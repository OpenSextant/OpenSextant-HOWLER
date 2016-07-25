/*
   Copyright 2009-2016 The MITRE Corporation.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
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
