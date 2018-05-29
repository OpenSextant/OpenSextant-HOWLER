package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class GenericWord extends WordBase {

  public GenericWord(String normal, IRI key) {
    super(normal, key);
  }

  public GenericWord(String normal, String pos) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), normal));
    this.setPOS(pos);
  }

  public WordType getWordType() {
    return WordType.GENERIC_WORD;
  }
}
