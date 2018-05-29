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
package org.opensextant.howler.abstraction;

import java.util.List;

import org.opensextant.howler.abstraction.words.enumerated.Scope;
/**
 * Phrase represents a combination of Words, used for a specific purposes or role. Each of the subtypes of Phrase,
 * defines the specific combination of Words
 */
public interface Phrase {

  public boolean isNegative();

  public void setNegative(boolean negative);

  public void flipNegative();

  public Scope getScope();

  public boolean isObjectScope();

  public boolean isDataScope();

  public boolean isAnnotationScope();

  public boolean isConsistentScope();

  public List<Word> getWords();
}