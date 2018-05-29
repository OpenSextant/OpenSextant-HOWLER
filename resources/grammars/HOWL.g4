parser grammar HOWL;

@header {
 package org.opensextant.howler.text.grammar;
}

options {

}

tokens {
ADJECTIVE,
BADWORD,
COMMON_NOUN,
QUOTED_TEXT,
OPEN,
CLOSE,
PERIOD,
COMMA,
NUMBER,
INTEGER,
DECIMAL,
DOES,
DASH,
HAS,
PARTICLE,
IS,
PROPER_NOUN,
PREDICATE,
AND,
ONEOF,
OR,
BY,
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
DATA_FACET,
SOME,
THE,
SAME_AS,
INVERSE_OF,
THAT,
OBJECT_SCOPE,
DATA_SCOPE,
ANNOTATION_MARKER,
ANNOTATION_SPLIT,
DATATYPE,
ITSELF,
TO,
PREDICATE_CHARACTERISTIC,
QUOTE,
WORD_TYPE,
THING,
DATA_VALUE,
AMBIG_WORD
}

// "document" is the top most element in the grammar

document
:
	(
		(statement PERIOD )| (debug PERIOD)
	)+
;

//---------- Statements (sentences) --------------

statement
:
	factStatementObject
	| factStatementData
	| descriptionStatementObject
	| descriptionStatementDataType
	| domainStatementObject
	| domainStatementDataType
	| rangeStatementObject
	| rangeStatementDataType
	| annotationStatement
	| declarationStatement
	| predicateCharacteristicStatement
	| predicateRelationStatement
	| domainStatementAnnotation
	| rangeStatementAnnotation
;

//debug and catch-all

debug
:
	singlePhraseObject
	| singlePhraseData
	| catchSet
	| badSentence
	| debugWordSequence
;

// ----- The statements ------

factStatementData
:
	properNounPhrase predicatePhraseDataValue  //((AND|OR) predicatePhraseDataValue)*
;

factStatementObject
:
	properNounPhrase predicatePhraseNoun //((AND|OR) predicatePhraseNoun)*
;

descriptionStatementObject
:
	compoundNounPhrase predicatePhraseNoun //((AND|OR) predicatePhraseNoun)*
;

// Datatype definition
descriptionStatementDataType
:
	A (DATATYPE|AMBIG_WORD) predicateExpressionState dataTypeExpression 
;

//TODO Object should be some value?
domainStatementDataType
:
	ONLY A? subj=compoundNounPhrase pred=predicateExpressionData (A|SOME) DATA_VALUE
;

domainStatementObject
:
	ONLY A? subj=compoundNounPhrase pred=predicateExpressionObject (A|SOME) THING
;

domainStatementAnnotation
:
	ANNOTATION_MARKER ONLY A? subj=wordSequence pred=predicateExpressionAnnotation (A|SOME) THING
;

rangeStatementDataType
:
	(A|SOME) THING pred=predicateExpressionData ONLY  obj=dataTypeExpression
;

rangeStatementObject
:
	(A|SOME) THING pred=predicateExpressionObject ONLY  obj=compoundNounPhrase
;

rangeStatementAnnotation
:
	ANNOTATION_MARKER (A|SOME) THING pred=predicateExpressionAnnotation ONLY A obj=wordSequence
;

predicateCharacteristicStatement
:
	THE wordSequence WORD_TYPE IS PREDICATE_CHARACTERISTIC
;

predicateRelationStatement
:
	THE subj=wordSequence WORD_TYPE relIS=IS NOT? relSame=SAME_AS? relInv=INVERSE_OF? THE obj=wordSequence WORD_TYPE?
;

annotationStatement
:
ANNOTATION_MARKER subj=wordSequence ANNOTATION_SPLIT rel=wordSequence ANNOTATION_SPLIT (objValue=dataValue|objWord=wordSequence)
;

declarationStatement: subj=declareWordSequence IS A WORD_TYPE;


//---------- Nouns and Noun Phrases --------------

nounPhrase: properNounPhrase | compoundNounPhrase;

compoundNounPhrase:
	 ONEOF oneof=             properNounPhrase  ((OR|COMMA)  properNounPhrase)+
	| setIntersection = 	compoundNounPhrase ((AND|COMMA)compoundNounPhrase)+	 
	| setUnion =  			compoundNounPhrase ((OR|COMMA) compoundNounPhrase)+
	| ONEOF disjointUnion = compoundNounPhrase ((OR|COMMA) compoundNounPhrase)+
	| common = commonNounPhrase
	| itself = ITSELF
;

/* InstancePhrase<ProperNoun> */
properNounPhrase
:
	THE? nProperSequence
;
// a sequence of proper nouns, to be interpreted as a single instance
nProperSequence
:
	(PROPER_NOUN|AMBIG_WORD)+
;

/* CategoryPhrase<Noun> with noun/propernoun/dataValue based relative phrases */
commonNounPhrase
:
	NOT? quant? adjp?
	(
		COMMON_NOUN
		| ADJECTIVE
		| PROPER_NOUN
		| THING
		| AMBIG_WORD
	)
	(THAT predicatePhrase (AND THAT predicatePhrase)*?)?
