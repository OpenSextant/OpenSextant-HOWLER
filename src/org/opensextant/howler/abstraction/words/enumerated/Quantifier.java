package org.opensextant.howler.abstraction.words.enumerated;

import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.semanticweb.owlapi.model.IRI;

public enum Quantifier implements Word {
  NULL("", false),
  EVERY("every", false),
  SOME("some", false),
  ONLY("only a", false),
  A("a", false),
  THE("the", false),
  EXACT("exactly", true),
  MORE_THAN("more than", true),
  LESS_THAN("less than",true),
  MORE_THAN_OR_EQUAL("at least", true),
  LESS_THAN_OR_EQUAL("at most", true);

  private boolean numeric;
  private String normalform;
  private IRI key;

  Quantifier(String normalForm, boolean numeric) {
    this.normalform = normalForm;
    this.numeric = numeric;
    this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), this.name());
  }

  public static Quantifier getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(NULL);
  }

  public boolean isNumeric() {
    return numeric;
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
    return this.name();
  }

  @Override
  public IRI getNamespace() {
    return Vocabulary.BUILTIN_NS;
  }

  @Override
  public Scope getScope() {
    return Scope.OBJECT_SCOPE;
  }

  @Override
  public WordType getWordType() {
    return WordType.QUANTIFIER;
  }

  @Override
  public String getPOS() {
    return this.getClass().getSimpleName();
  }

  @Override
  public void setPOS(String pos) {
    // ignore
  }

  @Override
  public String getPrefix() {
    return Vocabulary.BUILTIN_PREFIX;
  }

  @Override
  public void setPrefix(String prefix) {
    // ignore
  }

}