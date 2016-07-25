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
package org.opensextant.howler.convertors;

import java.util.HashSet;
import java.util.List;
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
import org.opensextant.howler.spo.What;
import org.opensextant.howler.spo.Word;
import org.opensextant.howler.utils.OWLUtils;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class SPOConverterOWL.
 */
public class SPOConverterOWL {

  /** The  LOGGER. */
  private static final Logger LOGGER = LoggerFactory
      .getLogger(SPOConverterOWL.class);

  /** The owl factory used to create ontology elements  */
  OWLDataFactory owlFactory;
  
  /** used to manage (create, remove, add to) the ontologies */
  OWLOntologyManager mgr;

  /**
   * Instantiates a new SPO converter OWL.
   */
  public SPOConverterOWL() {
    // create OWLAPI manager and factory
    mgr = OWLManager.createOWLOntologyManager();
    owlFactory = mgr.getOWLDataFactory();
  }

  /**
   * Creates the ontology.
   *
   * @param doc
   *          the doc
   * @return the OWL ontology
   */
  public OWLOntology createOntology(Document doc) {

    List<OWLOntology> existing = OWLAPIStreamUtils.asList(mgr.ontologies());

    for (OWLOntology ex : existing) {
      mgr.removeOntology(ex);
    }

    OWLOntology onto = null;

    // create empty ontology
    try {
      IRI iri = IRI.create(doc.getTitle());
      onto = mgr.createOntology(iri);
    } catch (OWLOntologyCreationException e) {
      LOGGER.error("Unable to create ontology:" + e.getMessage());
      return null;
    }

    for (SubjectPredicateObject spo : doc.getSentences()) {
      // do the conversion
      OWLAxiom ax = createAxiom(spo);
      try {
        mgr.addAxiom(onto, ax);
      } catch (Exception e) {
        LOGGER.error("Unable to add axiom to ontology, " + e.getMessage());
        continue;
      }
    }
    return onto;
  }

  /**
   * Creates the axiom.
   *
   * @param spo
   *          the spo
   * @return the OWL axiom
   */
  public OWLAxiom createAxiom(SubjectPredicateObject spo) {

    SubjectPredicateObject spoModified = OWLUtils.rewriteSPO(spo);

    ObjectPhrase subjPhrase = spoModified.getSubject();
    PhraseSet objPhrases = spoModified.getObjects();

    // if only one object, simplify to single predicate phrase
    if (objPhrases.getPhrases().size() == 1) {

      PredicatePhrase objPhrase = OWLUtils.pushDownObject(
          objPhrases.getPhrases().get(0), PredicateType.IS,
          QuantifierType.EVERY);

      Predicate pred = objPhrase.getPredicate();

      boolean isProperSubj = OWLUtils.isProper(subjPhrase);
      boolean isProperObj = OWLUtils.isProper(objPhrase.getObject());
      boolean isExclusivePred = pred.isExclusive();

      // if exclusive and propers must interpret as class expressions

      if (isExclusivePred && isProperSubj && isProperObj) {
        isProperSubj = false;
        isProperObj = false;
      }

      OWLAxiom ax = null;

      // Common and Common
      if (!isProperSubj && !isProperObj) {
        OWLClassExpression subj = convert(subjPhrase);
        OWLClassExpression obj = convert(objPhrase);
        ax = createAxiom(subj, pred, obj);
      }

      // Common and Proper
      if (!isProperSubj && isProperObj) {
        if (pred.isPassive()) {
          OWLClassExpression subj = convert(subjPhrase);
          OWLClassExpression obj = convert(objPhrase);
          ax = createAxiom(subj, pred, obj);
        } else {
          OWLClassExpression subj = convert(subjPhrase);
          OWLClassExpression obj = convert(objPhrase);
          ax = createAxiom(subj, pred, obj);
        }

      }

      // Proper and Common
      if (isProperSubj && !isProperObj) {
        OWLIndividual subj = convertProperPhrase(subjPhrase);
        OWLClassExpression obj = convert(objPhrase);
        ax = createAxiom(subj, pred, obj);
      }

      // Proper and Proper
      if (isProperSubj && isProperObj) {
        OWLIndividual subj = convertProperPhrase(subjPhrase);
        OWLIndividual obj = convertProperPhrase(objPhrase);
        ax = createAxiom(subj, pred, obj);
      }

      if (ax == null) {
        LOGGER
            .error("Expected some combination of common and proper phrases for "
                + spo);
      }

      return ax;
    }

    boolean properSubj = OWLUtils.isProper(subjPhrase);
    OWLAxiom ax = null;
    Predicate dummy = new Predicate();
    if (properSubj) {

      OWLIndividual subj = convertProperPhrase(subjPhrase);
      OWLClassExpression obj = convert(objPhrases);

      ax = createAxiom(subj, dummy, obj);
    } else {

      OWLClassExpression subj = convert(subjPhrase);
      OWLClassExpression obj = convert(objPhrases);
      ax = createAxiom(subj, dummy, obj);
    }

    return ax;

  }

