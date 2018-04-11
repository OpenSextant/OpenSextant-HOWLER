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

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.Category;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.Noun;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.enumerated.Scope;

public class CategoryPhrase<T extends Category> extends SubjectObjectPhrase {

  T head;
  private List<T> modifiers = new ArrayList<T>();
  private List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> relativePhrases = new ArrayList<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>>();

  public CategoryPhrase(T head) {
    this.head = head;
  }

  public T getHead() {
    return head;
  }

  public void setHead(T head) {
    this.head = head;
  }

  public boolean isSimple() {
    return modifiers.isEmpty() && relativePhrases.isEmpty() && !this.getQuantifier().isNegative();
  }

  public boolean isThingThatPhrase() {
    if ((head.getKey().equals(Vocabulary.THING_IRI) || head.getKey().equals(Vocabulary.DATATYPE_THING_IRI))
        && modifiers.isEmpty() && relativePhrases.size() == 1) {
      return true;
    }

    return false;
  }

  public List<T> getModifiers() {
    return modifiers;
  }

  public void setModifiers(List<T> modifiers) {
    this.modifiers = modifiers;
  }

  public void addModifier(T modifier) {
    this.modifiers.add(modifier);
  }

  public List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> getRelativePhrases() {
    return relativePhrases;
  }

  public void setRelativePhrases(
      List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> relativePhrases) {
    this.relativePhrases = relativePhrases;
  }

  public void addRelativePhrase(PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> relativePhrase) {
    this.relativePhrases.add(relativePhrase);
  }

  public boolean isObjectScope() {
    return this.head instanceof Noun;
  }

  public boolean isDataScope() {
    return this.head instanceof DataType;
  }

  @Override
  public boolean isAnnotationScope() {
    return false;
  }

  @Override
  public boolean isConsistentScope() {

    for (PredicatePhrase<?, ?> rel : this.relativePhrases) {
      if (!rel.isConsistentScope())
        return false;
    }

    return true;
  }

  @Override
  public Scope getScope() {
    return this.head.getScope();
  }

  @Override
  public String toString() {
    StringBuilder bldr = new StringBuilder();

    bldr.append("(" + this.getScope() + ") ");

    if (!this.modifiers.isEmpty()) {
      for (T w : this.modifiers) {
        bldr.append(w.toString());
        bldr.append(" ");
      }
    }

    bldr.append(head.toString());

    if (!this.relativePhrases.isEmpty()) {

      bldr.append(" that ");
      bldr.append(this.relativePhrases.get(0).toString());

      for (int i = 1; i < this.relativePhrases.size(); i++) {
        bldr.append(" and that ");
        bldr.append(this.relativePhrases.get(i).toString());
      }
    }

    return bldr.toString();
  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
    
    wrds.addAll(this.getQuantifier().getWords());
    
    for (Word a : this.modifiers) {
      wrds.add(a);
    }
    wrds.add(head);

    for (PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> rel : this.relativePhrases) {
      wrds.add(Vocabulary.THAT);
      wrds.addAll(rel.getWords());
    }

    return wrds;
  }

}
