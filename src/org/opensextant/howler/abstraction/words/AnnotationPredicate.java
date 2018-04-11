package org.opensextant.howler.abstraction.words;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class AnnotationPredicate extends Predicate {

  private List<Word> domain = new ArrayList<Word>();
  private List<Word> range = new ArrayList<Word>();

  public AnnotationPredicate(String normal, IRI key) {
    super(normal, key);
    super.predicateType = PredicateType.VERB;
  }

  public AnnotationPredicate(String normal, IRI key, PredicateType type ) {
    super(normal, key);
    super.predicateType = type;
  }
  
  public List<Word> getDomain() {
    return domain;
  }

  public void setDomain(List<Word> domain) {
    this.domain = domain;
  }

  public void addDomain(Word domain) {
    this.domain.add(domain);
  }

  public List<Word> getRange() {
    return range;
  }

  public void setRange(List<Word> range) {
    this.range = range;
  }

  public void addRange(Word range) {
    this.range.add(range);
  }

  public Scope getScope() {
    return Scope.ANNOTATION;
  }

  public WordType getWordType() {
    return WordType.ANNOTATION_PREDICATE;
  }
}
