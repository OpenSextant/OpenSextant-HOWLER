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

import java.util.Set;

public interface Phrase {

  public enum PhraseType {
    PHRASE, PREDICATEPHRASE, OBJECTPHRASE, PHRASESET, NOUNPHRASE, WORD, NOUN, MASSNOUN, ADJECTIVE, PROPER, THING, VERB, WHAT
  };

  PhraseType getPhraseType();

  Set<Word> getWords();
}