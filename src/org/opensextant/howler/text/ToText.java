package org.opensextant.howler.text;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToText {
  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(ToText.class);

  public TextDocument convert(Document doc) {

    TextDocument textDoc = new TextDocument();

    if (doc.getDocumentID().isPresent()) {
      textDoc.setId(doc.getDocumentID().get());
    }
    textDoc.setShortName(doc.getShortname());

    // convert the statements
    for (Statement statement : doc.getStatements()) {
      // TODO
      List<Sentence> sentences = new ArrayList<Sentence>();// = convert(statement);

      for (Sentence sent : sentences) {
        textDoc.addSentence(sent);
      }
    }

    // convert (add) the vocabulary
    for (Word w : doc.getVocabulary()) {
      textDoc.addVocabulary(w);
    }

    return textDoc;
  }

}
