/*
 * **************************************************************************
 *					     NOTICE
 *
 *	This software was produced for the U. S. Government
 *	under Basic Contract No. W15P7T-13-C-A802, and is
 *	subject to the Rights in Noncommercial Computer Software
 *	and Noncommercial Computer Software Documentation
 *	Clause 252.227-7014 (FEB 2012)
 *
 *  2016 The MITRE Corporation. All Rights Reserved.
 *
 * **************************************************************************
 */
package org.opensextant.howler.lexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.ahocorasick.trie.Trie.TrieBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.apache.commons.io.FileUtils;
import org.opensextant.howler.grammar.HOWL;

import eu.danieldk.nlp.jitar.data.Model;
import eu.danieldk.nlp.jitar.languagemodel.LanguageModel;
import eu.danieldk.nlp.jitar.languagemodel.LinearInterpolationLM;
import eu.danieldk.nlp.jitar.tagger.HMMTagger;
import eu.danieldk.nlp.jitar.tagger.HMMTagger.Sequence;
import eu.danieldk.nlp.jitar.wordhandler.KnownWordHandler;
import eu.danieldk.nlp.jitar.wordhandler.SuffixWordHandler;
import eu.danieldk.nlp.jitar.wordhandler.WordHandler;

public class HowlLexer implements TokenSource {

  private CharStream input;
  private TokenFactory<?> factory = CommonTokenFactory.DEFAULT;

  // the finished fully tagged sentences
  private List<Token> taggedSentences = new ArrayList<Token>();

  // mapping between the tags and integer ID
  private Map<String, Integer> tokenTypeMap = new HashMap<String, Integer>();

  // phrase map <Category, Phrase>
  private Map<String, String> phraseMap = new HashMap<String, String>();

  // the part of speech tagger and its model
  private HMMTagger tagger;
  private Model model = null;

  // the phrase tagger
  private Trie phraser;

  public HowlLexer(File lexiconFile, File ngramFile, File phraseFile) {

    initTagMap();

    // intialize the part of speech tagger
    initTagger(lexiconFile, ngramFile);

    // initialize the phrase tagger
    initPhraser(phraseFile);

  }

  private void initTagMap() {

    // initialize the tag map

    for (int i = 0; i < HOWL.VOCABULARY.getMaxTokenType() + 1; i++) {
      String symbolicName = HOWL.VOCABULARY.getSymbolicName(i);
      if (symbolicName != null) {
        tokenTypeMap.put(symbolicName, i);
      }
    }

    tokenTypeMap.put("EOF", Token.EOF);
  }

  public void setInput(CharStream input) {

    this.input = input;

    // clean up
    taggedSentences.clear();

    // fetch the whole input document
    String doc = fetchAll();

    // do some cleanup and transformations
    String[] cleanSentences = this.clean(doc);

    // tag each sentence
    for (String sent : cleanSentences) {

      // find all the key phrases
      List<CommonToken> keyPhrases = this.matchedPhrases(sent);

      // tokenize
      List<CommonToken> sentence = this.tokenize(sent);

      // tag sentence with part of speech tags
      this.tag(sentence);

      // merge part of speech tags with key phrases
      List<CommonToken> mergedSentence = this.merge(keyPhrases, sentence);
      taggedSentences.addAll(mergedSentence);

    }

  }

  private void initPhraser(File phraseFile) {
    List<String> lines = null;
    try {
      lines = FileUtils.readLines(phraseFile);
      for (String line : lines) {
        String[] pieces = line.split("\t");

        String phraseType = pieces[0];
        String phrase = pieces[1];
        phraseMap.put(phrase, phraseType);

      }

    } catch (IOException e) {

      e.printStackTrace();
    }

    TrieBuilder builder = Trie.builder();
    builder.caseInsensitive().onlyWholeWords().removeOverlaps();

    for (String phrase : phraseMap.keySet()) {
      builder.addKeyword(phrase);
    }

    phraser = builder.build();

  }

  private List<CommonToken> merge(List<CommonToken> keyPhrases,
      List<CommonToken> posSentences) {

    if (keyPhrases.isEmpty()) {
      return posSentences;
    }

    ArrayList<CommonToken> mergedSentence = new ArrayList<CommonToken>();

    Iterator<CommonToken> phraseIter = keyPhrases.iterator();
    Iterator<CommonToken> tokenIter = posSentences.iterator();

    // get the first phrase
    CommonToken currentPhrase = phraseIter.next();

    // loop over tokens
    while (tokenIter.hasNext()) {

      CommonToken currentToken = tokenIter.next();
      int currentTokenStartIndex = currentToken.getStartIndex();

      // token and phrase start at same location
      if (currentPhrase.getStartIndex() == currentTokenStartIndex) {
        // add phrase to sentence
        mergedSentence.add(currentPhrase);

        int phraselength = currentPhrase.getText().split(" ").length;

        // eat the overlapping tokens
        for (int skip = 0; skip < phraselength - 1; skip++) {
          currentToken = tokenIter.next();
        }

        int currentTokenStopIndex = currentToken.getStopIndex();

        // skip any more tokens which cover phrase
        while (currentTokenStopIndex < currentPhrase.getStopIndex()) {
          // eat token, bump token start index
          currentToken = tokenIter.next();
          currentTokenStopIndex = currentToken.getStopIndex();
        }

        if (phraseIter.hasNext()) {
          currentPhrase = phraseIter.next();
        }

      } else {
        mergedSentence.add(currentToken);
      }

    } // end of token loop

    return mergedSentence;
  }

