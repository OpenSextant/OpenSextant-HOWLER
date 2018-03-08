package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Statement;

public class PhraseSequence extends Statement {

  private List<Phrase> phrases = new ArrayList<Phrase>();

  public List<Phrase> getPhrases() {
    return phrases;
  }

  public void setPhrases(List<Phrase> phrases) {
    this.phrases = phrases;
  }

  public void addPhrases(Phrase phrase) {
    this.phrases.add(phrase);
  }

}
