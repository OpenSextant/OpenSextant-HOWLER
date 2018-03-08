package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class WordPhrase extends SubjectObjectPhrase {

  private Word head;

  public WordPhrase(Word head) {
    this.head = head;
  }

  public Word getHead() {
    return head;
  }

  public void setHead(Word head) {
    this.head = head;
  }

  @Override
  public String toString() {
    return "(" + this.getScope() +") " + head.toString();
  }

  @Override
  public boolean isObjectScope() {
    return false;
  }

  @Override
  public boolean isDataScope() {
    return false;
  }

  @Override
  public boolean isAnnotationScope() {
    return true;
  }

  @Override
  public Scope getScope() {
    return this.head.getScope();
  }

  @Override
  public boolean isConsistentScope() {
    return true;
  }

}
