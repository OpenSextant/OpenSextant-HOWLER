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
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class PhraseSet<T extends SubjectObjectPhrase> extends SubjectObjectPhrase {

  List<T> phrases = new ArrayList<T>();
  BooleanSetType booleanSetType = BooleanSetType.AND;
  boolean disjoint = false;

  public List<T> getPhrases() {
    return phrases;
  }

  public void setPhrases(List<T> phrases) {
    this.phrases = phrases;
  }

  public void addPhrase(T phrase) {
    phrases.add(phrase);
  }

  public BooleanSetType getSetType() {
    return booleanSetType;
  }

  public void setSetType(BooleanSetType booleanSetType) {
    this.booleanSetType = booleanSetType;
  }

  public boolean isDisjoint() {
    return disjoint;
  }

  public void setDisjoint(boolean disjoint) {
    this.disjoint = disjoint;
  }

  public boolean isNested() {
    for (T ph : phrases) {
      if (ph instanceof PhraseSet) {
        return true;
      }
    }
    return false;
  }

  public boolean allInstances() {

    for (T ph : phrases) {
      if (!(ph instanceof InstancePhrase)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {

    if (this.phrases.isEmpty()) {
      return "<EMPTY " + this.booleanSetType + ">";
    }

    StringBuilder bldr = new StringBuilder();

    String op = "";

    if (this.booleanSetType == BooleanSetType.AND) {
      op = " AND ";
    }

    if (this.booleanSetType == BooleanSetType.OR) {
      op = " OR ";
    }

    /*
    if (this.booleanSetType == BooleanSetType.ONEOF) {
      bldr.append(" either ");
      op = " OR ";
    }
*/
    bldr.append(this.getQuantifierExpression());
    bldr.append(" ");

    bldr.append(phrases.get(0).toString());

    for (int i = 1; i < phrases.size(); i++) {
      bldr.append(op);
      bldr.append(phrases.get(i).toString());
    }

    return bldr.toString();
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
  public Scope getScope() {
    if (this.isConsistentScope()) {
      return this.phrases.get(0).getScope();
    }
    return Scope.GENERAL_SCOPE;
  }

  @Override
  public boolean isAnnotationScope() {
    return this.getScope() == Scope.ANNOTATION_SCOPE;
  }

  @Override
  public boolean isConsistentScope() {

    for (T ph : this.phrases) {
      if (!ph.isConsistentScope()) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.getQuantifierExpression().getWords());
    wrds.addAll(this.phrases.get(0).getWords());
    for (int i = 1; i < this.phrases.size(); i++) {
      wrds.add(this.booleanSetType);
      wrds.addAll(this.phrases.get(i).getWords());
    }

    return wrds;
  }

}
