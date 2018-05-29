package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class ObjectPredicate extends Predicate {

  public ObjectPredicate(String normal, IRI key) {
    super(normal, key);
    super.predicateType = PredicateType.VERB;
  }

  public ObjectPredicate(String normal, IRI key, PredicateType type) {
    super(normal, key);
    super.predicateType = type;
  }

  public Scope getScope() {
    return Scope.OBJECT_SCOPE;
  }

  public WordType getWordType() {
    return WordType.OBJECT_PREDICATE;
  }
}
