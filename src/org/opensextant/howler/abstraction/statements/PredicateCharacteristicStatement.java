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
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;

public class PredicateCharacteristicStatement<P extends Predicate> extends Statement {

  private PredicateExpression<P> subject;
  private PredicateCharacteristic characteristic;

  public PredicateCharacteristicStatement(PredicateExpression<P> subject, PredicateCharacteristic characteristic) {
    this.subject = subject;
    this.characteristic = characteristic;
  }

  public PredicateExpression<P> getSubject() {
    return subject;
  }

  public void setSubject(PredicateExpression<P> subject) {
    this.subject = subject;
  }

  public PredicateCharacteristic getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(PredicateCharacteristic characteristic) {
    this.characteristic = characteristic;
  }

  @Override
  public boolean isDataStatement() {
    return subject.getPredicate() instanceof DataPredicate;
  }

  @Override
  public boolean isObjectStatement() {
    return subject.getPredicate() instanceof ObjectPredicate;
  }

  @Override
  public boolean isAnnotationStatement() {
    return subject.getPredicate() instanceof AnnotationPredicate;
  }

  public String toString() {
    return this.subject + " (" + this.characteristic + ")";
  }

  @Override
  public List<Word> getWords() {

    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.subject.getWords());
    wrds.add(Vocabulary.IS_AUX);
    wrds.add(this.characteristic);
    wrds.add(Vocabulary.PERIOD);
    return wrds;
  }

}
