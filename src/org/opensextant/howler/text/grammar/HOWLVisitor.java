// Generated from HOWL.g4 by ANTLR 4.7.1

 package org.opensextant.howler.text.grammar;

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
	 * Visit a parse tree produced by {@link HOWL#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HOWL.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#singlePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePhrase(HOWL.SinglePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#debug}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebug(HOWL.DebugContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#descriptionStatementObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptionStatementObject(HOWL.DescriptionStatementObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#descriptionStatementDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptionStatementDataType(HOWL.DescriptionStatementDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#factStatementData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactStatementData(HOWL.FactStatementDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#factStatementObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactStatementObject(HOWL.FactStatementObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateRelationStatementObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateRelationStatementObject(HOWL.PredicateRelationStatementObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateRelationStatementData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateRelationStatementData(HOWL.PredicateRelationStatementDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateRelationStatementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateRelationStatementAnnotation(HOWL.PredicateRelationStatementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateCharacteristicStatementObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateCharacteristicStatementObject(HOWL.PredicateCharacteristicStatementObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateCharacteristicStatementData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateCharacteristicStatementData(HOWL.PredicateCharacteristicStatementDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateCharacteristicStatementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateCharacteristicStatementAnnotation(HOWL.PredicateCharacteristicStatementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#annotationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationStatement(HOWL.AnnotationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#commonNounPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonNounPhrase(HOWL.CommonNounPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#adjp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdjp(HOWL.AdjpContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#properNounPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperNounPhrase(HOWL.ProperNounPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nProperSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNProperSequence(HOWL.NProperSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nounOrProperNounPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNounOrProperNounPhrase(HOWL.NounOrProperNounPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#oneOfProperNoun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOfProperNoun(HOWL.OneOfProperNounContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nounSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNounSet(HOWL.NounSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nounPhraseSubject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNounPhraseSubject(HOWL.NounPhraseSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#nounPhraseCatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNounPhraseCatch(HOWL.NounPhraseCatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataTypePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypePhrase(HOWL.DataTypePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataTypeRestriction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeRestriction(HOWL.DataTypeRestrictionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#facet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFacet(HOWL.FacetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataValuePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValuePhrase(HOWL.DataValuePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValue(HOWL.DataValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(HOWL.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#oneOfData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOfData(HOWL.OneOfDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataTypeSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeSet(HOWL.DataTypeSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataPhrase(HOWL.DataPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#dataPhraseCatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataPhraseCatch(HOWL.DataPhraseCatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#annotationWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationWord(HOWL.AnnotationWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuant(HOWL.QuantContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#quantNumeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantNumeric(HOWL.QuantNumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionObject(HOWL.PredicateExpressionObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionData(HOWL.PredicateExpressionDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionAnnotation(HOWL.PredicateExpressionAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpression(HOWL.PredicateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionVerbObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionVerbObject(HOWL.PredicateExpressionVerbObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionVerbData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionVerbData(HOWL.PredicateExpressionVerbDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionVerbAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionVerbAnnotation(HOWL.PredicateExpressionVerbAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionVerb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionVerb(HOWL.PredicateExpressionVerbContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionState}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionState(HOWL.PredicateExpressionStateContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionSimple(HOWL.PredicateExpressionSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionParticle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionParticle(HOWL.PredicateExpressionParticleContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionPassive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionPassive(HOWL.PredicateExpressionPassiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionNoun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionNoun(HOWL.PredicateExpressionNounContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionBE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionBE(HOWL.PredicateExpressionBEContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionSameAs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionSameAs(HOWL.PredicateExpressionSameAsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionDO}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionDO(HOWL.PredicateExpressionDOContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionHAS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionHAS(HOWL.PredicateExpressionHASContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicateExpressionHAS_POSS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateExpressionHAS_POSS(HOWL.PredicateExpressionHAS_POSSContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseCommonNoun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseCommonNoun(HOWL.PredicatePhraseCommonNounContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseProperNoun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseProperNoun(HOWL.PredicatePhraseProperNounContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseProperNounSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseProperNounSet(HOWL.PredicatePhraseProperNounSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseNounSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseNounSet(HOWL.PredicatePhraseNounSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseCommonNounOrSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseCommonNounOrSet(HOWL.PredicatePhraseCommonNounOrSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseItself}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseItself(HOWL.PredicatePhraseItselfContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseNoun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseNoun(HOWL.PredicatePhraseNounContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseDataType(HOWL.PredicatePhraseDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseDataValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseDataValue(HOWL.PredicatePhraseDataValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseDataValueSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseDataValueSet(HOWL.PredicatePhraseDataValueSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseDataSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseDataSet(HOWL.PredicatePhraseDataSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseData(HOWL.PredicatePhraseDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#predicatePhraseMixed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicatePhraseMixed(HOWL.PredicatePhraseMixedContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#singlePhraseObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePhraseObject(HOWL.SinglePhraseObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#singlePhraseData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinglePhraseData(HOWL.SinglePhraseDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#catchSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchSet(HOWL.CatchSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#badSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBadSentence(HOWL.BadSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link HOWL#catchAll}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchAll(HOWL.CatchAllContext ctx);
}