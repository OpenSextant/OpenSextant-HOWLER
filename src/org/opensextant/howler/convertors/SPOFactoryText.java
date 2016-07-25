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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.opensextant.howler.grammar.HOWL;
import org.opensextant.howler.grammar.HOWL.AdjpContext;
import org.opensextant.howler.grammar.HOWL.DocumentContext;
import org.opensextant.howler.grammar.HOWL.JContext;
import org.opensextant.howler.grammar.HOWL.JunkContext;
import org.opensextant.howler.grammar.HOWL.ModalContext;
import org.opensextant.howler.grammar.HOWL.NAdjContext;
import org.opensextant.howler.grammar.HOWL.NProperSequenceContext;
import org.opensextant.howler.grammar.HOWL.NSimpleContext;
import org.opensextant.howler.grammar.HOWL.NThingContext;
import org.opensextant.howler.grammar.HOWL.NbarCommonContext;
import org.opensextant.howler.grammar.HOWL.NbarContext;
import org.opensextant.howler.grammar.HOWL.NbarProperContext;
import org.opensextant.howler.grammar.HOWL.NpContext;
import org.opensextant.howler.grammar.HOWL.QuantContext;
import org.opensextant.howler.grammar.HOWL.SentenceContext;
import org.opensextant.howler.grammar.HOWL.SimpleSentenceContext;
import org.opensextant.howler.grammar.HOWL.VBEContext;
import org.opensextant.howler.grammar.HOWL.VContext;
import org.opensextant.howler.grammar.HOWL.VDOContext;
import org.opensextant.howler.grammar.HOWL.VHASContext;
import org.opensextant.howler.grammar.HOWL.VParticleContext;
import org.opensextant.howler.grammar.HOWL.VPassiveContext;
import org.opensextant.howler.grammar.HOWL.VSameAsContext;
import org.opensextant.howler.grammar.HOWL.VSimpleContext;
import org.opensextant.howler.grammar.HOWL.VbarAdjContext;
import org.opensextant.howler.grammar.HOWL.VbarContext;
import org.opensextant.howler.grammar.HOWL.VbarPassiveContext;
import org.opensextant.howler.grammar.HOWL.VbarSimpleContext;
import org.opensextant.howler.grammar.HOWL.VpContext;
import org.opensextant.howler.lexer.HowlLexer;
import org.opensextant.howler.spo.Adjective;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.MassNoun;
import org.opensextant.howler.spo.Noun;
import org.opensextant.howler.spo.NounPhrase;
import org.opensextant.howler.spo.ObjectPhrase;
import org.opensextant.howler.spo.Phrase.PhraseType;
import org.opensextant.howler.spo.PhraseSet;
import org.opensextant.howler.spo.Predicate;
import org.opensextant.howler.spo.Predicate.PredicateType;
import org.opensextant.howler.spo.PredicatePhrase;
import org.opensextant.howler.spo.Proper;
import org.opensextant.howler.spo.Quantifier;
import org.opensextant.howler.spo.Quantifier.QuantifierType;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.Thing;
import org.opensextant.howler.spo.Verb;
import org.opensextant.howler.spo.What;
import org.opensextant.howler.spo.Word;
import org.opensextant.howler.utils.OWLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPOFactoryText {

  // Log object
  private static final Logger LOGGER = LoggerFactory
      .getLogger(SPOFactoryText.class);

  HowlLexer lexer;
  String vocab;

  public SPOFactoryText(File lexiconFile, File ngramFile, File phraseFile,
      String voc) {
    this.vocab = voc;
    lexer = new HowlLexer(lexiconFile, ngramFile, phraseFile);
  }

  public Document convertText(String title, String content) {

    // create stream from input string
    ANTLRInputStream input = new ANTLRInputStream(content);

    // set stream input on lexer
    lexer.setInput(input);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // pull all the tokensinto the buffer
    tokens.fill();

    // now parse the tokens
    HOWL parser = new HOWL(tokens);

    // convert to SPOs starting at the top element (document)
    Document doc = convertDocument(parser.document(), title);
    return doc;
  }

  // document -> ontology (top most element)
  private Document convertDocument(DocumentContext ctx, String title) {

    Document doc = new Document();
    doc.setTitle(title);

    List<SubjectPredicateObject> spoList = new ArrayList<SubjectPredicateObject>();

    // loop over all sentences
    List<SentenceContext> sentences = ctx.sentence();

    for (SentenceContext sentence : sentences) {

      // convert sentence to spo
      SubjectPredicateObject spo = convertSentence(sentence);

      // add to SPO list
      spoList.add(spo);
    }

    // loop over all junk (no real parse) sentences

    for (JunkContext junk : ctx.junk()) {
      StringBuilder noParse = new StringBuilder();

      for (JContext j : junk.j()) {
        if (j.catchPhrase() != null) {
          noParse.append(this.text(j.catchPhrase()));
          noParse.append(" ");
        }
        if (j.phrase() != null) {
          noParse.append(this.text(j.phrase()));
          noParse.append(" ");
        }
      }
      doc.addUnparsedSentences(noParse.toString());
    }

    LOGGER.info(
        "Converted " + sentences.size() + " sentences into " + spoList.size()
            + " SPOs. " + ctx.junk().size() + " sentences were unparseable");

    doc.setSentences(spoList);
    return doc;
  }

  // all sentence types -> SPO
  private SubjectPredicateObject convertSentence(SentenceContext ctx) {

    SimpleSentenceContext simpleSent = ctx.simpleSentence();

    if (simpleSent != null) {
      return convertSimpleSentence(simpleSent);
    }

    LOGGER.error("Got a null sentence");
    return new SubjectPredicateObject();
  }

  // sentence -> axiom(s)
  private SubjectPredicateObject convertSimpleSentence(
      SimpleSentenceContext ctx) {

    SubjectPredicateObject spo = new SubjectPredicateObject();

    // get the sentence NP convert to SPO subject
    ObjectPhrase subj = convertNp(ctx.np());
    spo.setSubject(subj);

    // get the sentence VPs and convert to SPO predicates and objects
    List<VpContext> vps = ctx.vp();
    for (VpContext vp : vps) {
      PredicatePhrase obj = convertVp(vp);
      spo.addObject(obj);
    }

    // check to see if the VPs are ANDed or ORed together
    if (ctx.AND() != null && !ctx.AND().isEmpty()) {
      spo.getObjects().setIntersection(true);
    } else {
      spo.getObjects().setIntersection(false);
    }

    return spo;
  }

  // common adjective phrase -> list of Nouns
  private List<Noun> convertAdjp(AdjpContext ctx) {

    List<Noun> wrds = new ArrayList<Noun>();

    // convert all adjs to Adjectives, add to set
    for (int c = 0; c < ctx.getChildCount(); c++) {
      TerminalNode tNode = (TerminalNode) ctx.getChild(c);

      Noun wrd = convertTerminalToNoun(tNode, PhraseType.ADJECTIVE);

      // TODO treat propers being used as modifiers like propers or adjective?
      /*
       * String tname =
       * HOWL.VOCABULARY.getDisplayName(tNode.getSymbol().getType());
       * 
       * if (tname.equalsIgnoreCase("NP") || tname.equalsIgnoreCase("NPS")) {
       * wrd = convertTerminalToNoun(tNode, PhraseType.PROPER); }
       */
      wrds.add(wrd);
    }

    return wrds;
  }

  private ObjectPhrase convertNbarCommon(NbarCommonContext ctx) {

    Noun head = null;

    boolean isNeg = false;
    if (ctx.quantNeg() != null) {
      isNeg = true;
    }

    // extract the quantifier
    Quantifier q = convertQuant(ctx.quant());
    q.setNegative(isNeg);

    // get the modifiers
    List<Noun> mods = new ArrayList<Noun>();
    if (ctx.adjp() != null) {
      mods = convertAdjp(ctx.adjp());
    }

    // get the relative clauses
    List<PredicatePhrase> rels = new ArrayList<PredicatePhrase>();
    if (ctx.vbar() != null) {
      for (VbarContext vbar : ctx.vbar()) {
        PredicatePhrase relPhrase = convertVbar(vbar);
        rels.add(relPhrase);
      }
    }

    if (ctx.nSimple() != null) {
      head = convertNSimple(ctx.nSimple());
      head.setQuantifier(q);
      head.setRelativePhrases(rels);
    }

    if (ctx.nThing() != null) {
      head = convertNThing(ctx.nThing());
      // quantifier already set
      // flip negative if present (double negative)
      if (isNeg) {
        head.getQuantifier().setNegative(!head.getQuantifier().isNegative());
      }
      head.setRelativePhrases(rels);
    }
    /*
     * if (ctx.nProper() != null) { // demote Proper to Noun head =
     * convertnProper(ctx.nProper()); head.setQuantifier(q);
     * head.setRelativePhrases(rels); }
     */
    if (ctx.nAdj() != null) {
      mods.add(convertNAdj(ctx.nAdj()));
      head = new Thing();
      head.setQuantifier(q);
      head.setRelativePhrases(rels);
    }

    if (mods.isEmpty()) {
      return head;
    }

    // if nbar has modifier, upgrade to nounphrase, set head and modifiers

    NounPhrase np = new NounPhrase();

    np.setHead(head);
    np.addModifiers(mods);
    np.setRelativePhrases(rels);
    head.setRelativePhrases(new ArrayList<PredicatePhrase>());
    np.setQuantifier(q);

    return np;

  }

  /*
   * not used since NP handled as part of NProperSequence // demotes a proper to
   * a Noun for use as a named common private Noun convertnProper(NProperContext
   * ctx) {
   * 
   * Token t = null;
   * 
   * if (ctx.NP() != null) { t = ctx.NP().getSymbol(); }
   * 
   * if (ctx.NPS() != null) { t = ctx.NPS().getSymbol(); }
   * 
   * if (t == null) { LOGGER.error("No Proper in NProper"); return new Noun("",
   * "NP", vocab, true); }
   * 
   * String text = t.getText(); String tname =
   * HOWL.VOCABULARY.getDisplayName(t.getType()); return new Noun(text, tname,
   * vocab, true);
   * 
   * }
   */
  private Noun convertNAdj(NAdjContext ctx) {

    if (ctx.JJ() != null) {
      return convertTerminalToNoun(ctx.JJ(), PhraseType.ADJECTIVE);
    }
    if (ctx.JJR() != null) {
      return (convertTerminalToNoun(ctx.JJR(), PhraseType.ADJECTIVE));
    }
    if (ctx.JJS() != null) {
      return (convertTerminalToNoun(ctx.JJS(), PhraseType.ADJECTIVE));
    }
    if (ctx.JJT() != null) {
      return (convertTerminalToNoun(ctx.JJT(), PhraseType.ADJECTIVE));
    }
    if (ctx.VBG() != null) {
      return (convertTerminalToNoun(ctx.VBG(), PhraseType.ADJECTIVE));
    }
    if (ctx.VBN() != null) {
      return (convertTerminalToNoun(ctx.VBN(), PhraseType.ADJECTIVE));
    }

    LOGGER.error("Fell through all adjective types in adjective " + text(ctx));
    return null;
  }

  // extract the quantifier
  private Quantifier convertQuant(QuantContext qc) {

    Quantifier q = new Quantifier();

    // treat no quantifier as A type
    if (qc == null) {
      q.setQuantifierType(Quantifier.QuantifierType.A);
      return q;
    }

    // type "A"
    if (qc.quantA() != null) {
      // if (neg) {
      // q.setQuantType(Quantifier.QuantifierType.EVERY);
      // }
      q.setQuantifierType(Quantifier.QuantifierType.A);
      return q;
    }

    // type "some"
    if (qc.quantExist() != null) {
      q.setQuantifierType(Quantifier.QuantifierType.SOME);
      return q;
    }

    // type "the"
    if (qc.quantThe() != null) {
      q.setQuantifierType(Quantifier.QuantifierType.THE);
      return q;
    }

    // type "every"
    if (qc.quantUniverse() != null) {
      q.setQuantifierType(Quantifier.QuantifierType.EVERY);
      return q;
    }

    // all the numeric types
    if (qc.quantNumeric() != null) {
      q.setQuantifierType(Quantifier.QuantifierType.NUMERIC);

      Integer num = OWLUtils.convertNumber(qc.quantNumeric().CD().getText());

      if (qc.quantNumeric().less() != null) {
        q.setNumericType(Quantifier.NumericQuantifierType.LESS_THAN);
        q.setQuantity(num);
        return q;
      }

      if (qc.quantNumeric().more() != null) {
        q.setNumericType(Quantifier.NumericQuantifierType.MORE_THAN);
        q.setQuantity(num);
        return q;
      }

      if (qc.quantNumeric().exact() != null) {
        q.setNumericType(Quantifier.NumericQuantifierType.EXACT);
        q.setQuantity(num);
        return q;
      }

      if (qc.quantNumeric().moreOrEqual() != null) {
        q.setNumericType(Quantifier.NumericQuantifierType.MORE_THAN_OR_EQUAL);
        q.setQuantity(num);
        return q;
      }

      if (qc.quantNumeric().lessOrEqual() != null) {
        q.setNumericType(Quantifier.NumericQuantifierType.LESS_THAN_OR_EQUAL);
        q.setQuantity(num);
        return q;
      }

      // no numeric type specified, use exact
      q.setNumericType(Quantifier.NumericQuantifierType.EXACT);
      q.setQuantity(num);
      return q;

    }

    return q;
  }

  // convert a sequence of modifiers and a Proper noun to a single Proper
  private Proper convertnProperSequence(NProperSequenceContext ctx) {

    // concat all the node texts into single underbar delimited string
    StringBuffer merged = new StringBuffer();

    for (ParseTree child : ctx.children) {
      merged.append("_");
      merged.append(child.getText());
    }

    String mergedString = merged.toString().replaceFirst("^_", "");
    return new Proper(mergedString, "NP", vocab, false);
  }

  // convert NP (a sequence of nbars)
  private ObjectPhrase convertNp(NpContext ctx) {

    // just one
    if (ctx.nbar().size() == 1) {
      return convertNbar(ctx.nbar(0));
    }

    // more than one -> phrase set
    PhraseSet pSet = new PhraseSet();
    pSet.getQuantifier().setQuantifierType(QuantifierType.A);

    // loop over nbars
    for (NbarContext nb : ctx.nbar()) {
      pSet.addPhrase(convertNbar(nb));
    }

    // if conjunction
    if (ctx.AND() != null && !ctx.AND().isEmpty()) {
      pSet.setIntersection(true);
      return pSet;
    }

    // if disjunction
    if (ctx.OR() != null && !ctx.OR().isEmpty()) {
      pSet.setIntersection(false);
      return pSet;
    }

    LOGGER.error("Expected noun phrase or proper, Didn't get anything");
    return pSet;

  }

  private ObjectPhrase convertNbar(NbarContext ctx) {

    // if common
    if (ctx.nbarCommon() != null) {
      return convertNbarCommon(ctx.nbarCommon());
    }

    // if proper
    if (ctx.nbarProper() != null) {
      return convertNbarProper(ctx.nbarProper());
    }

    LOGGER.error("Expected noun phrase or proper, Didn't get anything");
    return null;
  }

  private Noun convertNSimple(NSimpleContext ctx) {

    Noun head = null;

    // either NN or NNS
    if (ctx.NN() != null) {
      head = convertTerminalToNoun(ctx.NN(), PhraseType.NOUN);
    }

    if (ctx.NNS() != null) {
      head = convertTerminalToNoun(ctx.NNS(), PhraseType.NOUN);
    }

    if (head == null) {
      LOGGER.error("Expected a NOUN, didn't get anything for " + text(ctx));
    }

    return head;
  }

  // convert some form of "thing" phrase
  // includes setting the quantifier
  private Noun convertNThing(NThingContext ctx) {

    Thing thing = new Thing();

    // nothing
    if (ctx.NOX() != null) {
      thing.getQuantifier().setQuantifierType(Quantifier.QuantifierType.EVERY);
      thing.getQuantifier().setNegative(true);
    }

    // anything
    if (ctx.ANYX() != null) {
      thing.getQuantifier().setQuantifierType(Quantifier.QuantifierType.EVERY);

    }

    // everything
    if (ctx.EVERYX() != null) {
      thing.getQuantifier().setQuantifierType(Quantifier.QuantifierType.EVERY);
    }

    // thing/things
    if (ctx.THING() != null) {
      thing.getQuantifier().setQuantifierType(Quantifier.QuantifierType.A);

    }

    // something
    if (ctx.SOMEX() != null) {
      thing.getQuantifier().setQuantifierType(Quantifier.QuantifierType.SOME);
    }
    return thing;
  }

  // proper noun phrase -> Proper
  private Proper convertNbarProper(NbarProperContext ctx) {

    Proper proper = convertnProperSequence(ctx.nProperSequence());

    Quantifier q = new Quantifier();
    // propers always have quantifier "THE"
    q.setQuantifierType(QuantifierType.THE);

    if (ctx.quantNeg() != null) {
      q.setNegative(true);
    }
    proper.setQuantifier(q);

    return proper;

  }

  // verb phrase -> PredicatePhrase

  private PredicatePhrase convertVbar(VbarContext ctx) {

    if (ctx.vbarAdj() != null) {
      return convertVbarAdj(ctx.vbarAdj());
    }

    if (ctx.vbarSimple() != null) {
      return convertVbarSimple(ctx.vbarSimple());
    }

    if (ctx.vbarPassive() != null) {
      return convertVbarPassive(ctx.vbarPassive());
    }

    LOGGER.error(
        "Expected some sort of vbar. Didn't get anything for " + text(ctx));

    return null;
  }

  // vbar adjectives have implicit "Thing" object
  private PredicatePhrase convertVbarAdj(VbarAdjContext ctx) {

    PredicatePhrase predPhrase = new PredicatePhrase();
    // create and set predicate
    Predicate pred = new Predicate();
    pred.setType(PredicateType.IS);

    if (ctx.vBE().NOT() != null) {
      pred.setNegative(true);
    }

    predPhrase.setPredicate(pred);

    // create and set object
    NounPhrase obj = new NounPhrase();
    predPhrase.setObject(obj);

    // create and set the implicit "thing" object
    Thing thing = new Thing();
    obj.setHead(thing);

    obj.getQuantifier().setQuantifierType(Quantifier.QuantifierType.A);

    // a predicate adjective must always have adjectives
    if (ctx.adjp() != null) {
      obj.setModifiers(convertAdjp(ctx.adjp()));
    } else {
      LOGGER
          .error("Didnt get any adjective phrase in a predicate adjective for "
              + text(ctx));
      return predPhrase;
    }

    return predPhrase;
  }

  private PredicatePhrase convertVbarPassive(VbarPassiveContext ctx) {

    PredicatePhrase predPhrase = new PredicatePhrase();

    predPhrase.setObject(convertNp(ctx.np()));
    predPhrase.setPredicate(convertVPassive(ctx.vPassive()));

    return predPhrase;
  }

  private PredicatePhrase convertVbarSimple(VbarSimpleContext ctx) {
    PredicatePhrase predPhrase = new PredicatePhrase();

    predPhrase.setPredicate(convertV(ctx.v()));
    predPhrase.setObject(convertNp(ctx.np()));

    return predPhrase;
  }

  // convert all flavors of verb
  private Predicate convertV(VContext ctx) {

    Predicate pred = new Predicate();

    if (ctx.vSimple() != null) {
      pred = convertVSimple(ctx.vSimple());
    }

    if (ctx.vParticle() != null) {
      pred = convertVParticle(ctx.vParticle());
    }

    if (ctx.vBE() != null) {
      pred = convertVBE(ctx.vBE());
    }

    if (ctx.vDO() != null) {
      pred = convertVDO(ctx.vDO());
    }

    if (ctx.vHAS() != null) {
      pred = convertVHAS(ctx.vHAS());
    }

    if (ctx.vSameAs() != null) {
      pred = convertVSameAs(ctx.vSameAs());
    }

    // ignore any modals except NOT
    if (ctx.modal() != null) {
      LOGGER
          .warn("Modal auxilaries except NOT ignored in " + text(ctx.modal()));
      ModalContext mod = ctx.modal();
      // see if there is a NOT mixed in with the modals
      if (mod.NOT() != null && !mod.NOT().isEmpty()) {

        if (pred.isNegative()) {
          LOGGER.info("Double negative in " + text(ctx));
        }
        pred.setNegative(true);
      }

    }

    return pred;
  }

  private Predicate convertVSameAs(VSameAsContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.IS_SAME_AS);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    Verb same = convertTerminalToVerb(ctx.SAMEAS());
    p.setVerb(same);

    return p;
  }

  private Predicate convertVHAS(VHASContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.VERB);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    Verb has = convertPreTerminal(ctx.verbHAS());
    p.setVerb(has);

    return p;
  }

  private Predicate convertVDO(VDOContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.VERB);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    Verb does = convertPreTerminal(ctx.verbDO());
    p.setVerb(does);

    return p;
  }

  private Predicate convertVBE(VBEContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.IS);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    Verb be = convertPreTerminal(ctx.verbBE());
    p.setVerb(be);

    return p;
  }

  // combo of a verb and a prep treated as a single verb
  private Predicate convertVParticle(VParticleContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.VERB);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    // get the base verb
    Verb vrb = convertPreTerminal(ctx.verb());

    // set the preposition/particle
    if (ctx.IN() != null) {
      vrb.setParticle(ctx.IN().getText());
    }
    if (ctx.RP() != null) {
      vrb.setParticle(ctx.RP().getText());
    }

    // get the modal context from the parent V
    VContext parent = (VContext) ctx.getParent();

    if (parent.modal() != null) {

      ModalContext mod = parent.modal();

      if (mod.verbBE() != null && !mod.verbBE().isEmpty()) {
        vrb.setAuxiliary("is");
      }

      /*
       * if (mod.verbDO() != null && !mod.verbDO().isEmpty()) { aux = "does_"; }
       */

      if (mod.verbHAS() != null && !mod.verbHAS().isEmpty()) {
        vrb.setAuxiliary("has");
      }

    }

    p.setVerb(vrb);

    return p;
  }

  // passive verb
  private Predicate convertVPassive(VPassiveContext ctx) {

    Predicate p = new Predicate();
    p.setType(PredicateType.VERB);

    // set passive
    p.setPassive(true);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    Verb verb = convertTerminalToVerb(ctx.VBN());
    p.setVerb(verb);

    // get the preposition/particle
    if (ctx.IN() != null) {
      verb.setParticle(ctx.IN().getText());
    }
    if (ctx.RP() != null) {
      verb.setParticle(ctx.RP().getText());
    }

    if (ctx.modal() != null) {
      LOGGER
          .warn("Modal auxilaries except NOT ignored in " + text(ctx.modal()));
      ModalContext mod = ctx.modal();
      // see if there is a NOT mixed in with the modals
      if (mod.NOT() != null && !mod.NOT().isEmpty()) {

        if (p.isNegative()) {
          LOGGER.info("Double negative in " + text(ctx));
        }
        p.setNegative(true);
      }

    }

    return p;
  }

  // vp is just a vbar
  private PredicatePhrase convertVp(VpContext ctx) {
    return convertVbar(ctx.vbar());
  }

  private Predicate convertVSimple(VSimpleContext ctx) {

    Verb v = convertPreTerminal(ctx.verb());

    Predicate p = new Predicate();
    p.setVerb(v);
    p.setType(PredicateType.VERB);

    if (ctx.NOT() != null) {
      p.setNegative(true);
    }

    if (ctx.ONLY() != null && !ctx.ONLY().isEmpty()) {
      p.setExclusive(true);
    }

    return p;
  }

  private Noun convertTerminalToNoun(TerminalNode token, PhraseType type) {

    Token t = token.getSymbol();
    String text = t.getText();
    String tname = HOWL.VOCABULARY.getDisplayName(t.getType());

    Noun wrd = new Noun(text, tname, vocab, true);

    if (type == PhraseType.NOUN) {
      wrd = new Noun(text, tname, vocab, true);
      return wrd;
    }

    if (type == PhraseType.MASSNOUN) {
      wrd = new MassNoun(text, tname, vocab, true);
      return wrd;
    }

    if (type == PhraseType.ADJECTIVE) {
      wrd = new Adjective(text, tname, vocab, true);
      return wrd;
    }

    if (type == PhraseType.PROPER) {
      wrd = new Proper(text, tname, vocab, false);
    }

    if (type == PhraseType.THING) {
      wrd = new Thing();
    }

    if (type == PhraseType.WHAT) {
      wrd = new What(text, tname);
    }

    return wrd;

  }

  private Verb convertTerminalToVerb(TerminalNode token) {
    Token t = token.getSymbol();
    String text = t.getText();
    String tname = HOWL.VOCABULARY.getDisplayName(t.getType());

    return new Verb(text, tname, vocab);
  }

  private Verb convertPreTerminal(ParserRuleContext preToken) {
    if (preToken.getChildCount() > 1) {
      LOGGER.warn("Not a PreTerminal:" + text(preToken) + " using first child");
    }

    if (preToken.getChildCount() == 0) {
      LOGGER.warn("No Children on a PreTerminal, returning blank");
    }

    if (preToken.getChild(0) instanceof TerminalNode) {
      TerminalNode token = (TerminalNode) preToken.getChild(0);
      return convertTerminalToVerb(token);
    } else {
      Verb wrd = new Verb("", "V", vocab);
      return wrd;
    }

  }

  // for debugging, just run through lexer
  public List<Word> speechTagDocument(String content, String voc) {

    ANTLRInputStream input = new ANTLRInputStream(content);

    // set input on lexer
    lexer.setInput(input);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    tokens.fill();

    List<Word> wrds = new ArrayList<Word>();
    // write part of speech tag sequence
    for (Token tok : tokens.getTokens()) {
      // get text
      String txt = tok.getText();
      // get token type (int), translate to label via Vocabulary
      if (tok.getType() > 0) {
        String tname = HOWL.VOCABULARY.getDisplayName(tok.getType());
        Word wrd = new Word(txt, tname, voc, true);
        wrds.add(wrd);
      }
    }

    return wrds;
  }

  // utility to get the text of a multi token phrase
  private String text(RuleContext ctx) {
    if (ctx.getChildCount() == 0) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < ctx.getChildCount(); i++) {
      builder.append(ctx.getChild(i).getText());
      builder.append(" ");
    }

    return builder.toString();
  }
}