;

// a sequence of modifiers
adjp
:
	(COMMON_NOUN|PROPER_NOUN|AMBIG_WORD|ADJECTIVE)+
;

// a set of proper nouns
//oneOfProperNoun: ONEOF properNounPhrase ((OR|COMMA) properNounPhrase)+;

//--------------------- Data and Data values -----------------

/* DataType Expressions => CategoryPhrase<DatatType> or PhraseSet => OWL DataRange*/
dataTypeExpression
:
	NOT? quant? dt=DATATYPE
	| NOT? quant? ambig=AMBIG_WORD
	| NOT comp = dataTypeExpression
	| rest = dataTypeRestriction
	| oneof = oneOfData
	| dv = dataValuePhrase
	| setUnion = dataTypeExpression ((OR|COMMA) dataTypeExpression)+
	| setIntersection = dataTypeExpression ((AND|COMMA) dataTypeExpression)+
;

/*  CategoryPhrase<DataType> with Realtive pharses  e.g. integer <that is> greater than 7, string that has the pattern "AbCD" */
dataTypeRestriction
:
	NOT? quant? (DATATYPE|AMBIG_WORD) dataFacetExpression (AND dataFacetExpression)*?
;

// individual facet-value pair => PredicatePhrase<InstancePhrase<DataValue>,DataFacetPredicate>
dataFacetExpression: (THAT (HAS|IS))? A? (DATA_FACET|quantNumeric) dataValue;

// an instance of data value
dataValuePhrase
:
	NOT? dataValue
;
// the type of data values
dataValue: QUOTED_TEXT | INTEGER | DECIMAL;

// a set of data values (XOR semantics?) TODO allow only one value?
oneOfData : ONEOF dataValue ((OR|COMMA) dataValue)+;

//---------- Quantifiers --------------

quant
:
	A
	| THE
	| EVERY
	| SOME
	| NO
	| ONLY
	| quantNumericExpression
;

quantNumeric
:
	EXACT
	| MORE_THAN
	| LESS_THAN
	| MORE_THAN_OR_EQUAL
	| LESS_THAN_OR_EQUAL
;

// numeric qualifiers absent modifier=EXACT
quantNumericExpression
:
	quantNumeric? INTEGER
;


//---------- Predicate Expressions and Predicate Phrases --------------

// scoped predicate expressions
predicateExpressionObject:predicateExpression;
predicateExpressionData:predicateExpression;
predicateExpressionAnnotation:predicateExpression;

predicateExpressionVerbData: predicateExpressionVerb;

// all predicate expressions
predicateExpression
:
	predicateExpressionVerb
	| predicateExpressionState
;

// predicate expressions that includes a "real" verb (i.e. other than "is" or "same as")
predicateExpressionVerb:
		predicateExpressionSimple
		| predicateExpressionParticle
		| predicateExpressionPassive
		| predicateExpressionNoun
		| predicateExpressionHAS
		| predicateExpressionDO
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
	(DOES NOT)? predicate
;

// predicate expression with a particle (preposition or verb particle)
predicateExpressionParticle
:
	(IS|DOES)? NOT? predicate PARTICLE
;

//TODO passive PREDICATE should be VBN specifically
// passive form a a predicate expression
predicateExpressionPassive
:
	 IS NOT? predicate PARTICLE? BY
;

// noun based predicate expression e.g. is president of, has interest in
predicateExpressionNoun
:
	(IS|HAS|predicate) NOT? (A|THE)? adjp? PARTICLE
;

// interpreted as some form of equivalence/disjointness
predicateExpressionSameAs
:
	IS NOT? SAME_AS
;

// various forms of "to be", intepreted as some form of subtype/subclass
predicateExpressionBE
:
	 IS NOT?
;

// some form of "do"
predicateExpressionDO
:
	DOES NOT?
;

// forms of has?
predicateExpressionHAS
:
	DOES? NOT? HAS
;


predicate: PREDICATE|AMBIG_WORD;

//-------------- Predicate Phrases --------------------------

// a predicate phrase with a noun phrase as object

predicatePhraseNoun
:
	predicateExpressionObject nounPhrase
;

// a predicate phrase with a datatype expression as its object

predicatePhraseDataType
:
	predicateExpressionData dataTypeExpression
;

// a predicate phrase with a single data value as its object (must have a "real" verb predicate expression)

predicatePhraseDataValue
:
	predicateExpressionVerbData dataValuePhrase
;


// all types of predicate phrases 
predicatePhrase: predicatePhraseNoun| predicatePhraseDataType | predicatePhraseDataValue  ;

//---------- Debug and catch-all stuff --------------

singlePhraseObject:nounPhrase| predicatePhraseNoun | predicateExpression ;
singlePhraseData:dataTypeExpression| predicatePhraseDataType | predicatePhraseDataValue| dataFacetExpression;

catchSet: (singlePhraseObject | singlePhraseData | AND|OR|COMMA|PERIOD)+?;

badSentence: (.*?)BADWORD+(.*?);
wordSequence: ~(WORD_TYPE)+?;
declareWordSequence: ~(WORD_TYPE)+?;

debugWordSequence: .+?;
