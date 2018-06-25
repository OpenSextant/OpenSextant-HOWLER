package org.opensextant.howler.abstraction.words.enumerated;

import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;

public enum WordType implements Word {
//@formatter:off
  GENERIC_WORD("generic word",false,false),
  BADWORD("badword",false,false),
  ADJECTIVE("adjective",false,false),
  COMMON_NOUN("common noun",false,false),
  PROPER_NOUN("proper noun",false,false),
  DATATYPE("datatype",false,false),
  DATAVALUE("datavalue",false,false),
  OBJECT_PREDICATE("object predicate",false,false),
  DATA_PREDICATE("data predicate",false,false),
  ANNOTATION_PREDICATE("annotation predicate",false,false),
  DATA_FACET_PREDICATE("data facet predicate",true,false),
  DATA_FACET("data facet",false,true),
  PREDICATE_CHARACTERISTIC("predicate characteristic",false,true),
  QUANTIFIER("quantifier",false,true),
  BOOLEAN_SET_TYPE("boolean set type",false,true),
  NEGATIVE("negative",false,true),
  THAT("that",false,true),
  BY("by",false,true),
  NOUN("noun", true,false),
  CATEGORY("category",true,false),
  INSTANCE("instance",true,false),
  PREDICATE("predicate",true,false),
  SCOPE("scope",false,true),
  WORD_TYPE("word type",false,true);
//@formatter:on

  private final String logicalform;
  private String normalForm;
  private IRI key;
  private boolean abstractType;
  private boolean enumerated;

  WordType(String normalForm, boolean abstractType, boolean enumerated) {
    this.logicalform = TextUtils.createLogicalFromNormal(normalForm);
    this.normalForm = normalForm;
    this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
    this.abstractType = abstractType;
    this.enumerated = enumerated;
  }

  public static WordType getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(BADWORD);
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
    return WordType.WORD_TYPE;
  }

  public boolean isAbstractType() {
    return abstractType;
  }

  public boolean isEnumerated() {
    return enumerated;
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
