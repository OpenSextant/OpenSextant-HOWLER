package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum Quantifier implements Word {
  NULL("<NULL>", false),
  EVERY("every", false),
  SOME("some", false),
  ONLY("only", false),
  A("a", false),
  THE("the",false),
  EXACT("exactly", true),
  MORE_THAN("more_than", true),
  LESS_THAN("less_than",true),
  MORE_THAN_OR_EQUAL("more_than_or_equal", true),
  LESS_THAN_OR_EQUAL("less_than_or_equal", true);

  private final String logicalform;
  private boolean numeric;
  private String normalform;
  private IRI key;

  Quantifier(String logicalForm, boolean numeric) {
    this.logicalform = logicalForm;
    this.normalform = logicalform;
    this.numeric = numeric;
    this.key = IRI.create(Vocabulary.HOWLER_NS.toString(), logicalform);
  }

  public static Quantifier getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
  }
  
  public String getLogicalform() {
    return logicalform;
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
    return WordType.QUANTIFIER;
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