  /**
   * Creates the axiom.
   *
   * @param subj
   *          the subj
   * @param pred
   *          the pred
   * @param obj
   *          the obj
   * @return the OWL axiom
   */
  private OWLAxiom createAxiom(OWLClassExpression subj, Predicate pred,
      OWLClassExpression obj) {

    PredicateType predType = pred.getType();

    if (predType == PredicateType.IS) {

      if (pred.isExclusive()) {
        // a class and a union -> disjoint union
        if (subj.getClassExpressionType() == ClassExpressionType.OWL_CLASS
            && obj.asDisjunctSet().size() > 1) {
          return owlFactory.getOWLDisjointUnionAxiom((OWLClass) subj,
              obj.asDisjunctSet());
        } else {
          LOGGER
              .warn("Exclusive predicate but not expressible as Disjoint union"
                  + subj + "\t" + pred + "\t" + obj);
          return owlFactory.getOWLSubClassOfAxiom(subj, obj);
        }
      } else {
        return owlFactory.getOWLSubClassOfAxiom(subj, obj);
      }

    }

    if (predType == PredicateType.IS_SAME_AS) {

      if (pred.isExclusive()) {
        LOGGER.warn("Exclusive SAME AS predicate Ignoring exclusive");
      }

      if (pred.isNegative()) {
        OWLDisjointClassesAxiom ax = owlFactory.getOWLDisjointClassesAxiom(subj,
            obj);
        return ax;
      }

      OWLEquivalentClassesAxiom ax = owlFactory
          .getOWLEquivalentClassesAxiom(subj, obj);
      return ax;
    }

    if (predType == PredicateType.VERB) {
      OWLSubClassOfAxiom ax = owlFactory.getOWLSubClassOfAxiom(subj, obj);
      return ax;
    }

    LOGGER
        .error("Fell through all Predicate Types. Predicate Type=" + predType);
    return null;

  }

  /**
   * Creates the axiom.
   *
   * @param subj
   *          the subj
   * @param pred
   *          the pred
   * @param obj
   *          the obj
   * @return the OWL axiom
   */
  private OWLAxiom createAxiom(OWLIndividual subj, Predicate pred,
      OWLClassExpression obj) {
    OWLClassAssertionAxiom ax = owlFactory.getOWLClassAssertionAxiom(obj, subj);
    return ax;
  }

  /**
   * Creates the axiom.
   *
   * @param subj
   *          the subj
   * @param pred
   *          the pred
   * @param obj
   *          the obj
   * @return the OWL axiom
   */
  /*
   * private OWLAxiom createAxiom(OWLClassExpression subj, Predicate pred,
   * OWLIndividual obj) {
   * 
   * if(pred.isPassive()){ return createAxiom(obj, pred, subj); }else{ // flip
   * predicate passive and reverse sub and obj pred.setPassive(false); return
   * createAxiom(obj, pred, subj); }
   * 
   * }
   */
  private OWLAxiom createAxiom(OWLIndividual subj, Predicate pred,
      OWLIndividual obj) {

    PredicateType predType = pred.getType();

    if (predType == PredicateType.IS || predType == PredicateType.IS_SAME_AS) {
      if (pred.isNegative()) {
        OWLDifferentIndividualsAxiom ax = owlFactory
            .getOWLDifferentIndividualsAxiom(subj, obj);
        return ax;
      }

      OWLSameIndividualAxiom ax = owlFactory.getOWLSameIndividualAxiom(subj,
          obj);

      return ax;
    }

    if (predType == PredicateType.VERB) {

      OWLObjectProperty prop = convert(pred.getVerb());

      // if passive flip direction of relation
      OWLObjectPropertyExpression propE = prop;
      if (pred.isPassive()) {
        propE = owlFactory.getOWLObjectInverseOf(prop);
      }

      if (pred.isNegative()) {
        OWLNegativeObjectPropertyAssertionAxiom ax = owlFactory
            .getOWLNegativeObjectPropertyAssertionAxiom(propE, subj, obj);

        return ax;
      }

      OWLObjectPropertyAssertionAxiom ax = owlFactory
          .getOWLObjectPropertyAssertionAxiom(propE, subj, obj);

      return ax;
    }

    LOGGER.error(
        "Tried to create axiom with unrecognized Predicate type:" + predType);
    return null;
  }

