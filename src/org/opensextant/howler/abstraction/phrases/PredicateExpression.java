package org.opensextant.howler.abstraction.phrases;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class PredicateExpression<T extends Predicate> {

  T predicate;
  private boolean negative = false;
  private boolean passive = false;

  public PredicateExpression() {
  }

  public PredicateExpression(T pred) {
    this.predicate = pred;
  }

  public T getPredicate() {
    return predicate;
  }

  public void setPredicate(T predicate) {
    this.predicate = predicate;
  }

  public boolean isNegative() {
    return negative;
  }

  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  public void flipNegative() {
    this.negative = !this.negative;
  }

  public boolean isPassive() {
    return passive;
  }

  public void setPassive(boolean passive) {
    this.passive = passive;
  }

  public boolean isObjectExpression() {
    return Scope.OBJECT == this.predicate.getScope();
  }

  public boolean isDataExpression() {
    return Scope.DATA == this.predicate.getScope();
  }

  public boolean isAnnotationExpression() {
    return Scope.ANNOTATION == this.predicate.getScope();
  }

  public Scope getScope() {
    return this.predicate.getScope();
  }

  public String toString() {
    StringBuilder bldr = new StringBuilder();

    if (this.negative) {
      bldr.append("NOT ");
    }

    if (this.passive) {
      bldr.append("is ");
      bldr.append(this.predicate);
      bldr.append(" by ");
    } else {
      bldr.append(this.predicate);
    }

    return bldr.toString();
  }

  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();

    if (this.predicate.getPredicateType().equals(PredicateType.IS)) {
      wrds.add(this.predicate);
      if (this.negative) {
        wrds.add(Vocabulary.NOT);
      }
    }

    if (this.predicate.getPredicateType().equals(PredicateType.SAME_AS)) {
      if (this.negative) {
        wrds.add(Vocabulary.IS_AUX);
        wrds.add(Vocabulary.NOT);
      }
      wrds.add(this.predicate);
    }

    if (this.predicate.getPredicateType().equals(PredicateType.VERB)) {

      if (this.passive) {
        wrds.add(Vocabulary.IS_AUX);
      }

      if (this.negative) {
        if (!this.passive) {
          wrds.add(Vocabulary.DOES_AUX);
        }
        wrds.add(Vocabulary.NOT);
      }
      wrds.add(this.predicate);

      if (this.passive) {
        wrds.add(Vocabulary.PASSIVE);
      }
    }

    if (this.predicate.getPredicateType().equals(PredicateType.FACET)) {

      wrds.add(Vocabulary.IS_AUX);
      if (this.negative) {
        wrds.add(Vocabulary.NOT);
      }
      wrds.add(this.predicate);
    }

    return wrds;
  }

}
