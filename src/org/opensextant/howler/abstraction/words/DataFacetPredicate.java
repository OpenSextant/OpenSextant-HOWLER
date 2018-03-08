package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;

public class DataFacetPredicate extends Predicate {

  private DataFacet facet;

  public DataFacetPredicate(DataFacet facet) {
    super(facet.getNormalForm(), facet.getKey());
    super.predicateType = PredicateType.FACET;
    this.facet = facet;
  }

  public DataFacet getFacet() {
    return facet;
  }

  public Scope getScope() {
    return Scope.DATA;
  }
  public WordType getWordType() {
    return WordType.DATA_FACET_PREDICATE;
  }
}
