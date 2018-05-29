package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.BadWord;

public class WordSequence extends Statement {

  private List<Word> words = new ArrayList<Word>();

  public boolean isBad() {
    for (Word w : words) {
      if (w instanceof BadWord) {
        return true;
      }
    }
    return false;
  }

  public List<Word> getWords() {
    return words;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  public void addWords(List<Word> words) {
    this.words.addAll(words);
  }
  
  public void addWord(Word word) {
    this.words.add(word);
  }

}
