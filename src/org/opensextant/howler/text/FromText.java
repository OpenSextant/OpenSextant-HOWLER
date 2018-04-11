package org.opensextant.howler.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.io.FileUtils;
import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.abstraction.phrases.CategoryPhrase;
import org.opensextant.howler.abstraction.phrases.InstancePhrase;
import org.opensextant.howler.abstraction.phrases.PhraseSet;
import org.opensextant.howler.abstraction.phrases.PredicateExpression;
import org.opensextant.howler.abstraction.phrases.PredicatePhrase;
import org.opensextant.howler.abstraction.phrases.QuantifierExpression;
import org.opensextant.howler.abstraction.phrases.SubjectObjectPhrase;
import org.opensextant.howler.abstraction.phrases.WordPhrase;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PredicateRelationStatement;
import org.opensextant.howler.abstraction.statements.WordSequence;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Noun;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.text.grammar.HOWL;
import org.opensextant.howler.text.grammar.HOWL.AdjpContext;
import org.opensextant.howler.text.grammar.HOWL.AnnotationStatementContext;
import org.opensextant.howler.text.grammar.HOWL.AnnotationWordContext;
import org.opensextant.howler.text.grammar.HOWL.BadSentenceContext;
import org.opensextant.howler.text.grammar.HOWL.CatchAllContext;
import org.opensextant.howler.text.grammar.HOWL.CatchSetContext;
import org.opensextant.howler.text.grammar.HOWL.CommonNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DataPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DataTypePhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DataTypeRestrictionContext;
import org.opensextant.howler.text.grammar.HOWL.DataTypeSetContext;
import org.opensextant.howler.text.grammar.HOWL.DataValueContext;
import org.opensextant.howler.text.grammar.HOWL.DataValuePhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DebugContext;
import org.opensextant.howler.text.grammar.HOWL.DescriptionStatementDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.DescriptionStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.DocumentContext;
import org.opensextant.howler.text.grammar.HOWL.FacetContext;
import org.opensextant.howler.text.grammar.HOWL.FactStatementDataContext;
import org.opensextant.howler.text.grammar.HOWL.FactStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.NProperSequenceContext;
import org.opensextant.howler.text.grammar.HOWL.NounOrProperNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.NounPhraseSubjectContext;
import org.opensextant.howler.text.grammar.HOWL.NounSetContext;
import org.opensextant.howler.text.grammar.HOWL.OneOfDataContext;
import org.opensextant.howler.text.grammar.HOWL.OneOfProperNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateCharacteristicStatementAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateCharacteristicStatementDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateCharacteristicStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionBEContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionDOContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionHASContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionHAS_POSSContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionObjectContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionParticleContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionPassiveContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionSameAsContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionSimpleContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionStateContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbObjectContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseCommonNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseCommonNounOrSetContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataSetContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataValueContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataValueSetContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseItselfContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseMixedContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseNounSetContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseProperNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseProperNounSetContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateRelationStatementAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateRelationStatementDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateRelationStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.ProperNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.QuantContext;
import org.opensextant.howler.text.grammar.HOWL.QuantNumericContext;
import org.opensextant.howler.text.grammar.HOWL.StatementContext;
import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@SuppressWarnings({"unchecked"})
public class FromText {

  private static final Logger LOGGER = LoggerFactory.getLogger(FromText.class);
  HowlerLexer lexer;

  WordManager wordManager = WordManager.getWordManager();
  private IRI currentNamespace = IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument");

  private Map<String, WordType> wordTypeMap = new HashMap<String, WordType>();

  public FromText(File lexiconFile, File ngramFile, File typeInfoFile, File phraseFile, File wordTypes) {
    lexer = new HowlerLexer(lexiconFile, ngramFile, typeInfoFile, phraseFile);
    initWordTypeMap(wordTypes);
  }

  private void initWordTypeMap(File wordTypes) {

    try {
      List<String> lines = FileUtils.readLines(wordTypes);

      for (String line : lines) {
        if (line.startsWith("#")) {
          continue;
        }

        // Token Type Name \t WordType
        String[] pieces = line.split("\t");

        String tokenTypeName = pieces[0];
        String wordTypeName = pieces[1];
        WordType wt = WordType.valueOf(wordTypeName);

        wordTypeMap.put(tokenTypeName, wt);
      }

    } catch (IOException e) {
      LOGGER.error("Could not read word type mapping from file:" + wordTypes);
    }

  }

  public IRI getCurrentNamespace() {
    return currentNamespace;
  }

  public void setCurrentNamespace(IRI currentNamespace) {
    this.currentNamespace = currentNamespace;
  }

  public Document convertText(TextDocument doc) {

    IRI id = doc.getId();
    String shortname = doc.getShortName();

    StringBuilder textBldr = new StringBuilder();
    for (Sentence sent : doc.getSentences()) {
      textBldr.append(sent.getContents());
      textBldr.append("\n");
    }

    return convertText(textBldr.toString(), id, shortname);
  }

