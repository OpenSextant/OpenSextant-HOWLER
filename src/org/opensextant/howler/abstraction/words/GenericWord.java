package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class GenericWord extends WordBase {

  public GenericWord(String normal, IRI key) {
    super(normal, key);
  }
/*
  public GenericWord(IRI key) {
    super(key);
  }
*/
  public GenericWord(String normal) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), normal));
  }

  public WordType getWordType() {
    return WordType.GENERIC_WORD;
  }
}
