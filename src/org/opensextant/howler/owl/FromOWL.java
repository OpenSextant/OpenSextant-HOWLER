package org.opensextant.howler.owl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.abstraction.phrases.CategoryPhrase;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.phrases.InstancePhrase;
import org.opensextant.howler.abstraction.phrases.PhraseSet;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PredicateRelationStatement;
import org.opensextant.howler.abstraction.words.Adjective;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Noun;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.DataRangeType;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectInverseOf;
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
import org.semanticweb.owlapi.model.OWLPrimitive;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FromOWL {

  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(FromOWL.class);

  WordManager wordManager = WordManager.getWordManager();

  // the limit of the number of pairwise axioms to create from a set of
  // entities or -1 to always do all
  private int maxPairs = -1;

  // change a union/intersection/oneOf with a single member to just that
  // member
  private boolean flattenSingleSet = false;

  public WordManager getWordManager() {
    return wordManager;
  }

  public int getMaxPairs() {
    return maxPairs;
  }

  public void setMaxPairs(int maxPairs) {
    this.maxPairs = maxPairs;
  }

  // are we flattening sets with a single member?
  public boolean isFlattenSingleSet() {
    return flattenSingleSet;
  }

  // set behavior for sets with a single member
  public void setFlattenSingleSet(boolean allowSingleSet) {
    this.flattenSingleSet = allowSingleSet;
  }

  public Document convertOWL(OWLOntology onto) {

    Document doc = new Document();

    // if the ontology has a version IRI
    if (onto.getOntologyID().getOntologyIRI().isPresent()) {
      doc.setDocumentID(onto.getOntologyID().getOntologyIRI().get());
    }

    // if the ontology has a version IRI
    if (onto.getOntologyID().getVersionIRI().isPresent()) {
      doc.setVersionID(onto.getOntologyID().getVersionIRI().get());
    }

    // add the ontology level annotations as footnotes to document
    for (OWLAnnotation anno : OWLAPIStreamUtils.asList(onto.annotations())) {
      doc.addFootnote(convertOWL(anno));
    }

    // add the imports
    doc.setImportedDocuments(OWLAPIStreamUtils.asList(onto.directImportsDocuments()));

    // convert each axioms and add result to document
    for (OWLAxiom axiom : OWLAPIStreamUtils.asList(onto.axioms())) {
      List<? extends Statement> statements = convertOWL(axiom);
      for (Statement st : statements) {
        doc.addStatement(st);
      }
    }

    // renormalize after whole ontology processed to get any labels added
    // during axiom conversion
    wordManager.renormalize();

    // add the vocabulary by lookingup the entities from the ontology
    // signature
    for (OWLEntity entity : OWLAPIStreamUtils.asSet(onto.signature(Imports.EXCLUDED))) {
      if (includeInVocabulary(entity, onto)) {
        Optional<Word> wrd = lookupPrimitive(entity);
        if (wrd.isPresent()) {
          LOGGER.debug("Adding Vocabulary to match entity: " + entity.getEntityType() + ":" + entity);
          doc.addVocabulary(wrd.get());
        } else {
          LOGGER.error("No Word in Vocabulary to match entity: " + entity.getEntityType() + ":" + entity);
        }
      }
    }

    // add the vocabulary from anonymous individuals (they aren't entities,
    // so not in signature)
    for (OWLAnonymousIndividual ind : OWLAPIStreamUtils.asSet(onto.anonymousIndividuals())) {
      Optional<Word> wrd = lookupPrimitive(ind);
      if (wrd.isPresent()) {
        doc.addVocabulary(wrd.get());
      } else {
        LOGGER.error("No Word in Vocabulary to match Anonymous Individual: " + ind);
      }
    }

    // add vocabulary from "bare" IRIs since they aren't entities either
    List<IRI> bares = findBareIRIs(onto);
    for (IRI iri : bares) {
      Optional<Word> wrd = lookupPrimitive(iri);
      if (wrd.isPresent()) {
        LOGGER.debug("Adding Vocabulary to match IRI: " + iri + ":" + wrd);
        doc.addVocabulary(wrd.get());
      } else {
        LOGGER.error("No Word in Vocabulary to match IRI: " + iri);
      }
    }

    return doc;
  }

  // what entities/words to include in a documents vocabulary section
  private boolean includeInVocabulary(OWLEntity entity, OWLOntology onto) {

    // (NOTE: this only considers LOADED imported ontologies, so if import
    // could not be loaded...)
    // if declared somewhere...
    if (onto.isDeclared(entity, Imports.INCLUDED)) {

      // if not declared in onto (must be only in an import)
      if (!onto.isDeclared(entity, Imports.EXCLUDED)) {
        LOGGER.warn("Not including in Vocabulary\t" + entity + "\t" + onto.getOntologyID());
        return false;
      } else {
        // must be declared in onto
        return true;
      }
    }

    // false if appears in signature of imported onto? Should have been
    // declared in imports?

    // true for everything else
    return true;
  }

  // convert each axiom by type
  public List<? extends Statement> convertOWL(OWLAxiom axiom) {

    AxiomType<?> axType = axiom.getAxiomType();

    // all the different OWL axioms
    if (axType == AxiomType.DECLARATION) {
      return convertOWL((OWLDeclarationAxiom) axiom);
    }
    if (axType == AxiomType.EQUIVALENT_CLASSES) {
      return convertOWL((OWLEquivalentClassesAxiom) axiom);
    }
    if (axType == AxiomType.SUBCLASS_OF) {
      return convertOWL((OWLSubClassOfAxiom) axiom);
    }
    if (axType == AxiomType.DISJOINT_CLASSES) {
      return convertOWL((OWLDisjointClassesAxiom) axiom);
    }
    if (axType == AxiomType.DISJOINT_UNION) {
      return convertOWL((OWLDisjointUnionAxiom) axiom);
    }
    if (axType == AxiomType.CLASS_ASSERTION) {
      return convertOWL((OWLClassAssertionAxiom) axiom);
    }
    if (axType == AxiomType.SAME_INDIVIDUAL) {
      return convertOWL((OWLSameIndividualAxiom) axiom);
    }
    if (axType == AxiomType.DIFFERENT_INDIVIDUALS) {
      return convertOWL((OWLDifferentIndividualsAxiom) axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_ASSERTION) {
      return convertOWL((OWLObjectPropertyAssertionAxiom) axiom);
    }
    if (axType == AxiomType.NEGATIVE_OBJECT_PROPERTY_ASSERTION) {
      return convertOWL((OWLNegativeObjectPropertyAssertionAxiom) axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_ASSERTION) {
      return convertOWL((OWLDataPropertyAssertionAxiom) axiom);
    }
    if (axType == AxiomType.NEGATIVE_DATA_PROPERTY_ASSERTION) {
      return convertOWL((OWLNegativeDataPropertyAssertionAxiom) axiom);
    }
    if (axType == AxiomType.EQUIVALENT_OBJECT_PROPERTIES) {
      return convertOWL((OWLEquivalentObjectPropertiesAxiom) axiom);
    }
    if (axType == AxiomType.SUB_OBJECT_PROPERTY) {
      return convertOWL((OWLSubObjectPropertyOfAxiom) axiom);
    }
    if (axType == AxiomType.INVERSE_OBJECT_PROPERTIES) {
      return convertOWL((OWLInverseObjectPropertiesAxiom) axiom);
    }
    if (axType == AxiomType.FUNCTIONAL_OBJECT_PROPERTY) {
      return convertOWL((OWLFunctionalObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY) {
      return convertOWL((OWLInverseFunctionalObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.SYMMETRIC_OBJECT_PROPERTY) {
      return convertOWL((OWLSymmetricObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.ASYMMETRIC_OBJECT_PROPERTY) {
      return convertOWL((OWLAsymmetricObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.TRANSITIVE_OBJECT_PROPERTY) {
      return convertOWL((OWLTransitiveObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.REFLEXIVE_OBJECT_PROPERTY) {
      return convertOWL((OWLReflexiveObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.IRREFLEXIVE_OBJECT_PROPERTY) {
      return convertOWL((OWLIrreflexiveObjectPropertyAxiom) axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_DOMAIN) {
      return convertOWL((OWLObjectPropertyDomainAxiom) axiom);
    }
    if (axType == AxiomType.OBJECT_PROPERTY_RANGE) {
      return convertOWL((OWLObjectPropertyRangeAxiom) axiom);
    }
    if (axType == AxiomType.DISJOINT_OBJECT_PROPERTIES) {
      return convertOWL((OWLDisjointObjectPropertiesAxiom) axiom);
    }
    if (axType == AxiomType.SUB_PROPERTY_CHAIN_OF) {
      return convertOWL((OWLSubPropertyChainOfAxiom) axiom);
    }
    if (axType == AxiomType.EQUIVALENT_DATA_PROPERTIES) {
      return convertOWL((OWLEquivalentDataPropertiesAxiom) axiom);
    }
    if (axType == AxiomType.SUB_DATA_PROPERTY) {
      return convertOWL((OWLSubDataPropertyOfAxiom) axiom);
    }
    if (axType == AxiomType.FUNCTIONAL_DATA_PROPERTY) {
      return convertOWL((OWLFunctionalDataPropertyAxiom) axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_DOMAIN) {
      return convertOWL((OWLDataPropertyDomainAxiom) axiom);
    }
    if (axType == AxiomType.DATA_PROPERTY_RANGE) {
      return convertOWL((OWLDataPropertyRangeAxiom) axiom);
    }
    if (axType == AxiomType.DISJOINT_DATA_PROPERTIES) {
      return convertOWL((OWLDisjointDataPropertiesAxiom) axiom);
    }
    if (axType == AxiomType.DATATYPE_DEFINITION) {
      return convertOWL((OWLDatatypeDefinitionAxiom) axiom);
    }
    if (axType == AxiomType.HAS_KEY) {
      return convertOWL((OWLHasKeyAxiom) axiom);
    }
    if (axType == AxiomType.SWRL_RULE) {
      return convertOWL((SWRLRule) axiom);
    }
    if (axType == AxiomType.ANNOTATION_ASSERTION) {
      return convertOWL((OWLAnnotationAssertionAxiom) axiom);
    }
    if (axType == AxiomType.SUB_ANNOTATION_PROPERTY_OF) {
      return convertOWL((OWLSubAnnotationPropertyOfAxiom) axiom);
    }
    if (axType == AxiomType.ANNOTATION_PROPERTY_RANGE) {
      return convertOWL((OWLAnnotationPropertyRangeAxiom) axiom);
    }
    if (axType == AxiomType.ANNOTATION_PROPERTY_DOMAIN) {
      return convertOWL((OWLAnnotationPropertyDomainAxiom) axiom);
    }

    LOGGER.warn("Should not happen: Could not convert axiom of type " + axType + ":" + axiom);
    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLDeclarationAxiom ax) {
    // convert the entity to a Word
    convertOWLPrimitive(ax.getEntity());
    return new ArrayList<Statement>();
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLEquivalentClassesAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLEquivalentClassesAxiom> axs = ax.asPairwiseAxioms();

    // look for
    if (axs.isEmpty()) {
      LOGGER.warn("Equivalent Classes axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLEquivalentClassesAxiom eq : axs) {
      i++;
      List<OWLClassExpression> cePair = OWLAPIStreamUtils.asList(eq.classExpressions());
      OWLClassExpression subj = cePair.get(0);
      OWLClassExpression obj = cePair.get(1);

      SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj));
      subjPhrase.getQuantifier().setQuantifierType(Quantifier.A);

      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj));
      objPhrase.getQuantifier().setQuantifierType(Quantifier.A);

      PredicateExpression<ObjectPredicate> predExp = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);

      PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
          predExp, objPhrase);

      DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
      statement.setSubject(subjPhrase);
      statement.setPredicatePhrase(predPhrase);
      attachFootnotes(statement, ax);

      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Equivalent Classes axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return statementList;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLDisjointClassesAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLDisjointClassesAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Disjoint Classes axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLDisjointClassesAxiom eq : axs) {
      i++;
      List<OWLClassExpression> cePair = OWLAPIStreamUtils.asList(eq.classExpressions());
      OWLClassExpression subj = cePair.get(0);
      OWLClassExpression obj = cePair.get(1);

      SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj));
      subjPhrase.getQuantifier().setQuantifierType(Quantifier.A);

      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj));
      objPhrase.getQuantifier().setQuantifierType(Quantifier.A);

      PredicateExpression<ObjectPredicate> predExp = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_Object);
      predExp.setNegative(true);

      PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
          predExp, objPhrase);

      DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
      statement.setSubject(subjPhrase);
      statement.setPredicatePhrase(predPhrase);
      attachFootnotes(statement, ax);

      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Disjoint Classes axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }

    }

    return statementList;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLSubClassOfAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    OWLClassExpression subj = ax.getSubClass();
    OWLClassExpression obj = ax.getSuperClass();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj));
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj));
    objPhrase.getQuantifier().setQuantifierType(Quantifier.A);

    PredicateExpression<ObjectPredicate> predExp = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_Object);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLDisjointUnionAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    OWLClass subj = ax.getOWLClass();

    List<OWLClassExpression> objs = OWLAPIStreamUtils.asList(ax.classExpressions());

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj));
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.EVERY);

    PhraseSet<SubjectObjectPhrase> objPhrases = new PhraseSet<SubjectObjectPhrase>();
    objPhrases.setSetType(BooleanSetType.UNION);

    for (OWLClassExpression objCE : objs) {
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(objCE));
      objPhrase.getQuantifier().setQuantifierType(Quantifier.A);
      objPhrases.addPhrase(objPhrase);
    }

    objPhrases.getQuantifier().setQuantifierType(Quantifier.A);

    PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_ONLY_Object);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pred, convertToSubjectObjectPhrase(objPhrases));

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    attachFootnotes(statement, ax);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);

    statementList.add(statement);

    return statementList;
  }

  private List<FactStatement<ObjectPredicate, ProperNoun>> convertOWL(OWLClassAssertionAxiom ax) {
    List<FactStatement<ObjectPredicate, ProperNoun>> statementList = new ArrayList<FactStatement<ObjectPredicate, ProperNoun>>();

    OWLIndividual subj = ax.getIndividual();
    OWLClassExpression obj = ax.getClassExpression();

    InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj));
    objPhrase.getQuantifier().setQuantifierType(Quantifier.A);

    PredicateExpression<ObjectPredicate> pExp = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_Object);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pExp, objPhrase);

    FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();
    statement.setSubject(subjPhrase);
    statement.setSubjectObjectPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<FactStatement<ObjectPredicate, ProperNoun>> convertOWL(OWLSameIndividualAxiom ax) {
    List<FactStatement<ObjectPredicate, ProperNoun>> factList = new ArrayList<FactStatement<ObjectPredicate, ProperNoun>>();

    Set<OWLSameIndividualAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Same Individual axiom with " + axs.size() + " pairs.");
      return factList;
    }

    int i = 0;
    for (OWLSameIndividualAxiom si : axs) {
      i++;
      OWLIndividual subj = si.getIndividualsAsList().get(0);
      OWLIndividual obj = si.getIndividualsAsList().get(1);

      InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
      subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

      InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
      objPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

      PredicateExpression<ObjectPredicate> pExp = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);
      PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
          pExp, objPhrase);

      FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();
      statement.setSubject(subjPhrase);
      statement.setInstancePredicatePhrase(predPhrase);
      attachFootnotes(statement, ax);

      factList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Same Individual axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return factList;
  }

  private List<FactStatement<ObjectPredicate, ProperNoun>> convertOWL(OWLDifferentIndividualsAxiom ax) {
    List<FactStatement<ObjectPredicate, ProperNoun>> factList = new ArrayList<FactStatement<ObjectPredicate, ProperNoun>>();

    Collection<OWLDifferentIndividualsAxiom> axs = ax.asPairwiseAxioms();
    if (axs.isEmpty()) {
      LOGGER.warn("Different Individual axiom with " + axs.size() + " pairs.");
      return factList;
    }

    int i = 0;
    for (OWLDifferentIndividualsAxiom si : axs) {
      i++;
      OWLIndividual subj = si.getIndividualsAsList().get(0);
      OWLIndividual obj = si.getIndividualsAsList().get(1);

      InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
      subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

      InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
      objPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

      PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);
      pred.setNegative(true);

      PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
          pred, convertOWL(obj));

      FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();
      statement.setSubject(subjPhrase);
      statement.setInstancePredicatePhrase(predPhrase);
      attachFootnotes(statement, ax);

      factList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Different Individual axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }

    }

    return factList;

  }

  private List<FactStatement<ObjectPredicate, ProperNoun>> convertOWL(OWLObjectPropertyAssertionAxiom ax) {
    List<FactStatement<ObjectPredicate, ProperNoun>> factList = new ArrayList<FactStatement<ObjectPredicate, ProperNoun>>();

    OWLIndividual subj = ax.getSubject();
    OWLIndividual obj = ax.getObject();

    InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    PredicateExpression<ObjectPredicate> pred = convertOWL(ax.getProperty());
    PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
        pred, objPhrase);

    FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();
    statement.setSubject(subjPhrase);
    statement.setInstancePredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    factList.add(statement);

    return factList;
  }

  private List<FactStatement<ObjectPredicate, ProperNoun>> convertOWL(OWLNegativeObjectPropertyAssertionAxiom ax) {
    List<FactStatement<ObjectPredicate, ProperNoun>> factList = new ArrayList<FactStatement<ObjectPredicate, ProperNoun>>();
    OWLIndividual subj = ax.getSubject();
    OWLIndividual obj = ax.getObject();

    InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    PredicateExpression<ObjectPredicate> pred = convertOWL(ax.getProperty());
    pred.setNegative(true);
    PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
        pred, objPhrase);

    FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();
    statement.setSubject(subjPhrase);
    statement.setInstancePredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    factList.add(statement);

    return factList;
  }

  private List<FactStatement<DataPredicate, DataValue>> convertOWL(OWLDataPropertyAssertionAxiom ax) {
    List<FactStatement<DataPredicate, DataValue>> factList = new ArrayList<FactStatement<DataPredicate, DataValue>>();

    OWLIndividual subj = ax.getSubject();
    OWLLiteral obj = ax.getObject();

    InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    InstancePhrase<DataValue> objPhrase = convertOWL(obj);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    PredicateExpression<DataPredicate> pred = convertOWL(ax.getProperty());
    PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataPredicate>(
        pred, objPhrase);

    FactStatement<DataPredicate, DataValue> statement = new FactStatement<DataPredicate, DataValue>();
    statement.setSubject(subjPhrase);
    statement.setInstancePredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    factList.add(statement);

    return factList;
  }

  private List<FactStatement<DataPredicate, DataValue>> convertOWL(OWLNegativeDataPropertyAssertionAxiom ax) {
    List<FactStatement<DataPredicate, DataValue>> factList = new ArrayList<FactStatement<DataPredicate, DataValue>>();

    OWLIndividual subj = ax.getSubject();
    OWLLiteral obj = ax.getObject();

    InstancePhrase<ProperNoun> subjPhrase = convertOWL(subj);
    subjPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    InstancePhrase<DataValue> objPhrase = convertOWL(obj);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.THE);

    PredicateExpression<DataPredicate> pred = convertOWL(ax.getProperty());
    pred.setNegative(true);
    PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataPredicate>(
        pred, objPhrase);

    FactStatement<DataPredicate, DataValue> statement = new FactStatement<DataPredicate, DataValue>();
    statement.setSubject(subjPhrase);
    statement.setInstancePredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    factList.add(statement);

    return factList;
  }

  private List<PredicateRelationStatement<ObjectPredicate>> convertOWL(OWLEquivalentObjectPropertiesAxiom ax) {
    List<PredicateRelationStatement<ObjectPredicate>> statementList = new ArrayList<PredicateRelationStatement<ObjectPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLEquivalentObjectPropertiesAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Equivalent Object Properties axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLEquivalentObjectPropertiesAxiom pairAx : axs) {
      i++;
      List<OWLObjectPropertyExpression> propPair = OWLAPIStreamUtils.asList(pairAx.properties());
      PredicateExpression<ObjectPredicate> subj = convertOWL(propPair.get(0));
      PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);
      PredicateExpression<ObjectPredicate> obj = convertOWL(propPair.get(1));
      PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
          pred, obj);
      attachFootnotes(statement, ax);
      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Equivalent Object Properties axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return statementList;
  }

  private List<PredicateRelationStatement<ObjectPredicate>> convertOWL(OWLSubObjectPropertyOfAxiom ax) {
    List<PredicateRelationStatement<ObjectPredicate>> statementList = new ArrayList<PredicateRelationStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subj = convertOWL(ax.getSubProperty());
    PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_Object);
    PredicateExpression<ObjectPredicate> obj = convertOWL(ax.getSuperProperty());
    PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj, pred,
        obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);
    return statementList;
  }

  private List<PredicateRelationStatement<ObjectPredicate>> convertOWL(OWLInverseObjectPropertiesAxiom ax) {
    List<PredicateRelationStatement<ObjectPredicate>> statementList = new ArrayList<PredicateRelationStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subj = convertOWL(ax.getFirstProperty());
    PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);
    PredicateExpression<ObjectPredicate> obj = convertOWL(ax.getSecondProperty());
    pred.setPassive(true);

    PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj, pred,
        obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<Statement> convertOWL(OWLFunctionalObjectPropertyAxiom ax) {

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.FUNCTIONAL_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.FUNCTIONAL);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLInverseFunctionalObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.INVERSE_FUNCTIONAL_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.INVERSE_FUNCTIONAL);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLSymmetricObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.SYMMETRIC_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.SYMMETRIC);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLAsymmetricObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.ASYMMETRIC_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.ASYMMETRIC);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLTransitiveObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.TRANSITIVE_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.TRANSITIVE);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLReflexiveObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.REFLEXIVE_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.REFLEXIVE);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLIrreflexiveObjectPropertyAxiom ax) {
    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    ObjectPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      pred.addCharacteristic(PredicateCharacteristic.IRREFLEXIVE_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.IRREFLEXIVE);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLObjectPropertyDomainAxiom ax) {

    SubjectObjectPhrase domain = convertToSubjectObjectPhrase(convertOWL(ax.getDomain()));
    PredicateExpression<ObjectPredicate> pred = convertOWL(ax.getProperty());

    if (pred.isPassive()) {
      pred.getPredicate().addRange(domain);
    } else {
      pred.getPredicate().addDomain(domain);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLObjectPropertyRangeAxiom ax) {

    SubjectObjectPhrase range = convertToSubjectObjectPhrase(convertOWL(ax.getRange()));
    PredicateExpression<ObjectPredicate> pred = convertOWL(ax.getProperty());

    if (pred.isPassive()) {
      pred.getPredicate().addDomain(range);
    } else {
      pred.getPredicate().addRange(range);
    }

    return new ArrayList<Statement>();
  }

  private List<PredicateRelationStatement<ObjectPredicate>> convertOWL(OWLDisjointObjectPropertiesAxiom ax) {
    List<PredicateRelationStatement<ObjectPredicate>> statementList = new ArrayList<PredicateRelationStatement<ObjectPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLDisjointObjectPropertiesAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Disjoint Object properties axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLDisjointObjectPropertiesAxiom pairAx : axs) {
      i++;
      List<OWLObjectPropertyExpression> propPair = OWLAPIStreamUtils.asList(pairAx.properties());
      PredicateExpression<ObjectPredicate> subj = convertOWL(propPair.get(0));
      PredicateExpression<ObjectPredicate> obj = convertOWL(propPair.get(1));

      PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);
      pred.setNegative(true);

      PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
          pred, obj);
      attachFootnotes(statement, ax);

      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Disjoint Object properties axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return statementList;
  }

  private List<PredicateRelationStatement<DataPredicate>> convertOWL(OWLEquivalentDataPropertiesAxiom ax) {
    List<PredicateRelationStatement<DataPredicate>> statementList = new ArrayList<PredicateRelationStatement<DataPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLEquivalentDataPropertiesAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Equivalent Data properties axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLEquivalentDataPropertiesAxiom pairAx : axs) {
      i++;
      List<OWLDataPropertyExpression> pairProps = OWLAPIStreamUtils.asList(pairAx.properties());
      PredicateExpression<DataPredicate> subj = convertOWL(pairProps.get(0));
      PredicateExpression<DataPredicate> obj = convertOWL(pairProps.get(1));

      PredicateExpression<DataPredicate> pred = new PredicateExpression<DataPredicate>(Vocabulary.SAME_Data);

      PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj, pred,
          obj);
      attachFootnotes(statement, ax);

      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Equivalent Data properties axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return statementList;
  }

  private List<PredicateRelationStatement<DataPredicate>> convertOWL(OWLSubDataPropertyOfAxiom ax) {
    List<PredicateRelationStatement<DataPredicate>> statementList = new ArrayList<PredicateRelationStatement<DataPredicate>>();

    PredicateExpression<DataPredicate> subj = convertOWL(ax.getSubProperty());
    PredicateExpression<DataPredicate> obj = convertOWL(ax.getSuperProperty());

    PredicateExpression<DataPredicate> pred = new PredicateExpression<DataPredicate>(Vocabulary.IS_Data);

    PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj, pred,
        obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<Statement> convertOWL(OWLFunctionalDataPropertyAxiom ax) {

    PredicateExpression<DataPredicate> subjExp = convertOWL(ax.getProperty());

    DataPredicate pred = subjExp.getPredicate();
    if (subjExp.isPassive()) {
      LOGGER.error("Data Properties do not have inverses. Ignoring" + ax);
      pred.addCharacteristic(PredicateCharacteristic.FUNCTIONAL_OF_INVERSE);
    } else {
      pred.addCharacteristic(PredicateCharacteristic.FUNCTIONAL);
    }

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLDataPropertyDomainAxiom ax) {

    SubjectObjectPhrase domain = convertToSubjectObjectPhrase(convertOWL(ax.getDomain()));
    PredicateExpression<DataPredicate> pred = convertOWL(ax.getProperty());
    pred.getPredicate().addDomain(domain);

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLDataPropertyRangeAxiom ax) {

    SubjectObjectPhrase range = convertToSubjectObjectPhrase(convertOWL(ax.getRange()));
    PredicateExpression<DataPredicate> pred = convertOWL(ax.getProperty());
    pred.getPredicate().addRange(range);

    return new ArrayList<Statement>();
  }

  private List<PredicateRelationStatement<DataPredicate>> convertOWL(OWLDisjointDataPropertiesAxiom ax) {
    List<PredicateRelationStatement<DataPredicate>> statementList = new ArrayList<PredicateRelationStatement<DataPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLDisjointDataPropertiesAxiom> axs = ax.asPairwiseAxioms();

    if (axs.isEmpty()) {
      LOGGER.warn("Disjoint Data Properties axiom with " + axs.size() + " pairs.");
      return statementList;
    }

    int i = 0;
    for (OWLDisjointDataPropertiesAxiom pairAx : axs) {
      i++;
      List<OWLDataPropertyExpression> pairProps = OWLAPIStreamUtils.asList(pairAx.properties());
      PredicateExpression<DataPredicate> subj = convertOWL(pairProps.get(0));
      PredicateExpression<DataPredicate> obj = convertOWL(pairProps.get(1));

      PredicateExpression<DataPredicate> pred = new PredicateExpression<DataPredicate>(Vocabulary.SAME_Data);
      pred.setNegative(true);

      PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj, pred,
          obj);
      attachFootnotes(statement, ax);

      statementList.add(statement);
      if (i > maxPairs && maxPairs > 0) {
        LOGGER.warn("Disjoint Data Properties axiom with " + axs.size() + " pairs. Only doing " + maxPairs);
        break;
      }
    }

    return statementList;
  }

  private List<DescriptionStatement<DataPredicate>> convertOWL(OWLDatatypeDefinitionAxiom ax) {
    List<DescriptionStatement<DataPredicate>> statementList = new ArrayList<DescriptionStatement<DataPredicate>>();

    CategoryPhrase<DataType> subj = convertOWL(ax.getDatatype());
    subj.getQuantifier().setQuantifierType(Quantifier.A);

    SubjectObjectPhrase obj = convertOWL(ax.getDataRange());
    obj.getQuantifier().setQuantifierType(Quantifier.A);

    PredicateExpression<DataPredicate> pred = new PredicateExpression<DataPredicate>(Vocabulary.SAME_Data);

    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        pred, obj);

    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();
    statement.setSubject(subj);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<Statement> convertOWL(OWLAnnotationAssertionAxiom ax) {

    Word subjWord = convertOWLPrimitive(ax.getSubject());
    OWLAnnotation anno = ax.getAnnotation();
    subjWord.addFootnote(convertOWL(anno));
    wordManager.addWord(subjWord);

    return new ArrayList<Statement>();
  }

  private List<PredicateRelationStatement<AnnotationPredicate>> convertOWL(OWLSubAnnotationPropertyOfAxiom ax) {
    List<PredicateRelationStatement<AnnotationPredicate>> statementList = new ArrayList<PredicateRelationStatement<AnnotationPredicate>>();

    PredicateExpression<AnnotationPredicate> subj = convertOWL(ax.getSubProperty());

    PredicateExpression<AnnotationPredicate> pred = new PredicateExpression<AnnotationPredicate>(
        Vocabulary.IS_Annotation);

    PredicateExpression<AnnotationPredicate> obj = convertOWL(ax.getSuperProperty());

    PredicateRelationStatement<AnnotationPredicate> statement = new PredicateRelationStatement<AnnotationPredicate>(
        subj, pred, obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<Statement> convertOWL(OWLAnnotationPropertyRangeAxiom ax) {

    Word range = convertOWLPrimitive(ax.getRange());
    AnnotationPredicate pred = convertOWLPrimitive(ax.getProperty());
    pred.addRange(range);
    wordManager.addWord(pred);

    return new ArrayList<Statement>();
  }

  private List<Statement> convertOWL(OWLAnnotationPropertyDomainAxiom ax) {

    AnnotationPredicate pred = convertOWLPrimitive(ax.getProperty());
    Word domain = convertOWLPrimitive(ax.getDomain());
    pred.addDomain(domain);
    wordManager.addWord(pred);

    return new ArrayList<Statement>();
  }

  // -------- Currently unsupported Axioms ------------------

  private List<Statement> convertOWL(OWLSubPropertyChainOfAxiom ax) {
    List<Statement> statementList = new ArrayList<Statement>();
    // just convert the properties for now (populates WordManager)
    convertOWL(ax.getSuperProperty());
    for (OWLObjectPropertyExpression prop : ax.getPropertyChain()) {
      convertOWL(prop);
    }

    // TODO
    LOGGER.debug("OWLSubPropertyChainOfAxiom not yet supported:" + ax);
    return statementList;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLHasKeyAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();
    // just convert the pieces for now (populates WordManager)
    convertOWL(ax.getClassExpression());
    for (OWLPropertyExpression prop : OWLAPIStreamUtils.asList(ax.propertyExpressions())) {
      if (prop.isObjectPropertyExpression()) {
        convertOWL(prop.asObjectPropertyExpression());
      }
      if (prop.isDataPropertyExpression()) {
        convertOWL(prop.asDataPropertyExpression());
      }
    }

    // TODO
    LOGGER.debug("OWLHasKeyAxiom not yet supported:" + ax);
    return statementList;
  }

  private List<Statement> convertOWL(SWRLRule rule) {
    List<Statement> statementList = new ArrayList<Statement>();
    // TODO
    LOGGER.debug("SWRLRule not yet supported:" + rule);
    return statementList;
  }

  // most general ClassExpression to Phrase
  private Phrase convertOWL(OWLClassExpression ce) {

    ClassExpressionType type = ce.getClassExpressionType();

    if (type == ClassExpressionType.OBJECT_COMPLEMENT_OF) {
      return convertOWL((OWLObjectComplementOf) ce);
    }

    if (type == ClassExpressionType.OWL_CLASS) {
      return convertOWL((OWLClass) ce);
    }

    if (type == ClassExpressionType.OBJECT_UNION_OF) {
      return convertOWL((OWLObjectUnionOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_INTERSECTION_OF) {
      return convertOWL((OWLObjectIntersectionOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_ONE_OF) {
      return convertOWL((OWLObjectOneOf) ce);
    }

    if (type == ClassExpressionType.OBJECT_ALL_VALUES_FROM) {
      return convertOWL((OWLObjectAllValuesFrom) ce);
    }

    if (type == ClassExpressionType.OBJECT_SOME_VALUES_FROM) {
      return convertOWL((OWLObjectSomeValuesFrom) ce);
    }

    if (type == ClassExpressionType.OBJECT_HAS_VALUE) {
      return convertOWL((OWLObjectHasValue) ce);
    }

    if (type == ClassExpressionType.OBJECT_EXACT_CARDINALITY) {
      return convertOWL((OWLObjectExactCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_MAX_CARDINALITY) {
      return convertOWL((OWLObjectMaxCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_MIN_CARDINALITY) {
      return convertOWL((OWLObjectMinCardinality) ce);
    }

    if (type == ClassExpressionType.OBJECT_HAS_SELF) {
      return convertOWL((OWLObjectHasSelf) ce);
    }

    if (type == ClassExpressionType.DATA_HAS_VALUE) {
      return convertOWL((OWLDataHasValue) ce);
    }

    if (type == ClassExpressionType.DATA_ALL_VALUES_FROM) {
      return convertOWL((OWLDataAllValuesFrom) ce);
    }

    if (type == ClassExpressionType.DATA_SOME_VALUES_FROM) {
      return convertOWL((OWLDataSomeValuesFrom) ce);
    }

    if (type == ClassExpressionType.DATA_EXACT_CARDINALITY) {
      return convertOWL((OWLDataExactCardinality) ce);
    }

    if (type == ClassExpressionType.DATA_MAX_CARDINALITY) {
      return convertOWL((OWLDataMaxCardinality) ce);
    }

    if (type == ClassExpressionType.DATA_MIN_CARDINALITY) {
      return convertOWL((OWLDataMinCardinality) ce);
    }

    LOGGER.error("Could not convert ClassExpression of type:" + type + " " + ce);

    return new CategoryPhrase<CommonNoun>(Vocabulary.THING);
  }

  private CategoryPhrase<Noun> convertOWL(OWLClass cl) {
    Noun n = convertOWLPrimitive(cl);
    CategoryPhrase<Noun> np = new CategoryPhrase<Noun>(n);
    return np;
  }

  private Phrase convertOWL(OWLObjectUnionOf ce) {

    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.UNION);

    List<OWLClassExpression> members = ce.getOperandsAsList();
    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to phrases
    for (OWLClassExpression member : members) {
      Phrase phrase = convertOWL(member);
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
      phSet.addPhrase(objPhrase);
    }

    return phSet;
  }

  private Phrase convertOWL(OWLObjectIntersectionOf ce) {

    List<OWLClassExpression> members = ce.getOperandsAsList();

    // if only 1 member
    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // if memebers are a set of categories and predicate phrases-> category
    // phrase
    List<Noun> nouns = new ArrayList<Noun>();
    List<Noun> mods = new ArrayList<Noun>();
    List<PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>> preds = new ArrayList<PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>>();
    List<Phrase> others = new ArrayList<Phrase>();

    for (OWLClassExpression member : members) {
      Phrase memberPhrase = convertOWL(member);
      if (memberPhrase instanceof CategoryPhrase) {
        CategoryPhrase<Noun> cat = (CategoryPhrase<Noun>) memberPhrase;
        if (cat.isSimple()) {
          Noun head = cat.getHead();
          if (head instanceof Adjective) {
            mods.add(head);
          } else {
            nouns.add(head);
          }
        } else {
          others.add(memberPhrase);
        }
        continue;
      }
      if (memberPhrase instanceof PredicatePhrase) {
        preds.add((PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>) memberPhrase);
        continue;
      }
      others.add(memberPhrase);
    }

    // no "others"
    if (others.isEmpty()) {
      Noun head = Vocabulary.THING;
      if (nouns.size() == 1) {
        head = nouns.get(0);
      }
      if (nouns.size() > 1) {
        // pick the first as head
        head = nouns.get(0); // move the rest to modifiers
        nouns.remove(head);
        mods.addAll(nouns);
      }
      CategoryPhrase<Noun> catPhrase = new CategoryPhrase<Noun>(head);
      for (Noun mod : mods) {
        catPhrase.addModifier(mod);
      }
      for (PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> pred : preds) {
        catPhrase.addRelativePhrase(pred);
      }
      return catPhrase;
    }

    // if none of the above, convert as a simple intersection
    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.INTERSECTION);

    // convert all set members to phrases
    for (OWLClassExpression member : members) {
      Phrase phrase = convertOWL(member);
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
      phSet.addPhrase(objPhrase);
    }

    return phSet;

  }

  private Phrase convertOWL(OWLObjectOneOf ce) {

    PhraseSet<InstancePhrase<ProperNoun>> phSet = new PhraseSet<InstancePhrase<ProperNoun>>();
    phSet.setSetType(BooleanSetType.ONEOF);

    List<OWLIndividual> members = OWLAPIStreamUtils.asList(ce.individuals());

    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to individuals then to Instance phrases
    for (OWLIndividual member : members) {
      ProperNoun pn = convertOWLPrimitive(member);
      InstancePhrase<ProperNoun> tmpPhrase = new InstancePhrase<ProperNoun>(pn);
      phSet.addPhrase(tmpPhrase);
    }

    return phSet;
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectAllValuesFrom ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create object phrase and possible convert to relative clause
    Phrase phrase = convertOWL(objCE);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.EVERY);

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private Phrase convertOWL(OWLObjectComplementOf ce) {
    Phrase ph = convertOWL(ce.getOperand());
    ph.flipNegative();
    return ph;
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectSomeValuesFrom ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create and possible convert to relative clause
    Phrase phrase = convertOWL(objCE);
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.SOME);

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> convertOWL(OWLObjectHasValue ce) {

    // get CE components
    OWLIndividual objInd = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create propernoun
    ProperNoun properNoun = convertOWLPrimitive(objInd);
    InstancePhrase<ProperNoun> np = new InstancePhrase<ProperNoun>(properNoun);
    np.getQuantifier().setQuantifierType(Quantifier.THE);

    // assemble predicate phrase
    PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
        predExp, np);

    return predPhrase;

  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectExactCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create and possible convert to relative clause
    Phrase phrase = convertOWL(objCE);
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.EXACT);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectMaxCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create and possible convert to relative clause
    Phrase phrase = convertOWL(objCE);
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.LESS_THAN_OR_EQUAL);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectMinCardinality ce) {

    // get CE components
    OWLClassExpression objCE = ce.getFiller();
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);

    // create and possible convert to relative clause
    Phrase phrase = convertOWL(objCE);
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.MORE_THAN_OR_EQUAL);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);
    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertOWL(OWLObjectHasSelf ce) {

    // get CE components
    OWLObjectPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<ObjectPredicate> predExp = convertOWL(prop);
    // create itself phrase
    CategoryPhrase<CommonNoun> objPhrase = new CategoryPhrase<CommonNoun>(Vocabulary.ITSELF);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.EVERY);

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> convertOWL(OWLDataHasValue ce) {
    // get CE components
    OWLLiteral objLit = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> predExp = convertOWL(prop);

    // create datavalue
    DataValue value = convertOWLPrimitive(objLit);
    InstancePhrase<DataValue> ip = new InstancePhrase<DataValue>(value);
    ip.getQuantifier().setQuantifierType(Quantifier.THE);

    // assemble predicate phrase
    PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataPredicate>(
        predExp, ip);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertOWL(OWLDataAllValuesFrom ce) {

    // get CE components
    OWLDataRange objDR = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> predExp = convertOWL(prop);

    // create objectphrase
    SubjectObjectPhrase objPhrase = convertOWL(objDR);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.EVERY);

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private SubjectObjectPhrase convertOWL(OWLDataComplementOf ce) {
    SubjectObjectPhrase ph = convertOWL(ce.getDataRange());
    ph.flipNegative();
    return ph;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertOWL(OWLDataSomeValuesFrom ce) {
    // get CE components
    OWLDataRange objDR = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> pred = convertOWL(prop);

    // create object phrase
    SubjectObjectPhrase objPhrase = convertOWL(objDR);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.SOME);

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        pred, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertOWL(OWLDataExactCardinality ce) {

    // get CE components
    OWLDataRange objDR = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> predExp = convertOWL(prop);

    // create object phrase
    SubjectObjectPhrase objPhrase = convertOWL(objDR);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.EXACT);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertOWL(OWLDataMaxCardinality ce) {
    // get CE components
    OWLDataRange objDR = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> predExp = convertOWL(prop);

    // create object phrase
    SubjectObjectPhrase objPhrase = convertOWL(objDR);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.LESS_THAN_OR_EQUAL);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertOWL(OWLDataMinCardinality ce) {

    // get CE components
    OWLDataRange objDR = ce.getFiller();
    OWLDataPropertyExpression prop = ce.getProperty();

    // create predicate expression
    PredicateExpression<DataPredicate> predExp = convertOWL(prop);

    // create object phrase
    SubjectObjectPhrase objPhrase = convertOWL(objDR);
    objPhrase.getQuantifier().setQuantifierType(Quantifier.MORE_THAN_OR_EQUAL);
    objPhrase.getQuantifier().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  // --------------- Properties and Property Expressions ------

  // Object property expression to Predicate
  private PredicateExpression<ObjectPredicate> convertOWL(OWLObjectPropertyExpression prop) {

    // check for inverse
    if (prop instanceof OWLObjectInverseOf) {
      return convertOWL((OWLObjectInverseOf) prop);
    }

    PredicateExpression<ObjectPredicate> predExp = new PredicateExpression<ObjectPredicate>();

    // create predicate from named property
    ObjectPredicate pred = convertOWLPrimitive(prop.getNamedProperty());
    predExp.setPredicate(pred);

    return predExp;
  }

  // Inverse Object property expression to PredicateExpression
  private PredicateExpression<ObjectPredicate> convertOWL(OWLObjectInverseOf prop) {
    PredicateExpression<ObjectPredicate> predExp = new PredicateExpression<ObjectPredicate>();

    // create predicate from named property
    ObjectPredicate pred = convertOWLPrimitive(prop.getNamedProperty());
    predExp.setPredicate(pred);
    predExp.setPassive(true);
    return predExp;
  }

  // Data property expression to PredicateExpression
  private PredicateExpression<DataPredicate> convertOWL(OWLDataPropertyExpression prop) {
    PredicateExpression<DataPredicate> predExp = new PredicateExpression<DataPredicate>();
    // is always just a DataProperty
    DataPredicate pred = convertOWLPrimitive(prop.asOWLDataProperty());
    predExp.setPredicate(pred);
    return predExp;
  }

  // Annotation property to PredicateExpression
  private PredicateExpression<AnnotationPredicate> convertOWL(OWLAnnotationProperty prop) {
    PredicateExpression<AnnotationPredicate> predExp = new PredicateExpression<AnnotationPredicate>();
    AnnotationPredicate pred = convertOWLPrimitive(prop);
    predExp.setPredicate(pred);
    return predExp;
  }

  // ------------- Data Ranges -------------
  private SubjectObjectPhrase convertOWL(OWLDataRange dr) {

    DataRangeType drType = dr.getDataRangeType();

    if (drType == DataRangeType.DATA_COMPLEMENT_OF) {
      return convertOWL((OWLDataComplementOf) dr);
    }

    if (drType == DataRangeType.DATATYPE) {
      return convertOWL((OWLDatatype) dr);
    }

    if (drType == DataRangeType.DATA_INTERSECTION_OF) {
      return convertOWL((OWLDataIntersectionOf) dr);
    }

    if (drType == DataRangeType.DATA_UNION_OF) {
      return convertOWL((OWLDataUnionOf) dr);
    }

    if (drType == DataRangeType.DATA_ONE_OF) {
      return convertOWL((OWLDataOneOf) dr);
    }

    if (drType == DataRangeType.DATATYPE_RESTRICTION) {
      return convertOWL((OWLDatatypeRestriction) dr);
    }

    // Should never happen
    LOGGER.warn("Could not convert DataRange of type " + drType + " " + dr);
    return new CategoryPhrase<DataType>(Vocabulary.DATATYPE_THING);
  }

  private CategoryPhrase<DataType> convertOWL(OWLDatatype odt) {
    DataType dt = convertOWLPrimitive(odt);
    CategoryPhrase<DataType> cat = new CategoryPhrase<DataType>(dt);
    return cat;
  }

  private SubjectObjectPhrase convertOWL(OWLDataIntersectionOf dr) {

    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.INTERSECTION);

    List<OWLDataRange> members = OWLAPIStreamUtils.asList(dr.operands());

    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to phrases
    for (OWLDataRange member : members) {
      SubjectObjectPhrase tmpPhrase = convertOWL(member);
      phSet.addPhrase(tmpPhrase);
    }

    return phSet;
  }

  private SubjectObjectPhrase convertOWL(OWLDataUnionOf dr) {

    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.UNION);
    List<OWLDataRange> members = OWLAPIStreamUtils.asList(dr.operands());

    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to phrases
    for (OWLDataRange member : members) {
      SubjectObjectPhrase tmpPhrase = convertOWL(member);
      phSet.addPhrase(tmpPhrase);
    }

    return phSet;
  }

  private SubjectObjectPhrase convertOWL(OWLDataOneOf dr) {

    PhraseSet<InstancePhrase<DataValue>> phSet = new PhraseSet<InstancePhrase<DataValue>>();
    phSet.setSetType(BooleanSetType.ONEOF);

    List<OWLLiteral> members = OWLAPIStreamUtils.asList(dr.values());

    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to phrases
    for (OWLLiteral member : members) {
      DataValue head = convertOWLPrimitive(member);
      InstancePhrase<DataValue> tmpPhrase = new InstancePhrase<DataValue>(head);
      phSet.addPhrase(tmpPhrase);
    }

    return phSet;
  }

  private CategoryPhrase<DataType> convertOWL(OWLDatatypeRestriction dr) {

    // core data type
    CategoryPhrase<DataType> dt = convertOWL(dr.getDatatype());

    List<OWLFacetRestriction> restricts = OWLAPIStreamUtils.asList(dr.facetRestrictions());

    // convert each restriction to a relative phrase
    for (OWLFacetRestriction rest : restricts) {

      DataFacet fc = convertOWLPrimitive(rest.getFacet());
      DataFacetPredicate dfp = new DataFacetPredicate(fc);

      PredicateExpression<DataFacetPredicate> predExp = new PredicateExpression<DataFacetPredicate>(dfp);

      InstancePhrase<DataValue> val = convertOWL(rest.getFacetValue());
      val.getQuantifier().setQuantifierType(Quantifier.THE);

      PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> restriction = new PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate>(
          predExp, val);
      dt.addRelativePhrase(restriction);
    }

    return dt;

  }

  private InstancePhrase<ProperNoun> convertOWL(OWLIndividual ind) {
    if (ind.isAnonymous()) {
      return convertOWL((OWLAnonymousIndividual) ind);
    } else {
      return convertOWL((OWLNamedIndividual) ind);
    }
  }

  private InstancePhrase<ProperNoun> convertOWL(OWLNamedIndividual ind) {
    ProperNoun indObj = convertOWLPrimitive(ind);
    InstancePhrase<ProperNoun> np = new InstancePhrase<ProperNoun>(indObj);
    return np;
  }

  private InstancePhrase<ProperNoun> convertOWL(OWLAnonymousIndividual ind) {
    ProperNoun indObj = convertOWLPrimitive(ind);
    InstancePhrase<ProperNoun> np = new InstancePhrase<ProperNoun>(indObj);
    return np;
  }

  private InstancePhrase<DataValue> convertOWL(OWLLiteral obj) {
    DataValue lit = convertOWLPrimitive(obj);
    InstancePhrase<DataValue> dp = new InstancePhrase<DataValue>(lit);
    return dp;
  }

  private Footnote convertOWL(OWLAnnotation anno) {

    AnnotationPredicate pred = convertOWLPrimitive(anno.getProperty());
    Word obj = convertOWLPrimitive(anno.getValue());

    Footnote foot = new Footnote();
    foot.setPredicate(pred);
    foot.setWord(obj);

    return foot;
  }

  private Word convertOWLPrimitive(OWLEntity ent) {

    if (ent.isType(EntityType.ANNOTATION_PROPERTY)) {
      return convertOWLPrimitive((OWLAnnotationProperty) ent);
    }

    if (ent.isType(EntityType.CLASS)) {
      return convertOWLPrimitive((OWLClass) ent);
    }

    if (ent.isType(EntityType.DATA_PROPERTY)) {
      return convertOWLPrimitive((OWLDataProperty) ent);
    }

    if (ent.isType(EntityType.DATATYPE)) {
      return convertOWLPrimitive((OWLDatatype) ent);
    }

    if (ent.isType(EntityType.NAMED_INDIVIDUAL)) {
      return convertOWLPrimitive((OWLNamedIndividual) ent);
    }

    if (ent.isType(EntityType.OBJECT_PROPERTY)) {
      return convertOWLPrimitive((OWLObjectProperty) ent);
    }

    LOGGER.error("Couldn't convert Entity of unknown type. Should not happen." + ent);
    return Vocabulary.ERROR;
  }

  private Noun convertOWLPrimitive(OWLClass cl) {
    if (isAdjective(cl)) {
      return wordManager.lookupOrCreateByKeyAndType(cl.getIRI(), WordType.ADJECTIVE);
    } else {
      return wordManager.lookupOrCreateByKeyAndType(cl.getIRI(), WordType.COMMON_NOUN);
    }
  }

  private DataType convertOWLPrimitive(OWLDatatype dt) {
    return wordManager.lookupOrCreateByKeyAndType(dt.getIRI(), WordType.DATATYPE);
  }

  private DataValue convertOWLPrimitive(OWLLiteral lit) {

    OWLDatatype odt = lit.getDatatype();
    DataType dt = convertOWLPrimitive(odt);

    String value = lit.getLiteral();
    if (value.isEmpty()) {
      LOGGER.warn("Literal with empty value");
    }
    String lang = lit.getLang();

    DataValue dv = new DataValue(value);
    dv.setDatatype(dt);
    dv.setLanguage(lang);

    return dv;
  }

  private ProperNoun convertOWLPrimitive(OWLIndividual ind) {
    if (ind.isNamed()) {
      return convertOWLPrimitive((OWLNamedIndividual) ind);
    }
    return convertOWLPrimitive((OWLAnonymousIndividual) ind);
  }

  private ProperNoun convertOWLPrimitive(OWLNamedIndividual ind) {
    return wordManager.lookupOrCreateByKeyAndType(ind.getIRI(), WordType.PROPER_NOUN);
  }

  private ProperNoun convertOWLPrimitive(OWLAnonymousIndividual ind) {
    String normal = ind.getID().getID().substring(Vocabulary.ANONYMOUS_NS.length());
    return wordManager.lookupOrCreateByKeyAndType(IRI.create(Vocabulary.ANONYMOUS_NS, normal), WordType.PROPER_NOUN);
  }

  private DataPredicate convertOWLPrimitive(OWLDataProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.DATA_PREDICATE);
  }

  private ObjectPredicate convertOWLPrimitive(OWLObjectProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.OBJECT_PREDICATE);
  }

  private AnnotationPredicate convertOWLPrimitive(OWLAnnotationProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.ANNOTATION_PREDICATE);
  }

  private Word convertOWLPrimitive(OWLAnnotationSubject subj) {

    if (subj.asIRI().isPresent()) {
      return convertOWLPrimitive(subj.asIRI().get());
    }

    if (subj.asAnonymousIndividual().isPresent()) {
      return convertOWLPrimitive(subj.asAnonymousIndividual().get());
    }

    LOGGER.error("Couldn't convert AnnotationSubject, not an AnonymousIndividual or IRI. Should not happen." + subj);
    return Vocabulary.ERROR;
  }

  private Word convertOWLPrimitive(OWLAnnotationValue value) {

    if (value.asIRI().isPresent()) {
      return convertOWLPrimitive(value.asIRI().get());
    }

    if (value.asAnonymousIndividual().isPresent()) {
      return convertOWLPrimitive(value.asAnonymousIndividual().get());
    }

    if (value.asLiteral().isPresent()) {
      return convertOWLPrimitive(value.asLiteral().get());
    }

    LOGGER.error(
        "Couldn't convert AnnotationSubject, not an AnonymousIndividual, Literal or IRI. Should not happen." + value);
    return Vocabulary.ERROR;
  }

  private DataFacet convertOWLPrimitive(OWLFacet facet) {
    String logical = facet.getShortForm();
    return DataFacet.getTypeByLogicalName(logical);
  }

  private Word convertOWLPrimitive(IRI iri) {
    // any existing word type
    return wordManager.lookupOrCreateByKeyAndType(iri, WordType.GENERIC_WORD);
  }

  private boolean isAdjective(OWLClass cl) {
    return cl.getIRI().toString().endsWith("_thing");
  }

  private SubjectObjectPhrase convertToSubjectObjectPhrase(Phrase phrase) {

    if (phrase instanceof SubjectObjectPhrase) {
      return (SubjectObjectPhrase) phrase;
    }

    if (phrase.isObjectScope()) {
      PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>) phrase;
      CategoryPhrase<CommonNoun> np = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
      np.addRelativePhrase(predPhrase);
      return np;
    }

    if (phrase.isDataScope()) {
      PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, DataPredicate>) phrase;
      CategoryPhrase<DataType> np = new CategoryPhrase<DataType>(Vocabulary.DATATYPE_THING);
      np.addRelativePhrase(predPhrase);
      return np;
    }

    LOGGER.error("Couldn't convert phrase to SubjectObjectPhrase:" + phrase);
    PredicatePhrase<SubjectObjectPhrase, Predicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, Predicate>) phrase;
    CategoryPhrase<CommonNoun> np = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
    np.addRelativePhrase(predPhrase);
    return np;

  }

  public Optional<Word> lookupPrimitive(OWLPrimitive prim) {

    if (prim instanceof OWLEntity) {
      OWLEntity ent = (OWLEntity) prim;
      if (ent.isType(EntityType.ANNOTATION_PROPERTY)) {
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.ANNOTATION_PREDICATE);
      }

      if (ent.isType(EntityType.CLASS)) {
        if (isAdjective((OWLClass) ent)) {
          return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.ADJECTIVE);
        }
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.COMMON_NOUN);
      }

      if (ent.isType(EntityType.DATA_PROPERTY)) {
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.DATA_PREDICATE);
      }

      if (ent.isType(EntityType.DATATYPE)) {
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.DATATYPE);
      }

      if (ent.isType(EntityType.NAMED_INDIVIDUAL)) {
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.PROPER_NOUN);
      }

      if (ent.isType(EntityType.OBJECT_PROPERTY)) {
        return wordManager.lookupByKeyAndType(ent.getIRI(), WordType.OBJECT_PREDICATE);
      }

    }

    if (prim instanceof OWLAnonymousIndividual) {
      OWLAnonymousIndividual anon = (OWLAnonymousIndividual) prim;
      String normal = anon.getID().getID().substring(Vocabulary.ANONYMOUS_NS.length());
      return wordManager.lookupByKeyAndType(IRI.create(Vocabulary.ANONYMOUS_NS, normal), WordType.PROPER_NOUN);
    }

    if (prim instanceof IRI) {
      return wordManager.lookupByKeyAndType((IRI) prim, WordType.GENERIC_WORD);
    }

    if (prim instanceof OWLLiteral) {
      LOGGER.error("Literals are not in WordManager" + prim);
      return Optional.empty();
    }

    LOGGER.error("Couldn't convert Primitive:" + prim);

    return Optional.empty();
  }

  private List<IRI> findBareIRIs(OWLOntology onto) {
    List<IRI> bares = new ArrayList<IRI>();
    List<IRI> entityIRIs = new ArrayList<IRI>();
    for (OWLEntity ent : OWLAPIStreamUtils.asSet(onto.signature(Imports.EXCLUDED))) {
      entityIRIs.add(ent.getIRI());
    } ;

    // bare IRIs can occur as AnnotationSubjects, AnnotationObjects or the
    // domain/range of annotationproperties
    List<OWLAnnotationAssertionAxiom> asserts = OWLAPIStreamUtils.asList(onto.axioms(AxiomType.ANNOTATION_ASSERTION));
    List<OWLAnnotationPropertyDomainAxiom> domains = OWLAPIStreamUtils
        .asList(onto.axioms(AxiomType.ANNOTATION_PROPERTY_DOMAIN));
    List<OWLAnnotationPropertyRangeAxiom> ranges = OWLAPIStreamUtils
        .asList(onto.axioms(AxiomType.ANNOTATION_PROPERTY_RANGE));

    for (OWLAnnotationAssertionAxiom ax : asserts) {
      OWLAnnotationSubject subj = ax.getSubject();
      OWLAnnotationValue value = ax.getValue();
      if (subj.isIRI() && !entityIRIs.contains(subj)) {
        bares.add((IRI) subj);
      }
      if (value.isIRI() && !entityIRIs.contains(value)) {
        bares.add((IRI) value);
      }
    }

    for (OWLAnnotationPropertyDomainAxiom ax : domains) {
      if (!entityIRIs.contains(ax.getDomain())) {
        bares.add(ax.getDomain());
      }

    }
    for (OWLAnnotationPropertyRangeAxiom ax : ranges) {
      if (!entityIRIs.contains(ax.getRange())) {
        bares.add(ax.getRange());
      }
    }

    return bares;
  }

  private List<OWLAnnotation> attachFootnotes(Statement statement, OWLAxiom ax) {
    List<OWLAnnotation> annos = OWLAPIStreamUtils.asList(ax.annotations());

    for (OWLAnnotation anno : annos) {
      Footnote foot = convertOWL(anno);
      statement.addFootnote(foot);
    }
    return annos;
  }

}
