package org.opensextant.howler.text;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class HOWLERTokenFactory implements TokenFactory<HOWLERToken> {

  @Override
  public HOWLERToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start,
      int stop, int line, int charPositionInLine) {

    HOWLERToken t = new HOWLERToken(type, text);
    t.setStartIndex(start);
    t.setStopIndex(stop);
    t.setChannel(channel);
    t.setLine(line);
    t.setCharPositionInLine(charPositionInLine);
    if (text != null) {
      t.setText(text);
    }

    return t;
  }

  @Override
  public HOWLERToken create(int type, String text) {
    return new HOWLERToken(type, text);
  }

}
