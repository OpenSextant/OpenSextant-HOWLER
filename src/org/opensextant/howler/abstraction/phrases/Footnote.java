package org.opensextant.howler.abstraction.phrases;

import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;

public class Footnote {

  private AnnotationPredicate predicate;
  private Word wordBase;

  public AnnotationPredicate getPredicate() {
    return predicate;
  }

  public void setPredicate(AnnotationPredicate predicate) {
    this.predicate = predicate;
  }

  public Word getWord() {
    return wordBase;
  }

  public void setWord(Word wordBase) {
    this.wordBase = wordBase;
  }

  public String toString() {
    return predicate.getNormalForm() + "->" + wordBase.getNormalForm();
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((predicate == null) ? 0 : predicate.hashCode());
    result = prime * result + ((wordBase == null) ? 0 : wordBase.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
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
    if (predicate == null) {
      if (other.predicate != null) {
        return false;
      }
    } else if (!predicate.equals(other.predicate)) {
      return false;
    }
    if (wordBase == null) {
      if (other.wordBase != null) {
        return false;
      }
    } else if (!wordBase.equals(other.wordBase)) {
      return false;
    }
    return true;
  }

}
