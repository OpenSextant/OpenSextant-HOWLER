package org.opensextant.howler.owl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.CategoryPhrase;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.phrases.InstancePhrase;
import org.opensextant.howler.abstraction.phrases.PhraseSet;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.QuantifierExpression;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.phrases.WordPhrase;
import org.opensextant.howler.abstraction.statements.DeclarationStatement;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PredicateCharacteristicStatement;
import org.opensextant.howler.abstraction.statements.PredicateRelationStatement;
import org.opensextant.howler.abstraction.statements.WordSequence;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Instance;
import org.opensextant.howler.abstraction.words.Noun;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.DataRangeType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnnotationValue;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLFacetRestriction;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ToOWL {

  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(ToOWL.class);

  OWLOntologyManager owlOntologyManager;
  OWLDataFactory owlDataFactory;

  // write predicate phrases with a single Proper as HasValue
  private boolean useHasValue = false;

  public ToOWL() {
    // create OWLAPI manager and factory
    owlOntologyManager = OWLManager.createOWLOntologyManager();
    owlDataFactory = owlOntologyManager.getOWLDataFactory();
  }

  public OWLOntology convert(Document doc) {
    return convert(doc, true);
  }

  public boolean isUseHasValue() {
    return useHasValue;
  }

  public void setUseHasValue(boolean useHasValue) {
    this.useHasValue = useHasValue;
  }

  public OWLOntology convert(Document doc, boolean clear) {

    Optional<IRI> ontoIRI = doc.getDocumentID();
    Optional<IRI> ontoVersionIRI = doc.getVersionID();
    OWLOntologyID ontoID = new OWLOntologyID(ontoIRI, ontoVersionIRI);

    OWLOntology onto = null;

    if (clear) {
      owlOntologyManager.removeOntology(ontoID);
    }

    try {
      onto = owlOntologyManager.createOntology(ontoID);
    } catch (OWLOntologyCreationException e) {
      LOGGER.error("Could not create ontology with ID " + ontoIRI + " " + e.getMessage());
      // TODO what can be returned here instead of null?
      return null;

    }

    // add the ontology level annotations
    List<OWLOntologyChange> ontoAdds = new ArrayList<OWLOntologyChange>();
    for (Footnote foot : doc.getFootnotes()) {
      ontoAdds.add(new AddOntologyAnnotation(onto, convertAnnotation(foot)));
    }

    for (IRI imported : doc.getImportedDocuments()) {
      ontoAdds.add(new AddImport(onto, owlDataFactory.getOWLImportsDeclaration(imported)));
    }

    // apply the adds for annotations and imports
    owlOntologyManager.applyChanges(ontoAdds);

    // convert the statements
    for (Statement statement : doc.getStatements()) {
      for (OWLAxiom ax : convert(statement)) {
        try {
          owlOntologyManager.addAxiom(onto, rewriteDomainRange(ax));
        } catch (Exception e) {
          LOGGER.error("Unable to add axiom to ontology: " + ax + ":" + e.getMessage());
          continue;
        }
      }
    }

    return onto;
  }

  public List<OWLAxiom> convert(List<? extends Statement> statements) {

    ArrayList<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    for (Statement statement : statements) {
      axs.addAll(convert(statement));
    }

    return rewriteDomainRanges(axs);
  }

  public List<OWLAxiom> convert(Statement statement) {

    if (statement instanceof DescriptionStatement) {
      DescriptionStatement<?> dstate = (DescriptionStatement<?>) statement;

      if (dstate.isAnnotationStatement()) {
        return convertAnnotation(dstate.asAnnotationStatement());
      }
      if (dstate.isDataStatement()) {
        return convertData(dstate.asDataStatement());
      }
      if (dstate.isObjectStatement()) {
        return convertObject(dstate.asObjectStatement());
      }

    }

    if (statement instanceof FactStatement) {

      FactStatement<?, ?> fstate = (FactStatement<?, ?>) statement;

      if (statement.isAnnotationStatement()) {
        return convertAnnotation(fstate.asAnnotationStatement());
      }
      if (statement.isDataStatement()) {
        return convertData(fstate.asDataStatement());
      }
      if (statement.isObjectStatement()) {
        return convertObject((fstate.asObjectStatement()));
      }

    }

    if (statement instanceof PredicateRelationStatement) {

      if (statement.isObjectStatement()) {
        return convertObject((PredicateRelationStatement<ObjectPredicate>) statement);
      }

      if (statement.isDataStatement()) {
        return convertData((PredicateRelationStatement<DataPredicate>) statement);
      }

      if (statement.isAnnotationStatement()) {
        return convertAnnotation((PredicateRelationStatement<AnnotationPredicate>) statement);
      }

    }

    if (statement instanceof PredicateCharacteristicStatement) {

      if (statement.isObjectStatement()) {
        return convertObject((PredicateCharacteristicStatement<ObjectPredicate>) statement);
      }

      if (statement.isDataStatement()) {
        return convertData((PredicateCharacteristicStatement<DataPredicate>) statement);
      }

      if (statement.isAnnotationStatement()) {
        return convertAnnotation((PredicateCharacteristicStatement<AnnotationPredicate>) statement);
      }

    }

    if (statement instanceof DeclarationStatement) {
      return convert((DeclarationStatement) statement);
    }

    if (statement instanceof WordSequence) {
      return convert((WordSequence) statement);
    }

    LOGGER.error("Could not convert Statement:" + statement);
    return new ArrayList<OWLAxiom>();
  }

  public void saveOntology(OWLOntology onto, File out) {

    OWLDocumentFormat format = this.owlOntologyManager.getOntologyFormat(onto);

    // TODO allow other formats
    OWLXMLDocumentFormat newFormat = new OWLXMLDocumentFormat();

    // copy the prefixes if supported by format
    if (format.isPrefixOWLDocumentFormat()) {
      newFormat.copyPrefixesFrom(format.asPrefixOWLDocumentFormat());
    }
    try {
      owlOntologyManager.saveOntology(onto, newFormat, IRI.create(out.toURI()));
    } catch (OWLOntologyStorageException e) {
      LOGGER.error("Cannot save ontology to file:" + e.getMessage());
    }
  }

  public OWLOntologyManager getOwlOntologyManager() {
    return owlOntologyManager;
  }

  public void setOwlOntologyManager(OWLOntologyManager owlOntologyManager) {
    this.owlOntologyManager = owlOntologyManager;
  }

  private List<OWLAxiom> convertObject(DescriptionStatement<ObjectPredicate> statement) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    // SubClassOf
    // DisjointClasses (same_as negative)
    // EquivalentClasses (same_as)
    // DisjointUnion (is_only)

    SubjectObjectPhrase subjPhrase = statement.getSubject();
    // TODO check quantifier for SOME, force to EVERY? some other form?

    PredicateExpression<ObjectPredicate> pExp = statement.getPredicatePhrase().getPredicateExpression();

    boolean neg = pExp.isNegative();
    PredicateType predType = pExp.getPredicate().getPredicateType();

    SubjectObjectPhrase objPhrase = statement.getPredicatePhrase().getObject();

    // boolean exclusive = objPhrase.getQuantifier().getQuantifierType().equals(Quantifier.EITHER);

    OWLObjectPropertyExpression propExp = convertObject(pExp);

    OWLClassExpression subjCE = convertObject(subjPhrase);
    OWLClassExpression objCE = convertObject(objPhrase);

    List<OWLClassExpression> cePair = new ArrayList<OWLClassExpression>();
    cePair.add(subjCE);
    cePair.add(objCE);

    List<OWLAnnotation> annos = createAnnotations(statement);

    if (predType == PredicateType.IS) {
      if (neg) {
        axs.add(owlDataFactory.getOWLDisjointClassesAxiom(cePair, annos));
      } else {
        axs.add(owlDataFactory.getOWLSubClassOfAxiom(subjCE, objCE, annos));
      }
      return axs;
    }

    if (predType == PredicateType.SAME_AS) {

      // disjoint union
      if (subjCE.isOWLClass() && objPhrase instanceof PhraseSet) {

        PhraseSet setPhrase = (PhraseSet) objPhrase;

        if (setPhrase.isDisjoint() && setPhrase.getSetType().equals(BooleanSetType.OR)) {
          OWLObjectUnionOf union = (OWLObjectUnionOf) objCE;
          List<OWLClassExpression> ops = union.getOperandsAsList();

          axs.add(owlDataFactory.getOWLDisjointUnionAxiom(subjCE.asOWLClass(), ops, annos));
          return axs;
        }

        if (neg) {
          axs.add(owlDataFactory.getOWLDisjointClassesAxiom(cePair, annos));
        } else {
          axs.add(owlDataFactory.getOWLEquivalentClassesAxiom(subjCE, objCE, annos));
        }

      } else {

        if (neg) {
          axs.add(owlDataFactory.getOWLDisjointClassesAxiom(cePair, annos));
        } else {
          axs.add(owlDataFactory.getOWLEquivalentClassesAxiom(subjCE, objCE, annos));
        }
        return axs;
      }

    }

    if (predType == PredicateType.VERB) {

      if (statement.isDomain()) {

        axs.add(owlDataFactory.getOWLObjectPropertyDomainAxiom(propExp, subjCE));
        return axs;
      }

      if (statement.isRange()) {
        axs.add(owlDataFactory.getOWLObjectPropertyRangeAxiom(propExp, objCE));
        return axs;
      }

      // convert ObjCE to thing that <propertyExpression> ObjCE
      if (neg) {
        axs.add(owlDataFactory.getOWLSubClassOfAxiom(subjCE,
            owlDataFactory.getOWLObjectSomeValuesFrom(propExp, objCE.getObjectComplementOf()), annos));
        return axs;
      } else {
        axs.add(owlDataFactory.getOWLSubClassOfAxiom(subjCE, owlDataFactory.getOWLObjectSomeValuesFrom(propExp, objCE),
            annos));
        return axs;
      }

    }
    return axs;

  }

  private List<OWLAxiom> convertData(DescriptionStatement<DataPredicate> statement) {

    // DatatypeDefinition

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    PredicateExpression<DataPredicate> pExp = statement.getPredicatePhrase().getPredicateExpression();

    boolean neg = pExp.isNegative();
    PredicateType predType = pExp.getPredicate().getPredicateType();
    // TODO must be SAME_AS check
    // DataPredicate pred = pExp.getPredicate();

    OWLDataPropertyExpression propExp = convertData(pExp);

    SubjectObjectPhrase subjPhrase = statement.getSubject();
    // TODO check quantifier for SOME
    SubjectObjectPhrase objPhrase = statement.getPredicatePhrase().getObject();

    List<OWLAnnotation> annos = createAnnotations(statement);

    if (statement.isDomain()) {
      OWLClassExpression subjCE = convertObject(subjPhrase);
      axs.add(owlDataFactory.getOWLDataPropertyDomainAxiom(propExp, subjCE));
      return axs;
    }

    OWLDataRange objDR = convertData(objPhrase);

    if (statement.isRange()) {
      axs.add(owlDataFactory.getOWLDataPropertyRangeAxiom(propExp, objDR));
      return axs;
    }

    if (predType == PredicateType.IS) {
      LOGGER.error("Cannot translate IS Datatype statement" + statement);
      return axs;
    }

    if (predType == PredicateType.SAME_AS) {

      if (subjPhrase.isDataScope() && subjPhrase instanceof CategoryPhrase
          && ((CategoryPhrase) subjPhrase).isSimple()) {
        DataType head = ((CategoryPhrase<DataType>) subjPhrase).getHead();
        OWLDatatype odt = convertWord(head);
        if (neg) {
          axs.add(
              owlDataFactory.getOWLDatatypeDefinitionAxiom(odt, owlDataFactory.getOWLDataComplementOf(objDR), annos));
        } else {
          axs.add(owlDataFactory.getOWLDatatypeDefinitionAxiom(odt, objDR, annos));
        }
        return axs;
      }
      LOGGER.error("Cannot translate SAME_AS Datatype statement" + statement);

      return axs;
    }

    // must be VERB type predicate

    if (subjPhrase instanceof CategoryPhrase) {
      CategoryPhrase<?> subjCat = (CategoryPhrase<?>) subjPhrase;
      if (subjCat.isSimple() && subjCat.getHead() instanceof DataType) {
        OWLDatatype dt = convertWord((DataType) subjCat.getHead());
        axs.add(owlDataFactory.getOWLDatatypeDefinitionAxiom(dt, objDR, annos));
        return axs;
      }
    } else {
      LOGGER.error("Cannot translate complex Datatype statement" + statement);
    }

    return axs;

  }

  private List<OWLAxiom> convertAnnotation(DescriptionStatement<AnnotationPredicate> statement) {

    // AnnotationAssertion
    // AnnotationDomain/Range

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    Word subjWord = null;
    Word objWord = null;

    PredicateExpression<AnnotationPredicate> predExp = statement.getPredicatePhrase().getPredicateExpression();
    OWLAnnotationProperty prop = convertAnnotation(predExp);

    // subject can be any single word except DataValue
    SubjectObjectPhrase subjPhrase = statement.getSubject();

    if (subjPhrase instanceof WordPhrase) {
      subjWord = ((WordPhrase) subjPhrase).getHead();
    }

    if (subjPhrase instanceof CategoryPhrase) {
      CategoryPhrase catPhrase = (CategoryPhrase) subjPhrase;
      if (catPhrase.isSimple()) {
        subjWord = catPhrase.getHead();
      }

      if (catPhrase.isThingThatPhrase()) {
        List<PredicatePhrase> thingPhrase = catPhrase.getRelativePhrases();

      }

    }

    if (subjWord == null) {
      LOGGER.error("Cannot annotate " + subjPhrase + " in " + statement);
      return axs;
    }

    // object can be any single word
    SubjectObjectPhrase objPhrase = statement.getPredicatePhrase().getObject();

    if (objPhrase instanceof InstancePhrase) {
      objWord = ((InstancePhrase<?>) objPhrase).getHead();
    }

    if (objPhrase instanceof WordPhrase) {
      objWord = ((WordPhrase) objPhrase).getHead();
    }

    if (objPhrase instanceof CategoryPhrase) {
      objWord = ((CategoryPhrase) objPhrase).getHead();
    }

    if (objWord == null) {
      LOGGER.error("Could not determine object of annotation:" + statement);
      return axs;
    }

    if (statement.isDomain()) {
      axs.add(owlDataFactory.getOWLAnnotationPropertyDomainAxiom(prop, convertWord(subjWord)));
      return axs;
    }

    if (statement.isRange()) {
      axs.add(owlDataFactory.getOWLAnnotationPropertyRangeAxiom(prop, convertWord(objWord)));
      return axs;
    }

    List<OWLAnnotation> annos = createAnnotations(statement);

    OWLAnnotationSubject subject = convertAnnotationSubject(subjWord);
    OWLAnnotationValue object = convertAnnotationValue(objWord);

    axs.add(owlDataFactory.getOWLAnnotationAssertionAxiom(prop, subject, object, annos));

    return axs;
  }

  private List<OWLAxiom> convertObject(FactStatement<ObjectPredicate, ProperNoun> statement) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    OWLIndividual subject = convertWord(statement.getSubject().getHead());
    List<OWLAnnotation> annos = createAnnotations(statement);

    if (statement.isSubjectObjectObject()) {

      // ClassAssertion
      PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = statement.getSubjectObjectPredicatePhrase();
      PredicateExpression<ObjectPredicate> pExp = predPhrase.getPredicateExpression();

      OWLClassExpression predObjCE = convertObject(predPhrase);

      // OWLClassExpression objCE = convertObject(predPhrase.getObject());

      if (pExp.getPredicate().isBuiltinPredicate()) {

        PredicateType predType = pExp.getPredicate().getPredicateType();

        if (predType == PredicateType.IS) {
          axs.add(owlDataFactory.getOWLClassAssertionAxiom(predObjCE, subject, annos));
        }

        if (predType == PredicateType.SAME_AS) {
          OWLObjectOneOf subjOneOf = owlDataFactory.getOWLObjectOneOf(subject);
          axs.add(owlDataFactory.getOWLEquivalentClassesAxiom(subjOneOf, predObjCE, annos));
        }
      } else {// must be VERB type predicate
        axs.add(owlDataFactory.getOWLClassAssertionAxiom(predObjCE, subject, annos));
      }

      return axs;

    } else {
      // DifferentIndividuals
      // SameIndividual
      // ObjectPropertyAssertion
      // NegativeObjectPropertyAssertion

      PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = statement.getInstancePredicatePhrase();

      PredicateExpression<ObjectPredicate> pExp = predPhrase.getPredicateExpression();

      boolean neg = pExp.isNegative();

      OWLIndividual object = convertWord(statement.getInstancePredicatePhrase().getObject().getHead());

      OWLObjectPropertyExpression propExp = convertObject(pExp);

      if (pExp.getPredicate().isBuiltinPredicate()) {

        List<OWLIndividual> indList = new ArrayList<OWLIndividual>();
        indList.add(subject);
        indList.add(object);

        // treat IS, IS_ONLY and SAME_AS identically
        if (neg) {
          axs.add(owlDataFactory.getOWLDifferentIndividualsAxiom(indList, annos));
        } else {
          axs.add(owlDataFactory.getOWLSameIndividualAxiom(indList, annos));
        }

      } else {// must be VERB type predicate

        if (neg) {
          axs.add(owlDataFactory.getOWLNegativeObjectPropertyAssertionAxiom(propExp, subject, object, annos));
        } else {
          axs.add(owlDataFactory.getOWLObjectPropertyAssertionAxiom(propExp, subject, object, annos));
        }
      }
    }

    return axs;
  }

  private List<OWLAxiom> convertData(FactStatement<DataPredicate, DataValue> statement) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    OWLIndividual subject = convertWord(statement.getSubject().getHead());
    List<OWLAnnotation> annos = createAnnotations(statement);

    if (statement.isSubjectObjectObject()) {
      // ClassAssertion

      PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = statement.getSubjectObjectPredicatePhrase();
      PredicateExpression<DataPredicate> pExp = predPhrase.getPredicateExpression();
      Predicate pred = pExp.getPredicate();
      PredicateType predType = pred.getPredicateType();
      boolean neg = pExp.isNegative();

      OWLDataPropertyExpression propExp = convertData(pExp);
      OWLClassExpression objCE = convertData(predPhrase);

      if (!pred.isBuiltinPredicate()) {
        // convert ObjCE to datatype thing that <propertyExpression> ObjCE
        objCE = owlDataFactory.getOWLObjectIntersectionOf(objCE,
            owlDataFactory.getOWLDataSomeValuesFrom(propExp, owlDataFactory.getTopDatatype()));
      }

      if (pred.isBuiltinPredicate()) {
        if (predType == PredicateType.IS) {
          LOGGER.warn("Treating IS like SAME AS for individuals" + statement);
        }

      }

      if (neg) {
        axs.add(owlDataFactory.getOWLClassAssertionAxiom(objCE.getObjectComplementOf(), subject, annos));
      } else {
        axs.add(owlDataFactory.getOWLClassAssertionAxiom(objCE, subject, annos));
      }

      return axs;

    } else {
      // DataPropertyAssertion
      // NegativeDataPropertyAssertion
      PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> instPredPhrase = statement.getInstancePredicatePhrase();
      PredicateExpression<DataPredicate> pExp = instPredPhrase.getPredicateExpression();
      OWLDataPropertyExpression propExp = convertData(pExp);
      DataPredicate pred = pExp.getPredicate();
      OWLLiteral objectLit = convertWord(instPredPhrase.getObject().getHead());
      PredicateType predType = pred.getPredicateType();
      boolean neg = pExp.isNegative();

      if (pred.isBuiltinPredicate()) {
        LOGGER.warn("Found builtin type " + predType + " used as a general predicate:" + statement);
      }

      if (neg) {
        axs.add(owlDataFactory.getOWLNegativeDataPropertyAssertionAxiom(propExp, subject, objectLit, annos));
      } else {
        axs.add(owlDataFactory.getOWLDataPropertyAssertionAxiom(propExp, subject, objectLit, annos));
      }

    }

    return axs;
  }

  private List<OWLAxiom> convertAnnotation(FactStatement<AnnotationPredicate, ProperNoun> statement) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    InstancePhrase<ProperNoun> subjPhrase = statement.getSubject();
    ProperNoun subjWord = subjPhrase.getHead();
    OWLIndividual ind = convertWord(subjWord);

    List<OWLAnnotation> annos = createAnnotations(statement);

    OWLAnnotationSubject subject;
    if (ind.isAnonymous()) {
      subject = ind.asOWLAnonymousIndividual();
    } else {
      subject = ind.asOWLNamedIndividual().getIRI();
    }

    if (statement.isSubjectObjectObject()) {
      LOGGER.error("Cannot annotate with a complex expressions" + statement);
      return axs;
    }
    PredicateExpression<AnnotationPredicate> pred = statement.getInstancePredicatePhrase().getPredicateExpression();

    OWLAnnotationProperty prop = convertAnnotation(pred);
    Word objWord = statement.getInstancePredicatePhrase().getObject().getHead();

    OWLAnnotationValue object;

    if (objWord instanceof DataValue) {
      object = convertWord((DataValue) objWord);
    } else {
      object = convertWord(objWord);
    }

    axs.add(owlDataFactory.getOWLAnnotationAssertionAxiom(prop, subject, object, annos));

    return axs;
  }

  private List<OWLAxiom> convertObject(PredicateRelationStatement<ObjectPredicate> statement) {
    // DisjointObjectProperties
    // EquivalentObjectProperties
    // SubObjectPropertyOf
    // InverseObjectProperties
    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    PredicateType rel = statement.getRelationType();
    boolean negative = statement.isNegative();
    boolean inverse = statement.isInverse();

    PredicateExpression<ObjectPredicate> subjPhrase = statement.getSubject();
    OWLObjectPropertyExpression subjExp = convertObject(subjPhrase);
    PredicateExpression<ObjectPredicate> objPhrase = statement.getObject();
    OWLObjectPropertyExpression objExp = convertObject(objPhrase);

    List<OWLAnnotation> annos = createAnnotations(statement);

    if (rel.equals(PredicateType.VERB) || rel.equals(PredicateType.FACET)) {
      LOGGER.error("Cannot have arbitrary relation between properties. Assuming IS:" + statement);
      rel = PredicateType.IS;
    }

    if (rel.equals(PredicateType.IS)) {

      if (inverse) {
        LOGGER.error("Cannot have inverse of a subtype relation in a predicate relation statement. Ignoring Inverse:"
            + statement);
      }

      if (negative) {
        // IS NOT
        List<OWLObjectPropertyExpression> props = new ArrayList<OWLObjectPropertyExpression>();
        props.add(subjExp);
        props.add(objExp);
        axs.add(owlDataFactory.getOWLDisjointObjectPropertiesAxiom(props, annos));
      } else {
        // IS
        axs.add(owlDataFactory.getOWLSubObjectPropertyOfAxiom(subjExp, objExp, annos));
      }
    }

    if (rel.equals(PredicateType.SAME_AS)) {
      if (negative) {
        // NOT SAME_AS
        LOGGER.error("Interpreting NOT SAME_AS as disjoint properties:" + statement);
        List<OWLObjectPropertyExpression> props = new ArrayList<OWLObjectPropertyExpression>();
        props.add(subjExp);
        props.add(objExp);
        axs.add(owlDataFactory.getOWLDisjointObjectPropertiesAxiom(props, annos));
      } else {
        if (inverse) {
          // SAME_AS INVERSE
          axs.add(owlDataFactory.getOWLInverseObjectPropertiesAxiom(subjExp, objExp, annos));
        } else {
          // SAME_AS
          axs.add(owlDataFactory.getOWLEquivalentObjectPropertiesAxiom(subjExp, objExp, annos));
        }
      }
    }

    return axs;
  }

  private List<OWLAxiom> convertData(PredicateRelationStatement<DataPredicate> statement) {
    // DisjointDataProperties
    // EquivalentDataProperties
    // SubDataPropertyOf
    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();
    PredicateType rel = statement.getRelationType();
    boolean negative = statement.isNegative();
    boolean inverse = statement.isInverse();

    PredicateExpression<DataPredicate> subjPhrase = statement.getSubject();
    OWLDataPropertyExpression subjExp = convertData(subjPhrase);
    PredicateExpression<DataPredicate> objPhrase = statement.getObject();
    OWLDataPropertyExpression objExp = convertData(objPhrase);

    List<OWLAnnotation> annos = createAnnotations(statement);

    if (rel.equals(PredicateType.VERB) || rel.equals(PredicateType.FACET)) {
      LOGGER.error("Cannot have arbitrary relation between properties. Assuming IS:" + statement);
      rel = PredicateType.IS;
    }

    if (rel.equals(PredicateType.IS)) {

      if (inverse) {
        LOGGER.error("Cannot have inverse of a subtype relation in a predicate relation statement. Ignoring Inverse:"
            + statement);
      }

      if (negative) {
        // IS NOT
        List<OWLDataPropertyExpression> props = new ArrayList<OWLDataPropertyExpression>();
        props.add(subjExp);
        props.add(objExp);
        axs.add(owlDataFactory.getOWLDisjointDataPropertiesAxiom(props, annos));
      } else {
        // IS
        axs.add(owlDataFactory.getOWLSubDataPropertyOfAxiom(subjExp, objExp, annos));
      }
    }

    if (rel.equals(PredicateType.SAME_AS)) {
      if (negative) {
        // NOT SAME_AS
        LOGGER.error("Interpreting NOT SAME_AS as disjoint properties:" + statement);
        List<OWLDataPropertyExpression> props = new ArrayList<OWLDataPropertyExpression>();
        props.add(subjExp);
        props.add(objExp);
        axs.add(owlDataFactory.getOWLDisjointDataPropertiesAxiom(props, annos));
      } else {
        if (inverse) {
          // SAME_AS INVERSE
          LOGGER.error("No such thing as an inverse data property. Interpreting as Equivalent:" + statement);
          axs.add(owlDataFactory.getOWLEquivalentDataPropertiesAxiom(subjExp, objExp, annos));
        } else {
          // SAME_AS
          axs.add(owlDataFactory.getOWLEquivalentDataPropertiesAxiom(subjExp, objExp, annos));
        }
      }
    }

    return axs;

  }

  private List<OWLAxiom> convertAnnotation(PredicateRelationStatement<AnnotationPredicate> statement) {
    // SubAnnotationPropertyOf
    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    PredicateType rel = statement.getRelationType();

    if (statement.isInverse()) {
      LOGGER.warn("Annotation property relations cannot be inverse.Ignoring:" + statement);
    }

    if (statement.isNegative()) {
      LOGGER.warn("Annotation property relations cannot be negated.Ignoring:" + statement);
    }

    if (!rel.equals(PredicateType.IS)) {
      LOGGER.warn("Annotation relations can only be subtype, assuming subtype" + statement);
    }

    PredicateExpression<AnnotationPredicate> subjPhrase = statement.getSubject();
    OWLAnnotationProperty subjExp = convertAnnotation(subjPhrase);

    PredicateExpression<AnnotationPredicate> objPhrase = statement.getObject();
    OWLAnnotationProperty objExp = convertAnnotation(objPhrase);

    List<OWLAnnotation> annos = createAnnotations(statement);

    axs.add(owlDataFactory.getOWLSubAnnotationPropertyOfAxiom(subjExp, objExp, annos));
    return axs;
  }

  private List<OWLAxiom> convertAnnotation(PredicateCharacteristicStatement<AnnotationPredicate> statement) {
    LOGGER.warn("No such thing as a PredicateCharacteristic on an Annotation Predicate" + statement);
    return new ArrayList<OWLAxiom>();
  }

  private List<OWLAxiom> convertData(PredicateCharacteristicStatement<DataPredicate> statement) {
    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    OWLDataPropertyExpression propExp = convertData(statement.getSubject());
    PredicateCharacteristic ch = statement.getCharacteristic();

    if (ch.equals(PredicateCharacteristic.FUNCTIONAL)) {
      axs.add(owlDataFactory.getOWLFunctionalDataPropertyAxiom(propExp));
    } else {
      LOGGER.warn("Cannot have a " + ch + " property PredicateCharacteristic on a Data Predicate:" + statement);
    }

    return axs;
  }

  private List<OWLAxiom> convertObject(PredicateCharacteristicStatement<ObjectPredicate> statement) {
    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    OWLObjectPropertyExpression propExp = convertObject(statement.getSubject());
    PredicateCharacteristic character = statement.getCharacteristic();

    if (character == PredicateCharacteristic.FUNCTIONAL) {
      axs.add(owlDataFactory.getOWLFunctionalObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.SYMMETRIC) {
      axs.add(owlDataFactory.getOWLSymmetricObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.ASYMMETRIC) {
      axs.add(owlDataFactory.getOWLAsymmetricObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.REFLEXIVE) {
      axs.add(owlDataFactory.getOWLReflexiveObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.TRANSITIVE) {
      axs.add(owlDataFactory.getOWLTransitiveObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.INVERSE_FUNCTIONAL) {
      axs.add(owlDataFactory.getOWLInverseFunctionalObjectPropertyAxiom(propExp));
    }

    if (character == PredicateCharacteristic.IRREFLEXIVE) {
      axs.add(owlDataFactory.getOWLIrreflexiveObjectPropertyAxiom(propExp));
    }

    return axs;
  }

  private List<OWLAxiom> convert(DeclarationStatement statement) {
    if (statement.isDerived()) {
      return new ArrayList<OWLAxiom>();
    }
    return convertVocabulary(statement.getWord());
  }

  private List<OWLAxiom> convertVocabulary(Word wrd) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();
    OWLEntity ent = null;
    if (wrd instanceof Noun) {
      ent = convertWord((Noun) wrd);
    }

    if (wrd instanceof DataType) {
      ent = convertWord((DataType) wrd);
    }

    if (wrd instanceof ProperNoun) {
      OWLIndividual ind = convertWord((ProperNoun) wrd);

      if (ind.isNamed()) {
        ent = ind.asOWLNamedIndividual();
      } else {
        LOGGER.warn("Can't declare an anonymous Individual:" + wrd);
        return axs;
      }
    }

    if (wrd instanceof ObjectPredicate) {
      ent = convertWord((ObjectPredicate) wrd);
    }

    if (wrd instanceof DataPredicate) {
      ent = convertWord((DataPredicate) wrd);
    }

    if (wrd instanceof AnnotationPredicate) {
      ent = convertWord((AnnotationPredicate) wrd);
    }

    if (ent != null) {
      axs.add(owlDataFactory.getOWLDeclarationAxiom(ent));
    } else {
      LOGGER.warn("Couldn't translate Declaration Statement for:" + wrd);
    }

    return axs;

  }

  private List<OWLAxiom> convert(WordSequence statement) {
    LOGGER.error("Cannot convert a BadStatement to OWL:" + statement.getWords());
    return new ArrayList<OWLAxiom>();
  }

  /* ---------------- Phrases and Expressions ---------- */

  /*---- Data Phrases => OWLDataRanges ---*/
  private OWLDataRange convertData(SubjectObjectPhrase ph) {

    if (ph instanceof CategoryPhrase) {

      if (((CategoryPhrase) ph).isDataScope()) {
        return convertData((CategoryPhrase<DataType>) ph);
      }

      if (((CategoryPhrase) ph).isObjectScope()) {
        LOGGER.error("Cannot convert Object Category Phrase to DataRange:" + ph);
        return owlDataFactory.getTopDatatype();
      }

    }

    if (ph instanceof InstancePhrase) {

      if (((InstancePhrase) ph).isDataScope()) {
        OWLLiteral lit = convertData((InstancePhrase<DataValue>) ph);
        if (ph.isNegative()) {
          OWLDataComplementOf negDoo = owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataOneOf(lit));
          LOGGER.info("Converted a single Literal as a Negative DataOneOf:" + ph);
          return negDoo;
        } else {
          OWLDataOneOf doo = owlDataFactory.getOWLDataOneOf(lit);
          LOGGER.info("Converted a single Literal as a DataOneOf:" + ph);
          return doo;
        }

      }

      if (((InstancePhrase) ph).isObjectScope()) {
        LOGGER.error("Cannot convert Object Phrase to DataRange:" + ph);
        return owlDataFactory.getTopDatatype();
      }

    }

    if (ph instanceof PhraseSet) {
      return convertData((PhraseSet<SubjectObjectPhrase>) ph);
    }

    if (ph instanceof WordPhrase) {
      OWLLiteral lit = convertData((WordPhrase) ph);
      OWLDataOneOf doo = owlDataFactory.getOWLDataOneOf(lit);
      LOGGER.warn("Converted a WordPhrase as a DataOneOf:" + ph);
      return doo;
    }

    LOGGER.error("Could not convert data phrase" + ph);
    return owlDataFactory.getTopDatatype();
  }

  private OWLDataRange convertData(CategoryPhrase<DataType> ph) {

    DataType h = ph.getHead();
    OWLDatatype headDatatype = convertWord(h);

    boolean neg = ph.getQuantifierExpression().isNegative();

    if (ph.isSimple()) {
      if (neg) {
        return owlDataFactory.getOWLDataComplementOf(headDatatype);
      } else {
        return headDatatype;
      }
    }

    List<DataType> mods = ph.getModifiers();
    List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> rels = ph.getRelativePhrases();

    List<OWLDataRange> modDRs = new ArrayList<OWLDataRange>();
    List<OWLDataRange> relDRs = new ArrayList<OWLDataRange>();

    ArrayList<OWLFacetRestriction> facetRestricts = new ArrayList<OWLFacetRestriction>();

    for (DataType mod : mods) {
      modDRs.add(this.convertWord(mod));
    }

    for (PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> rel : rels) {

      PredicateExpression<? extends Predicate> pExp = rel.getPredicateExpression();
      Predicate pred = pExp.getPredicate();
      SubjectObjectPhrase obj = rel.getObject();

      if (pred instanceof DataFacetPredicate && obj instanceof InstancePhrase
          && ((InstancePhrase<DataValue>) obj).getHead() instanceof DataValue) {

        DataFacetPredicate facet = (DataFacetPredicate) pred;
        DataValue dv = ((InstancePhrase<DataValue>) obj).getHead();

        OWLDatatype dt = convertWord(h);
        OWLFacet fc = convertWord(facet.getFacet());
        OWLLiteral val = convertWord(dv);

        facetRestricts.add(owlDataFactory.getOWLFacetRestriction(fc, val));

        relDRs.add(owlDataFactory.getOWLDatatypeRestriction(dt, fc, val));
      } else {
        LOGGER.warn("Could not convert non-Facet or instance as part of data type restriction" + rel);
      }

    }

    if (!facetRestricts.isEmpty() && modDRs.isEmpty()) {
      if (!neg) {
        return owlDataFactory.getOWLDatatypeRestriction(headDatatype, facetRestricts);
      } else {
        LOGGER.warn("Cannot negate a data range restriction:" + ph);
      }
    }

    ArrayList<OWLDataRange> drs = new ArrayList<OWLDataRange>();
    drs.add(headDatatype);
    drs.addAll(modDRs);
    drs.addAll(relDRs);

    if (drs.size() == 1) {
      if (neg) {
        return owlDataFactory.getOWLDataComplementOf(headDatatype);
      } else {
        return headDatatype;
      }

    } else {
      if (neg) {
        return owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataIntersectionOf(drs));
      } else {
        return owlDataFactory.getOWLDataIntersectionOf(drs);
      }
    }

  }

  private OWLDataRange convertData(PhraseSet<SubjectObjectPhrase> phSet) {

    List<SubjectObjectPhrase> phraseList = phSet.getPhrases();
    BooleanSetType booleanSetType = phSet.getSetType();
    boolean neg = phSet.isNegative();

    if (booleanSetType == BooleanSetType.AND) {

      List<OWLDataRange> drList = new ArrayList<OWLDataRange>();

      for (SubjectObjectPhrase ph : phraseList) {
        OWLDataRange dr = convertData(ph);
        drList.add(dr);
      }

      if (neg) {
        return owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataIntersectionOf(drList));
      } else {
        return owlDataFactory.getOWLDataIntersectionOf(drList);
      }

    }

    if (booleanSetType == BooleanSetType.OR) {

      if (phSet.allInstances()) {
        List<OWLLiteral> litList = new ArrayList<OWLLiteral>();

        for (SubjectObjectPhrase ph : phraseList) {
          OWLLiteral lit = convertData((InstancePhrase<DataValue>) ph);
          litList.add(lit);
        }

        if (neg) {
          return owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataOneOf(litList));
        } else {
          return owlDataFactory.getOWLDataOneOf(litList);
        }

      } else {

        List<OWLDataRange> drList = new ArrayList<OWLDataRange>();

        for (SubjectObjectPhrase ph : phraseList) {
          OWLDataRange dr = convertData(ph);
          drList.add(dr);
        }

        if (neg) {
          return owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataUnionOf(drList));
        } else {
          return owlDataFactory.getOWLDataUnionOf(drList);
        }
      }
    }

    LOGGER.warn("Could not convert Data PhraseSet:" + phSet);

    List<OWLDataRange> drList = new ArrayList<OWLDataRange>();

    for (SubjectObjectPhrase ph : phraseList) {
      OWLDataRange dr = convertData(ph);
      drList.add(dr);
    }

    if (neg) {
      return owlDataFactory.getOWLDataComplementOf(owlDataFactory.getOWLDataUnionOf(drList));
    } else {
      return owlDataFactory.getOWLDataUnionOf(drList);
    }

  }

  private OWLClassExpression convertData(PredicatePhrase<SubjectObjectPhrase, DataPredicate> ph) {

    OWLDataPropertyExpression propExp = convertData(ph.getPredicateExpression());

    if (ph.getObject() instanceof InstancePhrase) {
      InstancePhrase ip = (InstancePhrase) ph.getObject();
      Instance h = ip.getHead();
      if (h instanceof DataValue) {
        OWLLiteral lit = convertWord((DataValue) h);
        return owlDataFactory.getOWLDataHasValue(propExp, lit);
      }

    }

    OWLDataRange obj = convertData(ph.getObject());

    QuantifierExpression quant = ph.getObject().getQuantifierExpression();
    Quantifier qType = quant.getQuantifierType();
    boolean neg = ph.getPredicateExpression().isNegative();

    if (neg) {
      obj = owlDataFactory.getOWLDataComplementOf(obj);
    }

    OWLClassExpression finalCE = null;

    /*
     * // NO = NOT EVERY if (qType == Quantifier.NO) { finalCE = owlDataFactory.getOWLDataAllValuesFrom(propExp,
     * owlDataFactory.getOWLDataComplementOf(obj)); }
     */
    if (qType == Quantifier.SOME) {
      finalCE = owlDataFactory.getOWLDataSomeValuesFrom(propExp, obj);
    }

    if (qType == Quantifier.EVERY) {
      finalCE = owlDataFactory.getOWLDataAllValuesFrom(propExp, obj);
    }

    if (qType == Quantifier.ONLY) {
      finalCE = owlDataFactory.getOWLDataAllValuesFrom(propExp, obj);
    }

    // "A" and "THE" should be used with instance(s)
    if (qType == Quantifier.A || qType == Quantifier.THE || qType == Quantifier.NULL) {
      if (obj.getDataRangeType() == DataRangeType.DATA_ONE_OF) {
        OWLDataOneOf dof = (OWLDataOneOf) obj;
        List<OWLLiteral> lits = OWLAPIStreamUtils.asList(dof.values());
        if (lits.size() == 1 && useHasValue) {
          finalCE = owlDataFactory.getOWLDataHasValue(propExp, lits.get(0));
        } else {
          finalCE = owlDataFactory.getOWLDataSomeValuesFrom(propExp, obj);
        }
      } else {
        LOGGER.trace("Data Quantifier " + qType + " converted as EVERY");
        finalCE = owlDataFactory.getOWLDataAllValuesFrom(propExp, obj);
      }

    }

    int count = quant.getQuantity();

    if (qType == Quantifier.EXACT) {
      finalCE = owlDataFactory.getOWLDataExactCardinality(count, propExp, obj);
    }

    if (qType == Quantifier.LESS_THAN) {
      finalCE = owlDataFactory.getOWLDataMaxCardinality(count - 1, propExp, obj);
    }

    if (qType == Quantifier.LESS_THAN_OR_EQUAL) {
      finalCE = owlDataFactory.getOWLDataMaxCardinality(count, propExp, obj);
    }

    if (qType == Quantifier.MORE_THAN) {
      finalCE = owlDataFactory.getOWLDataMinCardinality(count + 1, propExp, obj);
    }

    if (qType == Quantifier.MORE_THAN_OR_EQUAL) {
      finalCE = owlDataFactory.getOWLDataMinCardinality(count, propExp, obj);
    }

    if (finalCE != null) {
      // if (neg) {
      // return finalCE.getObjectComplementOf();
      // } else {
      return finalCE;
      // }
    }

    LOGGER.warn("Couldn't convert Data Phrase:" + ph);
    return owlDataFactory.getOWLDataSomeValuesFrom(propExp, obj);
  }

  private OWLDataPropertyExpression convertData(PredicateExpression<DataPredicate> exp) {

    DataPredicate pred;
    if (!exp.isDataExpression()) {
      LOGGER
          .warn("Tried to convert a " + exp.getScope() + " predicate as an Data predicate. Forcing to Data predicate");
      Predicate notDataPred = exp.getPredicate();
      pred = new DataPredicate(notDataPred.getNormalForm(), notDataPred.getKey());
    } else {
      pred = exp.getPredicate();
    }

    return convertWord(pred);
  }

  private OWLLiteral convertData(InstancePhrase<DataValue> ph) {

    DataValue head = ph.getHead();
    OWLLiteral lit = convertWord(head);
    return lit;
  }

  private OWLLiteral convertData(WordPhrase ph) {
    LOGGER.warn("Converted data wordphrase as literal" + ph);
    OWLLiteral lit = owlDataFactory.getOWLLiteral(ph.getHead().getNormalForm());
    return lit;
  }

  /*--- Object Phrases => OWLClassExpressions ---*/
  private OWLClassExpression convertObject(Phrase ph) {

    if (ph instanceof PredicatePhrase) {
      if (ph.isObjectScope()) {
        return convertObject((PredicatePhrase) ph);
      }
      if (ph.isDataScope()) {
        return convertData((PredicatePhrase) ph);
      }
    }

    if (!ph.isObjectScope()) {
      LOGGER.error("Tried to convert a non-Object phrase as Object Phrase:" + ph.getScope() + "\t" + ph);
      return convertObject(new CategoryPhrase<Noun>(Vocabulary.THING));
    }

    if (ph instanceof SubjectObjectPhrase) {
      return convertObject((SubjectObjectPhrase) ph);
    }

    LOGGER.error("Could not convert Object Phrase. Not predicate or subject phrase:" + ph);
    return convertObject(new CategoryPhrase<Noun>(Vocabulary.THING));
  }

  private OWLClassExpression convertObject(SubjectObjectPhrase ph) {

    if (ph instanceof CategoryPhrase) {
      if (ph.isDataScope()) {
        PredicatePhrase unPh = convertCategoryPhraseData((CategoryPhrase) ph);
        if (unPh != null) {
          return convertData(unPh);
        }
      } else {
        return convertObject((CategoryPhrase<Noun>) ph);
      }
    }

    if (ph instanceof InstancePhrase) {
      return convertObject((InstancePhrase<ProperNoun>) ph);
    }

    if (ph instanceof PhraseSet) {
      return convertObject((PhraseSet) ph);
    }

    if (ph instanceof WordPhrase) {
      return convertObject((WordPhrase) ph);
    }

    LOGGER.error("Could not convert Object Phrase. Not category, instance, set or word phrase:" + ph);
    return convertObject(new CategoryPhrase<Noun>(Vocabulary.THING));
  }

  private OWLClassExpression convertObject(CategoryPhrase<Noun> ph) {

    // look for Thing with a single predicate phrase
    if (ph.isThingThatPhrase()) {
      return convertObject(ph.getRelativePhrases().get(0));
    }

    Noun h = ph.getHead();
    List<Noun> mods = ph.getModifiers();
    List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> rels = ph.getRelativePhrases();

    boolean neg = ph.isNegative();

    OWLClassExpression headClass = convertWord(h);

    if (ph.isSimple()) {
      if (neg) {
        return headClass.getObjectComplementOf();
      } else {
        return headClass;
      }

    }

    List<OWLClassExpression> modCEs = new ArrayList<OWLClassExpression>();
    List<OWLClassExpression> relCEs = new ArrayList<OWLClassExpression>();

    for (Noun mod : mods) {
      modCEs.add(convertWord(mod));
    }

    for (PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> rel : rels) {

      if (rel.isObjectScope()) {
        relCEs.add(this.convertObject(rel));
      }

      if (rel.isDataScope()) {
        relCEs.add(this.convertData((PredicatePhrase<SubjectObjectPhrase, DataPredicate>) rel));
      }

      if (rel.isAnnotationScope()) {
        LOGGER.error("Noun CategoryPhrase with Annotation RelativePhrase. Ignoring:" + rel);
      }

    }

    List<OWLClassExpression> ces = new ArrayList<OWLClassExpression>();

    if (headClass.isOWLThing()) {
    } else {
      ces.add(headClass);
    }

    ces.addAll(modCEs);
    ces.addAll(relCEs);

    if (ces.size() == 1) {
      if (neg) {
        return headClass.getObjectComplementOf();
      }
      return headClass;
    } else {
      if (neg) {
        return owlDataFactory.getOWLObjectIntersectionOf(ces).getObjectComplementOf();
      }
      return owlDataFactory.getOWLObjectIntersectionOf(ces);
    }

  }

  private OWLClassExpression convertObject(InstancePhrase<ProperNoun> ph) {
    OWLIndividual ind = convertWord(ph.getHead());
    if (ph.isNegative()) {
      return owlDataFactory.getOWLObjectOneOf(ind).getObjectComplementOf();
    } else {
      return owlDataFactory.getOWLObjectOneOf(ind);
    }
  }

  private OWLClassExpression convertObject(PhraseSet<SubjectObjectPhrase> phSet) {

    List<SubjectObjectPhrase> phraseList = phSet.getPhrases();
    BooleanSetType booleanSetType = phSet.getSetType();

    boolean neg = phSet.isNegative();

    if (booleanSetType == BooleanSetType.AND) {

      List<OWLClassExpression> ceList = new ArrayList<OWLClassExpression>();

      for (SubjectObjectPhrase ph : phraseList) {
        OWLClassExpression ce = convertObject(ph);
        ceList.add(ce);
      }

      if (neg) {
        return owlDataFactory.getOWLObjectIntersectionOf(ceList).getObjectComplementOf();
      } else {
        return owlDataFactory.getOWLObjectIntersectionOf(ceList);
      }
    }

    if (booleanSetType == BooleanSetType.OR) {

      if (phSet.allInstances()) {
        List<OWLIndividual> indList = new ArrayList<OWLIndividual>();

        for (SubjectObjectPhrase ph : phraseList) {
          ProperNoun pn = ((InstancePhrase<ProperNoun>) ph).getHead();
          OWLIndividual ind = convertWord(pn);
          indList.add(ind);
        }
        if (neg) {
          return owlDataFactory.getOWLObjectOneOf(indList).getObjectComplementOf();
        } else {
          return owlDataFactory.getOWLObjectOneOf(indList);
        }

      } else {

        List<OWLClassExpression> ceList = new ArrayList<OWLClassExpression>();

        for (SubjectObjectPhrase ph : phraseList) {
          OWLClassExpression ce = convertObject(ph);
          ceList.add(ce);
        }

        if (neg) {
          return owlDataFactory.getOWLObjectUnionOf(ceList).getObjectComplementOf();
        } else {
          return owlDataFactory.getOWLObjectUnionOf(ceList);
        }
      }
    }

    LOGGER.warn("Could not convert Object PhraseSet:" + phSet);

    List<OWLClassExpression> ceList = new ArrayList<OWLClassExpression>();

    for (SubjectObjectPhrase ph : phraseList) {
      OWLClassExpression ce = convertObject(ph);
      ceList.add(ce);
    }

    if (neg) {
      return owlDataFactory.getOWLObjectUnionOf(ceList).getObjectComplementOf();
    } else {
      return owlDataFactory.getOWLObjectUnionOf(ceList);
    }
  }

  private OWLClassExpression convertObject(PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> ph) {

    OWLObjectPropertyExpression propExp = convertObject(ph.getPredicateExpression());
    boolean builtin = ph.getPredicateExpression().getPredicate().isBuiltinPredicate();
    boolean neg = ph.getPredicateExpression().isNegative();

    SubjectObjectPhrase objPhrase = ph.getObject();

    OWLClassExpression finalCE = null;

    if (isItself(objPhrase)) {
      if (neg) {
        return owlDataFactory.getOWLObjectHasSelf(propExp).getObjectComplementOf();
      } else {
        return owlDataFactory.getOWLObjectHasSelf(propExp);
      }
    }

    OWLClassExpression obj = convertObject(objPhrase);

    // push negative predicate to object
    if (neg) {
      obj = obj.getObjectComplementOf();
    }

    QuantifierExpression quant = objPhrase.getQuantifierExpression();
    Quantifier qType = objPhrase.getQuantifierType();
    /*
     * // NO = NOT every if (qType == Quantifier.NO) { finalCE = owlDataFactory.getOWLObjectAllValuesFrom(propExp,
     * obj.getObjectComplementOf()); }
     */
    if (qType == Quantifier.SOME) {
      finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, obj);
    }

    if (qType == Quantifier.EVERY || qType == Quantifier.ONLY) {
      finalCE = owlDataFactory.getOWLObjectAllValuesFrom(propExp, obj);
    }

    if (qType == Quantifier.A || qType == Quantifier.THE) {

      // check for single individual
      if (obj.getClassExpressionType() == ClassExpressionType.OBJECT_ONE_OF) {
        OWLObjectOneOf oof = (OWLObjectOneOf) obj;
        List<OWLIndividual> inds = OWLAPIStreamUtils.asList(oof.individuals());
        if (inds.size() == 1 && useHasValue) {
          finalCE = owlDataFactory.getOWLObjectHasValue(propExp, inds.get(0));
        } else {
          finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, oof);
        }
      } else {
        if (builtin) {
          finalCE = obj;
        } else {
          LOGGER.debug("Object Quantifier " + qType + " converted as SOME:" + objPhrase);
          finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, obj);
        }
      }
    }

    if (qType == Quantifier.NULL) {

      // check for single individual
      if (obj instanceof OWLObjectOneOf) {
        OWLObjectOneOf oof = (OWLObjectOneOf) obj;
        List<OWLIndividual> inds = OWLAPIStreamUtils.asList(oof.individuals());
        if (inds.size() == 1 && useHasValue) {
          finalCE = owlDataFactory.getOWLObjectHasValue(propExp, inds.get(0));
        } else {
          finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, oof);
        }
      } else if (objPhrase instanceof PhraseSet) {

        PhraseSet<?> set = (PhraseSet<?>) objPhrase;
        Set<Quantifier> qes = new HashSet<Quantifier>();
        for (SubjectObjectPhrase elem : set.getPhrases()) {
          if (!elem.getQuantifierType().equals(Quantifier.NULL)) {
            qes.add(elem.getQuantifierType());
          }
        }

        if (qes.size() == 1) {
          // LOGGER.debug("Phrase set quantifier for :" + qes + " " + set);
          qType = qes.iterator().next();
        } else {
          LOGGER.debug("Ambigous Quantifiers seen:" + qes + " " + set);
          qType = Quantifier.SOME;
        }

        if (qType == Quantifier.SOME) {
          finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, obj);
        }

        if (qType == Quantifier.EVERY || qType == Quantifier.ONLY) {
          finalCE = owlDataFactory.getOWLObjectAllValuesFrom(propExp, obj);
        }

      } else {
        LOGGER.debug("Object Quantifier " + qType + " converted as SOME:" + objPhrase);
        finalCE = owlDataFactory.getOWLObjectSomeValuesFrom(propExp, obj);
      }

    }

    int count = quant.getQuantity();

    if (qType == Quantifier.EXACT) {
      finalCE = owlDataFactory.getOWLObjectExactCardinality(count, propExp, obj);
    }

    if (qType == Quantifier.LESS_THAN) {
      finalCE = owlDataFactory.getOWLObjectMaxCardinality(count - 1, propExp, obj);
    }

    if (qType == Quantifier.LESS_THAN_OR_EQUAL) {
      finalCE = owlDataFactory.getOWLObjectMaxCardinality(count, propExp, obj);
    }

    if (qType == Quantifier.MORE_THAN) {
      finalCE = owlDataFactory.getOWLObjectMinCardinality(count + 1, propExp, obj);
    }

    if (qType == Quantifier.MORE_THAN_OR_EQUAL) {
      finalCE = owlDataFactory.getOWLObjectMinCardinality(count, propExp, obj);
    }

    if (finalCE != null) {
      // if (neg) {
      // return finalCE.getObjectComplementOf();
      // } else {
      return finalCE;
      // }
    }

    LOGGER.warn("Couldn't convert Object Phrase:" + ph);
    return owlDataFactory.getOWLObjectSomeValuesFrom(propExp, obj);
  }

  private OWLObjectPropertyExpression convertObject(PredicateExpression<ObjectPredicate> exp) {

    ObjectPredicate pred = exp.getPredicate();

    OWLObjectProperty prop = convertWord(pred);

    if (exp.isInverse()) {
      return owlDataFactory.getOWLObjectInverseOf(prop);
    } else {
      return prop;
    }
  }

  private OWLClassExpression convertObject(WordPhrase ph) {
    LOGGER.warn("Converted object wordphrase as ObjectOneOf Individual" + ph);
    OWLNamedIndividual ind = owlDataFactory.getOWLNamedIndividual(ph.getHead().getKey());
    OWLObjectOneOf oneof = owlDataFactory.getOWLObjectOneOf(ind);

    return oneof;
  }

  private OWLAnnotationProperty convertAnnotation(PredicateExpression<AnnotationPredicate> exp) {

    AnnotationPredicate pred;
    if (!exp.isAnnotationExpression()) {
      LOGGER.warn("Tried to convert a " + exp.getScope()
          + " predicate as an Annotation predicate. Forcing to Annotation predicate");
      Predicate notAnnoPred = exp.getPredicate();
      pred = new AnnotationPredicate(notAnnoPred.getNormalForm(), notAnnoPred.getKey());
    } else {
      pred = exp.getPredicate();
    }

    return convertWord(pred);
  }

  private OWLAnnotationSubject convertAnnotationSubject(Word wrd) {

    // convert to IRI or anonymous Individual
    if (wrd instanceof ProperNoun) {

      OWLIndividual ind = convertWord((ProperNoun) wrd);

      if (ind.isAnonymous()) {
        return ind.asOWLAnonymousIndividual();
      } else {
        return ind.asOWLNamedIndividual().getIRI();
      }
    }

    return convertWord(wrd);

  }

  private OWLAnnotationValue convertAnnotationValue(Word wrd) {

    // convert to IRI, anonymous Individual or literal
    if (wrd instanceof DataValue) {
      return convertWord((DataValue) wrd);
    }

    if (wrd instanceof ProperNoun) {

      OWLIndividual ind = convertWord((ProperNoun) wrd);

      if (ind.isAnonymous()) {
        return ind.asOWLAnonymousIndividual();
      } else {
        return ind.asOWLNamedIndividual().getIRI();
      }
    }

    return convertWord(wrd);
  }

  private OWLAnnotation convertAnnotation(Footnote footnote) {
    OWLAnnotationProperty prop = convertWord(footnote.getPredicate());
    OWLAnnotationValue wrd = convertAnnotationValue(footnote.getWord());

    return owlDataFactory.getOWLAnnotation(prop, wrd);
  }

  private IRI convertWord(Word wrd) {

    if (wrd instanceof DataValue) {
      LOGGER.warn("Converted DataValue as fake IRI:" + wrd);
    }

    if (wrd instanceof ProperNoun) {
      if (((ProperNoun) wrd).isAnonymous()) {
        LOGGER.warn("Converted Anonymous ProperNoun as fake IRI:" + wrd);
      }
    }

    return wrd.getKey();
  }

  private OWLClass convertWord(Noun wrd) {
    OWLClass owl = owlDataFactory.getOWLClass(wrd.getKey());
    return owl;
  }

  private OWLDatatype convertWord(DataType wrd) {
    OWLDatatype owl = owlDataFactory.getOWLDatatype(wrd.getKey());
    return owl;
  }

  private OWLIndividual convertWord(ProperNoun wrd) {

    if (wrd.isAnonymous()) {
      return owlDataFactory.getOWLAnonymousIndividual(wrd.getLogicalForm());
    } else {
      return owlDataFactory.getOWLNamedIndividual(wrd.getKey());
    }
  }

  private OWLLiteral convertWord(DataValue wrd) {
    OWLDatatype dt = convertWord(wrd.getDatatype());
    String lang = wrd.getLanguage();
    String value = wrd.getNormalForm();

    if (!lang.isEmpty()) {
      return owlDataFactory.getOWLLiteral(value, lang);
    }

    return owlDataFactory.getOWLLiteral(value, dt);
  }

  private OWLObjectProperty convertWord(ObjectPredicate wrd) {
    return owlDataFactory.getOWLObjectProperty(wrd.getKey());
  }

  private OWLDataProperty convertWord(DataPredicate wrd) {
    return owlDataFactory.getOWLDataProperty(wrd.getKey());
  }

  private OWLAnnotationProperty convertWord(AnnotationPredicate wrd) {
    return owlDataFactory.getOWLAnnotationProperty(wrd.getKey());
  }

  private OWLFacet convertWord(DataFacet wrd) {

    String logical = wrd.getLogicalForm();
    OWLFacet facet = OWLFacet.getFacetByShortName(logical);

    if (facet == null) {
      LOGGER.error("Could not translate DatatypeFacet:" + wrd);
    }

    return facet;
  }

  private PredicatePhrase convertCategoryPhraseData(CategoryPhrase cat) {

    if (cat.getHead().getKey().equals(Vocabulary.DATATYPE_THING_IRI) && cat.getModifiers().isEmpty()
        && !cat.getRelativePhrases().isEmpty() && cat.getRelativePhrases().size() == 1) {
      List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> preds = cat.getRelativePhrases();
      return preds.get(0);
    }

    return null;
  }

  private boolean isItself(SubjectObjectPhrase ph) {

    if (ph instanceof CategoryPhrase) {
      return ((CategoryPhrase) ph).isItself();
    }
    return false;
  }

  private List<OWLAnnotation> createAnnotations(Statement statement) {

    List<Footnote> foots = statement.getFootnotes();
    List<OWLAnnotation> annos = new ArrayList<OWLAnnotation>();
    for (Footnote foot : foots) {
      annos.add(convertAnnotation(foot));
    }
    return annos;
  }

  private List<OWLAxiom> rewriteDomainRanges(List<OWLAxiom> draxs) {

    List<OWLAxiom> axs = new ArrayList<OWLAxiom>();

    for (OWLAxiom ax : draxs) {

      if (ax.isOfType(AxiomType.SUBCLASS_OF)) {

        OWLAxiom finalAx = ax;

        OWLSubClassOfAxiom subAx = (OWLSubClassOfAxiom) ax;
        OWLClassExpression subExp = subAx.getSubClass();
        OWLClassExpression superExp = subAx.getSuperClass();
        ClassExpressionType superType = superExp.getClassExpressionType();
        ClassExpressionType subType = subExp.getClassExpressionType();

        if (subExp.isOWLThing()) {

          // object range
          if (superType.equals(ClassExpressionType.OBJECT_ALL_VALUES_FROM)) {
            OWLObjectAllValuesFrom all = (OWLObjectAllValuesFrom) superExp;
            finalAx = owlDataFactory.getOWLObjectPropertyRangeAxiom(all.getProperty(), all.getFiller());
          }
          // data range
          if (superType.equals(ClassExpressionType.DATA_ALL_VALUES_FROM)) {
            OWLDataAllValuesFrom all = (OWLDataAllValuesFrom) superExp;
            finalAx = owlDataFactory.getOWLDataPropertyRangeAxiom(all.getProperty(), all.getFiller());
          }

        } else {

          if (subType.equals(ClassExpressionType.OBJECT_SOME_VALUES_FROM)) {
            OWLObjectSomeValuesFrom some = (OWLObjectSomeValuesFrom) subExp;
            if (some.getFiller().isOWLThing()) {
              finalAx = owlDataFactory.getOWLObjectPropertyDomainAxiom(some.getProperty(), superExp);
            }
          }
          // data range
          if (subType.equals(ClassExpressionType.DATA_SOME_VALUES_FROM)) {
            OWLDataSomeValuesFrom some = (OWLDataSomeValuesFrom) subExp;
            if (some.getFiller().isTopDatatype()) {
              finalAx = owlDataFactory.getOWLDataPropertyDomainAxiom(some.getProperty(), superExp);
            }
          }
        }

        axs.add(finalAx);

      } else {
        axs.add(ax);
      }
    }

    return axs;
  }

  private OWLAxiom rewriteDomainRange(OWLAxiom ax) {

    if (ax.isOfType(AxiomType.SUBCLASS_OF)) {

      OWLSubClassOfAxiom subAx = (OWLSubClassOfAxiom) ax;
      OWLClassExpression subExp = subAx.getSubClass();
      OWLClassExpression superExp = subAx.getSuperClass();
      ClassExpressionType superType = superExp.getClassExpressionType();
      ClassExpressionType subType = subExp.getClassExpressionType();

      if (subExp.isOWLThing()) {

        // object range
        if (superType.equals(ClassExpressionType.OBJECT_ALL_VALUES_FROM)) {
          OWLObjectAllValuesFrom all = (OWLObjectAllValuesFrom) superExp;
          return owlDataFactory.getOWLObjectPropertyRangeAxiom(all.getProperty(), all.getFiller());
        }
        // data range
        if (superType.equals(ClassExpressionType.DATA_ALL_VALUES_FROM)) {
          OWLDataAllValuesFrom all = (OWLDataAllValuesFrom) superExp;
          return owlDataFactory.getOWLDataPropertyRangeAxiom(all.getProperty(), all.getFiller());
        }

      } else {

        if (subType.equals(ClassExpressionType.OBJECT_SOME_VALUES_FROM)) {
          OWLObjectSomeValuesFrom some = (OWLObjectSomeValuesFrom) subExp;
          if (some.getFiller().isOWLThing()) {
            return owlDataFactory.getOWLObjectPropertyDomainAxiom(some.getProperty(), superExp);
          }
        }
        // data range
        if (subType.equals(ClassExpressionType.DATA_SOME_VALUES_FROM)) {
          OWLDataSomeValuesFrom some = (OWLDataSomeValuesFrom) subExp;
          if (some.getFiller().isTopDatatype()) {
            return owlDataFactory.getOWLDataPropertyDomainAxiom(some.getProperty(), superExp);
          }
        }
      }

    }

    return ax;
  }

}
