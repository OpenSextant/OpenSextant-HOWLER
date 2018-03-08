package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.words.Predicate;
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

}
