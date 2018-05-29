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

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class DataValue extends Instance {

  private DataType datatype = Vocabulary.STRING_TYPE;
  private String language = "";

  public DataValue(String normal, IRI key) {
    super(normal, key);
  }

  public DataValue(String normal) {
    super(normal, IRI.create(Vocabulary.VALUE_NS.toString(), normal));
  }

  @Override
  public String getNormalForm() {
    return normalForm;
  }

  public DataType getDatatype() {
    return datatype;
  }

  public void setDatatype(DataType datatype) {
    this.datatype = datatype;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Scope getScope() {
    return Scope.DATA_SCOPE;
  }

  public WordType getWordType() {
    return WordType.DATAVALUE;
  }

  public String toString() {
    return this.getNormalForm() + " (" + datatype + ")";
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((super.normalForm == null) ? 0 : super.normalForm.hashCode());
    result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());
    result = prime * result + ((language == null) ? 0 : language.hashCode());

    return result;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (!(obj instanceof DataValue)) {
      return false;
    }
    DataValue other = (DataValue) obj;

    if (datatype == null) {
      if (other.datatype != null) {
        return false;
      }
    } else if (!datatype.equals(other.datatype)) {
      return false;
    }

    if (super.normalForm == null) {
      if (other.normalForm != null) {
        return false;
      }
    } else if (!super.normalForm.equals(other.normalForm)) {
      return false;
    }

    if (language == null) {
      if (other.language != null) {
        return false;
      }
    } else if (!language.equals(other.language)) {
      return false;
    }
    return true;
  }

}