  public Document convertText(String text, IRI documentID, String shortname) {

    // set stream input on lexer
    lexer.setInput(text);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // now parse the tokens
    HOWL parser = new HOWL(tokens);

    Document converted = convertText(parser.document());
    converted.setDocumentID(documentID);
    converted.setShortname(shortname);

    return converted;
  }

  private Document convertText(DocumentContext ctx) {
    Document doc = new Document();

    for (StatementContext state : ctx.statement()) {

      if (state.predicateCharacteristicStatementObject() != null) {
        Predicate pred = convertText(state.predicateCharacteristicStatementObject());
        doc.addVocabulary(pred);
        continue;
      }

      if (state.predicateCharacteristicStatementData() != null) {
        Predicate pred = convertText(state.predicateCharacteristicStatementData());
        doc.addVocabulary(pred);
        continue;
      }

      if (state.predicateCharacteristicStatementAnnotation() != null) {
        Predicate pred = convertText(state.predicateCharacteristicStatementAnnotation());
        doc.addVocabulary(pred);
        continue;
      }

      doc.addStatement(convertText(state));
    }

    for (DebugContext debug : ctx.debug()) {
      doc.addStatement(convertText(debug));
    }

    return doc;
  }

  private Statement convertText(StatementContext ctx) {

    if (ctx.annotationStatement() != null) {
      return convertText(ctx.annotationStatement());
    }

    if (ctx.descriptionStatementDataType() != null) {
      return convertText(ctx.descriptionStatementDataType());
    }

    if (ctx.descriptionStatementObject() != null) {
      return convertText(ctx.descriptionStatementObject());
    }

    if (ctx.factStatementObject() != null) {
      return convertText(ctx.factStatementObject());
    }

    if (ctx.factStatementData() != null) {
      return convertText(ctx.factStatementData());
    }

    if (ctx.predicateRelationStatementObject() != null) {
      return convertText(ctx.predicateRelationStatementObject());
    }

    if (ctx.predicateRelationStatementData() != null) {
      return convertText(ctx.predicateRelationStatementData());
    }

    if (ctx.predicateRelationStatementAnnotation() != null) {
      return convertText(ctx.predicateRelationStatementAnnotation());
    }

    return null;
  }

