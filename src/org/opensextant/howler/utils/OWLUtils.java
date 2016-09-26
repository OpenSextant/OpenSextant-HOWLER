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
package org.opensextant.howler.utils;

import java.util.HashMap;
import java.util.Map;

import org.opensextant.howler.spo.ObjectPhrase;
import org.opensextant.howler.spo.Phrase;
import org.opensextant.howler.spo.Phrase.PhraseType;
import org.opensextant.howler.spo.Predicate;
import org.opensextant.howler.spo.Predicate.PredicateType;
import org.opensextant.howler.spo.PredicatePhrase;
import org.opensextant.howler.spo.Proper;
import org.opensextant.howler.spo.Quantifier.QuantifierType;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.Thing;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.nlp.common.util.StringUtils;
import edu.emory.mathcs.nlp.component.morph.MorphAnalyzer;
import edu.emory.mathcs.nlp.component.morph.english.EnglishMorphAnalyzer;

public class OWLUtils {

  static Map<String, Integer> numbers = new HashMap<String, Integer>();
  
  static MorphAnalyzer lemmatizer = new EnglishMorphAnalyzer();
  
  static {
    numbers.put("one", 1);
    numbers.put("two", 2);
    numbers.put("three", 3);
    numbers.put("four", 4);
    numbers.put("five", 5);
    numbers.put("six", 6);
    numbers.put("seven", 7);
    numbers.put("eight", 8);
    numbers.put("nine", 9);
    numbers.put("ten", 10);
    numbers.put("eleven", 11);
    numbers.put("twelve", 12);
  }

  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(OWLUtils.class);

  public static Integer convertNumber(String text) {

    try {
      if (text.matches("[0-9]+")) {
        int num = Integer.parseInt(text);
        return num;
      }
    } catch (NumberFormatException e) {
      LOGGER.error("Didn't convert number string to numeric " + text);
      return 1;
    }

    if (numbers.containsKey(text.toLowerCase())) {
      return numbers.get(text);
    }

    LOGGER.error("Didn't convert number string to numeric " + text);

    return 1;
  }

  // -----------------------------------------------------

  public static boolean isInverse(OWLObjectPropertyExpression prop) {
    return prop.isAnonymous();
  }

  public static boolean isAdjective(OWLClassExpression ce) {

    if (ce.getClassExpressionType() != ClassExpressionType.OWL_CLASS) {
      return false;
    }

    OWLClass cl = (OWLClass) ce;

    String entityWord = OWLUtils.getIRIShortform(cl.getIRI());
    if (entityWord.endsWith("_thing")) {
      return true;
    }
    return false;

  }

  public static boolean isMass(OWLClassExpression ce) {

    if (ce.getClassExpressionType() != ClassExpressionType.OWL_CLASS) {
      return false;
    }

    OWLClass cl = (OWLClass) ce;

    String entityWord = OWLUtils.getIRIShortform(cl.getIRI());
    if (entityWord.endsWith("_mass")) {
      return true;
    }
    return false;

  }

  // a proper proper is one with no relative clauses and is not negative
  public static boolean isProper(Phrase phrase) {

    if (phrase.getPhraseType() != PhraseType.PROPER) {
      return false;
    }

    Proper proper = (Proper) phrase;

    if (!proper.getRelativePhrases().isEmpty()) {
      return false;
    }

    if (proper.getQuantifier().isNegative()) {
      return false;
    }

    return true;
  }

  public static String getIRIShortform(IRI iri) {
    return iri.getShortForm();
  }

  public static String getIRINamespace(IRI iri) {
    return iri.getNamespace();
  }

  public static ObjectPhrase wrapRelativeThing(Phrase phrase) {

    // if top most phrase is predicate phrase, must be Thing with relative
    // clause
    if (phrase.getPhraseType() == PhraseType.PREDICATEPHRASE) {
      PredicatePhrase tmp = (PredicatePhrase) phrase;
      tmp.getObject().getQuantifier().setQuantifierType(QuantifierType.A);
      Thing obj = new Thing();
      obj.addRelativePhrases(tmp);
      return obj;
    } else {
      return (ObjectPhrase) phrase;
    }
  }

  public static PredicatePhrase pushDownObject(Phrase phrase,
      PredicateType ptype, QuantifierType qt) {

    // if topmost phrase is not a predicate phrase
    // add predicate phrase and move phrase to object
    if (phrase.getPhraseType() == PhraseType.PREDICATEPHRASE) {
      return (PredicatePhrase) phrase;
    } else {
      PredicatePhrase predPhrase = new PredicatePhrase();
      Predicate pred = new Predicate();
      pred.setType(ptype);
      predPhrase.setPredicate(pred);

      ObjectPhrase objPhrase = wrapRelativeThing(phrase);
      objPhrase.getQuantifier().setQuantifierType(qt);
      predPhrase.setObject(objPhrase);
      return predPhrase;
    }

  }

  public static String normalize(String word, String pos, boolean lower) {

    // don't change propers
    if (pos.equals("NP") || pos.equals("NPS")) {
      return word;
    }

    // don't change numbers or Fixed vocab
    if (pos.equals("CD") || pos.equals("FIXED")) {
      return word;
    }

    // don't normalize verbs yet
    if (pos.startsWith("V")) {
      return word;
    }

    return lemmatizer.lemmatize(StringUtils.toSimplifiedForm(word, lower), pos);
  }

  public static SubjectPredicateObject rewriteSPO(
      SubjectPredicateObject original) {

    // TODO handle multiple ANDed objects
    if (original.getObjects().getPhrases().size() > 1) {

      return original;
    }

    ObjectPhrase subj = original.getSubject();
    Phrase tgt = original.getObjects().getPhrases().get(0);

    // TODO rewrites for these
    if (tgt.getPhraseType() != PhraseType.PREDICATEPHRASE) {
      return original;
    }

    PredicatePhrase predPhrase = (PredicatePhrase) tgt;
    ObjectPhrase obj = predPhrase.getObject();
    Predicate pred = predPhrase.getPredicate();

    boolean isProperSubj = subj.getPhraseType() == PhraseType.PROPER;
    boolean isProperObj = OWLUtils.isProper(obj);
    boolean isPassive = pred.isPassive();
    boolean someQuant = true;
    if (subj.getQuantifier().getQuantifierType() == QuantifierType.EVERY) {
      someQuant = false;
    }

    // passive someQuant-Common and Proper
    if (isPassive && someQuant && !isProperSubj && isProperObj) {

      SubjectPredicateObject rewrite = new SubjectPredicateObject();
      // flip subject and object
      rewrite.setSubject(obj);

      PredicatePhrase rewritePredPhrase = new PredicatePhrase();
      // flip passive
      pred.setPassive(!pred.isPassive());
      rewritePredPhrase.setPredicate(pred);
      rewritePredPhrase.setObject(subj);
      rewrite.getObjects().addPhrase(rewritePredPhrase);

      return rewrite;

    }

    return original;

  }
}
