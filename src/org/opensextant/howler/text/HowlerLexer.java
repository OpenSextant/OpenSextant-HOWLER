package org.opensextant.howler.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.ahocorasick.trie.Trie.TrieBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.io.FileUtils;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.text.grammar.HOWL;
import org.opensextant.howler.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.nlp.component.morph.english.EnglishMorphAnalyzer;
import edu.emory.mathcs.nlp.tokenization.EnglishTokenizer;
import eu.danieldk.nlp.jitar.data.Model;
import eu.danieldk.nlp.jitar.languagemodel.LanguageModel;
import eu.danieldk.nlp.jitar.languagemodel.LinearInterpolationLM;
import eu.danieldk.nlp.jitar.tagger.HMMTagger;
import eu.danieldk.nlp.jitar.tagger.HMMTagger.Sequence;
import eu.danieldk.nlp.jitar.wordhandler.KnownWordHandler;
import eu.danieldk.nlp.jitar.wordhandler.SuffixWordHandler;
import eu.danieldk.nlp.jitar.wordhandler.WordHandler;

public class HowlerLexer implements TokenSource {

  private static final Logger LOGGER = LoggerFactory.getLogger(HowlerLexer.class);

  // the text to be lexed
  private String input = "";
  // a stream that contains the text
  private CharStream stream = CharStreams.fromString("");

  // the final list of tokens to be parsed
  private final List<HowlerToken> tokens = new ArrayList<HowlerToken>();

  // index into tokens list
  private int tokenIndex = 0;
  // sentence index
  int sentIndex = 1;

  // where the tokens are created
  private TokenFactory<HowlerToken> tokenFactory = new HowlerTokenFactory();
  private String sourceName = "HOWLER Lexer";

  // the part of speech tagger and its model
  private HMMTagger tagger;
  private Model model = null;

  // the manage that handles all the Word creation and lookups
  private WordManager wm = WordManager.getWordManager();

  // the tokenizer
  private static EnglishTokenizer tokenizer = new EnglishTokenizer();
  private static EnglishMorphAnalyzer lemmatizer = new EnglishMorphAnalyzer();

  // Mapping between the POS tag and the token type name
  private Map<String, String> tokenTypeMap = new HashMap<String, String>();

  // mapping between the token type name and its integer ID
  private Map<String, Integer> tokenIDMap = new HashMap<String, Integer>();

  // mapping between a alternate surface forms of phrases and their normalized forms
  private Map<String, String> phraseNormalMap = new HashMap<String, String>();

  // fixed vocbulary and previously seen phrases to be considered a single token and their TokenType name
  Map<String, String> knownPhrases = new HashMap<String, String>();

  // the phrase tagger, used for finding multiword phrases
  private Trie phraser;

  private HowlerToken eofToken;

  private String quotedTextTypeName = "QUOTED_TEXT";

  public HowlerLexer(File lexiconFile, File ngramFile, File typeInfoFile, File phraseFile) {

    // initialize the mapping between token type names and token type IDs
    for (int i = 0; i < HOWL.VOCABULARY.getMaxTokenType() + 1; i++) {
      String tokenTypeName = HOWL.VOCABULARY.getSymbolicName(i);
      tokenIDMap.put(tokenTypeName, i);
    }

    // initialize the part of speech tagger
    initTagger(lexiconFile, ngramFile);
    // initialize the type mappings
    initTypeMap(typeInfoFile);
    // initialize the fixed phrase info
    initKnownPhraseMap(phraseFile);
    // initialize the phrase finder
    initPhraser();

  }

  public void setInput(String txt) {
    reset();
    input = clean(txt);
    stream = CharStreams.fromString(input);
    processInput();
  }

  private void reset() {
    tokens.clear();
    eofToken = null;
    tokenIndex = 0;
    sentIndex = 1;
  }

