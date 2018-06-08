package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.InstancePhrase;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Instance;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.ProperNoun;

public class FactStatement<P extends Predicate, O extends Instance> extends Statement {

  private InstancePhrase<ProperNoun> subject;
  private PredicatePhrase<InstancePhrase<O>, P> instancePredicatePhrase = null;
  private PredicatePhrase<SubjectObjectPhrase, P> subjectObjectPredicatePhrase = null;

  public InstancePhrase<ProperNoun> getSubject() {
    return subject;
  }

  public void setSubject(InstancePhrase<ProperNoun> subject) {
    this.subject = subject;
  }

  public boolean isInstanceObject() {
    return this.instancePredicatePhrase != null;
  }

  public boolean isSubjectObjectObject() {
    return this.subjectObjectPredicatePhrase != null;
  }

  public PredicatePhrase<InstancePhrase<O>, P> getInstancePredicatePhrase() {
    return instancePredicatePhrase;
  }

  public void setInstancePredicatePhrase(PredicatePhrase<InstancePhrase<O>, P> instancePredicatePhrase) {
    this.instancePredicatePhrase = instancePredicatePhrase;
    this.subjectObjectPredicatePhrase = null;
  }

  public PredicatePhrase<SubjectObjectPhrase, P> getSubjectObjectPredicatePhrase() {
    return subjectObjectPredicatePhrase;
  }

  public void setSubjectObjectPredicatePhrase(PredicatePhrase<SubjectObjectPhrase, P> subjectObjectpredicatePhrase) {
    this.subjectObjectPredicatePhrase = subjectObjectpredicatePhrase;
    this.instancePredicatePhrase = null;
  }

  @Override
  public boolean isDataStatement() {

    if (this.isInstanceObject()) {
      return instancePredicatePhrase.getPredicateExpression().getPredicate() instanceof DataPredicate;
    } else {
      return subjectObjectPredicatePhrase.getPredicateExpression().getPredicate() instanceof DataPredicate;
    }

  }

  @Override
  public boolean isObjectStatement() {
    if (this.isInstanceObject()) {
      return instancePredicatePhrase.getPredicateExpression().getPredicate() instanceof ObjectPredicate;
    } else {
      return subjectObjectPredicatePhrase.getPredicateExpression().getPredicate() instanceof ObjectPredicate;
    }
  }

  @Override
  public boolean isAnnotationStatement() {
    if (this.isInstanceObject()) {
      return instancePredicatePhrase.getPredicateExpression().getPredicate() instanceof AnnotationPredicate;
    } else {
      return subjectObjectPredicatePhrase.getPredicateExpression().getPredicate() instanceof AnnotationPredicate;
    }
  }

  public FactStatement<AnnotationPredicate, ProperNoun> asAnnotationStatement() {
    return (FactStatement<AnnotationPredicate, ProperNoun>) this;
  }

  public FactStatement<DataPredicate, DataValue> asDataStatement() {
    return (FactStatement<DataPredicate, DataValue>) this;
  }

  public FactStatement<ObjectPredicate, ProperNoun> asObjectStatement() {
    return (FactStatement<ObjectPredicate, ProperNoun>) this;
  }

  public String toString() {

    if (this.isInstanceObject()) {
      return this.subject + " " + this.instancePredicatePhrase.getPredicateExpression() + " "
          + this.instancePredicatePhrase.getObject();

    }
    if (this.isSubjectObjectObject()) {
      return this.subject + " " + this.subjectObjectPredicatePhrase.getPredicateExpression() + " "
          + this.subjectObjectPredicatePhrase.getObject();
    }

    return this.subject + "? ?";

  }

  @Override
  public List<Word> getWords() {
    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(this.subject.getWords());

    if (this.isInstanceObject()) {
      wrds.addAll(this.getInstancePredicatePhrase().getWords());
    }

    if (this.isSubjectObjectObject()) {
      wrds.addAll(this.getSubjectObjectPredicatePhrase().getWords());
    }
    wrds.add(Vocabulary.PERIOD);
    return wrds;
  }

}
