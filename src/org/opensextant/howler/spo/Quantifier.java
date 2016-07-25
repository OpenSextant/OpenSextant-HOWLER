/*
 * **************************************************************************
 *					     NOTICE
 *
 *	This software was produced for the U. S. Government
 *	under Basic Contract No. W15P7T-13-C-A802, and is
 *	subject to the Rights in Noncommercial Computer Software
 *	and Noncommercial Computer Software Documentation
 *	Clause 252.227-7014 (FEB 2012)
 *
 *  2016 The MITRE Corporation. All Rights Reserved.
 *
 * **************************************************************************
 */
package org.opensextant.howler.spo;

public class Quantifier {

  public enum QuantifierType {
    NULL, EVERY, SOME, A, THE, NUMERIC
  };

  public enum NumericQuantifierType {
    EXACT, MORE_THAN, LESS_THAN, MORE_THAN_OR_EQUAL, LESS_THAN_OR_EQUAL
  };

  private QuantifierType quantType = QuantifierType.EVERY;
  private boolean negative = false;

  private NumericQuantifierType numericType = NumericQuantifierType.EXACT;
  private Integer quantity = 1;

  public boolean isNegative() {
    return negative;
  }

  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  public QuantifierType getQuantifierType() {
    return quantType;
  }

  public void setQuantifierType(QuantifierType quantType) {
    this.quantType = quantType;
  }

  public NumericQuantifierType getNumericType() {
    return numericType;
  }

  public void setNumericType(NumericQuantifierType numericType) {
    this.numericType = numericType;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quant) {
    quantity = quant;
  }

  @Override
  public String toString() {
    StringBuilder bldr = new StringBuilder();

    if (negative) {
      bldr.append("NOT ");
    }

    if (quantType != QuantifierType.NUMERIC) {
      bldr.append(quantType.name());

    } else {
      bldr.append(numericType + " " + quantity);
    }
    return bldr.toString();
  }

}
