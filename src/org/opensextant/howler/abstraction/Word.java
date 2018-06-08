package org.opensextant.howler.abstraction;

import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;

/**
 * Word is the fundamental (atomic) element of the abstraction consisting of
 * <ul>
 * <li>normalized form of the word (text)
 * <li>a WordType
 * <li>a Key
 * </ul>
 * A word is uniquely identified by the combination of its Key and WordType
 */

public interface Word {

  String getNormalForm();
  void setNormalForm(String normalForm);

  String getPOS();
  void setPOS(String pos);

  IRI getKey();
  String getLogicalForm();
  IRI getNamespace();

  Scope getScope();
  WordType getWordType();

  String getPrefix();
  void setPrefix(String prefix);

}