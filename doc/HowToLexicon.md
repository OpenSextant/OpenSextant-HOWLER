###How to modify the HOWLER lexicon

 The statistical language model that HOWLER uses to tag words with their part of speech ( nouns, verbs , adjectives etc) is 
 defined by two data sets derived from a large sample of English text:

1. a lexicon which contains a large set of English words and their possible part(s) of speech and the frequency (probability) for that part of speech
2. a collection of n-grams: sequences of parts of speech (POS) that occur in English and their frequencies 

These data sets are contained in *resources/data/pos*.

While the n-gram file contains statistical data which is difficult to create, adding or modifying the lexicon file is 
straightforward. Each line of the lexicon file contains the information for a single word. (Note that it must be a single
word, no spaces allowed. Hyphenated words are permitted) The information for each entry is one or more POS tag-frequency pair(s).
(see below for the set of valid POS tags). The frequency is an integer. The parts of the entry are separated by spaces.
For example:

* Bombay NP 1
* bomb NN 33 VB 3

This sample indicates that the word "Bombay" will always be tagged as a NP (a proper noun), while the word "bomb" can be either a 
NN (common noun) or a VB (verb), with the noun being more likely (higher frequency value). If there is only a single POS tag 
the numeric value is not significant.

There are two situations where the lexicon could be adjusted to correct an error in part of speech tagging or parsing. 
(The `speechTagDocument` method on the HOWLER class will show how HOWLER is tagging a word).

1. The word is in the lexicon but is not being tagged correctly. 
	If the desired/correct POS tag is not listed with the word in question, add the desired tag with a value of 1 and see if that gives the correct response. 
	If this does not give desired response, increase the value to be greater that the tag(s) which are being incorrectly returned.
2. The word is not in the lexicon. 
	This case is simply to remedy: add it to the lexicon, with the desired tag and a frequency value of 1.

The most common case for incorrect tagging will be proper nouns such as people,company or place names or names which look like descriptions (e.g. united nations).
For most cases adding it to the lexicon tagged as a proper noun (NP) and a frequency of 1 will work. For multi-part proper names like United Nations, adding it 
in a hyphenated form (United-Nations) and using it's hyphenated form in any input text will resolve the tagging issue.


### Part of Speech tags
 Below are the valid part of speech tags for use in the lexicon file. Note that the lexicon uses a large number of tags besides 
 these but use or changes involving those tags are rare,complex and likely to cause bad things to happen.

Tag | Description | Examples
----|-------------|--------  
JJ | adjective | big, fast, slow
NN | singular common noun | dog, house, skateboard
NNS | plural common noun | dogs, houses, skateboards
NP | singular proper noun | Steve, France, Acme
NPS | plural proper noun | Romans, Cadillacs, Masons
CD | cardinal numeral, | 1, one, million
OD | ordinal numeral | first, second, 701st
VB | verb (present tense) | investigate find, act, follow 
VBN | verb (past participle) | conducted, charged, won 
VBD | verb (past tense) | said, produced, took, recommended 
VBG | verb (present participle) | modernizing, improving, purchasing 
VBZ | verb (present tense, 3rd person singular) | deserves, believes, receives 
