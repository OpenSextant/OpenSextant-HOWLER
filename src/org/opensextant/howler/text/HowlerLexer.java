package org.opensextant.howler.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.ahocorasick.trie.Trie.TrieBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.io.FileUtils;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.text.grammar.HOWL;
import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.nlp.component.morph.english.EnglishMorphAnalyzer;
import edu.emory.mathcs.nlp.tokenization.EnglishTokenizer;
import edu.emory.mathcs.nlp.tokenization.Tokenizer;
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

  private String input = "";

  private final List<HOWLERToken> tokens = new ArrayList<HOWLERToken>();
  // index into tokens list
  private int i = 0;

  private TokenFactory<HOWLERToken> tokenFactory = new HOWLERTokenFactory();
  private String sourceName = "HOWLER LIST";

  // the part of speech tagger and its model
  private HMMTagger tagger;
  private Model model = null;

  private IRI currentNamespace = IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument");

  private WordManager wm = WordManager.getWordManager();

  // the tokenizer
  private static Tokenizer tokenizer = new EnglishTokenizer();
  private static EnglishMorphAnalyzer lemmatizer = new EnglishMorphAnalyzer();

  // Mapping between the POS tag and the token type name
  private Map<String, String> tokenTypeMap = new HashMap<String, String>();

  // mapping between a phrase and the token type name
  private Map<String, String> phraseTypeMap = new HashMap<String, String>();

  // mapping between the token type name and its integer ID
  private Map<String, Integer> tokenIDMap = new HashMap<String, Integer>();

  // mapping between a alternate surface forms of phrases and their normalized forms
  private Map<String, String> phraseNormalMap = new HashMap<String, String>();

  // the set of multiword phrases to be considered a single token
  Set<String> multiphrases = new HashSet<String>();

  // the phrase tagger, used for finding multiword phrases
  private Trie phraser;

  private HOWLERToken eofToken;

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
    initPhraseMap(phraseFile);
    // initialize the phrase finder
    initPhraser();

  }

  private void initPhraser() {

    TrieBuilder builder = Trie.builder();
    builder.caseInsensitive().onlyWholeWords().removeOverlaps();

    // add all the multiword phrases to the phraser
    for (String phrase : multiphrases) {
      builder.addKeyword(phrase);
    }

    phraser = builder.build();

  }

  public void setInput(String input) {
    reset();
    this.input = input;
    processInput();
  }

  private void reset() {
    tokens.clear();
    eofToken = null;
    i = 0;
  }

  // Do all the work to convert input text to List of HOWLERTokens
  private void processInput() {

    // normalize whitespace and join multiword phrases
    String cleanInput = clean(input);

    // tokenize and sentence-ize the input
    List<List<HOWLERToken>> sentences = tokenize(cleanInput);

    for (List<HOWLERToken> sentence : sentences) {

      // run each sentence through part-of-speech tagger
      posTag(sentence);

      // add the normal form to each token
      normalize(sentence);

      // adjust the POS for multiword phrases based on normal form
      adjustPOS(sentence);

      // add the various bits of type info to token
      addTypeInfo(sentence);

      // merge a quoted string into a single token
      mergeQuotedString(sentence);

      this.tokens.addAll(sentence);
    }

  }

  // tokenize and split into sentences
  public List<List<HOWLERToken>> tokenize(String input) {

    List<List<HOWLERToken>> sentences = new ArrayList<List<HOWLERToken>>();

    List<List<edu.emory.mathcs.nlp.tokenization.Token>> segs = tokenizer.segmentize(input);

    int sentIndex = 0;
    for (List<edu.emory.mathcs.nlp.tokenization.Token> seg : segs) {
      sentIndex++;
      List<HOWLERToken> sentence = new ArrayList<HOWLERToken>();
      for (edu.emory.mathcs.nlp.tokenization.Token tok : seg) {

        // create HOWLERToken based only on surface form
        HOWLERToken howlToken = tokenFactory.create(0, tok.getWordForm().replaceAll("_", " "));
        howlToken.setStartIndex(tok.getStartOffset());
        howlToken.setStopIndex(tok.getEndOffset());
        howlToken.setLine(sentIndex);

        sentence.add(howlToken);

      }
      sentences.add(sentence);
      sentence = new ArrayList<HOWLERToken>();
    }

    return sentences;
  }

  private void mergeQuotedString(List<HOWLERToken> sentence) {

    List<Integer> qs = containsQuote(sentence);

    if (qs.isEmpty()) {
      return;
    }

    if (qs.size() % 2 != 0) {
      LOGGER.warn("Ambigous Quotes in " + sentence);
    }

    int shift = 0;

    for (int p = 0; p < qs.size(); p = p + 2) {

      int firstQuote = qs.get(p) - shift;
      int lastQuote = qs.get(p + 1) - shift;
      shift = shift + lastQuote - firstQuote;

      List<HOWLERToken> quoteTokens = sentence.subList(firstQuote + 1, lastQuote);

      StringBuilder bldr = new StringBuilder();
      for (HOWLERToken tok : quoteTokens) {
        bldr.append(tok.getText());
        bldr.append(" ");
      }
      String qText = bldr.toString().trim();

      int id = tokenIDMap.get("QUOTED_TEXT");
      HOWLERToken quoteToken = new HOWLERToken(id, qText);
      quoteToken.setTokenTypeName("QUOTED_TEXT");
      quoteToken.setPos("QUOTED TEXT");
      quoteToken.setNormalForm(qText);
      quoteToken.setStartIndex(quoteTokens.get(0).getStartIndex());
      quoteToken.setStopIndex(quoteTokens.get(quoteTokens.size() - 1).getStopIndex());

      for (int i = firstQuote; i <= lastQuote; i++) {
        sentence.remove(firstQuote);
      }

      sentence.add(firstQuote, quoteToken);

    }

  }

  private List<Integer> containsQuote(List<HOWLERToken> sentence) {

    ArrayList<Integer> qs = new ArrayList<Integer>();

    for (int i = 0; i < sentence.size(); i++) {
      boolean q = sentence.get(i).getTokenTypeName().equals("QUOTE");

      if (q) {
        qs.add(i);
      }

    }

    return qs;
  }

  // some cleanup and joining multitoken phrases with underbars
  private String clean(String input) {

    String orig = input;
    // split periods away from integers at end of sentence
    String cleanSurface = input.replaceAll("( [0-9]+)\\.([^0-9]|$)", "$1 .$2");

    // normalize whitespace
    cleanSurface = cleanSurface.replaceAll("[\\s]+", " ").trim();

    // split some single token quantified things to multiple tokens
    cleanSurface = cleanSurface.replaceAll("(Any|Every|No|Some|any|every|no|some)(body|one|thing|where)", "$1 thing");

    // join multiword phrases with underbars
    Collection<Emit> matches = phraser.parseText(cleanSurface);

    for (Emit e : matches) {
      int start = e.getStart();
      int end = e.getEnd();
      String before = cleanSurface.substring(0, start);
      String mid = cleanSurface.substring(start, end + 1).replaceAll(" ", "_");
      String after = cleanSurface.substring(end + 1);
      cleanSurface = before + mid + after;
    }

    if (!cleanSurface.equals(orig)) {
      LOGGER.info("Cleaned sentence" + orig + "=>" + cleanSurface);
    }

    return cleanSurface;
  }

  // add the part of speech tag to each token
  private void posTag(List<HOWLERToken> sentence) {

    // create list of surface forms for the pos tagger
    List<String> stringTokens = new ArrayList<String>();

    for (HOWLERToken t : sentence) {
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

    // set the POS tag
    for (int i = 0; i < sentence.size(); i++) {
      HOWLERToken tok = sentence.get(i);
      String pos = tags.get(i + 2);
      tok.setPos(pos);
    }

  }

  private void normalize(List<HOWLERToken> sentence) {

    for (HOWLERToken tok : sentence) {
      String surfaceForm = tok.getText();
      String pos = tok.getPos();

      // get normal form based on surface form and part of speech
      String normal = surfaceForm;

      if (pos.startsWith("BE")) {
        normal = "is";
      } else if (pos.startsWith("DO")) {
        normal = "does";
      } else if (pos.startsWith("HV")) {
        normal = "has";
      } else if (pos.startsWith("VB")) {
        String base = lemmatizer.lemmatize(surfaceForm, pos);
        normal = thirdSingularVerb(base);
      } else if (pos.startsWith("NN")) {
        normal = lemmatizer.lemmatize(surfaceForm, pos);
      }

      if (phraseNormalMap.containsKey(surfaceForm.toLowerCase())) {
        normal = phraseNormalMap.get(surfaceForm.toLowerCase());
      }

      tok.setNormalForm(normal);
    }
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

  private void adjustPOS(List<HOWLERToken> sentence) {

    for (HOWLERToken tok : sentence) {
      String normal = tok.getNormalForm();
      if (phraseTypeMap.containsKey(normal)) {
        tok.setPos(phraseTypeMap.get(normal));
      }

    }

  }

  // add the token and word type info
  private void addTypeInfo(List<HOWLERToken> sentence) {

    for (HOWLERToken tok : sentence) {
      String pos = tok.getPos();

      // get the lexer/parser token type based on pos
      String tokenTypeName = tokenTypeMap.get(pos);

      // split integers and decimals numbers
      if (tokenTypeName.equals("NUMBER")) {
        if (tok.getText().matches("[0-9]+")) {
          tokenTypeName = "INTEGER";
        } else {
          tokenTypeName = "DECIMAL";
        }
      }

      Integer ttype = tokenIDMap.get(tokenTypeName);

      if (ttype == null) {
        LOGGER.error("Lexer does not have mapping for POS=" + pos);
        tokenTypeName = "BAD";
        ttype = tokenIDMap.get(tokenTypeName);
      }

      tok.setType(ttype);
      tok.setTokenTypeName(tokenTypeName);
    }

  }

  public List<HOWLERToken> tokenizeFlat(String input) {

    ArrayList<HOWLERToken> toks = new ArrayList<HOWLERToken>();

    String clean = clean(input);

    List<List<HOWLERToken>> sentences = tokenize(clean);

    for (List<HOWLERToken> sent : sentences) {

      toks.addAll(sent);

    }

    return toks;
  }

  @Override
  public Token nextToken() {

    if (i >= tokens.size()) {
      if (eofToken == null) {
        int start = -1;
        if (tokens.size() > 0) {
          int previousStop = tokens.get(tokens.size() - 1).getStopIndex();
          if (previousStop != -1) {
            start = previousStop + 1;
          }
        }

        int stop = Math.max(-1, start - 1);
        eofToken = tokenFactory.create(new Pair<TokenSource, CharStream>(this, getInputStream()), HOWLERToken.EOF,
            "EOF", Token.DEFAULT_CHANNEL, start, stop, getLine(), getCharPositionInLine());
      }

      return eofToken;
    }

    HOWLERToken t = tokens.get(i);
    if (i == tokens.size() - 1 && t.getType() == HOWLERToken.EOF) {
      eofToken = t;
    }

    i++;
    return t;
  }

  @Override
  public int getLine() {
    if (i < tokens.size()) {
      return tokens.get(i).getLine();
    } else if (eofToken != null) {
      return eofToken.getLine();
    } else if (tokens.size() > 0) {
      // have to calculate the result from the line/column of the previous
      // token, along with the text of the token.
      HOWLERToken lastToken = tokens.get(tokens.size() - 1);
      int line = lastToken.getLine();

      String tokenText = lastToken.getText();
      if (tokenText != null) {
        for (int i = 0; i < tokenText.length(); i++) {
          if (tokenText.charAt(i) == '\n') {
            line++;
          }
        }
      }

      // if no text is available, assume the token did not contain any
      // newline characters.
      return line;
    }

    // only reach this if tokens is empty, meaning EOF occurs at the first
    // position in the input
    return 1;
  }

  @Override
  public int getCharPositionInLine() {
    if (i < tokens.size()) {
      return tokens.get(i).getCharPositionInLine();
    } else if (eofToken != null) {
      return eofToken.getCharPositionInLine();
    } else if (tokens.size() > 0) {
      // have to calculate the result from the line/column of the previous
      // token, along with the text of the token.
      HOWLERToken lastToken = tokens.get(tokens.size() - 1);
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
    if (i < tokens.size()) {
      return tokens.get(i).getInputStream();
    } else if (eofToken != null) {
      return eofToken.getInputStream();
    } else if (tokens.size() > 0) {
      return tokens.get(tokens.size() - 1).getInputStream();
    }

    // no input stream information is available
    return null;
  }

  @Override
  public String getSourceName() {
    return sourceName;
  }

  @Override
  public void setTokenFactory(TokenFactory<?> factory) {
    if (factory instanceof HOWLERTokenFactory) {
      this.tokenFactory = (HOWLERTokenFactory) factory;
    } else {
      LOGGER.error("Cannot use a non HOWLERTokenFactory. Using default HOWLERTokenFactory");
    }
  }

  @Override
  public TokenFactory<?> getTokenFactory() {
    return this.tokenFactory;
  }

  public List<HOWLERToken> getTokens() {
    return tokens;
  }

  public IRI getCurrentNamespace() {
    return currentNamespace;
  }

  public void setCurrentNamespace(IRI currentNamespace) {
    this.currentNamespace = currentNamespace;
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
        Integer id = tokenIDMap.get(tokenTypeName);

        if (id == null) {
          LOGGER.error("POS mapped to unknown Lexer token type:" + posTag + "=>" + tokenTypeName);
          id = 0;
        }

        tokenTypeMap.put(posTag, tokenTypeName);
      }

    } catch (IOException e) {
      LOGGER.error("Could not read phrase info file:" + typeFile);
    }

  }

  private void initPhraseMap(File phraseFile) {

    try {
      List<String> lines = FileUtils.readLines(phraseFile);

      for (String line : lines) {
        if (line.startsWith("#") || line.trim().isEmpty()) {
          continue;
        }

        // Phrase \t Alternate surface forms \t Token Type name
        String[] pieces = line.split("\t");

        String phrase = pieces[0];
        String altForms = pieces[1];
        String tokenTypeName = pieces[2];

        String[] alts = altForms.split(",");

        // every phrase is its own normal
        phraseNormalMap.put(phrase, phrase);

        // normalize each alternative to the phrase
        for (String alt : alts) {
          if (!alt.trim().isEmpty()) {
            phraseNormalMap.put(alt.trim(), phrase);

            // add the alternative phrase to multiphrase
            if (alt.trim().contains(" ") || phrase.contains("[")) {
              multiphrases.add(alt.trim().replaceAll("\\s+", " "));
            }

          }
        }

        // if a multiword phrase, add multiword phrases to multilist
        if (phrase.contains(" ")) {
          multiphrases.add(phrase.replaceAll("\\s+", " "));
        }

        phraseTypeMap.put(phrase, tokenTypeName);
        tokenTypeMap.put(tokenTypeName, tokenTypeName);
      }

      // add all multiword phrases known to the Word Manager
      for (String ph : wm.getMultiWordPhrases()) {
        LOGGER.info("Adding multiword phrase to lexer from word manager" + ph);
        multiphrases.add(ph.replaceAll("\\s+", " "));
      }

    } catch (IOException e) {
      LOGGER.error("Could not read phrase info file:" + phraseFile);
    }
  }

  // dump a report of all the type info
  public List<TypeInfo> generateTypeReport(File lexiconFile, File reportFile) {

    List<TypeInfo> typeReport = new ArrayList<TypeInfo>();

    Set<String> posTags = new HashSet<String>();
    Set<String> tokTypes = new HashSet<String>(tokenIDMap.keySet());
    tokTypes.remove(null);

    try {

      // read the lexicon file to get all possible POS tags
      for (String line : FileUtils.readLines(lexiconFile, "UTF-8")) {
        String[] pieces = line.split(" ");
        if (pieces.length > 2) {
          for (int i = 1; i < pieces.length; i = i + 2) {
            String tag = pieces[i];
            posTags.add(tag);
          }
        } else {
          LOGGER.error("Malformed line in lexicon file:" + line);
        }
      }

      // for all POS tags, find the token type it is mapped to
      for (String tag : posTags) {
        TypeInfo typeInfo = new TypeInfo(tag, "POS", tokenTypeMap.get(tag));
        tokTypes.remove(tokenTypeMap.get(tag));
        typeReport.add(typeInfo);
      }

      // for all phrases, find the token type it is mapped to
      for (String phrase : phraseTypeMap.keySet()) {
        TypeInfo typeInfo = new TypeInfo(phrase, "PHRASE", phraseTypeMap.get(phrase));
        tokTypes.remove(tokenTypeMap.get(phraseTypeMap.get(phrase)));
        typeReport.add(typeInfo);
      }

      // see if there any token types which have no POS tag or phrase mapping
      for (String tokType : tokTypes) {
        TypeInfo typeInfo = new TypeInfo("", "Nothing mapped to this Token Type", tokType);
        typeReport.add(typeInfo);
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (reportFile != null) {
      try {
        FileUtils.writeStringToFile(reportFile, "POS tag or Phrase\tElementType\tTokenType\tWordType\n", false);

        for (TypeInfo info : typeReport) {
          FileUtils.writeStringToFile(reportFile, info.toString() + "\n", true);
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return typeReport;

  }

}