  // ------------- Phrase to OWL conversions -------------

  /**
   * Convert.
   *
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // Most general Phrase to ClassExpression
  private OWLClassExpression convert(Phrase phrase) {

    PhraseType type = phrase.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      return convert((Adjective) phrase);
    }
    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) phrase);
    }
    if (type == PhraseType.NOUN) {
      return convert((Noun) phrase);
    }
    if (type == PhraseType.NOUNPHRASE) {
      return convert((NounPhrase) phrase);
    }
    if (type == PhraseType.OBJECTPHRASE) {
      return convert((ObjectPhrase) phrase);
    }
    if (type == PhraseType.PHRASESET) {
      return convert((PhraseSet) phrase);
    }
    if (type == PhraseType.PREDICATEPHRASE) {
      return convert((PredicatePhrase) phrase);
    }
    if (type == PhraseType.THING) {
      return convert((Thing) phrase);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) phrase);
    }

    if (type == PhraseType.WORD) {
      return convert((Word) phrase);
    }
    if (type == PhraseType.PROPER) {
      return convert((Noun) phrase);
    }

    if (type == PhraseType.VERB) {
      LOGGER.warn("Couldn't convert Verb to OWL Class Expression:" + phrase);
      return owlFactory.getOWLThing();
    }

    LOGGER.warn("Fell through all phrase types. Couldn't convert: " + phrase);
    return owlFactory.getOWLThing();
  }

  /**
   * Convert.
   *
   * @param adj
   *          the adj
   * @return the OWL class expression
   */
  // Adjective to ClassExpression
  private OWLClassExpression convert(Adjective adj) {

    IRI iri = IRI.create(adj.getVocabulary(), adj.getLogicalForm() + "_thing");

    OWLClassExpression core = owlFactory.getOWLClass(iri);

    return applyRelativePhrases(core, adj);
  }

  /**
   * Convert.
   *
   * @param mass
   *          the mass
   * @return the OWL class expression
   */
  // Mass noun to ClassExpression
  private OWLClassExpression convert(MassNoun mass) {

    IRI iri = IRI.create(mass.getVocabulary(), mass.getLogicalForm() + "_mass");

    OWLClassExpression core = owlFactory.getOWLClass(iri);

    return applyRelativePhrases(core, mass);
  }

  /**
   * Convert.
   *
   * @param noun
   *          the noun
   * @return the OWL class expression
   */
  // Noun to ClassExpression
  private OWLClassExpression convert(Noun noun) {

    PhraseType phType = noun.getPhraseType();

    if (phType == PhraseType.THING) {
      return convert((Thing) noun);
    }

    if (phType == PhraseType.MASSNOUN) {
      return convert((MassNoun) noun);
    }

    if (phType == PhraseType.ADJECTIVE) {
      return convert((Adjective) noun);
    }

    if (phType == PhraseType.WHAT) {
      return convert((What) noun);
    }

    if (phType == PhraseType.NOUN) {
      IRI iri = IRI.create(noun.getVocabulary(), noun.getLogicalForm());
      OWLClassExpression core = owlFactory.getOWLClass(iri);

      return applyRelativePhrases(core, noun);
    }

    if (phType == PhraseType.PROPER) {
      OWLNamedIndividual ind = convert((Proper) noun);
      return applyRelativePhrases(owlFactory.getOWLObjectOneOf(ind), noun);
    }

    // fell through all types
    LOGGER.warn("Couldn't convert Noun to OWL Class, Unknown noun type" + noun);
    return owlFactory.getOWLThing();

  }

