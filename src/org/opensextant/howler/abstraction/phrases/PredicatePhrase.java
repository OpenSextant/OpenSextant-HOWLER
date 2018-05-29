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

import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class PredicatePhrase<T extends SubjectObjectPhrase, P extends Predicate> implements Phrase {

  PredicateExpression<P> predicateExpression;

  T object;

  public PredicatePhrase(PredicateExpression<P> predicateExpression, T object) {
    this.predicateExpression = predicateExpression;
    this.object = object;
  }

  public PredicateExpression<P> getPredicateExpression() {
    return predicateExpression;
  }

  public void setPredicateExpression(PredicateExpression<P> predicateExpression) {
    this.predicateExpression = predicateExpression;
  }

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public boolean isNegative() {
    return this.predicateExpression.isNegative();
  }

  public void setNegative(boolean negative) {
    this.predicateExpression.setNegative(negative);
  }

  public void flipNegative() {
    this.predicateExpression.flipNegative();
  }

  @Override
  public boolean isObjectScope() {
    return this.getScope() == Scope.OBJECT_SCOPE;
  }

  @Override
  public boolean isDataScope() {
    return this.getScope() == Scope.DATA_SCOPE;
  }

  @Override
  public boolean isAnnotationScope() {
    return this.getScope() == Scope.ANNOTATION_SCOPE;
  }

  @Override
  public boolean isConsistentScope() {
    return this.object.getScope() == this.predicateExpression.getScope();
  }

  @Override
  public Scope getScope() {

    if (this.isConsistentScope()) {
      return this.getObject().getScope();
    }
    return Scope.GENERAL_SCOPE;
  }

  public String toString() {
    return predicateExpression.toString() + " " + object.toString();
  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.predicateExpression.getWords());
    wrds.addAll(this.object.getWords());
    return wrds;
  }

}
