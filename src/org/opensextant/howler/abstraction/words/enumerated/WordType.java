package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

public enum WordType implements Word {
  
  GENERIC_WORD("Word",false),
  BADWORD("Badword",false),
  
  ADJECTIVE("Adjective",false),
  COMMON_NOUN("Common Noun",false),
  PROPER_NOUN("Proper Noun",false),
  
  DATATYPE("Datatype",false),
  DATAVALUE("Datavalue",false),
  
  UNDETERMINED_PREDICATE("Undetermined Predicate",false),
  OBJECT_PREDICATE("Object Predicate",false),
  DATA_PREDICATE("Data Predicate",false),
  ANNOTATION_PREDICATE("Annotation Predicate",false),
  DATA_FACET_PREDICATE("Data Facet Predicate",false),
  DATA_FACET("Data Facet",false),
  PREDICATE_PARTICLE("Predicate Particle",false),
  PREDICATE_CHARACTERISTIC("Predicate Characteristic",false),
  
  INTEGER("Integer",false),
  QUANTIFIER("Quantifier",false),

  BOOLEAN_SET_TYPE("Boolean Set Type",false),
  NEGATIVE("Negative",false),
  RELATIVE_MARKER("that",false),
  
  NOUN("Noun", true),
  CATEGORY("Category",true),
  INSTANCE("Instance",true),
  PREDICATE("Predicate",true),
  
  SCOPE("Scope",true),
  WORD_TYPE("Word Type",true);

  private final String logicalform;
  private String normalForm;
  private IRI key;
  private boolean abstractType;

  WordType(String logicalForm, boolean abstractType) {
    this.logicalform = logicalForm;
    this.normalForm = logicalform;
    this.key = IRI.create(Vocabulary.HOWLER_NS.toString(), logicalform);
    this.abstractType = abstractType;
  }

  public static WordType getTypeByNormalName(String normal) {
    return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
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
  public String getNamespace() {
    return Vocabulary.HOWLER_NS.toString();
  }

  @Override
  public Scope getScope() {
    return Scope.OBJECT;
  }

  @Override
  public WordType getWordType() {
    return WordType.WORD_TYPE;
  }

  public boolean isAbstractType() {
    return abstractType;
  }

  public void setAbstractType(boolean abstractType) {
    this.abstractType = abstractType;
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
