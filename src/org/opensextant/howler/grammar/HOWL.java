// Generated from HOWL.g4 by ANTLR 4.5.3

 package org.opensextant.howler.grammar;

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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		A=1, ABL=2, ABN=3, ABX=4, ALSO=5, AND=6, ANYX=7, AP=8, APOS=9, AT=10, 
		BE=11, BED=12, BEDZ=13, BEG=14, BEM=15, BEN=16, BER=17, BEZ=18, BY=19, 
		CC=20, CD=21, CLOSEPAREN=22, COLON=23, COMMA=24, CS=25, DASH=26, DO=27, 
		DOD=28, DOZ=29, DQUOTE=30, DT=31, DTI=32, DTS=33, DTX=34, EVERY=35, EVERYX=36, 
		EX=37, EXACT=38, GROUPOF=39, HV=40, HVD=41, HVG=42, HVN=43, HVZ=44, IF=45, 
		IN=46, JJ=47, JJR=48, JJS=49, JJT=50, LESS=51, LESSOREQUAL=52, MD=53, 
		MORE=54, MOREOREQUAL=55, MUST=56, NN=57, NNS=58, NONE=59, NOT=60, NOX=61, 
		NP=62, NPS=63, NR=64, NRS=65, OD=66, ONLY=67, OPENPAREN=68, OR=69, PERIOD=70, 
		PN=71, POSS=72, PPL=73, PPLS=74, PPO=75, PPS=76, PPSS=77, PPx=78, PPxx=79, 
		QL=80, QLP=81, RB=82, RBR=83, RBT=84, RN=85, RP=86, SAMEAS=87, SOME=88, 
		SOMEX=89, THAT=90, THE=91, THEN=92, THING=93, TIC=94, TO=95, QMARK=96, 
		VB=97, VBD=98, VBG=99, VBN=100, VBZ=101, WDT=102, WPO=103, WPS=104, WPx=105, 
		WQL=106, WRB=107, WHATV=108;
	public static final int
		RULE_document = 0, RULE_sentence = 1, RULE_simpleSentence = 2, RULE_np = 3, 
		RULE_nbar = 4, RULE_nbarProper = 5, RULE_nbarCommon = 6, RULE_nSimple = 7, 
		RULE_nProper = 8, RULE_nProperSequence = 9, RULE_nThing = 10, RULE_nAdj = 11, 
		RULE_adjp = 12, RULE_quant = 13, RULE_quantNeg = 14, RULE_quantThe = 15, 
		RULE_quantA = 16, RULE_quantUniverse = 17, RULE_quantExist = 18, RULE_quantNumeric = 19, 
		RULE_exact = 20, RULE_more = 21, RULE_less = 22, RULE_moreOrEqual = 23, 
		RULE_lessOrEqual = 24, RULE_vp = 25, RULE_vbar = 26, RULE_vbarSimple = 27, 
		RULE_vbarPassive = 28, RULE_vbarAdj = 29, RULE_v = 30, RULE_vSimple = 31, 
		RULE_vParticle = 32, RULE_vPassive = 33, RULE_vBE = 34, RULE_vSameAs = 35, 
		RULE_vDO = 36, RULE_vHAS = 37, RULE_verbBE = 38, RULE_verbDO = 39, RULE_verbHAS = 40, 
		RULE_verb = 41, RULE_modal = 42, RULE_phraseSet = 43, RULE_junk = 44, 
		RULE_j = 45, RULE_phrase = 46, RULE_catchPhrase = 47, RULE_adjWord = 48, 
		RULE_advWord = 49, RULE_connWord = 50, RULE_detWord = 51, RULE_modWord = 52, 
		RULE_nounWord = 53, RULE_punctWord = 54, RULE_verbWord = 55, RULE_phraseWord = 56;
	public static final String[] ruleNames = {
		"document", "sentence", "simpleSentence", "np", "nbar", "nbarProper", 
		"nbarCommon", "nSimple", "nProper", "nProperSequence", "nThing", "nAdj", 
		"adjp", "quant", "quantNeg", "quantThe", "quantA", "quantUniverse", "quantExist", 
		"quantNumeric", "exact", "more", "less", "moreOrEqual", "lessOrEqual", 
		"vp", "vbar", "vbarSimple", "vbarPassive", "vbarAdj", "v", "vSimple", 
		"vParticle", "vPassive", "vBE", "vSameAs", "vDO", "vHAS", "verbBE", "verbDO", 
		"verbHAS", "verb", "modal", "phraseSet", "junk", "j", "phrase", "catchPhrase", 
		"adjWord", "advWord", "connWord", "detWord", "modWord", "nounWord", "punctWord", 
		"verbWord", "phraseWord"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "A", "ABL", "ABN", "ABX", "ALSO", "AND", "ANYX", "AP", "APOS", "AT", 
		"BE", "BED", "BEDZ", "BEG", "BEM", "BEN", "BER", "BEZ", "BY", "CC", "CD", 
		"CLOSEPAREN", "COLON", "COMMA", "CS", "DASH", "DO", "DOD", "DOZ", "DQUOTE", 
		"DT", "DTI", "DTS", "DTX", "EVERY", "EVERYX", "EX", "EXACT", "GROUPOF", 
		"HV", "HVD", "HVG", "HVN", "HVZ", "IF", "IN", "JJ", "JJR", "JJS", "JJT", 
		"LESS", "LESSOREQUAL", "MD", "MORE", "MOREOREQUAL", "MUST", "NN", "NNS", 
		"NONE", "NOT", "NOX", "NP", "NPS", "NR", "NRS", "OD", "ONLY", "OPENPAREN", 
		"OR", "PERIOD", "PN", "POSS", "PPL", "PPLS", "PPO", "PPS", "PPSS", "PPx", 
		"PPxx", "QL", "QLP", "RB", "RBR", "RBT", "RN", "RP", "SAMEAS", "SOME", 
		"SOMEX", "THAT", "THE", "THEN", "THING", "TIC", "TO", "QMARK", "VB", "VBD", 
		"VBG", "VBN", "VBZ", "WDT", "WPO", "WPS", "WPx", "WQL", "WRB", "WHATV"
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
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(HOWL.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(HOWL.PERIOD, i);
		}
		public List<JunkContext> junk() {
			return getRuleContexts(JunkContext.class);
		}
		public JunkContext junk(int i) {
			return getRuleContext(JunkContext.class,i);
		}
		public List<TerminalNode> QMARK() { return getTokens(HOWL.QMARK); }
		public TerminalNode QMARK(int i) {
			return getToken(HOWL.QMARK, i);
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
					setState(114);
					sentence();
					setState(115);
					match(PERIOD);
					}
					break;
				case 2:
					{
					setState(117);
					junk();
					setState(118);
					_la = _input.LA(1);
					if ( !(_la==PERIOD || _la==QMARK) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << ABL) | (1L << ABN) | (1L << ABX) | (1L << ALSO) | (1L << AND) | (1L << ANYX) | (1L << AP) | (1L << APOS) | (1L << AT) | (1L << BE) | (1L << BED) | (1L << BEDZ) | (1L << BEG) | (1L << BEM) | (1L << BEN) | (1L << BER) | (1L << BEZ) | (1L << BY) | (1L << CC) | (1L << CD) | (1L << CLOSEPAREN) | (1L << COLON) | (1L << COMMA) | (1L << CS) | (1L << DASH) | (1L << DO) | (1L << DOD) | (1L << DOZ) | (1L << DQUOTE) | (1L << DT) | (1L << DTI) | (1L << DTS) | (1L << DTX) | (1L << EVERY) | (1L << EVERYX) | (1L << EX) | (1L << EXACT) | (1L << GROUPOF) | (1L << HV) | (1L << HVD) | (1L << HVG) | (1L << HVN) | (1L << HVZ) | (1L << IF) | (1L << IN) | (1L << JJ) | (1L << JJR) | (1L << JJS) | (1L << JJT) | (1L << LESS) | (1L << LESSOREQUAL) | (1L << MD) | (1L << MORE) | (1L << MOREOREQUAL) | (1L << MUST) | (1L << NN) | (1L << NNS) | (1L << NONE) | (1L << NOT) | (1L << NOX) | (1L << NP) | (1L << NPS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NR - 64)) | (1L << (NRS - 64)) | (1L << (OD - 64)) | (1L << (ONLY - 64)) | (1L << (OPENPAREN - 64)) | (1L << (OR - 64)) | (1L << (PERIOD - 64)) | (1L << (PN - 64)) | (1L << (POSS - 64)) | (1L << (PPL - 64)) | (1L << (PPLS - 64)) | (1L << (PPO - 64)) | (1L << (PPS - 64)) | (1L << (PPSS - 64)) | (1L << (PPx - 64)) | (1L << (PPxx - 64)) | (1L << (QL - 64)) | (1L << (QLP - 64)) | (1L << (RB - 64)) | (1L << (RBR - 64)) | (1L << (RBT - 64)) | (1L << (RN - 64)) | (1L << (RP - 64)) | (1L << (SAMEAS - 64)) | (1L << (SOME - 64)) | (1L << (SOMEX - 64)) | (1L << (THAT - 64)) | (1L << (THE - 64)) | (1L << (THEN - 64)) | (1L << (THING - 64)) | (1L << (TIC - 64)) | (1L << (TO - 64)) | (1L << (QMARK - 64)) | (1L << (VB - 64)) | (1L << (VBD - 64)) | (1L << (VBG - 64)) | (1L << (VBN - 64)) | (1L << (VBZ - 64)) | (1L << (WDT - 64)) | (1L << (WPO - 64)) | (1L << (WPS - 64)) | (1L << (WPx - 64)) | (1L << (WQL - 64)) | (1L << (WRB - 64)))) != 0) );
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

	public static class SentenceContext extends ParserRuleContext {
		public SimpleSentenceContext simpleSentence() {
			return getRuleContext(SimpleSentenceContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			simpleSentence();
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

	public static class SimpleSentenceContext extends ParserRuleContext {
		public NpContext np() {
			return getRuleContext(NpContext.class,0);
		}
		public List<VpContext> vp() {
			return getRuleContexts(VpContext.class);
		}
		public VpContext vp(int i) {
			return getRuleContext(VpContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public SimpleSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitSimpleSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleSentenceContext simpleSentence() throws RecognitionException {
		SimpleSentenceContext _localctx = new SimpleSentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			np();
			setState(127);
			vp();
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				{
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(128);
					match(AND);
					setState(129);
					vp();
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OR) {
					{
					{
					setState(135);
					match(OR);
					setState(136);
					vp();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class NpContext extends ParserRuleContext {
		public List<NbarContext> nbar() {
			return getRuleContexts(NbarContext.class);
		}
		public NbarContext nbar(int i) {
			return getRuleContext(NbarContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(HOWL.OR); }
		public TerminalNode OR(int i) {
			return getToken(HOWL.OR, i);
		}
		public NpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_np; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NpContext np() throws RecognitionException {
		NpContext _localctx = new NpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_np);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			nbar();
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				{
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(145);
						match(AND);
						setState(146);
						nbar();
						}
						} 
					}
					setState(151);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(152);
						match(OR);
						setState(153);
						nbar();
						}
						} 
					}
					setState(158);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
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

	public static class NbarContext extends ParserRuleContext {
		public NbarProperContext nbarProper() {
			return getRuleContext(NbarProperContext.class,0);
		}
		public NbarCommonContext nbarCommon() {
			return getRuleContext(NbarCommonContext.class,0);
		}
		public NbarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nbar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNbar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NbarContext nbar() throws RecognitionException {
		NbarContext _localctx = new NbarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nbar);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				nbarProper();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				nbarCommon();
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

	public static class NbarProperContext extends ParserRuleContext {
		public NProperSequenceContext nProperSequence() {
			return getRuleContext(NProperSequenceContext.class,0);
		}
		public QuantNegContext quantNeg() {
			return getRuleContext(QuantNegContext.class,0);
		}
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public NbarProperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nbarProper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNbarProper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NbarProperContext nbarProper() throws RecognitionException {
		NbarProperContext _localctx = new NbarProperContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nbarProper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if (_la==NONE) {
				{
				setState(165);
				quantNeg();
				}
			}

			setState(169);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << CD) | (1L << EVERY) | (1L << EXACT) | (1L << LESS) | (1L << LESSOREQUAL) | (1L << MORE) | (1L << MOREOREQUAL))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (ONLY - 67)) | (1L << (SOME - 67)) | (1L << (THE - 67)))) != 0)) {
				{
				setState(168);
				quant();
				}
			}

			setState(171);
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

	public static class NbarCommonContext extends ParserRuleContext {
		public NSimpleContext nSimple() {
			return getRuleContext(NSimpleContext.class,0);
		}
		public NThingContext nThing() {
			return getRuleContext(NThingContext.class,0);
		}
		public NAdjContext nAdj() {
			return getRuleContext(NAdjContext.class,0);
		}
		public QuantNegContext quantNeg() {
			return getRuleContext(QuantNegContext.class,0);
		}
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
		public List<VbarContext> vbar() {
			return getRuleContexts(VbarContext.class);
		}
		public VbarContext vbar(int i) {
			return getRuleContext(VbarContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(HOWL.AND); }
		public TerminalNode AND(int i) {
			return getToken(HOWL.AND, i);
		}
		public NbarCommonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nbarCommon; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNbarCommon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NbarCommonContext nbarCommon() throws RecognitionException {
		NbarCommonContext _localctx = new NbarCommonContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nbarCommon);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if (_la==NONE) {
				{
				setState(173);
				quantNeg();
				}
			}

			setState(177);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << CD) | (1L << EVERY) | (1L << EXACT) | (1L << LESS) | (1L << LESSOREQUAL) | (1L << MORE) | (1L << MOREOREQUAL))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (ONLY - 67)) | (1L << (SOME - 67)) | (1L << (THE - 67)))) != 0)) {
				{
				setState(176);
				quant();
				}
			}

			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(179);
				adjp();
				}
				break;
			}
			setState(185);
			switch (_input.LA(1)) {
			case NN:
			case NNS:
				{
				setState(182);
				nSimple();
				}
				break;
			case ANYX:
			case EVERYX:
			case NOX:
			case SOMEX:
			case THING:
				{
				setState(183);
				nThing();
				}
				break;
			case JJ:
			case JJR:
			case JJS:
			case JJT:
			case VBG:
			case VBN:
				{
				setState(184);
				nAdj();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(187);
				match(THAT);
				setState(188);
				vbar();
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(189);
						match(AND);
						setState(190);
						match(THAT);
						setState(191);
						vbar();
						}
						} 
					}
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class NSimpleContext extends ParserRuleContext {
		public TerminalNode NN() { return getToken(HOWL.NN, 0); }
		public TerminalNode NNS() { return getToken(HOWL.NNS, 0); }
		public NSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NSimpleContext nSimple() throws RecognitionException {
		NSimpleContext _localctx = new NSimpleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_nSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==NN || _la==NNS) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NProperContext extends ParserRuleContext {
		public TerminalNode NP() { return getToken(HOWL.NP, 0); }
		public TerminalNode NPS() { return getToken(HOWL.NPS, 0); }
		public NProperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nProper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNProper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NProperContext nProper() throws RecognitionException {
		NProperContext _localctx = new NProperContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nProper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !(_la==NP || _la==NPS) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NProperSequenceContext extends ParserRuleContext {
		public AdjpContext adjp() {
			return getRuleContext(AdjpContext.class,0);
		}
		public List<NProperContext> nProper() {
			return getRuleContexts(NProperContext.class);
		}
		public NProperContext nProper(int i) {
			return getRuleContext(NProperContext.class,i);
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
		enterRule(_localctx, 18, RULE_nProperSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(203);
				adjp();
				}
				break;
			}
			setState(207); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(206);
					nProper();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(209); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class NThingContext extends ParserRuleContext {
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode SOMEX() { return getToken(HOWL.SOMEX, 0); }
		public TerminalNode EVERYX() { return getToken(HOWL.EVERYX, 0); }
		public TerminalNode ANYX() { return getToken(HOWL.ANYX, 0); }
		public TerminalNode NOX() { return getToken(HOWL.NOX, 0); }
		public NThingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nThing; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNThing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NThingContext nThing() throws RecognitionException {
		NThingContext _localctx = new NThingContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nThing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANYX) | (1L << EVERYX) | (1L << NOX))) != 0) || _la==SOMEX || _la==THING) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NAdjContext extends ParserRuleContext {
		public TerminalNode JJ() { return getToken(HOWL.JJ, 0); }
		public TerminalNode JJR() { return getToken(HOWL.JJR, 0); }
		public TerminalNode JJS() { return getToken(HOWL.JJS, 0); }
		public TerminalNode JJT() { return getToken(HOWL.JJT, 0); }
		public TerminalNode VBG() { return getToken(HOWL.VBG, 0); }
		public TerminalNode VBN() { return getToken(HOWL.VBN, 0); }
		public NAdjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nAdj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNAdj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NAdjContext nAdj() throws RecognitionException {
		NAdjContext _localctx = new NAdjContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nAdj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (JJ - 47)) | (1L << (JJR - 47)) | (1L << (JJS - 47)) | (1L << (JJT - 47)) | (1L << (VBG - 47)) | (1L << (VBN - 47)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class AdjpContext extends ParserRuleContext {
		public List<TerminalNode> JJ() { return getTokens(HOWL.JJ); }
		public TerminalNode JJ(int i) {
			return getToken(HOWL.JJ, i);
		}
		public List<TerminalNode> JJR() { return getTokens(HOWL.JJR); }
		public TerminalNode JJR(int i) {
			return getToken(HOWL.JJR, i);
		}
		public List<TerminalNode> JJS() { return getTokens(HOWL.JJS); }
		public TerminalNode JJS(int i) {
			return getToken(HOWL.JJS, i);
		}
		public List<TerminalNode> JJT() { return getTokens(HOWL.JJT); }
		public TerminalNode JJT(int i) {
			return getToken(HOWL.JJT, i);
		}
		public List<TerminalNode> OD() { return getTokens(HOWL.OD); }
		public TerminalNode OD(int i) {
			return getToken(HOWL.OD, i);
		}
		public List<TerminalNode> NP() { return getTokens(HOWL.NP); }
		public TerminalNode NP(int i) {
			return getToken(HOWL.NP, i);
		}
		public List<TerminalNode> NPS() { return getTokens(HOWL.NPS); }
		public TerminalNode NPS(int i) {
			return getToken(HOWL.NPS, i);
		}
		public List<TerminalNode> POSS() { return getTokens(HOWL.POSS); }
		public TerminalNode POSS(int i) {
			return getToken(HOWL.POSS, i);
		}
		public List<TerminalNode> NN() { return getTokens(HOWL.NN); }
		public TerminalNode NN(int i) {
			return getToken(HOWL.NN, i);
		}
		public List<TerminalNode> NR() { return getTokens(HOWL.NR); }
		public TerminalNode NR(int i) {
			return getToken(HOWL.NR, i);
		}
		public List<TerminalNode> NNS() { return getTokens(HOWL.NNS); }
		public TerminalNode NNS(int i) {
			return getToken(HOWL.NNS, i);
		}
		public List<TerminalNode> VBG() { return getTokens(HOWL.VBG); }
		public TerminalNode VBG(int i) {
			return getToken(HOWL.VBG, i);
		}
		public List<TerminalNode> VBN() { return getTokens(HOWL.VBN); }
		public TerminalNode VBN(int i) {
			return getToken(HOWL.VBN, i);
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
		enterRule(_localctx, 24, RULE_adjp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(215);
					_la = _input.LA(1);
					if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (JJ - 47)) | (1L << (JJR - 47)) | (1L << (JJS - 47)) | (1L << (JJT - 47)) | (1L << (NN - 47)) | (1L << (NNS - 47)) | (1L << (NP - 47)) | (1L << (NPS - 47)) | (1L << (NR - 47)) | (1L << (OD - 47)) | (1L << (POSS - 47)) | (1L << (VBG - 47)) | (1L << (VBN - 47)))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(218); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class QuantContext extends ParserRuleContext {
		public QuantUniverseContext quantUniverse() {
			return getRuleContext(QuantUniverseContext.class,0);
		}
		public QuantExistContext quantExist() {
			return getRuleContext(QuantExistContext.class,0);
		}
		public QuantNumericContext quantNumeric() {
			return getRuleContext(QuantNumericContext.class,0);
		}
		public QuantAContext quantA() {
			return getRuleContext(QuantAContext.class,0);
		}
		public QuantTheContext quantThe() {
			return getRuleContext(QuantTheContext.class,0);
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
		enterRule(_localctx, 26, RULE_quant);
		try {
			setState(225);
			switch (_input.LA(1)) {
			case EVERY:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				quantUniverse();
				}
				break;
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				quantExist();
				}
				break;
			case CD:
			case EXACT:
			case LESS:
			case LESSOREQUAL:
			case MORE:
			case MOREOREQUAL:
			case ONLY:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				quantNumeric();
				}
				break;
			case A:
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				quantA();
				}
				break;
			case THE:
				enterOuterAlt(_localctx, 5);
				{
				setState(224);
				quantThe();
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

	public static class QuantNegContext extends ParserRuleContext {
		public TerminalNode NONE() { return getToken(HOWL.NONE, 0); }
		public QuantNegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantNeg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantNegContext quantNeg() throws RecognitionException {
		QuantNegContext _localctx = new QuantNegContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_quantNeg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(NONE);
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

	public static class QuantTheContext extends ParserRuleContext {
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public QuantTheContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantThe; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantThe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantTheContext quantThe() throws RecognitionException {
		QuantTheContext _localctx = new QuantTheContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_quantThe);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(THE);
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

	public static class QuantAContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public QuantAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantA; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantAContext quantA() throws RecognitionException {
		QuantAContext _localctx = new QuantAContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_quantA);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(A);
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

	public static class QuantUniverseContext extends ParserRuleContext {
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public QuantUniverseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantUniverse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantUniverse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantUniverseContext quantUniverse() throws RecognitionException {
		QuantUniverseContext _localctx = new QuantUniverseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_quantUniverse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(EVERY);
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

	public static class QuantExistContext extends ParserRuleContext {
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public QuantExistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantExist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitQuantExist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantExistContext quantExist() throws RecognitionException {
		QuantExistContext _localctx = new QuantExistContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_quantExist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(SOME);
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
		public TerminalNode CD() { return getToken(HOWL.CD, 0); }
		public ExactContext exact() {
			return getRuleContext(ExactContext.class,0);
		}
		public MoreContext more() {
			return getRuleContext(MoreContext.class,0);
		}
		public LessContext less() {
			return getRuleContext(LessContext.class,0);
		}
		public MoreOrEqualContext moreOrEqual() {
			return getRuleContext(MoreOrEqualContext.class,0);
		}
		public LessOrEqualContext lessOrEqual() {
			return getRuleContext(LessOrEqualContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_quantNumeric);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			switch (_input.LA(1)) {
			case EXACT:
			case ONLY:
				{
				setState(237);
				exact();
				}
				break;
			case MORE:
				{
				setState(238);
				more();
				}
				break;
			case LESS:
				{
				setState(239);
				less();
				}
				break;
			case MOREOREQUAL:
				{
				setState(240);
				moreOrEqual();
				}
				break;
			case LESSOREQUAL:
				{
				setState(241);
				lessOrEqual();
				}
				break;
			case CD:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(244);
			match(CD);
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

	public static class ExactContext extends ParserRuleContext {
		public TerminalNode EXACT() { return getToken(HOWL.EXACT, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public ExactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exact; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitExact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExactContext exact() throws RecognitionException {
		ExactContext _localctx = new ExactContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exact);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( !(_la==EXACT || _la==ONLY) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class MoreContext extends ParserRuleContext {
		public TerminalNode MORE() { return getToken(HOWL.MORE, 0); }
		public MoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_more; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitMore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreContext more() throws RecognitionException {
		MoreContext _localctx = new MoreContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_more);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(MORE);
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

	public static class LessContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(HOWL.LESS, 0); }
		public LessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_less; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitLess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessContext less() throws RecognitionException {
		LessContext _localctx = new LessContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_less);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(LESS);
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

	public static class MoreOrEqualContext extends ParserRuleContext {
		public TerminalNode MOREOREQUAL() { return getToken(HOWL.MOREOREQUAL, 0); }
		public MoreOrEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moreOrEqual; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitMoreOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreOrEqualContext moreOrEqual() throws RecognitionException {
		MoreOrEqualContext _localctx = new MoreOrEqualContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_moreOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(MOREOREQUAL);
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

	public static class LessOrEqualContext extends ParserRuleContext {
		public TerminalNode LESSOREQUAL() { return getToken(HOWL.LESSOREQUAL, 0); }
		public LessOrEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessOrEqual; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitLessOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessOrEqualContext lessOrEqual() throws RecognitionException {
		LessOrEqualContext _localctx = new LessOrEqualContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_lessOrEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(LESSOREQUAL);
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

	public static class VpContext extends ParserRuleContext {
		public VbarContext vbar() {
			return getRuleContext(VbarContext.class,0);
		}
		public VpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VpContext vp() throws RecognitionException {
		VpContext _localctx = new VpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_vp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			vbar();
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

	public static class VbarContext extends ParserRuleContext {
		public VbarPassiveContext vbarPassive() {
			return getRuleContext(VbarPassiveContext.class,0);
		}
		public VbarSimpleContext vbarSimple() {
			return getRuleContext(VbarSimpleContext.class,0);
		}
		public VbarAdjContext vbarAdj() {
			return getRuleContext(VbarAdjContext.class,0);
		}
		public VbarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vbar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVbar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VbarContext vbar() throws RecognitionException {
		VbarContext _localctx = new VbarContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_vbar);
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				vbarPassive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				vbarSimple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				vbarAdj();
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

	public static class VbarSimpleContext extends ParserRuleContext {
		public VContext v() {
			return getRuleContext(VContext.class,0);
		}
		public NpContext np() {
			return getRuleContext(NpContext.class,0);
		}
		public VbarSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vbarSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVbarSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VbarSimpleContext vbarSimple() throws RecognitionException {
		VbarSimpleContext _localctx = new VbarSimpleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_vbarSimple);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			v();
			setState(264);
			np();
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

	public static class VbarPassiveContext extends ParserRuleContext {
		public VPassiveContext vPassive() {
			return getRuleContext(VPassiveContext.class,0);
		}
		public NpContext np() {
			return getRuleContext(NpContext.class,0);
		}
		public VbarPassiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vbarPassive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVbarPassive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VbarPassiveContext vbarPassive() throws RecognitionException {
		VbarPassiveContext _localctx = new VbarPassiveContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_vbarPassive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			vPassive();
			setState(267);
			np();
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

	public static class VbarAdjContext extends ParserRuleContext {
		public VBEContext vBE() {
			return getRuleContext(VBEContext.class,0);
		}
		public AdjpContext adjp() {
			return getRuleContext(AdjpContext.class,0);
		}
		public VbarAdjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vbarAdj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVbarAdj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VbarAdjContext vbarAdj() throws RecognitionException {
		VbarAdjContext _localctx = new VbarAdjContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_vbarAdj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			vBE();
			setState(270);
			adjp();
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

	public static class VContext extends ParserRuleContext {
		public VSimpleContext vSimple() {
			return getRuleContext(VSimpleContext.class,0);
		}
		public VParticleContext vParticle() {
			return getRuleContext(VParticleContext.class,0);
		}
		public VBEContext vBE() {
			return getRuleContext(VBEContext.class,0);
		}
		public VSameAsContext vSameAs() {
			return getRuleContext(VSameAsContext.class,0);
		}
		public VDOContext vDO() {
			return getRuleContext(VDOContext.class,0);
		}
		public VHASContext vHAS() {
			return getRuleContext(VHASContext.class,0);
		}
		public ModalContext modal() {
			return getRuleContext(ModalContext.class,0);
		}
		public VContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitV(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VContext v() throws RecognitionException {
		VContext _localctx = new VContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_v);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(272);
				modal();
				}
				break;
			}
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(275);
				vSimple();
				}
				break;
			case 2:
				{
				setState(276);
				vParticle();
				}
				break;
			case 3:
				{
				setState(277);
				vBE();
				}
				break;
			case 4:
				{
				setState(278);
				vSameAs();
				}
				break;
			case 5:
				{
				setState(279);
				vDO();
				}
				break;
			case 6:
				{
				setState(280);
				vHAS();
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

	public static class VSimpleContext extends ParserRuleContext {
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public VSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VSimpleContext vSimple() throws RecognitionException {
		VSimpleContext _localctx = new VSimpleContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_vSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(283);
				match(NOT);
				}
			}

			setState(287);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(286);
				match(ONLY);
				}
			}

			setState(289);
			verb();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(290);
				match(ONLY);
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

	public static class VParticleContext extends ParserRuleContext {
		public VerbContext verb() {
			return getRuleContext(VerbContext.class,0);
		}
		public TerminalNode IN() { return getToken(HOWL.IN, 0); }
		public TerminalNode RP() { return getToken(HOWL.RP, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public VParticleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vParticle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVParticle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VParticleContext vParticle() throws RecognitionException {
		VParticleContext _localctx = new VParticleContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_vParticle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(293);
				match(NOT);
				}
			}

			setState(297);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(296);
				match(ONLY);
				}
			}

			setState(299);
			verb();
			setState(301);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(300);
				match(ONLY);
				}
			}

			setState(303);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==RP) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class VPassiveContext extends ParserRuleContext {
		public VerbBEContext verbBE() {
			return getRuleContext(VerbBEContext.class,0);
		}
		public TerminalNode VBN() { return getToken(HOWL.VBN, 0); }
		public TerminalNode BY() { return getToken(HOWL.BY, 0); }
		public ModalContext modal() {
			return getRuleContext(ModalContext.class,0);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public TerminalNode IN() { return getToken(HOWL.IN, 0); }
		public TerminalNode RP() { return getToken(HOWL.RP, 0); }
		public VPassiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vPassive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVPassive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VPassiveContext vPassive() throws RecognitionException {
		VPassiveContext _localctx = new VPassiveContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vPassive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(305);
				modal();
				}
				break;
			}
			setState(308);
			verbBE();
			setState(310);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(309);
				match(NOT);
				}
			}

			setState(313);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(312);
				match(ONLY);
				}
			}

			setState(315);
			match(VBN);
			setState(317);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(316);
				match(ONLY);
				}
			}

			setState(320);
			_la = _input.LA(1);
			if (_la==IN || _la==RP) {
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==IN || _la==RP) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(322);
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

	public static class VBEContext extends ParserRuleContext {
		public VerbBEContext verbBE() {
			return getRuleContext(VerbBEContext.class,0);
		}
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public VBEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vBE; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVBE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VBEContext vBE() throws RecognitionException {
		VBEContext _localctx = new VBEContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_vBE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(324);
				match(ONLY);
				}
			}

			setState(327);
			verbBE();
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(328);
				match(ONLY);
				}
				break;
			}
			setState(332);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(331);
				match(NOT);
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

	public static class VSameAsContext extends ParserRuleContext {
		public VerbBEContext verbBE() {
			return getRuleContext(VerbBEContext.class,0);
		}
		public TerminalNode SAMEAS() { return getToken(HOWL.SAMEAS, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public VSameAsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vSameAs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVSameAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VSameAsContext vSameAs() throws RecognitionException {
		VSameAsContext _localctx = new VSameAsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_vSameAs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			verbBE();
			setState(336);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(335);
				match(NOT);
				}
			}

			setState(338);
			match(SAMEAS);
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

	public static class VDOContext extends ParserRuleContext {
		public VerbDOContext verbDO() {
			return getRuleContext(VerbDOContext.class,0);
		}
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public VDOContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vDO; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVDO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VDOContext vDO() throws RecognitionException {
		VDOContext _localctx = new VDOContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_vDO);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(340);
				match(ONLY);
				}
			}

			setState(343);
			verbDO();
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(344);
				match(ONLY);
				}
				break;
			}
			setState(348);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(347);
				match(NOT);
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

	public static class VHASContext extends ParserRuleContext {
		public VerbHASContext verbHAS() {
			return getRuleContext(VerbHASContext.class,0);
		}
		public List<TerminalNode> ONLY() { return getTokens(HOWL.ONLY); }
		public TerminalNode ONLY(int i) {
			return getToken(HOWL.ONLY, i);
		}
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public VHASContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vHAS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVHAS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VHASContext vHAS() throws RecognitionException {
		VHASContext _localctx = new VHASContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_vHAS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(350);
				match(ONLY);
				}
			}

			setState(353);
			verbHAS();
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(354);
				match(ONLY);
				}
				break;
			}
			setState(358);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(357);
				match(NOT);
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

	public static class VerbBEContext extends ParserRuleContext {
		public TerminalNode BE() { return getToken(HOWL.BE, 0); }
		public TerminalNode BED() { return getToken(HOWL.BED, 0); }
		public TerminalNode BEDZ() { return getToken(HOWL.BEDZ, 0); }
		public TerminalNode BEG() { return getToken(HOWL.BEG, 0); }
		public TerminalNode BEM() { return getToken(HOWL.BEM, 0); }
		public TerminalNode BEN() { return getToken(HOWL.BEN, 0); }
		public TerminalNode BER() { return getToken(HOWL.BER, 0); }
		public TerminalNode BEZ() { return getToken(HOWL.BEZ, 0); }
		public VerbBEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbBE; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVerbBE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbBEContext verbBE() throws RecognitionException {
		VerbBEContext _localctx = new VerbBEContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_verbBE);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BE) | (1L << BED) | (1L << BEDZ) | (1L << BEG) | (1L << BEM) | (1L << BEN) | (1L << BER) | (1L << BEZ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class VerbDOContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(HOWL.DO, 0); }
		public TerminalNode DOD() { return getToken(HOWL.DOD, 0); }
		public TerminalNode DOZ() { return getToken(HOWL.DOZ, 0); }
		public VerbDOContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbDO; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVerbDO(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbDOContext verbDO() throws RecognitionException {
		VerbDOContext _localctx = new VerbDOContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_verbDO);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DO) | (1L << DOD) | (1L << DOZ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class VerbHASContext extends ParserRuleContext {
		public TerminalNode HV() { return getToken(HOWL.HV, 0); }
		public TerminalNode HVD() { return getToken(HOWL.HVD, 0); }
		public TerminalNode HVG() { return getToken(HOWL.HVG, 0); }
		public TerminalNode HVN() { return getToken(HOWL.HVN, 0); }
		public TerminalNode HVZ() { return getToken(HOWL.HVZ, 0); }
		public VerbHASContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbHAS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVerbHAS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbHASContext verbHAS() throws RecognitionException {
		VerbHASContext _localctx = new VerbHASContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_verbHAS);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HV) | (1L << HVD) | (1L << HVG) | (1L << HVN) | (1L << HVZ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class VerbContext extends ParserRuleContext {
		public TerminalNode VB() { return getToken(HOWL.VB, 0); }
		public TerminalNode VBD() { return getToken(HOWL.VBD, 0); }
		public TerminalNode VBZ() { return getToken(HOWL.VBZ, 0); }
		public TerminalNode VBG() { return getToken(HOWL.VBG, 0); }
		public TerminalNode VBN() { return getToken(HOWL.VBN, 0); }
		public VerbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVerb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbContext verb() throws RecognitionException {
		VerbContext _localctx = new VerbContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_verb);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !(((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & ((1L << (VB - 97)) | (1L << (VBD - 97)) | (1L << (VBG - 97)) | (1L << (VBN - 97)) | (1L << (VBZ - 97)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ModalContext extends ParserRuleContext {
		public List<TerminalNode> MD() { return getTokens(HOWL.MD); }
		public TerminalNode MD(int i) {
			return getToken(HOWL.MD, i);
		}
		public List<TerminalNode> NOT() { return getTokens(HOWL.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(HOWL.NOT, i);
		}
		public List<VerbBEContext> verbBE() {
			return getRuleContexts(VerbBEContext.class);
		}
		public VerbBEContext verbBE(int i) {
			return getRuleContext(VerbBEContext.class,i);
		}
		public List<VerbHASContext> verbHAS() {
			return getRuleContexts(VerbHASContext.class);
		}
		public VerbHASContext verbHAS(int i) {
			return getRuleContext(VerbHASContext.class,i);
		}
		public List<VerbDOContext> verbDO() {
			return getRuleContexts(VerbDOContext.class);
		}
		public VerbDOContext verbDO(int i) {
			return getRuleContext(VerbDOContext.class,i);
		}
		public ModalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitModal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModalContext modal() throws RecognitionException {
		ModalContext _localctx = new ModalContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_modal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(373);
					switch (_input.LA(1)) {
					case MD:
						{
						setState(368);
						match(MD);
						}
						break;
					case NOT:
						{
						setState(369);
						match(NOT);
						}
						break;
					case BE:
					case BED:
					case BEDZ:
					case BEG:
					case BEM:
					case BEN:
					case BER:
					case BEZ:
						{
						setState(370);
						verbBE();
						}
						break;
					case HV:
					case HVD:
					case HVG:
					case HVN:
					case HVZ:
						{
						setState(371);
						verbHAS();
						}
						break;
					case DO:
					case DOD:
					case DOZ:
						{
						setState(372);
						verbDO();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(375); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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

	public static class PhraseSetContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public PhraseSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPhraseSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseSetContext phraseSet() throws RecognitionException {
		PhraseSetContext _localctx = new PhraseSetContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_phraseSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(377);
				phrase();
				}
				}
				setState(380); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << ANYX) | (1L << BE) | (1L << BED) | (1L << BEDZ) | (1L << BEG) | (1L << BEM) | (1L << BEN) | (1L << BER) | (1L << BEZ) | (1L << CD) | (1L << DO) | (1L << DOD) | (1L << DOZ) | (1L << EVERY) | (1L << EVERYX) | (1L << EXACT) | (1L << HV) | (1L << HVD) | (1L << HVG) | (1L << HVN) | (1L << HVZ) | (1L << JJ) | (1L << JJR) | (1L << JJS) | (1L << JJT) | (1L << LESS) | (1L << LESSOREQUAL) | (1L << MD) | (1L << MORE) | (1L << MOREOREQUAL) | (1L << NN) | (1L << NNS) | (1L << NONE) | (1L << NOT) | (1L << NOX) | (1L << NP) | (1L << NPS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NR - 64)) | (1L << (OD - 64)) | (1L << (ONLY - 64)) | (1L << (POSS - 64)) | (1L << (SOME - 64)) | (1L << (SOMEX - 64)) | (1L << (THE - 64)) | (1L << (THING - 64)) | (1L << (VB - 64)) | (1L << (VBD - 64)) | (1L << (VBG - 64)) | (1L << (VBN - 64)) | (1L << (VBZ - 64)))) != 0) );
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

	public static class JunkContext extends ParserRuleContext {
		public List<JContext> j() {
			return getRuleContexts(JContext.class);
		}
		public JContext j(int i) {
			return getRuleContext(JContext.class,i);
		}
		public JunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_junk; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitJunk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JunkContext junk() throws RecognitionException {
		JunkContext _localctx = new JunkContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_junk);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(382);
					j();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(385); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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

	public static class JContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public CatchPhraseContext catchPhrase() {
			return getRuleContext(CatchPhraseContext.class,0);
		}
		public JContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_j; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitJ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JContext j() throws RecognitionException {
		JContext _localctx = new JContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_j);
		try {
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				phrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				catchPhrase();
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

	public static class PhraseContext extends ParserRuleContext {
		public NpContext np() {
			return getRuleContext(NpContext.class,0);
		}
		public VpContext vp() {
			return getRuleContext(VpContext.class,0);
		}
		public AdjpContext adjp() {
			return getRuleContext(AdjpContext.class,0);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_phrase);
		try {
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				np();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				vp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				adjp();
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

	public static class CatchPhraseContext extends ParserRuleContext {
		public List<AdjWordContext> adjWord() {
			return getRuleContexts(AdjWordContext.class);
		}
		public AdjWordContext adjWord(int i) {
			return getRuleContext(AdjWordContext.class,i);
		}
		public List<AdvWordContext> advWord() {
			return getRuleContexts(AdvWordContext.class);
		}
		public AdvWordContext advWord(int i) {
			return getRuleContext(AdvWordContext.class,i);
		}
		public List<PunctWordContext> punctWord() {
			return getRuleContexts(PunctWordContext.class);
		}
		public PunctWordContext punctWord(int i) {
			return getRuleContext(PunctWordContext.class,i);
		}
		public List<ConnWordContext> connWord() {
			return getRuleContexts(ConnWordContext.class);
		}
		public ConnWordContext connWord(int i) {
			return getRuleContext(ConnWordContext.class,i);
		}
		public List<DetWordContext> detWord() {
			return getRuleContexts(DetWordContext.class);
		}
		public DetWordContext detWord(int i) {
			return getRuleContext(DetWordContext.class,i);
		}
		public List<ModWordContext> modWord() {
			return getRuleContexts(ModWordContext.class);
		}
		public ModWordContext modWord(int i) {
			return getRuleContext(ModWordContext.class,i);
		}
		public List<NounWordContext> nounWord() {
			return getRuleContexts(NounWordContext.class);
		}
		public NounWordContext nounWord(int i) {
			return getRuleContext(NounWordContext.class,i);
		}
		public List<VerbWordContext> verbWord() {
			return getRuleContexts(VerbWordContext.class);
		}
		public VerbWordContext verbWord(int i) {
			return getRuleContext(VerbWordContext.class,i);
		}
		public List<PhraseWordContext> phraseWord() {
			return getRuleContexts(PhraseWordContext.class);
		}
		public PhraseWordContext phraseWord(int i) {
			return getRuleContext(PhraseWordContext.class,i);
		}
		public CatchPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchPhrase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitCatchPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchPhraseContext catchPhrase() throws RecognitionException {
		CatchPhraseContext _localctx = new CatchPhraseContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_catchPhrase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(405); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					setState(405);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(396);
						adjWord();
						}
						break;
					case 2:
						{
						setState(397);
						advWord();
						}
						break;
					case 3:
						{
						setState(398);
						punctWord();
						}
						break;
					case 4:
						{
						setState(399);
						connWord();
						}
						break;
					case 5:
						{
						setState(400);
						detWord();
						}
						break;
					case 6:
						{
						setState(401);
						modWord();
						}
						break;
					case 7:
						{
						setState(402);
						nounWord();
						}
						break;
					case 8:
						{
						setState(403);
						verbWord();
						}
						break;
					case 9:
						{
						setState(404);
						phraseWord();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(407); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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

	public static class AdjWordContext extends ParserRuleContext {
		public TerminalNode JJ() { return getToken(HOWL.JJ, 0); }
		public TerminalNode JJR() { return getToken(HOWL.JJR, 0); }
		public TerminalNode JJS() { return getToken(HOWL.JJS, 0); }
		public TerminalNode JJT() { return getToken(HOWL.JJT, 0); }
		public AdjWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adjWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitAdjWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdjWordContext adjWord() throws RecognitionException {
		AdjWordContext _localctx = new AdjWordContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_adjWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JJ) | (1L << JJR) | (1L << JJS) | (1L << JJT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class AdvWordContext extends ParserRuleContext {
		public TerminalNode RB() { return getToken(HOWL.RB, 0); }
		public TerminalNode RBR() { return getToken(HOWL.RBR, 0); }
		public TerminalNode RBT() { return getToken(HOWL.RBT, 0); }
		public TerminalNode RN() { return getToken(HOWL.RN, 0); }
		public TerminalNode RP() { return getToken(HOWL.RP, 0); }
		public AdvWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_advWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitAdvWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdvWordContext advWord() throws RecognitionException {
		AdvWordContext _localctx = new AdvWordContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_advWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !(((((_la - 82)) & ~0x3f) == 0 && ((1L << (_la - 82)) & ((1L << (RB - 82)) | (1L << (RBR - 82)) | (1L << (RBT - 82)) | (1L << (RN - 82)) | (1L << (RP - 82)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ConnWordContext extends ParserRuleContext {
		public TerminalNode CC() { return getToken(HOWL.CC, 0); }
		public TerminalNode CS() { return getToken(HOWL.CS, 0); }
		public TerminalNode IN() { return getToken(HOWL.IN, 0); }
		public ConnWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitConnWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnWordContext connWord() throws RecognitionException {
		ConnWordContext _localctx = new ConnWordContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_connWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CC) | (1L << CS) | (1L << IN))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class DetWordContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode ABL() { return getToken(HOWL.ABL, 0); }
		public TerminalNode ABN() { return getToken(HOWL.ABN, 0); }
		public TerminalNode ABX() { return getToken(HOWL.ABX, 0); }
		public TerminalNode AP() { return getToken(HOWL.AP, 0); }
		public TerminalNode AT() { return getToken(HOWL.AT, 0); }
		public TerminalNode DT() { return getToken(HOWL.DT, 0); }
		public TerminalNode DTI() { return getToken(HOWL.DTI, 0); }
		public TerminalNode DTS() { return getToken(HOWL.DTS, 0); }
		public TerminalNode DTX() { return getToken(HOWL.DTX, 0); }
		public TerminalNode PPx() { return getToken(HOWL.PPx, 0); }
		public TerminalNode WDT() { return getToken(HOWL.WDT, 0); }
		public DetWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitDetWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DetWordContext detWord() throws RecognitionException {
		DetWordContext _localctx = new DetWordContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_detWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << ABL) | (1L << ABN) | (1L << ABX) | (1L << AP) | (1L << AT) | (1L << DT) | (1L << DTI) | (1L << DTS) | (1L << DTX))) != 0) || _la==PPx || _la==WDT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ModWordContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(HOWL.CD, 0); }
		public TerminalNode NOT() { return getToken(HOWL.NOT, 0); }
		public TerminalNode OD() { return getToken(HOWL.OD, 0); }
		public TerminalNode POSS() { return getToken(HOWL.POSS, 0); }
		public TerminalNode QL() { return getToken(HOWL.QL, 0); }
		public TerminalNode QLP() { return getToken(HOWL.QLP, 0); }
		public TerminalNode WQL() { return getToken(HOWL.WQL, 0); }
		public TerminalNode WRB() { return getToken(HOWL.WRB, 0); }
		public ModWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitModWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModWordContext modWord() throws RecognitionException {
		ModWordContext _localctx = new ModWordContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_modWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if ( !(_la==CD || _la==NOT || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (OD - 66)) | (1L << (POSS - 66)) | (1L << (QL - 66)) | (1L << (QLP - 66)) | (1L << (WQL - 66)) | (1L << (WRB - 66)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NounWordContext extends ParserRuleContext {
		public TerminalNode EX() { return getToken(HOWL.EX, 0); }
		public TerminalNode NN() { return getToken(HOWL.NN, 0); }
		public TerminalNode NNS() { return getToken(HOWL.NNS, 0); }
		public TerminalNode NP() { return getToken(HOWL.NP, 0); }
		public TerminalNode NPS() { return getToken(HOWL.NPS, 0); }
		public TerminalNode NR() { return getToken(HOWL.NR, 0); }
		public TerminalNode NRS() { return getToken(HOWL.NRS, 0); }
		public TerminalNode PN() { return getToken(HOWL.PN, 0); }
		public TerminalNode PPxx() { return getToken(HOWL.PPxx, 0); }
		public TerminalNode PPL() { return getToken(HOWL.PPL, 0); }
		public TerminalNode PPLS() { return getToken(HOWL.PPLS, 0); }
		public TerminalNode PPO() { return getToken(HOWL.PPO, 0); }
		public TerminalNode PPS() { return getToken(HOWL.PPS, 0); }
		public TerminalNode PPSS() { return getToken(HOWL.PPSS, 0); }
		public TerminalNode WPx() { return getToken(HOWL.WPx, 0); }
		public TerminalNode WPO() { return getToken(HOWL.WPO, 0); }
		public TerminalNode WPS() { return getToken(HOWL.WPS, 0); }
		public NounWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nounWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitNounWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NounWordContext nounWord() throws RecognitionException {
		NounWordContext _localctx = new NounWordContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_nounWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EX) | (1L << NN) | (1L << NNS) | (1L << NP) | (1L << NPS))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NR - 64)) | (1L << (NRS - 64)) | (1L << (PN - 64)) | (1L << (PPL - 64)) | (1L << (PPLS - 64)) | (1L << (PPO - 64)) | (1L << (PPS - 64)) | (1L << (PPSS - 64)) | (1L << (PPxx - 64)) | (1L << (WPO - 64)) | (1L << (WPS - 64)) | (1L << (WPx - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class PunctWordContext extends ParserRuleContext {
		public TerminalNode APOS() { return getToken(HOWL.APOS, 0); }
		public TerminalNode CLOSEPAREN() { return getToken(HOWL.CLOSEPAREN, 0); }
		public TerminalNode COLON() { return getToken(HOWL.COLON, 0); }
		public TerminalNode COMMA() { return getToken(HOWL.COMMA, 0); }
		public TerminalNode DASH() { return getToken(HOWL.DASH, 0); }
		public TerminalNode DQUOTE() { return getToken(HOWL.DQUOTE, 0); }
		public TerminalNode OPENPAREN() { return getToken(HOWL.OPENPAREN, 0); }
		public TerminalNode PERIOD() { return getToken(HOWL.PERIOD, 0); }
		public TerminalNode TIC() { return getToken(HOWL.TIC, 0); }
		public PunctWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_punctWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPunctWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PunctWordContext punctWord() throws RecognitionException {
		PunctWordContext _localctx = new PunctWordContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_punctWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << APOS) | (1L << CLOSEPAREN) | (1L << COLON) | (1L << COMMA) | (1L << DASH) | (1L << DQUOTE))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (OPENPAREN - 68)) | (1L << (PERIOD - 68)) | (1L << (TIC - 68)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class VerbWordContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(HOWL.TO, 0); }
		public TerminalNode BE() { return getToken(HOWL.BE, 0); }
		public TerminalNode BED() { return getToken(HOWL.BED, 0); }
		public TerminalNode BEDZ() { return getToken(HOWL.BEDZ, 0); }
		public TerminalNode BEG() { return getToken(HOWL.BEG, 0); }
		public TerminalNode BEM() { return getToken(HOWL.BEM, 0); }
		public TerminalNode BEN() { return getToken(HOWL.BEN, 0); }
		public TerminalNode BER() { return getToken(HOWL.BER, 0); }
		public TerminalNode BEZ() { return getToken(HOWL.BEZ, 0); }
		public TerminalNode DO() { return getToken(HOWL.DO, 0); }
		public TerminalNode DOD() { return getToken(HOWL.DOD, 0); }
		public TerminalNode DOZ() { return getToken(HOWL.DOZ, 0); }
		public TerminalNode HV() { return getToken(HOWL.HV, 0); }
		public TerminalNode HVD() { return getToken(HOWL.HVD, 0); }
		public TerminalNode HVG() { return getToken(HOWL.HVG, 0); }
		public TerminalNode HVN() { return getToken(HOWL.HVN, 0); }
		public TerminalNode HVZ() { return getToken(HOWL.HVZ, 0); }
		public TerminalNode MD() { return getToken(HOWL.MD, 0); }
		public TerminalNode VB() { return getToken(HOWL.VB, 0); }
		public TerminalNode VBD() { return getToken(HOWL.VBD, 0); }
		public TerminalNode VBG() { return getToken(HOWL.VBG, 0); }
		public TerminalNode VBN() { return getToken(HOWL.VBN, 0); }
		public TerminalNode VBZ() { return getToken(HOWL.VBZ, 0); }
		public VerbWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitVerbWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VerbWordContext verbWord() throws RecognitionException {
		VerbWordContext _localctx = new VerbWordContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_verbWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BE) | (1L << BED) | (1L << BEDZ) | (1L << BEG) | (1L << BEM) | (1L << BEN) | (1L << BER) | (1L << BEZ) | (1L << DO) | (1L << DOD) | (1L << DOZ) | (1L << HV) | (1L << HVD) | (1L << HVG) | (1L << HVN) | (1L << HVZ) | (1L << MD))) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & ((1L << (TO - 95)) | (1L << (VB - 95)) | (1L << (VBD - 95)) | (1L << (VBG - 95)) | (1L << (VBN - 95)) | (1L << (VBZ - 95)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class PhraseWordContext extends ParserRuleContext {
		public TerminalNode A() { return getToken(HOWL.A, 0); }
		public TerminalNode ALSO() { return getToken(HOWL.ALSO, 0); }
		public TerminalNode AND() { return getToken(HOWL.AND, 0); }
		public TerminalNode ANYX() { return getToken(HOWL.ANYX, 0); }
		public TerminalNode BY() { return getToken(HOWL.BY, 0); }
		public TerminalNode EVERY() { return getToken(HOWL.EVERY, 0); }
		public TerminalNode EVERYX() { return getToken(HOWL.EVERYX, 0); }
		public TerminalNode EXACT() { return getToken(HOWL.EXACT, 0); }
		public TerminalNode IF() { return getToken(HOWL.IF, 0); }
		public TerminalNode LESS() { return getToken(HOWL.LESS, 0); }
		public TerminalNode MORE() { return getToken(HOWL.MORE, 0); }
		public TerminalNode MUST() { return getToken(HOWL.MUST, 0); }
		public TerminalNode NONE() { return getToken(HOWL.NONE, 0); }
		public TerminalNode NOX() { return getToken(HOWL.NOX, 0); }
		public TerminalNode ONLY() { return getToken(HOWL.ONLY, 0); }
		public TerminalNode OR() { return getToken(HOWL.OR, 0); }
		public TerminalNode SAMEAS() { return getToken(HOWL.SAMEAS, 0); }
		public TerminalNode SOME() { return getToken(HOWL.SOME, 0); }
		public TerminalNode SOMEX() { return getToken(HOWL.SOMEX, 0); }
		public TerminalNode THAT() { return getToken(HOWL.THAT, 0); }
		public TerminalNode THE() { return getToken(HOWL.THE, 0); }
		public TerminalNode THEN() { return getToken(HOWL.THEN, 0); }
		public TerminalNode THING() { return getToken(HOWL.THING, 0); }
		public TerminalNode GROUPOF() { return getToken(HOWL.GROUPOF, 0); }
		public TerminalNode QMARK() { return getToken(HOWL.QMARK, 0); }
		public PhraseWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseWord; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOWLVisitor ) return ((HOWLVisitor<? extends T>)visitor).visitPhraseWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseWordContext phraseWord() throws RecognitionException {
		PhraseWordContext _localctx = new PhraseWordContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_phraseWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << ALSO) | (1L << AND) | (1L << ANYX) | (1L << BY) | (1L << EVERY) | (1L << EVERYX) | (1L << EXACT) | (1L << GROUPOF) | (1L << IF) | (1L << LESS) | (1L << MORE) | (1L << MUST) | (1L << NONE) | (1L << NOX))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (ONLY - 67)) | (1L << (OR - 67)) | (1L << (SAMEAS - 67)) | (1L << (SOME - 67)) | (1L << (SOMEX - 67)) | (1L << (THAT - 67)) | (1L << (THE - 67)) | (1L << (THEN - 67)) | (1L << (THING - 67)) | (1L << (QMARK - 67)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3n\u01ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\6\2{\n\2\r\2\16\2|\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0085\n\4\f\4\16"+
		"\4\u0088\13\4\3\4\3\4\7\4\u008c\n\4\f\4\16\4\u008f\13\4\5\4\u0091\n\4"+
		"\3\5\3\5\3\5\7\5\u0096\n\5\f\5\16\5\u0099\13\5\3\5\3\5\7\5\u009d\n\5\f"+
		"\5\16\5\u00a0\13\5\5\5\u00a2\n\5\3\6\3\6\5\6\u00a6\n\6\3\7\5\7\u00a9\n"+
		"\7\3\7\5\7\u00ac\n\7\3\7\3\7\3\b\5\b\u00b1\n\b\3\b\5\b\u00b4\n\b\3\b\5"+
		"\b\u00b7\n\b\3\b\3\b\3\b\5\b\u00bc\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c3\n"+
		"\b\f\b\16\b\u00c6\13\b\5\b\u00c8\n\b\3\t\3\t\3\n\3\n\3\13\5\13\u00cf\n"+
		"\13\3\13\6\13\u00d2\n\13\r\13\16\13\u00d3\3\f\3\f\3\r\3\r\3\16\6\16\u00db"+
		"\n\16\r\16\16\16\u00dc\3\17\3\17\3\17\3\17\3\17\5\17\u00e4\n\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u00f5\n\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\34\5\34\u0108\n\34\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3 \5 \u0114\n \3 \3 \3 \3 \3 \3 \5 \u011c\n \3!\5"+
		"!\u011f\n!\3!\5!\u0122\n!\3!\3!\5!\u0126\n!\3\"\5\"\u0129\n\"\3\"\5\""+
		"\u012c\n\"\3\"\3\"\5\"\u0130\n\"\3\"\3\"\3#\5#\u0135\n#\3#\3#\5#\u0139"+
		"\n#\3#\5#\u013c\n#\3#\3#\5#\u0140\n#\3#\5#\u0143\n#\3#\3#\3$\5$\u0148"+
		"\n$\3$\3$\5$\u014c\n$\3$\5$\u014f\n$\3%\3%\5%\u0153\n%\3%\3%\3&\5&\u0158"+
		"\n&\3&\3&\5&\u015c\n&\3&\5&\u015f\n&\3\'\5\'\u0162\n\'\3\'\3\'\5\'\u0166"+
		"\n\'\3\'\5\'\u0169\n\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\3,\6,\u0178"+
		"\n,\r,\16,\u0179\3-\6-\u017d\n-\r-\16-\u017e\3.\6.\u0182\n.\r.\16.\u0183"+
		"\3/\3/\5/\u0188\n/\3\60\3\60\3\60\5\60\u018d\n\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\6\61\u0198\n\61\r\61\16\61\u0199\3\62\3\62\3"+
		"\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:"+
		"\3\u0199\2;\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnpr\2\27\4\2HHbb\3\2;<\3\2@A\7\2\t\t&&??["+
		"[__\4\2\61\64ef\b\2\61\64;<@BDDJJef\4\2((EE\4\2\60\60XX\3\2\r\24\3\2\35"+
		"\37\3\2*.\3\2cg\3\2\61\64\3\2TX\5\2\26\26\33\33\60\60\b\2\3\6\n\n\f\f"+
		"!$PPhh\b\2\27\27>>DDJJRSlm\t\2\'\';<@CIIKOQQik\t\2\13\13\30\32\34\34 "+
		" FFHH``\b\2\r\24\35\37*.\67\67aacg\21\2\3\3\7\t\25\25%&()//\65\6588::"+
		"==??EEGGY_bb\u01c2\2z\3\2\2\2\4~\3\2\2\2\6\u0080\3\2\2\2\b\u0092\3\2\2"+
		"\2\n\u00a5\3\2\2\2\f\u00a8\3\2\2\2\16\u00b0\3\2\2\2\20\u00c9\3\2\2\2\22"+
		"\u00cb\3\2\2\2\24\u00ce\3\2\2\2\26\u00d5\3\2\2\2\30\u00d7\3\2\2\2\32\u00da"+
		"\3\2\2\2\34\u00e3\3\2\2\2\36\u00e5\3\2\2\2 \u00e7\3\2\2\2\"\u00e9\3\2"+
		"\2\2$\u00eb\3\2\2\2&\u00ed\3\2\2\2(\u00f4\3\2\2\2*\u00f8\3\2\2\2,\u00fa"+
		"\3\2\2\2.\u00fc\3\2\2\2\60\u00fe\3\2\2\2\62\u0100\3\2\2\2\64\u0102\3\2"+
		"\2\2\66\u0107\3\2\2\28\u0109\3\2\2\2:\u010c\3\2\2\2<\u010f\3\2\2\2>\u0113"+
		"\3\2\2\2@\u011e\3\2\2\2B\u0128\3\2\2\2D\u0134\3\2\2\2F\u0147\3\2\2\2H"+
		"\u0150\3\2\2\2J\u0157\3\2\2\2L\u0161\3\2\2\2N\u016a\3\2\2\2P\u016c\3\2"+
		"\2\2R\u016e\3\2\2\2T\u0170\3\2\2\2V\u0177\3\2\2\2X\u017c\3\2\2\2Z\u0181"+
		"\3\2\2\2\\\u0187\3\2\2\2^\u018c\3\2\2\2`\u0197\3\2\2\2b\u019b\3\2\2\2"+
		"d\u019d\3\2\2\2f\u019f\3\2\2\2h\u01a1\3\2\2\2j\u01a3\3\2\2\2l\u01a5\3"+
		"\2\2\2n\u01a7\3\2\2\2p\u01a9\3\2\2\2r\u01ab\3\2\2\2tu\5\4\3\2uv\7H\2\2"+
		"v{\3\2\2\2wx\5Z.\2xy\t\2\2\2y{\3\2\2\2zt\3\2\2\2zw\3\2\2\2{|\3\2\2\2|"+
		"z\3\2\2\2|}\3\2\2\2}\3\3\2\2\2~\177\5\6\4\2\177\5\3\2\2\2\u0080\u0081"+
		"\5\b\5\2\u0081\u0090\5\64\33\2\u0082\u0083\7\b\2\2\u0083\u0085\5\64\33"+
		"\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0091\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7G\2\2\u008a"+
		"\u008c\5\64\33\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0086\3\2\2\2\u0090\u008d\3\2\2\2\u0091\7\3\2\2\2\u0092\u00a1\5\n\6\2"+
		"\u0093\u0094\7\b\2\2\u0094\u0096\5\n\6\2\u0095\u0093\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00a2\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\7G\2\2\u009b\u009d\5\n\6\2\u009c\u009a\3\2"+
		"\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1\u009e\3\2"+
		"\2\2\u00a2\t\3\2\2\2\u00a3\u00a6\5\f\7\2\u00a4\u00a6\5\16\b\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\13\3\2\2\2\u00a7\u00a9\5\36\20\2\u00a8"+
		"\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00ac\5\34"+
		"\17\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\5\24\13\2\u00ae\r\3\2\2\2\u00af\u00b1\5\36\20\2\u00b0\u00af\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\5\34\17\2\u00b3"+
		"\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b7\5\32"+
		"\16\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bb\3\2\2\2\u00b8"+
		"\u00bc\5\20\t\2\u00b9\u00bc\5\26\f\2\u00ba\u00bc\5\30\r\2\u00bb\u00b8"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00c7\3\2\2\2\u00bd"+
		"\u00be\7\\\2\2\u00be\u00c4\5\66\34\2\u00bf\u00c0\7\b\2\2\u00c0\u00c1\7"+
		"\\\2\2\u00c1\u00c3\5\66\34\2\u00c2\u00bf\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00bd\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\17\3\2\2\2\u00c9\u00ca"+
		"\t\3\2\2\u00ca\21\3\2\2\2\u00cb\u00cc\t\4\2\2\u00cc\23\3\2\2\2\u00cd\u00cf"+
		"\5\32\16\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2"+
		"\u00d0\u00d2\5\22\n\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\25\3\2\2\2\u00d5\u00d6\t\5\2\2\u00d6"+
		"\27\3\2\2\2\u00d7\u00d8\t\6\2\2\u00d8\31\3\2\2\2\u00d9\u00db\t\7\2\2\u00da"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\33\3\2\2\2\u00de\u00e4\5$\23\2\u00df\u00e4\5&\24\2\u00e0\u00e4"+
		"\5(\25\2\u00e1\u00e4\5\"\22\2\u00e2\u00e4\5 \21\2\u00e3\u00de\3\2\2\2"+
		"\u00e3\u00df\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2"+
		"\3\2\2\2\u00e4\35\3\2\2\2\u00e5\u00e6\7=\2\2\u00e6\37\3\2\2\2\u00e7\u00e8"+
		"\7]\2\2\u00e8!\3\2\2\2\u00e9\u00ea\7\3\2\2\u00ea#\3\2\2\2\u00eb\u00ec"+
		"\7%\2\2\u00ec%\3\2\2\2\u00ed\u00ee\7Z\2\2\u00ee\'\3\2\2\2\u00ef\u00f5"+
		"\5*\26\2\u00f0\u00f5\5,\27\2\u00f1\u00f5\5.\30\2\u00f2\u00f5\5\60\31\2"+
		"\u00f3\u00f5\5\62\32\2\u00f4\u00ef\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\7\27\2\2\u00f7)\3\2\2\2\u00f8\u00f9\t\b\2\2"+
		"\u00f9+\3\2\2\2\u00fa\u00fb\78\2\2\u00fb-\3\2\2\2\u00fc\u00fd\7\65\2\2"+
		"\u00fd/\3\2\2\2\u00fe\u00ff\79\2\2\u00ff\61\3\2\2\2\u0100\u0101\7\66\2"+
		"\2\u0101\63\3\2\2\2\u0102\u0103\5\66\34\2\u0103\65\3\2\2\2\u0104\u0108"+
		"\5:\36\2\u0105\u0108\58\35\2\u0106\u0108\5<\37\2\u0107\u0104\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108\67\3\2\2\2\u0109\u010a\5> \2"+
		"\u010a\u010b\5\b\5\2\u010b9\3\2\2\2\u010c\u010d\5D#\2\u010d\u010e\5\b"+
		"\5\2\u010e;\3\2\2\2\u010f\u0110\5F$\2\u0110\u0111\5\32\16\2\u0111=\3\2"+
		"\2\2\u0112\u0114\5V,\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u011b"+
		"\3\2\2\2\u0115\u011c\5@!\2\u0116\u011c\5B\"\2\u0117\u011c\5F$\2\u0118"+
		"\u011c\5H%\2\u0119\u011c\5J&\2\u011a\u011c\5L\'\2\u011b\u0115\3\2\2\2"+
		"\u011b\u0116\3\2\2\2\u011b\u0117\3\2\2\2\u011b\u0118\3\2\2\2\u011b\u0119"+
		"\3\2\2\2\u011b\u011a\3\2\2\2\u011c?\3\2\2\2\u011d\u011f\7>\2\2\u011e\u011d"+
		"\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u0122\7E\2\2\u0121"+
		"\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\5T"+
		"+\2\u0124\u0126\7E\2\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126A"+
		"\3\2\2\2\u0127\u0129\7>\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012b\3\2\2\2\u012a\u012c\7E\2\2\u012b\u012a\3\2\2\2\u012b\u012c\3\2"+
		"\2\2\u012c\u012d\3\2\2\2\u012d\u012f\5T+\2\u012e\u0130\7E\2\2\u012f\u012e"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\t\t\2\2\u0132"+
		"C\3\2\2\2\u0133\u0135\5V,\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0138\5N(\2\u0137\u0139\7>\2\2\u0138\u0137\3\2\2"+
		"\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a\u013c\7E\2\2\u013b\u013a"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\7f\2\2\u013e"+
		"\u0140\7E\2\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2"+
		"\2\2\u0141\u0143\t\t\2\2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0145\7\25\2\2\u0145E\3\2\2\2\u0146\u0148\7E\2\2"+
		"\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b"+
		"\5N(\2\u014a\u014c\7E\2\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014e\3\2\2\2\u014d\u014f\7>\2\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014fG\3\2\2\2\u0150\u0152\5N(\2\u0151\u0153\7>\2\2\u0152\u0151\3"+
		"\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\7Y\2\2\u0155"+
		"I\3\2\2\2\u0156\u0158\7E\2\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015b\5P)\2\u015a\u015c\7E\2\2\u015b\u015a\3\2\2"+
		"\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\7>\2\2\u015e\u015d"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015fK\3\2\2\2\u0160\u0162\7E\2\2\u0161\u0160"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\5R*\2\u0164"+
		"\u0166\7E\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2"+
		"\2\2\u0167\u0169\7>\2\2\u0168\u0167\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"M\3\2\2\2\u016a\u016b\t\n\2\2\u016bO\3\2\2\2\u016c\u016d\t\13\2\2\u016d"+
		"Q\3\2\2\2\u016e\u016f\t\f\2\2\u016fS\3\2\2\2\u0170\u0171\t\r\2\2\u0171"+
		"U\3\2\2\2\u0172\u0178\7\67\2\2\u0173\u0178\7>\2\2\u0174\u0178\5N(\2\u0175"+
		"\u0178\5R*\2\u0176\u0178\5P)\2\u0177\u0172\3\2\2\2\u0177\u0173\3\2\2\2"+
		"\u0177\u0174\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017aW\3\2\2\2\u017b"+
		"\u017d\5^\60\2\u017c\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017e\u017f\3\2\2\2\u017fY\3\2\2\2\u0180\u0182\5\\/\2\u0181\u0180"+
		"\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"[\3\2\2\2\u0185\u0188\5^\60\2\u0186\u0188\5`\61\2\u0187\u0185\3\2\2\2"+
		"\u0187\u0186\3\2\2\2\u0188]\3\2\2\2\u0189\u018d\5\b\5\2\u018a\u018d\5"+
		"\64\33\2\u018b\u018d\5\32\16\2\u018c\u0189\3\2\2\2\u018c\u018a\3\2\2\2"+
		"\u018c\u018b\3\2\2\2\u018d_\3\2\2\2\u018e\u0198\5b\62\2\u018f\u0198\5"+
		"d\63\2\u0190\u0198\5n8\2\u0191\u0198\5f\64\2\u0192\u0198\5h\65\2\u0193"+
		"\u0198\5j\66\2\u0194\u0198\5l\67\2\u0195\u0198\5p9\2\u0196\u0198\5r:\2"+
		"\u0197\u018e\3\2\2\2\u0197\u018f\3\2\2\2\u0197\u0190\3\2\2\2\u0197\u0191"+
		"\3\2\2\2\u0197\u0192\3\2\2\2\u0197\u0193\3\2\2\2\u0197\u0194\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u0199\u0197\3\2\2\2\u019aa\3\2\2\2\u019b\u019c\t\16\2\2\u019cc\3"+
		"\2\2\2\u019d\u019e\t\17\2\2\u019ee\3\2\2\2\u019f\u01a0\t\20\2\2\u01a0"+
		"g\3\2\2\2\u01a1\u01a2\t\21\2\2\u01a2i\3\2\2\2\u01a3\u01a4\t\22\2\2\u01a4"+
		"k\3\2\2\2\u01a5\u01a6\t\23\2\2\u01a6m\3\2\2\2\u01a7\u01a8\t\24\2\2\u01a8"+
		"o\3\2\2\2\u01a9\u01aa\t\25\2\2\u01aaq\3\2\2\2\u01ab\u01ac\t\26\2\2\u01ac"+
		"s\3\2\2\28z|\u0086\u008d\u0090\u0097\u009e\u00a1\u00a5\u00a8\u00ab\u00b0"+
		"\u00b3\u00b6\u00bb\u00c4\u00c7\u00ce\u00d3\u00dc\u00e3\u00f4\u0107\u0113"+
		"\u011b\u011e\u0121\u0125\u0128\u012b\u012f\u0134\u0138\u013b\u013f\u0142"+
		"\u0147\u014b\u014e\u0152\u0157\u015b\u015e\u0161\u0165\u0168\u0177\u0179"+
		"\u017e\u0183\u0187\u018c\u0197\u0199";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}