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
package org.opensextant.howler.examples;

import java.util.List;

import org.opensextant.howler.convertors.Howler;
import org.opensextant.howler.spo.Document;
import org.semanticweb.owlapi.model.OWLOntology;

public class BasicExample {

  /*
   * A worked example of using HOWLER to convert between OWL and English
   */
  public static void main(String[] args) {

    // initial Howler with property file
    // the default properties file provided in the resources directory should be
    // sufficient
    Howler howler = new Howler(args[0]);

    // sample input data
    // The title is used to create the ontologies identifier
    String title = "Test Example";

    // Sentences to be translated. Must be valid HOWLER grammar sentences.
    String inputText = "A car has 4 wheels.  A motorcycle has 2 wheels.";

    // convert text to SPOs
    Document spos = howler.convertText(title, inputText);

    // check spos here for conversion details
    List<String> unparsed = spos.getUnparsedSentences();
    if (!unparsed.isEmpty()) {
      System.out.println("Could not parse " + unparsed.size() + " sentences");
    }

    // convert SPOs to Ontology
    OWLOntology onto = howler.toOntology(spos);

    // do something with ontology here

    // convert back to text
    List<String> sentencesBack = howler.toText(howler.convertOntology(onto));

    // do something with sentences here

    System.out.println("These converted sentences:");
    for (String sent : sentencesBack) {
      System.out.println("\t\t" + sent);
    }

    System.out.println(
        "Should look like these original sentences:\n\t\t" + inputText);
  }

}