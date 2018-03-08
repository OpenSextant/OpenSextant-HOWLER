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
package org.opensextant.howler.abstraction.words;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;

public abstract class WordBase implements Word {

  protected String normalForm;
  private IRI key;
  private List<Footnote> footnotes = new ArrayList<Footnote>();

  public WordBase(String normal, IRI key) {
    this.normalForm = normal;
    this.key = key;
  }

  @Override
  public String getNormalForm() {
    return normalForm;
  }

  @Override
  public void setNormalForm(String normalForm) {
    this.normalForm = normalForm;
  }

  @Override
  public IRI getKey() {
    return key;
  }

  @Override
  public String getLogicalForm() {
    return TextUtils.getLogicalForm(this.key);
  }

  @Override
  public String getNamespace() {
    return TextUtils.getNamespace(this.key);
  }

  @Override
  public Scope getScope() {
    return Scope.ANNOTATION;
  }

  @Override
  public WordType getWordType() {
    return WordType.GENERIC_WORD;
  }

  @Override
  public List<Footnote> getFootnotes() {
    return footnotes;
  }

  @Override
  public void setFootnotes(List<Footnote> footnotes) {
    this.footnotes = footnotes;
  }

  @Override
  public void addFootnote(Footnote footnote) {
    this.footnotes.add(footnote);
  }

  public String toString() {
    return normalForm + " (" + this.getWordType() + ")";
  }

  // hash by key and wordtype
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((this.getWordType() == null) ? 0 : this.getWordType().hashCode());
    return result;
  }

  // words are equal if they have the same key and class
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof WordBase)) {
      return false;
    }

    WordBase other = (WordBase) obj;

    if (getClass() != obj.getClass()) {
      return false;
    }

    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    return true;
  }
}
