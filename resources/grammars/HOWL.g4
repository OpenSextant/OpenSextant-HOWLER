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
EXCLUSIVELY,
OR,
BY,
ONLY,
NO,
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
EITHER,
BOTH,
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
DATA_THING,
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
	| domainStatementObject
	| domainStatementDataType
	| rangeStatementObject
	| rangeStatementDataType
	| descriptionStatementObject
	| descriptionStatementDataType
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
	compoundNounPhrase predicatePhraseNoun //((AND|OR) predicatePhraseNoun)*?
;

// Datatype definition
descriptionStatementDataType
:
	A (DATATYPE|AMBIG_WORD) predicateExpressionState dataTypeExpression 
;

domainStatementDataType
:
	EVERY THING THAT pred = predicateExpressionData SOME DATA_THING IS domain = compoundNounPhrase
;

domainStatementObject
:
	EVERY THING THAT pred = predicateExpressionObject SOME THING IS  domain = compoundNounPhrase
;

domainStatementAnnotation
:
	ANNOTATION_MARKER EVERY THING THAT pred = predicateExpressionAnnotation SOME THING IS A domain = wordSequence
;

rangeStatementDataType
:
	EVERY THING IS A THING THAT pred=predicateExpressionData  range=dataTypeExpression
;

rangeStatementObject
:
	EVERY THING IS A THING THAT pred=predicateExpressionObject  range=compoundNounPhrase
;

rangeStatementAnnotation
:
	ANNOTATION_MARKER EVERY THING IS A THING THAT pred=predicateExpressionAnnotation A range=wordSequence
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

declarationStatement: subj=wordSequence IS A WORD_TYPE;


//---------- Nouns and Noun Phrases --------------

//nounPhrase: compoundNounPhrase (AND compoundNounPhrase)+;

compoundNounPhrase:
	 BOTH setIntersection = 	  compoundNounPhrase ((AND|COMMA) compoundNounPhrase)*? AND compoundNounPhrase
	|  EITHER setUnion =  		  compoundNounPhrase ((OR|COMMA)  compoundNounPhrase)*? OR  compoundNounPhrase
	| EXCLUSIVELY EITHER disjointUnion = compoundNounPhrase ((OR|COMMA)  compoundNounPhrase)* OR  compoundNounPhrase
	| proper = properNounPhrase
	| common = commonNounPhrase
	| itself = ITSELF
;

/* InstancePhrase<ProperNoun> */
properNounPhrase
:
	NOT? THE? nProperSequence
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


//--------------------- Data and Data values -----------------

/* DataType Expressions => CategoryPhrase<DatatType> or PhraseSet => OWL DataRange*/
dataTypeExpression
:
	 EITHER setUnion =        dataTypeExpression ((OR|COMMA)  dataTypeExpression)* OR  dataTypeExpression
	| BOTH setIntersection = dataTypeExpression ((AND|COMMA) dataTypeExpression)* AND dataTypeExpression
	| NOT? quant? (dt=DATATYPE| th=DATA_THING | ambig=AMBIG_WORD)
	| NOT comp = dataTypeExpression
	| rest = dataTypeRestriction
	| dv = dataValuePhrase

;

/*  CategoryPhrase<DataType> with Relative phrases  e.g. integer <that is> greater than 7, string that has the pattern "AbCD" */
dataTypeRestriction
:
	NOT? quant? (DATATYPE|AMBIG_WORD) dataFacetExpression (AND dataFacetExpression)*?
;

// individual facet-value pair
dataFacetExpression: (THAT (HAS|IS))? A? (DATA_FACET|quantNumeric) dataValue;

// an instance of data value
dataValuePhrase
:
	NOT? dataValue
;
// the type of data values
dataValue: QUOTED_TEXT | INTEGER | DECIMAL;

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
	predicateExpressionObject compoundNounPhrase
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

singlePhraseObject:compoundNounPhrase| predicatePhraseNoun | predicateExpression ;
singlePhraseData:dataTypeExpression| predicatePhraseDataType | predicatePhraseDataValue| dataFacetExpression;

catchSet: (singlePhraseObject | singlePhraseData | AND|OR|COMMA|PERIOD)+?;

badSentence: (.*?)BADWORD+(.*?);
wordSequence: ~(WORD_TYPE)+?;
//declareWordSequence: ~(WORD_TYPE)+?;

debugWordSequence: .+?;
