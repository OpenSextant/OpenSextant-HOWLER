package org.opensextant.howler.abstraction;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataType.DataTypeCategory;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.semanticweb.owlapi.model.IRI;
/**
 * Vocabulary captures all of the pre-defined Words used throughout the abstraction
 */
public class Vocabulary {

  public static List<Word> fixedVocabulary = new ArrayList<Word>();
  public static List<IRI> labelIRIs = new ArrayList<IRI>();

  /*-------- Name spaces -------------------*/
  public static final IRI HOWLER_DEFAULT_NS = IRI.create("http://org.opensextent.howler/");
  public static final IRI BUILTIN_NS = IRI.create("http://org.opensextent.howler/builtin#");
  public static final IRI VALUE_NS = IRI.create("http://org.opensextent.howler/datavalues#");
  public static final String ANONYMOUS_NS = "_:";
  public static final String BUILTIN_PREFIX = "hwl:";

  public static final IRI OWLNamespace = IRI.create("http://www.w3.org/2002/07/owl#");
  public static final IRI RDFNamespace = IRI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#");
  public static final IRI RDFSNamespace = IRI.create("http://www.w3.org/2000/01/rdf-schema#");
  public static final IRI XSDNamespace = IRI.create("http://www.w3.org/2001/XMLSchema#");

  private static List<IRI> builtInNamespaces = new ArrayList<IRI>();

  // IRI for AnnotationProperties that will be used for creating normal forms
  // of Words
  public static final IRI RDFS_LABEL = IRI.create("http://www.w3.org/2000/01/rdf-schema#label");
  public static final IRI SKOS_LABEL = IRI.create("http://www.w3.org/2004/02/skos/core#prefLabel");

  // Fixed IRIs
  public static final IRI THING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Thing");
  public static final IRI NOTHING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Nothing");
  public static final IRI DATATYPE_THING_IRI = IRI.create(Vocabulary.OWLNamespace.toString(), "Literal");
  public static final IRI ITSELF_IRI = IRI.create(BUILTIN_NS.toString(), "itself");

  /*-------- Fixed instances -----------*/

  /*--- Nouns ---*/
  public static final CommonNoun THING = new CommonNoun("thing", THING_IRI);
  public static final CommonNoun NOTHING = new CommonNoun("no thing", NOTHING_IRI);
 // public static final DataType DATAVALUE = new DataType("data value", DATATYPE_THING_IRI,DataTypeCategory.OTHER);
  public static final CommonNoun ITSELF = new CommonNoun("itself", ITSELF_IRI);

  /*--- Builtin scoped predicates ---*/
  public static final ObjectPredicate IS_Object = new ObjectPredicate("is", getBuiltInKey("is"), PredicateType.IS);
  public static final ObjectPredicate SAME_Object = new ObjectPredicate("defined as", getBuiltInKey("same"),
      PredicateType.SAME_AS);

  public static final DataPredicate IS_Data = new DataPredicate("is", getBuiltInKey("is"), PredicateType.IS);
  public static final DataPredicate SAME_Data = new DataPredicate("defined as", getBuiltInKey("same"),
      PredicateType.SAME_AS);

  public static final AnnotationPredicate IS_Annotation = new AnnotationPredicate("is", getBuiltInKey("is"),
      PredicateType.IS);
  public static final AnnotationPredicate SAME_Annotation = new AnnotationPredicate("defined as", getBuiltInKey("same"),
      PredicateType.SAME_AS);

  /* ------- parts of predicate expressions ------- */
  public static final GenericWord IS_AUX = new GenericWord("is", "VB");
  public static final GenericWord DOES_AUX = new GenericWord("does", "VB");
  public static final GenericWord HAS_AUX = new GenericWord("has", "VB");
  public static final GenericWord INVERSE_OF = new GenericWord("the inverse of", "ZZ");

  /* -------- parts of conjunctions/disjuntions -------*/
  public static final GenericWord EITHER = new GenericWord("either", "ZZ");
  public static final GenericWord BOTH = new GenericWord("both", "ZZ");
  public static final GenericWord EXCLUSIVE = new GenericWord("exclusively", "ZZ");
  