  private DescriptionStatement<ObjectPredicate> convertText(DescriptionStatementObjectContext ctx) {
    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();

    SubjectObjectPhrase subj = convertText(ctx.nounPhraseSubject());
    statement.setSubject(subj);
    // TODO cast?
    PredicatePhrase<? extends SubjectObjectPhrase, ObjectPredicate> tmp = convertText(ctx.predicatePhraseNoun());
    PredicateExpression<ObjectPredicate> pe = tmp.getPredicateExpression();
    SubjectObjectPhrase obj = tmp.getObject();

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private DescriptionStatement<DataPredicate> convertText(DescriptionStatementDataTypeContext ctx) {
    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();

    SubjectObjectPhrase subj = convertText(ctx.nounPhraseSubject());
    statement.setSubject(subj);
    // TODO cast?
    PredicatePhrase<? extends SubjectObjectPhrase, DataPredicate> tmp = convertText(ctx.predicatePhraseData());
    PredicateExpression<DataPredicate> pe = tmp.getPredicateExpression();
    SubjectObjectPhrase obj = tmp.getObject();

    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private FactStatement<ObjectPredicate, ProperNoun> convertText(FactStatementObjectContext ctx) {

    FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();

    InstancePhrase<ProperNoun> subj = convertText(ctx.properNounPhrase());
    statement.setSubject(subj);
    // TODO cast?
    PredicatePhrase<? extends SubjectObjectPhrase, ObjectPredicate> tmp = convertText(
        ctx.predicatePhraseCommonNounOrSet());
    PredicateExpression<ObjectPredicate> pe = tmp.getPredicateExpression();
    SubjectObjectPhrase obj = tmp.getObject();

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);

    statement.setSubjectObjectPredicatePhrase(predPhrase);

    return statement;
  }

  private FactStatement<DataPredicate, DataValue> convertText(FactStatementDataContext ctx) {

    FactStatement<DataPredicate, DataValue> statement = new FactStatement<DataPredicate, DataValue>();

    InstancePhrase<ProperNoun> subj = convertText(ctx.properNounPhrase());
    statement.setSubject(subj);

    PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> predPhrase = convertText(ctx.predicatePhraseDataValue());
    statement.setInstancePredicatePhrase(predPhrase);

    return statement;
  }

  private PredicateRelationStatement<ObjectPredicate> convertText(PredicateRelationStatementObjectContext ctx) {

    PredicateExpression<ObjectPredicate> subjPred = convertText(ctx.subj);
    PredicateExpression<ObjectPredicate> objPred = convertText(ctx.obj);

    ObjectPredicate rel = Vocabulary.IS_Object;
    if (ctx.relIS != null) {
      rel = Vocabulary.IS_Object;
    }

    if (ctx.relSame != null) {
      rel = Vocabulary.SAME_Object;
    }

    PredicateExpression<ObjectPredicate> relPred = new PredicateExpression<ObjectPredicate>(rel);
    relPred.setNegative(ctx.NOT() != null);
    relPred.setPassive(ctx.INVERSE_OF() != null);
    return new PredicateRelationStatement<ObjectPredicate>(subjPred, relPred, objPred);
  }

  private PredicateRelationStatement<DataPredicate> convertText(PredicateRelationStatementDataContext ctx) {

    PredicateExpression<DataPredicate> subjPred = convertText(ctx.subj);
    PredicateExpression<DataPredicate> objPred = convertText(ctx.obj);

    DataPredicate rel = Vocabulary.IS_Data;
    if (ctx.relIS != null) {
      rel = Vocabulary.IS_Data;
    }

    if (ctx.relSame != null) {
      rel = Vocabulary.SAME_Data;
    }

    PredicateExpression<DataPredicate> relPred = new PredicateExpression<DataPredicate>(rel);
    relPred.setNegative(ctx.NOT() != null);
    relPred.setPassive(ctx.INVERSE_OF() != null);
    return new PredicateRelationStatement<DataPredicate>(subjPred, relPred, objPred);
  }

  private PredicateRelationStatement<AnnotationPredicate> convertText(PredicateRelationStatementAnnotationContext ctx) {

    PredicateExpression<AnnotationPredicate> subjPred = convertText(ctx.subj);
    PredicateExpression<AnnotationPredicate> objPred = convertText(ctx.obj);

    AnnotationPredicate rel = Vocabulary.IS_Annotation;
    if (ctx.relIS != null) {
      rel = Vocabulary.IS_Annotation;
    }

    if (ctx.relSame != null) {
      rel = Vocabulary.SAME_Annotation;
    }

    PredicateExpression<AnnotationPredicate> relPred = new PredicateExpression<AnnotationPredicate>(rel);
    relPred.setNegative(ctx.NOT() != null);
    relPred.setPassive(ctx.INVERSE_OF() != null);
    return new PredicateRelationStatement<AnnotationPredicate>(subjPred, relPred, objPred);
  }

  private DescriptionStatement<AnnotationPredicate> convertText(AnnotationStatementContext ctx) {

    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();

    statement.setSubject(convertText(ctx.subj));

    PredicateExpression<AnnotationPredicate> rel = convertText(ctx.rel);

    if (ctx.objWord != null) {
      WordPhrase obj = convertText(ctx.objWord);
      PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predicatePhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
          rel, obj);
      statement.setPredicatePhrase(predicatePhrase);
    }

    if (ctx.objValue != null) {
      DataValue obj = convertWord(ctx.objValue);
      InstancePhrase<DataValue> dv = new InstancePhrase<DataValue>(obj);

      PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predicatePhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
          rel, dv);
      statement.setPredicatePhrase(predicatePhrase);
    }