  /**
   * Convert.
   *
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // noun Phrase to ClassExpression
  private OWLClassExpression convert(NounPhrase phrase) {

    OWLClassExpression h = convert(phrase.getHead());

    Set<OWLClassExpression> mods = new HashSet<OWLClassExpression>();
    for (Noun mod : phrase.getModifiers()) {
      mods.add(convert(mod));
    }

    OWLClassExpression core;

    // if no modifiers
    if (mods.isEmpty()) {
      core = h;
    } else {
      // intersection of head and modifiers
      mods.add(h);
      core = owlFactory.getOWLObjectIntersectionOf(mods);
    }

    return applyRelativePhrases(core, phrase);
  }

  /**
   * Convert.
   *
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // Object phrase to ClassExpression
  private OWLClassExpression convert(ObjectPhrase phrase) {

    PhraseType phType = phrase.getPhraseType();

    if (phType == PhraseType.ADJECTIVE) {
      Adjective tmp = (Adjective) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.NOUN) {
      Noun tmp = (Noun) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.THING) {
      Thing tmp = (Thing) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.MASSNOUN) {
      MassNoun tmp = (MassNoun) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.PROPER) {
      Proper tmp = (Proper) phrase;
      // must wrap individual with OneOf
      return applyRelativePhrases(owlFactory.getOWLObjectOneOf(convert(tmp)),
          tmp);
    }

    if (phType == PhraseType.NOUNPHRASE) {
      NounPhrase tmp = (NounPhrase) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.PHRASESET) {
      PhraseSet tmp = (PhraseSet) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.WORD) {
      Word tmp = (Word) phrase;
      return convert(tmp);
    }

    if (phType == PhraseType.WHAT) {
      return convert((What) phrase);
    }

    // shouldn't ever occur
    if (phType == PhraseType.VERB) {
      LOGGER.error("Found a Verb as object Phrase");
      return owlFactory.getOWLThing();
    }

    // shouldn't ever occur
    if (phType == PhraseType.PHRASE) {
      LOGGER.error("Found a generic Phrase as ObjectPhrase");
      return convert((Phrase) phrase);
    }

    // shouldn't ever occur
    LOGGER.error(
        "Fell through all object phrase types, cannot convert " + phrase);
    return owlFactory.getOWLThing();

  }

  /**
   * Convert.
   *
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // Phrase set to ClassExpression
  private OWLClassExpression convert(PhraseSet phrase) {

    if (phrase.getPhrases().size() == 1) {
      return convert(phrase.getPhrases().iterator().next());
    }

    // if union of individuals
    if (phrase.isProperSet() && !phrase.isIntersection()) {

      Set<OWLIndividual> indSet = new HashSet<OWLIndividual>();
      for (Phrase ph : phrase.getPhrases()) {
        indSet.add(convert((Proper) ph));
      }
      return owlFactory.getOWLObjectOneOf(indSet);
    }

    Set<OWLClassExpression> set = new HashSet<OWLClassExpression>();

    for (Phrase ph : phrase.getPhrases()) {
      set.add(convert(ph));
    }

    if (phrase.isIntersection()) {
      return owlFactory.getOWLObjectIntersectionOf(set);
    } else {
      return owlFactory.getOWLObjectUnionOf(set);
    }

  }

  /**
   * Convert.
   *
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // Predicate phrase to ClassExpression
  private OWLClassExpression convert(PredicatePhrase phrase) {

    Predicate pred = phrase.getPredicate();
    ObjectPhrase obj = phrase.getObject();

    // convert core including applying quantifier negative
    OWLClassExpression core = convert(obj);

    // TODO rel clause vs intersection changes here?
    if (pred.getType() == PredicateType.VERB) {
      Quantifier q = obj.getQuantifier();
      return applyQuantifer(core, q, pred);
    }

    // for IS , only negative predicate is relevant
    if (pred.getType() == PredicateType.IS) {
      if (pred.isNegative()) {
        return owlFactory.getOWLObjectComplementOf(core);
      }
      return core;
    }
    // for IS_SAME _AS don't negate object
    if (pred.getType() == PredicateType.IS_SAME_AS) {
      return core;
    }

    LOGGER.warn(
        "Fell through all Predicate types when converting Predicate Phrase");
    return core;

  }

  /**
   * Convert.
   *
   * @param word
   *          the word
   * @return the OWL named individual
   */
  // Proper to individual
  private OWLNamedIndividual convert(Proper word) {

    if (!word.getRelativePhrases().isEmpty()) {
      LOGGER.warn(
          "Tried to convert a Proper with relative clauses, Ignoring them");
    }

    IRI iri = IRI.create(word.getVocabulary(), word.getLogicalForm());
    OWLNamedIndividual ni = owlFactory.getOWLNamedIndividual(iri);
    return ni;
  }