  // Do all the work to convert input text to List of HOWLERTokens
  private void processInput() {

    // tokenize, create HowlerToken, set text,start/stop indices
    List<HowlerToken> toks = tokenize(input);

    // merge quoted text into single token, set text,start/stop, tokenType= QUOTED_TEXT
    mergeQuotedString(toks, input);

    // merge dashed words into single token set text,start/stop
    mergeDashes(toks);

    // ensure that PERIODs are marked
    addStops(toks);

    // split tokens into sentences
    List<List<HowlerToken>> sentences = sentenceize(toks);

    for (List<HowlerToken> sentence : sentences) {

      matchKnownPhrases(sentence, input);

      // set POS for each token not already set
      posTag(sentence);

      // add the normal form to each token based on POS and surface form
      normalize(sentence);

      // set token type based on POS if not already set
      setTokenType(sentence);

      this.tokens.addAll(sentence);
    }

  }

  private void addStops(List<HowlerToken> tokens) {

    for (HowlerToken tok : tokens) {
      if (tok.getText().equals(".") || tok.getText().equals("..")) {
        tok.setType(HOWL.PERIOD);
        tok.setTokenTypeName("PERIOD");
        tok.setPos("PERIOD");
      }
    }
  }

  // some cleanup of input text
  private String clean(String input) {

    String cleanSurface = input;
    // split periods away from integers
    cleanSurface = cleanSurface.replaceAll("( [0-9]+)\\.([^0-9]|$)", "$1 .$2");

    // TODO HACK, tokenizer is not tokenizing some quoted phrases correctly
    // add space before unescaped quotes
    cleanSurface = cleanSurface.replaceAll("([^\\\\])\"", "$1 \"");
    cleanSurface = cleanSurface.replaceAll("\\+", " + ");

    // split some single token quantified things to multiple tokens
    cleanSurface = cleanSurface.replaceAll("(Any|Every|No|Some|any|every|no|some)(body|one|thing|where)", "$1 thing");

    if (!cleanSurface.equals(input)) {
      LOGGER.trace("Cleaned sentence:\t" + input + "\t" + cleanSurface);
    }

    return cleanSurface;
  }

  private List<HowlerToken> tokenize(String input) {

    List<HowlerToken> hTokens = new ArrayList<HowlerToken>();

    List<edu.emory.mathcs.nlp.tokenization.Token> toks = tokenizer.tokenize(input);

    for (edu.emory.mathcs.nlp.tokenization.Token tok : toks) {

      // create HOWLERToken based only on surface form
      int start = tok.getStartOffset();
      int stop = tok.getEndOffset() - 1;
      HowlerToken howlToken = tokenFactory.create(new Pair<TokenSource, CharStream>(this, getInputStream()), 0,
          tok.getWordForm(), Token.DEFAULT_CHANNEL, start, stop, getLine(), getCharPositionInLine());

      hTokens.add(howlToken);
    }

    return hTokens;
  }

  private void mergeQuotedString(List<HowlerToken> sentence, String txt) {

    List<Integer> quoteTokenIndices = containsQuote(sentence);

    if (quoteTokenIndices.isEmpty()) {
      return;
    }

    if (quoteTokenIndices.size() % 2 != 0) {
      LOGGER.debug("Ambigous Quotes in " + txt);
      int first = quoteTokenIndices.get(0);
      int last = quoteTokenIndices.get(quoteTokenIndices.size()-1);
      quoteTokenIndices.clear();
      quoteTokenIndices.add(first);
      quoteTokenIndices.add(last);
    }

    int shift = 0;
    int id = idForTokenTypeName(quotedTextTypeName);
    for (int p = 0; p < quoteTokenIndices.size(); p = p + 2) {

      int firstQuoteIndex = quoteTokenIndices.get(p) - shift;
      int lastQuoteIndex = quoteTokenIndices.get(p + 1) - shift;
      int firstCharIndex = sentence.get(firstQuoteIndex).getStartIndex();
      int lastCharIndex = sentence.get(lastQuoteIndex).getStopIndex();

      String quoteText = txt.substring(firstCharIndex + 1, lastCharIndex - 1);

      shift = shift + lastQuoteIndex - firstQuoteIndex;

      if (quoteText.isEmpty()) {
        LOGGER.warn("Unbalanced or empty Quotes?" + sentence);
        continue;
      }

      HowlerToken quoteToken = new HowlerToken(id, quoteText);
      quoteToken.setTokenTypeName(quotedTextTypeName);
      quoteToken.setText(quoteText);
      // quoteToken.setNormalForm(quoteText);
      quoteToken.setStartIndex(firstCharIndex);
      quoteToken.setStopIndex(lastCharIndex);

      // remove the tokens that have been merged
      for (int i = firstQuoteIndex; i <= lastQuoteIndex; i++) {
        sentence.remove(firstQuoteIndex);
      }
      // add the quoted text token
      sentence.add(firstQuoteIndex, quoteToken);
    }

  }

