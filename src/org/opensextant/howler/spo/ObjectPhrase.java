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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectPhrase implements Phrase {

  private Quantifier quantifier = new Quantifier();
  private List<PredicatePhrase> relativePhrases = new ArrayList<PredicatePhrase>();

  public Quantifier getQuantifier() {
    return quantifier;
  }

  public void setQuantifier(Quantifier quantifier) {
    this.quantifier = quantifier;
  }

  public List<PredicatePhrase> getRelativePhrases() {
    return relativePhrases;
  }

  public void setRelativePhrases(List<PredicatePhrase> relativePhrases) {
    this.relativePhrases = relativePhrases;
  }

  public void addRelativePhrases(PredicatePhrase relativePhrase) {
    relativePhrases.add(relativePhrase);
  }

  @Override
  public PhraseType getPhraseType() {
    return Phrase.PhraseType.OBJECTPHRASE;
  }

  @Override
  public Set<Word> getWords() {
    Set<Word> words = new HashSet<Word>();
    for (Phrase p : this.relativePhrases) {
      words.addAll(p.getWords());
    }

    return words;
  }

}
