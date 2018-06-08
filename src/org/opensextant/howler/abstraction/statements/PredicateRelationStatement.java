package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;

public class PredicateRelationStatement<P extends Predicate> extends Statement {

  private PredicateExpression<P> subject;

  private PredicateType relationType = PredicateType.IS;
  private boolean negative = false;
  private boolean inverse = false;

  private PredicateExpression<P> object;

  public PredicateRelationStatement(PredicateExpression<P> subject, PredicateType relation,
      PredicateExpression<P> object) {
    this.subject = subject;
    this.relationType = relation;
    this.object = object;
  }

  public PredicateExpression<P> getSubject() {
    return subject;
  }

  public void setSubject(PredicateExpression<P> subject) {
    this.subject = subject;
  }

  public PredicateExpression<P> getObject() {
    return object;
  }

  public void setObject(PredicateExpression<P> object) {
    this.object = object;
  }

  public PredicateType getRelationType() {
    return relationType;
  }

  public void setRelationType(PredicateType relationType) {
    this.relationType = relationType;
  }

  public boolean isNegative() {
    return negative;
  }

  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  public boolean isInverse() {
    return inverse;
  }

  public void setInverse(boolean inverse) {
    this.inverse = inverse;
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
    return this.subject + " " + this.relationType + " " + this.getObject();
  }

  @Override
  public List<Word> getWords() {

    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.subject.getWords());

    if (relationType.equals(PredicateType.IS)) {
      if (this.isDataStatement()) {
        wrds.add(Vocabulary.IS_Data);
      }
      if (this.isAnnotationStatement()) {
        wrds.add(Vocabulary.IS_Annotation);
      }

      if (this.isObjectStatement()) {
        wrds.add(Vocabulary.IS_Object);
      }

    }
    if (relationType.equals(PredicateType.SAME_AS)) {
      if (this.isDataStatement()) {
        wrds.add(Vocabulary.SAME_Data);
      }
      if (this.isAnnotationStatement()) {
        wrds.add(Vocabulary.SAME_Annotation);
      }

      if (this.isObjectStatement()) {
        wrds.add(Vocabulary.SAME_Object);
      }
    }

    wrds.addAll(this.object.getWords());
    wrds.add(Vocabulary.PERIOD);
    return wrds;
  }

}
