package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Instance;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class InstancePhrase<T extends Instance> extends SubjectObjectPhrase {

  private T head;

  public InstancePhrase(T head) {
    this.head = head;
  }

  public T getHead() {
    return head;
  }

  public void setHead(T head) {
    this.head = head;
  }

  @Override
  public String toString() {
    return "(" + this.getScope() +") " + head.toString();
  }

  public boolean isObjectScope() {
    return head instanceof ProperNoun;
  }

  public boolean isDataScope() {
    return head instanceof DataValue;
  }

  @Override
  public boolean isConsistentScope() {
    return true;
  }

  @Override
  public Scope getScope() {
    return this.head.getScope();
  }

  @Override
  public boolean isAnnotationScope() {
    return false;
  }

}
