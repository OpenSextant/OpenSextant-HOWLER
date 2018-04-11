package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;

public class PhraseSequence extends Statement {

  private List<Phrase> phrases = new ArrayList<Phrase>();

  public List<Phrase> getPhrases() {
    return phrases;
  }

  public void setPhrases(List<Phrase> phrases) {
    this.phrases = phrases;
  }

  public void addPhrase(Phrase phrase) {
    this.phrases.add(phrase);
  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
   for(Phrase p:this.phrases){
     wrds.addAll(p.getWords());
   }
    return wrds;
  }

}