  private void mergeDashes(List<HowlerToken> sentence) {
    // token index pairs to be merged
    List<List<Integer>> pairs = new ArrayList<List<Integer>>();

    int i = 0;
    while (i < sentence.size() - 1) {
      List<Integer> pair = new ArrayList<Integer>();
      if (isDash(sentence.get(i))) {
        pair.add(i - 1);
        pair.add(i + 1);
        pairs.add(pair);
        i = i + 2;

        if (isDash(sentence.get(i))) {
          pair.remove(1);
          pair.add(i + 1);
        } else {
          pair = new ArrayList<Integer>();
        }

      }

      i++;
    }

    if (pairs.isEmpty()) {
      return;
    }

    int shift = 0;
    for (List<Integer> pair : pairs) {

      List<HowlerToken> seq = new ArrayList<HowlerToken>(
          sentence.subList(pair.get(0) - shift, pair.get(1) + 1 - shift));
      // merge tokens from pair(0) to pair(1)
      StringBuilder bldr = new StringBuilder();
      StringBuilder normBldr = new StringBuilder();

      for (HowlerToken tok : seq) {
        bldr.append(tok.getText());
        normBldr.append(tok.getText());
      }

      String dashText = bldr.toString().trim();
      HowlerToken dashToken = new HowlerToken(0, dashText);
      dashToken.setStartIndex(seq.get(0).getStartIndex());
      dashToken.setStopIndex(seq.get(seq.size() - 1).getStopIndex());
      sentence.subList(pair.get(0) - shift, pair.get(1) + 1 - shift).clear();
      sentence.add(pair.get(0) - shift, dashToken);
      shift = shift + pair.get(1) - pair.get(0);
    }

  }

  private void matchKnownPhrases(List<HowlerToken> tokens, String cleanString) {

    int first = tokens.get(0).getStartIndex();
    int last = tokens.get(tokens.size() - 1).getStopIndex() + 1;
    String cleanSentence = cleanString.substring(first, last);
 
    Collection<Emit> matches = phraser.parseText(cleanSentence);

    for (Emit e : matches) {

      int start = e.getStart() + first;
      int end = e.getEnd() + first;

      int tokenStartIndex = tokenAtStart(tokens, start);
      int tokenStopIndex = tokenAtStop(tokens, end);

      // match is not aligned to tokens
      if (tokenStartIndex == -1 || tokenStopIndex == -1) {
        LOGGER.trace("Overlapping phrase match:" + e + "\t" + cleanString);
        continue;
      }

      // match is exactly 1 token
      if (tokenStartIndex == tokenStopIndex) {
        HowlerToken tok = tokens.get(tokenStartIndex);
        String key = tok.getText().toLowerCase();
        if (this.knownPhrases.containsKey(key)) {
          String name = knownPhrases.get(key);
          tok.setTokenTypeName(name);
          tok.setType(this.idForTokenTypeName(name));
        }
        continue;
      }

      // create new token from phrase matched
      String txt = e.getKeyword();

      HowlerToken phraseToken = tokenFactory.create(new Pair<TokenSource, CharStream>(this, getInputStream()), 0, txt,
          Token.DEFAULT_CHANNEL, start, end, getLine(), getCharPositionInLine());

      if (this.knownPhrases.containsKey(txt.toLowerCase())) {
        String tokenTypeName = knownPhrases.get(txt.toLowerCase());
        Integer tID = this.idForTokenTypeName(tokenTypeName);

        phraseToken.setTokenTypeName(tokenTypeName);
        phraseToken.setType(tID);
      } else {
        LOGGER.error("Known phrase with no TokenType:" + txt + " " + cleanString);
        continue;
      }

      // remove merged tokens
      for (int i = tokenStartIndex; i < tokenStopIndex + 1; i++) {
        tokens.remove(tokenStartIndex);
      }

      // add phrase token
      tokens.add(tokenStartIndex, phraseToken);

    }

  }

