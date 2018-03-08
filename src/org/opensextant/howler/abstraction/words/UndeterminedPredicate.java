package org.opensextant.howler.abstraction.words;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class UndeterminedPredicate extends Predicate {

  private List<SubjectObjectPhrase> domain = new ArrayList<SubjectObjectPhrase>();
  private List<SubjectObjectPhrase> range = new ArrayList<SubjectObjectPhrase>();

  public UndeterminedPredicate(String normal, IRI key) {
    super(normal, key);
    super.predicateType = PredicateType.VERB;
  }

  public UndeterminedPredicate(PredicateType type) {
    super(type.name().toLowerCase(), IRI.create(Vocabulary.BUILTIN_NS.toString(), type.name()));
    super.predicateType = type;
  }
  /*
   * public UndeterminedPredicate(IRI key) { super(key); }
   */
  public UndeterminedPredicate(String normal, PredicateType type) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), type.name()));
    this.predicateType = type;
  }

  public List<SubjectObjectPhrase> getDomain() {
    return domain;
  }

  public void setDomain(List<SubjectObjectPhrase> domain) {
    this.domain = domain;
  }

  public void addDomain(SubjectObjectPhrase domain) {
    this.domain.add(domain);
  }

  public List<SubjectObjectPhrase> getRange() {
    return range;
  }

  public void setRange(List<SubjectObjectPhrase> range) {
    this.range = range;
  }

  public void addRange(SubjectObjectPhrase range) {
    this.range.add(range);
  }

  public Scope getScope() {
    return Scope.OBJECT;
  }

  public WordType getWordType() {
    return WordType.UNDETERMINED_PREDICATE;
  }
}
