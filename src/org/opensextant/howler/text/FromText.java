package org.opensextant.howler.text;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
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
import org.opensextant.howler.abstraction.statements.DeclarationStatement;
import org.opensextant.howler.abstraction.statements.DescriptionStatement;
import org.opensextant.howler.abstraction.statements.FactStatement;
import org.opensextant.howler.abstraction.statements.PredicateCharacteristicStatement;
import org.opensextant.howler.abstraction.statements.PredicateRelationStatement;
import org.opensextant.howler.abstraction.statements.WordSequence;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.Noun;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.Predicate.PredicateType;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.text.grammar.HOWL;
import org.opensextant.howler.text.grammar.HOWL.AdjpContext;
import org.opensextant.howler.text.grammar.HOWL.AnnotationStatementContext;
import org.opensextant.howler.text.grammar.HOWL.CommonNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.CompoundNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DataFacetExpressionContext;
import org.opensextant.howler.text.grammar.HOWL.DataTypeExpressionContext;
import org.opensextant.howler.text.grammar.HOWL.DataTypeRestrictionContext;
import org.opensextant.howler.text.grammar.HOWL.DataValueContext;
import org.opensextant.howler.text.grammar.HOWL.DataValuePhraseContext;
import org.opensextant.howler.text.grammar.HOWL.DebugContext;
import org.opensextant.howler.text.grammar.HOWL.DeclarationStatementContext;
import org.opensextant.howler.text.grammar.HOWL.DeclareWordSequenceContext;
import org.opensextant.howler.text.grammar.HOWL.DescriptionStatementDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.DescriptionStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.DocumentContext;
import org.opensextant.howler.text.grammar.HOWL.DomainStatementAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.DomainStatementDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.DomainStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.FactStatementDataContext;
import org.opensextant.howler.text.grammar.HOWL.FactStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.NProperSequenceContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateCharacteristicStatementContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionBEContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionDOContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionHASContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionObjectContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionParticleContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionPassiveContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionSameAsContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionSimpleContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionStateContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateExpressionVerbDataContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseDataValueContext;
import org.opensextant.howler.text.grammar.HOWL.PredicatePhraseNounContext;
import org.opensextant.howler.text.grammar.HOWL.PredicateRelationStatementContext;
import org.opensextant.howler.text.grammar.HOWL.ProperNounPhraseContext;
import org.opensextant.howler.text.grammar.HOWL.QuantContext;
import org.opensextant.howler.text.grammar.HOWL.QuantNumericContext;
import org.opensextant.howler.text.grammar.HOWL.QuantNumericExpressionContext;
import org.opensextant.howler.text.grammar.HOWL.RangeStatementAnnotationContext;
import org.opensextant.howler.text.grammar.HOWL.RangeStatementDataTypeContext;
import org.opensextant.howler.text.grammar.HOWL.RangeStatementObjectContext;
import org.opensextant.howler.text.grammar.HOWL.StatementContext;
import org.opensextant.howler.text.grammar.HOWL.WordSequenceContext;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unchecked"})
public class FromText {

  private static final Logger LOGGER = LoggerFactory.getLogger(FromText.class);
  private HowlerLexer lexer;
  private HOWL parser;
  WordManager wordManager = WordManager.getWordManager();
  private IRI currentNamespace = IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument");

  public FromText(File lexiconFile, File ngramFile, File typeInfoFile, File phraseFile) {
    lexer = new HowlerLexer(lexiconFile, ngramFile, typeInfoFile, phraseFile);
  }

  public HowlerLexer getLexer() {
    return lexer;
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
    String txt = doc.toString();
    return convertText(txt, id, shortname);
  }

  public Document convertText(String text, IRI documentID, String shortname) {

    // set stream input on lexer
    lexer.setInput(text);

    // create a buffer of tokens pulled from the lexer
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // now parse the tokens
    parser = new HOWL(tokens);

    extractVocabulary(parser.document());

    lexer.setInput(text);

    // create a buffer of tokens pulled from the lexer
    tokens = new CommonTokenStream(lexer);

    // now parse the tokens
    parser = new HOWL(tokens);

    // parse the statements
    Document converted = convertText(parser.document());
    converted.setDocumentID(documentID);
    converted.setShortname(shortname);

    return converted;
  }

  private Document convertText(DocumentContext ctx) {
    Document doc = new Document();

    for (StatementContext state : ctx.statement()) {
      Statement statement = convertText(state);
      statement.setSource(getTokenSequence(state));
      doc.addStatement(statement);
    }

    for (DebugContext debug : ctx.debug()) {
      WordSequence bug = convertText(debug);
      bug.setSource(getTokenSequence(debug));
      doc.addStatement(bug);
    }

    return doc;
  }

  private String getTokenSequence(ParserRuleContext ctx) {

    ParseTree ch = ctx.getChild(0);
    RuleNode rNode = (RuleNode) ch;

    String name = HOWL.ruleNames[rNode.getRuleContext().getRuleIndex()];

    List<String> tree = flattenToString(ctx);
    StringBuilder treeBuilder = new StringBuilder();
    treeBuilder.append(name);
    treeBuilder.append(" ");
    for (String t : tree) {
      treeBuilder.append(t);
      treeBuilder.append(" ");
    }

    return treeBuilder.toString().trim();
  }

