##HOWLER Grammar
 	
The grammar required by the HOWLER translators is a simple subset of full English. Since the primary purposes of HOWLER is to translate
between English and OWL, this subset was selected to only include concepts and structures that have an equivalent in OWL. Since English includes some concepts that have no equivalent in OWL (for instance OWL has no distinction between past, present and future tenses), these have been excluded from HOWLER English. Similarly, OWL has some concepts that have no English equivalent (for instance there is no English equivalent to a name space)

The formal specification of HOWLER English is defined in the ANTLR4 file found in *grammars/HOWL.g4*. (see <http://www.antlr.org/> for details of ANTLR). This file is used by ANTLR to create the HOWLER's English parser. The generated code resides in *org.opensextant.howler.grammar*. Unless you are changing the HOWLER grammar you will not need to regenerate this code. Changing the grammar requires code changes may be non-trivial.

HOWLER English is meant to be a simple subset of English, with no special or unusual words or syntax. Although the formal specification mentioned above defines this subset very precisely, this specification might be difficult for a user  who just wants to write HOWLER sentences to understand . A few basic principles and rules should get them started in writing valid HOWLER English.

See the test data for examples of valid and invalid sentences. 

###HOWLER English

#### Types of sentences
 There are three types of HOWLER English sentences
  
* Descriptions - A dog is an animal.
  * States some aspect(s) or characteristic(s) about the subject. 
* Definitions -  A dog is defined as animal that says woof.  
  * States that two descriptions are equivalent: "a dog"  "animal that says woof" are equivalent. 
* Facts - Fido is a dog.  
  * States something about a specific instance of something (e.g. Fido) 
* Questions - (Not yet implemented)

#### Elements
These sentences are made up of some basic elements that can be combined into phrases and sentences.

* Nouns
  * Types (categories) of things: dog, city, person ... 
* Adjectives
  * Characteristics and aspects of things: red, homemade , Russian
* Verbs
  * actions, state or being: is, belongs to, is located in
* Quantifiers
  * quantity or scope: a, every, some, more than 3
* Individuals
  * specific instances of things: Bob, Japan, Fido
* Connectors
  * connects a phrase to another thing or phrase that it modifies: a dog that has a tail.  

###Sentence structure
* All sentences must end with a period. No periods can be used inside the sentence (e.g. for abbreviations, title or numbers).
* Proper nouns (people, places, organizations etc) should be capitalized.
* Every proper noun is a specific identity: All uses of "Bob" refer to the same Bob. 
* All sentences must have three elements (no more, no less): a subject phrase, a verb phrase and an object phrase. These elements can be complex, and consist of modifiers and sub-phrases but all three must be present.
  * Bob flies to Paris. - **OK**
  * Bob flies to Paris from London. **Not OK**.  "from London" would be a fourth element.
  * Bob surfs.  **Not OK**. No object phrase.
  
1. The subject and object phrases can have sub-phrases that modify the main subject or object e.g. Paris is a city that is located in France.
  * Subject phrase - "Paris"
  * Verb phrase - "is"
  * Object phrase - "a city"
  * Modifying sub-phrase - "is located in France"
     * modifying Verb phrase - "is located in"
     * modifying Object phrase - "France"
     
     
Sub-phrases which consist of a verb phrase and an object phrase are connected to the phrase they modify by "that".
	
5. (For developers) HOWLER can round-trip the sentences (English to ontology back to English). The resulting English is often a more precise
	paraphrase of the original sentence which, if presented back to the user, can help confirm that the original sentence has been interpreted
	as intended. See below for examples of when HOWLER might paraphrase or modify input sentences.
		
### Concepts that OWL doesn't support and how HOWLER handles them
 
1. OWL does not distinguish between past, present and future. HOWLER can recognize these different tenses but will force it to be present tense, e.g.  

  * Bob is a pilot.
  * Bob was a pilot.
  * Bob will be a pilot. 
  
  are all interpreted as "Bob is a pilot."
	
2. OWL does not have the concept of possibility, necessity or opinion. HOWLER will mostly ignore these if seen 

  * Bob could be a pilot.
  * Bob should be a pilot.
  * Bob might be a pilot.
  
   are all interpreted as "Bob is a pilot."

3. OWL does not have an equivalent for ambiguous quantities like "some", "many", "most". HOWLER will recognize them but translate those as "at least 1"  e.g. 
	* Bob owns many dogs. => Bob owns at least 1 dog.
	
	These ambiguous quantities can only occur in the object phrase.If they occur in the subject phrase, they will be translated as "every" e.g. 
	* Some pilots own a plane. => Every pilot own a plane.
	 
4. OWL primarily deals with countable things e.g. a car, 3 trucks, more than 3 houses. It doesn't have any concept of "mass nouns", 
   things which don't occur as individual pieces. e.g. water, money, software.
   HOWLER interprets  all nouns as countable nouns thus 
   * Bob drinks water => Bob drinks **a** water. 
   
   This should be understood to mean "Bob drinks **a quantity of** water."  
   
5. OWL interprets every concept (word) as a separate and distinct entity e.g. "shoe maker" is not the same as "shoe-maker". If you wish
  to use a multi-word phrase but want it interpreted as a single thing or concept, hyphenate the words into a single phrase "shoe-maker". Similarly, 
  since HOWLER and OWL have no built-in vocabulary, it will not know that "**United Nations**" is a single entity (an organization) but will
  interpret it as some nations that are united. Hyphenating phrases like these e.g. "**United-Nations**" will allow HOWLER to recognize 
  that it is intended to be a single thing. 
 	  	
		
