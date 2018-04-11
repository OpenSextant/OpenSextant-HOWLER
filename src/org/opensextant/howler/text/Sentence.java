package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Word;

public class Sentence {

  private List<Word> words = new ArrayList<Word>();
  private List<TextFootnote> textFootnotes = new ArrayList<TextFootnote>();

  public Sentence() {
  }

  public List<Word> getWords() {
    return words;
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

  public void setFootnotes(List<TextFootnote> textFootnotes) {
    this.textFootnotes = textFootnotes;
  }

  public String toString() {
    StringBuilder bldr = new StringBuilder();

    for (Word w : this.words) {
      if (w != null) {
        bldr.append(w.getNormalForm());
        bldr.append(" ");
      }
    }

    return bldr.toString();
  }

}