  private List<List<HowlerToken>> sentenceize(List<HowlerToken> tokens) {

    List<List<HowlerToken>> sentences = new ArrayList<List<HowlerToken>>();

    List<HowlerToken> sentence = new ArrayList<HowlerToken>();
    for (HowlerToken tok : tokens) {
      sentIndex++;
      tok.setLine(sentIndex);

      if (isStop(tok)) {
        sentence.add(tok);
        sentences.add(sentence);
        sentence = new ArrayList<HowlerToken>();
      } else {
        sentence.add(tok);
      }

    }

    if (!sentence.isEmpty()) {
      LOGGER.warn("Sentence with no final period:" + tokens);

      int start = -1;
      if (tokens.size() > 0) {
        int previousStop = tokens.get(tokens.size() - 1).getStopIndex();
        if (previousStop != -1) {
          start = previousStop + 1;
        }
      }

      int stop = Math.max(-1, start - 1);
      HowlerToken period = tokenFactory.create(new Pair<TokenSource, CharStream>(this, getInputStream()), HOWL.PERIOD,
          "PERIOD", Token.DEFAULT_CHANNEL, start, stop, getLine(), getCharPositionInLine());
      period.setPos("PERIOD");
      sentence.add(period);
      sentences.add(sentence);
    }

    return sentences;
  }

  // add the part of speech tag and token type to each token
  private void posTag(List<HowlerToken> sentence) {

    // create list of surface forms for the pos tagger
    List<String> stringTokens = new ArrayList<String>();

    for (HowlerToken t : sentence) {
      stringTokens.add(t.getText());
    }

    // add the boundary markers
    stringTokens.add(0, "<START>");
    stringTokens.add(0, "<START>");
    stringTokens.add("<END>");

    // Tag the string tokens
    Sequence seq = HMMTagger.highestProbabilitySequence(tagger.viterbi(stringTokens), model);

    // get the part of speech tags from the sequence
    List<String> tags = seq.sequence();

    if (tags.size() != sentence.size() + 3) {
      LOGGER.error("Number of POS tags does not match number of input tokens:" + tags.size() + " " + sentence.size()
          + " " + sentence);
    }

    // set the POS tag and token type on each token
    for (int i = 0; i < sentence.size(); i++) {

      HowlerToken tok = sentence.get(i);
      String txt = sentence.get(i).getText();
      String pos = tags.get(i + 2);

      // has digits but not tagged as number
      if (containsDigits(txt) && !pos.equals("CD")) {
        // if not already tagged as noun
        if (!pos.startsWith("N")) {
          // does it look like an abbreviation?
          if (isAbbrev(txt)) {
            pos = "NP";
          } else {
            pos = "NN";
          }
        }

      }

      if (isURL(tok)) {
        pos = "NP";
      }

      // if not already set, set POS
      if (tok.getPos().isEmpty()) {
        tok.setPos(pos);
      }

    }
  }

  private void normalize(List<HowlerToken> sentence) {
    for (HowlerToken tok : sentence) {
      normalize(tok);
    }
  }

