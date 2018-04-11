parser grammar HOWL;

@header {
 package org.opensextant.howler.text.grammar;
}

options {
//	tokenVocab = Phrase;
}

tokens {
ADJECTIVE,
BAD,
NOUN,
QUOTED_TEXT,
OPEN,
CLOSE,
PERIOD,
COMMA,
NUMBER,
INTEGER,
DECIMAL,
DOES,
HAS,
PARTICLE,
IS,
PROPER,
PREDICATE,
AND,
ONEOF,
OR,
BY,
IS_ONLY,
ONLY,
NO,
NONE,
NOT,
A,
EVERY,
EXACT,
LESS_THAN,
LESS_THAN_OR_EQUAL,
MORE_THAN,
MORE_THAN_OR_EQUAL,
PATTERN_OF,
LENGTH_OF,
MIN_LENGTH_OF,
MAX_LENGTH_OF,
TOTAL_DIGITS_OF,
FRAC_DIGITS_OF,
LANG_RANGE_OF,
SOME,
THE,
SAME_AS,
INVERSE_OF,
THAT,
MODAL,
OBJECT_FLAG,
DATA_FLAG,
ANNOTATION_FLAG,
DATATYPE,
ITSELF,
TO,
PRED_CHAR,
QUOTE
}

// "document" is the top most element in the grammar
document
:
	(
		 statement PERIOD
		 | singlePhrase PERIOD
		 | debug PERIOD

	)+
;

//---------- Statements (sentences) --------------

statement
:
	factStatementObject
	| factStatementData
	| descriptionStatementObject
	| descriptionStatementDataType
	| predicateRelationStatementObject
	| predicateRelationStatementData
	| predicateRelationStatementAnnotation
	| predicateCharacteristicStatementObject
	| predicateCharacteristicStatementData
	| predicateCharacteristicStatementAnnotation
	| annotationStatement
;

//debug and catch-all

singlePhrase
:
	singlePhraseObject
	| singlePhraseData
;

debug
:
	catchSet
	| badSentence
	| catchAll
;

// ----- The statements ------

// a statement with a common noun or mixed common/proper noun subject and one or more noun or data value based predicate phrases 
descriptionStatementObject
:
	nounPhraseSubject predicatePhraseNoun //((AND|OR) predicatePhraseMixed)*
;

descriptionStatementDataType
:
	nounPhraseSubject predicatePhraseData //((AND|OR) predicatePhraseData)*
;

factStatementData
:
	properNounPhrase predicatePhraseDataValue  //((AND|OR) predicatePhraseDataValue)*
;

factStatementObject
:
	properNounPhrase predicatePhraseCommonNounOrSet //((AND|OR) predicatePhraseCommonNounOrSet)*
;


predicateRelationStatementObject
:
	OPEN OBJECT_FLAG CLOSE (TO IS?)? subj=predicateExpressionVerbObject ( (relIS=IS NOT?) | ( IS (NOT)? relSame=SAME_AS) | (IS (NOT)? relInv=INVERSE_OF) ) (TO IS?)? obj=predicateExpressionVerbObject
;

predicateRelationStatementData
:
	OPEN DATA_FLAG CLOSE (TO IS?)? subj=predicateExpressionVerbData ( (relIS=IS NOT?) | ( IS (NOT)? relSame=SAME_AS) | (IS (NOT)? relInv=INVERSE_OF) ) (TO IS?)? obj=predicateExpressionVerbData
;

predicateRelationStatementAnnotation
:
	OPEN ANNOTATION_FLAG CLOSE (TO IS?)? subj=predicateExpressionVerbAnnotation ( (relIS=IS NOT?) | ( IS (NOT)? relSame=SAME_AS) | (IS (NOT)? relInv=INVERSE_OF) ) (TO IS?)? obj=predicateExpressionVerbAnnotation
;



predicateCharacteristicStatementObject
:
	OPEN OBJECT_FLAG CLOSE (TO IS?)? predicateExpressionVerbObject IS PRED_CHAR
;

predicateCharacteristicStatementData
:
	OPEN DATA_FLAG CLOSE (TO IS?)? predicateExpressionVerbData IS PRED_CHAR
;

predicateCharacteristicStatementAnnotation
:
	OPEN ANNOTATION_FLAG CLOSE (TO IS?)? predicateExpressionVerbAnnotation IS PRED_CHAR
;




