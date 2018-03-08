package org.opensextant.howler.abstraction.words;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

public class BadWord extends WordBase {

  String partOfSpeech = "";

  public BadWord(String normal) {
    super(normal, IRI.create(Vocabulary.BUILTIN_NS.toString(), normal));
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
