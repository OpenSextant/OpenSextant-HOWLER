package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.semanticweb.owlapi.model.IRI;

public class TextDocument {

  private String title = "New Document";
  private String shortName = ":";
  private IRI id = IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument");

  private List<Word> words = new ArrayList<Word>();
  private List<Sentence> sentences = new ArrayList<Sentence>();
  private List<Word> vocabulary = new ArrayList<Word>();
  private List<TextFootnote> textFootnotes = new ArrayList<TextFootnote>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public IRI getId() {
    return id;
  }

  public void setId(IRI id) {
    this.id = id;
  }

  public List<Word> getWords() {
    return words;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  public void addWord(Word wordBase) {
    this.words.add(wordBase);
  }

  public List<Sentence> getSentences() {
    return sentences;
  }

  public void setSentences(List<Sentence> sentences) {
    this.sentences = sentences;
  }

  public void addSentence(Sentence sentence) {
    this.sentences.add(sentence);
  }

  public List<Word> getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(List<Word> vocabulary) {
    this.vocabulary = vocabulary;
  }

  public void addVocabulary(Word word) {
    this.vocabulary.add(word);
  }

  public List<TextFootnote> getTextFootnotes() {
    return textFootnotes;
  }

  public void setTextFootnotes(List<TextFootnote> textFootnotes) {
    this.textFootnotes = textFootnotes;
  }

  public void footnote(TextFootnote footnote) {
    this.textFootnotes.add(footnote);
  }

  public String toString() {
    return title + ":" + sentences;
  }

}