  private void normalize(HowlerToken token) {
    String surfaceForm = token.getText();
    String pos = token.getPos();


    
    // create normal form based on surface form and part of speech
    String normal = surfaceForm;

    if(!token.getTokenTypeName().isEmpty()){
      token.setNormalForm(normal);
      return;
    }
    
    
    if (pos.startsWith("BE")) {
      normal = "is";
    } else if (pos.startsWith("DO")) {
      normal = "does";
    } else if (pos.startsWith("HV")) {
      normal = "has";
    } else if (pos.startsWith("VB")) {

      String base = lemmatizer.lemmatize(surfaceForm, pos);

      // uninflected present tense
      if (pos.equals("VB")) {
        // normal = thirdSingularVerb(base);
      }
      // past tense
      if (pos.equals("VBD")) {
        // normal = thirdSingularVerb(base);
      }
      // present participle or gerund
      if (pos.equals("VBG")) {
        // normal = thirdSingularVerb(base);
      }

      // past participle
      if (pos.equals("VBN")) {
        // normal = thirdSingularVerb(base);
      }

      // present tense, 3rd person singular
      if (pos.equals("VBZ")) {

      }

    } else if (pos.startsWith("NN")) {
      normal = lemmatizer.lemmatize(surfaceForm, pos);
    } else if (pos.startsWith("NOT")) {
      normal = "not";
    } else if (pos.startsWith("CD")) {
      normal = TextUtils.convertNumber(surfaceForm);
    }

    if (phraseNormalMap.containsKey(surfaceForm.toLowerCase())) {
      normal = phraseNormalMap.get(surfaceForm.toLowerCase());
    }

    token.setNormalForm(normal);
    return;
  }

  private void setTokenType(List<HowlerToken> tokens) {
    for (HowlerToken tok : tokens) {
      setTokenType(tok);
    }
  }

  // determine and set the token type based on POS and content
  private void setTokenType(HowlerToken tok) {

    String pos = tok.getPos();

    // set token type name and ID

    // if already set e.g. already seen, quoted text ...
    if (!tok.getTokenTypeName().isEmpty()) {
      LOGGER.trace("Token Type name already set of token:" + tok + "\t" + tok.getTokenTypeName());
      return;
    } else {
      LOGGER.trace("Token not previously seen:" + tok);
    }

    String tokenTypeName = "BADWORD";

    // get the token type based on POS
    if (tokenTypeMap.containsKey(pos)) {
      tokenTypeName = tokenTypeMap.get(pos);
    } else {
      LOGGER.warn("No token type mapping for POS: " + pos + " " + tok);
    }

    // split integers and decimals numbers
    if (tokenTypeName.equals("NUMBER")) {
      if (tok.getNormalForm().matches("[0-9]+")) {
        tokenTypeName = "INTEGER";
      } else if (tok.getNormalForm().matches("-?[0-9]+\\.[0-9]+")) {
        tokenTypeName = "DECIMAL";
      } else {
        LOGGER.trace("Non-number tagged as number:" + tok);
        tokenTypeName = "COMMON_NOUN";
      }
    }

    Integer tID = this.idForTokenTypeName(tokenTypeName);

    tok.setTokenTypeName(tokenTypeName);
    tok.setType(tID);
    LOGGER.trace("\tToken type guessed:\t" + tok.getText() + "\t" + tok.getTokenTypeName() + "\t" + pos);
  }

