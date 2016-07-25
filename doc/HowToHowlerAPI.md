
##How to use the HOWLER API
	
The `org.opensextant.howler.convertors.Howler` class is the entry point for all the primary HOWLER capabilities. If you are not modifying the HOWLER grammar or algorithms, it is the only class needed.
This class provides access to all of the fundamental HOWLER capabilities: to translate back and forth from OWL to English. Each of these translations 
create or consume SubjectPredicateObject (SPO) objects which serve as intermediate representations of the information being translated. For the most part these intermediate objects can be used without change.


### To create an ontology from text
1. `convertText` - pass in the text to be translated along with a title. A Document object is returned. This document object contains all of the SPO objects created from the text.
2. `toOntology` - pass in the Document created in the above step. An OWLOntology object is returned. This OWLOntology object is from the OWLAPI package so it can be used in reasoners, formatters etc which are part of OWLAPI and other packages.
 
 
### To create English text from an ontology:
1. `convertOntology` - pass in an OWLOntology object (from the OWLAPI package), a Document object is returned
2. `toText` - pass in the Document object created in the above step. A list of Strings are returned which are the English sentences translated from the ontology.
	 
### Debug and testing
In addition to above primary methods, there are convenience methods to convert a single sentence or a single OWL axiom to their SPO equivalent
 The `speechTagDocument` method will show how HOWLER is tokenizing and tagging input text prior to parsing. This can be useful in debugging tokenizing, tagging or parsing issues.

###Examples
`org.opensextant.howler.examples.BasicExample.java` is a complete example of the above steps. In addition,`org.opensextant.howler.test.RoundTripText2Text.java`
and `org.opensextant.howler.test.RoundTripOWL2OWL.java` are simple test drivers which are useful for testing and debugging collections of sentences.
