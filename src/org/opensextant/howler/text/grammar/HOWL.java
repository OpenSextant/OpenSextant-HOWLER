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
		ADJECTIVE=1, BADWORD=2, COMMON_NOUN=3, QUOTED_TEXT=4, OPEN=5, CLOSE=6, 
		PERIOD=7, COMMA=8, NUMBER=9, INTEGER=10, DECIMAL=11, DOES=12, DASH=13, 
		HAS=14, PARTICLE=15, IS=16, PROPER_NOUN=17, PREDICATE=18, AND=19, EXCLUSIVELY=20, 
		OR=21, BY=22, ONLY=23, NO=24, NOT=25, A=26, EVERY=27, EXACT=28, LESS_THAN=29, 
		LESS_THAN_OR_EQUAL=30, MORE_THAN=31, MORE_THAN_OR_EQUAL=32, DATA_FACET=33, 
		SOME=34, THE=35, EITHER=36, BOTH=37, SAME_AS=38, INVERSE_OF=39, THAT=40, 
		OBJECT_SCOPE=41, DATA_SCOPE=42, ANNOTATION_MARKER=43, ANNOTATION_SPLIT=44, 
		DATATYPE=45, ITSELF=46, TO=47, PREDICATE_CHARACTERISTIC=48, QUOTE=49, 
		WORD_TYPE=50, THING=51, DATA_THING=52, AMBIG_WORD=53;
	public static final int
		RULE_document = 0, RULE_statement = 1, RULE_debug = 2, RULE_factStatementData = 3, 
		RULE_factStatementObject = 4, RULE_descriptionStatementObject = 5, RULE_descriptionStatementDataType = 6, 
		RULE_domainStatementDataType = 7, RULE_domainStatementObject = 8, RULE_domainStatementAnnotation = 9, 
		RULE_rangeStatementDataType = 10, RULE_rangeStatementObject = 11, RULE_rangeStatementAnnotation = 12, 
		RULE_predicateCharacteristicStatement = 13, RULE_predicateRelationStatement = 14, 
		RULE_annotationStatement = 15, RULE_declarationStatement = 16, RULE_compoundNounPhrase = 17, 
		RULE_properNounPhrase = 18, RULE_nProperSequence = 19, RULE_commonNounPhrase = 20, 
		RULE_adjp = 21, RULE_dataTypeExpression = 22, RULE_dataTypeRestriction = 23, 
		RULE_dataFacetExpression = 24, RULE_dataValuePhrase = 25, RULE_dataValue = 26, 
		RULE_quant = 27, RULE_quantNumeric = 28, RULE_quantNumericExpression = 29, 
		RULE_predicateExpressionObject = 30, RULE_predicateExpressionData = 31, 
		RULE_predicateExpressionAnnotation = 32, RULE_predicateExpressionVerbData = 33, 
		RULE_predicateExpression = 34, RULE_predicateExpressionVerb = 35, RULE_predicateExpressionState = 36, 
		RULE_predicateExpressionSimple = 37, RULE_predicateExpressionParticle = 38, 
		RULE_predicateExpressionPassive = 39, RULE_predicateExpressionNoun = 40, 
		RULE_predicateExpressionSameAs = 41, RULE_predicateExpressionBE = 42, 
		RULE_predicateExpressionDO = 43, RULE_predicateExpressionHAS = 44, RULE_predicate = 45, 
		RULE_predicatePhraseNoun = 46, RULE_predicatePhraseDataType = 47, RULE_predicatePhraseDataValue = 48, 
		RULE_predicatePhrase = 49, RULE_singlePhraseObject = 50, RULE_singlePhraseData = 51, 
		RULE_catchSet = 52, RULE_badSentence = 53, RULE_wordSequence = 54, RULE_debugWordSequence = 55;
	public static final String[] ruleNames = {
		"document", "statement", "debug", "factStatementData", "factStatementObject", 
		"descriptionStatementObject", "descriptionStatementDataType", "domainStatementDataType", 
		"domainStatementObject", "domainStatementAnnotation", "rangeStatementDataType", 
		"rangeStatementObject", "rangeStatementAnnotation", "predicateCharacteristicStatement", 
		"predicateRelationStatement", "annotationStatement", "declarationStatement", 
		"compoundNounPhrase", "properNounPhrase", "nProperSequence", "commonNounPhrase", 
		"adjp", "dataTypeExpression", "dataTypeRestriction", "dataFacetExpression", 
		"dataValuePhrase", "dataValue", "quant", "quantNumeric", "quantNumericExpression", 
		"predicateExpressionObject", "predicateExpressionData", "predicateExpressionAnnotation", 
		"predicateExpressionVerbData", "predicateExpression", "predicateExpressionVerb", 
		"predicateExpressionState", "predicateExpressionSimple", "predicateExpressionParticle", 
		"predicateExpressionPassive", "predicateExpressionNoun", "predicateExpressionSameAs", 
		"predicateExpressionBE", "predicateExpressionDO", "predicateExpressionHAS", 
		"predicate", "predicatePhraseNoun", "predicatePhraseDataType", "predicatePhraseDataValue", 
		"predicatePhrase", "singlePhraseObject", "singlePhraseData", "catchSet", 
		"badSentence", "wordSequence", "debugWordSequence"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADJECTIVE", "BADWORD", "COMMON_NOUN", "QUOTED_TEXT", "OPEN", "CLOSE", 
		"PERIOD", "COMMA", "NUMBER", "INTEGER", "DECIMAL", "DOES", "DASH", "HAS", 
		"PARTICLE", "IS", "PROPER_NOUN", "PREDICATE", "AND", "EXCLUSIVELY", "OR", 
		"BY", "ONLY", "NO", "NOT", "A", "EVERY", "EXACT", "LESS_THAN", "LESS_THAN_OR_EQUAL", 
		"MORE_THAN", "MORE_THAN_OR_EQUAL", "DATA_FACET", "SOME", "THE", "EITHER", 
		"BOTH", "SAME_AS", "INVERSE_OF", "THAT", "OBJECT_SCOPE", "DATA_SCOPE", 
		"ANNOTATION_MARKER", "ANNOTATION_SPLIT", "DATATYPE", "ITSELF", "TO", "PREDICATE_CHARACTERISTIC", 
		"QUOTE", "WORD_TYPE", "THING", "DATA_THING", "AMBIG_WORD"
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
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(118);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					{
					setState(112);
					statement();
					setState(113);
					match(PERIOD);
					}
					}
					break;
				case 2:
					{
					{
					setState(115);
					debug();
					setState(116);
					match(PERIOD);
					}
					}
					break;
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << BADWORD) | (1L << COMMON_NOUN) | (1L << QUOTED_TEXT) | (1L << OPEN) | (1L << CLOSE) | (1L << PERIOD) | (1L << COMMA) | (1L << NUMBER) | (1L << INTEGER) | (1L << DECIMAL) | (1L << DOES) | (1L << DASH) | (1L << HAS) | (1L << PARTICLE) | (1L << IS) | (1L << PROPER_NOUN) | (1L << PREDICATE) | (1L << AND) | (1L << EXCLUSIVELY) | (1L << OR) | (1L << BY) | (1L << ONLY) | (1L << NO) | (1L << NOT) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << DATA_FACET) | (1L << SOME) | (1L << THE) | (1L << EITHER) | (1L << BOTH) | (1L << SAME_AS) | (1L << INVERSE_OF) | (1L << THAT) | (1L << OBJECT_SCOPE) | (1L << DATA_SCOPE) | (1L << ANNOTATION_MARKER) | (1L << ANNOTATION_SPLIT) | (1L << DATATYPE) | (1L << ITSELF) | (1L << TO) | (1L << PREDICATE_CHARACTERISTIC) | (1L << QUOTE) | (1L << WORD_TYPE) | (1L << THING) | (1L << DATA_THING) | (1L << AMBIG_WORD))) != 0) );
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
		public DomainStatementObjectContext domainStatementObject() {
			return getRuleContext(DomainStatementObjectContext.class,0);
		}
		public DomainStatementDataTypeContext domainStatementDataType() {
			return getRuleContext(DomainStatementDataTypeContext.class,0);
		}
		public RangeStatementObjectContext rangeStatementObject() {
			return getRuleContext(RangeStatementObjectContext.class,0);
		}
		public RangeStatementDataTypeContext rangeStatementDataType() {
			return getRuleContext(RangeStatementDataTypeContext.class,0);
		}
		public DescriptionStatementObjectContext descriptionStatementObject() {
			return getRuleContext(DescriptionStatementObjectContext.class,0);
		}
		public DescriptionStatementDataTypeContext descriptionStatementDataType() {
			return getRuleContext(DescriptionStatementDataTypeContext.class,0);
		}
		public AnnotationStatementContext annotationStatement() {
			return getRuleContext(AnnotationStatementContext.class,0);
		}
		public DeclarationStatementContext declarationStatement() {
			return getRuleContext(DeclarationStatementContext.class,0);
		}
		public PredicateCharacteristicStatementContext predicateCharacteristicStatement() {
			return getRuleContext(PredicateCharacteristicStatementContext.class,0);
		}
		public PredicateRelationStatementContext predicateRelationStatement() {
			return getRuleContext(PredicateRelationStatementContext.class,0);
		}
		public DomainStatementAnnotationContext domainStatementAnnotation() {
			return getRuleContext(DomainStatementAnnotationContext.class,0);
		}
		public RangeStatementAnnotationContext rangeStatementAnnotation() {
			return getRuleContext(RangeStatementAnnotationContext.class,0);
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
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				factStatementObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				factStatementData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				domainStatementObject();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				domainStatementDataType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				rangeStatementObject();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				rangeStatementDataType();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				descriptionStatementObject();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				descriptionStatementDataType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
				annotationStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(131);
				declarationStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(132);
				predicateCharacteristicStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(133);
				predicateRelationStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(134);
				domainStatementAnnotation();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(135);
				rangeStatementAnnotation();
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
		public SinglePhraseObjectContext singlePhraseObject() {
			return getRuleContext(SinglePhraseObjectContext.class,0);
		}
		public SinglePhraseDataContext singlePhraseData() {
			return getRuleContext(SinglePhraseDataContext.class,0);
		}
		public CatchSetContext catchSet() {
			return getRuleContext(CatchSetContext.class,0);
		}
		public BadSentenceContext badSentence() {
			return getRuleContext(BadSentenceContext.class,0);
		}
		public DebugWordSequenceContext debugWordSequence() {
			return getRuleContext(DebugWordSequenceContext.class,0);
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
		enterRule(_localctx, 4, RULE_debug);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				singlePhraseObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				singlePhraseData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				catchSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				badSentence();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				debugWordSequence();
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
		enterRule(_localctx, 6, RULE_factStatementData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			properNounPhrase();
			setState(146);
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
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
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
		enterRule(_localctx, 8, RULE_factStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			properNounPhrase();
			setState(149);
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

	public static class DescriptionStatementObjectContext extends ParserRuleContext {
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
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
		enterRule(_localctx, 10, RULE_descriptionStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			compoundNounPhrase();
			setState(152);
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
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public PredicateExpressionStateContext predicateExpressionState() {
			return getRuleContext(PredicateExpressionStateContext.class,0);
		}
		public DataTypeExpressionContext dataTypeExpression() {
			return getRuleContext(DataTypeExpressionContext.class,0);
		}
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
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
		enterRule(_localctx, 12, RULE_descriptionStatementDataType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(A);
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==DATATYPE || _la==AMBIG_WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
			predicateExpressionState();
			setState(157);
			dataTypeExpression();
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

	public static class DomainStatementDataTypeContext extends ParserRuleContext {
		public PredicateExpressionDataContext pred;
		public CompoundNounPhraseContext domain;
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public TerminalNode DATA_THING() { return getToken(HOWL.DATA_THING, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public DomainStatementDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainStatementDataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDomainStatementDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainStatementDataTypeContext domainStatementDataType() throws RecognitionException {
		DomainStatementDataTypeContext _localctx = new DomainStatementDataTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_domainStatementDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(EVERY);
			setState(160);
			match(THING);
			setState(161);
			match(THAT);
			setState(162);
			((DomainStatementDataTypeContext)_localctx).pred = predicateExpressionData();
			setState(163);
			match(SOME);
			setState(164);
			match(DATA_THING);
			setState(165);
			match(IS);
			setState(166);
			((DomainStatementDataTypeContext)_localctx).domain = compoundNounPhrase();
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

	public static class DomainStatementObjectContext extends ParserRuleContext {
		public PredicateExpressionObjectContext pred;
		public CompoundNounPhraseContext domain;
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public List<TerminalNode> THING() { return getTokens(HOWL.THING); }
		public TerminalNode THING(int i) {
			return getToken(HOWL.THING, i);
		}
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public DomainStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDomainStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainStatementObjectContext domainStatementObject() throws RecognitionException {
		DomainStatementObjectContext _localctx = new DomainStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_domainStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(EVERY);
			setState(169);
			match(THING);
			setState(170);
			match(THAT);
			setState(171);
			((DomainStatementObjectContext)_localctx).pred = predicateExpressionObject();
			setState(172);
			match(SOME);
			setState(173);
			match(THING);
			setState(174);
			match(IS);
			setState(175);
			((DomainStatementObjectContext)_localctx).domain = compoundNounPhrase();
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

	public static class DomainStatementAnnotationContext extends ParserRuleContext {
		public PredicateExpressionAnnotationContext pred;
		public WordSequenceContext domain;
		public TerminalNode ANNOTATION_MARKER() { return getToken(HOWL.ANNOTATION_MARKER, 0); }
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public List<TerminalNode> THING() { return getTokens(HOWL.THING); }
		public TerminalNode THING(int i) {
			return getToken(HOWL.THING, i);
		}
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public PredicateExpressionAnnotationContext predicateExpressionAnnotation() {
			return getRuleContext(PredicateExpressionAnnotationContext.class,0);
		}
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public DomainStatementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainStatementAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDomainStatementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainStatementAnnotationContext domainStatementAnnotation() throws RecognitionException {
		DomainStatementAnnotationContext _localctx = new DomainStatementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_domainStatementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ANNOTATION_MARKER);
			setState(178);
			match(EVERY);
			setState(179);
			match(THING);
			setState(180);
			match(THAT);
			setState(181);
			((DomainStatementAnnotationContext)_localctx).pred = predicateExpressionAnnotation();
			setState(182);
			match(SOME);
			setState(183);
			match(THING);
			setState(184);
			match(IS);
			setState(185);
			match(A);
			setState(186);
			((DomainStatementAnnotationContext)_localctx).domain = wordSequence();
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

	public static class RangeStatementDataTypeContext extends ParserRuleContext {
		public PredicateExpressionDataContext pred;
		public DataTypeExpressionContext range;
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public List<TerminalNode> THING() { return getTokens(HOWL.THING); }
		public TerminalNode THING(int i) {
			return getToken(HOWL.THING, i);
		}
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public DataTypeExpressionContext dataTypeExpression() {
			return getRuleContext(DataTypeExpressionContext.class,0);
		}
		public RangeStatementDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeStatementDataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitRangeStatementDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeStatementDataTypeContext rangeStatementDataType() throws RecognitionException {
		RangeStatementDataTypeContext _localctx = new RangeStatementDataTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rangeStatementDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(EVERY);
			setState(189);
			match(THING);
			setState(190);
			match(IS);
			setState(191);
			match(A);
			setState(192);
			match(THING);
			setState(193);
			match(THAT);
			setState(194);
			((RangeStatementDataTypeContext)_localctx).pred = predicateExpressionData();
			setState(195);
			((RangeStatementDataTypeContext)_localctx).range = dataTypeExpression();
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

	public static class RangeStatementObjectContext extends ParserRuleContext {
		public PredicateExpressionObjectContext pred;
		public CompoundNounPhraseContext range;
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public List<TerminalNode> THING() { return getTokens(HOWL.THING); }
		public TerminalNode THING(int i) {
			return getToken(HOWL.THING, i);
		}
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public RangeStatementObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeStatementObject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitRangeStatementObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeStatementObjectContext rangeStatementObject() throws RecognitionException {
		RangeStatementObjectContext _localctx = new RangeStatementObjectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rangeStatementObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(EVERY);
			setState(198);
			match(THING);
			setState(199);
			match(IS);
			setState(200);
			match(A);
			setState(201);
			match(THING);
			setState(202);
			match(THAT);
			setState(203);
			((RangeStatementObjectContext)_localctx).pred = predicateExpressionObject();
			setState(204);
			((RangeStatementObjectContext)_localctx).range = compoundNounPhrase();
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

	public static class RangeStatementAnnotationContext extends ParserRuleContext {
		public PredicateExpressionAnnotationContext pred;
		public WordSequenceContext range;
		public TerminalNode ANNOTATION_MARKER() { return getToken(HOWL.ANNOTATION_MARKER, 0); }
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public List<TerminalNode> THING() { return getTokens(HOWL.THING); }
		public TerminalNode THING(int i) {
			return getToken(HOWL.THING, i);
		}
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public List<TerminalNode> A() { return getTokens(HOWL.A); }
		public TerminalNode A(int i) {
			return getToken(HOWL.A, i);
		}
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public PredicateExpressionAnnotationContext predicateExpressionAnnotation() {
			return getRuleContext(PredicateExpressionAnnotationContext.class,0);
		}
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public RangeStatementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeStatementAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitRangeStatementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeStatementAnnotationContext rangeStatementAnnotation() throws RecognitionException {
		RangeStatementAnnotationContext _localctx = new RangeStatementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rangeStatementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(ANNOTATION_MARKER);
			setState(207);
			match(EVERY);
			setState(208);
			match(THING);
			setState(209);
			match(IS);
			setState(210);
			match(A);
			setState(211);
			match(THING);
			setState(212);
			match(THAT);
			setState(213);
			((RangeStatementAnnotationContext)_localctx).pred = predicateExpressionAnnotation();
			setState(214);
			match(A);
			setState(215);
			((RangeStatementAnnotationContext)_localctx).range = wordSequence();
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

	public static class PredicateCharacteristicStatementContext extends ParserRuleContext {
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public TerminalNode WORD_TYPE() { return getToken(HOWL.WORD_TYPE, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode PREDICATE_CHARACTERISTIC() { return getToken(HOWL.PREDICATE_CHARACTERISTIC, 0); }
		public PredicateCharacteristicStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateCharacteristicStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateCharacteristicStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateCharacteristicStatementContext predicateCharacteristicStatement() throws RecognitionException {
		PredicateCharacteristicStatementContext _localctx = new PredicateCharacteristicStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_predicateCharacteristicStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(THE);
			setState(218);
			wordSequence();
			setState(219);
			match(WORD_TYPE);
			setState(220);
			match(IS);
			setState(221);
			match(PREDICATE_CHARACTERISTIC);
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

	public static class PredicateRelationStatementContext extends ParserRuleContext {
		public WordSequenceContext subj;
		public Token relIS;
		public Token relSame;
		public Token relInv;
		public WordSequenceContext obj;
		public List<TerminalNode> THE() { return getTokens(HOWL.THE); }
		public TerminalNode THE(int i) {
			return getToken(HOWL.THE, i);
		}
		public List<TerminalNode> WORD_TYPE() { return getTokens(HOWL.WORD_TYPE); }
		public TerminalNode WORD_TYPE(int i) {
			return getToken(HOWL.WORD_TYPE, i);
		}
		public List<WordSequenceContext> wordSequence() {
			return getRuleContexts(WordSequenceContext.class);
		}
		public WordSequenceContext wordSequence(int i) {
			return getRuleContext(WordSequenceContext.class,i);
		}
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
		public TerminalNode INVERSE_OF() { return getToken(HOWL.INVERSE_OF, 0); }
		public PredicateRelationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateRelationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicateRelationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateRelationStatementContext predicateRelationStatement() throws RecognitionException {
		PredicateRelationStatementContext _localctx = new PredicateRelationStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_predicateRelationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(THE);
			setState(224);
			((PredicateRelationStatementContext)_localctx).subj = wordSequence();
			setState(225);
			match(WORD_TYPE);
			setState(226);
			((PredicateRelationStatementContext)_localctx).relIS = match(IS);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(227);
				match(NOT);
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SAME_AS) {
				{
				setState(230);
				((PredicateRelationStatementContext)_localctx).relSame = match(SAME_AS);
				}
			}

			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INVERSE_OF) {
				{
				setState(233);
				((PredicateRelationStatementContext)_localctx).relInv = match(INVERSE_OF);
				}
			}

			setState(236);
			match(THE);
			setState(237);
			((PredicateRelationStatementContext)_localctx).obj = wordSequence();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD_TYPE) {
				{
				setState(238);
				match(WORD_TYPE);
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

	public static class AnnotationStatementContext extends ParserRuleContext {
		public WordSequenceContext subj;
		public WordSequenceContext rel;
		public DataValueContext objValue;
		public WordSequenceContext objWord;
		public TerminalNode ANNOTATION_MARKER() { return getToken(HOWL.ANNOTATION_MARKER, 0); }
		public List<TerminalNode> ANNOTATION_SPLIT() { return getTokens(HOWL.ANNOTATION_SPLIT); }
		public TerminalNode ANNOTATION_SPLIT(int i) {
			return getToken(HOWL.ANNOTATION_SPLIT, i);
		}
		public List<WordSequenceContext> wordSequence() {
			return getRuleContexts(WordSequenceContext.class);
		}
		public WordSequenceContext wordSequence(int i) {
			return getRuleContext(WordSequenceContext.class,i);
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
		enterRule(_localctx, 30, RULE_annotationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ANNOTATION_MARKER);
			setState(242);
			((AnnotationStatementContext)_localctx).subj = wordSequence();
			setState(243);
			match(ANNOTATION_SPLIT);
			setState(244);
			((AnnotationStatementContext)_localctx).rel = wordSequence();
			setState(245);
			match(ANNOTATION_SPLIT);
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(246);
				((AnnotationStatementContext)_localctx).objValue = dataValue();
				}
				break;
			case 2:
				{
				setState(247);
				((AnnotationStatementContext)_localctx).objWord = wordSequence();
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

	public static class DeclarationStatementContext extends ParserRuleContext {
		public WordSequenceContext subj;
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode WORD_TYPE() { return getToken(HOWL.WORD_TYPE, 0); }
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public DeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationStatementContext declarationStatement() throws RecognitionException {
		DeclarationStatementContext _localctx = new DeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			((DeclarationStatementContext)_localctx).subj = wordSequence();
			setState(251);
			match(IS);
			setState(252);
			match(A);
			setState(253);
			match(WORD_TYPE);
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

	public static class CompoundNounPhraseContext extends ParserRuleContext {
		public CompoundNounPhraseContext setIntersection;
		public CompoundNounPhraseContext setUnion;
		public CompoundNounPhraseContext disjointUnion;
		public ProperNounPhraseContext proper;
		public CommonNounPhraseContext common;
		public Token itself;
		public TerminalNode BOTH() { return getToken(HOWL.BOTH, 0); }
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<CompoundNounPhraseContext> compoundNounPhrase() {
			return getRuleContexts(CompoundNounPhraseContext.class);
		}
		public CompoundNounPhraseContext compoundNounPhrase(int i) {
			return getRuleContext(CompoundNounPhraseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public TerminalNode EITHER() { return getToken(HOWL.EITHER, 0); }
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public TerminalNode EXCLUSIVELY() { return getToken(HOWL.EXCLUSIVELY, 0); }
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public TerminalNode ITSELF() { return getToken(HOWL.ITSELF, 0); }
		public CompoundNounPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundNounPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitCompoundNounPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundNounPhraseContext compoundNounPhrase() throws RecognitionException {
		CompoundNounPhraseContext _localctx = new CompoundNounPhraseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compoundNounPhrase);
		int _la;
		try {
			int _alt;
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(BOTH);
				setState(256);
				((CompoundNounPhraseContext)_localctx).setIntersection = compoundNounPhrase();
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(257);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						compoundNounPhrase();
						}
						} 
					}
					setState(263);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(264);
				match(AND);
				setState(265);
				compoundNounPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(EITHER);
				setState(268);
				((CompoundNounPhraseContext)_localctx).setUnion = compoundNounPhrase();
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(269);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						compoundNounPhrase();
						}
						} 
					}
					setState(275);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(276);
				match(OR);
				setState(277);
				compoundNounPhrase();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(279);
				match(EXCLUSIVELY);
				setState(280);
				match(EITHER);
				setState(281);
				((CompoundNounPhraseContext)_localctx).disjointUnion = compoundNounPhrase();
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(282);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(283);
						compoundNounPhrase();
						}
						} 
					}
					setState(288);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(289);
				match(OR);
				setState(290);
				compoundNounPhrase();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				((CompoundNounPhraseContext)_localctx).proper = properNounPhrase();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(293);
				((CompoundNounPhraseContext)_localctx).common = commonNounPhrase();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(294);
				((CompoundNounPhraseContext)_localctx).itself = match(ITSELF);
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

	public static class ProperNounPhraseContext extends ParserRuleContext {
		public NProperSequenceContext nProperSequence() {
			return getRuleContext(NProperSequenceContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
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
		enterRule(_localctx, 36, RULE_properNounPhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(297);
				match(NOT);
				}
			}

			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THE) {
				{
				setState(300);
				match(THE);
				}
			}

			setState(303);
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
		public List<TerminalNode> PROPER_NOUN() { return getTokens(HOWL.PROPER_NOUN); }
		public TerminalNode PROPER_NOUN(int i) {
			return getToken(HOWL.PROPER_NOUN, i);
		}
		public List<TerminalNode> AMBIG_WORD() { return getTokens(HOWL.AMBIG_WORD); }
		public TerminalNode AMBIG_WORD(int i) {
			return getToken(HOWL.AMBIG_WORD, i);
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
		enterRule(_localctx, 38, RULE_nProperSequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(305);
					_la = _input.LA(1);
					if ( !(_la==PROPER_NOUN || _la==AMBIG_WORD) ) {
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
				setState(308); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class CommonNounPhraseContext extends ParserRuleContext {
		public TerminalNode COMMON_NOUN() { return getToken(HOWL.COMMON_NOUN, 0); }
		public TerminalNode ADJECTIVE() { return getToken(HOWL.ADJECTIVE, 0); }
		public TerminalNode PROPER_NOUN() { return getToken(HOWL.PROPER_NOUN, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
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
		public List<PredicatePhraseContext> predicatePhrase() {
			return getRuleContexts(PredicatePhraseContext.class);
		}
		public PredicatePhraseContext predicatePhrase(int i) {
			return getRuleContext(PredicatePhraseContext.class,i);
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
		enterRule(_localctx, 40, RULE_commonNounPhrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(310);
				match(NOT);
				}
			}

			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
				{
				setState(313);
				quant();
				}
			}

			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(316);
				adjp();
				}
				break;
			}
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << COMMON_NOUN) | (1L << PROPER_NOUN) | (1L << THING) | (1L << AMBIG_WORD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(320);
				match(THAT);
				setState(321);
				predicatePhrase();
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(322);
						match(AND);
						setState(323);
						match(THAT);
						setState(324);
						predicatePhrase();
						}
						} 
					}
					setState(329);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class AdjpContext extends ParserRuleContext {
		public List<TerminalNode> COMMON_NOUN() { return getTokens(HOWL.COMMON_NOUN); }
		public TerminalNode COMMON_NOUN(int i) {
			return getToken(HOWL.COMMON_NOUN, i);
		}
		public List<TerminalNode> PROPER_NOUN() { return getTokens(HOWL.PROPER_NOUN); }
		public TerminalNode PROPER_NOUN(int i) {
			return getToken(HOWL.PROPER_NOUN, i);
		}
		public List<TerminalNode> AMBIG_WORD() { return getTokens(HOWL.AMBIG_WORD); }
		public TerminalNode AMBIG_WORD(int i) {
			return getToken(HOWL.AMBIG_WORD, i);
		}
		public List<TerminalNode> ADJECTIVE() { return getTokens(HOWL.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(HOWL.ADJECTIVE, i);
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
		enterRule(_localctx, 42, RULE_adjp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(333); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(332);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << COMMON_NOUN) | (1L << PROPER_NOUN) | (1L << AMBIG_WORD))) != 0)) ) {
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
				setState(335); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class DataTypeExpressionContext extends ParserRuleContext {
		public DataTypeExpressionContext setUnion;
		public DataTypeExpressionContext setIntersection;
		public Token dt;
		public Token th;
		public Token ambig;
		public DataTypeExpressionContext comp;
		public DataTypeRestrictionContext rest;
		public DataValuePhraseContext dv;
		public TerminalNode EITHER() { return getToken(HOWL.EITHER, 0); }
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<DataTypeExpressionContext> dataTypeExpression() {
			return getRuleContexts(DataTypeExpressionContext.class);
		}
		public DataTypeExpressionContext dataTypeExpression(int i) {
			return getRuleContext(DataTypeExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public TerminalNode BOTH() { return getToken(HOWL.BOTH, 0); }
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public TerminalNode DATA_THING() { return getToken(HOWL.DATA_THING, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
		public DataTypeRestrictionContext dataTypeRestriction() {
			return getRuleContext(DataTypeRestrictionContext.class,0);
		}
		public DataValuePhraseContext dataValuePhrase() {
			return getRuleContext(DataValuePhraseContext.class,0);
		}
		public DataTypeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataTypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeExpressionContext dataTypeExpression() throws RecognitionException {
		DataTypeExpressionContext _localctx = new DataTypeExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dataTypeExpression);
		int _la;
		try {
			int _alt;
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(EITHER);
				setState(338);
				((DataTypeExpressionContext)_localctx).setUnion = dataTypeExpression();
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(339);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(340);
						dataTypeExpression();
						}
						} 
					}
					setState(345);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(346);
				match(OR);
				setState(347);
				dataTypeExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(BOTH);
				setState(350);
				((DataTypeExpressionContext)_localctx).setIntersection = dataTypeExpression();
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(351);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==AND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(352);
						dataTypeExpression();
						}
						} 
					}
					setState(357);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(358);
				match(AND);
				setState(359);
				dataTypeExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(361);
					match(NOT);
					}
				}

				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
					{
					setState(364);
					quant();
					}
				}

				setState(370);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DATATYPE:
					{
					setState(367);
					((DataTypeExpressionContext)_localctx).dt = match(DATATYPE);
					}
					break;
				case DATA_THING:
					{
					setState(368);
					((DataTypeExpressionContext)_localctx).th = match(DATA_THING);
					}
					break;
				case AMBIG_WORD:
					{
					setState(369);
					((DataTypeExpressionContext)_localctx).ambig = match(AMBIG_WORD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(372);
				match(NOT);
				setState(373);
				((DataTypeExpressionContext)_localctx).comp = dataTypeExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				((DataTypeExpressionContext)_localctx).rest = dataTypeRestriction();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(375);
				((DataTypeExpressionContext)_localctx).dv = dataValuePhrase();
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

	public static class DataTypeRestrictionContext extends ParserRuleContext {
		public List<DataFacetExpressionContext> dataFacetExpression() {
			return getRuleContexts(DataFacetExpressionContext.class);
		}
		public DataFacetExpressionContext dataFacetExpression(int i) {
			return getRuleContext(DataFacetExpressionContext.class,i);
		}
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
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
		enterRule(_localctx, 46, RULE_dataTypeRestriction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(378);
				match(NOT);
				}
			}

			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
				{
				setState(381);
				quant();
				}
			}

			setState(384);
			_la = _input.LA(1);
			if ( !(_la==DATATYPE || _la==AMBIG_WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(385);
			dataFacetExpression();
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(386);
					match(AND);
					setState(387);
					dataFacetExpression();
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public static class DataFacetExpressionContext extends ParserRuleContext {
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public TerminalNode DATA_FACET() { return getToken(HOWL.DATA_FACET, 0); }
		public QuantNumericContext quantNumeric() {
			return getRuleContext(QuantNumericContext.class,0);
		}
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode HAS() { return getToken(HOWL.HAS, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public DataFacetExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataFacetExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDataFacetExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataFacetExpressionContext dataFacetExpression() throws RecognitionException {
		DataFacetExpressionContext _localctx = new DataFacetExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dataFacetExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THAT) {
				{
				setState(393);
				match(THAT);
				setState(394);
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

			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A) {
				{
				setState(397);
				match(A);
				}
			}

			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_FACET:
				{
				setState(400);
				match(DATA_FACET);
				}
				break;
			case EXACT:
			case LESS_THAN:
			case LESS_THAN_OR_EQUAL:
			case MORE_THAN:
			case MORE_THAN_OR_EQUAL:
				{
				setState(401);
				quantNumeric();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(404);
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
		enterRule(_localctx, 50, RULE_dataValuePhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(406);
				match(NOT);
				}
			}

			setState(409);
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
		public TerminalNode INTEGER() { return getToken(HOWL.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(HOWL.DECIMAL, 0); }
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
		enterRule(_localctx, 52, RULE_dataValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUOTED_TEXT) | (1L << INTEGER) | (1L << DECIMAL))) != 0)) ) {
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
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public QuantNumericExpressionContext quantNumericExpression() {
			return getRuleContext(QuantNumericExpressionContext.class,0);
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
		enterRule(_localctx, 54, RULE_quant);
		try {
			setState(420);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(A);
				}
				break;
			case THE:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				match(THE);
				}
				break;
			case EVERY:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				match(EVERY);
				}
				break;
			case SOME:
				enterOuterAlt(_localctx, 4);
				{
				setState(416);
				match(SOME);
				}
				break;
			case NO:
				enterOuterAlt(_localctx, 5);
				{
				setState(417);
				match(NO);
				}
				break;
			case ONLY:
				enterOuterAlt(_localctx, 6);
				{
				setState(418);
				match(ONLY);
				}
				break;
			case INTEGER:
			case EXACT:
			case LESS_THAN:
			case LESS_THAN_OR_EQUAL:
			case MORE_THAN:
			case MORE_THAN_OR_EQUAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(419);
				quantNumericExpression();
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
		enterRule(_localctx, 56, RULE_quantNumeric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
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

	public static class QuantNumericExpressionContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(HOWL.INTEGER, 0); }
		public QuantNumericContext quantNumeric() {
			return getRuleContext(QuantNumericContext.class,0);
		}
		public QuantNumericExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantNumericExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantNumericExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantNumericExpressionContext quantNumericExpression() throws RecognitionException {
		QuantNumericExpressionContext _localctx = new QuantNumericExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_quantNumericExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL))) != 0)) {
				{
				setState(424);
				quantNumeric();
				}
			}

			setState(427);
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
		enterRule(_localctx, 60, RULE_predicateExpressionObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
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
		enterRule(_localctx, 62, RULE_predicateExpressionData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
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
		enterRule(_localctx, 64, RULE_predicateExpressionAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
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
		enterRule(_localctx, 66, RULE_predicateExpressionVerbData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
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
		enterRule(_localctx, 68, RULE_predicateExpression);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				predicateExpressionVerb();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
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
		enterRule(_localctx, 70, RULE_predicateExpressionVerb);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				predicateExpressionSimple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				predicateExpressionParticle();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(443);
				predicateExpressionPassive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(444);
				predicateExpressionNoun();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(445);
				predicateExpressionHAS();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(446);
				predicateExpressionDO();
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
		enterRule(_localctx, 72, RULE_predicateExpressionState);
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				predicateExpressionBE();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
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
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
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
		enterRule(_localctx, 74, RULE_predicateExpressionSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(453);
				match(DOES);
				setState(454);
				match(NOT);
				}
			}

			setState(457);
			predicate();
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
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode PARTICLE() { return getToken(HOWL.PARTICLE, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
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
		enterRule(_localctx, 76, RULE_predicateExpressionParticle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES || _la==IS) {
				{
				setState(459);
				_la = _input.LA(1);
				if ( !(_la==DOES || _la==IS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(462);
				match(NOT);
				}
			}

			setState(465);
			predicate();
			setState(466);
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
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
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
		enterRule(_localctx, 78, RULE_predicateExpressionPassive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(IS);
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(469);
				match(NOT);
				}
			}

			setState(472);
			predicate();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTICLE) {
				{
				setState(473);
				match(PARTICLE);
				}
			}

			setState(476);
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
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
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
		enterRule(_localctx, 80, RULE_predicateExpressionNoun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IS:
				{
				setState(478);
				match(IS);
				}
				break;
			case HAS:
				{
				setState(479);
				match(HAS);
				}
				break;
			case PREDICATE:
			case AMBIG_WORD:
				{
				setState(480);
				predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(483);
				match(NOT);
				}
			}

			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A || _la==THE) {
				{
				setState(486);
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

			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << COMMON_NOUN) | (1L << PROPER_NOUN) | (1L << AMBIG_WORD))) != 0)) {
				{
				setState(489);
				adjp();
				}
			}

			setState(492);
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

	public static class PredicateExpressionSameAsContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode SAME_AS() { return getToken(HOWL.SAME_AS, 0); }
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
		enterRule(_localctx, 82, RULE_predicateExpressionSameAs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(IS);
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(495);
				match(NOT);
				}
			}

			setState(498);
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
		enterRule(_localctx, 84, RULE_predicateExpressionBE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(IS);
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(501);
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
		enterRule(_localctx, 86, RULE_predicateExpressionDO);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(DOES);
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(505);
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
		public TerminalNode DOES() { return getToken(HOWL.DOES, 0); }
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
		enterRule(_localctx, 88, RULE_predicateExpressionHAS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(508);
				match(DOES);
				}
			}

			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(511);
				match(NOT);
				}
			}

			setState(514);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREDICATE() { return getToken(HOWL.PREDICATE, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_la = _input.LA(1);
			if ( !(_la==PREDICATE || _la==AMBIG_WORD) ) {
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

	public static class PredicatePhraseNounContext extends ParserRuleContext {
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
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
		enterRule(_localctx, 92, RULE_predicatePhraseNoun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			predicateExpressionObject();
			setState(519);
			compoundNounPhrase();
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
		public DataTypeExpressionContext dataTypeExpression() {
			return getRuleContext(DataTypeExpressionContext.class,0);
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
		enterRule(_localctx, 94, RULE_predicatePhraseDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			predicateExpressionData();
			setState(522);
			dataTypeExpression();
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
		enterRule(_localctx, 96, RULE_predicatePhraseDataValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			predicateExpressionVerbData();
			setState(525);
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

	public static class PredicatePhraseContext extends ParserRuleContext {
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
		}
		public PredicatePhraseDataTypeContext predicatePhraseDataType() {
			return getRuleContext(PredicatePhraseDataTypeContext.class,0);
		}
		public PredicatePhraseDataValueContext predicatePhraseDataValue() {
			return getRuleContext(PredicatePhraseDataValueContext.class,0);
		}
		public PredicatePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicatePhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPredicatePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatePhraseContext predicatePhrase() throws RecognitionException {
		PredicatePhraseContext _localctx = new PredicatePhraseContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_predicatePhrase);
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				predicatePhraseNoun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				predicatePhraseDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(529);
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
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public PredicatePhraseNounContext predicatePhraseNoun() {
			return getRuleContext(PredicatePhraseNounContext.class,0);
		}
		public PredicateExpressionContext predicateExpression() {
			return getRuleContext(PredicateExpressionContext.class,0);
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
		enterRule(_localctx, 100, RULE_singlePhraseObject);
		try {
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				compoundNounPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(533);
				predicatePhraseNoun();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				predicateExpression();
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
		public DataTypeExpressionContext dataTypeExpression() {
			return getRuleContext(DataTypeExpressionContext.class,0);
		}
		public PredicatePhraseDataTypeContext predicatePhraseDataType() {
			return getRuleContext(PredicatePhraseDataTypeContext.class,0);
		}
		public PredicatePhraseDataValueContext predicatePhraseDataValue() {
			return getRuleContext(PredicatePhraseDataValueContext.class,0);
		}
		public DataFacetExpressionContext dataFacetExpression() {
			return getRuleContext(DataFacetExpressionContext.class,0);
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
		enterRule(_localctx, 102, RULE_singlePhraseData);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				dataTypeExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(538);
				predicatePhraseDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(539);
				predicatePhraseDataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(540);
				dataFacetExpression();
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
		public List<TerminalNode> PERIOD() { return getTokens(HOWL.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(HOWL.PERIOD, i);
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
		enterRule(_localctx, 104, RULE_catchSet);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(549);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						setState(543);
						singlePhraseObject();
						}
						break;
					case 2:
						{
						setState(544);
						singlePhraseData();
						}
						break;
					case 3:
						{
						setState(545);
						match(AND);
						}
						break;
					case 4:
						{
						setState(546);
						match(OR);
						}
						break;
					case 5:
						{
						setState(547);
						match(COMMA);
						}
						break;
					case 6:
						{
						setState(548);
						match(PERIOD);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(551); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public List<TerminalNode> BADWORD() { return getTokens(HOWL.BADWORD); }
		public TerminalNode BADWORD(int i) {
			return getToken(HOWL.BADWORD, i);
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
		enterRule(_localctx, 106, RULE_badSentence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(553);
					matchWildcard();
					}
					} 
				}
				setState(558);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			}
			}
			setState(560); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(559);
					match(BADWORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(562); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			{
			setState(567);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(564);
					matchWildcard();
					}
					} 
				}
				setState(569);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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

	public static class WordSequenceContext extends ParserRuleContext {
		public List<TerminalNode> WORD_TYPE() { return getTokens(HOWL.WORD_TYPE); }
		public TerminalNode WORD_TYPE(int i) {
			return getToken(HOWL.WORD_TYPE, i);
		}
		public WordSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordSequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitWordSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordSequenceContext wordSequence() throws RecognitionException {
		WordSequenceContext _localctx = new WordSequenceContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_wordSequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(571); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(570);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==WORD_TYPE) ) {
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
				setState(573); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DebugWordSequenceContext extends ParserRuleContext {
		public DebugWordSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debugWordSequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDebugWordSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebugWordSequenceContext debugWordSequence() throws RecognitionException {
		DebugWordSequenceContext _localctx = new DebugWordSequenceContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_debugWordSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(576); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(575);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(578); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0247\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\6\2y\n\2\r\2\16\2z\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\u008b\n\3\3\4\3\4\3\4\3\4\3\4\5\4\u0092\n\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00e7\n\20\3\20\5\20\u00ea\n\20\3\20\5\20\u00ed\n\20\3\20\3\20\3"+
		"\20\5\20\u00f2\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00fb\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u0106\n\23\f\23\16"+
		"\23\u0109\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0112\n\23\f\23"+
		"\16\23\u0115\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u011f"+
		"\n\23\f\23\16\23\u0122\13\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012a"+
		"\n\23\3\24\5\24\u012d\n\24\3\24\5\24\u0130\n\24\3\24\3\24\3\25\6\25\u0135"+
		"\n\25\r\25\16\25\u0136\3\26\5\26\u013a\n\26\3\26\5\26\u013d\n\26\3\26"+
		"\5\26\u0140\n\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0148\n\26\f\26\16"+
		"\26\u014b\13\26\5\26\u014d\n\26\3\27\6\27\u0150\n\27\r\27\16\27\u0151"+
		"\3\30\3\30\3\30\3\30\7\30\u0158\n\30\f\30\16\30\u015b\13\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0164\n\30\f\30\16\30\u0167\13\30\3\30"+
		"\3\30\3\30\3\30\5\30\u016d\n\30\3\30\5\30\u0170\n\30\3\30\3\30\3\30\5"+
		"\30\u0175\n\30\3\30\3\30\3\30\3\30\5\30\u017b\n\30\3\31\5\31\u017e\n\31"+
		"\3\31\5\31\u0181\n\31\3\31\3\31\3\31\3\31\7\31\u0187\n\31\f\31\16\31\u018a"+
		"\13\31\3\32\3\32\5\32\u018e\n\32\3\32\5\32\u0191\n\32\3\32\3\32\5\32\u0195"+
		"\n\32\3\32\3\32\3\33\5\33\u019a\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u01a7\n\35\3\36\3\36\3\37\5\37\u01ac\n\37\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\5$\u01ba\n$\3%\3%\3%\3%\3%\3"+
		"%\5%\u01c2\n%\3&\3&\5&\u01c6\n&\3\'\3\'\5\'\u01ca\n\'\3\'\3\'\3(\5(\u01cf"+
		"\n(\3(\5(\u01d2\n(\3(\3(\3(\3)\3)\5)\u01d9\n)\3)\3)\5)\u01dd\n)\3)\3)"+
		"\3*\3*\3*\5*\u01e4\n*\3*\5*\u01e7\n*\3*\5*\u01ea\n*\3*\5*\u01ed\n*\3*"+
		"\3*\3+\3+\5+\u01f3\n+\3+\3+\3,\3,\5,\u01f9\n,\3-\3-\5-\u01fd\n-\3.\5."+
		"\u0200\n.\3.\5.\u0203\n.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\5\63\u0215\n\63\3\64\3\64\3\64\5\64\u021a\n"+
		"\64\3\65\3\65\3\65\3\65\5\65\u0220\n\65\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\6\66\u0228\n\66\r\66\16\66\u0229\3\67\7\67\u022d\n\67\f\67\16\67\u0230"+
		"\13\67\3\67\6\67\u0233\n\67\r\67\16\67\u0234\3\67\7\67\u0238\n\67\f\67"+
		"\16\67\u023b\13\67\38\68\u023e\n8\r8\168\u023f\39\69\u0243\n9\r9\169\u0244"+
		"\39\13\u0107\u0113\u0149\u0188\u0229\u022e\u0239\u023f\u0244\2:\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bdfhjlnp\2\17\4\2//\67\67\4\2\n\n\25\25\4\2\n\n\27\27\4\2\23\23"+
		"\67\67\7\2\3\3\5\5\23\23\65\65\67\67\6\2\3\3\5\5\23\23\67\67\4\2\20\20"+
		"\22\22\4\2\6\6\f\r\3\2\36\"\4\2\16\16\22\22\4\2\34\34%%\4\2\24\24\67\67"+
		"\3\2\64\64\2\u0278\2x\3\2\2\2\4\u008a\3\2\2\2\6\u0091\3\2\2\2\b\u0093"+
		"\3\2\2\2\n\u0096\3\2\2\2\f\u0099\3\2\2\2\16\u009c\3\2\2\2\20\u00a1\3\2"+
		"\2\2\22\u00aa\3\2\2\2\24\u00b3\3\2\2\2\26\u00be\3\2\2\2\30\u00c7\3\2\2"+
		"\2\32\u00d0\3\2\2\2\34\u00db\3\2\2\2\36\u00e1\3\2\2\2 \u00f3\3\2\2\2\""+
		"\u00fc\3\2\2\2$\u0129\3\2\2\2&\u012c\3\2\2\2(\u0134\3\2\2\2*\u0139\3\2"+
		"\2\2,\u014f\3\2\2\2.\u017a\3\2\2\2\60\u017d\3\2\2\2\62\u018d\3\2\2\2\64"+
		"\u0199\3\2\2\2\66\u019d\3\2\2\28\u01a6\3\2\2\2:\u01a8\3\2\2\2<\u01ab\3"+
		"\2\2\2>\u01af\3\2\2\2@\u01b1\3\2\2\2B\u01b3\3\2\2\2D\u01b5\3\2\2\2F\u01b9"+
		"\3\2\2\2H\u01c1\3\2\2\2J\u01c5\3\2\2\2L\u01c9\3\2\2\2N\u01ce\3\2\2\2P"+
		"\u01d6\3\2\2\2R\u01e3\3\2\2\2T\u01f0\3\2\2\2V\u01f6\3\2\2\2X\u01fa\3\2"+
		"\2\2Z\u01ff\3\2\2\2\\\u0206\3\2\2\2^\u0208\3\2\2\2`\u020b\3\2\2\2b\u020e"+
		"\3\2\2\2d\u0214\3\2\2\2f\u0219\3\2\2\2h\u021f\3\2\2\2j\u0227\3\2\2\2l"+
		"\u022e\3\2\2\2n\u023d\3\2\2\2p\u0242\3\2\2\2rs\5\4\3\2st\7\t\2\2ty\3\2"+
		"\2\2uv\5\6\4\2vw\7\t\2\2wy\3\2\2\2xr\3\2\2\2xu\3\2\2\2yz\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{\3\3\2\2\2|\u008b\5\n\6\2}\u008b\5\b\5\2~\u008b\5\22\n"+
		"\2\177\u008b\5\20\t\2\u0080\u008b\5\30\r\2\u0081\u008b\5\26\f\2\u0082"+
		"\u008b\5\f\7\2\u0083\u008b\5\16\b\2\u0084\u008b\5 \21\2\u0085\u008b\5"+
		"\"\22\2\u0086\u008b\5\34\17\2\u0087\u008b\5\36\20\2\u0088\u008b\5\24\13"+
		"\2\u0089\u008b\5\32\16\2\u008a|\3\2\2\2\u008a}\3\2\2\2\u008a~\3\2\2\2"+
		"\u008a\177\3\2\2\2\u008a\u0080\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0082"+
		"\3\2\2\2\u008a\u0083\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0085\3\2\2\2\u008a"+
		"\u0086\3\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2"+
		"\2\2\u008b\5\3\2\2\2\u008c\u0092\5f\64\2\u008d\u0092\5h\65\2\u008e\u0092"+
		"\5j\66\2\u008f\u0092\5l\67\2\u0090\u0092\5p9\2\u0091\u008c\3\2\2\2\u0091"+
		"\u008d\3\2\2\2\u0091\u008e\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\7\3\2\2\2\u0093\u0094\5&\24\2\u0094\u0095\5b\62\2\u0095\t\3"+
		"\2\2\2\u0096\u0097\5&\24\2\u0097\u0098\5^\60\2\u0098\13\3\2\2\2\u0099"+
		"\u009a\5$\23\2\u009a\u009b\5^\60\2\u009b\r\3\2\2\2\u009c\u009d\7\34\2"+
		"\2\u009d\u009e\t\2\2\2\u009e\u009f\5J&\2\u009f\u00a0\5.\30\2\u00a0\17"+
		"\3\2\2\2\u00a1\u00a2\7\35\2\2\u00a2\u00a3\7\65\2\2\u00a3\u00a4\7*\2\2"+
		"\u00a4\u00a5\5@!\2\u00a5\u00a6\7$\2\2\u00a6\u00a7\7\66\2\2\u00a7\u00a8"+
		"\7\22\2\2\u00a8\u00a9\5$\23\2\u00a9\21\3\2\2\2\u00aa\u00ab\7\35\2\2\u00ab"+
		"\u00ac\7\65\2\2\u00ac\u00ad\7*\2\2\u00ad\u00ae\5> \2\u00ae\u00af\7$\2"+
		"\2\u00af\u00b0\7\65\2\2\u00b0\u00b1\7\22\2\2\u00b1\u00b2\5$\23\2\u00b2"+
		"\23\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\u00b5\7\35\2\2\u00b5\u00b6\7\65\2"+
		"\2\u00b6\u00b7\7*\2\2\u00b7\u00b8\5B\"\2\u00b8\u00b9\7$\2\2\u00b9\u00ba"+
		"\7\65\2\2\u00ba\u00bb\7\22\2\2\u00bb\u00bc\7\34\2\2\u00bc\u00bd\5n8\2"+
		"\u00bd\25\3\2\2\2\u00be\u00bf\7\35\2\2\u00bf\u00c0\7\65\2\2\u00c0\u00c1"+
		"\7\22\2\2\u00c1\u00c2\7\34\2\2\u00c2\u00c3\7\65\2\2\u00c3\u00c4\7*\2\2"+
		"\u00c4\u00c5\5@!\2\u00c5\u00c6\5.\30\2\u00c6\27\3\2\2\2\u00c7\u00c8\7"+
		"\35\2\2\u00c8\u00c9\7\65\2\2\u00c9\u00ca\7\22\2\2\u00ca\u00cb\7\34\2\2"+
		"\u00cb\u00cc\7\65\2\2\u00cc\u00cd\7*\2\2\u00cd\u00ce\5> \2\u00ce\u00cf"+
		"\5$\23\2\u00cf\31\3\2\2\2\u00d0\u00d1\7-\2\2\u00d1\u00d2\7\35\2\2\u00d2"+
		"\u00d3\7\65\2\2\u00d3\u00d4\7\22\2\2\u00d4\u00d5\7\34\2\2\u00d5\u00d6"+
		"\7\65\2\2\u00d6\u00d7\7*\2\2\u00d7\u00d8\5B\"\2\u00d8\u00d9\7\34\2\2\u00d9"+
		"\u00da\5n8\2\u00da\33\3\2\2\2\u00db\u00dc\7%\2\2\u00dc\u00dd\5n8\2\u00dd"+
		"\u00de\7\64\2\2\u00de\u00df\7\22\2\2\u00df\u00e0\7\62\2\2\u00e0\35\3\2"+
		"\2\2\u00e1\u00e2\7%\2\2\u00e2\u00e3\5n8\2\u00e3\u00e4\7\64\2\2\u00e4\u00e6"+
		"\7\22\2\2\u00e5\u00e7\7\33\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2"+
		"\u00e7\u00e9\3\2\2\2\u00e8\u00ea\7(\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00ed\7)\2\2\u00ec\u00eb\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7%\2\2\u00ef\u00f1\5n8"+
		"\2\u00f0\u00f2\7\64\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\37\3\2\2\2\u00f3\u00f4\7-\2\2\u00f4\u00f5\5n8\2\u00f5\u00f6\7.\2\2\u00f6"+
		"\u00f7\5n8\2\u00f7\u00fa\7.\2\2\u00f8\u00fb\5\66\34\2\u00f9\u00fb\5n8"+
		"\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb!\3\2\2\2\u00fc\u00fd"+
		"\5n8\2\u00fd\u00fe\7\22\2\2\u00fe\u00ff\7\34\2\2\u00ff\u0100\7\64\2\2"+
		"\u0100#\3\2\2\2\u0101\u0102\7\'\2\2\u0102\u0107\5$\23\2\u0103\u0104\t"+
		"\3\2\2\u0104\u0106\5$\23\2\u0105\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u010a\u010b\7\25\2\2\u010b\u010c\5$\23\2\u010c\u012a\3\2\2\2\u010d"+
		"\u010e\7&\2\2\u010e\u0113\5$\23\2\u010f\u0110\t\4\2\2\u0110\u0112\5$\23"+
		"\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0114\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\27\2\2"+
		"\u0117\u0118\5$\23\2\u0118\u012a\3\2\2\2\u0119\u011a\7\26\2\2\u011a\u011b"+
		"\7&\2\2\u011b\u0120\5$\23\2\u011c\u011d\t\4\2\2\u011d\u011f\5$\23\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\27\2\2\u0124"+
		"\u0125\5$\23\2\u0125\u012a\3\2\2\2\u0126\u012a\5&\24\2\u0127\u012a\5*"+
		"\26\2\u0128\u012a\7\60\2\2\u0129\u0101\3\2\2\2\u0129\u010d\3\2\2\2\u0129"+
		"\u0119\3\2\2\2\u0129\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2"+
		"\2\2\u012a%\3\2\2\2\u012b\u012d\7\33\2\2\u012c\u012b\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u0130\7%\2\2\u012f\u012e\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\5(\25\2\u0132\'\3\2\2\2"+
		"\u0133\u0135\t\5\2\2\u0134\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0137)\3\2\2\2\u0138\u013a\7\33\2\2\u0139"+
		"\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u013d\58"+
		"\35\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e"+
		"\u0140\5,\27\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2"+
		"\2\2\u0141\u014c\t\6\2\2\u0142\u0143\7*\2\2\u0143\u0149\5d\63\2\u0144"+
		"\u0145\7\25\2\2\u0145\u0146\7*\2\2\u0146\u0148\5d\63\2\u0147\u0144\3\2"+
		"\2\2\u0148\u014b\3\2\2\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a"+
		"\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u0142\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d+\3\2\2\2\u014e\u0150\t\7\2\2\u014f\u014e\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152-\3\2\2\2\u0153"+
		"\u0154\7&\2\2\u0154\u0159\5.\30\2\u0155\u0156\t\4\2\2\u0156\u0158\5.\30"+
		"\2\u0157\u0155\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a"+
		"\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\7\27\2\2"+
		"\u015d\u015e\5.\30\2\u015e\u017b\3\2\2\2\u015f\u0160\7\'\2\2\u0160\u0165"+
		"\5.\30\2\u0161\u0162\t\3\2\2\u0162\u0164\5.\30\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0168\u0169\7\25\2\2\u0169\u016a\5.\30\2\u016a"+
		"\u017b\3\2\2\2\u016b\u016d\7\33\2\2\u016c\u016b\3\2\2\2\u016c\u016d\3"+
		"\2\2\2\u016d\u016f\3\2\2\2\u016e\u0170\58\35\2\u016f\u016e\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0174\3\2\2\2\u0171\u0175\7/\2\2\u0172\u0175\7\66"+
		"\2\2\u0173\u0175\7\67\2\2\u0174\u0171\3\2\2\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0173\3\2\2\2\u0175\u017b\3\2\2\2\u0176\u0177\7\33\2\2\u0177\u017b\5"+
		".\30\2\u0178\u017b\5\60\31\2\u0179\u017b\5\64\33\2\u017a\u0153\3\2\2\2"+
		"\u017a\u015f\3\2\2\2\u017a\u016c\3\2\2\2\u017a\u0176\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017a\u0179\3\2\2\2\u017b/\3\2\2\2\u017c\u017e\7\33\2\2\u017d"+
		"\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0181\58"+
		"\35\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u0183\t\2\2\2\u0183\u0188\5\62\32\2\u0184\u0185\7\25\2\2\u0185\u0187"+
		"\5\62\32\2\u0186\u0184\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0189\3\2\2\2"+
		"\u0188\u0186\3\2\2\2\u0189\61\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c"+
		"\7*\2\2\u018c\u018e\t\b\2\2\u018d\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e"+
		"\u0190\3\2\2\2\u018f\u0191\7\34\2\2\u0190\u018f\3\2\2\2\u0190\u0191\3"+
		"\2\2\2\u0191\u0194\3\2\2\2\u0192\u0195\7#\2\2\u0193\u0195\5:\36\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\5\66"+
		"\34\2\u0197\63\3\2\2\2\u0198\u019a\7\33\2\2\u0199\u0198\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\5\66\34\2\u019c\65\3\2"+
		"\2\2\u019d\u019e\t\t\2\2\u019e\67\3\2\2\2\u019f\u01a7\7\34\2\2\u01a0\u01a7"+
		"\7%\2\2\u01a1\u01a7\7\35\2\2\u01a2\u01a7\7$\2\2\u01a3\u01a7\7\32\2\2\u01a4"+
		"\u01a7\7\31\2\2\u01a5\u01a7\5<\37\2\u01a6\u019f\3\2\2\2\u01a6\u01a0\3"+
		"\2\2\2\u01a6\u01a1\3\2\2\2\u01a6\u01a2\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a79\3\2\2\2\u01a8\u01a9\t\n\2\2"+
		"\u01a9;\3\2\2\2\u01aa\u01ac\5:\36\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3"+
		"\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\7\f\2\2\u01ae=\3\2\2\2\u01af\u01b0"+
		"\5F$\2\u01b0?\3\2\2\2\u01b1\u01b2\5F$\2\u01b2A\3\2\2\2\u01b3\u01b4\5F"+
		"$\2\u01b4C\3\2\2\2\u01b5\u01b6\5H%\2\u01b6E\3\2\2\2\u01b7\u01ba\5H%\2"+
		"\u01b8\u01ba\5J&\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01baG\3\2"+
		"\2\2\u01bb\u01c2\5L\'\2\u01bc\u01c2\5N(\2\u01bd\u01c2\5P)\2\u01be\u01c2"+
		"\5R*\2\u01bf\u01c2\5Z.\2\u01c0\u01c2\5X-\2\u01c1\u01bb\3\2\2\2\u01c1\u01bc"+
		"\3\2\2\2\u01c1\u01bd\3\2\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c0\3\2\2\2\u01c2I\3\2\2\2\u01c3\u01c6\5V,\2\u01c4\u01c6\5T+\2\u01c5"+
		"\u01c3\3\2\2\2\u01c5\u01c4\3\2\2\2\u01c6K\3\2\2\2\u01c7\u01c8\7\16\2\2"+
		"\u01c8\u01ca\7\33\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb"+
		"\3\2\2\2\u01cb\u01cc\5\\/\2\u01ccM\3\2\2\2\u01cd\u01cf\t\13\2\2\u01ce"+
		"\u01cd\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0\u01d2\7\33"+
		"\2\2\u01d1\u01d0\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d4\5\\/\2\u01d4\u01d5\7\21\2\2\u01d5O\3\2\2\2\u01d6\u01d8\7\22\2\2"+
		"\u01d7\u01d9\7\33\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da"+
		"\3\2\2\2\u01da\u01dc\5\\/\2\u01db\u01dd\7\21\2\2\u01dc\u01db\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\7\30\2\2\u01dfQ\3\2\2\2"+
		"\u01e0\u01e4\7\22\2\2\u01e1\u01e4\7\20\2\2\u01e2\u01e4\5\\/\2\u01e3\u01e0"+
		"\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5"+
		"\u01e7\7\33\2\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3"+
		"\2\2\2\u01e8\u01ea\t\f\2\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea"+
		"\u01ec\3\2\2\2\u01eb\u01ed\5,\27\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\7\21\2\2\u01efS\3\2\2\2\u01f0\u01f2"+
		"\7\22\2\2\u01f1\u01f3\7\33\2\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2"+
		"\u01f3\u01f4\3\2\2\2\u01f4\u01f5\7(\2\2\u01f5U\3\2\2\2\u01f6\u01f8\7\22"+
		"\2\2\u01f7\u01f9\7\33\2\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"W\3\2\2\2\u01fa\u01fc\7\16\2\2\u01fb\u01fd\7\33\2\2\u01fc\u01fb\3\2\2"+
		"\2\u01fc\u01fd\3\2\2\2\u01fdY\3\2\2\2\u01fe\u0200\7\16\2\2\u01ff\u01fe"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2\2\2\u0201\u0203\7\33\2\2"+
		"\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205"+
		"\7\20\2\2\u0205[\3\2\2\2\u0206\u0207\t\r\2\2\u0207]\3\2\2\2\u0208\u0209"+
		"\5> \2\u0209\u020a\5$\23\2\u020a_\3\2\2\2\u020b\u020c\5@!\2\u020c\u020d"+
		"\5.\30\2\u020da\3\2\2\2\u020e\u020f\5D#\2\u020f\u0210\5\64\33\2\u0210"+
		"c\3\2\2\2\u0211\u0215\5^\60\2\u0212\u0215\5`\61\2\u0213\u0215\5b\62\2"+
		"\u0214\u0211\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0213\3\2\2\2\u0215e\3"+
		"\2\2\2\u0216\u021a\5$\23\2\u0217\u021a\5^\60\2\u0218\u021a\5F$\2\u0219"+
		"\u0216\3\2\2\2\u0219\u0217\3\2\2\2\u0219\u0218\3\2\2\2\u021ag\3\2\2\2"+
		"\u021b\u0220\5.\30\2\u021c\u0220\5`\61\2\u021d\u0220\5b\62\2\u021e\u0220"+
		"\5\62\32\2\u021f\u021b\3\2\2\2\u021f\u021c\3\2\2\2\u021f\u021d\3\2\2\2"+
		"\u021f\u021e\3\2\2\2\u0220i\3\2\2\2\u0221\u0228\5f\64\2\u0222\u0228\5"+
		"h\65\2\u0223\u0228\7\25\2\2\u0224\u0228\7\27\2\2\u0225\u0228\7\n\2\2\u0226"+
		"\u0228\7\t\2\2\u0227\u0221\3\2\2\2\u0227\u0222\3\2\2\2\u0227\u0223\3\2"+
		"\2\2\u0227\u0224\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0226\3\2\2\2\u0228"+
		"\u0229\3\2\2\2\u0229\u022a\3\2\2\2\u0229\u0227\3\2\2\2\u022ak\3\2\2\2"+
		"\u022b\u022d\13\2\2\2\u022c\u022b\3\2\2\2\u022d\u0230\3\2\2\2\u022e\u022f"+
		"\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2\2\2\u0231"+
		"\u0233\7\4\2\2\u0232\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0232\3\2"+
		"\2\2\u0234\u0235\3\2\2\2\u0235\u0239\3\2\2\2\u0236\u0238\13\2\2\2\u0237"+
		"\u0236\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u023a\3\2\2\2\u0239\u0237\3\2"+
		"\2\2\u023am\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023e\n\16\2\2\u023d\u023c"+
		"\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u023f\u023d\3\2\2\2\u0240"+
		"o\3\2\2\2\u0241\u0243\13\2\2\2\u0242\u0241\3\2\2\2\u0243\u0244\3\2\2\2"+
		"\u0244\u0245\3\2\2\2\u0244\u0242\3\2\2\2\u0245q\3\2\2\2Bxz\u008a\u0091"+
		"\u00e6\u00e9\u00ec\u00f1\u00fa\u0107\u0113\u0120\u0129\u012c\u012f\u0136"+
		"\u0139\u013c\u013f\u0149\u014c\u0151\u0159\u0165\u016c\u016f\u0174\u017a"+
		"\u017d\u0180\u0188\u018d\u0190\u0194\u0199\u01a6\u01ab\u01b9\u01c1\u01c5"+
		"\u01c9\u01ce\u01d1\u01d8\u01dc\u01e3\u01e6\u01e9\u01ec\u01f2\u01f8\u01fc"+
		"\u01ff\u0202\u0214\u0219\u021f\u0227\u0229\u022e\u0234\u0239\u023f\u0244";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}