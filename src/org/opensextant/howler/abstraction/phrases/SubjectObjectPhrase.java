package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;

public abstract class SubjectObjectPhrase implements Phrase {

  private QuantifierExpression quantifierExpression = new QuantifierExpression(Quantifier.NULL);

  public QuantifierExpression getQuantifier() {
    return quantifierExpression;
  }

  public void setQuantifier(QuantifierExpression quantifierExpression) {
    this.quantifierExpression = quantifierExpression;
  }

  public boolean isNegative() {
    return this.quantifierExpression.isNegative();
  }

  public void setNegative(boolean negative) {
    this.quantifierExpression.setNegative(negative);
  }

  public void flipNegative() {
    this.quantifierExpression.flipNegative();
  }

 

}