annotationStatement
:
OPEN ANNOTATION_FLAG CLOSE subj=annotationWord rel=predicateExpressionAnnotation (objWord=annotationWord|objValue=dataValue)
;

//---------- Nouns and Noun Phrases --------------


//------- Nouns and Proper nouns ----------

/* CategoryPhrase<Noun> with noun/propernoun/dataValue based relative phrases */
commonNounPhrase
:
	NOT? quant? adjp?
	(
		NOUN
		| ADJECTIVE
		| PROPER
	)
	(THAT predicatePhraseMixed (AND THAT predicatePhraseMixed)*)?
;

// a sequence of modifiers
adjp
:
	(ADJECTIVE|NOUN|PROPER|PREDICATE)+
;

/* InstancePhrase<ProperNoun> */
properNounPhrase
:
	THE? nProperSequence
;
// a sequence of proper nouns, to be interpreted as a single instance
nProperSequence
:
	PROPER+
;

// either a commonnoun or proper noun phrase
nounOrProperNounPhrase:
	properNounPhrase
	|commonNounPhrase
	| oneOfProperNoun
;

// a set of proper nouns (XOR semantics)
oneOfProperNoun: ONEOF properNounPhrase ((OR|COMMA) properNounPhrase)+;

// a set of common nouns and/or propernouns  HACK: any nested sets must follow a common noun phrase or oneOf (avoid left-recursion)
nounSet:  nounOrProperNounPhrase ((AND|OR|COMMA) nounPhraseSubject)+;
//dataTypeSet: (dataTypePhrase | oneOfData) ((AND|OR|COMMA) dataPhrase)+ ;

// all noun/propernoun phrases and sets
//nounPhrase:nounOrProperNounPhrase | oneOfProperNoun| nounSet;

// all nounphrases except a single Proper nound (used as subject of Description phrase)
nounPhraseSubject:commonNounPhrase | nounSet;

nounPhraseCatch: commonNounPhrase | properNounPhrase | oneOfProperNoun | nounSet;



//--------------------- Data and Data values -----------------

/* CategoryPhrase<DataType> a datatype with datatype based relative clauses (datatype restrictions) */
dataTypePhrase
:
	NOT? A 
	(
		DATATYPE
	)
	((THAT (IS|HAS))? dataTypeRestriction (AND (THAT (IS|HAS))? dataTypeRestriction)*)?
;

// individual facet(predicate)-value pair 
dataTypeRestriction: facet dataValue;
// the possible facets
facet: EXACT|LESS_THAN|LESS_THAN_OR_EQUAL|MORE_THAN|MORE_THAN_OR_EQUAL|PATTERN_OF|LENGTH_OF|MIN_LENGTH_OF|MAX_LENGTH_OF|PATTERN_OF|TOTAL_DIGITS_OF|FRAC_DIGITS_OF|LANG_RANGE_OF;

// an instance of data value
dataValuePhrase
:
	NOT? dataValue
;
// the type of data values
dataValue: QUOTED_TEXT | number;
number: INTEGER | DECIMAL;

// either a datatype or a data value phrase
//dataTypeOrDataValueSetPhrase: dataTypePhrase|oneOfData;

// a set of data values (XOR semantics?)
oneOfData : ONEOF dataValue ((OR|COMMA) dataValue)+;

// a set of data types and/or data values HACK: any nested sets must follow a datatype phrase or oneOf (avoid left-recursion)
dataTypeSet: (dataTypePhrase | oneOfData) ((AND|OR|COMMA) dataPhrase)+ ;

// all datatype and data value-set based phrases (=> OWL DataRange)
dataPhrase:dataTypePhrase | dataTypeSet | oneOfData;

dataPhraseCatch:dataTypePhrase | dataValuePhrase | oneOfData | dataTypeSet ;


// ---------------- Annotation subject and objects -----------
annotationWord:
	NOUN|ADJECTIVE|PROPER|PREDICATE|DATATYPE
;

//---------- Quantifiers --------------

quant
:
	A
	| THE
	| EVERY
	| SOME
	| NO
	| quantNumeric
;

// numeric qualifiers absent modifier=EXACT
quantNumeric
:
	(
		EXACT
		| MORE_THAN
		| LESS_THAN
		| MORE_THAN_OR_EQUAL
		| LESS_THAN_OR_EQUAL
	)? INTEGER
;


//---------- Predicate Expressions and Predicate Phrases --------------

// scoped predicate expressions
predicateExpressionObject:predicateExpression;
predicateExpressionData:predicateExpression;
predicateExpressionAnnotation:predicateExpression;

