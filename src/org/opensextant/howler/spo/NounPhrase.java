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

public class NounPhrase extends ObjectPhrase {

  List<Noun> modifiers = new ArrayList<Noun>();
  Noun head = new Thing();

  public List<Noun> getModifiers() {
    return modifiers;
  }

  public void setModifiers(List<Noun> modifiers) {
    this.modifiers = modifiers;
  }

  public void addModifier(Noun modifier) {
    modifiers.add(modifier);
  }

  public void addModifiers(List<Noun> mods) {
    modifiers.addAll(mods);
  }

  public Noun getHead() {
    return head;
  }

  public void setHead(Noun head) {
    this.head = head;
  }

  @Override
  public Set<Word> getWords() {

    Set<Word> words = new HashSet<Word>();

    words.addAll(super.getWords());
    words.add(this.head);
    words.addAll(this.modifiers);

    return words;

  }

  @Override
  public PhraseType getPhraseType() {
    return PhraseType.NOUNPHRASE;
  }

  @Override
  public String toString() {
    return modifiers + " " + head;
  }

}
