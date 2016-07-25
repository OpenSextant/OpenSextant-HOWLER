/*
 * **************************************************************************
 *					     NOTICE
 *
 *	This software was produced for the U. S. Government
 *	under Basic Contract No. W15P7T-13-C-A802, and is
 *	subject to the Rights in Noncommercial Computer Software
 *	and Noncommercial Computer Software Documentation
 *	Clause 252.227-7014 (FEB 2012)
 *
 *  2016 The MITRE Corporation. All Rights Reserved.
 *
 * **************************************************************************
 */
package org.opensextant.howler.spo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Document is a container for SPO which are created by one of the
 * Factories and are concumed by one of the Converters
 */
public class Document {

  String title = "New Document";
  List<SubjectPredicateObject> sentences = new ArrayList<SubjectPredicateObject>();
  List<String> unparsedSentences = new ArrayList<String>();

  /**
   * Gets the title.
   *
   * @return the title of the document
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the titl eof the document.
   *
   * @param title
   *          the new title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the sentences (SPOs) which were successully created.
   *
   * @return the sentences as SPOs
   */
  public List<SubjectPredicateObject> getSentences() {
    return sentences;
  }

  /**
   * Sets the sentences.
   *
   * @param sentences
   *          the new sentences
   */
  public void setSentences(List<SubjectPredicateObject> sentences) {
    this.sentences = sentences;
  }

  /**
   * Adds a sentence.
   *
   * @param sentence
   *          the sentence
   */
  public void addSentence(SubjectPredicateObject sentence) {
    this.sentences.add(sentence);
  }

  /**
   * Gets the sentences which failed translation.
   *
   * @return the unparsed sentences
   */
  public List<String> getUnparsedSentences() {
    return unparsedSentences;
  }

  /**
   * Sets the unparsed sentences.
   *
   * @param unparsedSentences
   *          the new unparsed sentences
   */
  public void setUnparsedSentences(List<String> unparsedSentences) {
    this.unparsedSentences = unparsedSentences;
  }

  /**
   * Adds a unparsed sentence.
   *
   * @param unparsedSentence
   *          the unparsed sentence
   */
  public void addUnparsedSentences(String unparsedSentence) {
    this.unparsedSentences.add(unparsedSentence);
  }

  /**
   * Gets the words.
   *
   * @return the words
   */
  public Set<Word> getWords() {

    Set<Word> words = new HashSet<Word>();
    for (SubjectPredicateObject spo : this.sentences) {
      words.addAll(spo.getWords());
    }
    return words;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  public String toString() {

    return this.title + "-" + this.sentences;

  }

}
