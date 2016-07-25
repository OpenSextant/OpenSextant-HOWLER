// Generated from HOWL.g4 by ANTLR 4.5.3

 package org.opensextant.howler.grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HOWL}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HOWLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HOWL#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(HOWL.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(HOWL.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#simpleSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSentence(HOWL.SimpleSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#np}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNp(HOWL.NpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nbar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNbar(HOWL.NbarContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nbarProper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNbarProper(HOWL.NbarProperContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nbarCommon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNbarCommon(HOWL.NbarCommonContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNSimple(HOWL.NSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nProper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNProper(HOWL.NProperContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nProperSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNProperSequence(HOWL.NProperSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nThing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNThing(HOWL.NThingContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nAdj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNAdj(HOWL.NAdjContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#adjp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjp(HOWL.AdjpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuant(HOWL.QuantContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantNeg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantNeg(HOWL.QuantNegContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantThe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantThe(HOWL.QuantTheContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantA(HOWL.QuantAContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantUniverse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantUniverse(HOWL.QuantUniverseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantExist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantExist(HOWL.QuantExistContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantNumeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantNumeric(HOWL.QuantNumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#exact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExact(HOWL.ExactContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#more}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMore(HOWL.MoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#less}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(HOWL.LessContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#moreOrEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreOrEqual(HOWL.MoreOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#lessOrEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(HOWL.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVp(HOWL.VpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vbar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVbar(HOWL.VbarContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vbarSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVbarSimple(HOWL.VbarSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vbarPassive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVbarPassive(HOWL.VbarPassiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vbarAdj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVbarAdj(HOWL.VbarAdjContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#v}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitV(HOWL.VContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVSimple(HOWL.VSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vParticle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVParticle(HOWL.VParticleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vPassive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVPassive(HOWL.VPassiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vBE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVBE(HOWL.VBEContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vSameAs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVSameAs(HOWL.VSameAsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vDO}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVDO(HOWL.VDOContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#vHAS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVHAS(HOWL.VHASContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#verbBE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbBE(HOWL.VerbBEContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#verbDO}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbDO(HOWL.VerbDOContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#verbHAS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbHAS(HOWL.VerbHASContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerb(HOWL.VerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#modal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModal(HOWL.ModalContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#phraseSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhraseSet(HOWL.PhraseSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#junk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJunk(HOWL.JunkContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#j}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJ(HOWL.JContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(HOWL.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#catchPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchPhrase(HOWL.CatchPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#adjWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjWord(HOWL.AdjWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#advWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdvWord(HOWL.AdvWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#connWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnWord(HOWL.ConnWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#detWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetWord(HOWL.DetWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#modWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModWord(HOWL.ModWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nounWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNounWord(HOWL.NounWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#punctWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPunctWord(HOWL.PunctWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#verbWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbWord(HOWL.VerbWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#phraseWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhraseWord(HOWL.PhraseWordContext ctx);
}