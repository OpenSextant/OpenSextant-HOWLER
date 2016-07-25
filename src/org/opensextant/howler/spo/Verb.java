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

public class Verb extends Word {

  private String auxiliary = "";
  private String baseVerb = "";
  private String particle = "";

  public Verb(String surface, String pos, String vocab) {
    super(surface, pos, vocab, true);
    // TODO verb normalization happens here?
    baseVerb = this.logicalForm;
  }

  @Override
  public String getLogicalForm() {

    String tmp = this.baseVerb;

    if (!this.auxiliary.isEmpty()) {
      tmp = this.auxiliary + "_" + tmp;
    }

    if (!this.particle.isEmpty()) {
      tmp = tmp + "_" + this.particle;
    }

    return tmp;
  }

  public boolean isParticleVerb() {
    if (!this.auxiliary.isEmpty()) {
      return true;
    }

    if (!this.particle.isEmpty()) {
      return true;
    }

    return false;
  }

  public String getAuxiliary() {
    return auxiliary;
  }

  public void setAuxiliary(String auxiliary) {
    this.auxiliary = auxiliary;
  }

  public String getBaseVerb() {
    return baseVerb;
  }

  public void setBaseVerb(String baseVerb) {
    this.baseVerb = baseVerb;
  }

  public String getParticle() {
    return particle;
  }

  public void setParticle(String particle) {
    this.particle = particle;
  }

  @Override
  public PhraseType getPhraseType() {
    return PhraseType.VERB;
  }
}