package org.opensextant.howler.abstraction;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.phrases.Footnote;

/**
 * Statement represents a complete "thought", a sentence.
 * <p>
 * A statements represents the basic pattern of a subject plus a predicate-object with the various types of Statements
 * differing by the type of subject, predicates and objects. Statements come in three Scopes (Object,Data and
 * Annotation) and three "flavors" (Description, Fact and PredicateRelation).
 */
public class Statement {

  // coments about this statements
  private List<Footnote> footnotes = new ArrayList<Footnote>();

  // for debugging, fromText = parse tree, FromOWL= axioms
  private String source = "";

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

  public String getSource() {
    return source;
  }

  public void setSource(String src) {
    this.source = src;
  }

}