  private List<CommonToken> matchedPhrases(String document) {

    List<CommonToken> markedSentence = new ArrayList<CommonToken>();

    Collection<Emit> matches = phraser.parseText(document);

    for (Emit e : matches) {
      String frag = e.getKeyword();
      String phraseType = phraseMap.get(frag);
      Integer tagID = tokenTypeMap.get(phraseType);
      // create Token
      CommonToken tmpToken = new CommonToken(tagID, frag);
      tmpToken.setStartIndex(e.getStart());
      tmpToken.setStopIndex(e.getEnd() + 1);
      markedSentence.add(tmpToken);
    }

    return markedSentence;

  }

  private String fetchAll() {

    // drain the entire input stream into a StringBuilder
    StringBuilder sentBuilder = new StringBuilder();

    for (int n = 0; n < input.size(); n++) {
      char ch = (char) input.LA(1);
      sentBuilder.append(ch);
      input.consume();
    }

    String doc = sentBuilder.toString();

    return doc;
  }

  private List<CommonToken> tokenize(String doc) {

    int tokenStartIndex = 0;

    StringTokenizer st = new StringTokenizer(doc);

    List<CommonToken> sentence = new ArrayList<CommonToken>();
    int currentPosition = 0;
    while (st.hasMoreTokens()) {

      String tokenText = st.nextToken();
      tokenStartIndex = doc.indexOf(tokenText, currentPosition);

      CommonToken tmpToken = new CommonToken(-99, tokenText);
      tmpToken.setStartIndex(tokenStartIndex);
      int tokenEndIndex = tokenStartIndex + tokenText.length();
      currentPosition = tokenEndIndex;
      tmpToken.setStopIndex(tokenEndIndex);
      sentence.add(tmpToken);
    }

    return sentence;

  };

  private String[] clean(String doc) {
    doc = doc.replaceAll("'s", " 's").replaceAll("\\s+", " ")
        .replaceAll("\r+", "\n").replaceAll("\\.", " \\.\n")
        .replaceAll("\\?", " \\?\n").trim();

    String[] sentences = doc.split("[\n]+");

    return sentences;
  }

  private void tag(List<CommonToken> sentence) {

    List<String> stringTokens = new ArrayList<String>();

    for (Token t : sentence) {
      stringTokens.add(t.getText());
    }

    stringTokens.add(0, "<START>");
    stringTokens.add(0, "<START>");
    stringTokens.add("<END>");

    // Send the tokens to the tagger
    Sequence seq = HMMTagger
        .highestProbabilitySequence(tagger.viterbi(stringTokens), model);

    // get the part of speech tags from the sequence
    List<String> tags = seq.sequence();

    // convert tagged sentence to list of Tokens

    for (int i = 0; i < sentence.size(); i++) {

      String tag = tags.get(i + 2);
      // look up token ID
      Integer tagID = tokenTypeMap.get(tag);
      if (tagID == null) {
        System.err.println("Unknown token type:" + tag);
        tagID = 0;
      }

      sentence.get(i).setType(tagID);

    }

  }

  @Override
  public Token nextToken() {

    if (taggedSentences.isEmpty()) {
      return new CommonToken(Token.EOF);
    }

    // just pull and return next token from finshed sentences
    return taggedSentences.remove(0);

  }

  private void initTagger(File lexiconFile, File ngramFile) {

    // Load the model
    try {
      model = Model.readModel(
          new BufferedReader(
              new InputStreamReader(new FileInputStream(lexiconFile), "UTF-8")),
          new BufferedReader(
              new InputStreamReader(new FileInputStream(ngramFile), "UTF-8")));
    } catch (IOException e) {
      System.err.println("Unable to read the model!");
      e.printStackTrace();
    }

    // Set up word handlers. The suffix word handler is used as a fallback
    // to the known word handler.
    int maxSuffixLength = 3; // low long a suffix to use to guess unknown
    // words
    int maxTrainFreqNum = 5; // max freq for numerical words
    int maxTrainFreqUppercase = 100000000; // max freq for uppercase words
    int maxTrainFreqLowercase = 100000000; // max freq for lower case words
    SuffixWordHandler swh = new SuffixWordHandler(model.lexicon(),
        model.uniGrams(), maxSuffixLength, maxTrainFreqNum,
        maxTrainFreqUppercase, maxTrainFreqLowercase, 10);

    WordHandler wh = new KnownWordHandler(model.lexicon(), model.uniGrams(),
        swh);

    // Create an n-gram language model.
    LanguageModel lm = new LinearInterpolationLM(model.uniGrams(),
        model.biGrams(), model.triGrams());

    // Initialize a tagger with a beam of 1000.0.
    tagger = new HMMTagger(model, wh, lm, 1000.0);

  }

  @Override
  public int getLine() {
    // TODO track lines
    return -1;
  }

  @Override
  public int getCharPositionInLine() {
    // TODO track position
    return -1;
  }

  @Override
  public CharStream getInputStream() {
    return input;
  }

  @Override
  public String getSourceName() {
    return input.getSourceName();
  }

  @Override
  public void setTokenFactory(TokenFactory<?> factory) {
    this.factory = factory;
  }

  @Override
  public TokenFactory<?> getTokenFactory() {
    return factory;
  }

}
