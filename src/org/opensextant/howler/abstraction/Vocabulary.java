package org.opensextant.howler.abstraction;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.RelativeMarker;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class Vocabulary {

  public static List<Word> fixedVocabulary = new ArrayList<Word>();
  public static List<IRI> labelIRIs = new ArrayList<IRI>();

  /*-------- Name spaces -------------------*/
  public static final IRI HOWLER_NS = IRI.create("http://org.opensextent.howler#");
  public static final IRI HOWLER_DEFAULT_NS = IRI.create("http://org.opensextent.howler/");
  public static final IRI BUILTIN_NS = IRI.create("http://org.opensextent.howler/builtin#");
  public static final IRI VALUE_NS = IRI.create("http://org.opensextent.howler/datavalues#");
  public static final String ANONYMOUS_NS = "_:";

  public static final IRI OWLNamespace = IRI.create("http://www.w3.org/2002/07/owl#");
  public static final IRI RDFNamespace = IRI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#");
  public static final IRI XSDNamespace = IRI.create("http://www.w3.org/2001/XMLSchema#");

  // IRI for AnnotationProperties that will be used for creating normal forms
  // of Words
  public static final IRI RDFS_LABEL = IRI.create("http://www.w3.org/2000/01/rdf-schema#label");
  public static final IRI SKOS_LABEL = IRI.create("http://www.w3.org/2004/02/skos/core#prefLabel");

  // http://purl.org/dc/terms/title

  // Fixed IRIs
  public static final IRI THING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Thing");
  public static final IRI NOTHING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Nothing");
  public static final IRI DATATYPE_THING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Literal");
  public static final IRI ITSELF_IRI = IRI.create(BUILTIN_NS.toString(), "itself");

  /*-------- Fixed instances -----------*/

  /*--- Nouns ---*/
  public static final CommonNoun THING = new CommonNoun("thing", THING_IRI);
  public static final CommonNoun NOTHING = new CommonNoun("nothing", NOTHING_IRI);
  public static final DataType DATATYPE_THING = new DataType("topDatatype", DATATYPE_THING_IRI);
  public static final CommonNoun ITSELF = new CommonNoun("itself", ITSELF_IRI);

  /*--- Data types ---*/
  public static final DataType TEXT_TYPE = new DataType("PlainLiteral",
      IRI.create(RDFNamespace.toString(), "PlainLiteral"));
  public static final DataType INTEGER_TYPE = new DataType("integer", IRI.create(XSDNamespace.toString(), "integer"));
  public static final DataType DOUBLE_TYPE = new DataType("double", IRI.create(XSDNamespace.toString(), "double"));

  /*--- Builtin scoped predicates ---*/
  public static final ObjectPredicate IS_Object = new ObjectPredicate("is", getBuiltInKey("is"), PredicateType.IS);
  public static final ObjectPredicate IS_ONLY_Object = new ObjectPredicate("is only", getBuiltInKey("is only"),PredicateType.IS_ONLY);
  public static final ObjectPredicate SAME_Object = new ObjectPredicate("is any", getBuiltInKey("same"),PredicateType.SAME_AS);

  public static final DataPredicate IS_Data = new DataPredicate("is", getBuiltInKey("is"), PredicateType.IS);
  public static final DataPredicate IS_ONLY_Data = new DataPredicate("is only", getBuiltInKey("is only"),PredicateType.IS_ONLY);
  public static final DataPredicate SAME_Data = new DataPredicate("is any", getBuiltInKey("same"), PredicateType.SAME_AS);

  public static final AnnotationPredicate IS_Annotation = new AnnotationPredicate("is", getBuiltInKey("is"),PredicateType.IS);
  public static final AnnotationPredicate IS_ONLY_Annotation = new AnnotationPredicate("is only", getBuiltInKey("is only"),PredicateType.IS_ONLY);
  public static final AnnotationPredicate SAME_Annotation = new AnnotationPredicate("same as", getBuiltInKey("same"), PredicateType.SAME_AS);

  /*-----Error handling -----*/
  public static final GenericWord ERROR = new GenericWord("ERROR");
  public static final GenericWord EOF = new GenericWord("EOF");

  
  /*----- Markers -----*/

  public static final GenericWord NO = new GenericWord("no");
  public static final GenericWord NOT = new GenericWord("not");
  public static final GenericWord THAT = new GenericWord("that");
  public static final GenericWord PASSIVE = new GenericWord("by");
  
  /* ------- parts of predicate expressions ------- */
   public static final GenericWord IS_AUX = new GenericWord("is");
   public static final GenericWord DOES_AUX = new GenericWord("does");
   public static final GenericWord HAS_AUX = new GenericWord("has"); 
  // public static final PredicateParticle SAME_AS = new PredicateParticle("the same as");
  // public static final PredicateParticle BY = new PredicateParticle("by");

  /*-----punctuation -----*/
  public static final GenericWord DQUOTE = new GenericWord("\"");
  public static final GenericWord PERIOD = new GenericWord(".");
  public static final GenericWord OPEN_PAREN = new GenericWord("(");
  public static final GenericWord CLOSE_PAREN = new GenericWord(")");

  static {

    labelIRIs.add(RDFS_LABEL);
    labelIRIs.add(SKOS_LABEL);

    fixedVocabulary.add(THING);
    fixedVocabulary.add(NOTHING);
    fixedVocabulary.add(DATATYPE_THING);
    fixedVocabulary.add(ITSELF);
    fixedVocabulary.add(TEXT_TYPE);
    fixedVocabulary.add(INTEGER_TYPE);
    fixedVocabulary.add(DOUBLE_TYPE);
    fixedVocabulary.add(IS_Object);
    fixedVocabulary.add(IS_ONLY_Object);
    fixedVocabulary.add(SAME_Object);
    fixedVocabulary.add(IS_Data);
    fixedVocabulary.add(SAME_Data);
    fixedVocabulary.add(IS_Annotation);
    fixedVocabulary.add(ERROR);
    fixedVocabulary.add(PERIOD);

    for (BooleanSetType bst : BooleanSetType.values()) {
      fixedVocabulary.add(bst);
    }

    for (DataFacet fc : DataFacet.values()) {
      fixedVocabulary.add(fc);
    }

    for (PredicateCharacteristic pc : PredicateCharacteristic.values()) {
      fixedVocabulary.add(pc);
    }

    for (Quantifier q : Quantifier.values()) {
      fixedVocabulary.add(q);
    }

    for (RelativeMarker rm : RelativeMarker.values()) {
      fixedVocabulary.add(rm);
    }

    for (Scope s : Scope.values()) {
      fixedVocabulary.add(s);
    }

    for (WordType wt : WordType.values()) {
      fixedVocabulary.add(wt);
    }

  }

  public static IRI getBuiltInKey(String logical) {
    return IRI.create(BUILTIN_NS.toString(), logical);
  }

}
