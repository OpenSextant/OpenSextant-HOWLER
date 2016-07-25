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

import org.opensextant.howler.utils.OWLUtils;

public class Word extends ObjectPhrase {

  // surface form is how it appeared in text
  protected String surfaceForm;

  // logical form has spaces replaced by underbars
  protected String logicalForm;
  protected String partOfSpeech;
  protected String vocabulary;

  public Word(String surface, String pos, String vocab, boolean lower) {
    surfaceForm = surface;
    logicalForm = OWLUtils.normalize(surface, pos, lower);
    partOfSpeech = pos;
    vocabulary = vocab;
  }

  public String getSurfaceForm() {
    return surfaceForm;
  }

  public void setSurfaceForm(String surfaceForm) {
    this.surfaceForm = surfaceForm;
  }

  public String getLogicalForm() {
    return logicalForm;
  }

  public void setLogicalForm(String logicalForm) {
    this.logicalForm = logicalForm;
  }

  public String getLogicalFormCapital() {
    if (logicalForm.length() > 0) {
      return Character.toUpperCase(this.getLogicalForm().charAt(0))
          + this.getLogicalForm().substring(1);
    } else {
      return "";
    }
  }

  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

  public String getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(String vocabulary) {
    this.vocabulary = vocabulary;
  }

  @Override
  public Set<Word> getWords() {
    Set<Word> words = new HashSet<Word>();
    words.addAll(super.getWords());
    words.add(this);
    return words;
  }

  @Override
  public String toString() {
    return this.getQuantifier() + " " + this.getSurfaceForm() + " ("
        + this.getLogicalForm() + ")";
  }

  @Override
  public PhraseType getPhraseType() {
    return PhraseType.WORD;
  }

}
