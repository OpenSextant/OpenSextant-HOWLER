package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.DataType.DataTypeCategory;
import org.opensextant.howler.abstraction.words.DataValue;

public class Sentence {

  public enum SentenceType {
    DECLARATION, DESCRIPTION, FACT, PREDICATE_RELATION, PREDICATE_CHARACTERISTIC, ERROR
  };

  private List<Word> words = new ArrayList<Word>();
  private List<TextFootnote> textFootnotes = new ArrayList<TextFootnote>();

  private SentenceType sentenceType = SentenceType.ERROR;

  private String parseTree = "";

  public Sentence() {
  }

  public List<Word> getWords() {
    return words;
  }

  public void addWord(Word wrd) {
    this.words.add(wrd);
  }

  public void addWords(List<Word> wrds) {
    this.words.addAll(wrds);
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  public String getContents() {
    return this.toString();
  }

  public List<TextFootnote> getFootnotes() {
    return textFootnotes;
  }

  public void addFootnote(TextFootnote textFootnote) {
    this.textFootnotes.add(textFootnote);
  }

  public void setFootnotes(List<TextFootnote> textFootnotes) {
    this.textFootnotes = textFootnotes;
  }

  public SentenceType getSentenceType() {
    return sentenceType;
  }

  public void setSentenceType(SentenceType sentenceType) {
    this.sentenceType = sentenceType;
  }

  public void setParseTree(String parseTree) {
    this.parseTree = parseTree;
  }

  public String getParseTree() {
    return parseTree;
  }

  public String toString() {
    StringBuilder bldr = new StringBuilder();

    if (!words.isEmpty()) {

      Word first = words.get(0);
      bldr.append(initUpper(first.getNormalForm()));
      bldr.append(" ");

      for (int i = 1; i < words.size(); i++) {
        Word w = words.get(i);
        if (w != null) {
          String norm = w.getNormalForm();
          if (w instanceof DataValue) {
            DataValue dv = (DataValue) w;
            if (!dv.getDatatype().getCategory().equals(DataTypeCategory.NUMERIC)) {
              // escape quotes
              String cleanNorm = w.getNormalForm().replace("\"", "\\\"");
              norm = "\"" + cleanNorm + "\"";
            }
          }
          bldr.append(norm);
          bldr.append(" ");
        }
      }
    }

    return bldr.toString().replaceAll("[\n\r]", " ");
  }

  private String initUpper(String norm) {
    StringBuilder bldr = new StringBuilder();

    if (norm == null || norm.isEmpty()) {
      return "";
    }

    if (norm.length() == 1) {
      bldr.append(Character.toUpperCase(norm.charAt(0)));
    } else {
      bldr.append(Character.toUpperCase(norm.charAt(0)) + norm.substring(1));
    }

    return bldr.toString();
  }

}