  private void extractVocabulary(DocumentContext docctx) {

    for (StatementContext state : docctx.statement()) {
      if (state.declarationStatement() != null) {

        DeclarationStatementContext decl = state.declarationStatement();

        WordType wt = WordType.GENERIC_WORD;
        Token tok = decl.WORD_TYPE().getSymbol();
        if (tok instanceof HowlerToken) {
          HowlerToken HToken = (HowlerToken) tok;
          wt = WordType.getTypeByNormalName(HToken.getNormalForm());
        }

        Word subjWord = convertWord(decl.subj, wt, false, true);
        if (!Vocabulary.isBuiltInVocabulary(subjWord)) {
          lexer.addKnownPhrase(subjWord, false);
        }

      }
    }
    lexer.initPhraser();
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

    if (ctx.predicateRelationStatement() != null) {
      return convertText(ctx.predicateRelationStatement());
    }

    if (ctx.predicateCharacteristicStatement() != null) {
      return convertText(ctx.predicateCharacteristicStatement());
    }

    if (ctx.domainStatementObject() != null) {
      return convertText(ctx.domainStatementObject());
    }

    if (ctx.domainStatementDataType() != null) {
      return convertText(ctx.domainStatementDataType());
    }

    if (ctx.domainStatementAnnotation() != null) {
      return convertText(ctx.domainStatementAnnotation());
    }

    if (ctx.declarationStatement() != null) {
      return convertText(ctx.declarationStatement());
    }

    if (ctx.rangeStatementObject() != null) {
      return convertText(ctx.rangeStatementObject());
    }

    if (ctx.rangeStatementDataType() != null) {
      return convertText(ctx.rangeStatementDataType());
    }

    if (ctx.rangeStatementAnnotation() != null) {
      return convertText(ctx.rangeStatementAnnotation());
    }

    return null;
  }

