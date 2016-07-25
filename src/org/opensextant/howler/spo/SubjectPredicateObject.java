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

public class SubjectPredicateObject {

  public enum SPOType {
    STATEMENT, QUESTION
  };

  private ObjectPhrase subject;
  // predicates are in objects
  private PhraseSet objects = new PhraseSet();
  private SPOType spoType = SPOType.STATEMENT;

  public ObjectPhrase getSubject() {
    return subject;
  }

  public void setSubject(ObjectPhrase subject) {
    this.subject = subject;
  }

  public PhraseSet getObjects() {
    return objects;
  }

  public void setObjects(PhraseSet objects) {
    this.objects = objects;
  }

  public void addObject(Phrase object) {
    this.objects.addPhrase(object);
  }

  public SPOType getSpoType() {
    return spoType;
  }

  public void setSpoType(SPOType spoType) {
    this.spoType = spoType;
  }

  @Override
  public String toString() {

    StringBuilder bldr = new StringBuilder();
    bldr.append(subject + " " + objects);
    return bldr.toString();
  }

  public Set<Word> getWords() {

    Set<Word> words = new HashSet<Word>();

    words.addAll(this.subject.getWords());
    words.addAll(this.objects.getWords());

    return words;

  }

}