// all predicate expressions
predicateExpression
:
	predicateExpressionVerb
	| predicateExpressionState
;


predicateExpressionVerbObject:predicateExpressionVerb;
predicateExpressionVerbData:predicateExpressionVerb;
predicateExpressionVerbAnnotation:predicateExpressionVerb;

// predicate expressions that includes a "real" verb (i.e. other than "is" or "same as")
predicateExpressionVerb:
		predicateExpressionSimple
		| predicateExpressionParticle
		| predicateExpressionPassive
		| predicateExpressionNoun
		| predicateExpressionHAS
		| predicateExpressionDO
		| predicateExpressionHAS_POSS
;

// predicate indicating either subtype or equivalence
predicateExpressionState
:
	predicateExpressionBE
	| predicateExpressionSameAs
;

// simplest predicate expression verb optionally negated
predicateExpressionSimple
:
	(DOES NOT)? PREDICATE
;

// predicate expression with a particle (preposition verb particle)
predicateExpressionParticle
:
	(IS|DOES|HAS)? NOT? PREDICATE PARTICLE
;

//TODO passive PREDICATE should be VBN specifically
// passive form a a predicate expression
predicateExpressionPassive
:
	 IS NOT? PREDICATE PARTICLE? BY
;

// noun based predicate expression e.g. is president of, has interest in
predicateExpressionNoun
:
	(IS|HAS|PREDICATE) NOT? (A|THE)? adjp? PARTICLE
;


// various forms of "to be", intepreted as some form of subtype/subclass
predicateExpressionBE
:
	 IS NOT?
;

// intrepreted as some form of equivalence/disjointness
predicateExpressionSameAs
:
	IS? NOT? SAME_AS
;

// some form of "do"
predicateExpressionDO
:
	DOES NOT?
;

// some form of "has"
predicateExpressionHAS
:
	HAS NOT?
;

// other forms of has?
predicateExpressionHAS_POSS
:
	DOES? NOT? HAS
;

//-------------- Predicate Phrases --------------------------

// --- common and proper noun based predicate phrases --------

// a predicate phrase with a single common noun as object
predicatePhraseCommonNoun: predicateExpressionObject commonNounPhrase; 

// a predicate phrase with a single proper noun as object
predicatePhraseProperNoun: predicateExpressionObject properNounPhrase; 

// a predicate phrase with a set of proper nouns as object
predicatePhraseProperNounSet: predicateExpressionObject oneOfProperNoun; 

// a predicate phrase with a set of common and/or proper nouns as objects
predicatePhraseNounSet: predicateExpressionObject nounSet; 

// a predicate phrase with a common noun or common/proper noun set object
predicatePhraseCommonNounOrSet: predicatePhraseCommonNoun | predicatePhraseNounSet  ;

// special predicate phrase with "itself" as object
predicatePhraseItself: predicateExpressionObject  ITSELF ;

// all common/proper based predicate phrases
predicatePhraseNoun: predicatePhraseCommonNoun | predicatePhraseProperNoun | predicatePhraseProperNounSet | predicatePhraseNounSet | predicatePhraseItself;

// --- datatype and data value based predicate phrases ------

// a predicate phrase with a single datatype as its object
predicatePhraseDataType:  predicateExpressionData dataTypePhrase;

// a predicate phrase with a single data value as its object (must have a "real" verb predicate expression)
predicatePhraseDataValue: predicateExpressionVerbData  dataValuePhrase ;

// a predicate phrase with a set of data values as its object
predicatePhraseDataValueSet:  predicateExpressionData oneOfData;

// a predicate phrase with a set of datatypes and/or data values as objects
predicatePhraseDataSet:  predicateExpressionData dataTypeSet;

predicatePhraseData: predicatePhraseDataType | predicatePhraseDataValueSet | predicatePhraseDataSet ;

// a predicate phrase that includes both noun, proper noun, data type and data values as object
predicatePhraseMixed: predicatePhraseNoun| predicatePhraseDataValue  ;


//---------- Debug and catch-all stuff --------------

singlePhraseObject:nounPhraseCatch|predicatePhraseNoun ;
singlePhraseData:dataPhraseCatch| predicatePhraseData | predicatePhraseDataValue| dataTypeRestriction;

catchSet: (singlePhraseObject | singlePhraseData | AND|OR|COMMA) +;

badSentence: (.*?)BAD+(.*?);

catchAll: .*?;
