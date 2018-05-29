package org.opensextant.howler.text;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class HowlerTokenFactory implements TokenFactory<HowlerToken> {

  @Override
  public HowlerToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start,
      int stop, int line, int charPositionInLine) {

    HowlerToken t = new HowlerToken(type, text);
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
  public HowlerToken create(int type, String text) {
    return new HowlerToken(type, text);
  }

}
