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
