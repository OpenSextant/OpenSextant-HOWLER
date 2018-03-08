package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public abstract class Instance extends WordBase {

  public Instance(String normal, IRI key) {
    super(normal, key);
  }
/*
  public Instance(IRI key) {
    super(key);  }
*/
  public WordType getWordType() {
    return WordType.INSTANCE;
  }

}
