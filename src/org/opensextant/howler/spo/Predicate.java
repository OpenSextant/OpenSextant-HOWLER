/*
 * **************************************************************************
 *					     NOTICE
 *
 *	This software was produced for the U. S. Government
 *	under Basic Contract No. W15P7T-13-C-A802, and is
 *	subject to the Rights in Noncommercial Computer Software
 *	and Noncommercial Computer Software Documentation
 *	Clause 252.227-7014 (FEB 2012)
 *
 *  2016 The MITRE Corporation. All Rights Reserved.
 *
 * **************************************************************************
 */
package org.opensextant.howler.spo;

public class Predicate {

  public enum PredicateType {
    IS, IS_SAME_AS, VERB
  };

  private PredicateType type = PredicateType.IS;
  private boolean negative = false;
  private boolean passive = false;
  private boolean exclusive = false;

  // default verb
  private Verb verb = new Verb("is", "BE", "#");

  public Predicate() {
    type = PredicateType.IS;
    negative = false;
  }

  public Predicate(PredicateType type) {
    this.type = type;
  }

  public Predicate(PredicateType type, String verb, String vocab) {
    this.type = type;
    this.verb = new Verb(verb, "V", vocab);
  }

  public boolean isVerbType() {
    if (type == PredicateType.VERB) {
      return true;
    }
    return false;
  }

  public PredicateType getType() {
    return type;
  }

  public void setType(PredicateType type) {
    this.type = type;
  }

  public boolean isNegative() {
    return negative;
  }

  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  public boolean isPassive() {
    return passive;
  }

  public void setPassive(boolean passive) {
    this.passive = passive;
  }

  public boolean isExclusive() {
    return exclusive;
  }

  public void setExclusive(boolean exclusive) {
    this.exclusive = exclusive;
  }

  public Verb getVerb() {

    if (this.type == PredicateType.IS) {
      return new Verb("is", "V", "#");
    }

    if (this.type == PredicateType.IS_SAME_AS) {
      return new Verb("is_same_as", "V", "#");
    }

    return verb;
  }

  public void setVerb(Verb verb) {
    this.verb = verb;
  }

  @Override
  public String toString() {

    if (this.isVerbType()) {
      StringBuilder bldr = new StringBuilder();

      if (this.isNegative()) {
        bldr.append("NOT");
        bldr.append(" ");
      }

      if (verb != null) {
        bldr.append(verb.getLogicalForm());
      }

      if (this.isExclusive()) {
        bldr.append(" ");
        bldr.append("ONLY");
      }

      if (this.isPassive()) {
        bldr.append(" ");
        bldr.append("BY");
      }

      return bldr.toString();
    }

    String ret = type.name();
    if (this.isNegative()) {
      ret = "NOT " + ret;
    }

    return ret;
  }

}