  /**
   * Convert proper phrase.
   *
   * @param phrase
   *          the phrase
   * @return the OWL named individual
   */
  // Proper to individual
  private OWLNamedIndividual convertProperPhrase(Phrase phrase) {

    if (phrase.getPhraseType() == PhraseType.PROPER) {
      return convert((Proper) phrase);
    }

    if (phrase.getPhraseType() == PhraseType.PREDICATEPHRASE) {
      ObjectPhrase obj = ((PredicatePhrase) phrase).getObject();

      if (OWLUtils.isProper(obj)) {
        return convert((Proper) obj);
      }

    }

    LOGGER.error(
        "Tried to convert a non-Proper Phrase to an Individual: " + phrase);
    return null;
  }

  /**
   * Convert.
   *
   * @param word
   *          the word
   * @return the OWL class expression
   */
  // Thing to ClassExpression
  private OWLClassExpression convert(Thing word) {
    return applyRelativePhrases(owlFactory.getOWLThing(), word);
  }

  /**
   * Convert.
   *
   * @param word
   *          the word
   * @return the OWL class expression
   */
  // What to ClassExpression
  private OWLClassExpression convert(What word) {

    IRI iri = IRI.create(word.getVocabulary(), word.getLogicalForm());
    OWLClassExpression core = owlFactory.getOWLClass(iri);

    return applyRelativePhrases(core, word);

  }

  /**
   * Convert.
   *
   * @param verb
   *          the verb
   * @return the OWL object property
   */
  // Verb to Property
  private OWLObjectProperty convert(Verb verb) {

    IRI iri = IRI.create(verb.getVocabulary(), verb.getLogicalForm());
    OWLObjectProperty op = owlFactory.getOWLObjectProperty(iri);
    return op;
  }

