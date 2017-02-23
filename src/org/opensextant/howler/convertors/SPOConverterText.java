/*
   Copyright 2009-2016 The MITRE Corporation.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
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
package org.opensextant.howler.convertors;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.spo.Adjective;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.MassNoun;
import org.opensextant.howler.spo.Noun;
import org.opensextant.howler.spo.NounPhrase;
import org.opensextant.howler.spo.ObjectPhrase;
import org.opensextant.howler.spo.Phrase;
import org.opensextant.howler.spo.Phrase.PhraseType;
import org.opensextant.howler.spo.PhraseSet;
import org.opensextant.howler.spo.Predicate;
import org.opensextant.howler.spo.Predicate.PredicateType;
import org.opensextant.howler.spo.PredicatePhrase;
import org.opensextant.howler.spo.Proper;
import org.opensextant.howler.spo.Quantifier;
import org.opensextant.howler.spo.Quantifier.NumericQuantifierType;
import org.opensextant.howler.spo.Quantifier.QuantifierType;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.SubjectPredicateObject.SPOType;
import org.opensextant.howler.spo.Thing;
import org.opensextant.howler.spo.Verb;
import org.opensextant.howler.spo.What;
import org.opensextant.howler.spo.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPOConverterText {

  // Log object
  private static final Logger LOGGER = LoggerFactory
      .getLogger(SPOConverterText.class);

  // vocabulary names space used for the fixed vocabulary
  static String FIXED_NAMESPACE = "http://org.opensextant/howler/fixed";

  public List<String> convertSPOsToText(Document doc) {
    List<String> sentences = new ArrayList<String>();

    for (SubjectPredicateObject spo : doc.getSentences()) {
      sentences.add(convertSPOtoText(spo));
    }

    return sentences;
  }

  public String convertSPOtoText(SubjectPredicateObject spo) {
    List<Word> sent = convertSPOtoSentence(spo);
    return cleanupSentence(sent);
  }

  public List<Word> convertSPOtoSentence(SubjectPredicateObject spo) {

    List<Word> sent = new ArrayList<Word>();

    sent.addAll(convert(spo.getSubject(), false));
    sent.addAll(convert(spo.getObjects(), true));

    if (spo.getSpoType() == SPOType.STATEMENT) {
      sent.add(new Word(".", "PERIOD", "fixed", true));
    }

    if (spo.getSpoType() == SPOType.QUESTION) {
      sent.add(new Word("?", "PERIOD", "fixed", true));
    }

    return sent;
  }

  // Most general Phrase to Words conversion
  protected List<Word> convert(Phrase phrase, boolean isObject) {

    PhraseType type = phrase.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      return convert((Adjective) phrase, isObject);
    }
    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) phrase, isObject);
    }
    if (type == PhraseType.NOUN) {
      return convert((Noun) phrase, isObject);
    }
    if (type == PhraseType.NOUNPHRASE) {
      return convert((NounPhrase) phrase, isObject);
    }
    if (type == PhraseType.OBJECTPHRASE) {
      return convert((ObjectPhrase) phrase, isObject);
    }
    if (type == PhraseType.PHRASESET) {
      return convert((PhraseSet) phrase, isObject);
    }
    if (type == PhraseType.PREDICATEPHRASE) {
      return convert((PredicatePhrase) phrase, isObject);
    }
    if (type == PhraseType.THING) {
      return convert((Thing) phrase, isObject);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) phrase, isObject);
    }

    if (type == PhraseType.WORD) {
      return convert((Word) phrase, isObject);
    }
    if (type == PhraseType.PROPER) {
      return convert((Proper) phrase, isObject);
    }
    if (type == PhraseType.VERB) {
      return convert((Verb) phrase, isObject);
    }

    LOGGER.warn("Fell through all phrase types. Couldn't convert: " + phrase);
    return convert((Thing) phrase, isObject);
  }

  private List<Word> convert(ObjectPhrase phrase, boolean isObject) {

    PhraseType type = phrase.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      // TODO special handling for phrases consisting of only an adjective

      NounPhrase np = new NounPhrase();
      np.addModifier((Adjective) phrase);
      Thing thing = new Thing();
      if (isObject) {
        thing.getQuantifier().setQuantifierType(QuantifierType.A);
      } else {
        thing.getQuantifier().setQuantifierType(QuantifierType.EVERY);
      }
      np.setHead(thing);

      List<Word> zz = convert(np, isObject);
      return zz;
    }
    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) phrase, isObject);
    }
    if (type == PhraseType.NOUN) {
      return convert((Noun) phrase, isObject);
    }
    if (type == PhraseType.NOUNPHRASE) {
      return convert((NounPhrase) phrase, isObject);
    }
    if (type == PhraseType.OBJECTPHRASE) {
      return convert((ObjectPhrase) phrase, isObject);
    }
    if (type == PhraseType.PHRASESET) {
      return convert((PhraseSet) phrase, isObject);
    }
    if (type == PhraseType.THING) {
      return convert((Thing) phrase, isObject);
    }
    if (type == PhraseType.WORD) {
      return convert((Word) phrase, isObject);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) phrase, isObject);
    }

    if (type == PhraseType.PROPER) {
      return convert((Proper) phrase, isObject);
    }

    if (type == PhraseType.VERB) {
      LOGGER.error("Got a verb as an object phrase" + phrase);
      return convert((Verb) phrase, isObject);
    }

    LOGGER.error("Fell through all object phrase types:" + phrase);
    List<Word> wrds = new ArrayList<Word>();

    return wrds;
  }

  private List<Word> convert(Word phrase, boolean isObject) {

    PhraseType type = phrase.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      return convert((Adjective) phrase, isObject);
    }
    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) phrase, isObject);
    }
    if (type == PhraseType.NOUN) {
      return convert((Noun) phrase, isObject);
    }
    if (type == PhraseType.THING) {
      return convert((Thing) phrase, isObject);
    }
    if (type == PhraseType.WORD) {
      return convert((Word) phrase, isObject);
    }
    if (type == PhraseType.PROPER) {
      return convert((Proper) phrase, isObject);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) phrase, isObject);
    }

    if (type == PhraseType.VERB) {
      LOGGER.error("Got a verb as an object phrase" + phrase);
      return convert((Verb) phrase, isObject);
    }

    LOGGER.error("Fell through all word types:" + phrase);
    List<Word> wrds = new ArrayList<Word>();

    return wrds;
  }

  private List<Word> convert(PredicatePhrase phrase, boolean isObject) {

    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(convertPredicate(phrase.getPredicate()));
    wrds.addAll(convert(phrase.getObject(), true));
    return wrds;
  }

  private List<Word> convert(Adjective phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(convertQuantifer(phrase.getQuantifier(), PhraseType.ADJECTIVE,
        isObject));
    wrds.add(phrase);
    wrds.addAll(applyRelativePhrases(phrase, isObject));
    return wrds;
  }

  private List<Word> convert(MassNoun phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(convertQuantifer(phrase.getQuantifier(), PhraseType.MASSNOUN,
        isObject));
    wrds.add(phrase);
    wrds.addAll(applyRelativePhrases(phrase, isObject));

    return wrds;
  }

  private List<Word> convert(Noun phrase, boolean isObject) {

    PhraseType type = phrase.getPhraseType();

    if (type == PhraseType.ADJECTIVE) {
      return convert((Adjective) phrase, isObject);
    }
    if (type == PhraseType.MASSNOUN) {
      return convert((MassNoun) phrase, isObject);
    }

    if (type == PhraseType.THING) {
      return convert((Thing) phrase, isObject);
    }

    if (type == PhraseType.PROPER) {
      return convert((Proper) phrase, isObject);
    }

    if (type == PhraseType.WHAT) {
      return convert((What) phrase, isObject);
    }

    List<Word> wrds = new ArrayList<Word>();
    if (type == PhraseType.NOUN) {
      wrds.addAll(
          convertQuantifer(phrase.getQuantifier(), PhraseType.NOUN, isObject));
      wrds.add(phrase);
      wrds.addAll(applyRelativePhrases(phrase, isObject));

      return wrds;
    }

    LOGGER.error("Fell through all noun types:" + phrase);

    return wrds;

  }

  private List<Word> convert(NounPhrase phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(convertQuantifer(phrase.getQuantifier(), PhraseType.NOUNPHRASE,
        isObject));

    wrds.addAll(phrase.getModifiers());
    wrds.add(phrase.getHead());
    wrds.addAll(applyRelativePhrases(phrase, isObject));

    return wrds;
  }

  private List<Word> convert(Proper phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(
        convertQuantifer(phrase.getQuantifier(), PhraseType.PROPER, isObject));
    wrds.add(phrase);
    wrds.addAll(applyRelativePhrases(phrase, isObject));

    return wrds;
  }

  private List<Word> convert(Thing phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(
        convertQuantifer(phrase.getQuantifier(), PhraseType.THING, isObject));
    wrds.addAll(applyRelativePhrases(phrase, isObject));

    return wrds;
  }

  private List<Word> convert(What phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(
        convertQuantifer(phrase.getQuantifier(), PhraseType.WHAT, isObject));
    wrds.add(phrase);
    wrds.addAll(applyRelativePhrases(phrase, isObject));

    return wrds;
  }

  private List<Word> convert(Verb phrase, boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();
    wrds.add(phrase);
    return wrds;
  }

  private List<Word> convert(PhraseSet phrase, boolean isObject) {

    List<Word> wrds = new ArrayList<Word>();

    boolean neg = phrase.getQuantifier().isNegative();

    Word oper;
    // flip operator if negative, distribute negative over operands
    if (phrase.isIntersection()) {
      if (neg) {
        oper = convertStringToWord("or");
      } else {
        oper = convertStringToWord("and");
      }
    } else {
      if (neg) {
        oper = convertStringToWord("and");
      } else {
        oper = convertStringToWord("or");
      }
    }

    boolean first = true;

    for (Phrase oPhrase : phrase.getPhrases()) {

      if (!first) {
        wrds.add(oper);
      }

      first = false;

      wrds.addAll(convert(oPhrase, isObject));
    }

    return wrds;

  }

  private List<Word> applyRelativePhrases(ObjectPhrase phrase,
      boolean isObject) {
    List<Word> wrds = new ArrayList<Word>();
    for (PredicatePhrase ph : phrase.getRelativePhrases()) {
      wrds.add(convertStringToWord("that"));
      wrds.addAll(convert(ph, isObject));
    }
    return wrds;
  }

  protected List<Word> convertPredicate(Predicate predicate) {

    List<Word> wrds = new ArrayList<Word>();

    PredicateType pType = predicate.getType();

    boolean neg = predicate.isNegative();
    boolean passive = predicate.isPassive();
    boolean exclusive = predicate.isExclusive();

    if (pType == PredicateType.IS) {
      wrds.add(convertStringToWord("is"));

      if (exclusive) {
        wrds.add(convertStringToWord("only"));
      }

      if (neg) {
        wrds.add(convertStringToWord("not"));
      }
      return wrds;
    }

    if (pType == PredicateType.IS_SAME_AS) {

      if (neg) {
        wrds.addAll(convertStringsToWords("is", "not", "the", "same", "as"));
      } else {
        wrds.addAll(convertStringsToWords("is", "the", "same", "as"));
      }
      return wrds;
    }

    if (pType == PredicateType.VERB) {

      Verb v = predicate.getVerb();

      boolean part = v.isParticleVerb();
      boolean hasAux = !v.getAuxiliary().isEmpty();

      if (neg && passive) {

        if (part) {
          if (hasAux) {
            wrds.add(convertStringToWord(v.getAuxiliary()));
          } else {
            wrds.add(convertStringToWord("is"));
          }
          wrds.addAll(convertStringsToWords("not"));

          wrds.add(convertStringToWord(v.getBaseVerb()));
          wrds.add(convertStringToWord(v.getParticle()));
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
          wrds.addAll(convertStringsToWords("by"));
        } else {
          wrds.addAll(convertStringsToWords("is", "not"));
          wrds.add(v);
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
          wrds.addAll(convertStringsToWords("by"));
        }

      }

      if (neg && !passive) {
        if (part) {
          if (hasAux) {
            wrds.add(convertStringToWord(v.getAuxiliary()));
          } else {
            wrds.add(convertStringToWord("does"));
          }
          wrds.addAll(convertStringsToWords("not"));

          wrds.add(convertStringToWord(v.getBaseVerb()));
          wrds.add(convertStringToWord(v.getParticle()));
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
        } else {
          wrds.addAll(convertStringsToWords("does", "not"));
          wrds.add(v);
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
        }

      }
      if (!neg && passive) {
        if (part) {
          if (hasAux) {
            wrds.add(convertStringToWord(v.getAuxiliary()));
          } else {
            wrds.add(convertStringToWord("is"));
          }

          wrds.add(convertStringToWord(v.getBaseVerb()));
          wrds.add(convertStringToWord(v.getParticle()));
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
          wrds.addAll(convertStringsToWords("by"));
        } else {
          wrds.addAll(convertStringsToWords("is"));

          wrds.add(v);
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
          wrds.addAll(convertStringsToWords("by"));
        }
      }
      if (!neg && !passive) {
        if (part) {
          if (hasAux) {
            wrds.add(convertStringToWord(v.getAuxiliary()));
          }

          wrds.add(convertStringToWord(v.getBaseVerb()));
          wrds.add(convertStringToWord(v.getParticle()));
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
        } else {

          wrds.add(v);
          if (exclusive) {
            wrds.add(convertStringToWord("only"));
          }
        }

      }
      return wrds;
    }

    return wrds;
  }

  private List<Word> convertQuantifer(Quantifier q, PhraseType pType,
      boolean isObject) {

    boolean neg = q.isNegative();

    if (pType == PhraseType.PHRASESET) {
      return convertQuantiferPHRASESET(q, isObject, neg);
    }
    if (pType == PhraseType.MASSNOUN) {
      return convertQuantiferMASSNOUN(q, isObject, neg);
    }
    if (pType == PhraseType.ADJECTIVE) {
      return convertQuantiferAdjective(q, isObject, neg);
    }
    if (pType == PhraseType.PROPER) {
      return convertQuantiferPROPER(q, isObject, neg);
    }
    if (pType == PhraseType.THING) {
      return convertQuantiferTHING(q, isObject, neg);
    }
    if (pType == PhraseType.VERB) {
      LOGGER.error("Tried to convert quantifer for a VERB:" + q);
    }
    if (pType == PhraseType.PREDICATEPHRASE) {
      LOGGER.error("Tried to convert quantifer for a PredicatePhrase:" + q);
    }

    return convertQuantiferOther(q, isObject, neg);

  }

  private List<Word> convertQuantiferAdjective(Quantifier q, boolean isObject,
      boolean neg) {
    List<Word> wrds = new ArrayList<Word>();
    if (neg) {
      wrds.addAll(convertStringsToWords("not"));
    }

    return wrds;

  }

  private List<Word> convertQuantiferOther(Quantifier q, boolean isObject,
      boolean neg) {

    List<Word> wrds = new ArrayList<Word>();
    QuantifierType qt = q.getQuantifierType();

    if (qt == Quantifier.QuantifierType.EVERY) {

      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("not", "a"));
        } else {
          wrds.add(convertStringToWord("no"));
        }
      } else {
        if (isObject) {
          wrds.add(convertStringToWord("a"));
        } else {
          wrds.add(convertStringToWord("every"));
        }

      }

    }

    if (qt == Quantifier.QuantifierType.SOME) {

      if (neg) {
        wrds.add(convertStringToWord("no"));
      } else {
        wrds.add(convertStringToWord("some"));
      }
    }

    if (qt == Quantifier.QuantifierType.A) {

      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("not", "a"));
        } else {
          wrds.addAll(convertStringsToWords("no"));
        }
      } else {
        wrds.add(convertStringToWord("a"));
      }
    }

    if (qt == Quantifier.QuantifierType.NULL) {

      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("no"));
        } else {
          wrds.addAll(convertStringsToWords("no"));
        }
      } else {
        // wrds.add(convertStringToWord("a"));
      }
    }

    if (qt == Quantifier.QuantifierType.THE) {

      if (neg) {
        wrds.addAll(convertStringsToWords("not", "the"));
      } else {
        wrds.add(convertStringToWord("the"));
      }
    }

    if (qt == Quantifier.QuantifierType.NUMERIC) {

      Integer num = q.getQuantity();
      NumericQuantifierType nt = q.getNumericType();

      if (neg) {
        wrds.add(convertStringToWord("not"));
      }

      if (nt == NumericQuantifierType.EXACT) {
        wrds.add(convertStringToWord("exactly"));
      }
      if (nt == NumericQuantifierType.MORE_THAN) {
        wrds.addAll(convertStringsToWords("more", "than"));
      }
      if (nt == NumericQuantifierType.LESS_THAN) {
        wrds.addAll(convertStringsToWords("less", "than"));
      }
      if (nt == NumericQuantifierType.MORE_THAN_OR_EQUAL) {
        wrds.addAll(convertStringsToWords("at", "least"));
      }
      if (nt == NumericQuantifierType.LESS_THAN_OR_EQUAL) {
        wrds.addAll(convertStringsToWords("at", "most"));
      }

      wrds.add(convertStringToWord(num.toString()));

    }

    return wrds;
  }

  private List<Word> convertQuantiferMASSNOUN(Quantifier q, boolean isObject,
      boolean neg) {

    List<Word> wrds = new ArrayList<Word>();
    QuantifierType qt = q.getQuantifierType();

    if (qt == Quantifier.QuantifierType.EVERY) {

      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("no"));
        } else {
          wrds.add(convertStringToWord("no"));
        }
      } else {
        if (isObject) {
          // wrds.add(convertStringToWord("a"));
        } else {
          // wrds.add(convertStringToWord("all"));
        }

      }

    }

    if (qt == Quantifier.QuantifierType.SOME) {

      if (neg) {
        wrds.add(convertStringToWord("no"));
      } else {
        wrds.add(convertStringToWord("some"));
      }
    }

    if (qt == Quantifier.QuantifierType.NULL) {

      if (neg) {
        wrds.add(convertStringToWord("no"));
      } else {
        // wrds.add(convertStringToWord("some"));
      }
    }

    return wrds;
  }

  private List<Word> convertQuantiferTHING(Quantifier q, boolean isObject,
      boolean neg) {
    List<Word> wrds = new ArrayList<Word>();
    QuantifierType qt = q.getQuantifierType();

    if (qt == Quantifier.QuantifierType.A || qt == QuantifierType.NULL) {
      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("nothing"));
        } else {
          wrds.addAll(convertStringsToWords("nothing"));
        }
      } else {
        if (isObject) {
          wrds.addAll(convertStringsToWords("a", "thing"));
        } else {
          wrds.addAll(convertStringsToWords("a", "thing"));
        }
      }
    }

    if (qt == Quantifier.QuantifierType.EVERY) {
      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("nothing"));
        } else {
          wrds.addAll(convertStringsToWords("nothing"));
        }
      } else {
        if (isObject) {
          wrds.addAll(convertStringsToWords("everything"));
        } else {
          wrds.addAll(convertStringsToWords("everything"));
        }
      }
    }
    if (qt == Quantifier.QuantifierType.SOME) {
      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("nothing"));
        } else {
          wrds.addAll(convertStringsToWords("nothing"));
        }
      } else {
        if (isObject) {
          wrds.addAll(convertStringsToWords("something"));
        } else {
          wrds.addAll(convertStringsToWords("something"));
        }
      }
    }
    if (qt == Quantifier.QuantifierType.THE) {
      if (neg) {
        if (isObject) {
          wrds.addAll(convertStringsToWords("not", "the", "thing"));
        } else {
          wrds.addAll(convertStringsToWords("not", "the", "thing"));
        }
      } else {
        if (isObject) {
          wrds.addAll(convertStringsToWords("the", "thing"));
        } else {
          wrds.addAll(convertStringsToWords("the", "thing"));
        }
      }
    }
    if (qt == Quantifier.QuantifierType.NUMERIC) {
      Integer num = q.getQuantity();
      NumericQuantifierType nt = q.getNumericType();

      if (neg) {
        wrds.add(convertStringToWord("not"));
      }

      if (nt == NumericQuantifierType.EXACT) {
        wrds.add(convertStringToWord("exactly"));
      }
      if (nt == NumericQuantifierType.MORE_THAN) {
        wrds.addAll(convertStringsToWords("more", "than"));
      }
      if (nt == NumericQuantifierType.LESS_THAN) {
        wrds.addAll(convertStringsToWords("less", "than"));
      }
      if (nt == NumericQuantifierType.MORE_THAN_OR_EQUAL) {
        wrds.addAll(convertStringsToWords("at", "least"));
      }
      if (nt == NumericQuantifierType.LESS_THAN_OR_EQUAL) {
        wrds.addAll(convertStringsToWords("at", "most"));
      }

      wrds.add(convertStringToWord(num.toString()));
      wrds.addAll(convertStringsToWords("things"));
    }

    return wrds;
  }

  private List<Word> convertQuantiferPHRASESET(Quantifier q, boolean isObject,
      boolean neg) {
    List<Word> wrds = new ArrayList<Word>();
    if (neg) {
      if (isObject) {
        wrds.add(convertStringToWord("not"));
      } else {
        wrds.add(convertStringToWord("no"));
      }
    }
    return wrds;
  }

  private List<Word> convertQuantiferPROPER(Quantifier q, boolean isObject,
      boolean neg) {
    List<Word> wrds = new ArrayList<Word>();

    if (neg) {
      if (isObject) {
        wrds.add(convertStringToWord("not"));
      } else {
        wrds.add(convertStringToWord("no"));
      }
    }

    return wrds;
  }

  private String cleanupSentence(List<Word> sent) {

    if (sent.isEmpty()) {
      return "";
    }
    StringBuilder bldr = new StringBuilder();

    // capitalize first word in each sentence
    bldr.append(sent.get(0).getLogicalFormCapital().replaceAll("_", " "));

    for (int i = 1; i < sent.size(); i++) {
      if (sent.get(i) == null) {
        continue;
      }

      if (sent.get(i).getLogicalForm().replaceAll("_", "").isEmpty()) {
        LOGGER.warn("Empty word encountered in sentence:" + sent);
        continue;
      }

      bldr.append(" ");
      // swap "an" for "a" if next word begins with vowel
      if (sent.get(i).getLogicalForm().equals("a") && (i + 1 <= sent.size())
          && sent.get(i + 1).getLogicalForm().matches("^[aeiouAEIOU].*")) {
        bldr.append("an");
      } else {
        bldr.append(sent.get(i).getLogicalForm().replaceAll("_", " "));
      }
    }

    return bldr.toString().replaceFirst(" \\.$", ".").replaceFirst(" \\?$",
        "?");

  }

  // only used for fixed vocab
  private Word convertStringToWord(String str) {
    Word wrd = new Word(str, "FIXED", FIXED_NAMESPACE, true);
    return wrd;
  }

  // only used for fixed vocab
  private List<Word> convertStringsToWords(String... wrds) {
    List<Word> words = new ArrayList<Word>();

    for (String wrd : wrds) {
      words.add(convertStringToWord(wrd));
    }

    return words;
  }

}
