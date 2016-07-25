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
package org.opensextant.howler.convertors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.Word;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Howler serves as the primary entry point for the HOWLER English
 * to/from OWL translation capabilities.
 */
public class Howler {

  /** The text factory. Creates SPOs from text */
  SPOFactoryText textFactory;

  /** The OWL factory. Creates SPOs from OWL */
  SPOFactoryOWL owlFactory;

  /** The text converter. Converts SPOs to text */
  SPOConverterText textConverter;

  /** The OWL converter. Converts SPOs to OWL */
  SPOConverterOWL owlConverter;

  /** The properties used to initialize Howler with its resources */
  Properties properties;

  /** The Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(Howler.class);

  /**
   * Instantiates a new Howler.
   *
   * @param propertiesPath
   *          the absolute path to the properties file
   */
  public Howler(String propertiesPath) {

    try {

      File propFile = new File(propertiesPath);

      // load properties file
      Properties props = new Properties();
      props.load(new FileInputStream(propFile));

      this.properties = props;

      // resource paths are relative to properties file
      File baseDir = propFile.getParentFile();

      File lexiconFile = new File(baseDir,
          props.getProperty("os.howler.lexicon"));
      File ngramFile = new File(baseDir, props.getProperty("os.howler.ngrams"));
      File phraseFile = new File(baseDir,
          props.getProperty("os.howler.phrases"));
      String vocab = props.getProperty("os.howler.defaultVocab");

      textFactory = new SPOFactoryText(lexiconFile, ngramFile, phraseFile,
          vocab);
      owlFactory = new SPOFactoryOWL();

      textConverter = new SPOConverterText();
      owlConverter = new SPOConverterOWL();

    } catch (FileNotFoundException e) {
      LOGGER.error(
          "Couldnt not initialize Howler. Could not find properties file:"
              + propertiesPath + " " + e.getMessage());
    } catch (IOException e) {
      LOGGER.error(
          "Couldnt not initialize Howler. IO Exception:" + e.getMessage());
    }

  }

  /**
   * Convert a Document to an OWL ontology.
   *
   * @param doc
   *          the Document containing the SPOs to be converted to an ontology
   * @return the OWL ontology that is the equivalent of the input Document
   */
  public OWLOntology toOntology(Document doc) {
    return owlConverter.createOntology(doc);
  }

  /**
   * Convert a single SPO to a single OWL axiom.
   *
   * @param spo
   *          the SPO to be translated
   * @return the OWL axiom which is the equivalent of the input SPO
   */
  public OWLAxiom toAxiom(SubjectPredicateObject spo) {
    return owlConverter.createAxiom(spo);
  }

  /**
   * A debug/testing method which shows how Howler is tokenizing and part of
   * speech tagging the input text.
   *
   * @param text
   *          the text to be examined
   * @return a list of Words which are the tokenized and tagged interpretation
   *         of the input
   * 
   */
  public List<Word> speechTagDocument(String text) {
    return textFactory.speechTagDocument(text, "test");
  }

  /**
   * Convert a Document of SPOs to text.
   *
   * @param doc
   *          the document to be translated
   * @return a list of Words which are the equivalent of the input Document
   */
  public List<String> toText(Document doc) {
    return textConverter.convertSPOsToText(doc);
  }

  /**
   * Convert a single SPO to a sentence
   *
   * @param spo
   *          the SPO to translate
   * @return the sentence which is the equivalent of the input SPO
   */
  public String toText(SubjectPredicateObject spo) {
    return textConverter.convertSPOtoText(spo);
  }

  /**
   * Convert English text to a document
   *
   * @param title
   *          the title for the created Document
   * @param text
   *          the English text to translate
   * @return the document which is the equivalent of the input text
   * 
   */
  public Document convertText(String title, String text) {
    return textFactory.convertText(title, text);
  }

  /**
   * Convert an OWL ontology to a Document
   *
   * @param onto
   *          the ontology to translate
   * @return the document which is the equivalent of the ontology
   */
  public Document convertOntology(OWLOntology onto) {
    return owlFactory.convertOntoloy(onto);
  }

  /**
   * Convert a single OWL axiom to a Document.
   *
   * @param axiom
   *          the axiom to translate
   * @param title
   *          the title for the created Document
   * @return the document which is the equivalent of the OWL axiom
   */
  public Document convertAxiom(OWLAxiom axiom, String title) {

    Document doc = new Document();
    doc.setTitle(title);
    doc.setSentences(owlFactory.convertAxiom(axiom));

    return doc;
  }

  /**
   * Gets the properties used to initialize this Howler.
   *
   * @return the properties
   */
  public Properties getProperties() {
    return properties;
  }

  /**
   * Gets the text factory.
   *
   * @return the text factory used by this Howler.
   */
  public SPOFactoryText getTextFactory() {
    return textFactory;
  }

  /**
   * Gets the OWL factory.
   *
   * @return the OWL factory used by this Howler.
   */
  public SPOFactoryOWL getOwlFactory() {
    return owlFactory;
  }

  /**
   * Gets the text converter.
   *
   * @return the text converter used by this Howler.
   */
  public SPOConverterText getTextConverter() {
    return textConverter;
  }

  /**
   * Gets the OWL converter.
   *
   * @return the OWL converter used by this Howler.
   */
  public SPOConverterOWL getOwlConverter() {
    return owlConverter;
  }

}
