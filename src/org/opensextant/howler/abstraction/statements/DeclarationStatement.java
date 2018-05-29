package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;

public class DeclarationStatement extends Statement {

  private boolean derived = false;
  private Word word;

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }

  public boolean isDerived() {
    return derived;
  }

  public void setDerived(boolean derived) {
    this.derived = derived;
  }

  public String toString() {
    return this.word.toString();
  }

  @Override
  public List<Word> getWords() {
    ArrayList<Word> wrds = new ArrayList<Word>();
    wrds.add(word);
    wrds.add(Vocabulary.IS_AUX);
    wrds.add(word.getWordType());
    return wrds;
  }

}
