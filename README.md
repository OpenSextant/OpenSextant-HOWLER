 
## HOWLER
 
 HOWLER translates between a simple subset of English (HOWLER English) and OWL (Web Ontology Language) ontologies. Why might you want to do this? Many people find ontologies difficult to understand: ontologies are based on a system of formal logic which uses unfamiliar concepts and nomenclature and expressing your thoughts in this formal system is not easy. If you can express your thoughts in simple English, then HOWLER can create the ontology for you. (Why you might want an ontology in the first place is beyond the scope of this project. See https://en.wikipedia.org/wiki/Ontology_(information_science) to see if ontologies are for you. )
 
### Approach
 HOWLER works by translating English or OWL to SPOs (Subject-Predicate-Object structures) and then translating the SPOs to English or OWL (see *What's a SPO?* below for details on SPOs). Each language (HOWLER English and OWL) is defined by a formal grammar: OWL is defined by its W3C specification (https://www.w3.org/OWL/) and HOWLER is defined by the grammar in the HOWLER project (see resources/grammars/HOWL.g4). These grammars form the basis for parsers. For OWL, HOWLER uses the excellent and capable OWL API package (https://github.com/owlcs/owlapi/wiki). For HOWLER English, HOWLER uses ANTLR4 (http://www.antlr.org/) to generate the parser code from our grammar specification. The output of these parsers is then converted to SPOs by the SPOFactories (see `org.opensextant.howler.convertors.SPOFactory<Text|OWL>` ). These SPO are then converted to OWL or English by the SPOConverters (see `org.opensextant.howler.convertors.SPOConverter<Text|OWL>` ). (Yes, that means that you can translate English to English and OWL to OWL. This might not seem useful but is a big help in testing/validating the translations.) This two step approach was selected for a number of reasons:

1. the translation between the two languages is quite complex and doing it in a single step would be difficult.
2. testing and debugging is simplified since we can isolate each half of the translation
3. it will make it easier to add translations to/from other languages in the future e.g. SPARQL

#### No Magic
 HOWLER is intended to lower the language barrier between English speakers and ontologies. It does not lower the thinking barrier. HOWLER has no understanding of the content it transforms, it merely transform one language to another while (hopefully) preserving any semantics.
 
### What's a SPO?
A SPO represents a Subject-Predicate-Object triple. SPOs form the basis of the model that HOWLER uses to translate between English and OWL. SPOs and the elements they contain are abstractions that can express the contents and structures of both English (nouns, verbs, sentences ...) and OWL (axioms, properties, class expression ...) in a consistent way.

### Inspiration
 The use of simplified ("controlled") natural languages, like HOWLER English, for purposes like translating between natural languages and ontologies and other formal systems is not a new concept. HOWLER was inspired by a number of efforts like the Attempto project at the University of Zurich (http://attempto.ifi.uzh.ch).
 Also from the Attempto project,"A Survey and Classification of Controlled Natural Languages" (http://attempto.ifi.uzh.ch/site/pubs/papers/kuhn2013cl.pdf) gives a good overview of a variety of controlled natural language efforts.
 
### Kanban Demo 
Kanban is a simple information organization technique (https://en.wikipedia.org/wiki/Kanban_board) with an easy to understand visual metaphor: boards have lists, lists have cards, cards have content (mostly free text). Combining the simple but informal Kanban model with not simple but formal ontologies seemed like a good idea.  The HOWLER Kanban demo was created to show this combined model and to demonstrate how the HOWLER translation capabilities could be added to a system to make it ontology-literate. The HOWLER capabilities were bolted onto a slightly modified Wekan Kanban system (https://github.com/wekan/wekan). HOWLER Wekan sends entered text to HOWLER, HOWLER interprets the text and creates Kanban cards and card content which it sends back to Wekan. Not really meant to be a complete system but does show how HOWLER capabilities can be used to incorporate ontology capabilities such as inferencing.
 
### What does HOWLER stand for?
 HOWLER means *Some-word-beginning-with-H* OWL-English *some-word-beginning-with-R*. We have not yet decided what those words are but the name was too good not to use.