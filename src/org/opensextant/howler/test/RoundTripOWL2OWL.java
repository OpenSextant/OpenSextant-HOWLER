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
package org.opensextant.howler.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.opensextant.howler.convertors.Howler;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.utils.OWLUtils;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;

// text->SPO->text
public class RoundTripOWL2OWL {
  public static void main(String[] args) throws IOException {

    String props = args[0];
    File test = new File(args[1]);
    File results = new File(args[2]);
    File entities = new File(args[3]);

    Howler howler = new Howler(props);

    FileUtils.writeStringToFile(results,
        "Sentence\tPOS tags\tRound Trip verbalization\tAxiom\n", false);

    OWLOntologyManager mgr = OWLManager.createOWLOntologyManager();
    OWLOntologyLoaderConfiguration loadConfig = new OWLOntologyLoaderConfiguration()
        .setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT)
        .setStrict(false);

    mgr.setOntologyLoaderConfiguration(loadConfig);

    try {
      OWLOntology onto = mgr.loadOntologyFromOntologyDocument(test);

      List<OWLEntity> signs = OWLAPIStreamUtils.asList(onto.signature());
      FileUtils.writeStringToFile(entities, "Entity Type\tEntity\n", false);

      for (OWLEntity en : signs) {
        StringBuilder outLine = new StringBuilder();
        outLine.append(en.getEntityType().toString());
        outLine.append("\t");
        String fragment = OWLUtils.getIRIShortform(en.getIRI());
        outLine.append(fragment);
        outLine.append("\t");
        String split = fragment.replaceAll("([A-Z][a-z])", "\t$1");
        outLine.append(split.toLowerCase().trim());

        FileUtils.writeStringToFile(entities, outLine.toString() + "\n", true);
      }

      for (OWLAxiom ax : OWLAPIStreamUtils.asList(onto.logicalAxioms())) {
        StringBuilder outLine = new StringBuilder();
        outLine.append(ax.getAxiomType().toString());
        outLine.append("\t");
        outLine.append(ax);
        outLine.append("\t");

        Document doc = howler.convertAxiom(ax, "Single Axiom");

        // convert SPOs back to English
        List<String> sentences = howler.toText(doc);
        if (!sentences.isEmpty()) {
          outLine.append(sentences.get(0));
          for (int i = 1; i < sentences.size(); i++) {
            outLine.append(", ");
            outLine.append(sentences.get(i));
          }

        }
        FileUtils.writeStringToFile(results, outLine.toString() + "\n", true);
      }

    } catch (OWLOntologyCreationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}// end main