  /*-----punctuation -----*/
  public static final GenericWord DQUOTE = new GenericWord("\"", "DQUOTE");
  public static final GenericWord PERIOD = new GenericWord(".", "PERIOD");
  public static final GenericWord OPEN_BRACKET = new GenericWord("[", "OPEN");
  public static final GenericWord CLOSE_BRACKET = new GenericWord("]", "CLOSE");

  /* ----------- Flags ------------------ */
  public static final GenericWord ANNO_FLAG = new GenericWord("*", "FLAG");
  public static final Word ANNO_SPLIT = new GenericWord(":", "FLAG");

  /*--- Data types ---*/
  public static final DataType BASE64_BIN_TYPE = new DataType("base64Binary datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#base64Binary"), DataTypeCategory.OTHER);
  public static final DataType HEX_BIN_TYPE = new DataType("hexBinary datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#hexBinary"), DataTypeCategory.OTHER);
  public static final DataType BOOL_TYPE = new DataType("boolean datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#boolean"), DataTypeCategory.OTHER);
  public static final DataType RATIONAL_TYPE = new DataType("rational datatype",
      IRI.create("http://www.w3.org/2002/07/owl#rational"), DataTypeCategory.OTHER);
  public static final DataType REAL_TYPE = new DataType("real datatype",
      IRI.create("http://www.w3.org/2002/07/owl#real"), DataTypeCategory.NUMERIC);
  public static final DataType BYTE_TYPE = new DataType("byte datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#byte"), DataTypeCategory.NUMERIC);
  public static final DataType DECIMAL_TYPE = new DataType("decimal datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#decimal"), DataTypeCategory.NUMERIC);
  public static final DataType DOUBLE_TYPE = new DataType("double datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#double"), DataTypeCategory.NUMERIC);
  public static final DataType FLOAT_TYPE = new DataType("float datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#float"), DataTypeCategory.NUMERIC);
  public static final DataType INT_TYPE = new DataType("int datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#int"), DataTypeCategory.NUMERIC);
  public static final DataType INTEGER_TYPE = new DataType("integer datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#integer"), DataTypeCategory.NUMERIC);
  public static final DataType LONG_TYPE = new DataType("long datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#long"), DataTypeCategory.NUMERIC);
  public static final DataType NEG_INTEGER_TYPE = new DataType("negativeInteger datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#negativeInteger"), DataTypeCategory.NUMERIC);
  public static final DataType NONNEG_INTEGER_TYPE = new DataType("nonNegativeInteger datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#nonNegativeInteger"), DataTypeCategory.NUMERIC);
  public static final DataType NONPOS_INTEGER_TYPE = new DataType("nonPositiveInteger datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#nonPositiveInteger"), DataTypeCategory.NUMERIC);
  public static final DataType POS_INTEGER_TYPE = new DataType("positiveInteger datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#positiveInteger"), DataTypeCategory.NUMERIC);
  public static final DataType SHORT_TYPE = new DataType("short datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#short"), DataTypeCategory.NUMERIC);
  public static final DataType UNSIGN_BYTE_TYPE = new DataType("unsignedByte datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#unsignedByte"), DataTypeCategory.NUMERIC);
  public static final DataType UNSIGN_INT_TYPE = new DataType("unsignedInt datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#unsignedInt"), DataTypeCategory.NUMERIC);
  public static final DataType UNSIGN_LONG_TYPE = new DataType("unsignedLong datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#unsignedLong"), DataTypeCategory.NUMERIC);
  public static final DataType UNSIGN_SHORT_TYPE = new DataType("unsignedShort datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#unsignedShort"), DataTypeCategory.NUMERIC);
  public static final DataType PLAIN_LIT_TYPE = new DataType("PlainLiteral datatype",
      IRI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral"), DataTypeCategory.TEXT);
  public static final DataType LANG_STRING_TYPE = new DataType("langString datatype",
      IRI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#langString"), DataTypeCategory.TEXT);
  public static final DataType XML_LIT_TYPE = new DataType("XMLLiteral datatype",
      IRI.create("http://www.w3.org/1999/02/22-rdf-syntax-ns#XMLLiteral"), DataTypeCategory.TEXT);
  public static final DataType LANG_TYPE = new DataType("language datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#language"), DataTypeCategory.TEXT);
  public static final DataType NAME_TYPE = new DataType("Name datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#Name"), DataTypeCategory.TEXT);
  public static final DataType NCNAME_TYPE = new DataType("NCName datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#NCName"), DataTypeCategory.TEXT);
  public static final DataType NMTOKEN_TYPE = new DataType("NMTOKEN datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#NMTOKEN"), DataTypeCategory.TEXT);
  public static final DataType NORM_STRING_TYPE = new DataType("normalizedString datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#normalizedString"), DataTypeCategory.TEXT);
  public static final DataType STRING_TYPE = new DataType("string datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#string"), DataTypeCategory.TEXT);
  public static final DataType TOKEN_TYPE = new DataType("token datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#token"), DataTypeCategory.TEXT);
  public static final DataType DATETIME_TYPE = new DataType("dateTime datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#dateTime"), DataTypeCategory.DATE);
  public static final DataType DATETIMESTAMP_TYPE = new DataType("dateTimeStamp datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#dateTimeStamp"), DataTypeCategory.DATE);
  public static final DataType LITERAL_TYPE = new DataType("literal datatype",
      IRI.create("http://www.w3.org/2000/01/rdf-schema#Literal"), DataTypeCategory.TEXT);
  public static final DataType ANYURI_TYPE = new DataType("anyURI datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#anyURI"), DataTypeCategory.OTHER);
  public static final DataType DATE_TYPE = new DataType("date datatype",
      IRI.create("http://www.w3.org/2001/XMLSchema#date"), DataTypeCategory.DATE);
  
  /*--- Builtin Predicates ---*/
  public static final AnnotationPredicate BACKWARD = new AnnotationPredicate("is backward compatible with",
      IRI.create(OWLNamespace.toString(), "backwardCompatibleWith"));
  public static final AnnotationPredicate DEPRECATED = new AnnotationPredicate("is deprecated",
      IRI.create(OWLNamespace.toString(), "deprecated"));
  public static final AnnotationPredicate INCOMPATIBLE = new AnnotationPredicate("is incompatible with",
      IRI.create(OWLNamespace.toString(), "incompatibleWith"));
  public static final AnnotationPredicate PRIOR_VERSION = new AnnotationPredicate("has prior version",
      IRI.create(OWLNamespace.toString(), "priorVersion"));
  public static final AnnotationPredicate VERSION_INFO = new AnnotationPredicate("has version info",
      IRI.create(OWLNamespace.toString(), "versionInfo"));
  public static final DataPredicate BOTTOM_DATA_PREDICATE = new DataPredicate("bottomDataProperty",
      IRI.create(OWLNamespace.toString(), "bottomDataProperty"));
  public static final DataPredicate TOP_DATA_PREDICATE = new DataPredicate("topDataProperty",
      IRI.create(OWLNamespace.toString(), "topDataProperty"));
  public static final ObjectPredicate BOTTOM_OBJECT_PREDICATE = new ObjectPredicate("bottomObjectProperty",
      IRI.create(OWLNamespace.toString(), "bottomObjectProperty"));
  public static final ObjectPredicate TOP_OBJECT_PREDICATE = new ObjectPredicate("topObjectProperty",
      IRI.create(OWLNamespace.toString(), "topObjectProperty"));
  public static final AnnotationPredicate COMMENT = new AnnotationPredicate("has comment",
      IRI.create(RDFSNamespace.toString(), "comment"));
  public static final AnnotationPredicate DEFINED_BY = new AnnotationPredicate("is defined by",
      IRI.create(RDFSNamespace.toString(), "isDefinedBy"));
  public static final AnnotationPredicate LABEL = new AnnotationPredicate("is labeled as",
      IRI.create(RDFSNamespace.toString(), "label"));
  public static final AnnotationPredicate SEE_ALSO = new AnnotationPredicate("see also",
      IRI.create(RDFSNamespace.toString(), "seeAlso"));

  static {

    labelIRIs.add(RDFS_LABEL);
    labelIRIs.add(SKOS_LABEL);

    fixedVocabulary.add(THING);
    fixedVocabulary.add(NOTHING);
    fixedVocabulary.add(ITSELF);

    fixedVocabulary.add(IS_Object);
    fixedVocabulary.add(SAME_Object);

    fixedVocabulary.add(IS_Data);
    fixedVocabulary.add(SAME_Data);

    fixedVocabulary.add(IS_Annotation);
    fixedVocabulary.add(SAME_Annotation);

    fixedVocabulary.add(BASE64_BIN_TYPE);
    fixedVocabulary.add(HEX_BIN_TYPE);
    fixedVocabulary.add(BOOL_TYPE);
    fixedVocabulary.add(RATIONAL_TYPE);
    fixedVocabulary.add(REAL_TYPE);
    fixedVocabulary.add(BYTE_TYPE);
    fixedVocabulary.add(DECIMAL_TYPE);
    fixedVocabulary.add(DOUBLE_TYPE);
    fixedVocabulary.add(FLOAT_TYPE);
    fixedVocabulary.add(INT_TYPE);
    fixedVocabulary.add(INTEGER_TYPE);
    fixedVocabulary.add(LONG_TYPE);
    fixedVocabulary.add(NEG_INTEGER_TYPE);
    fixedVocabulary.add(NONNEG_INTEGER_TYPE);
    fixedVocabulary.add(NONPOS_INTEGER_TYPE);
    fixedVocabulary.add(POS_INTEGER_TYPE);
    fixedVocabulary.add(SHORT_TYPE);
    fixedVocabulary.add(UNSIGN_BYTE_TYPE);
    fixedVocabulary.add(UNSIGN_INT_TYPE);
    fixedVocabulary.add(UNSIGN_LONG_TYPE);
    fixedVocabulary.add(UNSIGN_SHORT_TYPE);
    fixedVocabulary.add(PLAIN_LIT_TYPE);
    fixedVocabulary.add(LANG_STRING_TYPE);
    fixedVocabulary.add(XML_LIT_TYPE);
    fixedVocabulary.add(LANG_TYPE);
    fixedVocabulary.add(NAME_TYPE);
    fixedVocabulary.add(NCNAME_TYPE);
    fixedVocabulary.add(NMTOKEN_TYPE);
    fixedVocabulary.add(NORM_STRING_TYPE);
    fixedVocabulary.add(STRING_TYPE);
    fixedVocabulary.add(TOKEN_TYPE);
    fixedVocabulary.add(DATETIME_TYPE);
    fixedVocabulary.add(DATETIMESTAMP_TYPE);
    fixedVocabulary.add(LITERAL_TYPE);
    fixedVocabulary.add(ANYURI_TYPE);

    fixedVocabulary.add(BACKWARD);
    fixedVocabulary.add(DEPRECATED);
    fixedVocabulary.add(INCOMPATIBLE);
    fixedVocabulary.add(PRIOR_VERSION);
    fixedVocabulary.add(VERSION_INFO);
    fixedVocabulary.add(BOTTOM_DATA_PREDICATE);
    fixedVocabulary.add(TOP_DATA_PREDICATE);
    fixedVocabulary.add(BOTTOM_OBJECT_PREDICATE);
    fixedVocabulary.add(TOP_OBJECT_PREDICATE);
    fixedVocabulary.add(COMMENT);
    fixedVocabulary.add(DEFINED_BY);
    fixedVocabulary.add(LABEL);
    fixedVocabulary.add(SEE_ALSO);

    fixedVocabulary.add(PERIOD);

    builtInNamespaces.add(OWLNamespace);
    builtInNamespaces.add(RDFNamespace);
    builtInNamespaces.add(RDFSNamespace);
    builtInNamespaces.add(XSDNamespace);
    builtInNamespaces.add(BUILTIN_NS);
    builtInNamespaces.add(VALUE_NS);

  }

  public static IRI getBuiltInKey(String logical) {
    return IRI.create(BUILTIN_NS.toString(), logical);
  }

  public static boolean isBuiltInVocabulary(Word wrd) {
    return builtInNamespaces.contains(wrd.getNamespace());
  }

}
