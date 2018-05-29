package org.opensextant.howler.text;

import org.antlr.v4.runtime.CommonToken;

@SuppressWarnings("serial")
public class HowlerToken extends CommonToken {

  // normalized form of text content
  private String normalForm = "";

  // the various type information
  private String pos = "";
  private String tokenTypeName = "";

  public HowlerToken(String surfaceForm) {
    this(0, surfaceForm);
  }

  public HowlerToken(int type, String surfaceForm) {
    super(type, surfaceForm);
  }

  public String getNormalForm() {
    return normalForm;
  }

  public void setNormalForm(String normalForm) {
    this.normalForm = normalForm;
  }

  public String getPos() {
    return pos;
  }

  public void setPos(String pos) {
    this.pos = pos;
  }

  public String getTokenTypeName() {
    return tokenTypeName;
  }

  public void setTokenTypeName(String tokenTypeName) {
    this.tokenTypeName = tokenTypeName;
  }

  public String toString() {

    if (this.tokenTypeName.equals("BAD")) {
      return this.text + " (" + this.tokenTypeName + "-" + this.pos + ")";
    }
    return this.text + " (" + this.tokenTypeName + ")";

  }

}
