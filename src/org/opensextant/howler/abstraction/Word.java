package org.opensextant.howler.abstraction;

import java.util.List;

import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

//Words are a vocabulary element consisting of
//   normalized form of the word (text)
//   a WordType
//   a Key
// A word is uniquely identified by the combination of its Key and WordType 

public interface Word {

  String getNormalForm();

  void setNormalForm(String normalForm);

  IRI getKey();

  String getLogicalForm();

  String getNamespace();

  Scope getScope();

  WordType getWordType();

  List<Footnote> getFootnotes();

  void setFootnotes(List<Footnote> footnotes);

  void addFootnote(Footnote footnote);

}