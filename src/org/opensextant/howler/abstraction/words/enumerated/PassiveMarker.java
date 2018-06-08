package org.opensextant.howler.abstraction.words.enumerated;

import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;

public enum PassiveMarker implements Word {
  BY("by");

  private final String logicalform;
  private String normalform;
  private IRI key;

  PassiveMarker(String normalForm) {
    this.logicalform = TextUtils.createLogicalFromNormal(normalForm);
    this.normalform = normalForm;
    this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
  }

  public static PassiveMarker getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(BY);
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
    return Scope.GENERAL_SCOPE;
  }

  @Override
  public WordType getWordType() {
    return WordType.BY;
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