  private DescriptionStatement<ObjectPredicate> convertText(DescriptionStatementObjectContext ctx) {
    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();

    SubjectObjectPhrase subj = convertText(ctx.compoundNounPhrase());
    statement.setSubject(subj);
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = convertText(ctx.predicatePhraseNoun());

    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private DescriptionStatement<DataPredicate> convertText(DescriptionStatementDataTypeContext ctx) {
    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();

    DataType subjWord = null;
    if (ctx.DATATYPE() != null) {
      subjWord = convertWord(ctx.DATATYPE(), WordType.DATATYPE, true);
    }

    if (ctx.AMBIG_WORD() != null) {
      subjWord = convertWord(ctx.AMBIG_WORD(), WordType.DATATYPE, true);
    }

    CategoryPhrase<DataType> subj = new CategoryPhrase<DataType>(subjWord);
    subj.setQuantifierType(Quantifier.A);

    statement.setSubject(subj);

    SubjectObjectPhrase obj = convertText(ctx.dataTypeExpression());
    PredicateExpression<DataPredicate> predExp = new PredicateExpression<DataPredicate>(Vocabulary.SAME_Data);
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        predExp, obj);

    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private FactStatement<ObjectPredicate, ProperNoun> convertText(FactStatementObjectContext ctx) {

    FactStatement<ObjectPredicate, ProperNoun> statement = new FactStatement<ObjectPredicate, ProperNoun>();

    InstancePhrase<ProperNoun> subj = convertText(ctx.properNounPhrase());
    statement.setSubject(subj);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = convertText(ctx.predicatePhraseNoun());

    if (predPhrase.getObject() instanceof InstancePhrase) {
      PredicateExpression<ObjectPredicate> pExp = predPhrase.getPredicateExpression();
      InstancePhrase<ProperNoun> ip = (InstancePhrase<ProperNoun>) predPhrase.getObject();
      PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate> instancePred = new PredicatePhrase<InstancePhrase<ProperNoun>, ObjectPredicate>(
          pExp, ip);
      statement.setInstancePredicatePhrase(instancePred);
    } else {
      statement.setSubjectObjectPredicatePhrase(predPhrase);
    }

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

  private DescriptionStatement<ObjectPredicate> convertText(DomainStatementObjectContext ctx) {

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    statement.setDomain(true);
    SubjectObjectPhrase subj = convertText(ctx.subj);
    statement.setSubject(subj);

    PredicateExpression<ObjectPredicate> pe = convertText(ctx.pred);

    SubjectObjectPhrase obj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;

  }

  private DescriptionStatement<DataPredicate> convertText(DomainStatementDataTypeContext ctx) {

    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();
    statement.setDomain(true);

    SubjectObjectPhrase subj = convertText(ctx.subj);
    statement.setSubject(subj);

    PredicateExpression<DataPredicate> pe = convertText(ctx.pred);

    SubjectObjectPhrase obj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);

    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private DescriptionStatement<AnnotationPredicate> convertText(DomainStatementAnnotationContext ctx) {
    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();
    statement.setDomain(true);

    Word subjWord = convertWord(ctx.subj, WordType.GENERIC_WORD, true, true);
    WordPhrase subj = new WordPhrase(subjWord);
    statement.setSubject(subj);

    PredicateExpression<AnnotationPredicate> pe = convertText(ctx.pred);

    SubjectObjectPhrase obj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);

    PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private DescriptionStatement<ObjectPredicate> convertText(RangeStatementObjectContext ctx) {

    DescriptionStatement<ObjectPredicate> statement = new DescriptionStatement<ObjectPredicate>();
    statement.setRange(true);
    SubjectObjectPhrase subj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
    statement.setSubject(subj);

    PredicateExpression<ObjectPredicate> pe = convertText(ctx.pred);

    SubjectObjectPhrase obj = convertText(ctx.obj);

    if (ctx.NOT() != null) {
      obj.flipNegative();
    }

    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;

  }

  private DescriptionStatement<DataPredicate> convertText(RangeStatementDataTypeContext ctx) {

    DescriptionStatement<DataPredicate> statement = new DescriptionStatement<DataPredicate>();
    statement.setRange(true);

    SubjectObjectPhrase subj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
    statement.setSubject(subj);

    PredicateExpression<DataPredicate> pe = convertText(ctx.pred);

    SubjectObjectPhrase obj = convertText(ctx.obj);

    if (ctx.NOT() != null) {
      obj.flipNegative();
    }
    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private DescriptionStatement<AnnotationPredicate> convertText(RangeStatementAnnotationContext ctx) {
    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();
    statement.setRange(true);

    SubjectObjectPhrase subj = new CategoryPhrase<CommonNoun>(Vocabulary.THING);
    statement.setSubject(subj);

    PredicateExpression<AnnotationPredicate> pe = convertText(ctx.pred);

    Word objWord = convertWord(ctx.obj, WordType.GENERIC_WORD, true, true);
    WordPhrase obj = new WordPhrase(objWord);

    if (ctx.NOT() != null) {
      obj.flipNegative();
    }

    PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
        pe, obj);
    statement.setPredicatePhrase(predPhrase);

    return statement;
  }

  private PredicateRelationStatement<? extends Predicate> convertText(PredicateRelationStatementContext ctx) {

    WordType wt = convertWord(ctx.WORD_TYPE(0), WordType.WORD_TYPE, false);
    if (ctx.WORD_TYPE().size() > 1) {
      WordType wtEnd = convertWord(ctx.WORD_TYPE(1), WordType.WORD_TYPE, false);
      if (!wt.equals(wtEnd)) {
        LOGGER.warn("Predicate relation statement with different WordTypes. Ignoring second:" + wt + "<->" + wtEnd);
      }
    }
    boolean neg = ctx.NOT() != null;
    boolean inverse = ctx.INVERSE_OF() != null;

    PredicateType predType = PredicateType.IS;
    if (ctx.SAME_AS() != null) {
      predType = PredicateType.SAME_AS;
    }

    if (wt.equals(WordType.OBJECT_PREDICATE)) {
      ObjectPredicate subjPred = convertWord(ctx.subj, WordType.OBJECT_PREDICATE, false, true);
      PredicateExpression<ObjectPredicate> subjPredExp = new PredicateExpression<ObjectPredicate>(subjPred);

      ObjectPredicate objPred = convertWord(ctx.obj, WordType.OBJECT_PREDICATE, false, true);
      PredicateExpression<ObjectPredicate> objPredExp = new PredicateExpression<ObjectPredicate>(objPred);

      PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(
          subjPredExp, predType, objPredExp);
      statement.setNegative(neg);
      statement.setInverse(inverse);

      return statement;
    }

    if (wt.equals(WordType.DATA_PREDICATE)) {
      DataPredicate subjPred = convertWord(ctx.subj, WordType.DATA_PREDICATE, false, true);
      PredicateExpression<DataPredicate> subjPredExp = new PredicateExpression<DataPredicate>(subjPred);

      DataPredicate objPred = convertWord(ctx.obj, WordType.DATA_PREDICATE, false, true);
      PredicateExpression<DataPredicate> objPredExp = new PredicateExpression<DataPredicate>(objPred);

      PredicateRelationStatement<DataPredicate> statement = new PredicateRelationStatement<DataPredicate>(subjPredExp,
          predType, objPredExp);
      statement.setNegative(neg);
      statement.setInverse(inverse);

      return statement;
    }

    if (wt.equals(WordType.ANNOTATION_PREDICATE)) {
      AnnotationPredicate subjPred = convertWord(ctx.subj, WordType.ANNOTATION_PREDICATE, false, true);
      PredicateExpression<AnnotationPredicate> subjPredExp = new PredicateExpression<AnnotationPredicate>(subjPred);

      AnnotationPredicate objPred = convertWord(ctx.obj, WordType.ANNOTATION_PREDICATE, false, true);
      PredicateExpression<AnnotationPredicate> objPredExp = new PredicateExpression<AnnotationPredicate>(objPred);

      PredicateRelationStatement<AnnotationPredicate> statement = new PredicateRelationStatement<AnnotationPredicate>(
          subjPredExp, predType, objPredExp);
      statement.setNegative(neg);
      statement.setInverse(inverse);

      return statement;
    }

    LOGGER.error("PredicateRelationStatements must be about a predicate type, forcing to Object Predicate" + wt);
    ObjectPredicate subjPred = convertWord(ctx.subj, WordType.OBJECT_PREDICATE, false, true);
    PredicateExpression<ObjectPredicate> subjPredExp = new PredicateExpression<ObjectPredicate>(subjPred);

    ObjectPredicate objPred = convertWord(ctx.obj, WordType.OBJECT_PREDICATE, false, true);
    PredicateExpression<ObjectPredicate> objPredExp = new PredicateExpression<ObjectPredicate>(objPred);

    PredicateRelationStatement<ObjectPredicate> statement = new PredicateRelationStatement<ObjectPredicate>(subjPredExp,
        predType, objPredExp);
    statement.setNegative(neg);
    statement.setInverse(inverse);

    return statement;

  }

  private PredicateCharacteristicStatement<? extends Predicate> convertText(
      PredicateCharacteristicStatementContext ctx) {

    PredicateCharacteristic character = convertWord(ctx.PREDICATE_CHARACTERISTIC(), WordType.PREDICATE_CHARACTERISTIC,
        true);
    WordType wt = convertWord(ctx.WORD_TYPE(), WordType.WORD_TYPE, false);

    if (wt.equals(WordType.OBJECT_PREDICATE)) {
      ObjectPredicate pred = convertWord(ctx.wordSequence(), wt, true, true);
      PredicateExpression<ObjectPredicate> pe = new PredicateExpression<ObjectPredicate>(pred);
      return new PredicateCharacteristicStatement<ObjectPredicate>(pe, character);
    }

    if (wt.equals(WordType.DATA_PREDICATE)) {
      DataPredicate pred = convertWord(ctx.wordSequence(), wt, true, true);
      PredicateExpression<DataPredicate> pe = new PredicateExpression<DataPredicate>(pred);
      return new PredicateCharacteristicStatement<DataPredicate>(pe, character);
    }

    if (wt.equals(WordType.ANNOTATION_PREDICATE)) {
      AnnotationPredicate pred = convertWord(ctx.wordSequence(), wt, true, true);
      PredicateExpression<AnnotationPredicate> pe = new PredicateExpression<AnnotationPredicate>(pred);
      return new PredicateCharacteristicStatement<AnnotationPredicate>(pe, character);
    }

    ObjectPredicate pred = convertWord(ctx.wordSequence(), wt, true, true);
    LOGGER.error("Tried to set a predicate charateristics on a nonPredicate. Forcing to ObejectPredicate:" + pred + " ("
        + wt + ") " + character);
    PredicateExpression<ObjectPredicate> pe = new PredicateExpression<ObjectPredicate>(pred);
    return new PredicateCharacteristicStatement<ObjectPredicate>(pe, character);
  }

  private DescriptionStatement<AnnotationPredicate> convertText(AnnotationStatementContext ctx) {

    DescriptionStatement<AnnotationPredicate> statement = new DescriptionStatement<AnnotationPredicate>();

    Word subjWord = convertWord(ctx.subj, WordType.GENERIC_WORD, false, true);
    WordPhrase subjWP = new WordPhrase(subjWord);

    statement.setSubject(subjWP);

    AnnotationPredicate relPred = convertWord(ctx.rel, WordType.ANNOTATION_PREDICATE, false, true);

    PredicateExpression<AnnotationPredicate> rel = new PredicateExpression<AnnotationPredicate>(relPred);

    if (ctx.objWord != null) {

      Word objWord = convertWord(ctx.objWord, WordType.GENERIC_WORD, false, true);
      WordPhrase ObjWP = new WordPhrase(objWord);

      PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predicatePhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
          rel, ObjWP);
      statement.setPredicatePhrase(predicatePhrase);
    }

    if (ctx.objValue != null) {
      DataValue obj = convertText(ctx.objValue);
      InstancePhrase<DataValue> dv = new InstancePhrase<DataValue>(obj);

      PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate> predicatePhrase = new PredicatePhrase<SubjectObjectPhrase, AnnotationPredicate>(
          rel, dv);
      statement.setPredicatePhrase(predicatePhrase);
    }

    return statement;
  }

  private DeclarationStatement convertText(DeclarationStatementContext ctx) {

    DeclarationStatement statement = new DeclarationStatement();

    WordType wt = WordType.GENERIC_WORD;
    Token tok = ctx.WORD_TYPE().getSymbol();
    if (tok instanceof HowlerToken) {
      HowlerToken HToken = (HowlerToken) tok;
      wt = WordType.getTypeByNormalName(HToken.getNormalForm());
    }

    Word subjWord = convertWord(ctx.subj, wt, false, true);
    statement.setWord(subjWord);

    return statement;
  }

  private WordSequence convertText(DebugContext ctx) {
    WordSequence seq = new WordSequence();
    seq.addWords(flatten(ctx));
    return seq;
  }

  private List<Word> flatten(RuleContext ctx) {
    List<Word> words = new ArrayList<Word>();

    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);

      if (child instanceof TerminalNode) {
        TerminalNode tNode = (TerminalNode) child;
        words.add(convertWord(tNode, WordType.GENERIC_WORD, false));
      }
      if (child instanceof RuleNode) {
        RuleNode rNode = (RuleNode) child;
        words.addAll(flatten(rNode.getRuleContext()));
      }
    }

