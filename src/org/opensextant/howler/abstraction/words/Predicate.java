package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public abstract class Predicate extends WordBase {

  public enum PredicateType {
    IS, SAME_AS, VERB, FACET
  }

  private boolean passiveForm = false;

  protected PredicateType predicateType = PredicateType.VERB;

  public Predicate(String normal, IRI key) {
    super(normal, key);
    this.setPOS("VB");
  }

  public Predicate(String normal, IRI key, PredicateType type) {
    super(normal, key);
    this.predicateType = type;
    this.setPOS("VB");
  }

  public PredicateType getPredicateType() {
    return predicateType;
  }

  public void setPredicateType(PredicateType predicateType) {
    this.predicateType = predicateType;
  }

  public boolean isBuiltinPredicate() {
    return this.predicateType != PredicateType.VERB;
  }

  public boolean isPassiveForm() {
    return passiveForm;
  }

  public void setPassiveForm(boolean passiveForm) {
    this.passiveForm = passiveForm;
  }

  public WordType getWordType() {
    return WordType.PREDICATE;
  }

}
