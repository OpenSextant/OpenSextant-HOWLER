package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum BooleanSetType implements Word {
  UNION("or"),
  INTERSECTION("and"),
  ONEOF("one of");

  private final String logicalform;
  private String normalform;
  private IRI key;

  BooleanSetType(String logicalForm) {
    this.logicalform = logicalForm;
    this.normalform = logicalform;
    this.key = IRI.create(Vocabulary.HOWLER_NS.toString(), logicalform);
  }

  public static BooleanSetType getTypeByNormalName(String normal) {
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
    return WordType.BOOLEAN_SET_TYPE;
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