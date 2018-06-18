package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;

public abstract class SubjectObjectPhrase implements Phrase {

  private QuantifierExpression quantifierExpression = new QuantifierExpression(Quantifier.NULL);

  public QuantifierExpression getQuantifierExpression() {
    return quantifierExpression;
  }

  public void setQuantifierExpression(QuantifierExpression quantifierExpression) {
    this.quantifierExpression = quantifierExpression;
  }

  public Quantifier getQuantifierType() {
    return this.quantifierExpression.getQuantifierType();
  }

  public void setQuantifierType(Quantifier q) {
    this.quantifierExpression.setQuantifierType(q);
  }

  public boolean isNegative() {
    return this.quantifierExpression.isNegative();
  }

  public void flipNegative() {
    this.quantifierExpression.flipNegative();
  }

  public void pushNegative() {
    return;
  }

  public void pushQuantifier() {
    return;
  }

}
