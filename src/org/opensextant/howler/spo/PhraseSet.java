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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.opensextant.howler.utils.OWLUtils;

public class PhraseSet extends ObjectPhrase {

  List<Phrase> phrases = new ArrayList<Phrase>();

  boolean intersection;

  public boolean isProperSet() {

    for (Phrase ph : phrases) {
      if (!OWLUtils.isProper(ph)) {
        return false;
      }
    }
    return true;
  }

  public List<Phrase> getPhrases() {
    return phrases;
  }

  public void setPhrases(List<Phrase> phrases) {
    this.phrases = phrases;
  }

  public void addPhrase(Phrase phrase) {
    phrases.add(phrase);
  }

  public boolean isIntersection() {
    return intersection;
  }

  public void setIntersection(boolean intersection) {
    this.intersection = intersection;
  }

  @Override
  public Set<Word> getWords() {
    Set<Word> words = new HashSet<Word>();
    words.addAll(super.getWords());
    for (Phrase phrase : this.phrases) {
      words.addAll(phrase.getWords());
    }
    return words;

  }

  @Override
  public PhraseType getPhraseType() {
    return PhraseType.PHRASESET;
  }

  @Override
  public String toString() {
    return phrases.toString();
  }

}
