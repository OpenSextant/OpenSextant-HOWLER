package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class Negative extends WordBase {

  public Negative(String normal) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), normal));
  }

  public WordType getWordType() {
    return WordType.NEGATIVE;
  }
}
