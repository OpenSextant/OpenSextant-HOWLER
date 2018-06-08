// Generated from HOWL.g4 by ANTLR 4.7.1

package org.opensextant.howler.text.grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link HOWL}.
 * @param <T>
 *          The return type of the visit operation. Use {@link Void} for operations with no return type.
 */
public interface HOWLVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link HOWL#document}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDocument(HOWL.DocumentContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#statement}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitStatement(HOWL.StatementContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#debug}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDebug(HOWL.DebugContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#factStatementData}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitFactStatementData(HOWL.FactStatementDataContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#factStatementObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitFactStatementObject(HOWL.FactStatementObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#descriptionStatementObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDescriptionStatementObject(HOWL.DescriptionStatementObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#descriptionStatementDataType}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDescriptionStatementDataType(HOWL.DescriptionStatementDataTypeContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#domainStatementDataType}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDomainStatementDataType(HOWL.DomainStatementDataTypeContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#domainStatementObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDomainStatementObject(HOWL.DomainStatementObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#domainStatementAnnotation}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDomainStatementAnnotation(HOWL.DomainStatementAnnotationContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#rangeStatementDataType}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitRangeStatementDataType(HOWL.RangeStatementDataTypeContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#rangeStatementObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitRangeStatementObject(HOWL.RangeStatementObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#rangeStatementAnnotation}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitRangeStatementAnnotation(HOWL.RangeStatementAnnotationContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateCharacteristicStatement}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateCharacteristicStatement(HOWL.PredicateCharacteristicStatementContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateRelationStatement}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateRelationStatement(HOWL.PredicateRelationStatementContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#annotationStatement}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitAnnotationStatement(HOWL.AnnotationStatementContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#declarationStatement}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDeclarationStatement(HOWL.DeclarationStatementContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#compoundNounPhrase}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitCompoundNounPhrase(HOWL.CompoundNounPhraseContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#properNounPhrase}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitProperNounPhrase(HOWL.ProperNounPhraseContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#nProperSequence}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitNProperSequence(HOWL.NProperSequenceContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#commonNounPhrase}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitCommonNounPhrase(HOWL.CommonNounPhraseContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#adjp}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitAdjp(HOWL.AdjpContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#dataTypeExpression}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDataTypeExpression(HOWL.DataTypeExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#dataTypeRestriction}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDataTypeRestriction(HOWL.DataTypeRestrictionContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#dataFacetExpression}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDataFacetExpression(HOWL.DataFacetExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#dataValuePhrase}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDataValuePhrase(HOWL.DataValuePhraseContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#dataValue}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDataValue(HOWL.DataValueContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#quant}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitQuant(HOWL.QuantContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#quantNumeric}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitQuantNumeric(HOWL.QuantNumericContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#quantNumericExpression}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitQuantNumericExpression(HOWL.QuantNumericExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionObject(HOWL.PredicateExpressionObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionData}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionData(HOWL.PredicateExpressionDataContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionAnnotation}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionAnnotation(HOWL.PredicateExpressionAnnotationContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionVerbData}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionVerbData(HOWL.PredicateExpressionVerbDataContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpression}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpression(HOWL.PredicateExpressionContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionVerb}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionVerb(HOWL.PredicateExpressionVerbContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionState}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionState(HOWL.PredicateExpressionStateContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionSimple}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionSimple(HOWL.PredicateExpressionSimpleContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionParticle}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionParticle(HOWL.PredicateExpressionParticleContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionPassive}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionPassive(HOWL.PredicateExpressionPassiveContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionNoun}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionNoun(HOWL.PredicateExpressionNounContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionSameAs}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionSameAs(HOWL.PredicateExpressionSameAsContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionBE}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionBE(HOWL.PredicateExpressionBEContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionDO}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionDO(HOWL.PredicateExpressionDOContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicateExpressionHAS}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicateExpressionHAS(HOWL.PredicateExpressionHASContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicate}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicate(HOWL.PredicateContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicatePhraseNoun}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicatePhraseNoun(HOWL.PredicatePhraseNounContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicatePhraseDataType}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicatePhraseDataType(HOWL.PredicatePhraseDataTypeContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicatePhraseDataValue}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicatePhraseDataValue(HOWL.PredicatePhraseDataValueContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#predicatePhrase}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitPredicatePhrase(HOWL.PredicatePhraseContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#singlePhraseObject}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitSinglePhraseObject(HOWL.SinglePhraseObjectContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#singlePhraseData}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitSinglePhraseData(HOWL.SinglePhraseDataContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#catchSet}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitCatchSet(HOWL.CatchSetContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#badSentence}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitBadSentence(HOWL.BadSentenceContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#wordSequence}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitWordSequence(HOWL.WordSequenceContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#declareWordSequence}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDeclareWordSequence(HOWL.DeclareWordSequenceContext ctx);
  /**
   * Visit a parse tree produced by {@link HOWL#debugWordSequence}.
   * @param ctx
   *          the parse tree
   * @return the visitor result
   */
  T visitDebugWordSequence(HOWL.DebugWordSequenceContext ctx);
}