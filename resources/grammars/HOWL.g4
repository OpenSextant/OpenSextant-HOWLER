parser grammar HOWL;

@header {
 package org.opensextant.howler.grammar;
}

options {
//	tokenVocab = Phrase;
}

tokens {
A,
ABL,
ABN,
ABX,
ALSO,
AND,
ANYX,
AP,
APOS,
AT,
BE,
BED,
BEDZ,
BEG,
BEM,
BEN,
BER,
BEZ,
BY,
CC,
CD,
CLOSEPAREN,
COLON,
COMMA,
CS,
DASH,
DO,
DOD,
DOZ,
DQUOTE,
DT,
DTI,
DTS,
DTX,
EVERY,
EVERYX,
EX,
EXACT,
GROUPOF,
HV,
HVD,
HVG,
HVN,
HVZ,
IF,
IN,
JJ,
JJR,
JJS,
JJT,
LESS,
LESSOREQUAL,
MD,
MORE,
MOREOREQUAL,
MUST,
NN,
NNS,
NONE,
NOT,
NOX,
NP,
NPS,
NR,
NRS,
OD,
ONLY,
OPENPAREN,
OR,
PERIOD,
PN,
POSS,
PPL,
PPLS,
PPO,
PPS,
PPSS,
PPx,
PPxx,
QL,
QLP,
RB,
RBR,
RBT,
RN,
RP,
SAMEAS,
SOME,
SOMEX,
THAT,
THE,
THEN,
THING,
TIC,
TO,
QMARK,
VB,
VBD,
VBG,
VBN,
VBZ,
WDT,
WPO,
WPS,
WPx,
WQL,
WRB,
WHATV
}

// "document" is the top most element in the grammar
document
:
	(
		 sentence PERIOD
//		| phraseSet (PERIOD|QMARK) //debug
		| junk (PERIOD|QMARK) //debug
	)+
;

//---------- Sentences --------------

sentence
:
	simpleSentence
;

simpleSentence
:
	np vp ( ((AND vp)*) | ((OR vp)*) )
;
//---------- Questions --------------

// ADD QUESTION GRAMMAR HERE

//---------- Nouns and Noun Phrases --------------
np
:
	nbar ( ((AND nbar)*) | ((OR nbar)*) )
;

// proper first due to overlap with a proper embedded in a common
nbar
:
	nbarProper
	| nbarCommon
;

nbarProper
:
	quantNeg? quant? nProperSequence
;

nbarCommon
:
	quantNeg? quant? adjp?
	(
		nSimple
		| nThing
//		| nProper
		| nAdj
	)
	(THAT vbar (AND THAT vbar)*)?
;


nSimple
:
	NN
	| NNS
;

nProper
:
	NP
	| NPS
;

nProperSequence
:
	adjp? nProper+
;

nThing
:
	THING
	| SOMEX
	| EVERYX
	| ANYX
	| NOX
;


nAdj
:
	JJ
	| JJR
	| JJS
	| JJT
	| VBG
	| VBN
;

adjp
:
	(
		JJ
		| JJR
		| JJS
		| JJT
		| OD
		| NP
		| NPS
		| POSS
		| NN
		| NR
		| NNS
		| VBG
		| VBN
	)+
;

// TODO add to adjp and np
//possp: (NN|NNS) POSS;

//---------- Quantifiers --------------
quant
:
	quantUniverse
	| quantExist
	| quantNumeric
	| quantA
	| quantThe
;

quantNeg
:
	NONE
;

quantThe
:
	THE
;

quantA
:
	A
;

quantUniverse
:
	EVERY
;

quantExist
:
	SOME
;

quantNumeric
:
	(
		exact
		| more
		| less
		| moreOrEqual
		| lessOrEqual
	)? CD
;

exact
:
	EXACT
	| ONLY
;

more
:
	MORE
;

less
:
	LESS
;

moreOrEqual
:
	MOREOREQUAL
;

lessOrEqual
:
	LESSOREQUAL
;



//---------- Verbs and Verb Phrases --------------
vp: vbar;

vbar
:
	vbarPassive
	| vbarSimple
	| vbarAdj
;

vbarSimple
:
	v np
;

vbarPassive
:
	vPassive np
;

vbarAdj
:
	vBE adjp
;

v
:
	modal?
	(
		vSimple
		| vParticle
		| vBE
		| vSameAs
		| vDO
		| vHAS
	) 
;

vSimple
:
	NOT? ONLY? verb ONLY? 
;

vParticle
:
	NOT? ONLY? verb ONLY? 
	(
		IN
		| RP
	)
;

vPassive
:
	modal? verbBE NOT? ONLY? VBN ONLY?  (IN|RP)? BY
;

vBE
:
	ONLY? verbBE ONLY? NOT?
;

vSameAs
:
	verbBE NOT? SAMEAS
;

vDO
:
	ONLY? verbDO ONLY? NOT?
;

vHAS
:
	ONLY? verbHAS ONLY? NOT?
;

verbBE
:
	BE
	| BED
	| BEDZ
	| BEG
	| BEM
	| BEN
	| BER
	| BEZ
;

verbDO
:
	DO
	| DOD
	| DOZ
;

verbHAS
:
	HV
	| HVD
	| HVG
	| HVN
	| HVZ
;


verb
:
	VB
	| VBD
	| VBZ
	| VBG
	| VBN
;

modal
:
	(
		MD
		| NOT
		| verbBE
		| verbHAS
		| verbDO
	)+
;

//---------- Debug stuff --------------

phraseSet
:
	phrase+
;

junk
:
	j+
;

j: phrase|catchPhrase;

phrase:np|vp|adjp;

catchPhrase
:
	(adjWord|advWord|punctWord|connWord|detWord|modWord|nounWord|verbWord|phraseWord)+?
;

adjWord:JJ|JJR|JJS|JJT;
advWord:RB|RBR|RBT|RN|RP;
connWord:CC|CS|IN;
detWord:A|ABL|ABN|ABX|AP|AT|DT|DTI|DTS|DTX|PPx|WDT;
modWord:CD|NOT|OD|POSS|QL|QLP|WQL|WRB;
nounWord:EX|NN|NNS|NP|NPS|NR|NRS|PN|PPxx|PPL|PPLS|PPO|PPS|PPSS|WPx|WPO|WPS;
punctWord:APOS|CLOSEPAREN|COLON|COMMA|DASH|DQUOTE|OPENPAREN|PERIOD|TIC;
verbWord:TO|BE|BED|BEDZ|BEG|BEM|BEN|BER|BEZ|DO|DOD|DOZ|HV|HVD|HVG|HVN|HVZ|MD|VB|VBD|VBG|VBN|VBZ;
phraseWord:A|ALSO|AND|ANYX|BY|EVERY|EVERYX|EXACT|IF|LESS|MORE|MUST|NONE|NOX|ONLY|OR|SAMEAS|SOME|SOMEX|THAT|THE|THEN|THING|GROUPOF|QMARK;

