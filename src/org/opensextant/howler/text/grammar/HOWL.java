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
		HAS=14, PARTICLE=15, IS=16, PROPER_NOUN=17, PREDICATE=18, AND=19, ONEOF=20, 
		OR=21, BY=22, ONLY=23, NO=24, NONE=25, NOT=26, A=27, EVERY=28, EXACT=29, 
		LESS_THAN=30, LESS_THAN_OR_EQUAL=31, MORE_THAN=32, MORE_THAN_OR_EQUAL=33, 
		DATA_FACET=34, SOME=35, THE=36, SAME_AS=37, INVERSE_OF=38, THAT=39, OBJECT_SCOPE=40, 
		DATA_SCOPE=41, ANNOTATION_MARKER=42, ANNOTATION_SPLIT=43, DATATYPE=44, 
		ITSELF=45, TO=46, PREDICATE_CHARACTERISTIC=47, QUOTE=48, WORD_TYPE=49, 
		THING=50, DATA_VALUE=51, AMBIG_WORD=52;
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
		RULE_catchSet = 52, RULE_badSentence = 53, RULE_wordSequence = 54, RULE_declareWordSequence = 55, 
		RULE_debugWordSequence = 56;
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
		"badSentence", "wordSequence", "declareWordSequence", "debugWordSequence"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADJECTIVE", "BADWORD", "COMMON_NOUN", "QUOTED_TEXT", "OPEN", "CLOSE", 
		"PERIOD", "COMMA", "NUMBER", "INTEGER", "DECIMAL", "DOES", "DASH", "HAS", 
		"PARTICLE", "IS", "PROPER_NOUN", "PREDICATE", "AND", "ONEOF", "OR", "BY", 
		"ONLY", "NO", "NONE", "NOT", "A", "EVERY", "EXACT", "LESS_THAN", "LESS_THAN_OR_EQUAL", 
		"MORE_THAN", "MORE_THAN_OR_EQUAL", "DATA_FACET", "SOME", "THE", "SAME_AS", 
		"INVERSE_OF", "THAT", "OBJECT_SCOPE", "DATA_SCOPE", "ANNOTATION_MARKER", 
		"ANNOTATION_SPLIT", "DATATYPE", "ITSELF", "TO", "PREDICATE_CHARACTERISTIC", 
		"QUOTE", "WORD_TYPE", "THING", "DATA_VALUE", "AMBIG_WORD"
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
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					{
					setState(114);
					statement();
					setState(115);
					match(PERIOD);
					}
					}
					break;
				case 2:
					{
					{
					setState(117);
					debug();
					setState(118);
					match(PERIOD);
					}
					}
					break;
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << BADWORD) | (1L << COMMON_NOUN) | (1L << QUOTED_TEXT) | (1L << OPEN) | (1L << CLOSE) | (1L << PERIOD) | (1L << COMMA) | (1L << NUMBER) | (1L << INTEGER) | (1L << DECIMAL) | (1L << DOES) | (1L << DASH) | (1L << HAS) | (1L << PARTICLE) | (1L << IS) | (1L << PROPER_NOUN) | (1L << PREDICATE) | (1L << AND) | (1L << ONEOF) | (1L << OR) | (1L << BY) | (1L << ONLY) | (1L << NO) | (1L << NONE) | (1L << NOT) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << DATA_FACET) | (1L << SOME) | (1L << THE) | (1L << SAME_AS) | (1L << INVERSE_OF) | (1L << THAT) | (1L << OBJECT_SCOPE) | (1L << DATA_SCOPE) | (1L << ANNOTATION_MARKER) | (1L << ANNOTATION_SPLIT) | (1L << DATATYPE) | (1L << ITSELF) | (1L << TO) | (1L << PREDICATE_CHARACTERISTIC) | (1L << QUOTE) | (1L << WORD_TYPE) | (1L << THING) | (1L << DATA_VALUE) | (1L << AMBIG_WORD))) != 0) );
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
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				factStatementObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				factStatementData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				domainStatementObject();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				domainStatementDataType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				rangeStatementObject();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				rangeStatementDataType();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(130);
				descriptionStatementObject();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				descriptionStatementDataType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				annotationStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(133);
				declarationStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(134);
				predicateCharacteristicStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(135);
				predicateRelationStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(136);
				domainStatementAnnotation();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(137);
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
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				singlePhraseObject();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				singlePhraseData();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				catchSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				badSentence();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
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
			setState(147);
			properNounPhrase();
			setState(148);
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
			setState(150);
			properNounPhrase();
			setState(151);
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
			setState(153);
			compoundNounPhrase(0);
			setState(154);
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
			setState(156);
			match(A);
			setState(157);
			_la = _input.LA(1);
			if ( !(_la==DATATYPE || _la==AMBIG_WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(158);
			predicateExpressionState();
			setState(159);
			dataTypeExpression(0);
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
		public CompoundNounPhraseContext subj;
		public PredicateExpressionDataContext pred;
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode DATA_VALUE() { return getToken(HOWL.DATA_VALUE, 0); }
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ONLY);
			setState(162);
			((DomainStatementDataTypeContext)_localctx).subj = compoundNounPhrase(0);
			setState(163);
			((DomainStatementDataTypeContext)_localctx).pred = predicateExpressionData();
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(165);
			match(DATA_VALUE);
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
		public CompoundNounPhraseContext subj;
		public PredicateExpressionObjectContext pred;
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ONLY);
			setState(168);
			((DomainStatementObjectContext)_localctx).subj = compoundNounPhrase(0);
			setState(169);
			((DomainStatementObjectContext)_localctx).pred = predicateExpressionObject();
			setState(170);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(171);
			match(THING);
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
		public WordSequenceContext subj;
		public PredicateExpressionAnnotationContext pred;
		public TerminalNode ANNOTATION_MARKER() { return getToken(HOWL.ANNOTATION_MARKER, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public PredicateExpressionAnnotationContext predicateExpressionAnnotation() {
			return getRuleContext(PredicateExpressionAnnotationContext.class,0);
		}
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ANNOTATION_MARKER);
			setState(174);
			match(ONLY);
			setState(175);
			((DomainStatementAnnotationContext)_localctx).subj = wordSequence();
			setState(176);
			((DomainStatementAnnotationContext)_localctx).pred = predicateExpressionAnnotation();
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(178);
			match(THING);
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
		public DataTypeExpressionContext obj;
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public PredicateExpressionDataContext predicateExpressionData() {
			return getRuleContext(PredicateExpressionDataContext.class,0);
		}
		public DataTypeExpressionContext dataTypeExpression() {
			return getRuleContext(DataTypeExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(181);
			match(THING);
			setState(182);
			((RangeStatementDataTypeContext)_localctx).pred = predicateExpressionData();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(183);
				match(NOT);
				}
			}

			setState(186);
			match(ONLY);
			setState(187);
			((RangeStatementDataTypeContext)_localctx).obj = dataTypeExpression(0);
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
		public CompoundNounPhraseContext obj;
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public PredicateExpressionObjectContext predicateExpressionObject() {
			return getRuleContext(PredicateExpressionObjectContext.class,0);
		}
		public CompoundNounPhraseContext compoundNounPhrase() {
			return getRuleContext(CompoundNounPhraseContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(190);
			match(THING);
			setState(191);
			((RangeStatementObjectContext)_localctx).pred = predicateExpressionObject();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(192);
				match(NOT);
				}
			}

			setState(195);
			match(ONLY);
			setState(196);
			((RangeStatementObjectContext)_localctx).obj = compoundNounPhrase(0);
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
		public WordSequenceContext obj;
		public TerminalNode ANNOTATION_MARKER() { return getToken(HOWL.ANNOTATION_MARKER, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public PredicateExpressionAnnotationContext predicateExpressionAnnotation() {
			return getRuleContext(PredicateExpressionAnnotationContext.class,0);
		}
		public WordSequenceContext wordSequence() {
			return getRuleContext(WordSequenceContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(ANNOTATION_MARKER);
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==A || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(200);
			match(THING);
			setState(201);
			((RangeStatementAnnotationContext)_localctx).pred = predicateExpressionAnnotation();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(202);
				match(NOT);
				}
			}

			setState(205);
			match(ONLY);
			setState(206);
			((RangeStatementAnnotationContext)_localctx).obj = wordSequence();
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
			setState(208);
			match(THE);
			setState(209);
			wordSequence();
			setState(210);
			match(WORD_TYPE);
			setState(211);
			match(IS);
			setState(212);
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
			setState(214);
			match(THE);
			setState(215);
			((PredicateRelationStatementContext)_localctx).subj = wordSequence();
			setState(216);
			match(WORD_TYPE);
			setState(217);
			((PredicateRelationStatementContext)_localctx).relIS = match(IS);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(218);
				match(NOT);
				}
			}

			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SAME_AS) {
				{
				setState(221);
				((PredicateRelationStatementContext)_localctx).relSame = match(SAME_AS);
				}
			}

			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INVERSE_OF) {
				{
				setState(224);
				((PredicateRelationStatementContext)_localctx).relInv = match(INVERSE_OF);
				}
			}

			setState(227);
			match(THE);
			setState(228);
			((PredicateRelationStatementContext)_localctx).obj = wordSequence();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD_TYPE) {
				{
				setState(229);
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
			setState(232);
			match(ANNOTATION_MARKER);
			setState(233);
			((AnnotationStatementContext)_localctx).subj = wordSequence();
			setState(234);
			match(ANNOTATION_SPLIT);
			setState(235);
			((AnnotationStatementContext)_localctx).rel = wordSequence();
			setState(236);
			match(ANNOTATION_SPLIT);
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(237);
				((AnnotationStatementContext)_localctx).objValue = dataValue();
				}
				break;
			case 2:
				{
				setState(238);
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
		public DeclareWordSequenceContext subj;
		public TerminalNode IS() { return getToken(HOWL.IS, 0); }
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode WORD_TYPE() { return getToken(HOWL.WORD_TYPE, 0); }
		public DeclareWordSequenceContext declareWordSequence() {
			return getRuleContext(DeclareWordSequenceContext.class,0);
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
			setState(241);
			((DeclarationStatementContext)_localctx).subj = declareWordSequence();
			setState(242);
			match(IS);
			setState(243);
			match(A);
			setState(244);
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
		public CompoundNounPhraseContext setUnion;
		public CompoundNounPhraseContext setIntersection;
		public CompoundNounPhraseContext disjointUnion;
		public ProperNounPhraseContext proper;
		public CommonNounPhraseContext common;
		public Token itself;
		public TerminalNode ONEOF() { return getToken(HOWL.ONEOF, 0); }
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
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
		public ProperNounPhraseContext properNounPhrase() {
			return getRuleContext(ProperNounPhraseContext.class,0);
		}
		public CommonNounPhraseContext commonNounPhrase() {
			return getRuleContext(CommonNounPhraseContext.class,0);
		}
		public TerminalNode ITSELF() { return getToken(HOWL.ITSELF, 0); }
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
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
		return compoundNounPhrase(0);
	}

	private CompoundNounPhraseContext compoundNounPhrase(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompoundNounPhraseContext _localctx = new CompoundNounPhraseContext(_ctx, _parentState);
		CompoundNounPhraseContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_compoundNounPhrase, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(247);
				match(ONEOF);
				setState(248);
				((CompoundNounPhraseContext)_localctx).disjointUnion = compoundNounPhrase(0);
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(249);
						_la = _input.LA(1);
						if ( !(_la==COMMA || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(250);
						compoundNounPhrase(0);
						}
						} 
					}
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(256);
				match(OR);
				setState(257);
				compoundNounPhrase(4);
				}
				break;
			case 2:
				{
				setState(259);
				((CompoundNounPhraseContext)_localctx).proper = properNounPhrase();
				}
				break;
			case 3:
				{
				setState(260);
				((CompoundNounPhraseContext)_localctx).common = commonNounPhrase();
				}
				break;
			case 4:
				{
				setState(261);
				((CompoundNounPhraseContext)_localctx).itself = match(ITSELF);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(284);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new CompoundNounPhraseContext(_parentctx, _parentState);
						_localctx.setUnion = _prevctx;
						_localctx.setUnion = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_compoundNounPhrase);
						setState(264);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(269);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(265);
								_la = _input.LA(1);
								if ( !(_la==COMMA || _la==OR) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(266);
								compoundNounPhrase(0);
								}
								} 
							}
							setState(271);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
						}
						setState(272);
						match(OR);
						setState(273);
						compoundNounPhrase(7);
						}
						break;
					case 2:
						{
						_localctx = new CompoundNounPhraseContext(_parentctx, _parentState);
						_localctx.setIntersection = _prevctx;
						_localctx.setIntersection = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_compoundNounPhrase);
						setState(274);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(279);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(275);
								_la = _input.LA(1);
								if ( !(_la==COMMA || _la==AND) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(276);
								compoundNounPhrase(0);
								}
								} 
							}
							setState(281);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
						}
						setState(282);
						match(AND);
						setState(283);
						compoundNounPhrase(6);
						}
						break;
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(289);
				match(NOT);
				}
			}

			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THE) {
				{
				setState(292);
				match(THE);
				}
			}

			setState(295);
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
			setState(298); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(297);
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
				setState(300); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(302);
				match(NOT);
				}
			}

			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
				{
				setState(305);
				quant();
				}
			}

			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(308);
				adjp();
				}
				break;
			}
			setState(311);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << COMMON_NOUN) | (1L << PROPER_NOUN) | (1L << THING) | (1L << AMBIG_WORD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(312);
				match(THAT);
				setState(313);
				predicatePhrase();
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(314);
						match(AND);
						setState(315);
						match(THAT);
						setState(316);
						predicatePhrase();
						}
						} 
					}
					setState(321);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
			setState(325); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(324);
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
				setState(327); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		public Token ambig;
		public DataTypeExpressionContext comp;
		public DataTypeRestrictionContext rest;
		public DataValuePhraseContext dv;
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public TerminalNode DATATYPE() { return getToken(HOWL.DATATYPE, 0); }
		public TerminalNode AMBIG_WORD() { return getToken(HOWL.AMBIG_WORD, 0); }
		public List<DataTypeExpressionContext> dataTypeExpression() {
			return getRuleContexts(DataTypeExpressionContext.class);
		}
		public DataTypeExpressionContext dataTypeExpression(int i) {
			return getRuleContext(DataTypeExpressionContext.class,i);
		}
		public DataTypeRestrictionContext dataTypeRestriction() {
			return getRuleContext(DataTypeRestrictionContext.class,0);
		}
		public DataValuePhraseContext dataValuePhrase() {
			return getRuleContext(DataValuePhraseContext.class,0);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HOWL.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HOWL.COMMA, i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
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
		return dataTypeExpression(0);
	}

	private DataTypeExpressionContext dataTypeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DataTypeExpressionContext _localctx = new DataTypeExpressionContext(_ctx, _parentState);
		DataTypeExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_dataTypeExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(330);
					match(NOT);
					}
				}

				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
					{
					setState(333);
					quant();
					}
				}

				setState(338);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DATATYPE:
					{
					setState(336);
					((DataTypeExpressionContext)_localctx).dt = match(DATATYPE);
					}
					break;
				case AMBIG_WORD:
					{
					setState(337);
					((DataTypeExpressionContext)_localctx).ambig = match(AMBIG_WORD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				setState(340);
				match(NOT);
				setState(341);
				((DataTypeExpressionContext)_localctx).comp = dataTypeExpression(3);
				}
				break;
			case 3:
				{
				setState(342);
				((DataTypeExpressionContext)_localctx).rest = dataTypeRestriction();
				}
				break;
			case 4:
				{
				setState(343);
				((DataTypeExpressionContext)_localctx).dv = dataValuePhrase();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(360);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new DataTypeExpressionContext(_parentctx, _parentState);
						_localctx.setUnion = _prevctx;
						_localctx.setUnion = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_dataTypeExpression);
						setState(346);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(349); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(347);
								_la = _input.LA(1);
								if ( !(_la==COMMA || _la==OR) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(348);
								dataTypeExpression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(351); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						_localctx = new DataTypeExpressionContext(_parentctx, _parentState);
						_localctx.setIntersection = _prevctx;
						_localctx.setIntersection = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_dataTypeExpression);
						setState(353);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(356); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(354);
								_la = _input.LA(1);
								if ( !(_la==COMMA || _la==AND) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								setState(355);
								dataTypeExpression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(358); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(365);
				match(NOT);
				}
			}

			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << ONLY) | (1L << NO) | (1L << A) | (1L << EVERY) | (1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL) | (1L << SOME) | (1L << THE))) != 0)) {
				{
				setState(368);
				quant();
				}
			}

			setState(371);
			_la = _input.LA(1);
			if ( !(_la==DATATYPE || _la==AMBIG_WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(372);
			dataFacetExpression();
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(373);
					match(AND);
					setState(374);
					dataFacetExpression();
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THAT) {
				{
				setState(380);
				match(THAT);
				setState(381);
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

			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A) {
				{
				setState(384);
				match(A);
				}
			}

			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_FACET:
				{
				setState(387);
				match(DATA_FACET);
				}
				break;
			case EXACT:
			case LESS_THAN:
			case LESS_THAN_OR_EQUAL:
			case MORE_THAN:
			case MORE_THAN_OR_EQUAL:
				{
				setState(388);
				quantNumeric();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(391);
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
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(393);
				match(NOT);
				}
			}

			setState(396);
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
			setState(398);
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
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(A);
				}
				break;
			case THE:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(THE);
				}
				break;
			case EVERY:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				match(EVERY);
				}
				break;
			case SOME:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				match(SOME);
				}
				break;
			case NO:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				match(NO);
				}
				break;
			case ONLY:
				enterOuterAlt(_localctx, 6);
				{
				setState(405);
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
				setState(406);
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
			setState(409);
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
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACT) | (1L << LESS_THAN) | (1L << LESS_THAN_OR_EQUAL) | (1L << MORE_THAN) | (1L << MORE_THAN_OR_EQUAL))) != 0)) {
				{
				setState(411);
				quantNumeric();
				}
			}

			setState(414);
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
			setState(416);
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
			setState(418);
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
			setState(420);
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
			setState(422);
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
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				predicateExpressionVerb();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
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
			setState(434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				predicateExpressionSimple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
				predicateExpressionParticle();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				predicateExpressionPassive();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(431);
				predicateExpressionNoun();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				predicateExpressionHAS();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(433);
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
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				predicateExpressionBE();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
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
			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(440);
				match(DOES);
				setState(441);
				match(NOT);
				}
			}

			setState(444);
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
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES || _la==IS) {
				{
				setState(446);
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

			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(449);
				match(NOT);
				}
			}

			setState(452);
			predicate();
			setState(453);
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
			setState(455);
			match(IS);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(456);
				match(NOT);
				}
			}

			setState(459);
			predicate();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTICLE) {
				{
				setState(460);
				match(PARTICLE);
				}
			}

			setState(463);
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
			setState(468);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IS:
				{
				setState(465);
				match(IS);
				}
				break;
			case HAS:
				{
				setState(466);
				match(HAS);
				}
				break;
			case PREDICATE:
			case AMBIG_WORD:
				{
				setState(467);
				predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(470);
				match(NOT);
				}
			}

			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==A || _la==THE) {
				{
				setState(473);
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

			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << COMMON_NOUN) | (1L << PROPER_NOUN) | (1L << AMBIG_WORD))) != 0)) {
				{
				setState(476);
				adjp();
				}
			}

			setState(479);
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
			setState(481);
			match(IS);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(482);
				match(NOT);
				}
			}

			setState(485);
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
			setState(487);
			match(IS);
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(488);
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
			setState(491);
			match(DOES);
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(492);
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
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOES) {
				{
				setState(495);
				match(DOES);
				}
			}

			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(498);
				match(NOT);
				}
			}

			setState(501);
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
			setState(503);
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
			setState(505);
			predicateExpressionObject();
			setState(506);
			compoundNounPhrase(0);
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
			setState(508);
			predicateExpressionData();
			setState(509);
			dataTypeExpression(0);
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
			setState(511);
			predicateExpressionVerbData();
			setState(512);
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
			setState(517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(514);
				predicatePhraseNoun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				predicatePhraseDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(516);
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
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				compoundNounPhrase(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				predicatePhraseNoun();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(521);
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
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(524);
				dataTypeExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(525);
				predicatePhraseDataType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(526);
				predicatePhraseDataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(527);
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
			setState(536); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(536);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						setState(530);
						singlePhraseObject();
						}
						break;
					case 2:
						{
						setState(531);
						singlePhraseData();
						}
						break;
					case 3:
						{
						setState(532);
						match(AND);
						}
						break;
					case 4:
						{
						setState(533);
						match(OR);
						}
						break;
					case 5:
						{
						setState(534);
						match(COMMA);
						}
						break;
					case 6:
						{
						setState(535);
						match(PERIOD);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(538); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(540);
					matchWildcard();
					}
					} 
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
			setState(547); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(546);
					match(BADWORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(549); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			{
			setState(554);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(551);
					matchWildcard();
					}
					} 
				}
				setState(556);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
			setState(558); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(557);
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
				setState(560); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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

	public static class DeclareWordSequenceContext extends ParserRuleContext {
		public List<TerminalNode> WORD_TYPE() { return getTokens(HOWL.WORD_TYPE); }
		public TerminalNode WORD_TYPE(int i) {
			return getToken(HOWL.WORD_TYPE, i);
		}
		public DeclareWordSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareWordSequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDeclareWordSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareWordSequenceContext declareWordSequence() throws RecognitionException {
		DeclareWordSequenceContext _localctx = new DeclareWordSequenceContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_declareWordSequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(563); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(562);
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
				setState(565); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		enterRule(_localctx, 112, RULE_debugWordSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(568); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(567);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(570); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return compoundNounPhrase_sempred((CompoundNounPhraseContext)_localctx, predIndex);
		case 22:
			return dataTypeExpression_sempred((DataTypeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean compoundNounPhrase_sempred(CompoundNounPhraseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean dataTypeExpression_sempred(DataTypeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u023f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\6\2{\n\2\r\2\16\2|\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\u008d\n\3\3\4\3\4\3\4\3\4\3\4\5\4\u0094\n\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\5\f\u00bb\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\5\16\u00ce\n\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00de\n\20\3\20\5\20"+
		"\u00e1\n\20\3\20\5\20\u00e4\n\20\3\20\3\20\3\20\5\20\u00e9\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f2\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u00fe\n\23\f\23\16\23\u0101\13\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u0109\n\23\3\23\3\23\3\23\7\23\u010e\n"+
		"\23\f\23\16\23\u0111\13\23\3\23\3\23\3\23\3\23\3\23\7\23\u0118\n\23\f"+
		"\23\16\23\u011b\13\23\3\23\3\23\7\23\u011f\n\23\f\23\16\23\u0122\13\23"+
		"\3\24\5\24\u0125\n\24\3\24\5\24\u0128\n\24\3\24\3\24\3\25\6\25\u012d\n"+
		"\25\r\25\16\25\u012e\3\26\5\26\u0132\n\26\3\26\5\26\u0135\n\26\3\26\5"+
		"\26\u0138\n\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0140\n\26\f\26\16\26"+
		"\u0143\13\26\5\26\u0145\n\26\3\27\6\27\u0148\n\27\r\27\16\27\u0149\3\30"+
		"\3\30\5\30\u014e\n\30\3\30\5\30\u0151\n\30\3\30\3\30\5\30\u0155\n\30\3"+
		"\30\3\30\3\30\3\30\5\30\u015b\n\30\3\30\3\30\3\30\6\30\u0160\n\30\r\30"+
		"\16\30\u0161\3\30\3\30\3\30\6\30\u0167\n\30\r\30\16\30\u0168\7\30\u016b"+
		"\n\30\f\30\16\30\u016e\13\30\3\31\5\31\u0171\n\31\3\31\5\31\u0174\n\31"+
		"\3\31\3\31\3\31\3\31\7\31\u017a\n\31\f\31\16\31\u017d\13\31\3\32\3\32"+
		"\5\32\u0181\n\32\3\32\5\32\u0184\n\32\3\32\3\32\5\32\u0188\n\32\3\32\3"+
		"\32\3\33\5\33\u018d\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u019a\n\35\3\36\3\36\3\37\5\37\u019f\n\37\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\5$\u01ad\n$\3%\3%\3%\3%\3%\3%\5%\u01b5"+
		"\n%\3&\3&\5&\u01b9\n&\3\'\3\'\5\'\u01bd\n\'\3\'\3\'\3(\5(\u01c2\n(\3("+
		"\5(\u01c5\n(\3(\3(\3(\3)\3)\5)\u01cc\n)\3)\3)\5)\u01d0\n)\3)\3)\3*\3*"+
		"\3*\5*\u01d7\n*\3*\5*\u01da\n*\3*\5*\u01dd\n*\3*\5*\u01e0\n*\3*\3*\3+"+
		"\3+\5+\u01e6\n+\3+\3+\3,\3,\5,\u01ec\n,\3-\3-\5-\u01f0\n-\3.\5.\u01f3"+
		"\n.\3.\5.\u01f6\n.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\5\63\u0208\n\63\3\64\3\64\3\64\5\64\u020d\n\64\3"+
		"\65\3\65\3\65\3\65\5\65\u0213\n\65\3\66\3\66\3\66\3\66\3\66\3\66\6\66"+
		"\u021b\n\66\r\66\16\66\u021c\3\67\7\67\u0220\n\67\f\67\16\67\u0223\13"+
		"\67\3\67\6\67\u0226\n\67\r\67\16\67\u0227\3\67\7\67\u022b\n\67\f\67\16"+
		"\67\u022e\13\67\38\68\u0231\n8\r8\168\u0232\39\69\u0236\n9\r9\169\u0237"+
		"\3:\6:\u023b\n:\r:\16:\u023c\3:\n\u0141\u017b\u021c\u0221\u022c\u0232"+
		"\u0237\u023c\4$.;\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnpr\2\20\4\2..\66\66\4\2\35\35%%\4\2"+
		"\n\n\27\27\4\2\n\n\25\25\4\2\23\23\66\66\7\2\3\3\5\5\23\23\64\64\66\66"+
		"\6\2\3\3\5\5\23\23\66\66\4\2\20\20\22\22\4\2\6\6\f\r\3\2\37#\4\2\16\16"+
		"\22\22\4\2\35\35&&\4\2\24\24\66\66\3\2\63\63\2\u0272\2z\3\2\2\2\4\u008c"+
		"\3\2\2\2\6\u0093\3\2\2\2\b\u0095\3\2\2\2\n\u0098\3\2\2\2\f\u009b\3\2\2"+
		"\2\16\u009e\3\2\2\2\20\u00a3\3\2\2\2\22\u00a9\3\2\2\2\24\u00af\3\2\2\2"+
		"\26\u00b6\3\2\2\2\30\u00bf\3\2\2\2\32\u00c8\3\2\2\2\34\u00d2\3\2\2\2\36"+
		"\u00d8\3\2\2\2 \u00ea\3\2\2\2\"\u00f3\3\2\2\2$\u0108\3\2\2\2&\u0124\3"+
		"\2\2\2(\u012c\3\2\2\2*\u0131\3\2\2\2,\u0147\3\2\2\2.\u015a\3\2\2\2\60"+
		"\u0170\3\2\2\2\62\u0180\3\2\2\2\64\u018c\3\2\2\2\66\u0190\3\2\2\28\u0199"+
		"\3\2\2\2:\u019b\3\2\2\2<\u019e\3\2\2\2>\u01a2\3\2\2\2@\u01a4\3\2\2\2B"+
		"\u01a6\3\2\2\2D\u01a8\3\2\2\2F\u01ac\3\2\2\2H\u01b4\3\2\2\2J\u01b8\3\2"+
		"\2\2L\u01bc\3\2\2\2N\u01c1\3\2\2\2P\u01c9\3\2\2\2R\u01d6\3\2\2\2T\u01e3"+
		"\3\2\2\2V\u01e9\3\2\2\2X\u01ed\3\2\2\2Z\u01f2\3\2\2\2\\\u01f9\3\2\2\2"+
		"^\u01fb\3\2\2\2`\u01fe\3\2\2\2b\u0201\3\2\2\2d\u0207\3\2\2\2f\u020c\3"+
		"\2\2\2h\u0212\3\2\2\2j\u021a\3\2\2\2l\u0221\3\2\2\2n\u0230\3\2\2\2p\u0235"+
		"\3\2\2\2r\u023a\3\2\2\2tu\5\4\3\2uv\7\t\2\2v{\3\2\2\2wx\5\6\4\2xy\7\t"+
		"\2\2y{\3\2\2\2zt\3\2\2\2zw\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\3\3"+
		"\2\2\2~\u008d\5\n\6\2\177\u008d\5\b\5\2\u0080\u008d\5\22\n\2\u0081\u008d"+
		"\5\20\t\2\u0082\u008d\5\30\r\2\u0083\u008d\5\26\f\2\u0084\u008d\5\f\7"+
		"\2\u0085\u008d\5\16\b\2\u0086\u008d\5 \21\2\u0087\u008d\5\"\22\2\u0088"+
		"\u008d\5\34\17\2\u0089\u008d\5\36\20\2\u008a\u008d\5\24\13\2\u008b\u008d"+
		"\5\32\16\2\u008c~\3\2\2\2\u008c\177\3\2\2\2\u008c\u0080\3\2\2\2\u008c"+
		"\u0081\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0084\3\2"+
		"\2\2\u008c\u0085\3\2\2\2\u008c\u0086\3\2\2\2\u008c\u0087\3\2\2\2\u008c"+
		"\u0088\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2"+
		"\2\2\u008d\5\3\2\2\2\u008e\u0094\5f\64\2\u008f\u0094\5h\65\2\u0090\u0094"+
		"\5j\66\2\u0091\u0094\5l\67\2\u0092\u0094\5r:\2\u0093\u008e\3\2\2\2\u0093"+
		"\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\7\3\2\2\2\u0095\u0096\5&\24\2\u0096\u0097\5b\62\2\u0097\t\3"+
		"\2\2\2\u0098\u0099\5&\24\2\u0099\u009a\5^\60\2\u009a\13\3\2\2\2\u009b"+
		"\u009c\5$\23\2\u009c\u009d\5^\60\2\u009d\r\3\2\2\2\u009e\u009f\7\35\2"+
		"\2\u009f\u00a0\t\2\2\2\u00a0\u00a1\5J&\2\u00a1\u00a2\5.\30\2\u00a2\17"+
		"\3\2\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a5\5$\23\2\u00a5\u00a6\5@!\2\u00a6"+
		"\u00a7\t\3\2\2\u00a7\u00a8\7\65\2\2\u00a8\21\3\2\2\2\u00a9\u00aa\7\31"+
		"\2\2\u00aa\u00ab\5$\23\2\u00ab\u00ac\5> \2\u00ac\u00ad\t\3\2\2\u00ad\u00ae"+
		"\7\64\2\2\u00ae\23\3\2\2\2\u00af\u00b0\7,\2\2\u00b0\u00b1\7\31\2\2\u00b1"+
		"\u00b2\5n8\2\u00b2\u00b3\5B\"\2\u00b3\u00b4\t\3\2\2\u00b4\u00b5\7\64\2"+
		"\2\u00b5\25\3\2\2\2\u00b6\u00b7\t\3\2\2\u00b7\u00b8\7\64\2\2\u00b8\u00ba"+
		"\5@!\2\u00b9\u00bb\7\34\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\7\31\2\2\u00bd\u00be\5.\30\2\u00be\27\3\2\2"+
		"\2\u00bf\u00c0\t\3\2\2\u00c0\u00c1\7\64\2\2\u00c1\u00c3\5> \2\u00c2\u00c4"+
		"\7\34\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2"+
		"\u00c5\u00c6\7\31\2\2\u00c6\u00c7\5$\23\2\u00c7\31\3\2\2\2\u00c8\u00c9"+
		"\7,\2\2\u00c9\u00ca\t\3\2\2\u00ca\u00cb\7\64\2\2\u00cb\u00cd\5B\"\2\u00cc"+
		"\u00ce\7\34\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3"+
		"\2\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d1\5n8\2\u00d1\33\3\2\2\2\u00d2\u00d3"+
		"\7&\2\2\u00d3\u00d4\5n8\2\u00d4\u00d5\7\63\2\2\u00d5\u00d6\7\22\2\2\u00d6"+
		"\u00d7\7\61\2\2\u00d7\35\3\2\2\2\u00d8\u00d9\7&\2\2\u00d9\u00da\5n8\2"+
		"\u00da\u00db\7\63\2\2\u00db\u00dd\7\22\2\2\u00dc\u00de\7\34\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\7\'"+
		"\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e4\7(\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\7&\2\2\u00e6\u00e8\5n8\2\u00e7\u00e9\7\63\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\37\3\2\2\2\u00ea\u00eb\7,\2\2\u00eb"+
		"\u00ec\5n8\2\u00ec\u00ed\7-\2\2\u00ed\u00ee\5n8\2\u00ee\u00f1\7-\2\2\u00ef"+
		"\u00f2\5\66\34\2\u00f0\u00f2\5n8\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2"+
		"\2\2\u00f2!\3\2\2\2\u00f3\u00f4\5p9\2\u00f4\u00f5\7\22\2\2\u00f5\u00f6"+
		"\7\35\2\2\u00f6\u00f7\7\63\2\2\u00f7#\3\2\2\2\u00f8\u00f9\b\23\1\2\u00f9"+
		"\u00fa\7\26\2\2\u00fa\u00ff\5$\23\2\u00fb\u00fc\t\4\2\2\u00fc\u00fe\5"+
		"$\23\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7\27"+
		"\2\2\u0103\u0104\5$\23\6\u0104\u0109\3\2\2\2\u0105\u0109\5&\24\2\u0106"+
		"\u0109\5*\26\2\u0107\u0109\7/\2\2\u0108\u00f8\3\2\2\2\u0108\u0105\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u0120\3\2\2\2\u010a"+
		"\u010f\f\b\2\2\u010b\u010c\t\4\2\2\u010c\u010e\5$\23\2\u010d\u010b\3\2"+
		"\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\27\2\2\u0113\u011f\5"+
		"$\23\t\u0114\u0119\f\7\2\2\u0115\u0116\t\5\2\2\u0116\u0118\5$\23\2\u0117"+
		"\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2"+
		"\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\25\2\2\u011d"+
		"\u011f\5$\23\b\u011e\u010a\3\2\2\2\u011e\u0114\3\2\2\2\u011f\u0122\3\2"+
		"\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121%\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0123\u0125\7\34\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2"+
		"\u0125\u0127\3\2\2\2\u0126\u0128\7&\2\2\u0127\u0126\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\5(\25\2\u012a\'\3\2\2\2\u012b"+
		"\u012d\t\6\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f)\3\2\2\2\u0130\u0132\7\34\2\2\u0131\u0130"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0135\58\35\2\u0134"+
		"\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0138\5,"+
		"\27\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u0144\t\7\2\2\u013a\u013b\7)\2\2\u013b\u0141\5d\63\2\u013c\u013d\7\25"+
		"\2\2\u013d\u013e\7)\2\2\u013e\u0140\5d\63\2\u013f\u013c\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u0142\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0144\u013a\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"+\3\2\2\2\u0146\u0148\t\b\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a-\3\2\2\2\u014b\u014d\b"+
		"\30\1\2\u014c\u014e\7\34\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0150\3\2\2\2\u014f\u0151\58\35\2\u0150\u014f\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0154\3\2\2\2\u0152\u0155\7.\2\2\u0153\u0155\7\66\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u015b\3\2\2\2\u0156\u0157\7\34"+
		"\2\2\u0157\u015b\5.\30\5\u0158\u015b\5\60\31\2\u0159\u015b\5\64\33\2\u015a"+
		"\u014b\3\2\2\2\u015a\u0156\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2"+
		"\2\2\u015b\u016c\3\2\2\2\u015c\u015f\f\b\2\2\u015d\u015e\t\4\2\2\u015e"+
		"\u0160\5.\30\2\u015f\u015d\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2"+
		"\2\2\u0161\u0162\3\2\2\2\u0162\u016b\3\2\2\2\u0163\u0166\f\7\2\2\u0164"+
		"\u0165\t\5\2\2\u0165\u0167\5.\30\2\u0166\u0164\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a"+
		"\u015c\3\2\2\2\u016a\u0163\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d/\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0171"+
		"\7\34\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2"+
		"\u0172\u0174\58\35\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0176\t\2\2\2\u0176\u017b\5\62\32\2\u0177\u0178\7\25\2"+
		"\2\u0178\u017a\5\62\32\2\u0179\u0177\3\2\2\2\u017a\u017d\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c\61\3\2\2\2\u017d\u017b\3\2\2"+
		"\2\u017e\u017f\7)\2\2\u017f\u0181\t\t\2\2\u0180\u017e\3\2\2\2\u0180\u0181"+
		"\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0184\7\35\2\2\u0183\u0182\3\2\2\2"+
		"\u0183\u0184\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0188\7$\2\2\u0186\u0188"+
		"\5:\36\2\u0187\u0185\3\2\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\u018a\5\66\34\2\u018a\63\3\2\2\2\u018b\u018d\7\34\2\2\u018c\u018b\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\5\66\34\2\u018f"+
		"\65\3\2\2\2\u0190\u0191\t\n\2\2\u0191\67\3\2\2\2\u0192\u019a\7\35\2\2"+
		"\u0193\u019a\7&\2\2\u0194\u019a\7\36\2\2\u0195\u019a\7%\2\2\u0196\u019a"+
		"\7\32\2\2\u0197\u019a\7\31\2\2\u0198\u019a\5<\37\2\u0199\u0192\3\2\2\2"+
		"\u0199\u0193\3\2\2\2\u0199\u0194\3\2\2\2\u0199\u0195\3\2\2\2\u0199\u0196"+
		"\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a9\3\2\2\2\u019b"+
		"\u019c\t\13\2\2\u019c;\3\2\2\2\u019d\u019f\5:\36\2\u019e\u019d\3\2\2\2"+
		"\u019e\u019f\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\7\f\2\2\u01a1=\3"+
		"\2\2\2\u01a2\u01a3\5F$\2\u01a3?\3\2\2\2\u01a4\u01a5\5F$\2\u01a5A\3\2\2"+
		"\2\u01a6\u01a7\5F$\2\u01a7C\3\2\2\2\u01a8\u01a9\5H%\2\u01a9E\3\2\2\2\u01aa"+
		"\u01ad\5H%\2\u01ab\u01ad\5J&\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2"+
		"\u01adG\3\2\2\2\u01ae\u01b5\5L\'\2\u01af\u01b5\5N(\2\u01b0\u01b5\5P)\2"+
		"\u01b1\u01b5\5R*\2\u01b2\u01b5\5Z.\2\u01b3\u01b5\5X-\2\u01b4\u01ae\3\2"+
		"\2\2\u01b4\u01af\3\2\2\2\u01b4\u01b0\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4"+
		"\u01b2\3\2\2\2\u01b4\u01b3\3\2\2\2\u01b5I\3\2\2\2\u01b6\u01b9\5V,\2\u01b7"+
		"\u01b9\5T+\2\u01b8\u01b6\3\2\2\2\u01b8\u01b7\3\2\2\2\u01b9K\3\2\2\2\u01ba"+
		"\u01bb\7\16\2\2\u01bb\u01bd\7\34\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3"+
		"\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\5\\/\2\u01bfM\3\2\2\2\u01c0\u01c2"+
		"\t\f\2\2\u01c1\u01c0\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3"+
		"\u01c5\7\34\2\2\u01c4\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3"+
		"\2\2\2\u01c6\u01c7\5\\/\2\u01c7\u01c8\7\21\2\2\u01c8O\3\2\2\2\u01c9\u01cb"+
		"\7\22\2\2\u01ca\u01cc\7\34\2\2\u01cb\u01ca\3\2\2\2\u01cb\u01cc\3\2\2\2"+
		"\u01cc\u01cd\3\2\2\2\u01cd\u01cf\5\\/\2\u01ce\u01d0\7\21\2\2\u01cf\u01ce"+
		"\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\7\30\2\2"+
		"\u01d2Q\3\2\2\2\u01d3\u01d7\7\22\2\2\u01d4\u01d7\7\20\2\2\u01d5\u01d7"+
		"\5\\/\2\u01d6\u01d3\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7"+
		"\u01d9\3\2\2\2\u01d8\u01da\7\34\2\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3"+
		"\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01dd\t\r\2\2\u01dc\u01db\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de\u01e0\5,\27\2\u01df\u01de\3\2"+
		"\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\7\21\2\2\u01e2"+
		"S\3\2\2\2\u01e3\u01e5\7\22\2\2\u01e4\u01e6\7\34\2\2\u01e5\u01e4\3\2\2"+
		"\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\7\'\2\2\u01e8U"+
		"\3\2\2\2\u01e9\u01eb\7\22\2\2\u01ea\u01ec\7\34\2\2\u01eb\u01ea\3\2\2\2"+
		"\u01eb\u01ec\3\2\2\2\u01ecW\3\2\2\2\u01ed\u01ef\7\16\2\2\u01ee\u01f0\7"+
		"\34\2\2\u01ef\u01ee\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0Y\3\2\2\2\u01f1\u01f3"+
		"\7\16\2\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\3\2\2\2"+
		"\u01f4\u01f6\7\34\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7"+
		"\3\2\2\2\u01f7\u01f8\7\20\2\2\u01f8[\3\2\2\2\u01f9\u01fa\t\16\2\2\u01fa"+
		"]\3\2\2\2\u01fb\u01fc\5> \2\u01fc\u01fd\5$\23\2\u01fd_\3\2\2\2\u01fe\u01ff"+
		"\5@!\2\u01ff\u0200\5.\30\2\u0200a\3\2\2\2\u0201\u0202\5D#\2\u0202\u0203"+
		"\5\64\33\2\u0203c\3\2\2\2\u0204\u0208\5^\60\2\u0205\u0208\5`\61\2\u0206"+
		"\u0208\5b\62\2\u0207\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0206\3\2"+
		"\2\2\u0208e\3\2\2\2\u0209\u020d\5$\23\2\u020a\u020d\5^\60\2\u020b\u020d"+
		"\5F$\2\u020c\u0209\3\2\2\2\u020c\u020a\3\2\2\2\u020c\u020b\3\2\2\2\u020d"+
		"g\3\2\2\2\u020e\u0213\5.\30\2\u020f\u0213\5`\61\2\u0210\u0213\5b\62\2"+
		"\u0211\u0213\5\62\32\2\u0212\u020e\3\2\2\2\u0212\u020f\3\2\2\2\u0212\u0210"+
		"\3\2\2\2\u0212\u0211\3\2\2\2\u0213i\3\2\2\2\u0214\u021b\5f\64\2\u0215"+
		"\u021b\5h\65\2\u0216\u021b\7\25\2\2\u0217\u021b\7\27\2\2\u0218\u021b\7"+
		"\n\2\2\u0219\u021b\7\t\2\2\u021a\u0214\3\2\2\2\u021a\u0215\3\2\2\2\u021a"+
		"\u0216\3\2\2\2\u021a\u0217\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u0219\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021c\u021a\3\2\2\2\u021d"+
		"k\3\2\2\2\u021e\u0220\13\2\2\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2\2"+
		"\u0221\u0222\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221"+
		"\3\2\2\2\u0224\u0226\7\4\2\2\u0225\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u022c\3\2\2\2\u0229\u022b\13"+
		"\2\2\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022d\3\2\2\2\u022c"+
		"\u022a\3\2\2\2\u022dm\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0231\n\17\2\2"+
		"\u0230\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\3\2\2\2\u0232\u0230"+
		"\3\2\2\2\u0233o\3\2\2\2\u0234\u0236\n\17\2\2\u0235\u0234\3\2\2\2\u0236"+
		"\u0237\3\2\2\2\u0237\u0238\3\2\2\2\u0237\u0235\3\2\2\2\u0238q\3\2\2\2"+
		"\u0239\u023b\13\2\2\2\u023a\u0239\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d"+
		"\3\2\2\2\u023c\u023a\3\2\2\2\u023ds\3\2\2\2Jz|\u008c\u0093\u00ba\u00c3"+
		"\u00cd\u00dd\u00e0\u00e3\u00e8\u00f1\u00ff\u0108\u010f\u0119\u011e\u0120"+
		"\u0124\u0127\u012e\u0131\u0134\u0137\u0141\u0144\u0149\u014d\u0150\u0154"+
		"\u015a\u0161\u0168\u016a\u016c\u0170\u0173\u017b\u0180\u0183\u0187\u018c"+
		"\u0199\u019e\u01ac\u01b4\u01b8\u01bc\u01c1\u01c4\u01cb\u01cf\u01d6\u01d9"+
		"\u01dc\u01df\u01e5\u01eb\u01ef\u01f2\u01f5\u0207\u020c\u0212\u021a\u021c"+
		"\u0221\u0227\u022c\u0232\u0237\u023c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}