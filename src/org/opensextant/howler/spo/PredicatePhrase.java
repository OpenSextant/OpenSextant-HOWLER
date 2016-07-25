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

import java.util.HashSet;
import java.util.Set;

public class PredicatePhrase implements Phrase {

  Predicate predicate = new Predicate();
  ObjectPhrase object = new ObjectPhrase();

  public PredicatePhrase() {

  }

  public PredicatePhrase(Predicate predicate, ObjectPhrase object) {
    this.predicate = predicate;
    this.object = object;
  }

  public Predicate getPredicate() {
    return predicate;
  }

  public void setPredicate(Predicate predicate) {
    this.predicate = predicate;
  }

  public ObjectPhrase getObject() {
    return object;
  }

  public void setObject(ObjectPhrase object) {
    this.object = object;
  }

  @Override
  public PhraseType getPhraseType() {
    return PhraseType.PREDICATEPHRASE;
  }

  @Override
  public String toString() {
    return predicate + " " + object;
  }

  @Override
  public Set<Word> getWords() {

    Set<Word> words = new HashSet<Word>();

    if (this.predicate.isVerbType()) {
      words.add(this.predicate.getVerb());
    }

    words.addAll(this.object.getWords());

    return words;
  }

}
