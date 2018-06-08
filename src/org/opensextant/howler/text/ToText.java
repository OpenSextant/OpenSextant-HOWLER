package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Phrase;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.CategoryPhrase;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.phrases.InstancePhrase;
import org.opensextant.howler.abstraction.phrases.PhraseSet;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.QuantifierExpression;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.phrases.WordPhrase;
import org.opensextant.howler.abstraction.statements.DeclarationStatement;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PhraseSequence;
import org.opensextant.howler.abstraction.statements.PredicateCharacteristicStatement;
import org.opensextant.howler.abstraction.statements.PredicateRelationStatement;
import org.opensextant.howler.abstraction.statements.WordSequence;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.Negative;
import org.opensextant.howler.abstraction.words.enumerated.PassiveMarker;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.RelativeMarker;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.text.Sentence.SentenceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class ToText {
  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(ToText.class);

  public TextDocument convert(Document doc) {

    TextDocument textDoc = new TextDocument();

    if (doc.getDocumentID().isPresent()) {
      textDoc.setId(doc.getDocumentID().get());
    }

    textDoc.setShortName(doc.getShortname());

    // convert the statements
    for (Statement statement : doc.getStatements()) {
      Sentence sentence = convert(statement);
      if (sentence != null) {
        sentence.setParseTree(statement.getSource());
        sentence.addWord(Vocabulary.PERIOD);
        textDoc.addSentence(sentence);
      } else {
        LOGGER.error("Null sentence converted from statement:" + statement);
      }

    }

    return textDoc;
  }

  public Sentence convert(Statement st) {

    if (st instanceof DescriptionStatement) {
      return convert((DescriptionStatement) st);
    }

    if (st instanceof FactStatement) {
      return convert((FactStatement) st);
    }

    if (st instanceof PredicateRelationStatement) {
      return convert((PredicateRelationStatement) st);
    }

    if (st instanceof PredicateCharacteristicStatement) {
      return convert((PredicateCharacteristicStatement) st);
    }

    if (st instanceof DeclarationStatement) {
      return convert((DeclarationStatement) st);
    }

    if (st instanceof WordSequence) {
      return convert((WordSequence) st);
    }

    if (st instanceof PhraseSequence) {
      return convert((PhraseSequence) st);
    }

    return null;
  }

  private Sentence convert(DescriptionStatement st) {

    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.DESCRIPTION);

    SubjectObjectPhrase subj = st.getSubject();
    PredicateExpression pExp = st.getPredicatePhrase().getPredicateExpression();
    SubjectObjectPhrase obj = st.getPredicatePhrase().getObject();

    if (st.isDomain()) {
      if (st.isAnnotationStatement()) {
        sent.addWord(Vocabulary.ANNO_FLAG);
      }
      sent.addWords(convert(subj));
      sent.addWords(convert(pExp));
      sent.addWord(Quantifier.SOME);

      if (pExp.isDataExpression()) {
        sent.addWord(Vocabulary.DATAVALUE);
      } else {
        sent.addWord(Vocabulary.THING);
      }

    }

    if (st.isRange()) {
      if (st.isAnnotationStatement()) {
        sent.addWord(Vocabulary.ANNO_FLAG);
      }
      sent.addWords(convert(subj));
      sent.addWords(convert(pExp));
      sent.addWords(convert(obj));
    }

    if (!st.isDomain() && !st.isRange()) {

      if (st.isAnnotationStatement()) {
        return convertAnno(st);
      }
      sent.addWords(convert(subj));
      sent.addWords(convert(st.getPredicatePhrase()));
    }

    for (Footnote fn : st.getFootnotes()) {
      sent.addFootnote(convert(fn));
    }

    return sent;
  }

  private Sentence convertAnno(DescriptionStatement st) {

    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.DESCRIPTION);

    SubjectObjectPhrase subj = st.getSubject();
    PredicateExpression pExp = st.getPredicatePhrase().getPredicateExpression();
    SubjectObjectPhrase obj = st.getPredicatePhrase().getObject();

    sent.addWord(Vocabulary.ANNO_FLAG);
    sent.addWords(convert(subj));
    sent.addWord(Vocabulary.ANNO_SPLIT);
    sent.addWords(convert(pExp));
    sent.addWord(Vocabulary.ANNO_SPLIT);
    sent.addWords(convert(obj));

    for (Footnote fn : st.getFootnotes()) {
      sent.addFootnote(convert(fn));
    }

    return sent;
  }

  private Sentence convert(FactStatement st) {

    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.FACT);

    sent.addWords(convert(st.getSubject()));
    if (st.isInstanceObject()) {
      sent.addWords(convert(st.getInstancePredicatePhrase()));
    } else {
      sent.addWords(convert(st.getSubjectObjectPredicatePhrase()));
    }

    for (Footnote fn : st.getFootnotes()) {
      sent.addFootnote(convert(fn));
    }

    return sent;
  }
  private Sentence convert(PredicateRelationStatement st) {

    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.PREDICATE_RELATION);

    PredicateExpression subjExp = st.getSubject();
    PredicateExpression objExp = st.getObject();

    WordType wt = subjExp.getPredicate().getWordType();
    WordType owt = objExp.getPredicate().getWordType();

    if (!wt.equals(owt)) {
      LOGGER.warn("Predicate types do not match in Predicate Relation statement:" + st);
    }

    sent.addWord(Quantifier.THE);
    sent.addWords(convert(st.getSubject()));
    sent.addWord(wt);
    sent.addWords(convert(st.getRelationType(), st.isNegative(), st.isInverse(), wt));
    sent.addWord(Quantifier.THE);
    sent.addWords(convert(st.getObject()));
    sent.addWord(wt);

    for (Footnote fn : st.getFootnotes()) {
      sent.addFootnote(convert(fn));
    }

    return sent;

  }

  private Sentence convert(PredicateCharacteristicStatement st) {

    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.PREDICATE_CHARACTERISTIC);

    PredicateExpression pred = st.getSubject();
    WordType wt = WordType.OBJECT_PREDICATE;

    if (pred.isObjectExpression()) {
      wt = WordType.OBJECT_PREDICATE;
    }

    if (pred.isDataExpression()) {
      wt = WordType.DATA_PREDICATE;
    }

    if (pred.isAnnotationExpression()) {
      wt = WordType.ANNOTATION_PREDICATE;
    }

    sent.addWord(Quantifier.THE);
    sent.addWords(convert(st.getSubject()));
    sent.addWord(wt);
    sent.addWord(Vocabulary.IS_AUX);
    sent.addWord(st.getCharacteristic());

    for (Footnote fn : st.getFootnotes()) {
      sent.addFootnote(convert(fn));
    }

    return sent;

  }

  private Sentence convert(DeclarationStatement st) {
    Sentence sent = new Sentence();
    sent.setSentenceType(SentenceType.DECLARATION);

    Word subjWord = st.getWord();

    sent.addWord(subjWord);
    sent.addWord(Vocabulary.IS_AUX);
    sent.addWord(Quantifier.A);
    sent.addWord(subjWord.getWordType());
    return sent;

  }

  private Sentence convert(WordSequence st) {
    Sentence sent = new Sentence();
    sent.addWords(st.getWords());
    return sent;
  }
  private Sentence convert(PhraseSequence st) {
    Sentence sent = new Sentence();

    for (Phrase ph : st.getPhrases()) {
      sent.addWords(ph.getWords());
    }

    return sent;
  }

  private List<Word> convert(Phrase ph) {

    if (ph instanceof CategoryPhrase) {
      return convert((CategoryPhrase) ph);
    }

    if (ph instanceof InstancePhrase) {
      return convert((InstancePhrase) ph);
    }

    if (ph instanceof PhraseSet) {
      return convert((PhraseSet) ph);
    }

    if (ph instanceof WordPhrase) {
      return convert((WordPhrase) ph);
    }

    if (ph instanceof PredicatePhrase) {
      return convert((PredicatePhrase) ph);
    }

    return null;
  }

  private List<Word> convert(CategoryPhrase<?> ph) {
    List<Word> wrds = new ArrayList<Word>();

    wrds.addAll(convert(ph.getQuantifierExpression()));
    wrds.addAll(ph.getModifiers());
    wrds.add(ph.getHead());

    List<PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate>> relPhrases = ph.getRelativePhrases();

    if (!relPhrases.isEmpty()) {
      wrds.add(RelativeMarker.THAT);
      wrds.addAll(convert(relPhrases.get(0)));
      for (int i = 1; i < relPhrases.size(); i++) {
        wrds.add(BooleanSetType.AND);
        wrds.add(RelativeMarker.THAT);
        wrds.addAll(convert(relPhrases.get(i)));
      }

    }

    return wrds;
  }

  private List<Word> convert(InstancePhrase<?> ph) {
    List<Word> wrds = new ArrayList<Word>();

    if (ph.isNegative()) {
      wrds.add(Negative.NOT);
    }

    wrds.add(ph.getHead());
    return wrds;
  }
  private List<Word> convert(PhraseSet<?> ph) {

    List<Word> wrds = new ArrayList<Word>();
    List<? extends SubjectObjectPhrase> phrases = ph.getPhrases();

    // push negatives and quantifiers to the objects
    ph.pushQuantifier();

    if (!phrases.isEmpty()) {

      if (ph.isDisjoint()) {
        wrds.add(Vocabulary.EITHER);
      }

      // add first phrase
      wrds.addAll(convert(phrases.get(0)));

      for (int i = 1; i < phrases.size(); i++) {
        wrds.add(ph.getSetType());
        wrds.addAll(convert(phrases.get(i)));
      }
    }

    return wrds;
  }

  private List<Word> convert(WordPhrase ph) {
    List<Word> wrds = new ArrayList<Word>();
    wrds.addAll(convert(ph.getQuantifierExpression()));
    wrds.add(ph.getHead());
    return wrds;
  }

  private List<Word> convert(PredicatePhrase ph) {
    List<Word> wrds = new ArrayList<Word>();

    PredicateExpression pe = ph.getPredicateExpression();

    SubjectObjectPhrase obj = ph.getObject();

    obj.pushQuantifier();

    wrds.addAll(convert(pe));
    wrds.addAll(convert(obj));

    return wrds;
  }

  private List<Word> convert(QuantifierExpression qe) {
    List<Word> wrds = new ArrayList<Word>();

    if (qe.isNegative()) {
      wrds.add(Negative.NOT);
    }

    Quantifier q = qe.getQuantifierType();

    wrds.add(q);

    if (q.isNumeric()) {
      wrds.add(new GenericWord(qe.getQuantity().toString(), "CD"));
    }

    return wrds;
  }

  private List<Word> convert(PredicateExpression ph) {
    List<Word> wrds = new ArrayList<Word>();

    Predicate pred = ph.getPredicate();
    PredicateType predType = pred.getPredicateType();

    if (predType.equals(PredicateType.IS)) {

      wrds.add(pred);
      if (ph.isNegative()) {
        wrds.add(Negative.NOT);
      }

      if (ph.isInverse()) {
        wrds.add(Vocabulary.INVERSE_OF);
      }

      return wrds;
    }

    if (predType.equals(PredicateType.SAME_AS)) {

      if (ph.isNegative()) {
        wrds.add(Vocabulary.IS_AUX);
        wrds.add(Negative.NOT);
        return wrds;
      }

      wrds.add(Vocabulary.IS_AUX);
      if (ph.isInverse()) {
        wrds.add(pred);
        wrds.add(Vocabulary.INVERSE_OF);
      } else {
        wrds.add(pred);
      }
      return wrds;
    }

    if (predType.equals(PredicateType.FACET)) {
      wrds.add(Vocabulary.IS_AUX);
      if (ph.isNegative()) {
        wrds.add(Negative.NOT);
      }
      wrds.add(pred);
      return wrds;

    }

    if (pred.getNormalForm().startsWith("is ")) {

    }

    if (ph.isInverse() && !pred.getNormalForm().startsWith("is ") && !pred.getNormalForm().startsWith("has ")) {
      wrds.add(Vocabulary.IS_AUX);
    }

    if (ph.isNegative()) {
      wrds.add(Vocabulary.DOES_AUX);
      wrds.add(Negative.NOT);
    }
    wrds.add(pred);

    if (ph.isInverse()) {
      wrds.add(PassiveMarker.BY);
    }

    return wrds;
  }

  private TextFootnote convert(Footnote ph) {

    TextFootnote tfn = new TextFootnote();

    tfn.setNoteType(ph.getPredicate());
    tfn.setContent(ph.getWord());

    return tfn;
  }

  private List<Word> convert(PredicateType type, boolean negative, boolean inverse, WordType wt) {

    List<Word> wrds = new ArrayList<Word>();

    if (type.equals(PredicateType.IS)) {

      if (wt.equals(WordType.DATA_PREDICATE)) {
        wrds.add(Vocabulary.IS_Data);
      }
      if (wt.equals(WordType.OBJECT_PREDICATE)) {
        wrds.add(Vocabulary.IS_Object);
      }
      if (wt.equals(WordType.ANNOTATION_PREDICATE)) {
        wrds.add(Vocabulary.IS_Annotation);
      }

      if (negative) {
        wrds.add(Negative.NOT);
      }

      if (inverse) {
        wrds.add(Vocabulary.INVERSE_OF);
      }

    }
    if (type.equals(PredicateType.SAME_AS)) {

      wrds.add(Vocabulary.IS_AUX);

      if (negative) {
        wrds.add(Negative.NOT);
      }

      if (wt.equals(WordType.DATA_PREDICATE)) {
        wrds.add(Vocabulary.SAME_Data);
      }
      if (wt.equals(WordType.OBJECT_PREDICATE)) {
        wrds.add(Vocabulary.SAME_Object);
      }
      if (wt.equals(WordType.ANNOTATION_PREDICATE)) {
        wrds.add(Vocabulary.SAME_Annotation);
      }

      if (inverse) {
        wrds.add(Vocabulary.INVERSE_OF);
      }

    }

    return wrds;

  }

}
