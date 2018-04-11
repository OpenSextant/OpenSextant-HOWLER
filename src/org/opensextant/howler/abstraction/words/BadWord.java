package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class BadWord extends WordBase {

  String partOfSpeech = "";

  public BadWord(String normal, IRI key) {
    super(normal, key);
  }

  public String getPartOfSpeech() {
    return partOfSpeech;
  }

  public void setPartOfSpeech(String partOfSpeech) {
    this.partOfSpeech = partOfSpeech;
  }

  public WordType getWordType() {
    return WordType.BADWORD;
  }
}
