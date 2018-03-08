package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum PredicateCharacteristic implements Word {
  FUNCTIONAL("Functional Predicate"),
  SYMMETRIC("Symmetric Predicate"),
  ASYMMETRIC("Asymmetric Predicate"),
  REFLEXIVE("Reflexive Predicate"),
  TRANSITIVE("Transitive Predicate"),
  INVERSE_FUNCTIONAL("Inverse Functional Predicate"),
  IRREFLEXIVE("Irreflexive Predicate"),

  FUNCTIONAL_OF_INVERSE("Functional Inverse Predicate"),
  SYMMETRIC_OF_INVERSE("Symmetric Inverse Predicate"),
  ASYMMETRIC_OF_INVERSE("Asymmetric Inverse Predicate"),
  REFLEXIVE_OF_INVERSE("Reflexive Inverse Predicate"),
  TRANSITIVE_OF_INVERSE("Transitive Inverse Predicate"),
  INVERSE_FUNCTIONAL_OF_INVERSE("Inverse Functional Inverse Predicate"),
  IRREFLEXIVE_OF_INVERSE("Irreflexive Inverse Predicate");

  private final String logicalform;
  private String normalform;
  private IRI key;

  PredicateCharacteristic(String logicalForm) {
    this.logicalform = logicalForm;
    this.normalform = logicalform;
    this.key = IRI.create(Vocabulary.HOWLER_NS.toString(), logicalform);
  }

  public static PredicateCharacteristic getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
  }
  
  
  
  public String getLogicalform() {
    return logicalform;
  }

  @Override
  public String getNormalForm() {
    return normalform;
  }

  @Override
  public void setNormalForm(String normalForm) {
    // ignore
  }

  @Override
  public IRI getKey() {
    return key;
  }

  @Override
  public String getLogicalForm() {
    return logicalform;
  }

  @Override
  public String getNamespace() {
    return Vocabulary.HOWLER_NS.toString();
  }

  @Override
  public Scope getScope() {
    return Scope.OBJECT;
  }

  @Override
  public WordType getWordType() {
    return WordType.PREDICATE_CHARACTERISTIC;
  }

  @Override
  public List<Footnote> getFootnotes() {
    return new ArrayList<Footnote>();
  }

  @Override
  public void setFootnotes(List<Footnote> footnotes) {
    // ignore
  }

  @Override
  public void addFootnote(Footnote footnote) {
    // ignore
  }

}