    return words;
  }

  private List<String> flattenToString(RuleContext ctx) {
    List<String> words = new ArrayList<String>();

    for (int i = 0; i < ctx.getChildCount(); i++) {
      ParseTree child = ctx.getChild(i);

      if (child instanceof TerminalNode) {
        TerminalNode tNode = (TerminalNode) child;
        words.add(flattenToString(tNode));
      }
      if (child instanceof RuleNode) {
        RuleNode rNode = (RuleNode) child;
        words.addAll(flattenToString(rNode.getRuleContext()));
      }
    }
    return words;
  }

  private String flattenToString(TerminalNode tNode) {
    if (tNode.getSymbol() instanceof HowlerToken) {
      HowlerToken hToken = (HowlerToken) tNode.getSymbol();
      return hToken.getTokenTypeName();
    } else {
      return "UNK";
    }
  }

  private List<Noun> convertText(AdjpContext ctx) {

    List<Noun> nouns = new ArrayList<Noun>();
    if (ctx != null) {
      for (ParseTree child : ctx.children) {
        if (child instanceof TerminalNode) {
          TerminalNode tNode = (TerminalNode) child;

          WordType wt = WordType.COMMON_NOUN;
          if (tNode.getSymbol() instanceof HowlerToken) {
            HowlerToken hToken = (HowlerToken) tNode.getSymbol();
            String tType = hToken.getTokenTypeName();

            if (tType.equals("AMBIG_WORD")) {
              wt = WordType.COMMON_NOUN;
            }
            // wt = WordType.valueOf(hToken.getTokenTypeName());
            // force to common noun (pun)
            if (!wt.equals(WordType.ADJECTIVE)) {
              wt = WordType.COMMON_NOUN;
            }
          }
          nouns.add(convertWord(tNode, wt, true));
        }
      }
    }
    return nouns;
  }

  private SubjectObjectPhrase convertText(CompoundNounPhraseContext ctx) {

    if (ctx.common != null) {
      return convertText(ctx.common);
    }

    if (ctx.proper != null) {
      return convertText(ctx.properNounPhrase());
    }

    if (ctx.setIntersection != null) {
      return convertTextNoun(ctx.compoundNounPhrase(), BooleanSetType.AND);
    }

    if (ctx.setUnion != null) {
      return convertTextNoun(ctx.compoundNounPhrase(), BooleanSetType.OR);
    }

    if (ctx.disjointUnion != null) {
      PhraseSet<SubjectObjectPhrase> set = convertTextNoun(ctx.compoundNounPhrase(), BooleanSetType.OR);
      set.setDisjoint(true);
      return set;
    }

    if (ctx.itself != null) {
      CommonNoun itself = convertWord(ctx.ITSELF(), WordType.COMMON_NOUN, false);
      return new CategoryPhrase<CommonNoun>(itself);
    }

    return null;
  }

  private PhraseSet<SubjectObjectPhrase> convertTextNoun(List<CompoundNounPhraseContext> phraseCTXs,
      BooleanSetType type) {

    PhraseSet<SubjectObjectPhrase> set = new PhraseSet<SubjectObjectPhrase>();
    Set<Quantifier> qes = new HashSet<Quantifier>();

    for (CompoundNounPhraseContext phCTX : phraseCTXs) {
      SubjectObjectPhrase elem = convertText(phCTX);
      qes.add(elem.getQuantifierExpression().getQuantifierType());
      if (elem instanceof PhraseSet) {
        // TODO this only merges one level deep, should be recursive
        PhraseSet<?> innerSet = (PhraseSet<?>) elem;
        // only merge same set types
        if (innerSet.getSetType().equals(type)) {
          LOGGER.debug("Merging Nested phrase sets" + innerSet.getPhrases() + " into " + set);
          for (SubjectObjectPhrase iph : innerSet.getPhrases()) {
            set.addPhrase(iph);
          }
        } else {
          set.addPhrase(elem);
        }
      } else {
        set.addPhrase(elem);
      }
    }

    set.setSetType(type);

    if (qes.contains(Quantifier.EVERY) || qes.contains(Quantifier.ONLY)) {
      set.setQuantifierType(Quantifier.EVERY);
    } else {
      set.setQuantifierType(Quantifier.SOME);
    }

    return set;
  }

  private InstancePhrase<ProperNoun> convertText(ProperNounPhraseContext ctx) {
    InstancePhrase<ProperNoun> ip = new InstancePhrase<ProperNoun>(convertText(ctx.nProperSequence()));
    if (ctx.NOT() != null) {
      ip.flipNegative();
    }
    return ip;
  }

  private ProperNoun convertText(NProperSequenceContext ctx) {

    StringBuilder properBldr = new StringBuilder();

    for (ParseTree proper : ctx.children) {
      properBldr.append(proper.getText());
      properBldr.append(" ");
    }

    String properText = properBldr.toString().trim();
    ProperNoun wrd = convertWord(properText, WordType.PROPER_NOUN, true);
    wrd.setPOS("NP");

    return wrd;
  }

  private CategoryPhrase<Noun> convertText(CommonNounPhraseContext ctx) {

    List<Noun> adjs = convertText(ctx.adjp());

    QuantifierExpression quant = convertText(ctx.quant());
    quant.setNegative(ctx.NOT() != null);

    Noun head = null;
    CategoryPhrase<Noun> catPhrase = null;
    if (ctx.COMMON_NOUN() != null) {
      head = convertWord(ctx.COMMON_NOUN(), WordType.COMMON_NOUN, true);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.ADJECTIVE() != null) {
      head = convertWord(ctx.ADJECTIVE(), WordType.ADJECTIVE, true);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.PROPER_NOUN() != null) {
      // force a proper to an common noun
      head = convertWord(ctx.PROPER_NOUN(), WordType.COMMON_NOUN, true);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.AMBIG_WORD() != null) {
      // force a proper to an common noun
      head = convertWord(ctx.AMBIG_WORD(), WordType.COMMON_NOUN, true);
      catPhrase = new CategoryPhrase<Noun>(head);
    }

    if (ctx.THING() != null) {
      head = Vocabulary.THING;
    }
    if (head == null) {
      LOGGER.error("No head in CategoryPhraseNoun" + ctx);
      head = Vocabulary.THING;
    }

    catPhrase = new CategoryPhrase<Noun>(head);

    catPhrase.setModifiers(adjs);
    catPhrase.setQuantifierExpression(quant);

    for (PredicatePhraseContext rel : ctx.predicatePhrase()) {
      PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> relPhrase = convertText(rel);
      catPhrase.addRelativePhrase(relPhrase);
    }

    return catPhrase;
  }

  private SubjectObjectPhrase convertText(DataTypeExpressionContext ctx) {

    if (ctx.dt != null) {
      DataType dt = convertWord(ctx.DATATYPE(), WordType.DATATYPE, true);
      QuantifierExpression quant = convertText(ctx.quant());
      CategoryPhrase<DataType> cat = new CategoryPhrase<DataType>(dt);
      cat.setQuantifierExpression(quant);
      if (ctx.NOT() != null) {
        cat.flipNegative();
      }
      return cat;
    }

    if (ctx.ambig != null) {
      DataType dt = convertWord(ctx.AMBIG_WORD(), WordType.DATATYPE, true);
      QuantifierExpression quant = convertText(ctx.quant());
      CategoryPhrase<DataType> cat = new CategoryPhrase<DataType>(dt);
      cat.setQuantifierExpression(quant);
      if (ctx.NOT() != null) {
        cat.flipNegative();
      }
      return cat;
    }

    if (ctx.dv != null) {
      return convertText(ctx.dv);
    }

    if (ctx.comp != null) {
      SubjectObjectPhrase comp = convertText(ctx.comp);
      comp.flipNegative();
      return comp;
    }

    if (ctx.rest != null) {
      return convertText(ctx.rest);
    }

    if (ctx.setUnion != null) {
      return convertText(ctx.dataTypeExpression(), BooleanSetType.OR);
    }

    if (ctx.setIntersection != null) {
      return convertText(ctx.dataTypeExpression(), BooleanSetType.AND);
    }

    return null;
  }

  private PhraseSet<SubjectObjectPhrase> convertText(List<DataTypeExpressionContext> dtes, BooleanSetType setType) {

    PhraseSet<SubjectObjectPhrase> set = new PhraseSet<SubjectObjectPhrase>();
    set.setSetType(setType);
    for (DataTypeExpressionContext dte : dtes) {
      SubjectObjectPhrase dt = convertText(dte);

      if (dt instanceof PhraseSet) {
        PhraseSet<?> innerSet = (PhraseSet<?>) dt;
        if (innerSet.getQuantifierType().equals(setType)) {
          LOGGER.debug("Merging Nested phrase sets" + innerSet.getPhrases() + " into " + set);
          for (SubjectObjectPhrase elem : innerSet.getPhrases()) {
            set.addPhrase(elem);
          }
        } else {
          set.addPhrase(innerSet);
        }
      } else {
        set.addPhrase(dt);
      }

    }

    return set;
  }

  private InstancePhrase<DataValue> convertText(DataValuePhraseContext ctx) {
    DataValue dv = convertText(ctx.dataValue());
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

      if (ctx.ONLY() != null) {
        qtype = Quantifier.ONLY;
      }

      qe = new QuantifierExpression(qtype);

      if (ctx.quantNumericExpression() != null) {
        qe = convertText(ctx.quantNumericExpression());
      }

    }

    return qe;
  }

  private QuantifierExpression convertText(QuantNumericExpressionContext ctx) {

    QuantifierExpression qe = new QuantifierExpression(Quantifier.NULL);
    if (ctx.quantNumeric() != null) {
      qe = convertTextQuantifier(ctx.quantNumeric());

    }

    String numtxt = TextUtils.convertNumber(ctx.INTEGER().getText());

    int num = Integer.parseInt(numtxt);

    qe.setQuantity(num);

    return qe;
  }

  private QuantifierExpression convertTextQuantifier(QuantNumericContext ctx) {

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

    QuantifierExpression qe = new QuantifierExpression(qtype);

    return qe;
  }

  private DataFacet convertTextFacet(QuantNumericContext ctx) {

    DataFacet facet = DataFacet.ERROR_FACET;

    if (ctx.EXACT() != null) {
      facet = DataFacet.ERROR_FACET;
    }

    if (ctx.LESS_THAN() != null) {
      facet = DataFacet.MAX_EXCLUSIVE_FACET;
    }

    if (ctx.LESS_THAN_OR_EQUAL() != null) {
      facet = DataFacet.MAX_INCLUSIVE_FACET;
    }

    if (ctx.MORE_THAN() != null) {
      facet = DataFacet.MIN_EXCLUSIVE_FACET;
    }

    if (ctx.MORE_THAN_OR_EQUAL() != null) {
      facet = DataFacet.MIN_INCLUSIVE_FACET;
    }

    return facet;
  }

  private PredicatePhrase<? extends SubjectObjectPhrase, ? extends Predicate> convertText(PredicatePhraseContext ctx) {

    if (ctx.predicatePhraseNoun() != null) {
      return convertText(ctx.predicatePhraseNoun());
    }

    if (ctx.predicatePhraseDataValue() != null) {
      return convertText(ctx.predicatePhraseDataValue());
    }

    if (ctx.predicatePhraseDataType() != null) {
      return convertText(ctx.predicatePhraseDataType());
    }

    return null;
  }

  private PredicatePhrase<SubjectObjectPhrase, DataPredicate> convertText(PredicatePhraseDataTypeContext ctx) {

    SubjectObjectPhrase obj = convertText(ctx.dataTypeExpression());
    PredicateExpression<DataPredicate> pe = convertText(ctx.predicateExpressionData());

    PredicatePhrase<SubjectObjectPhrase, DataPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, DataPredicate>(
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

  private PredicateExpression<DataPredicate> convertText(PredicateExpressionVerbDataContext ctx) {

    return convertText(ctx.predicateExpressionVerb(), WordType.DATA_PREDICATE);
  }

  private PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> convertText(PredicatePhraseNounContext ctx) {

    // SubjectObjectPhrase obj = convertText(ctx.nounPhrase());
    SubjectObjectPhrase obj = convertText(ctx.compoundNounPhrase());
    PredicateExpression<ObjectPredicate> pe = convertText(ctx.predicateExpressionObject());
    /*
     * // move negative predicate to object if (pe.isNegative()) { if (obj.getQuantifierType().equals(Quantifier.EXACT))
     * { // dont change anything } else { pe.flipNegative(); obj.flipNegative();
     * obj.setQuantifierType(obj.getQuantifierType().getNegation()); } }
     */
    PredicatePhrase<SubjectObjectPhrase, ObjectPredicate> predPhrase = new PredicatePhrase<SubjectObjectPhrase, ObjectPredicate>(
        pe, obj);

    return predPhrase;
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

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionVerbContext ctx,
      WordType predicateType) {

    if (ctx.predicateExpressionDO() != null) {
      return convertText(ctx.predicateExpressionDO(), predicateType);
    }

    if (ctx.predicateExpressionHAS() != null) {
      return convertText(ctx.predicateExpressionHAS(), predicateType);
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
    T pred = convertWord(ctx.DOES(), predicateType, true);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    return pe;
  }

  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionHASContext ctx,
      WordType predicateType) {
    PredicateExpression<T> pe = new PredicateExpression<T>();
    T pred = convertWord(ctx.HAS(), predicateType, true);
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

    if (ctx.predicate() != null) {
      bldr.append(ctx.predicate().getText());
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
    T pred = convertWord(text, predicateType, true);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);
    pred.setPOS("VB");

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

    if (ctx.DOES() != null) {
      bldr.append("does");
      bldr.append(" ");
    }

    if (ctx.predicate() != null) {
      bldr.append(ctx.predicate().getText());
      bldr.append(" ");
    }

    bldr.append(ctx.PARTICLE().getText());

    String text = bldr.toString();
    T pred = convertWord(text, predicateType, true);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);
    pred.setPOS("VB");

    return pe;

  }
  private <T extends Predicate> PredicateExpression<T> convertText(PredicateExpressionPassiveContext ctx,
      WordType predicateType) {

    PredicateExpression<T> pe = new PredicateExpression<T>();

    StringBuilder bldr = new StringBuilder();

    if (ctx.predicate() != null) {
      bldr.append(ctx.predicate().getText());

    }

    if (ctx.PARTICLE() != null) {
      bldr.append(" ");
      bldr.append(ctx.PARTICLE().getText());
    }

    String text = bldr.toString();
    T pred = convertWord(text, predicateType, true);
    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);

    pe.setInverse(true);
    pred.setPOS("VB");

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

    T pred = convertText(ctx.predicate(), predicateType);

    pe.setPredicate(pred);
    pe.setNegative(ctx.NOT() != null);
    pred.setPOS("VB");

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

  private <T extends Predicate> T convertText(PredicateContext ctx, WordType predicateType) {
    T pred = null;

    if (ctx.PREDICATE() != null) {
      pred = convertWord(ctx.PREDICATE(), predicateType, true);
    }

    if (ctx.AMBIG_WORD() != null) {
      pred = convertWord(ctx.AMBIG_WORD(), predicateType, true);
    }

    pred.setPOS("VB");

    return pred;
  }

  private SubjectObjectPhrase convertText(DataTypeRestrictionContext ctx) {

    DataType dt = null;
    if (ctx.DATATYPE() != null) {
      dt = convertWord(ctx.DATATYPE(), WordType.DATATYPE, true);
    }

    if (ctx.AMBIG_WORD() != null) {
      dt = convertWord(ctx.AMBIG_WORD(), WordType.DATATYPE, true);
    }

    CategoryPhrase<DataType> catPhrase = new CategoryPhrase<DataType>(dt);

    for (DataFacetExpressionContext facetExp : ctx.dataFacetExpression()) {
      PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> predPhrase = convertText(facetExp);
      catPhrase.addRelativePhrase(predPhrase);
    }
    return catPhrase;
  }
  // PredicatePhrase<InstancePhrase<DataValue>,DataFacetPredicate>
  private PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> convertText(DataFacetExpressionContext ctx) {

    DataFacet facet = DataFacet.ERROR_FACET;
    if (ctx.DATA_FACET() != null) {
      facet = convertWord(ctx.DATA_FACET(), WordType.DATA_FACET, false);
    }

    if (ctx.quantNumeric() != null) {
      facet = convertTextFacet(ctx.quantNumeric());
    }

    DataFacetPredicate facetPredicate = new DataFacetPredicate(facet);

    DataValue dv = convertText(ctx.dataValue());
    InstancePhrase<DataValue> iPhrase = new InstancePhrase<DataValue>(dv);

    PredicateExpression<DataFacetPredicate> i = new PredicateExpression<DataFacetPredicate>(facetPredicate);
    PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate> predPhrase = new PredicatePhrase<InstancePhrase<DataValue>, DataFacetPredicate>(
        i, iPhrase);

    return predPhrase;
  }

  private DataValue convertText(DataValueContext ctx) {

    if (ctx.INTEGER() != null) {
      DataValue dv = new DataValue(ctx.INTEGER().getText());
      dv.setDatatype(Vocabulary.INTEGER_TYPE);
      dv.setPOS("CD");
      return dv;
    }

    if (ctx.DECIMAL() != null) {
      DataValue dv = new DataValue(ctx.DECIMAL().getText());
      dv.setDatatype(Vocabulary.DOUBLE_TYPE);
      dv.setPOS("CD");
      return dv;
    }

    if (ctx.QUOTED_TEXT() != null) {
      DataValue dv = new DataValue(ctx.getText());
      dv.setDatatype(Vocabulary.STRING_TYPE);
      // TODO guess actual type here, date, boolean ...?
      dv.setPOS("QUOTED_TEXT");
      // assume english?
      // dv.setLanguage("en");
      return dv;
    }

    LOGGER.warn("Data value of unknown type. Assuming STRING" + ctx.getText());
    DataValue dv = new DataValue(ctx.getText());
    dv.setDatatype(Vocabulary.STRING_TYPE);
    dv.setPOS("TEXT");

    return dv;
  }

  private <T extends Word> T convertWord(String norm, WordType wordType, boolean add) {

    // return 1-n words
    List<T> wrds = wordManager.lookupOrCreateByNormalForm(norm, wordType, currentNamespace, add);

    if (wrds.size() > 1 && !wordType.equals(WordType.GENERIC_WORD) && add) {
      LOGGER.trace("Ambigous word found in Word Manager during text conversion:" + norm + " (" + wordType + ")");
    }

    T wrd = wrds.get(0);
    return wrd;
  }

  private <T extends Word> T convertWord(TerminalNode tnode, WordType wordType, boolean add) {
    String norm = tnode.getText();
    String pos = "";

    if (tnode.getSymbol() instanceof HowlerToken) {
      HowlerToken howlToken = (HowlerToken) tnode.getSymbol();
      norm = howlToken.getNormalForm();
      pos = howlToken.getPos();
    }

    T w = convertWord(norm, wordType, add);
    w.setPOS(pos);
    return w;
  }

  private <T extends Word> T convertWord(WordSequenceContext ctx, WordType wordType, boolean useNorm, boolean add) {

    StringBuilder bldr = new StringBuilder();
    StringBuilder posBldr = new StringBuilder();
    for (ParseTree child : ctx.children) {
      if (child instanceof TerminalNode) {
        TerminalNode tnode = (TerminalNode) child;
        Token tok = tnode.getSymbol();
        if (tok instanceof HowlerToken) {
          HowlerToken howlToken = (HowlerToken) tok;
          if (useNorm) {
            bldr.append(howlToken.getNormalForm());
          } else {
            bldr.append(howlToken.getText());
          }
          bldr.append(" ");
          posBldr.append(howlToken.getPos());
          posBldr.append("/");
        }
      }

    }

    String norm = bldr.toString().trim();
    String posSeq = posBldr.toString().replaceFirst("/$", "");

    T wrd = convertWord(norm, wordType, add);
    if (wrd != null) {
      wrd.setPOS(posSeq);
    } else {
      LOGGER.error("Got a null word during conversion:" + norm + " (" + posSeq + ")");
    }

    return wrd;

  }

  private <T extends Word> T convertWord(DeclareWordSequenceContext ctx, WordType wordType, boolean useNorm,
      boolean add) {

    StringBuilder bldr = new StringBuilder();
    StringBuilder posBldr = new StringBuilder();
    for (ParseTree child : ctx.children) {
      if (child instanceof TerminalNode) {
        TerminalNode tnode = (TerminalNode) child;
        Token tok = tnode.getSymbol();
        if (tok instanceof HowlerToken) {
          HowlerToken howlToken = (HowlerToken) tok;
          if (useNorm) {
            bldr.append(howlToken.getNormalForm());
          } else {
            bldr.append(howlToken.getText());
          }
          bldr.append(" ");
          posBldr.append(howlToken.getPos());
          posBldr.append("/");
        }
      }

    }

    String norm = bldr.toString().trim();
    String posSeq = posBldr.toString().replaceFirst("/$", "");

    T wrd = convertWord(norm, wordType, add);
    if (wrd != null) {
      wrd.setPOS(posSeq);
    } else {
      LOGGER.error("Got a null word during conversion:" + norm + " (" + posSeq + ")");
    }

    return wrd;

  }

}
