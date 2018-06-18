package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.text.Sentence.SentenceType;
import org.semanticweb.owlapi.model.IRI;

public class TextDocument {

  private String title = "New Document";
  private String shortName = ":";
  private IRI id = IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument");

  private List<Word> words = new ArrayList<Word>();
  private List<Sentence> sentences = new ArrayList<Sentence>();
  private Set<Word> vocabulary = new HashSet<Word>();
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

  public Set<Word> getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(Set<Word> vocabulary) {
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
    StringBuilder bldr = new StringBuilder();

    for (Sentence s : this.sentences) {
      if (s.getSentenceType().equals(SentenceType.DECLARATION)) {
        bldr.append(s.toString());
        bldr.append("\n\n\n");
      }
    }

    for (Sentence s : this.sentences) {
      if (!s.getSentenceType().equals(SentenceType.DECLARATION)) {
        bldr.append(s.toString());
        bldr.append("\n\n\n");
      }
    }

    return bldr.toString();
  }

}