    return statement;
  }

  private WordSequence convertText(DebugContext ctx) {

    if (ctx.badSentence() != null) {
      return convertText(ctx.badSentence());
    }

    if (ctx.catchSet() != null) {
      return convertText(ctx.catchSet());
    }

    if (ctx.catchAll() != null) {
      return convertText(ctx.catchAll());
    }

    return null;
  }

  private WordSequence convertText(BadSentenceContext ctx) {
    // TODO
    WordSequence seq = new WordSequence();
    return seq;
  }

  private WordSequence convertText(CatchAllContext ctx) {
    // TODO
    WordSequence seq = new WordSequence();
    return seq;
  }

  private WordSequence convertText(CatchSetContext ctx) {
    // TODO
    WordSequence seq = new WordSequence();
    return seq;
  }

  private List<Noun> convertText(AdjpContext ctx) {

    List<Noun> nouns = new ArrayList<Noun>();
    if (ctx != null) {
      for (ParseTree child : ctx.children) {
        if (child instanceof TerminalNode) {
          TerminalNode tNode = (TerminalNode) child;
          // force all to Adjective
          nouns.add(convertWord(tNode, WordType.ADJECTIVE));
        }
      }
    }
    return nouns;
  }

  private CategoryPhrase<Noun> convertText(CommonNounPhraseContext ctx) {

    List<Noun> adjs = convertText(ctx.adjp());

    QuantifierExpression quant = convertText(ctx.quant());
    quant.setNegative(ctx.NOT() != null);

    Noun head;
    CategoryPhrase<Noun> catPhrase = null;
    if (ctx.NOUN() != null) {
      head = convertWord(ctx.NOUN(), WordType.COMMON_NOUN);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.ADJECTIVE() != null) {
      head = convertWord(ctx.ADJECTIVE(), WordType.ADJECTIVE);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.PROPER() != null) {
      // force a proper to an common noun
      head = convertWord(ctx.PROPER(), WordType.COMMON_NOUN);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (catPhrase == null) {
      LOGGER.error("No head in CategoryPhraseNoun" + ctx);
      return null;
    }

    catPhrase.setModifiers(adjs);
    catPhrase.setQuantifier(quant);

    for (PredicatePhraseMixedContext rel : ctx.predicatePhraseMixed()) {
      PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> relPhrase = convertText(rel);
      catPhrase.addRelativePhrase(relPhrase);
    }

    return catPhrase;
  }
  private SubjectObjectPhrase convertText(NounOrProperNounPhraseContext ctx) {

    if (ctx.commonNounPhrase() != null) {
      return convertText(ctx.commonNounPhrase());
    }

    if (ctx.oneOfProperNoun() != null) {
      return convertText(ctx.oneOfProperNoun());
    }

    if (ctx.properNounPhrase() != null) {
      return convertText(ctx.properNounPhrase());
    }

    return null;
  }

  private SubjectObjectPhrase convertText(NounPhraseSubjectContext ctx) {

    if (ctx.nounSet() != null) {
      return convertText(ctx.nounSet());
    }

    if (ctx.commonNounPhrase() != null) {
      return convertText(ctx.commonNounPhrase());
    }

    return null;
  }
  private PhraseSet<SubjectObjectPhrase> convertText(NounSetContext ctx) {

    PhraseSet<SubjectObjectPhrase> phraseSet = new PhraseSet<SubjectObjectPhrase>();

    SubjectObjectPhrase first = convertText(ctx.nounOrProperNounPhrase());
    phraseSet.addPhrase(first);

    for (NounPhraseSubjectContext nxt : ctx.nounPhraseSubject()) {
      phraseSet.addPhrase(convertText(nxt));
    }

    return phraseSet;
  }

  private InstancePhrase<ProperNoun> convertText(ProperNounPhraseContext ctx) {
    return new InstancePhrase<ProperNoun>(convertText(ctx.nProperSequence()));
  }

  private ProperNoun convertText(NProperSequenceContext ctx) {

    StringBuilder properBldr = new StringBuilder();
    for (TerminalNode proper : ctx.PROPER()) {
      properBldr.append(proper.getText());
      properBldr.append(" ");
    }

    String properText = properBldr.toString().trim();

    return convertWord(properText, WordType.PROPER_NOUN);
  }

  private SubjectObjectPhrase convertText(DataPhraseContext ctx) {

    if (ctx.dataTypePhrase() != null) {
      return convertText(ctx.dataTypePhrase());
    }

    if (ctx.dataTypeSet() != null) {
      return convertText(ctx.dataTypeSet());
    }

    if (ctx.oneOfData() != null) {
      return convertText(ctx.oneOfData());
    }

    return null;
  }

  private CategoryPhrase<DataType> convertText(DataTypePhraseContext ctx) {

    DataType head = convertWord(ctx.DATATYPE(), WordType.DATATYPE);

    CategoryPhrase<DataType> catPhrase = new CategoryPhrase<DataType>(head);
    catPhrase.getQuantifier().setQuantifierType(Quantifier.A);
    catPhrase.getQuantifier().setNegative(ctx.NOT() != null);

    for (DataTypeRestrictionContext restrict : ctx.dataTypeRestriction()) {
      catPhrase.addRelativePhrase(convertText(restrict));
    }

    return catPhrase;
  }

  private PhraseSet<SubjectObjectPhrase> convertText(DataTypeSetContext ctx) {
    PhraseSet<SubjectObjectPhrase> phraseSet = new PhraseSet<SubjectObjectPhrase>();

    SubjectObjectPhrase first = convertText(ctx.dataTypePhrase());
    phraseSet.addPhrase(first);

    for (DataPhraseContext nxt : ctx.dataPhrase()) {
      phraseSet.addPhrase(convertText(nxt));
    }

    return phraseSet;
  }

  private InstancePhrase<DataValue> convertText(DataValuePhraseContext ctx) {
    DataValue dv = convertWord(ctx.dataValue());
    InstancePhrase<DataValue> ip = new InstancePhrase<DataValue>(dv);
    return ip;
  }

  private QuantifierExpression convertText(QuantContext ctx) {

    Quantifier qtype = Quantifier.NULL;
    QuantifierExpression qe = new QuantifierExpression(qtype);

    if (ctx != null) {

      if (ctx.NO() != null) {
        qtype = Quantifier.NO;
      }

      if (ctx.EVERY() != null) {
        qtype = Quantifier.EVERY;
      }

      if (ctx.SOME() != null) {
        qtype = Quantifier.SOME;
      }

      if (ctx.A() != null) {
        qtype = Quantifier.A;
      }

      if (ctx.THE() != null) {
        qtype = Quantifier.THE;
      }

      qe = new QuantifierExpression(qtype);

      if (ctx.quantNumeric() != null) {
        qe = convertText(ctx.quantNumeric());
      }

    }

    return qe;
  }

  private QuantifierExpression convertText(QuantNumericContext ctx) {

    Quantifier qtype = Quantifier.EXACT;

    if (ctx.EXACT() != null) {
      qtype = Quantifier.EXACT;
    }

    if (ctx.LESS_THAN() != null) {
      qtype = Quantifier.LESS_THAN;
    }

    if (ctx.LESS_THAN_OR_EQUAL() != null) {
      qtype = Quantifier.LESS_THAN_OR_EQUAL;
    }

    if (ctx.MORE_THAN() != null) {
      qtype = Quantifier.MORE_THAN;
    }

    if (ctx.MORE_THAN_OR_EQUAL() != null) {
      qtype = Quantifier.MORE_THAN_OR_EQUAL;
    }

    int num = Integer.parseInt(ctx.INTEGER().getText());
    QuantifierExpression qe = new QuantifierExpression(qtype);
    qe.setQuantity(num);

    return qe;
  }

  private PhraseSet<InstancePhrase<DataValue>> convertText(OneOfDataContext ctx) {

    PhraseSet<InstancePhrase<DataValue>> set = new PhraseSet<InstancePhrase<DataValue>>();

    for (DataValueContext dv : ctx.dataValue()) {
      DataValue v = convertWord(dv);
      set.addPhrase(new InstancePhrase<DataValue>(v));
    }

    return set;
  }
  private PhraseSet<InstancePhrase<ProperNoun>> convertText(OneOfProperNounContext ctx) {

    PhraseSet<InstancePhrase<ProperNoun>> set = new PhraseSet<InstancePhrase<ProperNoun>>();

    for (ProperNounPhraseContext proper : ctx.properNounPhrase()) {
      set.addPhrase(convertText(proper));
    }

    return set;
  }

  private ObjectPredicate convertText(PredicateCharacteristicStatementObjectContext ctx) {

    PredicateCharacteristic character = convertWord(ctx.PRED_CHAR(), WordType.PREDICATE_CHARACTERISTIC);

    ObjectPredicate pe = convertText(ctx.predicateExpressionVerbObject()).getPredicate();
    pe.addCharacteristic(character);
    return pe;
  }

  private DataPredicate convertText(PredicateCharacteristicStatementDataContext ctx) {

    PredicateCharacteristic character = convertWord(ctx.PRED_CHAR(), WordType.PREDICATE_CHARACTERISTIC);

    DataPredicate pe = convertText(ctx.predicateExpressionVerbData()).getPredicate();
    pe.addCharacteristic(character);
    return pe;
  }

  private AnnotationPredicate convertText(PredicateCharacteristicStatementAnnotationContext ctx) {

    PredicateCharacteristic character = convertWord(ctx.PRED_CHAR(), WordType.PREDICATE_CHARACTERISTIC);

    AnnotationPredicate pe = convertText(ctx.predicateExpressionVerbAnnotation()).getPredicate();
    pe.addCharacteristic(character);
    return pe;
  }

  private PredicateExpression<ObjectPredicate> convertText(PredicateExpressionObjectContext ctx) {
    return convertText(ctx.predicateExpression(), WordType.OBJECT_PREDICATE);
  }

  private PredicateExpression<DataPredicate> convertText(PredicateExpressionDataContext ctx) {
    return convertText(ctx.predicateExpression(), WordType.DATA_PREDICATE);
  }

  private PredicateExpression<AnnotationPredicate> convertText(PredicateExpressionAnnotationContext ctx) {
    return convertText(ctx.predicateExpression(), WordType.ANNOTATION_PREDICATE);
  }

  private PredicateExpression<ObjectPredicate> convertText(PredicateExpressionVerbObjectContext ctx) {
    return convertText(ctx.predicateExpressionVerb(), WordType.OBJECT_PREDICATE);
  }

  private PredicateExpression<DataPredicate> convertText(PredicateExpressionVerbDataContext ctx) {
    return convertText(ctx.predicateExpressionVerb(), WordType.DATA_PREDICATE);
  }

  private PredicateExpression<AnnotationPredicate> convertText(PredicateExpressionVerbAnnotationContext ctx) {
    return convertText(ctx.predicateExpressionVerb(), WordType.ANNOTATION_PREDICATE);
  }

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionVerbContext ctx,
      WordType predicateType) {

    if (ctx.predicateExpressionDO() != null) {
      return convertText(ctx.predicateExpressionDO(), predicateType);
    }

    if (ctx.predicateExpressionHAS() != null) {
      return convertText(ctx.predicateExpressionHAS(), predicateType);
    }

    if (ctx.predicateExpressionHAS_POSS() != null) {
      return convertText(ctx.predicateExpressionHAS_POSS(), predicateType);
    }

    if (ctx.predicateExpressionNoun() != null) {
      return convertText(ctx.predicateExpressionNoun(), predicateType);
    }

    if (ctx.predicateExpressionParticle() != null) {
      return convertText(ctx.predicateExpressionParticle(), predicateType);
    }

    if (ctx.predicateExpressionPassive() != null) {
      return convertText(ctx.predicateExpressionPassive(), predicateType);
    }

    if (ctx.predicateExpressionSimple() != null) {
      return convertText(ctx.predicateExpressionSimple(), predicateType);
    }

    return null;
  }

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionContext ctx,
      WordType predicateType) {

    if (ctx.predicateExpressionState() != null) {
      return convertText(ctx.predicateExpressionState(), predicateType);
    }

    if (ctx.predicateExpressionVerb() != null) {
      return convertText(ctx.predicateExpressionVerb(), predicateType);
    }

    return null;
  }

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionBEContext ctx,
      WordType predicateType) {

    PredicateExpression<T> pe = new PredicateExpression<T>();

    if (predicateType.equals(WordType.OBJECT_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.IS_Object);
    }

    if (predicateType.equals(WordType.DATA_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.IS_Data);
    }

    if (predicateType.equals(WordType.ANNOTATION_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.IS_Annotation);
    }

    pe.setNegative(ctx.NOT() != null);

    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionDOContext ctx,
      WordType predicateType) {

    PredicateExpression<T> pe = new PredicateExpression<T>();
    T pred = convertWord(ctx.DOES(), predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionHASContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();
    T pred = convertWord(ctx.HAS(), predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionHAS_POSSContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();
    T pred = convertWord(ctx.HAS(), predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionNounContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();

    StringBuilder bldr = new StringBuilder();

    if (ctx.IS() != null) {
      bldr.append("is");
      bldr.append(" ");
    }

    if (ctx.HAS() != null) {
      bldr.append("has");
      bldr.append(" ");
    }

    if (ctx.PREDICATE() != null) {
      bldr.append(ctx.PREDICATE().getText());
      bldr.append(" ");
    }

    if (ctx.A() != null) {
      bldr.append(ctx.A().getText());
      bldr.append(" ");
    }

    if (ctx.THE() != null) {
      bldr.append(ctx.THE().getText());
      bldr.append(" ");
    }

    List<Noun> core = convertText(ctx.adjp());
    for (Noun n : core) {
      bldr.append(n.getNormalForm());
      bldr.append(" ");
    }

    bldr.append(ctx.PARTICLE().getText());

    String text = bldr.toString();
    T pred = convertWord(text, predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionParticleContext ctx,
      WordType predicateType) {

    PredicateExpression<T> pe = new PredicateExpression<T>();

    StringBuilder bldr = new StringBuilder();

    if (ctx.IS() != null) {
      bldr.append("is");
      bldr.append(" ");
    }

    if (ctx.HAS() != null) {
      bldr.append("has");
      bldr.append(" ");
    }

    if (ctx.PREDICATE() != null) {
      bldr.append(ctx.PREDICATE().getText());
      bldr.append(" ");
    }

    bldr.append(ctx.PARTICLE().getText());

    String text = bldr.toString();
    T pred = convertWord(text, predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;

  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionPassiveContext ctx,
      WordType predicateType) {

    PredicateExpression<T> pe = new PredicateExpression<T>();

    StringBuilder bldr = new StringBuilder();

    if (ctx.PREDICATE() != null) {
      bldr.append(ctx.PREDICATE().getText());
      bldr.append(" ");
    }

    if (ctx.PARTICLE() != null) {
      bldr.append(ctx.PARTICLE().getText());
      bldr.append(" ");
    }

    String text = bldr.toString();
    T pred = convertWord(text, predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    pe.setPassive(true);

    return pe;

  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionSameAsContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();

    if (predicateType.equals(WordType.OBJECT_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.SAME_Object);
    }

    if (predicateType.equals(WordType.DATA_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.SAME_Data);
    }

    if (predicateType.equals(WordType.ANNOTATION_PREDICATE)) {
      pe.setPredicate((T) Vocabulary.SAME_Annotation);
    }
    pe.setNegative(ctx.NOT() != null);
    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionSimpleContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();

    T pred = convertWord(ctx.PREDICATE(), predicateType);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionStateContext ctx,
      WordType predicateType) {

    if (ctx.predicateExpressionBE() != null) {
      return convertText(ctx.predicateExpressionBE(), predicateType);
    }

    if (ctx.predicateExpressionSameAs() != null) {
      return convertText(ctx.predicateExpressionSameAs(), predicateType);
    }

    return null;
  }

  private PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate> convertText(PredicatePhraseCommonNounContext ctx) {
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());
    CategoryPhrase<Noun> obj = convertText(ctx.commonNounPhrase());
    PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate> predPhrase = new PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate>(
        pe, obj);
    return predPhrase;
  }

  private PredicatePhrase<? extends SubjectObjectPhrase, ObjectPredicate> convertText(
      PredicatePhraseCommonNounOrSetContext ctx) {

    if (ctx.predicatePhraseCommonNoun() != null) {
      return convertText(ctx.predicatePhraseCommonNoun());
    }

    if (ctx.predicatePhraseNounSet() != null) {
      return convertText(ctx.predicatePhraseNounSet());
    }

    return null;
  }
  private PredicatePhrase<? extends SubjectObjectPhrase, DataPredicate> convertText(PredicatePhraseDataContext ctx) {

    if (ctx.predicatePhraseDataSet() != null) {
      return convertText(ctx.predicatePhraseDataSet());
    }

    if (ctx.predicatePhraseDataType() != null) {
      return convertText(ctx.predicatePhraseDataType());
    }

    if (ctx.predicatePhraseDataValueSet() != null) {
      return convertText(ctx.predicatePhraseDataValueSet());
    }

    return null;
  }
  private PredicatePhrase<PhraseSet<? extends SubjectObjectPhrase>, DataPredicate> convertText(
      PredicatePhraseDataSetContext ctx) {
    PredicateExpression<DataPredicate> pe = convertText(ctx.predicateExpressionData());
    PhraseSet<SubjectObjectPhrase> obj = convertText(ctx.dataTypeSet());
    PredicatePhrase<PhraseSet<? extends SubjectObjectPhrase>, DataPredicate> predPhrase = new PredicatePhrase<PhraseSet<? extends SubjectObjectPhrase>, DataPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<CategoryPhrase<DataType>, DataPredicate> convertText(PredicatePhraseDataTypeContext ctx) {

    PredicateExpression<DataPredicate> pe = convertText(ctx.predicateExpressionData());
    CategoryPhrase<DataType> obj = convertText(ctx.dataTypePhrase());
    PredicatePhrase<CategoryPhrase<DataType>, DataPredicate> predPhrase = new PredicatePhrase<CategoryPhrase<DataType>, DataPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> convertText(PredicatePhraseDataValueContext ctx) {
    PredicateExpression<DataPredicate> pe = convertText(ctx.predicateExpressionVerbData());
    InstancePhrase<DataValue> obj = convertText(ctx.dataValuePhrase());
    PredicatePhrase<InstancePhrase<DataValue>, DataPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<PhraseSet<InstancePhrase<DataValue>>, DataPredicate> convertText(
      PredicatePhraseDataValueSetContext ctx) {
    PredicateExpression<DataPredicate> pe = convertText(ctx.predicateExpressionData());
    PhraseSet<InstancePhrase<DataValue>> obj = convertText(ctx.oneOfData());
    PredicatePhrase<PhraseSet<InstancePhrase<DataValue>>, DataPredicate> predPhrase = new PredicatePhrase<PhraseSet<InstancePhrase<DataValue>>, DataPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate> convertText(PredicatePhraseItselfContext ctx) {
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());
    CategoryPhrase<Noun> obj = new CategoryPhrase<Noun>(Vocabulary.ITSELF);
    PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate> predPhrase = new PredicatePhrase<CategoryPhrase<Noun>, ObjectPredicate>(
        pe, obj);
    return predPhrase;
  }

  private PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> convertText(
      PredicatePhraseMixedContext ctx) {

    if (ctx.predicatePhraseDataValue() != null) {
      return convertText(ctx.predicatePhraseDataValue());
    }

    if (ctx.predicatePhraseNoun() != null) {
      return convertText(ctx.predicatePhraseNoun());
    }

    return null;
  }
  private PredicatePhrase<? extends SubjectObjectPhrase, ObjectPredicate> convertText(PredicatePhraseNounContext ctx) {

    if (ctx.predicatePhraseCommonNoun() != null) {
      return convertText(ctx.predicatePhraseCommonNoun());
    }

    if (ctx.predicatePhraseItself() != null) {
      return convertText(ctx.predicatePhraseItself());
    }

    if (ctx.predicatePhraseNounSet() != null) {
      return convertText(ctx.predicatePhraseNounSet());
    }

    if (ctx.predicatePhraseProperNoun() != null) {
      return convertText(ctx.predicatePhraseProperNoun());
    }

    if (ctx.predicatePhraseProperNounSet() != null) {
      return convertText(ctx.predicatePhraseProperNounSet());
    }

    return null;
  }
  private PredicatePhrase<? extends SubjectObjectPhrase, ObjectPredicate> convertText(
      PredicatePhraseNounSetContext ctx) {
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());

    PhraseSet<SubjectObjectPhrase> obj = convertText(ctx.nounSet());

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> convertText(
      PredicatePhraseProperNounContext ctx) {
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());

    InstancePhrase<ProperNoun> obj = convertText(ctx.properNounPhrase());

    PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> predPhrase = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<PhraseSet<InstancePhrase<ProperNoun>>, ObjectPredicate> convertText(
      PredicatePhraseProperNounSetContext ctx) {
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());

    PhraseSet<InstancePhrase<ProperNoun>> obj = convertText(ctx.oneOfProperNoun());

    PredicatePhrase<PhraseSet<InstancePhrase<ProperNoun>>, ObjectPredicate> predPhrase = new PredicatePhrase<PhraseSet<InstancePhrase<ProperNoun>>, ObjectPredicate>(
        pe, obj);
    return predPhrase;
  }
  private PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> convertText(DataTypeRestrictionContext ctx) {

    DataFacet facet = convertWord(ctx.facet());
    DataFacetPredicate facetPred = new DataFacetPredicate(facet);
    PredicateExpression<DataFacetPredicate> pe = new PredicateExpression<DataFacetPredicate>();
    pe.setPredicate(facetPred);

    DataValue dv = convertWord(ctx.dataValue());
    InstancePhrase<DataValue> obj = new InstancePhrase<DataValue>(dv);

    PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate>(
        pe, obj);
    return predPhrase;
  }

  private WordPhrase convertText(AnnotationWordContext ctx) {
    String txt = ctx.getText();

    List<Word> candidates = wordManager.lookupOrCreateByNormalForm(txt, WordType.COMMON_NOUN, currentNamespace);

    if (candidates.size() != 1) {
      LOGGER.warn("Ambigous Proper Noun for:" + txt + "=>" + candidates);
    }

    WordPhrase wp = new WordPhrase(candidates.get(0));
    return wp;
  }

  private DataValue convertWord(DataValueContext ctx) {

    if (ctx.number() != null) {

      if (ctx.number().INTEGER() != null) {
        DataValue dv = new DataValue(ctx.number().INTEGER().getText());
        dv.setDatatype(Vocabulary.INTEGER_TYPE);
        return dv;
      }

      if (ctx.number().DECIMAL() != null) {
        DataValue dv = new DataValue(ctx.number().DECIMAL().getText());
        dv.setDatatype(Vocabulary.DOUBLE_TYPE);
        return dv;
      }
    }

    if (ctx.QUOTED_TEXT() != null) {
      DataValue dv = new DataValue(ctx.getText());
      dv.setDatatype(Vocabulary.TEXT_TYPE);
      return dv;
    }

    LOGGER.warn("Data value of unknown type. Assuming TEXT" + ctx.getText());
    DataValue dv = new DataValue(ctx.getText());
    dv.setDatatype(Vocabulary.TEXT_TYPE);
    return dv;
  }

  private <T extends Word> T convertWord(String norm, WordType wordType) {

    List<T> wrds = wordManager.lookupOrCreateByNormalForm(norm, wordType, currentNamespace);

    if (wrds.size() > 1) {
      LOGGER.warn("Ambigous word found in Word Manager during text conversion:" + norm + " (" + wordType + ")");
    }
    return wrds.get(0);
  }

  private <T extends Word> T convertWord(TerminalNode tnode, WordType wordType) {
    String norm = tnode.getText();

    if (tnode.getSymbol() instanceof HOWLERToken) {
      HOWLERToken howlToken = (HOWLERToken) tnode.getSymbol();
      norm = howlToken.getNormalForm();
    }

    return convertWord(norm, wordType);
  }

  private DataFacet convertWord(FacetContext ctx) {

    DataFacet facet = DataFacet.getTypeByNormalName(ctx.getText());

    if (facet == null) {
      facet = DataFacet.ERROR;
    }

    return facet;
  }

  public List<TypeInfo> generateTypeReport(File lexiconFile, File reportFile) {

    List<TypeInfo> typeReport = lexer.generateTypeReport(lexiconFile, null);
    List<WordType> wts = new ArrayList<WordType>(Arrays.asList(WordType.values()));

    for (TypeInfo info : typeReport) {
      WordType wt = wordTypeMap.get(info.getTokenType());
      info.setWordType(wt);
      wts.remove(wt);
    }

    if (reportFile != null) {
      try {
        FileUtils.writeStringToFile(reportFile,
            "POS tag or Phrase\tElementType\tTokenType\tWordType\tAbstract WordType\n", false);

        for (TypeInfo info : typeReport) {
          FileUtils.writeStringToFile(reportFile, info.toString() + "\n", true);
        }

        for (WordType wt : wts) {
          TypeInfo info = new TypeInfo("", "Nothing mapped to this word type", "", wt);
          FileUtils.writeStringToFile(reportFile, info.toString() + "\n", true);
        }

      } catch (IOException e) {
        LOGGER.error("Could not write Parser Type report to " + reportFile);
      }
    }
    return typeReport;
  }

  // private String convertText(NounPhraseCatchContext ctx) { return null; }
  // private String convertText(SinglePhraseContext ctx) { return null; }
  // private String convertText(SinglePhraseDataContext ctx) { return null; }
  // private String convertText(SinglePhraseObjectContext ctx) { return null; }
  // private String convertText(DataPhraseCatchContext ctx) { return null; }

}
