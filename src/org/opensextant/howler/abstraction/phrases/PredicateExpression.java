package org.opensextant.howler.abstraction.phrases;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.enumerated.Negative;
import org.opensextant.howler.abstraction.words.enumerated.PassiveMarker;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class PredicateExpression<T extends Predicate> {

  T predicate;
  private boolean negative = false;
  private boolean inverse = false;

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

  public boolean isInverse() {
    return inverse;
  }

  public void setInverse(boolean inverse) {
    this.inverse = inverse;
  }

  public boolean isObjectExpression() {
    return Scope.OBJECT_SCOPE == this.predicate.getScope();
  }

  public boolean isDataExpression() {
    return Scope.DATA_SCOPE == this.predicate.getScope();
  }

  public boolean isAnnotationExpression() {
    return Scope.ANNOTATION_SCOPE == this.predicate.getScope();
  }

  public Scope getScope() {
    return this.predicate.getScope();
  }

  public String toString() {
    StringBuilder bldr = new StringBuilder();

    if (this.negative) {
      bldr.append("NOT ");
    }

    if (this.inverse) {
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
        wrds.add(Negative.NOT);
      }
    }

    if (this.predicate.getPredicateType().equals(PredicateType.SAME_AS)) {
      if (this.negative) {
        wrds.add(Vocabulary.IS_AUX);
        wrds.add(Negative.NOT);
      }
      wrds.add(this.predicate);
    }

    if (this.predicate.getPredicateType().equals(PredicateType.VERB)) {

      if (this.inverse) {
        wrds.add(Vocabulary.IS_AUX);
      }

      if (this.negative) {
        if (!this.inverse) {
          wrds.add(Vocabulary.DOES_AUX);
        }
        wrds.add(Negative.NOT);
      }
      wrds.add(this.predicate);

      if (this.inverse) {
        wrds.add(PassiveMarker.BY);
      }
    }

    if (this.predicate.getPredicateType().equals(PredicateType.FACET)) {

      wrds.add(Vocabulary.IS_AUX);
      if (this.negative) {
        wrds.add(Negative.NOT);
      }
      wrds.add(this.predicate);
    }

    return wrds;
  }

}
