package org.opensextant.howler.text;

import org.opensextant.howler.abstraction.words.enumerated.WordType;

public class TypeInfo {

  private String posTag = "";
  private String elementType = "";
  private String tokenType = "";
  private WordType wordType = WordType.WORD_TYPE;

  public TypeInfo(String posTag, String elementType, String tokenType, WordType wordType) {
    this.posTag = posTag;
    this.elementType = elementType;
    this.tokenType = tokenType;
    this.wordType = wordType;
  }

  public TypeInfo(String posTag, String elementType, String tokenType) {
    this(posTag, elementType, tokenType, WordType.WORD_TYPE);
  }

  public String getPosTag() {
    return posTag;
  }
  public void setPosTag(String posTag) {
    this.posTag = posTag;
  }
  public String getElementType() {
    return elementType;
  }
  public void setElementType(String elementType) {
    this.elementType = elementType;
  }
  public String getTokenType() {
    return tokenType;
  }
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  public WordType getWordType() {
    return wordType;
  }

  public void setWordType(WordType wordType) {
    this.wordType = wordType;
  }

  public String toString() {
    String line = posTag + "\t" + elementType + "\t" + tokenType + "\t" + wordType+ "\t"  ;
    if(wordType != null){
      line = line + wordType.isAbstractType();
    }
    return line;
  }

}
