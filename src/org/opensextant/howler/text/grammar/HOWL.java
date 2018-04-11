// Generated from HOWL.g4 by ANTLR 4.7.1

 package org.opensextant.howler.text.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HOWL extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADJECTIVE=1, BAD=2, NOUN=3, QUOTED_TEXT=4, OPEN=5, CLOSE=6, PERIOD=7, 
		COMMA=8, NUMBER=9, INTEGER=10, DECIMAL=11, DOES=12, HAS=13, PARTICLE=14, 
		IS=15, PROPER=16, PREDICATE=17, AND=18, ONEOF=19, OR=20, BY=21, IS_ONLY=22, 
		ONLY=23, NO=24, NONE=25, NOT=26, A=27, EVERY=28, EXACT=29, LESS_THAN=30, 
		LESS_THAN_OR_EQUAL=31, MORE_THAN=32, MORE_THAN_OR_EQUAL=33, PATTERN_OF=34, 
		LENGTH_OF=35, MIN_LENGTH_OF=36, MAX_LENGTH_OF=37, TOTAL_DIGITS_OF=38, 
		FRAC_DIGITS_OF=39, LANG_RANGE_OF=40, SOME=41, THE=42, SAME_AS=43, INVERSE_OF=44, 
		THAT=45, MODAL=46, OBJECT_FLAG=47, DATA_FLAG=48, ANNOTATION_FLAG=49, DATATYPE=50, 
		ITSELF=51, TO=52, PRED_CHAR=53, QUOTE=54;
	public static final int
		RULE_document = 0, RULE_statement = 1, RULE_singlePhrase = 2, RULE_debug = 3, 
		RULE_descriptionStatementObject = 4, RULE_descriptionStatementDataType = 5, 
		RULE_factStatementData = 6, RULE_factStatementObject = 7, RULE_predicateRelationStatementObject = 8, 
		RULE_predicateRelationStatementData = 9, RULE_predicateRelationStatementAnnotation = 10, 
		RULE_predicateCharacteristicStatementObject = 11, RULE_predicateCharacteristicStatementData = 12, 
		RULE_predicateCharacteristicStatementAnnotation = 13, RULE_annotationStatement = 14, 
		RULE_commonNounPhrase = 15, RULE_adjp = 16, RULE_properNounPhrase = 17, 
		RULE_nProperSequence = 18, RULE_nounOrProperNounPhrase = 19, RULE_oneOfProperNoun = 20, 
		RULE_nounSet = 21, RULE_nounPhraseSubject = 22, RULE_nounPhraseCatch = 23, 
		RULE_dataTypePhrase = 24, RULE_dataTypeRestriction = 25, RULE_facet = 26, 
		RULE_dataValuePhrase = 27, RULE_dataValue = 28, RULE_number = 29, RULE_oneOfData = 30, 
		RULE_dataTypeSet = 31, RULE_dataPhrase = 32, RULE_dataPhraseCatch = 33, 
		RULE_annotationWord = 34, RULE_quant = 35, RULE_quantNumeric = 36, RULE_predicateExpressionObject = 37, 
		RULE_predicateExpressionData = 38, RULE_predicateExpressionAnnotation = 39, 
		RULE_predicateExpression = 40, RULE_predicateExpressionVerbObject = 41, 
		RULE_predicateExpressionVerbData = 42, RULE_predicateExpressionVerbAnnotation = 43, 
		RULE_predicateExpressionVerb = 44, RULE_predicateExpressionState = 45, 
		RULE_predicateExpressionSimple = 46, RULE_predicateExpressionParticle = 47, 
		RULE_predicateExpressionPassive = 48, RULE_predicateExpressionNoun = 49, 
		RULE_predicateExpressionBE = 50, RULE_predicateExpressionSameAs = 51, 
		RULE_predicateExpressionDO = 52, RULE_predicateExpressionHAS = 53, RULE_predicateExpressionHAS_POSS = 54, 
		RULE_predicatePhraseCommonNoun = 55, RULE_predicatePhraseProperNoun = 56, 
		RULE_predicatePhraseProperNounSet = 57, RULE_predicatePhraseNounSet = 58, 
		RULE_predicatePhraseCommonNounOrSet = 59, RULE_predicatePhraseItself = 60, 
		RULE_predicatePhraseNoun = 61, RULE_predicatePhraseDataType = 62, RULE_predicatePhraseDataValue = 63, 
		RULE_predicatePhraseDataValueSet = 64, RULE_predicatePhraseDataSet = 65, 
		RULE_predicatePhraseData = 66, RULE_predicatePhraseMixed = 67, RULE_singlePhraseObject = 68, 
		RULE_singlePhraseData = 69, RULE_catchSet = 70, RULE_badSentence = 71, 
		RULE_catchAll = 72;
	public static final String[] ruleNames = {
		"document", "statement", "singlePhrase", "debug", "descriptionStatementObject", 
		"descriptionStatementDataType", "factStatementData", "factStatementObject", 
		"predicateRelationStatementObject", "predicateRelationStatementData", 
		"predicateRelationStatementAnnotation", "predicateCharacteristicStatementObject", 
		"predicateCharacteristicStatementData", "predicateCharacteristicStatementAnnotation", 
		"annotationStatement", "commonNounPhrase", "adjp", "properNounPhrase", 
		"nProperSequence", "nounOrProperNounPhrase", "oneOfProperNoun", "nounSet", 
		"nounPhraseSubject", "nounPhraseCatch", "dataTypePhrase", "dataTypeRestriction", 
		"facet", "dataValuePhrase", "dataValue", "number", "oneOfData", "dataTypeSet", 
		"dataPhrase", "dataPhraseCatch", "annotationWord", "quant", "quantNumeric", 
		"predicateExpressionObject", "predicateExpressionData", "predicateExpressionAnnotation", 
		"predicateExpression", "predicateExpressionVerbObject", "predicateExpressionVerbData", 
		"predicateExpressionVerbAnnotation", "predicateExpressionVerb", "predicateExpressionState", 
		"predicateExpressionSimple", "predicateExpressionParticle", "predicateExpressionPassive", 
		"predicateExpressionNoun", "predicateExpressionBE", "predicateExpressionSameAs", 
		"predicateExpressionDO", "predicateExpressionHAS", "predicateExpressionHAS_POSS", 
		"predicatePhraseCommonNoun", "predicatePhraseProperNoun", "predicatePhraseProperNounSet", 
		"predicatePhraseNounSet", "predicatePhraseCommonNounOrSet", "predicatePhraseItself", 
		"predicatePhraseNoun", "predicatePhraseDataType", "predicatePhraseDataValue", 
		"predicatePhraseDataValueSet", "predicatePhraseDataSet", "predicatePhraseData", 
		"predicatePhraseMixed", "singlePhraseObject", "singlePhraseData", "catchSet", 
		"badSentence", "catchAll"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADJECTIVE", "BAD", "NOUN", "QUOTED_TEXT", "OPEN", "CLOSE", "PERIOD", 
		"COMMA", "NUMBER", "INTEGER", "DECIMAL", "DOES", "HAS", "PARTICLE", "IS", 
		"PROPER", "PREDICATE", "AND", "ONEOF", "OR", "BY", "IS_ONLY", "ONLY", 
		"NO", "NONE", "NOT", "A", "EVERY", "EXACT", "LESS_THAN", "LESS_THAN_OR_EQUAL", 
		"MORE_THAN", "MORE_THAN_OR_EQUAL", "PATTERN_OF", "LENGTH_OF", "MIN_LENGTH_OF", 
		"MAX_LENGTH_OF", "TOTAL_DIGITS_OF", "FRAC_DIGITS_OF", "LANG_RANGE_OF", 
		"SOME", "THE", "SAME_AS", "INVERSE_OF", "THAT", "MODAL", "OBJECT_FLAG", 
		"DATA_FLAG", "ANNOTATION_FLAG", "DATATYPE", "ITSELF", "TO", "PRED_CHAR", 
		"QUOTE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HOWL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HOWL(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(HOWL.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(HOWL.PERIOD, i);
		}
		public List<SinglePhraseContext> singlePhrase() {
			return getRuleContexts(SinglePhraseContext.class);
		}
		public SinglePhraseContext singlePhrase(int i) {
			return getRuleContext(SinglePhraseContext.class,i);
		}
		public List<DebugContext> debug() {
			return getRuleContexts(DebugContext.class);
		}
		public DebugContext debug(int i) {
			return getRuleContext(DebugContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(146);
					statement();
					setState(147);
					match(PERIOD);
					}
					break;
				case 2:
					{
					setState(149);
					singlePhrase();
					setState(150);
					match(PERIOD);
					}
					break;
				case 3:
					{
					setState(152);
					debug();
					setState(153);
					match(PERIOD);
					}
					break;
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << BAD) | (1L << NOUN) | (1L << QUOTED_TEXT) | (1L << OPEN) | (1L << CLOSE) | (1L << PERIOD) | (1L << COMMA) | (1L << NUMBER) | (1L << INTEGER) | (1L << DECIMAL) | (1L << DOES) | (1L << HAS) | (1L << PARTICLE) | (1L << IS) | (1L << PROPER) | (1L << PREDICATE) | (1L << AND) | (1L << ONEOF) | (1L << OR) | (1L << BY) | (1L << IS_ONLY) | (1L << ONLY) | (1L << NO) | (1L << NONE) | (1L << NOT) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << PATTERN_OF) | (1L << LENGTH_OF) | (1L << MIN_LENGTH_OF) | (1L << MAX_LENGTH_OF) | (1L << TOTAL_DIGITS_OF) | (1L << FRAC_DIGITS_OF) | (1L << LANG_RANGE_OF) | (1L << SOME) | (1L << THE) | (1L << SAME_AS) | (1L << INVERSE_OF) | (1L << THAT) | (1L << MODAL) | (1L << OBJECT_FLAG) | (1L << DATA_FLAG) | (1L << ANNOTATION_FLAG) | (1L << DATATYPE) | (1L << ITSELF) | (1L << TO) | (1L << PRED_CHAR) | (1L << QUOTE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public FactStatementObjectContext factStatementObject() {
			return getRuleContext(FactStatementObjectContext.class,0);
		}
		public FactStatementDataContext factStatementData() {
			return getRuleContext(FactStatementDataContext.class,0);
		}
		public DescriptionStatementObjectContext descriptionStatementObject() {
			return getRuleContext(DescriptionStatementObjectContext.class,0);
		}
		public DescriptionStatementDataTypeContext descriptionStatementDataType() {
			return getRuleContext(DescriptionStatementDataTypeContext.class,0);
		}
		public PredicateRelationStatementObjectContext predicateRelationStatementObject() {
			return getRuleContext(PredicateRelationStatementObjectContext.class,0);
		}
		public PredicateRelationStatementDataContext predicateRelationStatementData() {
			return getRuleContext(PredicateRelationStatementDataContext.class,0);
		}
		public PredicateRelationStatementAnnotationContext predicateRelationStatementAnnotation() {
			return getRuleContext(PredicateRelationStatementAnnotationContext.class,0);
		}
		public PredicateCharacteristicStatementObjectContext predicateCharacteristicStatementObject() {
			return getRuleContext(PredicateCharacteristicStatementObjectContext.class,0);
		}
		public PredicateCharacteristicStatementDataContext predicateCharacteristicStatementData() {
			return getRuleContext(PredicateCharacteristicStatementDataContext.class,0);
		}
		public PredicateCharacteristicStatementAnnotationContext predicateCharacteristicStatementAnnotation() {
			return getRuleContext(PredicateCharacteristicStatementAnnotationContext.class,0);
		}
		public AnnotationStatementContext annotationStatement() {
			return getRuleContext(AnnotationStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				factStatementObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				factStatementData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				descriptionStatementObject();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				descriptionStatementDataType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				predicateRelationStatementObject();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				predicateRelationStatementData();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(165);
				predicateRelationStatementAnnotation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				predicateCharacteristicStatementObject();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(167);
				predicateCharacteristicStatementData();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(168);
				predicateCharacteristicStatementAnnotation();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(169);
				annotationStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinglePhraseContext extends ParserRuleContext {
		public SinglePhraseObjectContext singlePhraseObject() {
			return getRuleContext(SinglePhraseObjectContext.class,0);
		}
		public SinglePhraseDataContext singlePhraseData() {
			return getRuleContext(SinglePhraseDataContext.class,0);
		}
		public SinglePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlePhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitSinglePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinglePhraseContext singlePhrase() throws RecognitionException {
		SinglePhraseContext _localctx = new SinglePhraseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singlePhrase);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				singlePhraseObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				singlePhraseData();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DebugContext extends ParserRuleContext {
		public CatchSetContext catchSet() {
			return getRuleContext(CatchSetContext.class,0);
		}
		public BadSentenceContext badSentence() {
			return getRuleContext(BadSentenceContext.class,0);
		}
		public CatchAllContext catchAll() {
			return getRuleContext(CatchAllContext.class,0);
		}
		public DebugContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debug; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDebug(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebugContext debug() throws RecognitionException {
		DebugContext _localctx = new DebugContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_debug);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				catchSet();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				badSentence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				catchAll();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionStatementObjectContext extends ParserRuleContext {
		public NounPhraseSubjectContext nounPhraseSubject() {
			return getRuleContext(NounPhraseSubjectContext.class,0);
		}
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
		}
		public DescriptionStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDescriptionStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionStatementObjectContext descriptionStatementObject() throws RecognitionException {
		DescriptionStatementObjectContext _localctx = new DescriptionStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_descriptionStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			nounPhraseSubject();
			setState(182);
			predicatePhraseNoun();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionStatementDataTypeContext extends ParserRuleContext {
		public NounPhraseSubjectContext nounPhraseSubject() {
			return getRuleContext(NounPhraseSubjectContext.class,0);
		}
		public PredicatePhraseDataContext predicatePhraseData() {
			return getRuleContext(PredicatePhraseDataContext.class,0);
		}
		public DescriptionStatementDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionStatementDataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDescriptionStatementDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionStatementDataTypeContext descriptionStatementDataType() throws RecognitionException {
		DescriptionStatementDataTypeContext _localctx = new DescriptionStatementDataTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_descriptionStatementDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			nounPhraseSubject();
			setState(185);
			predicatePhraseData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactStatementDataContext extends ParserRuleContext {
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public PredicatePhraseDataValueContext predicatePhraseDataValue() {
			return getRuleContext(PredicatePhraseDataValueContext.class,0);
		}
		public FactStatementDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factStatementData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitFactStatementData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactStatementDataContext factStatementData() throws RecognitionException {
		FactStatementDataContext _localctx = new FactStatementDataContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_factStatementData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			properNounPhrase();
			setState(188);
			predicatePhraseDataValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactStatementObjectContext extends ParserRuleContext {
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public PredicatePhraseCommonNounOrSetContext predicatePhraseCommonNounOrSet() {
			return getRuleContext(PredicatePhraseCommonNounOrSetContext.class,0);
		}
		public FactStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitFactStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactStatementObjectContext factStatementObject() throws RecognitionException {
		FactStatementObjectContext _localctx = new FactStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			properNounPhrase();
			setState(191);
			predicatePhraseCommonNounOrSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateRelationStatementObjectContext extends ParserRuleContext {
		public PredicateExpressionVerbObjectContext subj;
		public Token relIS;
		public Token relSame;
		public Token relInv;
		public PredicateExpressionVerbObjectContext obj;
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode OBJECT_FLAG() { return getToken(HOWL.OBJECT_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public List<PredicateExpressionVerbObjectContext> predicateExpressionVerbObject() {
			return getRuleContexts(PredicateExpressionVerbObjectContext.class);
		}
		public PredicateExpressionVerbObjectContext predicateExpressionVerbObject(int i) {
			return getRuleContext(PredicateExpressionVerbObjectContext.class,i);
		}
		public List<TerminalNode> TO() { return getTokens(HOWL.TO); }
		public TerminalNode TO(int i) {
			return getToken(HOWL.TO, i);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
		public TerminalNode INVERSE_OF() { return getToken(HOWL.INVERSE_OF, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateRelationStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateRelationStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateRelationStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateRelationStatementObjectContext predicateRelationStatementObject() throws RecognitionException {
		PredicateRelationStatementObjectContext _localctx = new PredicateRelationStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_predicateRelationStatementObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(OPEN);
			setState(194);
			match(OBJECT_FLAG);
			setState(195);
			match(CLOSE);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(196);
				match(TO);
				setState(198);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(197);
					match(IS);
					}
					break;
				}
				}
			}

			setState(202);
			((PredicateRelationStatementObjectContext)_localctx).subj = predicateExpressionVerbObject();
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				{
				setState(203);
				((PredicateRelationStatementObjectContext)_localctx).relIS = match(IS);
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(204);
					match(NOT);
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(207);
				match(IS);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(208);
					match(NOT);
					}
				}

				setState(211);
				((PredicateRelationStatementObjectContext)_localctx).relSame = match(SAME_AS);
				}
				}
				break;
			case 3:
				{
				{
				setState(212);
				match(IS);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(213);
					match(NOT);
					}
				}

				setState(216);
				((PredicateRelationStatementObjectContext)_localctx).relInv = match(INVERSE_OF);
				}
				}
				break;
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(219);
				match(TO);
				setState(221);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(220);
					match(IS);
					}
					break;
				}
				}
			}

			setState(225);
			((PredicateRelationStatementObjectContext)_localctx).obj = predicateExpressionVerbObject();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateRelationStatementDataContext extends ParserRuleContext {
		public PredicateExpressionVerbDataContext subj;
		public Token relIS;
		public Token relSame;
		public Token relInv;
		public PredicateExpressionVerbDataContext obj;
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode DATA_FLAG() { return getToken(HOWL.DATA_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public List<PredicateExpressionVerbDataContext> predicateExpressionVerbData() {
			return getRuleContexts(PredicateExpressionVerbDataContext.class);
		}
		public PredicateExpressionVerbDataContext predicateExpressionVerbData(int i) {
			return getRuleContext(PredicateExpressionVerbDataContext.class,i);
		}
		public List<TerminalNode> TO() { return getTokens(HOWL.TO); }
		public TerminalNode TO(int i) {
			return getToken(HOWL.TO, i);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
		public TerminalNode INVERSE_OF() { return getToken(HOWL.INVERSE_OF, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateRelationStatementDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateRelationStatementData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateRelationStatementData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateRelationStatementDataContext predicateRelationStatementData() throws RecognitionException {
		PredicateRelationStatementDataContext _localctx = new PredicateRelationStatementDataContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_predicateRelationStatementData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(OPEN);
			setState(228);
			match(DATA_FLAG);
			setState(229);
			match(CLOSE);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(230);
				match(TO);
				setState(232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(231);
					match(IS);
					}
					break;
				}
				}
			}

			setState(236);
			((PredicateRelationStatementDataContext)_localctx).subj = predicateExpressionVerbData();
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				{
				setState(237);
				((PredicateRelationStatementDataContext)_localctx).relIS = match(IS);
				setState(239);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(238);
					match(NOT);
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(241);
				match(IS);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(242);
					match(NOT);
					}
				}

				setState(245);
				((PredicateRelationStatementDataContext)_localctx).relSame = match(SAME_AS);
				}
				}
				break;
			case 3:
				{
				{
				setState(246);
				match(IS);
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(247);
					match(NOT);
					}
				}

				setState(250);
				((PredicateRelationStatementDataContext)_localctx).relInv = match(INVERSE_OF);
				}
				}
				break;
			}
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(253);
				match(TO);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(254);
					match(IS);
					}
					break;
				}
				}
			}

			setState(259);
			((PredicateRelationStatementDataContext)_localctx).obj = predicateExpressionVerbData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateRelationStatementAnnotationContext extends ParserRuleContext {
		public PredicateExpressionVerbAnnotationContext subj;
		public Token relIS;
		public Token relSame;
		public Token relInv;
		public PredicateExpressionVerbAnnotationContext obj;
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode ANNOTATION_FLAG() { return getToken(HOWL.ANNOTATION_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public List<PredicateExpressionVerbAnnotationContext> predicateExpressionVerbAnnotation() {
			return getRuleContexts(PredicateExpressionVerbAnnotationContext.class);
		}
		public PredicateExpressionVerbAnnotationContext predicateExpressionVerbAnnotation(int i) {
			return getRuleContext(PredicateExpressionVerbAnnotationContext.class,i);
		}
		public List<TerminalNode> TO() { return getTokens(HOWL.TO); }
		public TerminalNode TO(int i) {
			return getToken(HOWL.TO, i);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
		public TerminalNode INVERSE_OF() { return getToken(HOWL.INVERSE_OF, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateRelationStatementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateRelationStatementAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateRelationStatementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateRelationStatementAnnotationContext predicateRelationStatementAnnotation() throws RecognitionException {
		PredicateRelationStatementAnnotationContext _localctx = new PredicateRelationStatementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_predicateRelationStatementAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(OPEN);
			setState(262);
			match(ANNOTATION_FLAG);
			setState(263);
			match(CLOSE);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(264);
				match(TO);
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(265);
					match(IS);
					}
					break;
				}
				}
			}

			setState(270);
			((PredicateRelationStatementAnnotationContext)_localctx).subj = predicateExpressionVerbAnnotation();
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				{
				setState(271);
				((PredicateRelationStatementAnnotationContext)_localctx).relIS = match(IS);
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(272);
					match(NOT);
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(275);
				match(IS);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(276);
					match(NOT);
					}
				}

				setState(279);
				((PredicateRelationStatementAnnotationContext)_localctx).relSame = match(SAME_AS);
				}
				}
				break;
			case 3:
				{
				{
				setState(280);
				match(IS);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(281);
					match(NOT);
					}
				}

				setState(284);
				((PredicateRelationStatementAnnotationContext)_localctx).relInv = match(INVERSE_OF);
				}
				}
				break;
			}
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(287);
				match(TO);
				setState(289);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(288);
					match(IS);
					}
					break;
				}
				}
			}

			setState(293);
			((PredicateRelationStatementAnnotationContext)_localctx).obj = predicateExpressionVerbAnnotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateCharacteristicStatementObjectContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode OBJECT_FLAG() { return getToken(HOWL.OBJECT_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public PredicateExpressionVerbObjectContext predicateExpressionVerbObject() {
			return getRuleContext(PredicateExpressionVerbObjectContext.class,0);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode PRED_CHAR() { return getToken(HOWL.PRED_CHAR, 0); }
		public TerminalNode TO() { return getToken(HOWL.TO, 0); }
		public PredicateCharacteristicStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCharacteristicStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateCharacteristicStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateCharacteristicStatementObjectContext predicateCharacteristicStatementObject() throws RecognitionException {
		PredicateCharacteristicStatementObjectContext _localctx = new PredicateCharacteristicStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_predicateCharacteristicStatementObject);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(OPEN);
			setState(296);
			match(OBJECT_FLAG);
			setState(297);
			match(CLOSE);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(298);
				match(TO);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(299);
					match(IS);
					}
					break;
				}
				}
			}

			setState(304);
			predicateExpressionVerbObject();
			setState(305);
			match(IS);
			setState(306);
			match(PRED_CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateCharacteristicStatementDataContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode DATA_FLAG() { return getToken(HOWL.DATA_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public PredicateExpressionVerbDataContext predicateExpressionVerbData() {
			return getRuleContext(PredicateExpressionVerbDataContext.class,0);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode PRED_CHAR() { return getToken(HOWL.PRED_CHAR, 0); }
		public TerminalNode TO() { return getToken(HOWL.TO, 0); }
		public PredicateCharacteristicStatementDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCharacteristicStatementData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateCharacteristicStatementData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateCharacteristicStatementDataContext predicateCharacteristicStatementData() throws RecognitionException {
		PredicateCharacteristicStatementDataContext _localctx = new PredicateCharacteristicStatementDataContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_predicateCharacteristicStatementData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(OPEN);
			setState(309);
			match(DATA_FLAG);
			setState(310);
			match(CLOSE);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(311);
				match(TO);
				setState(313);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(312);
					match(IS);
					}
					break;
				}
				}
			}

			setState(317);
			predicateExpressionVerbData();
			setState(318);
			match(IS);
			setState(319);
			match(PRED_CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateCharacteristicStatementAnnotationContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode ANNOTATION_FLAG() { return getToken(HOWL.ANNOTATION_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public PredicateExpressionVerbAnnotationContext predicateExpressionVerbAnnotation() {
			return getRuleContext(PredicateExpressionVerbAnnotationContext.class,0);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public TerminalNode PRED_CHAR() { return getToken(HOWL.PRED_CHAR, 0); }
		public TerminalNode TO() { return getToken(HOWL.TO, 0); }
		public PredicateCharacteristicStatementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCharacteristicStatementAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateCharacteristicStatementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateCharacteristicStatementAnnotationContext predicateCharacteristicStatementAnnotation() throws RecognitionException {
		PredicateCharacteristicStatementAnnotationContext _localctx = new PredicateCharacteristicStatementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_predicateCharacteristicStatementAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(OPEN);
			setState(322);
			match(ANNOTATION_FLAG);
			setState(323);
			match(CLOSE);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(324);
				match(TO);
				setState(326);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(325);
					match(IS);
					}
					break;
				}
				}
			}

			setState(330);
			predicateExpressionVerbAnnotation();
			setState(331);
			match(IS);
			setState(332);
			match(PRED_CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationStatementContext extends ParserRuleContext {
		public AnnotationWordContext subj;
		public PredicateExpressionAnnotationContext rel;
		public AnnotationWordContext objWord;
		public DataValueContext objValue;
		public TerminalNode OPEN() { return getToken(HOWL.OPEN, 0); }
		public TerminalNode ANNOTATION_FLAG() { return getToken(HOWL.ANNOTATION_FLAG, 0); }
		public TerminalNode CLOSE() { return getToken(HOWL.CLOSE, 0); }
		public List<AnnotationWordContext> annotationWord() {
			return getRuleContexts(AnnotationWordContext.class);
		}
		public AnnotationWordContext annotationWord(int i) {
			return getRuleContext(AnnotationWordContext.class,i);
		}
		public PredicateExpressionAnnotationContext predicateExpressionAnnotation() {
			return getRuleContext(PredicateExpressionAnnotationContext.class,0);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public AnnotationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitAnnotationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationStatementContext annotationStatement() throws RecognitionException {
		AnnotationStatementContext _localctx = new AnnotationStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_annotationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(OPEN);
			setState(335);
			match(ANNOTATION_FLAG);
			setState(336);
			match(CLOSE);
			setState(337);
			((AnnotationStatementContext)_localctx).subj = annotationWord();
			setState(338);
			((AnnotationStatementContext)_localctx).rel = predicateExpressionAnnotation();
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADJECTIVE:
			case NOUN:
			case PROPER:
			case PREDICATE:
			case DATATYPE:
				{
				setState(339);
				((AnnotationStatementContext)_localctx).objWord = annotationWord();
				}
				break;
			case QUOTED_TEXT:
			case INTEGER:
			case DECIMAL:
				{
				setState(340);
				((AnnotationStatementContext)_localctx).objValue = dataValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonNounPhraseContext extends ParserRuleContext {
		public TerminalNode NOUN() { return getToken(HOWL.NOUN, 0); }
		public TerminalNode ADJECTIVE() { return getToken(HOWL.ADJECTIVE, 0); }
		public TerminalNode PROPER() { return getToken(HOWL.PROPER, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public AdjpContext adjp() {
			return getRuleContext(AdjpContext.class,0);
		}
		public List<TerminalNode> THAT() { return getTokens(HOWL.THAT); }
		public TerminalNode THAT(int i) {
			return getToken(HOWL.THAT, i);
		}
		public List<PredicatePhraseMixedContext> predicatePhraseMixed() {
			return getRuleContexts(PredicatePhraseMixedContext.class);
		}
		public PredicatePhraseMixedContext predicatePhraseMixed(int i) {
			return getRuleContext(PredicatePhraseMixedContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public CommonNounPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonNounPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitCommonNounPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommonNounPhraseContext commonNounPhrase() throws RecognitionException {
		CommonNounPhraseContext _localctx = new CommonNounPhraseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_commonNounPhrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(343);
				match(NOT);
				}
			}

			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
				{
				setState(346);
				quant();
				}
			}

			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(349);
				adjp();
				}
				break;
			}
			setState(352);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << NOUN) | (1L << PROPER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THAT) {
				{
				setState(353);
				match(THAT);
				setState(354);
				predicatePhraseMixed();
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(355);
						match(AND);
						setState(356);
						match(THAT);
						setState(357);
						predicatePhraseMixed();
						}
						} 
					}
					setState(362);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdjpContext extends ParserRuleContext {
		public List<TerminalNode> ADJECTIVE() { return getTokens(HOWL.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(HOWL.ADJECTIVE, i);
		}
		public List<TerminalNode> NOUN() { return getTokens(HOWL.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(HOWL.NOUN, i);
		}
		public List<TerminalNode> PROPER() { return getTokens(HOWL.PROPER); }
		public TerminalNode PROPER(int i) {
			return getToken(HOWL.PROPER, i);
		}
		public List<TerminalNode> PREDICATE() { return getTokens(HOWL.PREDICATE); }
		public TerminalNode PREDICATE(int i) {
			return getToken(HOWL.PREDICATE, i);
		}
		public AdjpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adjp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitAdjp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdjpContext adjp() throws RecognitionException {
		AdjpContext _localctx = new AdjpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_adjp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(365);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << NOUN) | (1L << PROPER) | (1L << PREDICATE))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(368); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProperNounPhraseContext extends ParserRuleContext {
		public NProperSequenceContext nProperSequence() {
			return getRuleContext(NProperSequenceContext.class,0);
		}
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public ProperNounPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properNounPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitProperNounPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProperNounPhraseContext properNounPhrase() throws RecognitionException {
		ProperNounPhraseContext _localctx = new ProperNounPhraseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_properNounPhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THE) {
				{
				setState(370);
				match(THE);
				}
			}

			setState(373);
			nProperSequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NProperSequenceContext extends ParserRuleContext {
		public List<TerminalNode> PROPER() { return getTokens(HOWL.PROPER); }
		public TerminalNode PROPER(int i) {
			return getToken(HOWL.PROPER, i);
		}
		public NProperSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nProperSequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNProperSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NProperSequenceContext nProperSequence() throws RecognitionException {
		NProperSequenceContext _localctx = new NProperSequenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nProperSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(375);
					match(PROPER);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(378); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NounOrProperNounPhraseContext extends ParserRuleContext {
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public OneOfProperNounContext oneOfProperNoun() {
			return getRuleContext(OneOfProperNounContext.class,0);
		}
		public NounOrProperNounPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nounOrProperNounPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNounOrProperNounPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounOrProperNounPhraseContext nounOrProperNounPhrase() throws RecognitionException {
		NounOrProperNounPhraseContext _localctx = new NounOrProperNounPhraseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_nounOrProperNounPhrase);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				properNounPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
				commonNounPhrase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(382);
				oneOfProperNoun();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneOfProperNounContext extends ParserRuleContext {
		public TerminalNode ONEOF() { return getToken(HOWL.ONEOF, 0); }
		public List<ProperNounPhraseContext> properNounPhrase() {
			return getRuleContexts(ProperNounPhraseContext.class);
		}
		public ProperNounPhraseContext properNounPhrase(int i) {
			return getRuleContext(ProperNounPhraseContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public OneOfProperNounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneOfProperNoun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitOneOfProperNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneOfProperNounContext oneOfProperNoun() throws RecognitionException {
		OneOfProperNounContext _localctx = new OneOfProperNounContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_oneOfProperNoun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(ONEOF);
			setState(386);
			properNounPhrase();
			setState(389); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(387);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(388);
					properNounPhrase();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(391); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NounSetContext extends ParserRuleContext {
		public NounOrProperNounPhraseContext nounOrProperNounPhrase() {
			return getRuleContext(NounOrProperNounPhraseContext.class,0);
		}
		public List<NounPhraseSubjectContext> nounPhraseSubject() {
			return getRuleContexts(NounPhraseSubjectContext.class);
		}
		public NounPhraseSubjectContext nounPhraseSubject(int i) {
			return getRuleContext(NounPhraseSubjectContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public NounSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nounSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNounSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounSetContext nounSet() throws RecognitionException {
		NounSetContext _localctx = new NounSetContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_nounSet);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			nounOrProperNounPhrase();
			setState(396); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(394);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMA) | (1L << AND) | (1L << OR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(395);
					nounPhraseSubject();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(398); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NounPhraseSubjectContext extends ParserRuleContext {
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public NounSetContext nounSet() {
			return getRuleContext(NounSetContext.class,0);
		}
		public NounPhraseSubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nounPhraseSubject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNounPhraseSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounPhraseSubjectContext nounPhraseSubject() throws RecognitionException {
		NounPhraseSubjectContext _localctx = new NounPhraseSubjectContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nounPhraseSubject);
		try {
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				commonNounPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				nounSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NounPhraseCatchContext extends ParserRuleContext {
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public OneOfProperNounContext oneOfProperNoun() {
			return getRuleContext(OneOfProperNounContext.class,0);
		}
		public NounSetContext nounSet() {
			return getRuleContext(NounSetContext.class,0);
		}
		public NounPhraseCatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nounPhraseCatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNounPhraseCatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounPhraseCatchContext nounPhraseCatch() throws RecognitionException {
		NounPhraseCatchContext _localctx = new NounPhraseCatchContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_nounPhraseCatch);
		try {
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				commonNounPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				properNounPhrase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(406);
				oneOfProperNoun();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(407);
				nounSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypePhraseContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public List<DataTypeRestrictionContext> dataTypeRestriction() {
			return getRuleContexts(DataTypeRestrictionContext.class);
		}
		public DataTypeRestrictionContext dataTypeRestriction(int i) {
			return getRuleContext(DataTypeRestrictionContext.class,i);
		}
		public List<TerminalNode> THAT() { return getTokens(HOWL.THAT); }
		public TerminalNode THAT(int i) {
			return getToken(HOWL.THAT, i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> IS() { return getTokens(HOWL.IS); }
		public TerminalNode IS(int i) {
			return getToken(HOWL.IS, i);
		}
		public List<TerminalNode> HAS() { return getTokens(HOWL.HAS); }
		public TerminalNode HAS(int i) {
			return getToken(HOWL.HAS, i);
		}
		public DataTypePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypePhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataTypePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypePhraseContext dataTypePhrase() throws RecognitionException {
		DataTypePhraseContext _localctx = new DataTypePhraseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dataTypePhrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(410);
				match(NOT);
				}
			}

			setState(413);
			match(A);
			{
			setState(414);
			match(DATATYPE);
			}
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THAT) {
					{
					setState(415);
					match(THAT);
					setState(416);
					_la = _input.LA(1);
					if ( !(_la==HAS || _la==IS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(419);
				dataTypeRestriction();
				setState(428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(420);
						match(AND);
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==THAT) {
							{
							setState(421);
							match(THAT);
							setState(422);
							_la = _input.LA(1);
							if ( !(_la==HAS || _la==IS) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
						}

						setState(425);
						dataTypeRestriction();
						}
						} 
					}
					setState(430);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeRestrictionContext extends ParserRuleContext {
		public FacetContext facet() {
			return getRuleContext(FacetContext.class,0);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public DataTypeRestrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeRestriction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataTypeRestriction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeRestrictionContext dataTypeRestriction() throws RecognitionException {
		DataTypeRestrictionContext _localctx = new DataTypeRestrictionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dataTypeRestriction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			facet();
			setState(434);
			dataValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FacetContext extends ParserRuleContext {
		public TerminalNode EXACT() { return getToken(HOWL.EXACT, 0); }
		public TerminalNode LESS_THAN() { return getToken(HOWL.LESS_THAN, 0); }
		public TerminalNode LESS_THAN_OR_EQUAL() { return getToken(HOWL.LESS_THAN_OR_EQUAL, 0); }
		public TerminalNode MORE_THAN() { return getToken(HOWL.MORE_THAN, 0); }
		public TerminalNode MORE_THAN_OR_EQUAL() { return getToken(HOWL.MORE_THAN_OR_EQUAL, 0); }
		public TerminalNode PATTERN_OF() { return getToken(HOWL.PATTERN_OF, 0); }
		public TerminalNode LENGTH_OF() { return getToken(HOWL.LENGTH_OF, 0); }
		public TerminalNode MIN_LENGTH_OF() { return getToken(HOWL.MIN_LENGTH_OF, 0); }
		public TerminalNode MAX_LENGTH_OF() { return getToken(HOWL.MAX_LENGTH_OF, 0); }
		public TerminalNode TOTAL_DIGITS_OF() { return getToken(HOWL.TOTAL_DIGITS_OF, 0); }
		public TerminalNode FRAC_DIGITS_OF() { return getToken(HOWL.FRAC_DIGITS_OF, 0); }
		public TerminalNode LANG_RANGE_OF() { return getToken(HOWL.LANG_RANGE_OF, 0); }
		public FacetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitFacet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FacetContext facet() throws RecognitionException {
		FacetContext _localctx = new FacetContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_facet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << PATTERN_OF) | (1L << LENGTH_OF) | (1L << MIN_LENGTH_OF) | (1L << MAX_LENGTH_OF) | (1L << TOTAL_DIGITS_OF) | (1L << FRAC_DIGITS_OF) | (1L << LANG_RANGE_OF))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataValuePhraseContext extends ParserRuleContext {
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public DataValuePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValuePhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataValuePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValuePhraseContext dataValuePhrase() throws RecognitionException {
		DataValuePhraseContext _localctx = new DataValuePhraseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dataValuePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(438);
				match(NOT);
				}
			}

			setState(441);
			dataValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataValueContext extends ParserRuleContext {
		public TerminalNode QUOTED_TEXT() { return getToken(HOWL.QUOTED_TEXT, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public DataValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueContext dataValue() throws RecognitionException {
		DataValueContext _localctx = new DataValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_dataValue);
		try {
			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUOTED_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(QUOTED_TEXT);
				}
				break;
			case INTEGER:
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(HOWL.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(HOWL.DECIMAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==DECIMAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneOfDataContext extends ParserRuleContext {
		public TerminalNode ONEOF() { return getToken(HOWL.ONEOF, 0); }
		public List<DataValueContext> dataValue() {
			return getRuleContexts(DataValueContext.class);
		}
		public DataValueContext dataValue(int i) {
			return getRuleContext(DataValueContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public OneOfDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneOfData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitOneOfData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneOfDataContext oneOfData() throws RecognitionException {
		OneOfDataContext _localctx = new OneOfDataContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_oneOfData);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(ONEOF);
			setState(450);
			dataValue();
			setState(453); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(451);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(452);
					dataValue();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(455); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeSetContext extends ParserRuleContext {
		public DataTypePhraseContext dataTypePhrase() {
			return getRuleContext(DataTypePhraseContext.class,0);
		}
		public OneOfDataContext oneOfData() {
			return getRuleContext(OneOfDataContext.class,0);
		}
		public List<DataPhraseContext> dataPhrase() {
			return getRuleContexts(DataPhraseContext.class);
		}
		public DataPhraseContext dataPhrase(int i) {
			return getRuleContext(DataPhraseContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public DataTypeSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataTypeSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeSetContext dataTypeSet() throws RecognitionException {
		DataTypeSetContext _localctx = new DataTypeSetContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_dataTypeSet);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case A:
				{
				setState(457);
				dataTypePhrase();
				}
				break;
			case ONEOF:
				{
				setState(458);
				oneOfData();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(463); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(461);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMA) | (1L << AND) | (1L << OR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(462);
					dataPhrase();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(465); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataPhraseContext extends ParserRuleContext {
		public DataTypePhraseContext dataTypePhrase() {
			return getRuleContext(DataTypePhraseContext.class,0);
		}
		public DataTypeSetContext dataTypeSet() {
			return getRuleContext(DataTypeSetContext.class,0);
		}
		public OneOfDataContext oneOfData() {
			return getRuleContext(OneOfDataContext.class,0);
		}
		public DataPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataPhraseContext dataPhrase() throws RecognitionException {
		DataPhraseContext _localctx = new DataPhraseContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dataPhrase);
		try {
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(467);
				dataTypePhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				dataTypeSet();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(469);
				oneOfData();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataPhraseCatchContext extends ParserRuleContext {
		public DataTypePhraseContext dataTypePhrase() {
			return getRuleContext(DataTypePhraseContext.class,0);
		}
		public DataValuePhraseContext dataValuePhrase() {
			return getRuleContext(DataValuePhraseContext.class,0);
		}
		public OneOfDataContext oneOfData() {
			return getRuleContext(OneOfDataContext.class,0);
		}
		public DataTypeSetContext dataTypeSet() {
			return getRuleContext(DataTypeSetContext.class,0);
		}
		public DataPhraseCatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataPhraseCatch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataPhraseCatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataPhraseCatchContext dataPhraseCatch() throws RecognitionException {
		DataPhraseCatchContext _localctx = new DataPhraseCatchContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dataPhraseCatch);
		try {
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(472);
				dataTypePhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				dataValuePhrase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(474);
				oneOfData();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(475);
				dataTypeSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationWordContext extends ParserRuleContext {
		public TerminalNode NOUN() { return getToken(HOWL.NOUN, 0); }
		public TerminalNode ADJECTIVE() { return getToken(HOWL.ADJECTIVE, 0); }
		public TerminalNode PROPER() { return getToken(HOWL.PROPER, 0); }
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public AnnotationWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitAnnotationWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationWordContext annotationWord() throws RecognitionException {
		AnnotationWordContext _localctx = new AnnotationWordContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_annotationWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << NOUN) | (1L << PROPER) | (1L << PREDICATE) | (1L << DATATYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public TerminalNode NO() { return getToken(HOWL.NO, 0); }
		public QuantNumericContext quantNumeric() {
			return getRuleContext(QuantNumericContext.class,0);
		}
		public QuantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantContext quant() throws RecognitionException {
		QuantContext _localctx = new QuantContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_quant);
		try {
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				match(A);
				}
				break;
			case THE:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				match(THE);
				}
				break;
			case EVERY:
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				match(EVERY);
				}
				break;
			case SOME:
				enterOuterAlt(_localctx, 4);
				{
				setState(483);
				match(SOME);
				}
				break;
			case NO:
				enterOuterAlt(_localctx, 5);
				{
				setState(484);
				match(NO);
				}
				break;
			case INTEGER:
			case EXACT:
			case LESS_THAN:
			case LESS_THAN_OR_EQUAL:
			case MORE_THAN:
			case MORE_THAN_OR_EQUAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(485);
				quantNumeric();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantNumericContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(HOWL.INTEGER, 0); }
		public TerminalNode EXACT() { return getToken(HOWL.EXACT, 0); }
		public TerminalNode MORE_THAN() { return getToken(HOWL.MORE_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(HOWL.LESS_THAN, 0); }
		public TerminalNode MORE_THAN_OR_EQUAL() { return getToken(HOWL.MORE_THAN_OR_EQUAL, 0); }
		public TerminalNode LESS_THAN_OR_EQUAL() { return getToken(HOWL.LESS_THAN_OR_EQUAL, 0); }
		public QuantNumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantNumeric; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantNumericContext quantNumeric() throws RecognitionException {
		QuantNumericContext _localctx = new QuantNumericContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_quantNumeric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL))) != 0)) {
				{
				setState(488);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(491);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionObjectContext extends ParserRuleContext {
		public PredicateExpressionContext predicateExpression() {
			return getRuleContext(PredicateExpressionContext.class,0);
		}
		public PredicateExpressionObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionObjectContext predicateExpressionObject() throws RecognitionException {
		PredicateExpressionObjectContext _localctx = new PredicateExpressionObjectContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_predicateExpressionObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			predicateExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionDataContext extends ParserRuleContext {
		public PredicateExpressionContext predicateExpression() {
			return getRuleContext(PredicateExpressionContext.class,0);
		}
		public PredicateExpressionDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionDataContext predicateExpressionData() throws RecognitionException {
		PredicateExpressionDataContext _localctx = new PredicateExpressionDataContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_predicateExpressionData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			predicateExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionAnnotationContext extends ParserRuleContext {
		public PredicateExpressionContext predicateExpression() {
			return getRuleContext(PredicateExpressionContext.class,0);
		}
		public PredicateExpressionAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionAnnotationContext predicateExpressionAnnotation() throws RecognitionException {
		PredicateExpressionAnnotationContext _localctx = new PredicateExpressionAnnotationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_predicateExpressionAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			predicateExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionContext extends ParserRuleContext {
		public PredicateExpressionVerbContext predicateExpressionVerb() {
			return getRuleContext(PredicateExpressionVerbContext.class,0);
		}
		public PredicateExpressionStateContext predicateExpressionState() {
			return getRuleContext(PredicateExpressionStateContext.class,0);
		}
		public PredicateExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionContext predicateExpression() throws RecognitionException {
		PredicateExpressionContext _localctx = new PredicateExpressionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_predicateExpression);
		try {
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				predicateExpressionVerb();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				predicateExpressionState();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionVerbObjectContext extends ParserRuleContext {
		public PredicateExpressionVerbContext predicateExpressionVerb() {
			return getRuleContext(PredicateExpressionVerbContext.class,0);
		}
		public PredicateExpressionVerbObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionVerbObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionVerbObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionVerbObjectContext predicateExpressionVerbObject() throws RecognitionException {
		PredicateExpressionVerbObjectContext _localctx = new PredicateExpressionVerbObjectContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_predicateExpressionVerbObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			predicateExpressionVerb();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionVerbDataContext extends ParserRuleContext {
		public PredicateExpressionVerbContext predicateExpressionVerb() {
			return getRuleContext(PredicateExpressionVerbContext.class,0);
		}
		public PredicateExpressionVerbDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionVerbData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionVerbData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionVerbDataContext predicateExpressionVerbData() throws RecognitionException {
		PredicateExpressionVerbDataContext _localctx = new PredicateExpressionVerbDataContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_predicateExpressionVerbData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			predicateExpressionVerb();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionVerbAnnotationContext extends ParserRuleContext {
		public PredicateExpressionVerbContext predicateExpressionVerb() {
			return getRuleContext(PredicateExpressionVerbContext.class,0);
		}
		public PredicateExpressionVerbAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionVerbAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionVerbAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionVerbAnnotationContext predicateExpressionVerbAnnotation() throws RecognitionException {
		PredicateExpressionVerbAnnotationContext _localctx = new PredicateExpressionVerbAnnotationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_predicateExpressionVerbAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			predicateExpressionVerb();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionVerbContext extends ParserRuleContext {
		public PredicateExpressionSimpleContext predicateExpressionSimple() {
			return getRuleContext(PredicateExpressionSimpleContext.class,0);
		}
		public PredicateExpressionParticleContext predicateExpressionParticle() {
			return getRuleContext(PredicateExpressionParticleContext.class,0);
		}
		public PredicateExpressionPassiveContext predicateExpressionPassive() {
			return getRuleContext(PredicateExpressionPassiveContext.class,0);
		}
		public PredicateExpressionNounContext predicateExpressionNoun() {
			return getRuleContext(PredicateExpressionNounContext.class,0);
		}
		public PredicateExpressionHASContext predicateExpressionHAS() {
			return getRuleContext(PredicateExpressionHASContext.class,0);
		}
		public PredicateExpressionDOContext predicateExpressionDO() {
			return getRuleContext(PredicateExpressionDOContext.class,0);
		}
		public PredicateExpressionHAS_POSSContext predicateExpressionHAS_POSS() {
			return getRuleContext(PredicateExpressionHAS_POSSContext.class,0);
		}
		public PredicateExpressionVerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionVerb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionVerb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionVerbContext predicateExpressionVerb() throws RecognitionException {
		PredicateExpressionVerbContext _localctx = new PredicateExpressionVerbContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_predicateExpressionVerb);
		try {
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				predicateExpressionSimple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				predicateExpressionParticle();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				predicateExpressionPassive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(512);
				predicateExpressionNoun();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(513);
				predicateExpressionHAS();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(514);
				predicateExpressionDO();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(515);
				predicateExpressionHAS_POSS();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionStateContext extends ParserRuleContext {
		public PredicateExpressionBEContext predicateExpressionBE() {
			return getRuleContext(PredicateExpressionBEContext.class,0);
		}
		public PredicateExpressionSameAsContext predicateExpressionSameAs() {
			return getRuleContext(PredicateExpressionSameAsContext.class,0);
		}
		public PredicateExpressionStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionState; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionState(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionStateContext predicateExpressionState() throws RecognitionException {
		PredicateExpressionStateContext _localctx = new PredicateExpressionStateContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_predicateExpressionState);
		try {
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(518);
				predicateExpressionBE();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
				predicateExpressionSameAs();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionSimpleContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionSimpleContext predicateExpressionSimple() throws RecognitionException {
		PredicateExpressionSimpleContext _localctx = new PredicateExpressionSimpleContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_predicateExpressionSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(522);
				match(DOES);
				setState(523);
				match(NOT);
				}
			}

			setState(526);
			match(PREDICATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionParticleContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode PARTICLE() { return getToken(HOWL.PARTICLE, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
		public TerminalNode HAS() { return getToken(HOWL.HAS, 0); }
		public PredicateExpressionParticleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionParticle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionParticle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionParticleContext predicateExpressionParticle() throws RecognitionException {
		PredicateExpressionParticleContext _localctx = new PredicateExpressionParticleContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_predicateExpressionParticle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOES) | (1L << HAS) | (1L << IS))) != 0)) {
				{
				setState(528);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOES) | (1L << HAS) | (1L << IS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(531);
				match(NOT);
				}
			}

			setState(534);
			match(PREDICATE);
			setState(535);
			match(PARTICLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionPassiveContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode BY() { return getToken(HOWL.BY, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public TerminalNode PARTICLE() { return getToken(HOWL.PARTICLE, 0); }
		public PredicateExpressionPassiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionPassive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionPassive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionPassiveContext predicateExpressionPassive() throws RecognitionException {
		PredicateExpressionPassiveContext _localctx = new PredicateExpressionPassiveContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_predicateExpressionPassive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(IS);
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(538);
				match(NOT);
				}
			}

			setState(541);
			match(PREDICATE);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTICLE) {
				{
				setState(542);
				match(PARTICLE);
				}
			}

			setState(545);
			match(BY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionNounContext extends ParserRuleContext {
		public TerminalNode PARTICLE() { return getToken(HOWL.PARTICLE, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode HAS() { return getToken(HOWL.HAS, 0); }
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public AdjpContext adjp() {
			return getRuleContext(AdjpContext.class,0);
		}
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public PredicateExpressionNounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionNoun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionNounContext predicateExpressionNoun() throws RecognitionException {
		PredicateExpressionNounContext _localctx = new PredicateExpressionNounContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_predicateExpressionNoun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HAS) | (1L << IS) | (1L << PREDICATE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(548);
				match(NOT);
				}
			}

			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A || _la==THE) {
				{
				setState(551);
				_la = _input.LA(1);
				if ( !(_la==A || _la==THE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << NOUN) | (1L << PROPER) | (1L << PREDICATE))) != 0)) {
				{
				setState(554);
				adjp();
				}
			}

			setState(557);
			match(PARTICLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionBEContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionBEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionBE; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionBE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionBEContext predicateExpressionBE() throws RecognitionException {
		PredicateExpressionBEContext _localctx = new PredicateExpressionBEContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_predicateExpressionBE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(IS);
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(560);
				match(NOT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionSameAsContext extends ParserRuleContext {
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionSameAsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionSameAs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionSameAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionSameAsContext predicateExpressionSameAs() throws RecognitionException {
		PredicateExpressionSameAsContext _localctx = new PredicateExpressionSameAsContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_predicateExpressionSameAs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(563);
				match(IS);
				}
			}

			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(566);
				match(NOT);
				}
			}

			setState(569);
			match(SAME_AS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionDOContext extends ParserRuleContext {
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionDOContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionDO; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionDO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionDOContext predicateExpressionDO() throws RecognitionException {
		PredicateExpressionDOContext _localctx = new PredicateExpressionDOContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_predicateExpressionDO);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(DOES);
			setState(573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(572);
				match(NOT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionHASContext extends ParserRuleContext {
		public TerminalNode HAS() { return getToken(HOWL.HAS, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionHASContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionHAS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionHAS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionHASContext predicateExpressionHAS() throws RecognitionException {
		PredicateExpressionHASContext _localctx = new PredicateExpressionHASContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_predicateExpressionHAS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(HAS);
			setState(577);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(576);
				match(NOT);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateExpressionHAS_POSSContext extends ParserRuleContext {
		public TerminalNode HAS() { return getToken(HOWL.HAS, 0); }
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public PredicateExpressionHAS_POSSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateExpressionHAS_POSS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateExpressionHAS_POSS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateExpressionHAS_POSSContext predicateExpressionHAS_POSS() throws RecognitionException {
		PredicateExpressionHAS_POSSContext _localctx = new PredicateExpressionHAS_POSSContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_predicateExpressionHAS_POSS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(579);
				match(DOES);
				}
			}

			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(582);
				match(NOT);
				}
			}

			setState(585);
			match(HAS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseCommonNounContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public PredicatePhraseCommonNounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseCommonNoun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseCommonNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseCommonNounContext predicatePhraseCommonNoun() throws RecognitionException {
		PredicatePhraseCommonNounContext _localctx = new PredicatePhraseCommonNounContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_predicatePhraseCommonNoun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			predicateExpressionObject();
			setState(588);
			commonNounPhrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseProperNounContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public PredicatePhraseProperNounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseProperNoun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseProperNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseProperNounContext predicatePhraseProperNoun() throws RecognitionException {
		PredicatePhraseProperNounContext _localctx = new PredicatePhraseProperNounContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_predicatePhraseProperNoun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			predicateExpressionObject();
			setState(591);
			properNounPhrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseProperNounSetContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public OneOfProperNounContext oneOfProperNoun() {
			return getRuleContext(OneOfProperNounContext.class,0);
		}
		public PredicatePhraseProperNounSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseProperNounSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseProperNounSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseProperNounSetContext predicatePhraseProperNounSet() throws RecognitionException {
		PredicatePhraseProperNounSetContext _localctx = new PredicatePhraseProperNounSetContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_predicatePhraseProperNounSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			predicateExpressionObject();
			setState(594);
			oneOfProperNoun();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseNounSetContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public NounSetContext nounSet() {
			return getRuleContext(NounSetContext.class,0);
		}
		public PredicatePhraseNounSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseNounSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseNounSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseNounSetContext predicatePhraseNounSet() throws RecognitionException {
		PredicatePhraseNounSetContext _localctx = new PredicatePhraseNounSetContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_predicatePhraseNounSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			predicateExpressionObject();
			setState(597);
			nounSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseCommonNounOrSetContext extends ParserRuleContext {
		public PredicatePhraseCommonNounContext predicatePhraseCommonNoun() {
			return getRuleContext(PredicatePhraseCommonNounContext.class,0);
		}
		public PredicatePhraseNounSetContext predicatePhraseNounSet() {
			return getRuleContext(PredicatePhraseNounSetContext.class,0);
		}
		public PredicatePhraseCommonNounOrSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseCommonNounOrSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseCommonNounOrSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseCommonNounOrSetContext predicatePhraseCommonNounOrSet() throws RecognitionException {
		PredicatePhraseCommonNounOrSetContext _localctx = new PredicatePhraseCommonNounOrSetContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_predicatePhraseCommonNounOrSet);
		try {
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(599);
				predicatePhraseCommonNoun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(600);
				predicatePhraseNounSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseItselfContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public TerminalNode ITSELF() { return getToken(HOWL.ITSELF, 0); }
		public PredicatePhraseItselfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseItself; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseItself(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseItselfContext predicatePhraseItself() throws RecognitionException {
		PredicatePhraseItselfContext _localctx = new PredicatePhraseItselfContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_predicatePhraseItself);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			predicateExpressionObject();
			setState(604);
			match(ITSELF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseNounContext extends ParserRuleContext {
		public PredicatePhraseCommonNounContext predicatePhraseCommonNoun() {
			return getRuleContext(PredicatePhraseCommonNounContext.class,0);
		}
		public PredicatePhraseProperNounContext predicatePhraseProperNoun() {
			return getRuleContext(PredicatePhraseProperNounContext.class,0);
		}
		public PredicatePhraseProperNounSetContext predicatePhraseProperNounSet() {
			return getRuleContext(PredicatePhraseProperNounSetContext.class,0);
		}
		public PredicatePhraseNounSetContext predicatePhraseNounSet() {
			return getRuleContext(PredicatePhraseNounSetContext.class,0);
		}
		public PredicatePhraseItselfContext predicatePhraseItself() {
			return getRuleContext(PredicatePhraseItselfContext.class,0);
		}
		public PredicatePhraseNounContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseNoun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseNoun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseNounContext predicatePhraseNoun() throws RecognitionException {
		PredicatePhraseNounContext _localctx = new PredicatePhraseNounContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_predicatePhraseNoun);
		try {
			setState(611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(606);
				predicatePhraseCommonNoun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				predicatePhraseProperNoun();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(608);
				predicatePhraseProperNounSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(609);
				predicatePhraseNounSet();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(610);
				predicatePhraseItself();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseDataTypeContext extends ParserRuleContext {
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public DataTypePhraseContext dataTypePhrase() {
			return getRuleContext(DataTypePhraseContext.class,0);
		}
		public PredicatePhraseDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseDataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseDataTypeContext predicatePhraseDataType() throws RecognitionException {
		PredicatePhraseDataTypeContext _localctx = new PredicatePhraseDataTypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_predicatePhraseDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			predicateExpressionData();
			setState(614);
			dataTypePhrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseDataValueContext extends ParserRuleContext {
		public PredicateExpressionVerbDataContext predicateExpressionVerbData() {
			return getRuleContext(PredicateExpressionVerbDataContext.class,0);
		}
		public DataValuePhraseContext dataValuePhrase() {
			return getRuleContext(DataValuePhraseContext.class,0);
		}
		public PredicatePhraseDataValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseDataValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseDataValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseDataValueContext predicatePhraseDataValue() throws RecognitionException {
		PredicatePhraseDataValueContext _localctx = new PredicatePhraseDataValueContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_predicatePhraseDataValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			predicateExpressionVerbData();
			setState(617);
			dataValuePhrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseDataValueSetContext extends ParserRuleContext {
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public OneOfDataContext oneOfData() {
			return getRuleContext(OneOfDataContext.class,0);
		}
		public PredicatePhraseDataValueSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseDataValueSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseDataValueSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseDataValueSetContext predicatePhraseDataValueSet() throws RecognitionException {
		PredicatePhraseDataValueSetContext _localctx = new PredicatePhraseDataValueSetContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_predicatePhraseDataValueSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			predicateExpressionData();
			setState(620);
			oneOfData();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseDataSetContext extends ParserRuleContext {
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public DataTypeSetContext dataTypeSet() {
			return getRuleContext(DataTypeSetContext.class,0);
		}
		public PredicatePhraseDataSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseDataSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseDataSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseDataSetContext predicatePhraseDataSet() throws RecognitionException {
		PredicatePhraseDataSetContext _localctx = new PredicatePhraseDataSetContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_predicatePhraseDataSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			predicateExpressionData();
			setState(623);
			dataTypeSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseDataContext extends ParserRuleContext {
		public PredicatePhraseDataTypeContext predicatePhraseDataType() {
			return getRuleContext(PredicatePhraseDataTypeContext.class,0);
		}
		public PredicatePhraseDataValueSetContext predicatePhraseDataValueSet() {
			return getRuleContext(PredicatePhraseDataValueSetContext.class,0);
		}
		public PredicatePhraseDataSetContext predicatePhraseDataSet() {
			return getRuleContext(PredicatePhraseDataSetContext.class,0);
		}
		public PredicatePhraseDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseDataContext predicatePhraseData() throws RecognitionException {
		PredicatePhraseDataContext _localctx = new PredicatePhraseDataContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_predicatePhraseData);
		try {
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(625);
				predicatePhraseDataType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(626);
				predicatePhraseDataValueSet();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(627);
				predicatePhraseDataSet();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicatePhraseMixedContext extends ParserRuleContext {
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
		}
		public PredicatePhraseDataValueContext predicatePhraseDataValue() {
			return getRuleContext(PredicatePhraseDataValueContext.class,0);
		}
		public PredicatePhraseMixedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhraseMixed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhraseMixed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseMixedContext predicatePhraseMixed() throws RecognitionException {
		PredicatePhraseMixedContext _localctx = new PredicatePhraseMixedContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_predicatePhraseMixed);
		try {
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(630);
				predicatePhraseNoun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				predicatePhraseDataValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinglePhraseObjectContext extends ParserRuleContext {
		public NounPhraseCatchContext nounPhraseCatch() {
			return getRuleContext(NounPhraseCatchContext.class,0);
		}
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
		}
		public SinglePhraseObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlePhraseObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitSinglePhraseObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinglePhraseObjectContext singlePhraseObject() throws RecognitionException {
		SinglePhraseObjectContext _localctx = new SinglePhraseObjectContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_singlePhraseObject);
		try {
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				nounPhraseCatch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(635);
				predicatePhraseNoun();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinglePhraseDataContext extends ParserRuleContext {
		public DataPhraseCatchContext dataPhraseCatch() {
			return getRuleContext(DataPhraseCatchContext.class,0);
		}
		public PredicatePhraseDataContext predicatePhraseData() {
			return getRuleContext(PredicatePhraseDataContext.class,0);
		}
		public PredicatePhraseDataValueContext predicatePhraseDataValue() {
			return getRuleContext(PredicatePhraseDataValueContext.class,0);
		}
		public DataTypeRestrictionContext dataTypeRestriction() {
			return getRuleContext(DataTypeRestrictionContext.class,0);
		}
		public SinglePhraseDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singlePhraseData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitSinglePhraseData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinglePhraseDataContext singlePhraseData() throws RecognitionException {
		SinglePhraseDataContext _localctx = new SinglePhraseDataContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_singlePhraseData);
		try {
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(638);
				dataPhraseCatch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(639);
				predicatePhraseData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(640);
				predicatePhraseDataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(641);
				dataTypeRestriction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchSetContext extends ParserRuleContext {
		public List<SinglePhraseObjectContext> singlePhraseObject() {
			return getRuleContexts(SinglePhraseObjectContext.class);
		}
		public SinglePhraseObjectContext singlePhraseObject(int i) {
			return getRuleContext(SinglePhraseObjectContext.class,i);
		}
		public List<SinglePhraseDataContext> singlePhraseData() {
			return getRuleContexts(SinglePhraseDataContext.class);
		}
		public SinglePhraseDataContext singlePhraseData(int i) {
			return getRuleContext(SinglePhraseDataContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public CatchSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitCatchSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchSetContext catchSet() throws RecognitionException {
		CatchSetContext _localctx = new CatchSetContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_catchSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(649);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
				case 1:
					{
					setState(644);
					singlePhraseObject();
					}
					break;
				case 2:
					{
					setState(645);
					singlePhraseData();
					}
					break;
				case 3:
					{
					setState(646);
					match(AND);
					}
					break;
				case 4:
					{
					setState(647);
					match(OR);
					}
					break;
				case 5:
					{
					setState(648);
					match(COMMA);
					}
					break;
				}
				}
				setState(651); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << NOUN) | (1L << QUOTED_TEXT) | (1L << COMMA) | (1L << INTEGER) | (1L << DECIMAL) | (1L << DOES) | (1L << HAS) | (1L << IS) | (1L << PROPER) | (1L << PREDICATE) | (1L << AND) | (1L << ONEOF) | (1L << OR) | (1L << NO) | (1L << NOT) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << PATTERN_OF) | (1L << LENGTH_OF) | (1L << MIN_LENGTH_OF) | (1L << MAX_LENGTH_OF) | (1L << TOTAL_DIGITS_OF) | (1L << FRAC_DIGITS_OF) | (1L << LANG_RANGE_OF) | (1L << SOME) | (1L << THE) | (1L << SAME_AS))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BadSentenceContext extends ParserRuleContext {
		public List<TerminalNode> BAD() { return getTokens(HOWL.BAD); }
		public TerminalNode BAD(int i) {
			return getToken(HOWL.BAD, i);
		}
		public BadSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_badSentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitBadSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BadSentenceContext badSentence() throws RecognitionException {
		BadSentenceContext _localctx = new BadSentenceContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_badSentence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(656);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(653);
					matchWildcard();
					}
					} 
				}
				setState(658);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			}
			setState(660); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(659);
					match(BAD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(662); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			{
			setState(667);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(664);
					matchWildcard();
					}
					} 
				}
				setState(669);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchAllContext extends ParserRuleContext {
		public CatchAllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchAll; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitCatchAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchAllContext catchAll() throws RecognitionException {
		CatchAllContext _localctx = new CatchAllContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_catchAll);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(670);
					matchWildcard();
					}
					} 
				}
				setState(675);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u02a7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\u009e\n\2\r\2\16\2\u009f"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00ad\n\3\3\4\3\4\5\4"+
		"\u00b1\n\4\3\5\3\5\3\5\5\5\u00b6\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u00c9\n\n\5\n\u00cb\n\n\3\n\3\n"+
		"\3\n\5\n\u00d0\n\n\3\n\3\n\5\n\u00d4\n\n\3\n\3\n\3\n\5\n\u00d9\n\n\3\n"+
		"\5\n\u00dc\n\n\3\n\3\n\5\n\u00e0\n\n\5\n\u00e2\n\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00eb\n\13\5\13\u00ed\n\13\3\13\3\13\3\13\5\13\u00f2"+
		"\n\13\3\13\3\13\5\13\u00f6\n\13\3\13\3\13\3\13\5\13\u00fb\n\13\3\13\5"+
		"\13\u00fe\n\13\3\13\3\13\5\13\u0102\n\13\5\13\u0104\n\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u010d\n\f\5\f\u010f\n\f\3\f\3\f\3\f\5\f\u0114\n\f"+
		"\3\f\3\f\5\f\u0118\n\f\3\f\3\f\3\f\5\f\u011d\n\f\3\f\5\f\u0120\n\f\3\f"+
		"\3\f\5\f\u0124\n\f\5\f\u0126\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u012f"+
		"\n\r\5\r\u0131\n\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16\u013c"+
		"\n\16\5\16\u013e\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0149\n\17\5\17\u014b\n\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u0158\n\20\3\21\5\21\u015b\n\21\3\21\5\21\u015e\n\21"+
		"\3\21\5\21\u0161\n\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0169\n\21\f"+
		"\21\16\21\u016c\13\21\5\21\u016e\n\21\3\22\6\22\u0171\n\22\r\22\16\22"+
		"\u0172\3\23\5\23\u0176\n\23\3\23\3\23\3\24\6\24\u017b\n\24\r\24\16\24"+
		"\u017c\3\25\3\25\3\25\5\25\u0182\n\25\3\26\3\26\3\26\3\26\6\26\u0188\n"+
		"\26\r\26\16\26\u0189\3\27\3\27\3\27\6\27\u018f\n\27\r\27\16\27\u0190\3"+
		"\30\3\30\5\30\u0195\n\30\3\31\3\31\3\31\3\31\5\31\u019b\n\31\3\32\5\32"+
		"\u019e\n\32\3\32\3\32\3\32\3\32\5\32\u01a4\n\32\3\32\3\32\3\32\3\32\5"+
		"\32\u01aa\n\32\3\32\7\32\u01ad\n\32\f\32\16\32\u01b0\13\32\5\32\u01b2"+
		"\n\32\3\33\3\33\3\33\3\34\3\34\3\35\5\35\u01ba\n\35\3\35\3\35\3\36\3\36"+
		"\5\36\u01c0\n\36\3\37\3\37\3 \3 \3 \3 \6 \u01c8\n \r \16 \u01c9\3!\3!"+
		"\5!\u01ce\n!\3!\3!\6!\u01d2\n!\r!\16!\u01d3\3\"\3\"\3\"\5\"\u01d9\n\""+
		"\3#\3#\3#\3#\5#\u01df\n#\3$\3$\3%\3%\3%\3%\3%\3%\5%\u01e9\n%\3&\5&\u01ec"+
		"\n&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\5*\u01f8\n*\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3.\3.\3.\3.\3.\5.\u0207\n.\3/\3/\5/\u020b\n/\3\60\3\60\5\60\u020f\n"+
		"\60\3\60\3\60\3\61\5\61\u0214\n\61\3\61\5\61\u0217\n\61\3\61\3\61\3\61"+
		"\3\62\3\62\5\62\u021e\n\62\3\62\3\62\5\62\u0222\n\62\3\62\3\62\3\63\3"+
		"\63\5\63\u0228\n\63\3\63\5\63\u022b\n\63\3\63\5\63\u022e\n\63\3\63\3\63"+
		"\3\64\3\64\5\64\u0234\n\64\3\65\5\65\u0237\n\65\3\65\5\65\u023a\n\65\3"+
		"\65\3\65\3\66\3\66\5\66\u0240\n\66\3\67\3\67\5\67\u0244\n\67\38\58\u0247"+
		"\n8\38\58\u024a\n8\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\5="+
		"\u025c\n=\3>\3>\3>\3?\3?\3?\3?\3?\5?\u0266\n?\3@\3@\3@\3A\3A\3A\3B\3B"+
		"\3B\3C\3C\3C\3D\3D\3D\5D\u0277\nD\3E\3E\5E\u027b\nE\3F\3F\5F\u027f\nF"+
		"\3G\3G\3G\3G\5G\u0285\nG\3H\3H\3H\3H\3H\6H\u028c\nH\rH\16H\u028d\3I\7"+
		"I\u0291\nI\fI\16I\u0294\13I\3I\6I\u0297\nI\rI\16I\u0298\3I\7I\u029c\n"+
		"I\fI\16I\u029f\13I\3J\7J\u02a2\nJ\fJ\16J\u02a5\13J\3J\5\u0292\u029d\u02a3"+
		"\2K\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\2\16\5\2\3\3\5\5\22\22\5\2\3\3\5\5\22\23\4\2\n\n\26"+
		"\26\5\2\n\n\24\24\26\26\4\2\17\17\21\21\3\2\37*\3\2\f\r\6\2\3\3\5\5\22"+
		"\23\64\64\3\2\37#\4\2\16\17\21\21\5\2\17\17\21\21\23\23\4\2\35\35,,\2"+
		"\u02e0\2\u009d\3\2\2\2\4\u00ac\3\2\2\2\6\u00b0\3\2\2\2\b\u00b5\3\2\2\2"+
		"\n\u00b7\3\2\2\2\f\u00ba\3\2\2\2\16\u00bd\3\2\2\2\20\u00c0\3\2\2\2\22"+
		"\u00c3\3\2\2\2\24\u00e5\3\2\2\2\26\u0107\3\2\2\2\30\u0129\3\2\2\2\32\u0136"+
		"\3\2\2\2\34\u0143\3\2\2\2\36\u0150\3\2\2\2 \u015a\3\2\2\2\"\u0170\3\2"+
		"\2\2$\u0175\3\2\2\2&\u017a\3\2\2\2(\u0181\3\2\2\2*\u0183\3\2\2\2,\u018b"+
		"\3\2\2\2.\u0194\3\2\2\2\60\u019a\3\2\2\2\62\u019d\3\2\2\2\64\u01b3\3\2"+
		"\2\2\66\u01b6\3\2\2\28\u01b9\3\2\2\2:\u01bf\3\2\2\2<\u01c1\3\2\2\2>\u01c3"+
		"\3\2\2\2@\u01cd\3\2\2\2B\u01d8\3\2\2\2D\u01de\3\2\2\2F\u01e0\3\2\2\2H"+
		"\u01e8\3\2\2\2J\u01eb\3\2\2\2L\u01ef\3\2\2\2N\u01f1\3\2\2\2P\u01f3\3\2"+
		"\2\2R\u01f7\3\2\2\2T\u01f9\3\2\2\2V\u01fb\3\2\2\2X\u01fd\3\2\2\2Z\u0206"+
		"\3\2\2\2\\\u020a\3\2\2\2^\u020e\3\2\2\2`\u0213\3\2\2\2b\u021b\3\2\2\2"+
		"d\u0225\3\2\2\2f\u0231\3\2\2\2h\u0236\3\2\2\2j\u023d\3\2\2\2l\u0241\3"+
		"\2\2\2n\u0246\3\2\2\2p\u024d\3\2\2\2r\u0250\3\2\2\2t\u0253\3\2\2\2v\u0256"+
		"\3\2\2\2x\u025b\3\2\2\2z\u025d\3\2\2\2|\u0265\3\2\2\2~\u0267\3\2\2\2\u0080"+
		"\u026a\3\2\2\2\u0082\u026d\3\2\2\2\u0084\u0270\3\2\2\2\u0086\u0276\3\2"+
		"\2\2\u0088\u027a\3\2\2\2\u008a\u027e\3\2\2\2\u008c\u0284\3\2\2\2\u008e"+
		"\u028b\3\2\2\2\u0090\u0292\3\2\2\2\u0092\u02a3\3\2\2\2\u0094\u0095\5\4"+
		"\3\2\u0095\u0096\7\t\2\2\u0096\u009e\3\2\2\2\u0097\u0098\5\6\4\2\u0098"+
		"\u0099\7\t\2\2\u0099\u009e\3\2\2\2\u009a\u009b\5\b\5\2\u009b\u009c\7\t"+
		"\2\2\u009c\u009e\3\2\2\2\u009d\u0094\3\2\2\2\u009d\u0097\3\2\2\2\u009d"+
		"\u009a\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\3\3\2\2\2\u00a1\u00ad\5\20\t\2\u00a2\u00ad\5\16\b\2\u00a3\u00ad"+
		"\5\n\6\2\u00a4\u00ad\5\f\7\2\u00a5\u00ad\5\22\n\2\u00a6\u00ad\5\24\13"+
		"\2\u00a7\u00ad\5\26\f\2\u00a8\u00ad\5\30\r\2\u00a9\u00ad\5\32\16\2\u00aa"+
		"\u00ad\5\34\17\2\u00ab\u00ad\5\36\20\2\u00ac\u00a1\3\2\2\2\u00ac\u00a2"+
		"\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac"+
		"\u00a6\3\2\2\2\u00ac\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\5\3\2\2\2\u00ae\u00b1"+
		"\5\u008aF\2\u00af\u00b1\5\u008cG\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\7\3\2\2\2\u00b2\u00b6\5\u008eH\2\u00b3\u00b6\5\u0090I\2\u00b4"+
		"\u00b6\5\u0092J\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4"+
		"\3\2\2\2\u00b6\t\3\2\2\2\u00b7\u00b8\5.\30\2\u00b8\u00b9\5|?\2\u00b9\13"+
		"\3\2\2\2\u00ba\u00bb\5.\30\2\u00bb\u00bc\5\u0086D\2\u00bc\r\3\2\2\2\u00bd"+
		"\u00be\5$\23\2\u00be\u00bf\5\u0080A\2\u00bf\17\3\2\2\2\u00c0\u00c1\5$"+
		"\23\2\u00c1\u00c2\5x=\2\u00c2\21\3\2\2\2\u00c3\u00c4\7\7\2\2\u00c4\u00c5"+
		"\7\61\2\2\u00c5\u00ca\7\b\2\2\u00c6\u00c8\7\66\2\2\u00c7\u00c9\7\21\2"+
		"\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c6"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00db\5T+\2\u00cd"+
		"\u00cf\7\21\2\2\u00ce\u00d0\7\34\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3"+
		"\2\2\2\u00d0\u00dc\3\2\2\2\u00d1\u00d3\7\21\2\2\u00d2\u00d4\7\34\2\2\u00d3"+
		"\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00dc\7-"+
		"\2\2\u00d6\u00d8\7\21\2\2\u00d7\u00d9\7\34\2\2\u00d8\u00d7\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\7.\2\2\u00db\u00cd\3\2"+
		"\2\2\u00db\u00d1\3\2\2\2\u00db\u00d6\3\2\2\2\u00dc\u00e1\3\2\2\2\u00dd"+
		"\u00df\7\66\2\2\u00de\u00e0\7\21\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3"+
		"\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\5T+\2\u00e4\23\3\2\2\2\u00e5\u00e6\7\7\2\2"+
		"\u00e6\u00e7\7\62\2\2\u00e7\u00ec\7\b\2\2\u00e8\u00ea\7\66\2\2\u00e9\u00eb"+
		"\7\21\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2"+
		"\u00ec\u00e8\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00fd"+
		"\5V,\2\u00ef\u00f1\7\21\2\2\u00f0\u00f2\7\34\2\2\u00f1\u00f0\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00fe\3\2\2\2\u00f3\u00f5\7\21\2\2\u00f4\u00f6\7"+
		"\34\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00fe\7-\2\2\u00f8\u00fa\7\21\2\2\u00f9\u00fb\7\34\2\2\u00fa\u00f9\3"+
		"\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\7.\2\2\u00fd"+
		"\u00ef\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fe\u0103\3\2"+
		"\2\2\u00ff\u0101\7\66\2\2\u0100\u0102\7\21\2\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u00ff\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0106\5V,\2\u0106\25\3\2\2\2\u0107\u0108"+
		"\7\7\2\2\u0108\u0109\7\63\2\2\u0109\u010e\7\b\2\2\u010a\u010c\7\66\2\2"+
		"\u010b\u010d\7\21\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f"+
		"\3\2\2\2\u010e\u010a\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u011f\5X-\2\u0111\u0113\7\21\2\2\u0112\u0114\7\34\2\2\u0113\u0112\3\2"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0120\3\2\2\2\u0115\u0117\7\21\2\2\u0116"+
		"\u0118\7\34\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0119\u0120\7-\2\2\u011a\u011c\7\21\2\2\u011b\u011d\7\34\2\2\u011c"+
		"\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\7."+
		"\2\2\u011f\u0111\3\2\2\2\u011f\u0115\3\2\2\2\u011f\u011a\3\2\2\2\u0120"+
		"\u0125\3\2\2\2\u0121\u0123\7\66\2\2\u0122\u0124\7\21\2\2\u0123\u0122\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0121\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\5X-\2\u0128\27\3\2\2\2"+
		"\u0129\u012a\7\7\2\2\u012a\u012b\7\61\2\2\u012b\u0130\7\b\2\2\u012c\u012e"+
		"\7\66\2\2\u012d\u012f\7\21\2\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2"+
		"\u012f\u0131\3\2\2\2\u0130\u012c\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0133\5T+\2\u0133\u0134\7\21\2\2\u0134\u0135\7\67\2\2\u0135"+
		"\31\3\2\2\2\u0136\u0137\7\7\2\2\u0137\u0138\7\62\2\2\u0138\u013d\7\b\2"+
		"\2\u0139\u013b\7\66\2\2\u013a\u013c\7\21\2\2\u013b\u013a\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0139\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0140\5V,\2\u0140\u0141\7\21\2\2\u0141"+
		"\u0142\7\67\2\2\u0142\33\3\2\2\2\u0143\u0144\7\7\2\2\u0144\u0145\7\63"+
		"\2\2\u0145\u014a\7\b\2\2\u0146\u0148\7\66\2\2\u0147\u0149\7\21\2\2\u0148"+
		"\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0146\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\5X-\2\u014d\u014e"+
		"\7\21\2\2\u014e\u014f\7\67\2\2\u014f\35\3\2\2\2\u0150\u0151\7\7\2\2\u0151"+
		"\u0152\7\63\2\2\u0152\u0153\7\b\2\2\u0153\u0154\5F$\2\u0154\u0157\5P)"+
		"\2\u0155\u0158\5F$\2\u0156\u0158\5:\36\2\u0157\u0155\3\2\2\2\u0157\u0156"+
		"\3\2\2\2\u0158\37\3\2\2\2\u0159\u015b\7\34\2\2\u015a\u0159\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015e\5H%\2\u015d\u015c\3\2\2"+
		"\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u0161\5\"\22\2\u0160"+
		"\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u016d\t\2"+
		"\2\2\u0163\u0164\7/\2\2\u0164\u016a\5\u0088E\2\u0165\u0166\7\24\2\2\u0166"+
		"\u0167\7/\2\2\u0167\u0169\5\u0088E\2\u0168\u0165\3\2\2\2\u0169\u016c\3"+
		"\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016d\u0163\3\2\2\2\u016d\u016e\3\2\2\2\u016e!\3\2\2\2"+
		"\u016f\u0171\t\3\2\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173#\3\2\2\2\u0174\u0176\7,\2\2\u0175\u0174"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\5&\24\2\u0178"+
		"%\3\2\2\2\u0179\u017b\7\22\2\2\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2"+
		"\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\'\3\2\2\2\u017e\u0182\5"+
		"$\23\2\u017f\u0182\5 \21\2\u0180\u0182\5*\26\2\u0181\u017e\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182)\3\2\2\2\u0183\u0184\7\25\2\2"+
		"\u0184\u0187\5$\23\2\u0185\u0186\t\4\2\2\u0186\u0188\5$\23\2\u0187\u0185"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"+\3\2\2\2\u018b\u018e\5(\25\2\u018c\u018d\t\5\2\2\u018d\u018f\5.\30\2"+
		"\u018e\u018c\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191"+
		"\3\2\2\2\u0191-\3\2\2\2\u0192\u0195\5 \21\2\u0193\u0195\5,\27\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0193\3\2\2\2\u0195/\3\2\2\2\u0196\u019b\5 \21\2"+
		"\u0197\u019b\5$\23\2\u0198\u019b\5*\26\2\u0199\u019b\5,\27\2\u019a\u0196"+
		"\3\2\2\2\u019a\u0197\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u0199\3\2\2\2\u019b"+
		"\61\3\2\2\2\u019c\u019e\7\34\2\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2"+
		"\2\u019e\u019f\3\2\2\2\u019f\u01a0\7\35\2\2\u01a0\u01b1\7\64\2\2\u01a1"+
		"\u01a2\7/\2\2\u01a2\u01a4\t\6\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01ae\5\64\33\2\u01a6\u01a9\7\24\2\2\u01a7"+
		"\u01a8\7/\2\2\u01a8\u01aa\t\6\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2"+
		"\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad\5\64\33\2\u01ac\u01a6\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b2\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01a3\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\63\3\2\2\2\u01b3\u01b4\5\66\34\2\u01b4\u01b5\5:\36\2\u01b5\65\3\2\2\2"+
		"\u01b6\u01b7\t\7\2\2\u01b7\67\3\2\2\2\u01b8\u01ba\7\34\2\2\u01b9\u01b8"+
		"\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\5:\36\2\u01bc"+
		"9\3\2\2\2\u01bd\u01c0\7\6\2\2\u01be\u01c0\5<\37\2\u01bf\u01bd\3\2\2\2"+
		"\u01bf\u01be\3\2\2\2\u01c0;\3\2\2\2\u01c1\u01c2\t\b\2\2\u01c2=\3\2\2\2"+
		"\u01c3\u01c4\7\25\2\2\u01c4\u01c7\5:\36\2\u01c5\u01c6\t\4\2\2\u01c6\u01c8"+
		"\5:\36\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9"+
		"\u01ca\3\2\2\2\u01ca?\3\2\2\2\u01cb\u01ce\5\62\32\2\u01cc\u01ce\5> \2"+
		"\u01cd\u01cb\3\2\2\2\u01cd\u01cc\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01d0"+
		"\t\5\2\2\u01d0\u01d2\5B\"\2\u01d1\u01cf\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4A\3\2\2\2\u01d5\u01d9\5\62\32"+
		"\2\u01d6\u01d9\5@!\2\u01d7\u01d9\5> \2\u01d8\u01d5\3\2\2\2\u01d8\u01d6"+
		"\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9C\3\2\2\2\u01da\u01df\5\62\32\2\u01db"+
		"\u01df\58\35\2\u01dc\u01df\5> \2\u01dd\u01df\5@!\2\u01de\u01da\3\2\2\2"+
		"\u01de\u01db\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01dd\3\2\2\2\u01dfE\3"+
		"\2\2\2\u01e0\u01e1\t\t\2\2\u01e1G\3\2\2\2\u01e2\u01e9\7\35\2\2\u01e3\u01e9"+
		"\7,\2\2\u01e4\u01e9\7\36\2\2\u01e5\u01e9\7+\2\2\u01e6\u01e9\7\32\2\2\u01e7"+
		"\u01e9\5J&\2\u01e8\u01e2\3\2\2\2\u01e8\u01e3\3\2\2\2\u01e8\u01e4\3\2\2"+
		"\2\u01e8\u01e5\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9I"+
		"\3\2\2\2\u01ea\u01ec\t\n\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ed\u01ee\7\f\2\2\u01eeK\3\2\2\2\u01ef\u01f0\5R*\2\u01f0"+
		"M\3\2\2\2\u01f1\u01f2\5R*\2\u01f2O\3\2\2\2\u01f3\u01f4\5R*\2\u01f4Q\3"+
		"\2\2\2\u01f5\u01f8\5Z.\2\u01f6\u01f8\5\\/\2\u01f7\u01f5\3\2\2\2\u01f7"+
		"\u01f6\3\2\2\2\u01f8S\3\2\2\2\u01f9\u01fa\5Z.\2\u01faU\3\2\2\2\u01fb\u01fc"+
		"\5Z.\2\u01fcW\3\2\2\2\u01fd\u01fe\5Z.\2\u01feY\3\2\2\2\u01ff\u0207\5^"+
		"\60\2\u0200\u0207\5`\61\2\u0201\u0207\5b\62\2\u0202\u0207\5d\63\2\u0203"+
		"\u0207\5l\67\2\u0204\u0207\5j\66\2\u0205\u0207\5n8\2\u0206\u01ff\3\2\2"+
		"\2\u0206\u0200\3\2\2\2\u0206\u0201\3\2\2\2\u0206\u0202\3\2\2\2\u0206\u0203"+
		"\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0205\3\2\2\2\u0207[\3\2\2\2\u0208"+
		"\u020b\5f\64\2\u0209\u020b\5h\65\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2"+
		"\2\2\u020b]\3\2\2\2\u020c\u020d\7\16\2\2\u020d\u020f\7\34\2\2\u020e\u020c"+
		"\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\7\23\2\2"+
		"\u0211_\3\2\2\2\u0212\u0214\t\13\2\2\u0213\u0212\3\2\2\2\u0213\u0214\3"+
		"\2\2\2\u0214\u0216\3\2\2\2\u0215\u0217\7\34\2\2\u0216\u0215\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7\23\2\2\u0219\u021a\7"+
		"\20\2\2\u021aa\3\2\2\2\u021b\u021d\7\21\2\2\u021c\u021e\7\34\2\2\u021d"+
		"\u021c\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\7\23"+
		"\2\2\u0220\u0222\7\20\2\2\u0221\u0220\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\3\2\2\2\u0223\u0224\7\27\2\2\u0224c\3\2\2\2\u0225\u0227\t\f\2\2"+
		"\u0226\u0228\7\34\2\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022a"+
		"\3\2\2\2\u0229\u022b\t\r\2\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2\2\u022b"+
		"\u022d\3\2\2\2\u022c\u022e\5\"\22\2\u022d\u022c\3\2\2\2\u022d\u022e\3"+
		"\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\7\20\2\2\u0230e\3\2\2\2\u0231\u0233"+
		"\7\21\2\2\u0232\u0234\7\34\2\2\u0233\u0232\3\2\2\2\u0233\u0234\3\2\2\2"+
		"\u0234g\3\2\2\2\u0235\u0237\7\21\2\2\u0236\u0235\3\2\2\2\u0236\u0237\3"+
		"\2\2\2\u0237\u0239\3\2\2\2\u0238\u023a\7\34\2\2\u0239\u0238\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\7-\2\2\u023ci\3\2\2\2\u023d"+
		"\u023f\7\16\2\2\u023e\u0240\7\34\2\2\u023f\u023e\3\2\2\2\u023f\u0240\3"+
		"\2\2\2\u0240k\3\2\2\2\u0241\u0243\7\17\2\2\u0242\u0244\7\34\2\2\u0243"+
		"\u0242\3\2\2\2\u0243\u0244\3\2\2\2\u0244m\3\2\2\2\u0245\u0247\7\16\2\2"+
		"\u0246\u0245\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0249\3\2\2\2\u0248\u024a"+
		"\7\34\2\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024b\3\2\2\2"+
		"\u024b\u024c\7\17\2\2\u024co\3\2\2\2\u024d\u024e\5L\'\2\u024e\u024f\5"+
		" \21\2\u024fq\3\2\2\2\u0250\u0251\5L\'\2\u0251\u0252\5$\23\2\u0252s\3"+
		"\2\2\2\u0253\u0254\5L\'\2\u0254\u0255\5*\26\2\u0255u\3\2\2\2\u0256\u0257"+
		"\5L\'\2\u0257\u0258\5,\27\2\u0258w\3\2\2\2\u0259\u025c\5p9\2\u025a\u025c"+
		"\5v<\2\u025b\u0259\3\2\2\2\u025b\u025a\3\2\2\2\u025cy\3\2\2\2\u025d\u025e"+
		"\5L\'\2\u025e\u025f\7\65\2\2\u025f{\3\2\2\2\u0260\u0266\5p9\2\u0261\u0266"+
		"\5r:\2\u0262\u0266\5t;\2\u0263\u0266\5v<\2\u0264\u0266\5z>\2\u0265\u0260"+
		"\3\2\2\2\u0265\u0261\3\2\2\2\u0265\u0262\3\2\2\2\u0265\u0263\3\2\2\2\u0265"+
		"\u0264\3\2\2\2\u0266}\3\2\2\2\u0267\u0268\5N(\2\u0268\u0269\5\62\32\2"+
		"\u0269\177\3\2\2\2\u026a\u026b\5V,\2\u026b\u026c\58\35\2\u026c\u0081\3"+
		"\2\2\2\u026d\u026e\5N(\2\u026e\u026f\5> \2\u026f\u0083\3\2\2\2\u0270\u0271"+
		"\5N(\2\u0271\u0272\5@!\2\u0272\u0085\3\2\2\2\u0273\u0277\5~@\2\u0274\u0277"+
		"\5\u0082B\2\u0275\u0277\5\u0084C\2\u0276\u0273\3\2\2\2\u0276\u0274\3\2"+
		"\2\2\u0276\u0275\3\2\2\2\u0277\u0087\3\2\2\2\u0278\u027b\5|?\2\u0279\u027b"+
		"\5\u0080A\2\u027a\u0278\3\2\2\2\u027a\u0279\3\2\2\2\u027b\u0089\3\2\2"+
		"\2\u027c\u027f\5\60\31\2\u027d\u027f\5|?\2\u027e\u027c\3\2\2\2\u027e\u027d"+
		"\3\2\2\2\u027f\u008b\3\2\2\2\u0280\u0285\5D#\2\u0281\u0285\5\u0086D\2"+
		"\u0282\u0285\5\u0080A\2\u0283\u0285\5\64\33\2\u0284\u0280\3\2\2\2\u0284"+
		"\u0281\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0283\3\2\2\2\u0285\u008d\3\2"+
		"\2\2\u0286\u028c\5\u008aF\2\u0287\u028c\5\u008cG\2\u0288\u028c\7\24\2"+
		"\2\u0289\u028c\7\26\2\2\u028a\u028c\7\n\2\2\u028b\u0286\3\2\2\2\u028b"+
		"\u0287\3\2\2\2\u028b\u0288\3\2\2\2\u028b\u0289\3\2\2\2\u028b\u028a\3\2"+
		"\2\2\u028c\u028d\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e"+
		"\u008f\3\2\2\2\u028f\u0291\13\2\2\2\u0290\u028f\3\2\2\2\u0291\u0294\3"+
		"\2\2\2\u0292\u0293\3\2\2\2\u0292\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294"+
		"\u0292\3\2\2\2\u0295\u0297\7\4\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2"+
		"\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029d\3\2\2\2\u029a"+
		"\u029c\13\2\2\2\u029b\u029a\3\2\2\2\u029c\u029f\3\2\2\2\u029d\u029e\3"+
		"\2\2\2\u029d\u029b\3\2\2\2\u029e\u0091\3\2\2\2\u029f\u029d\3\2\2\2\u02a0"+
		"\u02a2\13\2\2\2\u02a1\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a4\3"+
		"\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u0093\3\2\2\2\u02a5\u02a3\3\2\2\2_\u009d"+
		"\u009f\u00ac\u00b0\u00b5\u00c8\u00ca\u00cf\u00d3\u00d8\u00db\u00df\u00e1"+
		"\u00ea\u00ec\u00f1\u00f5\u00fa\u00fd\u0101\u0103\u010c\u010e\u0113\u0117"+
		"\u011c\u011f\u0123\u0125\u012e\u0130\u013b\u013d\u0148\u014a\u0157\u015a"+
		"\u015d\u0160\u016a\u016d\u0172\u0175\u017c\u0181\u0189\u0190\u0194\u019a"+
		"\u019d\u01a3\u01a9\u01ae\u01b1\u01b9\u01bf\u01c9\u01cd\u01d3\u01d8\u01de"+
		"\u01e8\u01eb\u01f7\u0206\u020a\u020e\u0213\u0216\u021d\u0221\u0227\u022a"+
		"\u022d\u0233\u0236\u0239\u023f\u0243\u0246\u0249\u025b\u0265\u0276\u027a"+
		"\u027e\u0284\u028b\u028d\u0292\u0298\u029d\u02a3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}