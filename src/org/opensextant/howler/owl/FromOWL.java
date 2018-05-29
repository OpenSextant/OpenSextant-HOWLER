package org.opensextant.howler.owl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
import org.opensextant.howler.abstraction.phrases.WordPhrase;
import org.opensextant.howler.abstraction.statements.DeclarationStatement;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PredicateCharacteristicStatement;
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
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.PrefixDocumentFormat;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.DataRangeType;
import org.semanticweb.owlapi.model.EntityType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.MissingImportEvent;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.MissingImportListener;
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
import org.semanticweb.owlapi.model.OWLDocumentFormat;
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
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiomShortCut;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FromOWL {

  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(FromOWL.class);

  private OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();

  private WordManager wordManager = WordManager.getWordManager();

  // OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();
  // OWLDataFactory owlDataFactory = owlOntologyManager.getOWLDataFactory();

  // the limit of the number of pairwise axioms to create from a set of
  // entities or -1 to always do all
  private int maxPairs = -1;

  // change a union/intersection/oneOf with a single member to just that
  // member
  private boolean flattenSingleSet = false;

  // converted an axiom to its negation normal form
  private boolean negNormal = false;

  // convert an domain or range axiom to its subclass axiom logical equivalent
  private boolean rewriteDomainRanges = false;

  private boolean rewriteAllAsSubclass = false;

  private boolean repairPuns = false;

  public OWLOntologyManager getOntologyManager() {
    return ontologyManager;
  }

  public void setOntologyManager(OWLOntologyManager ontologyManager) {
    this.ontologyManager = ontologyManager;
  }

  public FromOWL(boolean ignoreMissingImports) {

    if (ignoreMissingImports) {
      OWLOntologyLoaderConfiguration loadConfig = new OWLOntologyLoaderConfiguration()
          .setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT).setStrict(false)
          .setFollowRedirects(true).setRepairIllegalPunnings(repairPuns).setTreatDublinCoreAsBuiltIn(false);

      ontologyManager.setOntologyLoaderConfiguration(loadConfig);

      // add a listener for any missing imports
      ontologyManager.addMissingImportListener(new MissingImportListener() {
        private static final long serialVersionUID = 1L;
        public void importMissing(MissingImportEvent event) {
          IRI importURI = event.getImportedOntologyURI();
          LOGGER.error("Cannot import\t" + importURI + "\t" + event.getCreationException().getMessage());
        }
      });
    }
  }

  public FromOWL() {
    this(true);
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

  // convert to negation normal form?
  public boolean isNegNormal() {
    return negNormal;
  }

  // set behavior for converting to negation normal form
  public void setNegNormal(boolean negNormal) {
    this.negNormal = negNormal;
  }

  // rewrite domain/range axioms to subclass axioms
  public boolean isRewriteDomainRanges() {
    return rewriteDomainRanges;
  }

  // set behavior for rewriting domain/range axioms to subclass axioms
  public void setRewriteDomainRanges(boolean rewriteDomainRanges) {
    this.rewriteDomainRanges = rewriteDomainRanges;
  }

  // rewrite all possible axioms as subclass equivalents
  public boolean isRewriteAllAsSubclass() {
    return rewriteAllAsSubclass;
  }

  // rewrite all possible axioms as subclass equivalents
  public void setRewriteAllAsSubclass(boolean rewriteAllAsSubclass) {
    this.rewriteAllAsSubclass = rewriteAllAsSubclass;
  }

  // convert a file containing an ontology to a Document
  public Document convertOWL(File ontoFile) {
    OWLOntology onto = loadOWL(ontoFile);
    return convertOWL(onto);
  }

  // convert a file containing an ontology to an ontology
  public OWLOntology loadOWL(File ontoFile) {

    // AutoMapper attempts to find imported ontologies located in same
    // directories as ontology
    AutoIRIMapper mapper = new AutoIRIMapper(ontoFile.getParentFile(), true);
    ontologyManager.getIRIMappers().add(mapper);

    try {
      OWLOntology onto = ontologyManager.loadOntologyFromOntologyDocument(ontoFile);
      LOGGER.trace("Loaded ontology from " + ontoFile);
      return onto;
    } catch (OWLOntologyCreationException e) {
      LOGGER.error("Could not load ontology from " + ontoFile + ":" + e.getMessage());
      return null;
    }
  }

  public Document convertOWL(OWLOntology onto) {

    Document doc = new Document();

    // add any namespace prefixes seen in onto to the word manager
    addNameSpacePrefixes(onto);

    // if the ontology has a ontology IRI, set the document equivalent
    if (onto.getOntologyID().getOntologyIRI().isPresent()) {
      doc.setDocumentID(onto.getOntologyID().getOntologyIRI().get());
    }

    // if the ontology has a version IRI, set the document equivalent
    if (onto.getOntologyID().getVersionIRI().isPresent()) {
      doc.setVersionID(onto.getOntologyID().getVersionIRI().get());
    }

    // add the ontology level annotations as footnotes to document
    for (OWLAnnotation anno : OWLAPIStreamUtils.asList(onto.annotations())) {
      doc.addFootnote(convertOWL(anno));
      // TODO can any of these be used as a title if present?
    }

    // add the imports
    doc.setImportedDocuments(OWLAPIStreamUtils.asList(onto.directImportsDocuments()));
    // TODO add option to convert the imports as well?

    // convert each axiom and add result to document
    for (OWLAxiom axiom : OWLAPIStreamUtils.asList(onto.axioms())) {
      List<? extends Statement> statements = convertOWL(axiom);

      String axString = axiom.toString();
      for (Statement st : statements) {
        st.setSource(axString);
        doc.addStatement(st);
      }
    }

    // create a declaration for each element of the signature not explicitly declared
    for (OWLEntity ent : OWLAPIStreamUtils.asList(onto.signature(Imports.EXCLUDED))) {
      // don't include builtin (OWL,RDF..) entities
      if (!onto.isDeclared(ent, Imports.EXCLUDED) && !ent.isBuiltIn()) {
        DeclarationStatement statement = new DeclarationStatement();
        statement.setWord(convertOWLPrimitive(ent));
        statement.setDerived(true);
        statement.setSource("Declaration(" + ent.getEntityType() + "(" + ent + "))");
        doc.addStatement(statement);
      }
    }

    // clear the manager
    ontologyManager.clearOntologies();

    return doc;
  }

  // convert each axiom by type
  public List<? extends Statement> convertOWL(OWLAxiom ax) {

    OWLAxiom axiom = ax;
    if (negNormal) {
      // rewrite axiom into its negation normal form
      axiom = ax.getNNF();
      if (!axiom.equals(ax)) {
        LOGGER.debug("Rewrote to negation normal form:" + ax + " => " + axiom);
      }
    }

    // if rewriting axioms as subclasses
    if (axiom instanceof OWLSubClassOfAxiomShortCut) {
      OWLSubClassOfAxiomShortCut sub = (OWLSubClassOfAxiomShortCut) axiom;

      if (rewriteDomainRanges && (axiom instanceof OWLPropertyRangeAxiom || axiom instanceof OWLPropertyDomainAxiom)) {
        axiom = sub.asOWLSubClassOfAxiom();
        LOGGER.debug("Rewrote " + ax.getAxiomType() + "to subclass equivalent:" + ax + " => " + axiom);
      }

      if (this.rewriteAllAsSubclass) {
        axiom = sub.asOWLSubClassOfAxiom();
        LOGGER.debug("Rewrote " + ax.getAxiomType() + "to subclass equivalent:" + ax + " => " + axiom);
      }

    }

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

  private List<DeclarationStatement> convertOWL(OWLDeclarationAxiom ax) {
    List<DeclarationStatement> statementList = new ArrayList<DeclarationStatement>();

    DeclarationStatement statement = new DeclarationStatement();

    statement.setWord(convertOWLPrimitive(ax.getEntity()));
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLEquivalentClassesAxiom ax) {
    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    // do as pairwise rather than single set of n
    Collection<OWLEquivalentClassesAxiom> axs = ax.asPairwiseAxioms();

    // look for no pairs
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

      SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj), Quantifier.A);

      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj), Quantifier.A);

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

      SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj), Quantifier.A);

      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj), Quantifier.A);

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

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj), Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj), Quantifier.A);

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

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(subj), Quantifier.EVERY);

    PhraseSet<SubjectObjectPhrase> objPhrases = new PhraseSet<SubjectObjectPhrase>();
    objPhrases.setSetType(BooleanSetType.OR);

    for (OWLClassExpression objCE : objs) {
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(objCE), Quantifier.A);
      objPhrases.addPhrase(objPhrase);
    }

    objPhrases.setDisjoint(true);

    PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.SAME_Object);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pred, objPhrases);

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
    subjPhrase.setQuantifierType(Quantifier.NULL);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(obj), Quantifier.A);

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

    Collection<OWLSameIndividualAxiom> axs = ax.asPairwiseAxioms();

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
      subjPhrase.setQuantifierType(Quantifier.NULL);

      InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
      objPhrase.setQuantifierType(Quantifier.NULL);

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
      subjPhrase.setQuantifierType(Quantifier.NULL);

      InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
      objPhrase.setQuantifierType(Quantifier.NULL);

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
    subjPhrase.setQuantifierType(Quantifier.NULL);

    InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
    subjPhrase.setQuantifierType(Quantifier.NULL);

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
    subjPhrase.setQuantifierType(Quantifier.NULL);

    InstancePhrase<ProperNoun> objPhrase = convertOWL(obj);
    subjPhrase.setQuantifierType(Quantifier.NULL);

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
    subjPhrase.setQuantifierType(Quantifier.NULL);

    InstancePhrase<DataValue> objPhrase = convertOWL(obj);
    objPhrase.setQuantifierType(Quantifier.NULL);

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
    subjPhrase.setQuantifierType(Quantifier.NULL);

    InstancePhrase<DataValue> objPhrase = convertOWL(obj);
    objPhrase.setQuantifierType(Quantifier.NULL);

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
      PredicateExpression<ObjectPredicate> obj = convertOWL(propPair.get(1));
      PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
          PredicateType.SAME_AS, obj);
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
    PredicateExpression<ObjectPredicate> obj = convertOWL(ax.getSuperProperty());
    PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
        PredicateType.IS, obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);
    return statementList;
  }

  private List<PredicateRelationStatement<ObjectPredicate>> convertOWL(OWLInverseObjectPropertiesAxiom ax) {
    List<PredicateRelationStatement<ObjectPredicate>> statementList = new ArrayList<PredicateRelationStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subj = convertOWL(ax.getFirstProperty());
    PredicateExpression<ObjectPredicate> obj = convertOWL(ax.getSecondProperty());

    PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
        PredicateType.SAME_AS, obj);
    statement.setInverse(true);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLFunctionalObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.FUNCTIONAL;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(
      OWLInverseFunctionalObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.INVERSE_FUNCTIONAL;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLSymmetricObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.SYMMETRIC;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLAsymmetricObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.ASYMMETRIC;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLTransitiveObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.TRANSITIVE;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLReflexiveObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.REFLEXIVE;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateCharacteristicStatement<ObjectPredicate>> convertOWL(OWLIrreflexiveObjectPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<ObjectPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<ObjectPredicate>>();

    PredicateExpression<ObjectPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.IRREFLEXIVE;

    PredicateCharacteristicStatement<ObjectPredicate> statement = new PredicateCharacteristicStatement<ObjectPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLObjectPropertyDomainAxiom ax) {

    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(ax.getDomain()), Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<CommonNoun>(Vocabulary.THING),
        Quantifier.SOME);

    PredicateExpression<ObjectPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    statement.setDomain(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;

  }

  private List<DescriptionStatement<ObjectPredicate>> convertOWL(OWLObjectPropertyRangeAxiom ax) {

    List<DescriptionStatement<ObjectPredicate>> statementList = new ArrayList<DescriptionStatement<ObjectPredicate>>();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<CommonNoun>(Vocabulary.THING),
        Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(ax.getRange()), Quantifier.A);

    PredicateExpression<ObjectPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        predExp, objPhrase);

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    statement.setRange(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;

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

      PredicateExpression<ObjectPredicate> pred = new PredicateExpression<ObjectPredicate>(Vocabulary.IS_Object);
      pred.setNegative(true);

      PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subj,
          PredicateType.IS, obj);
      statement.setNegative(true);
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

      PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj,
          PredicateType.SAME_AS, obj);
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

    PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj,
        PredicateType.IS, obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<PredicateCharacteristicStatement<DataPredicate>> convertOWL(OWLFunctionalDataPropertyAxiom ax) {
    List<PredicateCharacteristicStatement<DataPredicate>> statements = new ArrayList<PredicateCharacteristicStatement<DataPredicate>>();

    PredicateExpression<DataPredicate> subjExp = convertOWL(ax.getProperty());

    PredicateCharacteristic ch = PredicateCharacteristic.FUNCTIONAL;

    PredicateCharacteristicStatement<DataPredicate> statement = new PredicateCharacteristicStatement<DataPredicate>(
        subjExp, ch);
    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<DescriptionStatement<DataPredicate>> convertOWL(OWLDataPropertyDomainAxiom ax) {

    List<DescriptionStatement<DataPredicate>> statementList = new ArrayList<DescriptionStatement<DataPredicate>>();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(convertOWL(ax.getDomain()), Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<DataType>(Vocabulary.LITERAL_TYPE),
        Quantifier.A);

    PredicateExpression<DataPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();
    statement.setDomain(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<DescriptionStatement<DataPredicate>> convertOWL(OWLDataPropertyRangeAxiom ax) {

    List<DescriptionStatement<DataPredicate>> statementList = new ArrayList<DescriptionStatement<DataPredicate>>();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<CommonNoun>(Vocabulary.THING),
        Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(ax.getRange()), Quantifier.A);

    PredicateExpression<DataPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();
    statement.setRange(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
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

      PredicateExpression<DataPredicate> pred = new PredicateExpression<DataPredicate>(Vocabulary.IS_Data);
      pred.setNegative(true);

      PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subj,
          PredicateType.IS, obj);
      statement.setNegative(true);
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
    subj.setQuantifierType(Quantifier.A);

    SubjectObjectPhrase obj = convertOWL(ax.getDataRange());
    obj.setQuantifierType(Quantifier.A);

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

  private List<DescriptionStatement<AnnotationPredicate>> convertOWL(OWLAnnotationAssertionAxiom ax) {

    List<DescriptionStatement<AnnotationPredicate>> statements = new ArrayList<DescriptionStatement<AnnotationPredicate>>();

    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();

    Word subjWord = convertOWLPrimitive(ax.getSubject());

    WordPhrase subj = new WordPhrase(subjWord);

    AnnotationPredicate pred = convertOWLPrimitive(ax.getProperty());
    Word objWord = convertOWLPrimitive(ax.getValue());
    WordPhrase obj = new WordPhrase(objWord);

    PredicateExpression<AnnotationPredicate> pe = new PredicateExpression<AnnotationPredicate>(pred);

    PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predicatePhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
        pe, obj);

    // add to word manager as possible instance of an entity label
    wordManager.addLabelAnnotation(subjWord, pred, objWord);

    statement.setSubject(subj);
    statement.setPredicatePhrase(predicatePhrase);

    attachFootnotes(statement, ax);
    statements.add(statement);

    return statements;
  }

  private List<PredicateRelationStatement<AnnotationPredicate>> convertOWL(OWLSubAnnotationPropertyOfAxiom ax) {
    List<PredicateRelationStatement<AnnotationPredicate>> statementList = new ArrayList<PredicateRelationStatement<AnnotationPredicate>>();

    PredicateExpression<AnnotationPredicate> subj = convertOWL(ax.getSubProperty());
    PredicateExpression<AnnotationPredicate> obj = convertOWL(ax.getSuperProperty());

    PredicateRelationStatement<AnnotationPredicate> statement = new PredicateRelationStatement<AnnotationPredicate>(
        subj, PredicateType.IS, obj);
    attachFootnotes(statement, ax);
    statementList.add(statement);

    return statementList;
  }

  private List<DescriptionStatement<AnnotationPredicate>> convertOWL(OWLAnnotationPropertyRangeAxiom ax) {
    List<DescriptionStatement<AnnotationPredicate>> statementList = new ArrayList<DescriptionStatement<AnnotationPredicate>>();

    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<CommonNoun>(Vocabulary.THING),
        Quantifier.EVERY);

    Word obj = convertOWLPrimitive(ax.getRange());
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(new WordPhrase(obj), Quantifier.A);

    PredicateExpression<AnnotationPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
        predExp, objPhrase);

    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();
    statement.setRange(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
  }

  private List<DescriptionStatement<AnnotationPredicate>> convertOWL(OWLAnnotationPropertyDomainAxiom ax) {
    List<DescriptionStatement<AnnotationPredicate>> statementList = new ArrayList<DescriptionStatement<AnnotationPredicate>>();

    Word subj = convertOWLPrimitive(ax.getDomain());
    SubjectObjectPhrase subjPhrase = convertToSubjectObjectPhrase(new WordPhrase(subj), Quantifier.EVERY);

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(new CategoryPhrase<CommonNoun>(Vocabulary.THING),
        Quantifier.A);

    PredicateExpression<AnnotationPredicate> predExp = convertOWL(ax.getProperty());
    PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
        predExp, objPhrase);

    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();
    statement.setDomain(true);
    statement.setSubject(subjPhrase);
    statement.setPredicatePhrase(predPhrase);
    attachFootnotes(statement, ax);

    statementList.add(statement);

    return statementList;
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
    LOGGER.warn("OWLSubPropertyChainOfAxiom not yet supported:" + ax);
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
    LOGGER.warn("OWLHasKeyAxiom not yet supported:" + ax);
    return statementList;
  }

  private List<Statement> convertOWL(SWRLRule rule) {
    List<Statement> statementList = new ArrayList<Statement>();
    // TODO
    LOGGER.warn("SWRLRule not yet supported:" + rule);
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

    LOGGER.error("Should not happen. Could not convert ClassExpression of type:" + type + " " + ce);

    return new CategoryPhrase<CommonNoun>(Vocabulary.THING);
  }

  private CategoryPhrase<Noun> convertOWL(OWLClass cl) {
    Noun n = convertOWLPrimitive(cl);
    CategoryPhrase<Noun> np = new CategoryPhrase<Noun>(n);
    return np;
  }

  private Phrase convertOWL(OWLObjectUnionOf ce) {

    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.OR);

    List<OWLClassExpression> members = ce.getOperandsAsList();

    if (members.size() == 1 && flattenSingleSet) {
      return convertOWL(members.get(0));
    }

    // convert all set members to phrases
    for (OWLClassExpression member : members) {
      Phrase phrase = convertOWL(member);
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.NULL);

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

    // if members are a set of categories and predicate phrases-> category
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
    phSet.setSetType(BooleanSetType.AND);

    // convert all set members to phrases
    for (OWLClassExpression member : members) {
      Phrase phrase = convertOWL(member);
      SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.NULL);
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
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(convertOWL(objCE), Quantifier.ONLY);

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

    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.SOME);

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
    np.setQuantifierType(Quantifier.NULL);

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
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.EXACT, ce.getCardinality());

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
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.LESS_THAN_OR_EQUAL,
        ce.getCardinality());

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
    SubjectObjectPhrase objPhrase = convertToSubjectObjectPhrase(phrase, Quantifier.MORE_THAN_OR_EQUAL,
        ce.getCardinality());

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
    objPhrase.setQuantifierType(Quantifier.EVERY);

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
    ip.setQuantifierType(Quantifier.NULL);

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
    objPhrase.setQuantifierType(Quantifier.ONLY);

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
    objPhrase.setQuantifierType(Quantifier.SOME);

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
    objPhrase.setQuantifierType(Quantifier.EXACT);
    objPhrase.getQuantifierExpression().setQuantity(ce.getCardinality());

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
    objPhrase.setQuantifierType(Quantifier.LESS_THAN_OR_EQUAL);
    objPhrase.getQuantifierExpression().setQuantity(ce.getCardinality());

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
    objPhrase.setQuantifierType(Quantifier.MORE_THAN_OR_EQUAL);
    objPhrase.getQuantifierExpression().setQuantity(ce.getCardinality());

    // assemble predicate phrase
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, objPhrase);

    return predPhrase;
  }

  // --------------- Properties and Property Expressions ------

  // Object property expression to Predicate
  private PredicateExpression<ObjectPredicate> convertOWL(OWLObjectPropertyExpression prop) {

    // check for explicit inverse
    if (prop instanceof OWLObjectInverseOf) {
      return convertOWL((OWLObjectInverseOf) prop);
    }

    // TODO check for is_X_by form? convert to inverse?

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
    predExp.setInverse(true);
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

    LOGGER.error("Should not happen. Could not convert DataRange of type " + drType + " " + dr);
    return new CategoryPhrase<DataType>(Vocabulary.LITERAL_TYPE);
  }

  private CategoryPhrase<DataType> convertOWL(OWLDatatype odt) {
    DataType dt = convertOWLPrimitive(odt);
    CategoryPhrase<DataType> cat = new CategoryPhrase<DataType>(dt);
    return cat;
  }

  private SubjectObjectPhrase convertOWL(OWLDataIntersectionOf dr) {

    PhraseSet<SubjectObjectPhrase> phSet = new PhraseSet<SubjectObjectPhrase>();
    phSet.setSetType(BooleanSetType.AND);

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
    phSet.setSetType(BooleanSetType.OR);
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
      val.setQuantifierType(Quantifier.NULL);

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

    LOGGER.error(" Should not happen. Couldn't convert Entity of unknown type." + ent);
    return Vocabulary.THING;
  }

  private Noun convertOWLPrimitive(OWLClass cl) {
    if (isAdjective(cl)) {
      return wordManager.lookupOrCreateByKeyAndType(cl.getIRI(), WordType.ADJECTIVE, true);
    } else {
      return wordManager.lookupOrCreateByKeyAndType(cl.getIRI(), WordType.COMMON_NOUN, true);
    }
  }

  private DataType convertOWLPrimitive(OWLDatatype dt) {
    return wordManager.lookupOrCreateByKeyAndType(dt.getIRI(), WordType.DATATYPE, true);
  }

  private DataValue convertOWLPrimitive(OWLLiteral lit) {

    String value = lit.getLiteral();
    OWLDatatype odt = lit.getDatatype();
    String lang = lit.getLang();

    DataType dt = convertOWLPrimitive(odt);

    if (value.isEmpty()) {
      LOGGER.trace("Literal with empty value");
    }

    if (!lang.isEmpty() && !lang.equals("en")) {
      LOGGER.trace("Found a non-English literal" + lit);
    }

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
    return wordManager.lookupOrCreateByKeyAndType(ind.getIRI(), WordType.PROPER_NOUN, true);
  }

  private ProperNoun convertOWLPrimitive(OWLAnonymousIndividual ind) {
    // TODO better model for normal for anonymous individuals. Globalize?
    String normal = ind.getID().getID().substring(Vocabulary.ANONYMOUS_NS.length());
    return wordManager.lookupOrCreateByKeyAndType(IRI.create(Vocabulary.ANONYMOUS_NS, normal), WordType.PROPER_NOUN,
        true);
  }

  private DataPredicate convertOWLPrimitive(OWLDataProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.DATA_PREDICATE, true);
  }

  private ObjectPredicate convertOWLPrimitive(OWLObjectProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.OBJECT_PREDICATE, true);
  }

  private AnnotationPredicate convertOWLPrimitive(OWLAnnotationProperty prop) {
    return wordManager.lookupOrCreateByKeyAndType(prop.getIRI(), WordType.ANNOTATION_PREDICATE, true);
  }

  private Word convertOWLPrimitive(OWLAnnotationSubject subj) {

    if (subj.asIRI().isPresent()) {
      return convertOWLPrimitive(subj.asIRI().get());
    }

    if (subj.asAnonymousIndividual().isPresent()) {
      return convertOWLPrimitive(subj.asAnonymousIndividual().get());
    }

    LOGGER.error(" Should not happen. Couldn't convert AnnotationSubject, not an AnonymousIndividual or IRI." + subj);
    return Vocabulary.THING;
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
        " Should not happen. Couldn't convert AnnotationSubject, not an AnonymousIndividual, Literal or IRI." + value);
    return Vocabulary.THING;
  }

  private DataFacet convertOWLPrimitive(OWLFacet facet) {
    String logical = facet.getShortForm();
    return DataFacet.getTypeByLogicalName(logical);
  }

  private Word convertOWLPrimitive(IRI iri) {
    // find any existing word type or create a generic
    return wordManager.lookupOrCreateByKey(iri, true);
  }

  // check if class is using the HOWLER adjective naming convention
  private boolean isAdjective(OWLClass cl) {
    return cl.getIRI().toString().endsWith("_thing");
  }

  private SubjectObjectPhrase convertToSubjectObjectPhrase(Phrase phrase, Quantifier q) {

    if (phrase instanceof SubjectObjectPhrase) {
      SubjectObjectPhrase so = (SubjectObjectPhrase) phrase;

      if (so.getQuantifierType().equals(Quantifier.NULL)) {
        so.setQuantifierType(q);
      }

      return so;
    }

    if (phrase.isObjectScope()) {
      PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>) phrase;
      CategoryPhrase<CommonNoun> np = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
      np.setQuantifierType(Quantifier.SOME);
      if (predPhrase.getObject().equals(Quantifier.NULL)) {
        predPhrase.getObject().setQuantifierType(q);
      }
      np.addRelativePhrase(predPhrase);
      return np;
    }

    if (phrase.isDataScope()) {
      PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, DataPredicate>) phrase;
      CategoryPhrase<CommonNoun> np = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
      np.setQuantifierType(Quantifier.SOME);
      if (predPhrase.getObject().equals(Quantifier.NULL)) {
        predPhrase.getObject().setQuantifierType(q);
      }
      np.addRelativePhrase(predPhrase);
      return np;
    }

    if (phrase.isAnnotationScope()) {
      LOGGER
          .error("Couldn't convert annotation predicate phrase to relative phrase Forcing to object phrase:" + phrase);
    }

    PredicatePhrase<SubjectObjectPhrase, Predicate> predPhrase = (PredicatePhrase<SubjectObjectPhrase, Predicate>) phrase;
    CategoryPhrase<CommonNoun> np = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
    np.setQuantifierType(Quantifier.SOME);
    if (predPhrase.getObject().equals(Quantifier.NULL)) {
      predPhrase.getObject().setQuantifierType(q);
    }
    np.addRelativePhrase(predPhrase);
    return np;

  }

  private SubjectObjectPhrase convertToSubjectObjectPhrase(Phrase phrase, Quantifier q, int quantity) {

    if (!q.isNumeric()) {
      LOGGER.warn("Tried to set a quantity for a non-numerical Quantifier. Ignoring quantity:" + q);
    }

    SubjectObjectPhrase so = convertToSubjectObjectPhrase(phrase, q);
    so.getQuantifierExpression().setQuantity(quantity);
    return so;
  }

  // add any axiom annotations to statement as footnotes
  private List<OWLAnnotation> attachFootnotes(Statement statement, OWLAxiom ax) {
    List<OWLAnnotation> annos = OWLAPIStreamUtils.asList(ax.annotations());

    for (OWLAnnotation anno : annos) {
      Footnote foot = convertOWL(anno);
      statement.addFootnote(foot);
    }

    return annos;
  }

  // add any prefixes defined to the word manager
  private void addNameSpacePrefixes(OWLOntology onto) {

    OWLDocumentFormat format = ontologyManager.getOntologyFormat(onto);
    // does this format include prefixes?
    if (format != null && format.isPrefixOWLDocumentFormat()) {
      PrefixDocumentFormat prefixFormat = format.asPrefixOWLDocumentFormat();

      Map<String, String> nsMap = prefixFormat.getPrefixName2PrefixMap();
      // add any prefix except default (:) to the word manager
      for (String prefix : nsMap.keySet()) {
        if (!prefix.equals(":")) {
          this.wordManager.addPrefix(prefix, IRI.create(nsMap.get(prefix)));
        }
      }
    } else {
      LOGGER.trace("Ontology " + onto.getOntologyID().getDefaultDocumentIRI() + " does not have any prefixes defined");
    }
  }

}
