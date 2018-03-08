package org.opensextant.howler.abstraction;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.phrases.Footnote;

public class Statement {

  private List<Footnote> footnotes = new ArrayList<Footnote>();

  public List<Footnote> getFootnotes() {
    return footnotes;
  }

  public void setFootnotes(List<Footnote> footnotes) {
    this.footnotes = footnotes;
  }

  public void addFootnote(Footnote footnote) {
    this.footnotes.add(footnote);
  }

  public boolean isDataStatement() {
    return false;
  }

  public boolean isObjectStatement() {
    return false;
  }

  public boolean isAnnotationStatement() {
    return false;
  }

  public List<Word> getWords() {
    return new ArrayList<Word>();
  }

}
