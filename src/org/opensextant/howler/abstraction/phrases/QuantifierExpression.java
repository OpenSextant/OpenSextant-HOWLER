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
package org.opensextant.howler.abstraction.phrases;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.enumerated.Negative;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;

public class QuantifierExpression {

  private Quantifier quantifier = Quantifier.EVERY;
  private Integer quantity = 1;

  public QuantifierExpression(Quantifier type) {
    this.quantifier = type;
  }

  public QuantifierExpression(Integer count, Quantifier type) {
    this.quantifier = type;
    this.quantity = count;
    if (!type.isNumeric()) {
      // TODO log warning
    }
  }

  public boolean isNegative() {
    return quantifier.equals(Quantifier.NO);
  }

  public void flipNegative() {
    this.quantifier = this.quantifier.getNegation();
  }

  public Quantifier getQuantifierType() {
    return quantifier;
  }

  public void setQuantifierType(Quantifier quantType) {
    if(isNegative()){
      this.quantifier = quantType.getNegation();
    }else{
      this.quantifier = quantType;
    }

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

    bldr.append(quantifier.name());

    if (quantifier.isNumeric()) {
      bldr.append(" " + quantity);
    }
    return bldr.toString();
  }

  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();

    if(! this.quantifier.equals(Quantifier.NULL)){
      wrds.add(this.quantifier);
      if (quantifier.isNumeric()) {
        wrds.add(new GenericWord(this.quantity.toString(),"CD"));
      }
    }

    return wrds;
  }

}
