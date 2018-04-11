package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;

public class Footnote {

  private AnnotationPredicate predicate;
  private Word word;

  public AnnotationPredicate getPredicate() {
    return predicate;
  }

  public void setPredicate(AnnotationPredicate predicate) {
    this.predicate = predicate;
  }

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }

  public String toString() {
    return predicate.getNormalForm() + "->" + word.getNormalForm();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((predicate == null) ? 0 : predicate.hashCode());
    result = prime * result + ((word == null) ? 0 : word.hashCode());
    return result;
  }

  // Footnotes are equal if they have the same predicate and word
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Footnote)) {
      return false;
    }

    Footnote other = (Footnote) obj;
    // same predicate?
    if (predicate == null) {
      if (other.predicate != null) {
        return false;
      }
    } else if (!predicate.equals(other.predicate)) {
      return false;
    }

    // same Word
    if (word == null) {
      if (other.word != null) {
        return false;
      }
    } else if (!word.equals(other.word)) {
      return false;
    }
    return true;
  }

}
