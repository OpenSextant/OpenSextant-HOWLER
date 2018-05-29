package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class DataPredicate extends Predicate {

  public DataPredicate(String normal, IRI key) {
    super(normal, key);
    super.predicateType = PredicateType.VERB;
  }

  public DataPredicate(String normal, IRI key, PredicateType type) {
    super(normal, key);
    super.predicateType = type;
  }

  public Scope getScope() {
    return Scope.DATA_SCOPE;
  }

  public WordType getWordType() {
    return WordType.DATA_PREDICATE;
  }
}
