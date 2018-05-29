/*
   Copyright 2009-2016 The MITRE Corporation.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
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
package org.opensextant.howler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.kanban.elements.Sentence;
import org.opensextant.howler.owl.FromOWL;
import org.opensextant.howler.owl.ToOWL;
import org.opensextant.howler.text.FromText;
import org.opensextant.howler.text.TextDocument;
import org.opensextant.howler.text.ToText;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Howler serves as the primary entry point for the HOWLER English to/from OWL translation capabilities.
 */
public class Howler {

  /** The text factory. Creates statements to/from text */
  FromText fromText;
  ToText toText;

  /** The OWL factory. Creates statements to/from OWL */
  FromOWL fromOWL = new FromOWL();
  ToOWL toOWL = new ToOWL();

  /** The properties used to initialize Howler with its resources */
  Properties properties;

  /** The Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(Howler.class);

  /**
   * Instantiates a new Howler.
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

      File lexiconFile = new File(baseDir, props.getProperty("os.howler.lexicon"));
      File ngramFile = new File(baseDir, props.getProperty("os.howler.ngrams"));
      File typeInfoFile = new File(baseDir, props.getProperty("os.howler.typeinfo"));
      File phraseFile = new File(baseDir, props.getProperty("os.howler.phrases"));

      fromText = new FromText(lexiconFile, ngramFile, typeInfoFile, phraseFile);

    } catch (FileNotFoundException e) {
      LOGGER.error(
          "Couldnt not initialize Howler. Could not find properties file:" + propertiesPath + " " + e.getMessage());
    } catch (IOException e) {
      LOGGER.error("Couldnt not initialize Howler. IO Exception:" + e.getMessage());
    }

  }

  /**
   * Convert a Document to an OWL ontology.
   * @param doc
   *          the Document containing the SPOs to be converted to an ontology
   * @return the OWL ontology that is the equivalent of the input Document
   */
  public OWLOntology toOntology(Document doc, boolean clear) {
    return toOWL.convert(doc, clear);
  }

  /**
   * Convert a single SPO to one or more OWL axioms.
   * @param spo
   *          the SPO to be translated
   * @return the OWL axiom which is the equivalent of the input SPO
   */
  public List<OWLAxiom> toAxiom(Statement spo) {
    return toOWL.convert(spo);
  }

  /**
   * Convert a Document of SPOs to text.
   * @param doc
   *          the document to be translated
   * @return a list of Words which are the equivalent of the input Document
   */
  public TextDocument toText(Document doc) {
    return toText.convert(doc);
  }

  /**
   * Convert a single SPO to a sentence
   * @param spo
   *          the SPO to translate
   * @return the sentence which is the equivalent of the input SPO
   */
  public Sentence toText(Statement spo) {
    return null; // toText.convertAbstraction(spo);
  }

  /**
   * Convert English text to a document
   * @param title
   *          the title for the created Document
   * @param text
   *          the English text to translate
   * @return the document which is the equivalent of the input text
   */
  public Document convertText(TextDocument doc) {
    return fromText.convertText(doc);
  }

  /**
   * Convert an OWL ontology to a Document
   * @param onto
   *          the ontology to translate
   * @return the document which is the equivalent of the ontology
   */
  public Document convertOntology(OWLOntology onto) {
    return fromOWL.convertOWL(onto);
  }

  /**
   * Convert a single OWL axiom to a Document.
   * @param axiom
   *          the axiom to translate
   * @param title
   *          the title for the created Document
   * @return the document which is the equivalent of the OWL axiom
   */
  public Document convertAxiom(OWLAxiom axiom, String title) {

    Document doc = new Document();
    for (Statement st : fromOWL.convertOWL(axiom)) {
      doc.addStatement(st);
    }
    return doc;
  }

  /**
   * Gets the properties used to initialize this Howler.
   * @return the properties
   */
  public Properties getProperties() {
    return properties;
  }

  /**
   * Gets the text factory.
   * @return the text factory used by this Howler.
   */
  public FromText getTextFactory() {
    return fromText;
  }

  /**
   * Gets the OWL factory.
   * @return the OWL factory used by this Howler.
   */
  public FromOWL getOwlFactory() {
    return fromOWL;
  }

  public Document convertText(String title, String text) {
    // TODO Auto-generated method stub
    return null;
  }

}
