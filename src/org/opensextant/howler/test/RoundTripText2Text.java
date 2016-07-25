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
package org.opensextant.howler.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.opensextant.howler.convertors.Howler;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.Word;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;

// text->SPO->text
public class RoundTripText2Text {
  public static void main(String[] args)
      throws IOException, OWLOntologyStorageException {

    String props = args[0];
    File test = new File(args[1]);
    File results = new File(args[2]);

    String title = "Test Text";

    List<String> lines = FileUtils.readLines(test);

    FileUtils.writeStringToFile(results,
        "Sentence\tPOS tags\tRound Trip #1 text\tRound trip #1 Match?\tRound Trip #2 text\t #2-original Match\t #2-#1 match\tAxiom type\tAxiom\n",
        false);

    Howler howler = new Howler(props);

    for (String text : lines) {

      StringBuilder outLine = new StringBuilder();

      if (text.startsWith("//")) {
        continue;
      }

      // write original sentence
      outLine.append(text);
      outLine.append("\t");

      // do part of speech tagging
      List<Word> wrds = howler.speechTagDocument(text);

      // output POS sequence
      for (Word w : wrds) {
        outLine.append(w.getPartOfSpeech());
        outLine.append(" ");
      }
      outLine.append("\t");

      // --------- Roundtrip #1: text->SPO->text -----------------------
      // convert text to SPOs
      Document sposRT1 = howler.convertText(title, text);

      // convert SPOs back to text -
      List<String> sentencesRT1 = howler.toText(sposRT1);

      // -------- Round-trip #2: text-SPO-Ontology-SPO-text -----------

      // convert SPOs to Ontology
      OWLOntology onto = howler.toOntology(sposRT1);

      // convert ontology back to SPOs
      Document sposRT2 = howler.convertOntology(onto);

      // convert SPOs back to text
      List<String> sentencesRT2 = howler.toText(sposRT2);

      // output sentence from first round trip
      // and if it matches starting text
      if (!sentencesRT1.isEmpty()) {
        String sentBack = sentencesRT1.get(0);
        outLine.append(sentBack);
        outLine.append("\t");
        outLine.append(text.equals(sentBack));
        outLine.append("\t");
      } else {
        outLine.append("");
        outLine.append("\t");
        outLine.append(false);
        outLine.append("\t");
      }

      // output sentence from second roundtrip
      // and it matches starting and first round trip
      if (!sentencesRT2.isEmpty()) {
        String sentBack = sentencesRT2.get(0);
        outLine.append(sentBack);
        outLine.append("\t");
        outLine.append(text.equals(sentBack));
        outLine.append("\t");
        if (!sentencesRT1.get(0).isEmpty()) {
          outLine.append(sentencesRT1.get(0).equals(sentBack));
        }
        outLine.append("\t");
      } else {
        outLine.append("");
        outLine.append("\t");
        outLine.append(false);
        outLine.append("\t");
      }

      // output first axiom generated
      List<OWLLogicalAxiom> axs = OWLAPIStreamUtils
          .asList(onto.logicalAxioms());

      // OWLAxiomToSPARQLConverter sparqer = new OWLAxiomToSPARQLConverter();
      // OWLClassExpressionToSPARQLConverter ceSparqer = new
      // OWLClassExpressionToSPARQLConverter();
      if (!axs.isEmpty()) {
        OWLLogicalAxiom ax = axs.iterator().next();
        outLine.append(ax.getAxiomType());
        outLine.append("\t");
        outLine.append(ax.toString());
        outLine.append("\t");
        // outLine.append(sparqer.asQuery(ax).toString().replaceAll("[\n\r]", "
        // "));

      }

      FileUtils.writeStringToFile(results, outLine.toString() + "\n", true);

    } // end line loop

  }// end main

}