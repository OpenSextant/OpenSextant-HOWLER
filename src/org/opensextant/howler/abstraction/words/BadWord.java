package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class BadWord extends WordBase {

  public BadWord(String normal, IRI key) {
    super(normal, key);
  }

  public WordType getWordType() {
    return WordType.BADWORD;
  }
}
