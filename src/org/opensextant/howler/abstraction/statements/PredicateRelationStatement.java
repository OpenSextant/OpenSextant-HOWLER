package org.opensextant.howler.abstraction.statements;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;

public class PredicateRelationStatement<P extends Predicate> extends Statement {

  private PredicateExpression<P> subject;
  private PredicateExpression<P> relation;
  private PredicateExpression<P> object;

  public PredicateRelationStatement(PredicateExpression<P> subject, PredicateExpression<P> relation,
      PredicateExpression<P> object) {
    this.subject = subject;
    this.relation = relation;
    this.object = object;
  }

  public PredicateExpression<P> getSubject() {
    return subject;
  }

  public void setSubject(PredicateExpression<P> subject) {
    this.subject = subject;
  }

  public PredicateExpression<P> getRelation() {
    return relation;
  }

  public void setRelation(PredicateExpression<P> relation) {
    this.relation = relation;
  }

  public PredicateExpression<P> getObject() {
    return object;
  }

  public void setObject(PredicateExpression<P> object) {
    this.object = object;
  }

  @Override
  public boolean isDataStatement() {
    return subject.getPredicate() instanceof DataPredicate && object.getPredicate() instanceof DataPredicate;
  }

  @Override
  public boolean isObjectStatement() {
    return subject.getPredicate() instanceof ObjectPredicate && object.getPredicate() instanceof ObjectPredicate;
  }

  @Override
  public boolean isAnnotationStatement() {
    return subject.getPredicate() instanceof AnnotationPredicate
        && object.getPredicate() instanceof AnnotationPredicate;
  }

  public String toString() {
    return this.subject + " " + this.relation + " " + this.getObject();
  }

}
