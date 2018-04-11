package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum DataFacet implements Word {
  LENGTH(Vocabulary.XSDNamespace, "length", "a length of"),
  MIN_LENGTH(Vocabulary.XSDNamespace, "minLength","a minimum length of"),
  MAX_LENGTH(Vocabulary.XSDNamespace, "maxLength", "a maximum length of"),
  PATTERN(Vocabulary.XSDNamespace, "pattern", "a pattern of"),
  MIN_INCLUSIVE(Vocabulary.XSDNamespace,"minInclusive", "greater or equal to"),
  MIN_EXCLUSIVE(Vocabulary.XSDNamespace, "minExclusive","greater than"),
  MAX_INCLUSIVE(Vocabulary.XSDNamespace, "maxInclusive","less or equal to"),
  MAX_EXCLUSIVE(Vocabulary.XSDNamespace, "maxExclusive","less than"),
  TOTAL_DIGITS(Vocabulary.XSDNamespace, "totalDigits","total digits of"),
  FRACTION_DIGITS(Vocabulary.XSDNamespace, "fractionDigits","fraction digits of"),
  LANG_RANGE(Vocabulary.RDFNamespace, "langRange","a language range of"),
  ERROR(Vocabulary.BUILTIN_NS, "error","unknown relation to");

  private IRI namespace;
  private String logicalform;
  private String normalForm;
  private DataFacet word;
  private IRI key;

  DataFacet(IRI ns, String logicalForm, String normalForm) {
    this.namespace = ns;
    this.logicalform = logicalForm;
    this.normalForm = normalForm;
    this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
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
