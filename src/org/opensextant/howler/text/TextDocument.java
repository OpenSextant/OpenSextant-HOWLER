package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
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
    return toString(FileStructure.DOCUMENT_PER_LINE, false);
  }

  public String toString(FileStructure format, boolean hdrs) {

    StringBuilder bldr = new StringBuilder();
    String delim = "\n";

    if (format.equals(FileStructure.DOCUMENT_PER_LINE)) {
      delim = "\n";
    }

    if (format.equals(FileStructure.SINGLE_BLOCK)) {
      delim = " ";
    }

    if (format.equals(FileStructure.MULTI_BLOCK)) {
      delim = "\n\n\n";
    }

    for (SentenceType typ : SentenceType.values()) {

      if (hdrs) {
        bldr.append("#\n");
        bldr.append("# " + typ.toString() + " Statements" + "\n");
        bldr.append("#------------\n");
      }
      for (Sentence s : this.sentences) {
        if (s.getSentenceType().equals(typ)) {
          if (format.equals(FileStructure.DOCUMENT_PER_LINE)) {
            bldr.append(s.toString().replaceAll("\n", " "));
          } else {
            bldr.append(s.toString());
          }
          bldr.append(delim);
        }
      }

    }

    return bldr.toString();
  }

}