  private int tokenAtStart(List<HowlerToken> tokens, int offset) {

    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).getStartIndex() == offset) {
        return i;
      }
    }

    return -1;
  }

  private int tokenAtStop(List<HowlerToken> tokens, int offset) {

    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).getStopIndex() == offset) {
        return i;
      }
    }

    return -1;
  }

  private List<Integer> containsQuote(List<HowlerToken> sentence) {
    ArrayList<Integer> quoteTokenIndices = new ArrayList<Integer>();

    for (int i = 0; i < sentence.size(); i++) {
      if (isQuoteChar(sentence.get(i))) {
        if (i - 1 >= 0 && !isEscape(sentence.get(i - 1))) {
          quoteTokenIndices.add(i);
        }
      }
    }
    return quoteTokenIndices;
  }

  // convert base verb form to 3rd person singular form
  private String thirdSingularVerb(String base) {

    String norm = base + "s";
    if (base.matches(".+(s|z|x|sh|ch|o)$")) {
      norm = base + "es";
    }
    if (base.matches(".+[b-d,f-h,j-n,p-t,v-x,z]y$")) {
      norm = base.substring(0, base.length() - 1) + "ies";
    }

    return norm;
  }

  @Override
  public Token nextToken() {

    if (tokenIndex >= tokens.size()) {
      if (eofToken == null) {
        int start = -1;
        if (tokens.size() > 0) {
          int previousStop = tokens.get(tokens.size() - 1).getStopIndex();
          if (previousStop != -1) {
            start = previousStop + 1;
          }
        }

        int stop = Math.max(-1, start - 1);
        eofToken = tokenFactory.create(new Pair<TokenSource, CharStream>(this, getInputStream()), HowlerToken.EOF,
            "EOF", Token.DEFAULT_CHANNEL, start, stop, getLine(), getCharPositionInLine());
      }

      return eofToken;
    }

    HowlerToken t = tokens.get(tokenIndex);
    if (tokenIndex == tokens.size() - 1 && t.getType() == HowlerToken.EOF) {
      eofToken = t;
    }

    tokenIndex++;
    return t;
  }

  @Override
  public int getLine() {
    return sentIndex;
    /*
     * if (tokenIndex < tokens.size()) { return tokens.get(tokenIndex).getLine(); } else if (eofToken != null) { return
     * eofToken.getLine(); } else if (tokens.size() > 0) { // have to calculate the result from the line/column of the
     * previous // token, along with the text of the token. HowlerToken lastToken = tokens.get(tokens.size() - 1); int
     * line = lastToken.getLine(); String tokenText = lastToken.getText(); if (tokenText != null) { for (int i = 0; i <
     * tokenText.length(); i++) { if (tokenText.charAt(i) == '\n') { line++; } } } // if no text is available, assume
     * the token did not contain any // newline characters. return line;
     */
    // }

    // only reach this if tokens is empty, meaning EOF occurs at the first
    // position in the input
    // return 1;
  }

  @Override
  public int getCharPositionInLine() {
    if (tokenIndex < tokens.size()) {
      return tokens.get(tokenIndex).getCharPositionInLine();
    } else if (eofToken != null) {
      return eofToken.getCharPositionInLine();
    } else if (tokens.size() > 0) {
      // have to calculate the result from the line/column of the previous
      // token, along with the text of the token.
      HowlerToken lastToken = tokens.get(tokens.size() - 1);
      String tokenText = lastToken.getText();
      if (tokenText != null) {
        int lastNewLine = tokenText.lastIndexOf('\n');
        if (lastNewLine >= 0) {
          return tokenText.length() - lastNewLine - 1;
        }
      }

      return lastToken.getCharPositionInLine() + lastToken.getStopIndex() - lastToken.getStartIndex() + 1;
    }

    // only reach this if tokens is empty, meaning EOF occurs at the first
    // position in the input
    return 0;
  }

  public String getInput() {
    return input;
  }

  @Override
  public CharStream getInputStream() {
    return this.stream;
  }

  @Override
  public String getSourceName() {
    return sourceName;
  }

  @Override
  public void setTokenFactory(TokenFactory<?> factory) {
    if (factory instanceof HowlerTokenFactory) {
      this.tokenFactory = (HowlerTokenFactory) factory;
    } else {
      LOGGER.error("Cannot use a non HOWLERTokenFactory. Using default HOWLERTokenFactory");
    }
  }

  @Override
  public TokenFactory<?> getTokenFactory() {
    return this.tokenFactory;
  }

  public List<HowlerToken> getTokens() {
    return tokens;
  }

  private void initTagger(File lexiconFile, File ngramFile) {
    // Load the model
    try {
      model = Model.readModel(new BufferedReader(new InputStreamReader(new FileInputStream(lexiconFile), "UTF-8")),
          new BufferedReader(new InputStreamReader(new FileInputStream(ngramFile), "UTF-8")));
    } catch (IOException e) {
      LOGGER.error(
          "Unable to read the model using Lexicon=" + lexiconFile + " NGrams=" + ngramFile + "" + e.getMessage());
      return;
    }

    // Set up word handlers. The suffix word handler is used as a fallback
    // to the known word handler.
    int maxSuffixLength = 3; // low long a suffix to use to guess unknown
    // words
    int maxTrainFreqNum = 5; // max freq for numerical words
    int maxTrainFreqUppercase = 100000000; // max freq for uppercase words
    int maxTrainFreqLowercase = 100000000; // max freq for lower case words
    SuffixWordHandler swh = new SuffixWordHandler(model.lexicon(), model.uniGrams(), maxSuffixLength, maxTrainFreqNum,
        maxTrainFreqUppercase, maxTrainFreqLowercase, 10);

    WordHandler wh = new KnownWordHandler(model.lexicon(), model.uniGrams(), swh);

    // Create an n-gram language model.
    LanguageModel lm = new LinearInterpolationLM(model.uniGrams(), model.biGrams(), model.triGrams());

    // Initialize a tagger with a beam of 1000.0.
    tagger = new HMMTagger(model, wh, lm, 1000.0);

  }

  // initial the mapping between the token's POS tag and the Lexer/Parser's tokenType name
  private void initTypeMap(File typeFile) {

    try {
      List<String> lines = FileUtils.readLines(typeFile);

      for (String line : lines) {
        if (line.startsWith("#")) {
          continue;
        }

        // POS tag \t Token Type name
        String[] pieces = line.split("\t");

        String posTag = pieces[0];
        String tokenTypeName = pieces[1];
        int id = this.idForTokenTypeName(tokenTypeName);

        if (id == 0) {
          LOGGER.error("POS mapped to unknown Lexer token type:" + posTag + "=>" + tokenTypeName);
        }

        tokenTypeMap.put(posTag, tokenTypeName);
      }

    } catch (IOException e) {
      LOGGER.error("Could not read phrase info file:" + typeFile);
    }

  }

  private void initKnownPhraseMap(File phraseFile) {

    // add all known phrases from the WordManager
    for (Word ph : wm.getWords()) {
      String norm = ph.getNormalForm();

      String tType = tokenTypeFromWord(ph);

      LOGGER
          .trace("Adding known phrase to lexer from \tWord Manager\t" + norm + "\t" + tType + "\t" + ph.getWordType());

      if (knownPhrases.containsKey(norm.toLowerCase())) {
        String existingType = knownPhrases.get(norm.toLowerCase());
        LOGGER.trace("Ambigous word from WordManager:" + ph + " replacing " + existingType);
      }

      knownPhrases.put(norm.toLowerCase(), tType);
    }

    try {
      List<String> lines = FileUtils.readLines(phraseFile, "UTF-8");

      for (String line : lines) {
        if (line.startsWith("#") || line.trim().isEmpty()) {
          continue;
        }

        // Phrase \t Alternate surface forms \t Token Type name
        String[] pieces = line.split("\t");

        String phrase = pieces[0].trim();
        String altForms = pieces[1].trim();
        String tokenTypeName = pieces[2].trim();

        // add the phrase to the known phrases map
        knownPhrases.put(phrase.toLowerCase(), tokenTypeName);
        LOGGER.trace("Adding known phrase to lexer from \tphrase file\t" + phrase + "\t" + tokenTypeName);

        String[] alts = altForms.split(",");

        // add the alt phrase to the known phrases map
        for (String alt : alts) {
          if (alt.isEmpty()) {
            continue;
          }
          knownPhrases.put(alt.toLowerCase(), tokenTypeName);
          LOGGER.trace("Adding known phrase to lexer from \talt phrase file\t" + alt + "\t" + tokenTypeName);
          phraseNormalMap.put(alt, phrase);
        }
      }

    } catch (IOException e) {
      LOGGER.error("Could not read phrase info file:" + phraseFile);
    }
  }

  public void initPhraser() {

    TrieBuilder builder = Trie.builder();
    builder.caseInsensitive().onlyWholeWords().removeOverlaps();

    // add all the multiword phrases to the phraser
    for (String phrase : knownPhrases.keySet()) {
      builder.addKeyword(phrase);
    }

    phraser = builder.build();

  }

  // add a known phrase to the lexer
  public void addKnownPhrase(Word ph, boolean init) {
    
    if(Vocabulary.isBuiltInVocabulary(ph)){
      LOGGER.warn("Attempt to redefine built in Word:" + ph);
      return;
    }
    
    String phraseKey = ph.getNormalForm().toLowerCase();
    if (!knownPhrases.containsKey(phraseKey)) {
      knownPhrases.put(phraseKey, tokenTypeFromWord(ph));
    } else {
      String existingType = knownPhrases.get(phraseKey);

      if (!existingType.equals(tokenTypeFromWord(ph)) && !existingType.equals("AMBIG_WORD")) {
        knownPhrases.put(phraseKey, "AMBIG_WORD");
        LOGGER.debug("Add ambigous word from text:" + phraseKey + " " + "AMBIG_WORD" + " replacing " + existingType);
      }
    }

    if (init) {
      initPhraser();
    }

  }

  private String tokenTypeFromWord(Word wrd) {

    WordType wType = wrd.getWordType();

    if (wrd instanceof Predicate) {
      Predicate pred = (Predicate) wrd;
      if (pred.isBuiltinPredicate()) {
        return pred.getPredicateType().toString();
      } else {
        return "PREDICATE";
      }
    }

    if (wType.equals(WordType.GENERIC_WORD)) {
      return wrd.getPOS();
    }

    if (wType.equals(WordType.PREDICATE_CHARACTERISTIC)) {
      return wType.toString();
    }

    if (wType.equals(WordType.WORD_TYPE)) {
      return wType.toString();
    }

    if (wType.equals(WordType.DATA_FACET)) {
      return wType.toString();
    }

    if (wType.isEnumerated()) {
      return wrd.getLogicalForm();
    }

    return wType.toString();
  }

  private boolean isStop(HowlerToken tok) {
    return tok.getTokenTypeName().equals("PERIOD");
  }

  private boolean isDash(HowlerToken tok) {
    return !tok.getTokenTypeName().equals(quotedTextTypeName) && tok.getText().trim().matches("[-\\/\\+]");
  }

  private boolean isQuoteChar(HowlerToken tok) {
    return tok.getText().trim().equals("\"");
  }

  private boolean isEscape(HowlerToken tok) {
    return tok.getText().trim().endsWith("\\");
  }

  private boolean isURL(HowlerToken tok) {
    return tok.getText().trim().startsWith("http:");
  }

  private int idForTokenTypeName(String name) {
    if (tokenIDMap.containsKey(name)) {
      return tokenIDMap.get(name);
    } else {
      LOGGER.warn("No token ID mapping for token name: " + name);
      return 0;
    }
  }

  private boolean containsDigits(CharSequence cs) {
    if (cs == null) {
      return false;
    }
    final int sz = cs.length();
    for (int i = 0; i < sz; i++) {
      if (Character.isDigit(cs.charAt(i))) {
        return true;
      }
    }
    return false;
  }

  private boolean isAbbrev(CharSequence cs) {
    if (cs == null || cs.length() < 3) {
      return false;
    }

    final int sz = Math.min(cs.length(), 3);
    for (int i = 0; i < sz; i++) {
      if (!Character.isUpperCase(cs.charAt(i))) {
        return false;
      }
    }
    return true;
  }

}
