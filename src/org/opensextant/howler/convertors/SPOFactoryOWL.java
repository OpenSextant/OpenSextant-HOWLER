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
package org.opensextant.howler.convertors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.opensextant.howler.spo.Adjective;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.MassNoun;
import org.opensextant.howler.spo.Noun;
import org.opensextant.howler.spo.NounPhrase;
import org.opensextant.howler.spo.ObjectPhrase;
import org.opensextant.howler.spo.Phrase;
import org.opensextant.howler.spo.Phrase.PhraseType;
import org.opensextant.howler.spo.PhraseSet;
import org.opensextant.howler.spo.Predicate;
import org.opensextant.howler.spo.Predicate.PredicateType;
import org.opensextant.howler.spo.PredicatePhrase;
import org.opensextant.howler.spo.Proper;
import org.opensextant.howler.spo.Quantifier;
import org.opensextant.howler.spo.Quantifier.NumericQuantifierType;
import org.opensextant.howler.spo.Quantifier.QuantifierType;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.Thing;
import org.opensextant.howler.spo.Verb;
import org.opensextant.howler.utils.OWLUtils;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPOFactoryOWL {

  // all the conversion routines

  // Log object
  private static final Logger LOGGER = LoggerFactory
      .getLogger(SPOFactoryOWL.class);

  static String DEFAULT_NAMESPACE = "http://org.opensextant.howler/";

  public Document convertOntoloy(OWLOntology onto) {

    Document doc = new Document();
    String title = "New Document";

    Optional<IRI> iri = onto.getOntologyID().getOntologyIRI();

    // TODO how to convert IRI to title?
    if (iri.isPresent()) {
      title = iri.get().toString();
    }

    doc.setTitle(title);

    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    for (OWLAxiom axiom : OWLAPIStreamUtils.asList(onto.axioms())) {
      List<SubjectPredicateObject> spos = convertAxiom(axiom);
      spoList.addAll(spos);
    }

    doc.setSentences(spoList);

    return doc;
  }

  // convert each axiom by type
  public List<SubjectPredicateObject> convertAxiom(OWLAxiom axiom) {

    AxiomType<?> axType = axiom.getAxiomType();

    // all the different OWL axioms
    if (axType == AxiomType.DECLARATION) {
      return convertDeclaration(axiom);
    }
    if (axType == AxiomType.EQUIVALENT_CLASSES) {
      return convertEquivalentClasses(axiom);
    }
    if (axType == AxiomType.SUBCLASS_OF) {
      return convertSubclassOf(axiom);
    }
    if (axType == AxiomType.DISJOINT_CLASSES) {
      return convertDisjointClasses(axiom);
    }
    if (axType == AxiomType.DISJOINT_UNION) {
      return convertDisjointUnion(axiom);
    }
    if (axType == AxiomType.CLASS_ASSERTION) {
      return convertClassAssertion(axiom);
    }
    if (axType == AxiomType.SAME_INDIVIDUAL) {
      return convertSameIndividual(axiom);
    }
    if (axType == AxiomType.DIFFERENT_INDIVIDUALS) {
      return convertDifferentIndividuals(axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_ASSERTION) {
      return convertObjectPropertyAssertion(axiom);
    }
    if (axType == AxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION) {
      return convertNegativeObjectPropertyAssertion(axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_ASSERTION) {
      return convertDataPropertyAssertion(axiom);
    }
    if (axType == AxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION) {
      return convertNegativeDataPropertyAssertion(axiom);
    }
    if (axType == AxiomType.EQUIVALENT_OBJECT_PROPERTIES) {
      return convertEquivalentObjectProperties(axiom);
    }
    if (axType == AxiomType.SUB_OBJECT_PROPERTY) {
      return convertSubObjectProperty(axiom);
    }
    if (axType == AxiomType.INVERSE_OBJECT_PROPERTIES) {
      return convertInverseObjectProperties(axiom);
    }
    if (axType == AxiomType.FUNCTIONAL_OBJECT_PROPERTY) {
      return convertFunctionalObjectProperty(axiom);
    }
    if (axType == AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY) {
      return convertInverseFunctionalObjectProperty(axiom);
    }
    if (axType == AxiomType.SYMMETRIC_OBJECT_PROPERTY) {
      return convertSymmetricObjectProperty(axiom);
    }
    if (axType == AxiomType.ASYMMETRIC_OBJECT_PROPERTY) {
      return convertAsymmetricObjectProperty(axiom);
    }
    if (axType == AxiomType.TRANSITIVE_OBJECT_PROPERTY) {
      return convertTransitiveObjectProperty(axiom);
    }
    if (axType == AxiomType.REFLEXIVE_OBJECT_PROPERTY) {
      return convertReflexiveObjectProperty(axiom);
    }
    if (axType == AxiomType.IRREFLEXIVE_OBJECT_PROPERTY) {
      return convertIrreflexiveObjectProperty(axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_DOMAIN) {
      return convertObjectPropertyDomain(axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_RANGE) {
      return convertObjectPropertyRange(axiom);
    }
    if (axType == AxiomType.DISJOINT_OBJECT_PROPERTIES) {
      return convertDisjointObjectProperties(axiom);
    }
    if (axType == AxiomType.SUB_PROPERTY_CHAIN_OF) {
      return convertSubPropertyChainOf(axiom);
    }
    if (axType == AxiomType.EQUIVALENT_DATA_PROPERTIES) {
      return convertEquivalentDataProperties(axiom);
    }
    if (axType == AxiomType.SUB_DATA_PROPERTY) {
      return convertSubDataProperty(axiom);
    }
    if (axType == AxiomType.FUNCTIONAL_DATA_PROPERTY) {
      return convertFunctionalDataProperty(axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_DOMAIN) {
      return convertDataPropertyDomain(axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_RANGE) {
      return convertDataPropertyRange(axiom);
    }
    if (axType == AxiomType.DISJOINT_DATA_PROPERTIES) {
      return convertDisjointDataProperties(axiom);
    }
    if (axType == AxiomType.DATATYPE_DEFINITION) {
      return convertDatatypeDefinition(axiom);
    }
    if (axType == AxiomType.HAS_KEY) {
      return convertHasKey(axiom);
    }
    if (axType == AxiomType.SWRL_RULE) {
      return convertSwrlRule(axiom);
    }
    if (axType == AxiomType.ANNOTATION_ASSERTION) {
      return convertAnnotationAssertion(axiom);
    }
    if (axType == AxiomType.SUB_ANNOTATION_PROPERTY_OF) {
      return convertSubAnnotationPropertyOf(axiom);
    }
    if (axType == AxiomType.ANNOTATION_PROPERTY_RANGE) {
      return convertAnnotationPropertyRange(axiom);
    }
    if (axType == AxiomType.ANNOTATION_PROPERTY_DOMAIN) {
      return convertAnnotationPropertyDomain(axiom);
    }

    LOGGER.warn("Got axiom of unknown type" + axType);
    // return empty list, not null
    return new ArrayList<SubjectPredicateObject>();
  }

  private List<SubjectPredicateObject> convertDeclaration(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDeclarationAxiom ax = (OWLDeclarationAxiom) axiom;
    // TODO
    LOGGER.warn("OWLDeclarationAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertEquivalentClasses(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLEquivalentClassesAxiom ax = (OWLEquivalentClassesAxiom) axiom;

    // do as pairwise rather than single set of n
    Collection<OWLEquivalentClassesAxiom> axs = ax.asPairwiseAxioms();

    for (OWLEquivalentClassesAxiom eq : axs) {

      List<OWLClassExpression> ceList = OWLAPIStreamUtils
          .asList(eq.classExpressions());
      OWLClassExpression subj = ceList.get(0);
      OWLClassExpression obj = ceList.get(1);

      ObjectPhrase subjPhrase = convertSubjectClassExp(subj, QuantifierType.A);
      PhraseSet objPhrase = convertObjectClassExp(obj, PredicateType.IS_SAME_AS,
          QuantifierType.A);

      SubjectPredicateObject spo = new SubjectPredicateObject();
      spo.setSubject(subjPhrase);
      spo.setObjects(objPhrase);

      spoList.add(spo);

    }
    return spoList;
  }

  private List<SubjectPredicateObject> convertDisjointClasses(OWLAxiom axiom) {

    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLDisjointClassesAxiom ax = (OWLDisjointClassesAxiom) axiom;

    Collection<OWLDisjointClassesAxiom> axs = ax.asPairwiseAxioms();

    for (OWLDisjointClassesAxiom dj : axs) {

      List<OWLClassExpression> ceList = OWLAPIStreamUtils
          .asList(dj.classExpressions());
      OWLClassExpression subj = ceList.get(0);
      OWLClassExpression obj = ceList.get(1);

      ObjectPhrase subjPhrase = convertSubjectClassExp(subj, QuantifierType.A);
      PhraseSet objPhrase = convertObjectClassExp(obj, PredicateType.IS_SAME_AS,
          QuantifierType.A);

      for (Phrase objPh : objPhrase.getPhrases()) {

        if (objPh.getPhraseType() == PhraseType.PREDICATEPHRASE) {
          ((PredicatePhrase) objPh).getPredicate().setNegative(true);
        } else {
          ((ObjectPhrase) objPh).getQuantifier().setNegative(true);
        }

      }

      SubjectPredicateObject spo = new SubjectPredicateObject();
      spo.setSubject(subjPhrase);
      spo.setObjects(objPhrase);

      spoList.add(spo);

    }
    return spoList;
  }

  private List<SubjectPredicateObject> convertSubclassOf(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLSubClassOfAxiom ax = (OWLSubClassOfAxiom) axiom;

    OWLClassExpression subj = ax.getSubClass();
    OWLClassExpression obj = ax.getSuperClass();

    ObjectPhrase subjPhrase = convertSubjectClassExp(subj,
        QuantifierType.EVERY);
    PhraseSet objPhrase = convertObjectClassExp(obj, PredicateType.IS,
        QuantifierType.A);

    SubjectPredicateObject spo = new SubjectPredicateObject();
    spo.setSubject(subjPhrase);
    spo.setObjects(objPhrase);

    spoList.add(spo);

    return spoList;
  }

  private List<SubjectPredicateObject> convertDisjointUnion(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLDisjointUnionAxiom ax = (OWLDisjointUnionAxiom) axiom;

    OWLClass subj = ax.getOWLClass();
    List<OWLClassExpression> objs = OWLAPIStreamUtils
        .asList(ax.classExpressions());

    // OWLClassExpression ceSet = wrapCESet(objs, false);

    ObjectPhrase subjPhrase = convertSubjectClassExp(subj,
        QuantifierType.EVERY);

    PhraseSet objPhrases = new PhraseSet();
    for (OWLClassExpression ce : objs) {
      objPhrases.addPhrase(convertSubjectClassExp(ce, QuantifierType.A));
    }

    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setObject(objPhrases);
    predPhrase.getPredicate().setType(PredicateType.IS);
    predPhrase.getPredicate().setExclusive(true);

    PhraseSet objPhrase = new PhraseSet();
    objPhrase.addPhrase(predPhrase);

    SubjectPredicateObject spo = new SubjectPredicateObject();
    spo.setSubject(subjPhrase);
    spo.setObjects(objPhrase);

    spoList.add(spo);

    return spoList;
  }

  private List<SubjectPredicateObject> convertClassAssertion(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLClassAssertionAxiom ax = (OWLClassAssertionAxiom) axiom;

    OWLIndividual subj = ax.getIndividual();
    OWLClassExpression obj = ax.getClassExpression();

    ObjectPhrase subjPhrase = convertIndividualToObjectPhrase(subj,
        QuantifierType.THE);
    PhraseSet objPhrase = convertObjectClassExp(obj, PredicateType.IS,
        QuantifierType.A);

    SubjectPredicateObject spo = new SubjectPredicateObject();
    spo.setSubject(subjPhrase);
    spo.setObjects(objPhrase);

    spoList.add(spo);

    return spoList;
  }

  private List<SubjectPredicateObject> convertSameIndividual(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLSameIndividualAxiom ax = (OWLSameIndividualAxiom) axiom;

    Set<OWLSameIndividualAxiom> axs = ax.asPairwiseAxioms();

    for (OWLSameIndividualAxiom si : axs) {

      OWLIndividual subj = si.getIndividualsAsList().get(0);
      OWLIndividual obj = si.getIndividualsAsList().get(1);
      ObjectPhrase subjPhrase = convertIndividualToObjectPhrase(subj,
          QuantifierType.THE);
      PredicatePhrase objPhrase = convertIndividualToPredicatePhrase(obj,
          PredicateType.IS_SAME_AS, QuantifierType.THE);

      SubjectPredicateObject spo = new SubjectPredicateObject();
      spo.setSubject(subjPhrase);
      spo.addObject(objPhrase);

      spoList.add(spo);

    }

    return spoList;
  }

  private List<SubjectPredicateObject> convertDifferentIndividuals(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLDifferentIndividualsAxiom ax = (OWLDifferentIndividualsAxiom) axiom;

    Collection<OWLDifferentIndividualsAxiom> axs = ax.asPairwiseAxioms();

    for (OWLDifferentIndividualsAxiom di : axs) {

      OWLIndividual subj = di.getIndividualsAsList().get(0);
      OWLIndividual obj = di.getIndividualsAsList().get(1);

      ObjectPhrase subjPhrase = convertIndividualToObjectPhrase(subj,
          QuantifierType.THE);
      PredicatePhrase objPhrase = convertIndividualToPredicatePhrase(obj,
          PredicateType.IS_SAME_AS, QuantifierType.THE);
      objPhrase.getPredicate().setNegative(true);

      SubjectPredicateObject spo = new SubjectPredicateObject();
      spo.setSubject(subjPhrase);
      spo.addObject(objPhrase);

      spoList.add(spo);

    }

    return spoList;

  }

  private List<SubjectPredicateObject> convertObjectPropertyAssertion(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLObjectPropertyAssertionAxiom ax = (OWLObjectPropertyAssertionAxiom) axiom;

    OWLIndividual subj = ax.getSubject();
    OWLIndividual obj = ax.getObject();
    Verb verb = convertObjectPropertyExpression(ax.getProperty());

    ObjectPhrase subjPhrase = convertIndividualToObjectPhrase(subj,
        QuantifierType.THE);
    PredicatePhrase objPhrase = convertIndividualToPredicatePhrase(obj,
        PredicateType.VERB, QuantifierType.THE);
    objPhrase.getPredicate().setVerb(verb);
    objPhrase.getPredicate().setType(PredicateType.VERB);
    objPhrase.getPredicate().setPassive(OWLUtils.isInverse(ax.getProperty()));

    SubjectPredicateObject spo = new SubjectPredicateObject();
    spo.setSubject(subjPhrase);
    spo.addObject(objPhrase);

    spoList.add(spo);

    return spoList;
  }

  private List<SubjectPredicateObject> convertNegativeObjectPropertyAssertion(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    OWLNegativeObjectPropertyAssertionAxiom ax = (OWLNegativeObjectPropertyAssertionAxiom) axiom;

    OWLIndividual subj = ax.getSubject();
    OWLIndividual obj = ax.getObject();
    Verb verb = convertObjectPropertyExpression(ax.getProperty());

    ObjectPhrase subjPhrase = convertIndividualToObjectPhrase(subj,
        QuantifierType.THE);
    PredicatePhrase objPhrase = convertIndividualToPredicatePhrase(obj,
        PredicateType.VERB, QuantifierType.THE);
    objPhrase.getPredicate().setVerb(verb);
    objPhrase.getPredicate().setType(PredicateType.VERB);
    objPhrase.getPredicate().setNegative(true);
    objPhrase.getPredicate().setPassive(OWLUtils.isInverse(ax.getProperty()));

    SubjectPredicateObject spo = new SubjectPredicateObject();
    spo.setSubject(subjPhrase);
    spo.addObject(objPhrase);

    spoList.add(spo);

    return spoList;
  }

  private List<SubjectPredicateObject> convertDataPropertyAssertion(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDataPropertyAssertionAxiom ax = (OWLDataPropertyAssertionAxiom) axiom;
    // TODO
    LOGGER.warn("OWLDataPropertyAssertionAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertNegativeDataPropertyAssertion(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLNegativeDataPropertyAssertionAxiom ax =
    // (OWLNegativeDataPropertyAssertionAxiom) axiom;
    // TODO
    LOGGER.warn(
        "OWLNegativeDataPropertyAssertionAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertEquivalentObjectProperties(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLEquivalentObjectPropertiesAxiom ax =
    // (OWLEquivalentObjectPropertiesAxiom) axiom;
    // TODO
    LOGGER
        .warn("OWLEquivalentObjectPropertiesAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertSubObjectProperty(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLSubObjectPropertyOfAxiom ax = (OWLSubObjectPropertyOfAxiom) axiom;
    // TODO
    LOGGER.warn("OWLSubObjectPropertyOfAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertInverseObjectProperties(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLInverseObjectPropertiesAxiom ax = (OWLInverseObjectPropertiesAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLInverseObjectPropertiesAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertFunctionalObjectProperty(
      OWLAxiom axiom) {
    OWLFunctionalObjectPropertyAxiom ax = (OWLFunctionalObjectPropertyAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertInverseFunctionalObjectProperty(
      OWLAxiom axiom) {
    OWLInverseFunctionalObjectPropertyAxiom ax = (OWLInverseFunctionalObjectPropertyAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertSymmetricObjectProperty(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLSymmetricObjectPropertyAxiom ax = (OWLSymmetricObjectPropertyAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLSymmetricObjectPropertyAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertAsymmetricObjectProperty(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLAsymmetricObjectPropertyAxiom ax = (OWLAsymmetricObjectPropertyAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLAsymmetricObjectPropertyAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertTransitiveObjectProperty(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLTransitiveObjectPropertyAxiom ax = (OWLTransitiveObjectPropertyAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLTransitiveObjectPropertyAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertReflexiveObjectProperty(
      OWLAxiom axiom) {
    OWLReflexiveObjectPropertyAxiom ax = (OWLReflexiveObjectPropertyAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertIrreflexiveObjectProperty(
      OWLAxiom axiom) {
    OWLIrreflexiveObjectPropertyAxiom ax = (OWLIrreflexiveObjectPropertyAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertObjectPropertyDomain(
      OWLAxiom axiom) {
    OWLObjectPropertyDomainAxiom ax = (OWLObjectPropertyDomainAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertObjectPropertyRange(
      OWLAxiom axiom) {
    OWLObjectPropertyRangeAxiom ax = (OWLObjectPropertyRangeAxiom) axiom;
    // rewrite as subclass axiom
    OWLSubClassOfAxiom sub = ax.asOWLSubClassOfAxiom();
    return convertSubclassOf(sub);
  }

  private List<SubjectPredicateObject> convertDisjointObjectProperties(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDisjointObjectPropertiesAxiom ax = (OWLDisjointObjectPropertiesAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLDisjointObjectPropertiesAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertSubPropertyChainOf(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLSubPropertyChainOfAxiom ax = (OWLSubPropertyChainOfAxiom) axiom;
    // TODO
    LOGGER.warn("OWLSubPropertyChainOfAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertEquivalentDataProperties(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLEquivalentDataPropertiesAxiom ax = (OWLEquivalentDataPropertiesAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLEquivalentDataPropertiesAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertSubDataProperty(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLSubDataPropertyOfAxiom ax = (OWLSubDataPropertyOfAxiom) axiom;
    // TODO
    LOGGER.warn("OWLSubDataPropertyOfAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertFunctionalDataProperty(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLFunctionalDataPropertyAxiom ax = (OWLFunctionalDataPropertyAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLFunctionalDataPropertyAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertDataPropertyDomain(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDataPropertyDomainAxiom ax = (OWLDataPropertyDomainAxiom) axiom;
    // TODO
    LOGGER.warn("OWLDataPropertyDomainAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertDataPropertyRange(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDataPropertyRangeAxiom ax = (OWLDataPropertyRangeAxiom) axiom;
    // TODO
    LOGGER.warn("OWLDataPropertyRangeAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertDisjointDataProperties(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDisjointDataPropertiesAxiom ax = (OWLDisjointDataPropertiesAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLDisjointDataPropertiesAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertDatatypeDefinition(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLDatatypeDefinitionAxiom ax = (OWLDatatypeDefinitionAxiom) axiom;
    // TODO
    LOGGER.warn("OWLDatatypeDefinitionAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertHasKey(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLHasKeyAxiom ax = (OWLHasKeyAxiom) axiom;
    // TODO
    LOGGER.warn("OWLHasKeyAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertSwrlRule(OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // SWRLRule ax = (SWRLRule) axiom;
    // TODO
    LOGGER.warn("SWRLRule not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertAnnotationAssertion(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLAnnotationAssertionAxiom ax = (OWLAnnotationAssertionAxiom) axiom;
    // TODO
    LOGGER.warn("OWLAnnotationAssertionAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertSubAnnotationPropertyOf(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLSubAnnotationPropertyOfAxiom ax = (OWLSubAnnotationPropertyOfAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLSubAnnotationPropertyOfAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertAnnotationPropertyRange(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLAnnotationPropertyRangeAxiom ax = (OWLAnnotationPropertyRangeAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLAnnotationPropertyRangeAxiom not yet supported:" + axiom);
    return spoList;
  }

  private List<SubjectPredicateObject> convertAnnotationPropertyDomain(
      OWLAxiom axiom) {
    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();
    // OWLAnnotationPropertyDomainAxiom ax = (OWLAnnotationPropertyDomainAxiom)
    // axiom;
    // TODO
    LOGGER.warn("OWLAnnotationPropertyDomainAxiom not yet supported:" + axiom);
    return spoList;
  }

  // Annotation Property to Verb
  private Verb convertAnnotationProperty(OWLAnnotationProperty prop) {

    String propWord = OWLUtils.getIRIShortform(prop.getIRI());
    String vocab = OWLUtils.getIRINamespace(prop.getIRI());

    Verb wrd = new Verb(propWord, "V", vocab);
    return wrd;
  }

  // Class to Noun (includes adjectives, mass nouns, and things)
  private Phrase convertClass(OWLClass cl) {

    if (cl.isTopEntity()) {
      Thing wrd = new Thing();
      return wrd;
    }

    if (cl.isBottomEntity()) {
      Thing wrd = new Thing();
      wrd.getQuantifier().setNegative(true);
      return wrd;
    }

    String entityWord = OWLUtils.getIRIShortform(cl.getIRI());
    String vocab = OWLUtils.getIRINamespace(cl.getIRI());

    if (OWLUtils.isAdjective(cl)) {
      Adjective adj = new Adjective(entityWord.replaceFirst("_thing$", ""),
          "JJ", vocab, false);
      return adj;
    }

    if (OWLUtils.isMass(cl)) {
      MassNoun mass = new MassNoun(entityWord.replaceFirst("_mass$", ""), "NN",
          vocab, false);
      return mass;
    }

    Noun wrd = new Noun(entityWord, "NN", vocab, false);
    return wrd;
  }

  // most general ClassExpression to Phrase
  private Phrase convertClassExpression(OWLClassExpression ce) {

    ClassExpressionType type = ce.getClassExpressionType();

    if (type == ClassExpressionType.OWL_CLASS) {
      return convertClass((OWLClass) ce);
    }

    if (type == ClassExpressionType.OBJECT_COMPLEMENT_OF) {
      return convertObjectComplementOf((OWLObjectComplementOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_UNION_OF) {
      return convertObjectUnionOf((OWLObjectUnionOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_INTERSECTION_OF) {
      return convertObjectIntersectionOf((OWLObjectIntersectionOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_ONE_OF) {
      return convertObjectOneOf((OWLObjectOneOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_ALL_VALUES_FROM) {
      return convertObjectAllValuesFrom((OWLObjectAllValuesFrom) ce);
    }

    if (type == ClassExpressionType.OBJECT_SOME_VALUES_FROM) {
      return convertObjectSomeValuesFrom((OWLObjectSomeValuesFrom) ce);
    }

    if (type == ClassExpressionType.OBJECT_HAS_VALUE) {
      return convertObjectHasValue((OWLObjectHasValue) ce);
    }

    if (type == ClassExpressionType.OBJECT_EXACT_CARDINALITY) {
      return convertObjectExactCardinality((OWLObjectExactCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_MAX_CARDINALITY) {
      return convertObjectMaxCardinality((OWLObjectMaxCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_MIN_CARDINALITY) {
      return convertObjectMinCardinality((OWLObjectMinCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_HAS_SELF) {
      return convertObjectHasSelf((OWLObjectHasSelf) ce);
    }

    if (type == ClassExpressionType.DATA_HAS_VALUE) {
      return convertDataHasValue((OWLDataHasValue) ce);
    }

    if (type == ClassExpressionType.DATA_ALL_VALUES_FROM) {
      return convertDataAllValuesFrom((OWLDataAllValuesFrom) ce);
    }

    if (type == ClassExpressionType.DATA_SOME_VALUES_FROM) {
      return convertDataSomeValuesFrom((OWLDataSomeValuesFrom) ce);
    }

    if (type == ClassExpressionType.DATA_EXACT_CARDINALITY) {
      return convertDataExactCardinality((OWLDataExactCardinality) ce);
    }

    if (type == ClassExpressionType.DATA_MAX_CARDINALITY) {
      return convertDataMaxCardinality((OWLDataMaxCardinality) ce);
    }

    if (type == ClassExpressionType.DATA_MIN_CARDINALITY) {
      return convertDataMinCardinality((OWLDataMinCardinality) ce);
    }

    // should never happen
    return null;

  }

  // data property to Verb
  private Verb convertDataProperty(OWLDataProperty prop) {
    String propWord = OWLUtils.getIRIShortform(prop.getIRI());
    String vocab = OWLUtils.getIRINamespace(prop.getIRI());

    Verb wrd = new Verb(propWord, "V", vocab);
    return wrd;
  }

  // Datatype to Noun (TBD)
  private Noun convertDatatype(OWLDatatype dt) {
    LOGGER.warn("Converting OWL Datatypes not yet supported:" + dt);
    return null;
  }

  // Literal to Noun (TBD)
  private Noun convertLiteral(OWLLiteral literal) {
    LOGGER.warn("Converting OWL Literals not yet supported:" + literal);
    return null;
  }

  // individual to Proper
  private Proper convertIndividual(OWLIndividual ind) {
    if (ind.isNamed()) {
      return convertNamedIndividual((OWLNamedIndividual) ind);
    }
    return convertAnonymousIndividual((OWLAnonymousIndividual) ind);

  }

  // named individual to Proper
  private Proper convertNamedIndividual(OWLNamedIndividual ind) {

    OWLNamedIndividual nInd = (OWLNamedIndividual) ind;

    String propWord = OWLUtils.getIRIShortform(nInd.getIRI());
    String vocab = OWLUtils.getIRINamespace(nInd.getIRI());

    Proper wrd = new Proper(propWord, "NP", vocab, false);
    return wrd;

  }

  // anonymous individual to Proper
  private Proper convertAnonymousIndividual(OWLAnonymousIndividual ind) {

    // TODO what is naming pattern for anonymous individuals?

    String propWord = "THING" + ind.getID().getID();

    Proper wrd = new Proper(propWord, "NP", DEFAULT_NAMESPACE, false);
    return wrd;

  }

  // object property to verb
  private Verb convertObjectProperty(OWLObjectProperty prop) {
    // always use named property even if inverse

    String propWord = OWLUtils
        .getIRIShortform(prop.getNamedProperty().getIRI());
    String vocab = OWLUtils.getIRINamespace(prop.getNamedProperty().getIRI());

    // TODO other coding conventions? CamelCase etc
    String[] pieces = propWord.split("_");

    String aux = "";
    String base = "";
    String part = "";

    // assume plain verb
    if (pieces.length == 1) {
      base = pieces[0];
    }

    // assume verb_particle
    if (pieces.length == 2) {
      base = pieces[0];
      part = pieces[1];
    }

    // assume aux_verb_particle
    if (pieces.length == 3) {

      aux = pieces[0];
      base = pieces[1];
      part = pieces[2];
    }

    if (pieces.length > 3) {
      // more than 3 parts, don't treat as particle verb
      LOGGER.error("Particle verb? with more that three parts:" + propWord);
      base = propWord;
    }

    Verb vrb = new Verb(base, "V", vocab);
    if (!aux.isEmpty()) {
      vrb.setAuxiliary(aux);
    }

    if (!part.isEmpty()) {
      vrb.setParticle(part);
    }

    return vrb;
  }

  // Object propert expression to Verb
  private Verb convertObjectPropertyExpression(
      OWLObjectPropertyExpression prop) {
    return convertObjectProperty(prop.getNamedProperty());
  }

  private Phrase convertObjectComplementOf(OWLObjectComplementOf ce) {
    Phrase phrase = convertClassExpression(ce.getOperand());

    // apply negative to object
    if (phrase.getPhraseType() == PhraseType.PREDICATEPHRASE) {
      PredicatePhrase predPhrase = (PredicatePhrase) phrase;
      predPhrase.getPredicate().setNegative(true);
      return predPhrase;
    }

    // distributed negative to all members and flip operator
    if (phrase.getPhraseType() == PhraseType.PHRASESET) {
      PhraseSet phraseSet = (PhraseSet) phrase;
      phraseSet.setIntersection(!phraseSet.isIntersection());
      for (Phrase ph : phraseSet.getPhrases()) {

        // apply negative to object
        if (ph.getPhraseType() == PhraseType.PREDICATEPHRASE) {
          PredicatePhrase predPhrase = (PredicatePhrase) ph;
          predPhrase.getPredicate().setNegative(true);
        } else {
          ObjectPhrase objPhrase = (ObjectPhrase) ph;
          objPhrase.getQuantifier().setNegative(true);
        }

      }

      return phraseSet;
    }

    ObjectPhrase objPhrase = (ObjectPhrase) phrase;
    objPhrase.getQuantifier().setNegative(true);
    return objPhrase;

  }

  private ObjectPhrase convertObjectUnionOf(OWLObjectUnionOf ce) {

    if (ce.getOperandsAsList().size() == 1) {
      Phrase tmpPhrase = convertClassExpression(ce.getOperandsAsList().get(0));
      return OWLUtils.wrapRelativeThing(tmpPhrase);
    }

    PhraseSet phSet = new PhraseSet();
    phSet.setIntersection(false);
    for (OWLClassExpression member : ce.getOperandsAsList()) {
      Phrase tmpPhrase = convertClassExpression(member);
      phSet.addPhrase((tmpPhrase));
      // phSet.addPhrase(OWLUtils.wrapRelativeThing(tmpPhrase));
    }

    return phSet;
  }

  private Phrase convertObjectIntersectionOf(OWLObjectIntersectionOf ce) {

    List<OWLClassExpression> members = ce.getOperandsAsList();

    // just a single wrapped in an intersection
    if (members.size() == 1) {
      return convertClassExpression(members.get(0));
    }

    // all the phrases organized by phrase type
    Map<PhraseType, List<Phrase>> phraseMap = new HashMap<PhraseType, List<Phrase>>();

    // convert all set members to phrases and populate map by phrasetype
    for (OWLClassExpression member : members) {
      Phrase tmpPhrase = convertClassExpression(member);
      PhraseType typ = tmpPhrase.getPhraseType();

      if (!phraseMap.containsKey(typ)) {
        phraseMap.put(typ, new ArrayList<Phrase>());
      }
      // add to map
      phraseMap.get(typ).add(tmpPhrase);

    }

    // check for different combos of phrases and convert accordingly

    boolean hasNoun = phraseMap.containsKey(PhraseType.NOUN);
    boolean hasMassNoun = phraseMap.containsKey(PhraseType.MASSNOUN);
    boolean hasThing = phraseMap.containsKey(PhraseType.THING);
    boolean hasNounPhrase = phraseMap.containsKey(PhraseType.NOUNPHRASE);
    boolean hasAdj = phraseMap.containsKey(PhraseType.ADJECTIVE);
    boolean hasPred = phraseMap.containsKey(PhraseType.PREDICATEPHRASE);
    boolean hasProper = phraseMap.containsKey(PhraseType.PROPER);

    int numType = phraseMap.keySet().size();

    // if 1 noun + 1,n adj/proper and nothing else-> nounphrase
    if (hasNoun && (hasAdj || hasProper) && numType == 2
        && phraseMap.get(PhraseType.NOUN).size() == 1) {
      NounPhrase nPhrase = new NounPhrase();

      nPhrase.setHead((Noun) phraseMap.get(PhraseType.NOUN).get(0));

      if (phraseMap.get(PhraseType.ADJECTIVE) != null) {
        for (Phrase adj : phraseMap.get(PhraseType.ADJECTIVE)) {
          nPhrase.addModifier((Adjective) adj);
        }
      }
      if (phraseMap.get(PhraseType.PROPER) != null) {
        for (Phrase prop : phraseMap.get(PhraseType.PROPER)) {
          nPhrase.addModifier((Proper) prop);
        }
      }

      return nPhrase;
    }

    // if 1 massnoun + 1,n adj and nothing else-> nounphrase
    if (hasMassNoun && hasAdj && numType == 2
        && phraseMap.get(PhraseType.MASSNOUN).size() == 1) {
      NounPhrase nPhrase = new NounPhrase();

      nPhrase.setHead((MassNoun) phraseMap.get(PhraseType.MASSNOUN).get(0));
      for (Phrase adj : phraseMap.get(PhraseType.ADJECTIVE)) {
        nPhrase.addModifier((Adjective) adj);
      }
      return nPhrase;
    }

    // if 1 Thing + 1,n adj and nothing else-> nounphrase
    if (hasThing && hasAdj && numType == 2
        && phraseMap.get(PhraseType.THING).size() == 1) {
      NounPhrase nPhrase = new NounPhrase();

      nPhrase.setHead((Thing) phraseMap.get(PhraseType.THING).get(0));
      for (Phrase adj : phraseMap.get(PhraseType.ADJECTIVE)) {
        nPhrase.addModifier((Adjective) adj);
      }
      return nPhrase;
    }

    // if 1 noun/nounphrase + 1 predicate phrase and nothing else - > nounphrase
    // with relative clause
    if (numType == 2 && (hasNoun || hasMassNoun || hasThing || hasNounPhrase)
        && hasPred && phraseMap.get(PhraseType.PREDICATEPHRASE).size() == 1) {

      PredicatePhrase pred = (PredicatePhrase) phraseMap
          .get(PhraseType.PREDICATEPHRASE).get(0);

      if (hasNoun) {
        Noun n = (Noun) phraseMap.get(PhraseType.NOUN).get(0);
        n.addRelativePhrases(pred);
        return n;
      }

      if (hasThing) {
        Thing t = (Thing) phraseMap.get(PhraseType.THING).get(0);
        t.addRelativePhrases(pred);
        return t;
      }

      if (hasMassNoun) {
        MassNoun n = (MassNoun) phraseMap.get(PhraseType.MASSNOUN).get(0);
        n.addRelativePhrases(pred);
        return n;
      }

      if (hasNounPhrase) {
        NounPhrase n = (NounPhrase) phraseMap.get(PhraseType.NOUNPHRASE).get(0);
        n.addRelativePhrases(pred);
        return n;
      }

    }

    // everything else -> phraseSet
    PhraseSet phSet = new PhraseSet();
    phSet.setIntersection(true);

    for (List<Phrase> phraseList : phraseMap.values()) {
      for (Phrase ph : phraseList) {
        phSet.addPhrase(ph);
      }
    }

    return phSet;
  }

  private ObjectPhrase convertObjectOneOf(OWLObjectOneOf ce) {

    PhraseSet phSet = new PhraseSet();
    phSet.setIntersection(false);

    List<OWLIndividual> indList = OWLAPIStreamUtils.asList(ce.individuals());

    if (indList.size() == 1) {
      Proper ind = this.convertIndividual(indList.get(0));
      return ind;
    }

    for (OWLIndividual member : indList) {
      Proper tmpPhrase = this.convertIndividual(member);
      phSet.addPhrase(tmpPhrase);
    }

    return phSet;
  }

  private PredicatePhrase convertObjectAllValuesFrom(
      OWLObjectAllValuesFrom ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setExclusive(true);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Phrase phrase = convertClassExpression(objCE);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertObjectSomeValuesFrom(
      OWLObjectSomeValuesFrom ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Phrase phrase = convertClassExpression(objCE);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertObjectHasValue(OWLObjectHasValue ce) {

    // get CE components
    OWLIndividual objInd = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Proper phrase = this.convertIndividual(objInd);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;

  }

  private PredicatePhrase convertObjectExactCardinality(
      OWLObjectExactCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Phrase phrase = convertClassExpression(objCE);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // create and set numeric quantifier
    Quantifier q = objPhrase.getQuantifier();
    q.setQuantifierType(QuantifierType.NUMERIC);
    q.setNumericType(NumericQuantifierType.EXACT);
    q.setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertObjectMaxCardinality(
      OWLObjectMaxCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Phrase phrase = convertClassExpression(objCE);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // create and set numeric quantifier
    Quantifier q = objPhrase.getQuantifier();
    q.setQuantifierType(QuantifierType.NUMERIC);
    q.setNumericType(NumericQuantifierType.LESS_THAN_OR_EQUAL);
    q.setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertObjectMinCardinality(
      OWLObjectMinCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);
    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Phrase phrase = convertClassExpression(objCE);
    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(phrase);

    // create and set numeric quantifier
    Quantifier q = objPhrase.getQuantifier();
    q.setQuantifierType(QuantifierType.NUMERIC);
    q.setNumericType(NumericQuantifierType.MORE_THAN_OR_EQUAL);
    q.setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertObjectHasSelf(OWLObjectHasSelf ce) {

    // get CE components
    // OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.VERB);

    pred.setVerb(this.convertObjectPropertyExpression(prop));
    pred.setPassive(OWLUtils.isInverse(prop));

    // create and possible convert to relative clause
    Noun itself = new Noun("itself", "NN", "", false);

    ObjectPhrase objPhrase = OWLUtils.wrapRelativeThing(itself);

    // assemble predicate phrase
    PredicatePhrase predPhrase = new PredicatePhrase();
    predPhrase.setPredicate(pred);
    predPhrase.setObject(objPhrase);

    return predPhrase;
  }

  private PredicatePhrase convertDataHasValue(OWLDataHasValue ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PredicatePhrase convertDataAllValuesFrom(OWLDataAllValuesFrom ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PredicatePhrase convertDataSomeValuesFrom(OWLDataSomeValuesFrom ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PredicatePhrase convertDataExactCardinality(
      OWLDataExactCardinality ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PredicatePhrase convertDataMaxCardinality(OWLDataMaxCardinality ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PredicatePhrase convertDataMinCardinality(OWLDataMinCardinality ce) {
    // TODO Auto-generated method stub
    return null;
  }

  private PhraseSet convertObjectClassExp(OWLClassExpression ce,
      PredicateType ptype, QuantifierType qt) {

    Phrase phrase = convertClassExpression(ce);

    PhraseSet phrases = new PhraseSet();

    if (phrase == null) {
      return phrases;
    }

    if (phrase.getPhraseType() == PhraseType.PHRASESET) {
      PhraseSet pSet = (PhraseSet) phrase;
      phrases.setIntersection(pSet.isIntersection());

      for (Phrase ph : pSet.getPhrases()) {
        PredicatePhrase p = OWLUtils.pushDownObject(ph, ptype, qt);
        phrases.addPhrase(p);
      }

      return phrases;
    }

    PredicatePhrase p = OWLUtils.pushDownObject(phrase, ptype, qt);
    phrases.addPhrase(p);

    return phrases;
  }

  private ObjectPhrase convertSubjectClassExp(OWLClassExpression ce,
      QuantifierType qt) {
    Phrase phrase = convertClassExpression(ce);

    ObjectPhrase wrapped = OWLUtils.wrapRelativeThing(phrase);
    wrapped.getQuantifier().setQuantifierType(qt);

    return wrapped;
  }

  private ObjectPhrase convertIndividualToObjectPhrase(OWLIndividual ind,
      QuantifierType qt) {
    Proper indObj = convertIndividual(ind);
    indObj.getQuantifier().setQuantifierType(qt);
    return indObj;
  }

  private PredicatePhrase convertIndividualToPredicatePhrase(OWLIndividual ind,
      PredicateType ptype, QuantifierType qt) {
    Proper indObj = convertIndividual(ind);
    indObj.getQuantifier().setQuantifierType(qt);

    PredicatePhrase predPhrase = new PredicatePhrase();
    Predicate pred = predPhrase.getPredicate();
    pred.setType(ptype);
    predPhrase.setObject(indObj);
    return predPhrase;

  }

}
