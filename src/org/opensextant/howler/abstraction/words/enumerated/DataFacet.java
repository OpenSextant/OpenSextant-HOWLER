package org.opensextant.howler.abstraction.words.enumerated;

import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.semanticweb.owlapi.model.IRI;

public enum DataFacet implements Word {
 LENGTH_FACET("length of", Vocabulary.XSDNamespace, "length"),
 MIN_LENGTH_FACET("minimum length of", Vocabulary.XSDNamespace,"minLength"),
 MAX_LENGTH_FACET("maximum length of", Vocabulary.XSDNamespace, "maxLength"),
 PATTERN_FACET("pattern of",Vocabulary.XSDNamespace, "pattern"),
 MIN_INCLUSIVE_FACET("greater or equal to", Vocabulary.XSDNamespace,"minInclusive"),
 MIN_EXCLUSIVE_FACET("greater than", Vocabulary.XSDNamespace, "minExclusive"),
 MAX_INCLUSIVE_FACET("less or equal to", Vocabulary.XSDNamespace, "maxInclusive"),
 MAX_EXCLUSIVE_FACET("less than",Vocabulary.XSDNamespace, "maxExclusive"),
 TOTAL_DIGITS_FACET("total digits of", Vocabulary.XSDNamespace,"totalDigits"),
 FRACTION_DIGITS_FACET("fractional digits of", Vocabulary.XSDNamespace,"fractionDigits"),
 LANG_RANGE_FACET("language range of", Vocabulary.RDFNamespace,"langRange"),
 ERROR_FACET("unknown relation to", Vocabulary.BUILTIN_NS, "error");

  private IRI namespace;
  private String logicalform;
  private String normalForm;
  private DataFacet word;
  private IRI key;

  DataFacet(String normalForm, IRI ns, String logicalForm) {
    this.namespace = ns;
    this.logicalform = logicalForm;
    this.normalForm = normalForm;
    this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
  }

  public IRI getNamespace() {
    return namespace;
  }

  public static DataFacet getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(DataFacet.ERROR_FACET);
  }

  public static DataFacet getTypeByLogicalName(String logical) {
    return Stream.of(values()).filter(v -> v.getLogicalForm().equals(logical)).findAny().orElse(DataFacet.ERROR_FACET);
  }

  public DataFacet getWord() {
    return word;
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
    return this.logicalform;
  }

  @Override
  public Scope getScope() {
    return Scope.DATA_SCOPE;
  }

  @Override
  public WordType getWordType() {
    return WordType.DATA_FACET;
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
    //ignore
  }
}
