package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum DataFacet implements Word {
  LENGTH(Vocabulary.XSDNamespace, "length", "has_a_length_of"),
  MIN_LENGTH(Vocabulary.XSDNamespace, "minLength","has_a_minimum_length_of"),
  MAX_LENGTH(Vocabulary.XSDNamespace, "maxLength", "has_a_maximum_length_of"),
  PATTERN(Vocabulary.XSDNamespace, "pattern", "has_a_pattern_of"),
  MIN_INCLUSIVE(Vocabulary.XSDNamespace,"minInclusive", "is_greater_or_equal_to"),
  MIN_EXCLUSIVE(Vocabulary.XSDNamespace, "minExclusive","is_greater_than"),
  MAX_INCLUSIVE(Vocabulary.XSDNamespace, "maxInclusive","is_less_or_equal_to"),
  MAX_EXCLUSIVE(Vocabulary.XSDNamespace, "maxExclusive","is_less_than"),
  TOTAL_DIGITS(Vocabulary.XSDNamespace, "totalDigits","has_total_digits_of"),
  FRACTION_DIGITS(Vocabulary.XSDNamespace, "fractionDigits","has_fraction_digits_of"),
  LANG_RANGE(Vocabulary.RDFNamespace, "langRange","has_a_language_range_of"),
  ERROR(Vocabulary.BUILTIN_NS, "error","has_unknown_relation_to");

  private IRI namespace;
  private String logicalform;
  private String normalForm;
  private DataFacet word;
  private IRI key;

  DataFacet(IRI ns, String logicalForm, String normalForm) {
    this.namespace = ns;
    this.logicalform = logicalForm;
    this.normalForm = normalForm;
    this.key = IRI.create(Vocabulary.HOWLER_NS.toString(), logicalform);
  }

  public String getNamespace() {
    return namespace.toString();
  }

  public static DataFacet getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
  }

  public static DataFacet getTypeByLogicalName(String logical) {
	    return Stream.of(values()).filter(v -> v.getLogicalForm().equals(logical)).findAny().orElse(null);
	  }
  
  
  public DataFacet getWord() {
    return word;
  }

  public String getLogicalform() {
    return logicalform;
  }

  @Override
  public String getNormalForm() {
    return normalForm;
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
  public Scope getScope() {
    return Scope.DATA;
  }

  @Override
  public WordType getWordType() {
    return WordType.DATA_FACET;
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
