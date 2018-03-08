package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class IntegerNum extends WordBase {

  Integer count = 0;
  
  public IntegerNum(String normal) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), normal));
  }

  public WordType getWordType() {
    return WordType.INTEGER;
  }
}