  /**
   * Convert.
   *
   * @param word
   *          the word
   * @return the OWL class expression
   */
  // General, Word to ClassExpression
  private OWLClassExpression convert(Word word) {

    PhraseType type = word.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      return convert((Adjective) word);
    }

    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) word);
    }
    if (type == PhraseType.NOUN) {
      return convert((Noun) word);
    }

    if (type == PhraseType.THING) {
      return convert((Thing) word);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) word);
    }

    if (type == PhraseType.PROPER) {
      return convert((Noun) word);
    }

    if (type == PhraseType.VERB) {
      LOGGER.error("Couldn't convert Verb to OWL Class Expression:" + word);
      return owlFactory.getOWLThing();
    }

    LOGGER.error("Fell through all phrase types Couldn't convert: " + word);
    return owlFactory.getOWLThing();

  }

  // apply any relative clauses and negative quantifer of a Phrase to the core
  /**
   * Apply relative phrases.
   *
   * @param core
   *          the core
   * @param phrase
   *          the phrase
   * @return the OWL class expression
   */
  // ClassExpression
  private OWLClassExpression applyRelativePhrases(OWLClassExpression core,
      ObjectPhrase phrase) {

    List<PredicatePhrase> rels = phrase.getRelativePhrases();
    // apply negative quantifier
    if (phrase.getQuantifier().isNegative()) {
      if (core.isOWLThing()) {
        core = owlFactory.getOWLNothing();
      } else {
        core = owlFactory.getOWLObjectComplementOf(core);
      }

    }

    if (!rels.isEmpty()) {

      if (rels.size() == 1) {
        PredicatePhrase single = rels.get(0);
        OWLClassExpression relCE = convert(single);
        if (core.isOWLThing()) {
          core = relCE;
        } else {
          core = owlFactory.getOWLObjectIntersectionOf(core, relCE);
        }

      } else {
        Set<OWLClassExpression> relCEs = new HashSet<OWLClassExpression>();
        for (PredicatePhrase rel : rels) {
          OWLClassExpression relCE = convert(rel);
          relCEs.add(relCE);
        }
        OWLObjectIntersectionOf relsCE = owlFactory
            .getOWLObjectIntersectionOf(relCEs);
        core = owlFactory.getOWLObjectIntersectionOf(core, relsCE);
      }

    }

    return core;
  }

  /**
   * Apply quantifer.
   *
   * @param core
   *          the core
   * @param quantifier
   *          the quantifier
   * @param pred
   *          the pred
   * @return the OWL class expression
   */
  private OWLClassExpression applyQuantifer(OWLClassExpression core,
      Quantifier quantifier, Predicate pred) {

    Quantifier.QuantifierType qtype = quantifier.getQuantifierType();
    OWLObjectProperty prop = convert(pred.getVerb());

    // TODO could resolve double negative here (pred=neg and q=neg)
    // dont apply negative quantifer here since already applied to core

    boolean negPred = false;
    boolean exclusive = false;
    if (pred.isNegative()) {
      negPred = true;
    }

    if (pred.isExclusive()) {
      exclusive = true;
    }

    OWLObjectPropertyExpression propE = prop;
    if (pred.isPassive()) {
      propE = owlFactory.getOWLObjectInverseOf(prop);
    }

    if (qtype == QuantifierType.NULL) {
      if (exclusive) {
        core = owlFactory.getOWLObjectAllValuesFrom(propE, core);
      } else {
        core = owlFactory.getOWLObjectSomeValuesFrom(propE, core);
      }

      if (negPred) {
        core = owlFactory.getOWLObjectComplementOf(core);
      }
    }

    if (qtype == QuantifierType.EVERY) {
      if (exclusive) {
        core = owlFactory.getOWLObjectAllValuesFrom(propE, core);
      } else {
        core = owlFactory.getOWLObjectSomeValuesFrom(propE, core);
      }
      if (negPred) {
        core = owlFactory.getOWLObjectComplementOf(core);
      }
    }

    // some = at least 1
    if (qtype == QuantifierType.SOME) {
      core = owlFactory.getOWLObjectMinCardinality(1, propE, core);
      if (negPred) {
        core = owlFactory.getOWLObjectComplementOf(core);
      }
    }

    if (qtype == QuantifierType.A) {
      if (exclusive) {
        core = owlFactory.getOWLObjectAllValuesFrom(propE, core);
      } else {
        core = owlFactory.getOWLObjectSomeValuesFrom(propE, core);
      }
      if (negPred) {
        core = owlFactory.getOWLObjectComplementOf(core);
      }
    }

    if (qtype == QuantifierType.THE) {
      if (exclusive) {
        core = owlFactory.getOWLObjectAllValuesFrom(propE, core);
      } else {
        core = owlFactory.getOWLObjectSomeValuesFrom(propE, core);
      }
      if (negPred) {
        core = owlFactory.getOWLObjectComplementOf(core);
      }
    }

    if (qtype == QuantifierType.NUMERIC) {

      NumericQuantifierType qnt = quantifier.getNumericType();
      Integer num = quantifier.getQuantity();

      // treat no numeric type as "exact"
      if (qnt == null) {
        core = owlFactory.getOWLObjectExactCardinality(num, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }

      if (qnt == Quantifier.NumericQuantifierType.EXACT) {
        core = owlFactory.getOWLObjectExactCardinality(num, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }

      if (qnt == Quantifier.NumericQuantifierType.MORE_THAN) {
        core = owlFactory.getOWLObjectMinCardinality(num + 1, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }

      if (qnt == Quantifier.NumericQuantifierType.LESS_THAN) {
        core = owlFactory.getOWLObjectMaxCardinality(num - 1, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }
      if (qnt == Quantifier.NumericQuantifierType.MORE_THAN_OR_EQUAL) {
        core = owlFactory.getOWLObjectMinCardinality(num, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }
      if (qnt == Quantifier.NumericQuantifierType.LESS_THAN_OR_EQUAL) {
        core = owlFactory.getOWLObjectMaxCardinality(num, propE, core);
        if (negPred) {
          core = owlFactory.getOWLObjectComplementOf(core);
        }
      }

    }

    return core;
  }
}
