package org.opensextant.howler.test;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.opensextant.howler.text.HOWLERToken;
import org.opensextant.howler.text.grammar.HOWL.DocumentContext;
import org.opensextant.howler.text.grammar.HOWLBaseVisitor;

public class HowlWalker extends HOWLBaseVisitor<List<HOWLERToken>> {

  @Override
  public List<HOWLERToken> visitDocument(DocumentContext ctx) {
    return super.visitDocument(ctx);
  }

  @Override
  public List<HOWLERToken> visitTerminal(TerminalNode node) {

    Token token = node.getSymbol();
    ArrayList<HOWLERToken> list = new ArrayList<HOWLERToken>();
    if (token instanceof HOWLERToken) {
      HOWLERToken hTok = (HOWLERToken) token;
      list.add(hTok);
    } else {
      list.add(null);
    }
    return list;
  }

  @Override
  public List<HOWLERToken> visitChildren(RuleNode node) {
    List<HOWLERToken> tmp = super.visitChildren(node);
    return tmp;
  }

  @Override
  protected List<HOWLERToken> defaultResult() {
    ArrayList<HOWLERToken> tmp = new ArrayList<HOWLERToken>();
    return tmp;
  }

  @Override
  protected List<HOWLERToken> aggregateResult(List<HOWLERToken> aggregate, List<HOWLERToken> nextResult) {
    List<HOWLERToken> tmp = new ArrayList<HOWLERToken>(aggregate);
    tmp.addAll(nextResult);
    return tmp;
  }

}
