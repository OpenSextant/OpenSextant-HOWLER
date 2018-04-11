package org.opensextant.howler.abstraction.words;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public abstract class Predicate extends WordBase {

  public enum PredicateType {
    IS, IS_ONLY, SAME_AS, VERB, FACET
  }

  private PredicateParticle predParticle;
  private String baseVerb = "";
  private PredicateParticle postParticle;
  protected PredicateType predicateType = PredicateType.VERB;
  private List<PredicateCharacteristic> characteristics = new ArrayList<PredicateCharacteristic>();

  public Predicate(String normal, IRI key) {
    super(normal, key);
  }

  public Predicate(String normal, IRI key, PredicateType type) {
    super(normal, key);
    this.predicateType = type;
  }
  
  /*
  public Predicate(PredicateType type) {
    super(type.name().toLowerCase().replaceAll("_", " "), IRI.create(Vocabulary.BUILTIN_NS.toString(), type.name()));
    this.predicateType = type;
  }

  public Predicate(String normal, PredicateType type) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), type.name()));
    this.predicateType = type;
  }
*/
  public List<PredicateCharacteristic> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<PredicateCharacteristic> characteristics) {
    this.characteristics = characteristics;
  }

  public void addCharacteristic(PredicateCharacteristic characteristic) {
    this.characteristics.add(characteristic);
  }

  public boolean isMultipartVerb() {
    if (this.predParticle != null) {
      return true;
    }

    if (this.postParticle != null) {
      return true;
    }

    return false;
  }

  public PredicateParticle getPredParticle() {
    return predParticle;
  }

  public void setPredParticle(PredicateParticle predParticle) {
    this.predParticle = predParticle;
  }

  public PredicateParticle getPostParticle() {
    return postParticle;
  }

  public void setPostParticle(PredicateParticle postParticle) {
    this.postParticle = postParticle;
  }

  public String getBaseVerb() {
    return baseVerb;
  }

  public void setBaseVerb(String baseVerb) {
    this.baseVerb = baseVerb;
  }

  public PredicateType getPredicateType() {
    return predicateType;
  }

  public void setPredicateType(PredicateType predicateType) {
    this.predicateType = predicateType;
  }

  public boolean isBuiltinPredicate() {
    return this.predicateType != PredicateType.VERB;
  }

  public WordType getWordType() {
    return WordType.PREDICATE;
  }

}
