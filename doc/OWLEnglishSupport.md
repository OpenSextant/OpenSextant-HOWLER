
###Some details about HOWLER's support for OWL.


This table shows if the OWL element is supported in translating from OWL to English, from English to OWL and if the round trip from OWL to English back to OWL results in the same (or logically equivalent) form. See footnotes for details.

 

Category|Element|OWL to English|English to OWL|Round trip Equivalent|Foot Notes
--------|-------|--------------|--------------|-----------|-----
 |Ontology|Y|Y|Y|
Axiom|Declaration||Y||6
ClassAxiom|EquivalentClasses|Y|Y|Y|10
ClassAxiom|DisjointClasses|Y|Y|Y|10
ClassAxiom|SubclassOf|Y|Y|Y|
ClassAxiom|DisjointUnion|Y|Y|Y|
AssertionAxiom|ClassAssertion|Y|Y|Y|
AssertionAxiom|SameIndividual|Y|Y|Y|10
AssertionAxiom|DifferentIndividuals|Y|Y|Y|10
AssertionAxiom|ObjectPropertyAssertion|Y|Y|Y|
AssertionAxiom|NegativeObjectPropertyAssertion|Y|Y|Y|
AssertionAxiom|DataPropertyAssertion||||3
AssertionAxiom|NegativeDataPropertyAssertion||||3
ObjectPropertyAxiom|EquivalentObjectProperties||||2
ObjectPropertyAxiom|SubObjectProperty||||2
ObjectPropertyAxiom|InverseObjectProperties||Y||2
ObjectPropertyAxiom|FunctionalObjectProperty|Y|||2,9
ObjectPropertyAxiom|InverseFunctionalObjectProperty|Y|||2,9
ObjectPropertyAxiom|SymmetricObjectProperty||||2
ObjectPropertyAxiom|AsymmetricObjectProperty||||2
ObjectPropertyAxiom|TransitiveObjectProperty||||2
ObjectPropertyAxiom|ReflexiveObjectProperty|Y||Y|2,9
ObjectPropertyAxiom|IrreflexiveObjectProperty|Y||Y|2,9
ObjectPropertyAxiom|ObjectPropertyDomain|Y||Y|2,9
ObjectPropertyAxiom|ObjectPropertyRange|Y||Y|2,9
ObjectPropertyAxiom|DisjointObjectProperties||||2
ObjectPropertyAxiom|SubPropertyChainOf||||2
DataPropertyAxiom|EquivalentDataProperties||||2
DataPropertyAxiom|SubDataProperty||||2
DataPropertyAxiom|FunctionalDataProperty||||2
DataPropertyAxiom|DataPropertyDomain||||2
DataPropertyAxiom|DataPropertyRange||||2
DataPropertyAxiom|DisjointDataProperties||||2
Axiom|DatatypeDefinition||||3
Axiom|HasKey||||4
Axiom|SwrlRule||||5
AnnotationAxiom|AnnotationAssertion||||1
AnnotationAxiom|SubAnnotationPropertyOf||||1
AnnotationAxiom|AnnotationPropertyRange||||1
AnnotationAxiom|AnnotationPropertyDomain||||1
Entity|AnnotationProperty||||1
Entity|Class|Y|Y|Y|
Entity|DataProperty||||3
Entity|Datatype||||3
Literal|Literal||||3
Entity|NamedIndividual|Y|Y|Y|
Entity|AnonymousIndividual|Y|||8
Entity|ObjectProperty|Y|Y|Y|
ObjectProperty|InverseObjectProperty |Y|Y|Y|
ClassExpression|ObjectComplementOf|Y|Y|Y|
ClassExpression|ObjectUnionOf|Y|Y|Y|
ClassExpression|ObjectIntersectionOf|Y|Y|Y|
ClassExpression|ObjectOneOf|Y|Y|Y|
ClassExpression|ObjectAllValuesFrom|Y|Y|Y|
ClassExpression|ObjectSomeValuesFrom|Y|Y|Y|
ClassExpression|ObjectHasValue|Y|||
ClassExpression|ObjectExactCardinality|Y|Y|Y|
ClassExpression|ObjectMaxCardinality|Y|Y|Y|
ClassExpression|ObjectMinCardinality|Y|Y|Y|
ClassExpression|ObjectHasSelf|Y|||7
ClassExpression|DataHasValue||||3
ClassExpression|DataAllValuesFrom||||3
ClassExpression|DataSomeValuesFrom||||3
ClassExpression|DataExactCardinality||||3
ClassExpression|DataMaxCardinality||||3
ClassExpression|DataMinCardinality||||3
 
 
1. Annotations are ignored
2. Most data and object property axioms are not supported since they are effectively sentences about verbs which result in very awkward and unnatural English expressions.
3. Data-like elements (literals, datatypes, data class expressions) are not supported since English has no real distinction between class-like and data-like elements.
4. No obvious English equivalent for HasKey semantics.
5. Rules not yet supported. A SWRL subset to English possible but English to SWRL would require very complex English grammar to enforce DL-safety
6. Declarations don’t carry much semantic weight and are ignored. Only entities which are actually used in an axiom are translated. Declarations are created for entities which appear in the generated ontology.
7. No obvious English equivalent for has-self semantics 
8. No obvious English equivalent for anonymous individuals.
9. OWL rewritten as equivalent subclass expression before translation to English. The resulting English would thus be interpreted as a (logically equivalent )subclass expression rather than the original expression
10. Expanded into multiple pairwise axioms for axioms with more than two elements
 
 
 
 