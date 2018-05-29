package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;

public class DescriptionStatement<P extends Predicate> extends Statement {

  private boolean domain = false;
  private boolean range = false;

  private SubjectObjectPhrase subject;
  private PredicatePhrase<SubjectObjectPhrase, P> predicatePhrase;

  public SubjectObjectPhrase getSubject() {
    return subject;
  }

  public void setSubject(SubjectObjectPhrase subject) {
    this.subject = subject;
  }

  public PredicatePhrase<SubjectObjectPhrase, P> getPredicatePhrase() {
    return predicatePhrase;
  }

  public void setPredicatePhrase(PredicatePhrase<SubjectObjectPhrase, P> predicatePhrase) {
    this.predicatePhrase = predicatePhrase;
  }

  @Override
  public boolean isDataStatement() {
    return predicatePhrase.getPredicateExpression().getPredicate() instanceof DataPredicate;
  }

  @Override
  public boolean isObjectStatement() {
    return predicatePhrase.getPredicateExpression().getPredicate() instanceof ObjectPredicate;
  }

  @Override
  public boolean isAnnotationStatement() {
    return predicatePhrase.getPredicateExpression().getPredicate() instanceof AnnotationPredicate;
  }

  public boolean isDomain() {
    return domain;
  }

  public void setDomain(boolean domain) {
    this.domain = domain;
  }

  public boolean isRange() {
    return range;
  }

  public void setRange(boolean range) {
    this.range = range;
  }

  public DescriptionStatement<AnnotationPredicate> asAnnotationStatement() {
    return (DescriptionStatement<AnnotationPredicate>) this;
  }

  public DescriptionStatement<DataPredicate> asDataStatement() {
    return (DescriptionStatement<DataPredicate>) this;
  }

  public DescriptionStatement<ObjectPredicate> asObjectStatement() {
    return (DescriptionStatement<ObjectPredicate>) this;
  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.subject.getWords());
    wrds.addAll(this.predicatePhrase.getWords());
    wrds.add(Vocabulary.PERIOD);
    return wrds;
  }

  public String toString() {
    return this.subject + " " + this.predicatePhrase.getPredicateExpression() + " " + this.predicatePhrase.getObject();
  }

}
