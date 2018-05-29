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
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.owl.ToOWL;
import org.opensextant.howler.text.FromText;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class Text2OWL {

  public static void main(String[] args) throws IOException, OWLOntologyCreationException {

    File inputDirsFile = new File(args[0]);
    File resultsDir = new File(args[1]);
    File resourceDir = new File(args[2]);

    File posDir = new File(resourceDir, "pos");

    List<String> textDirs = FileUtils.readLines(inputDirsFile, "UTF-8");

    File lexFile = new File(posDir, "lexicon.txt");
    File gramFile = new File(posDir, "ngrams.txt");
    File typeInfoFile = new File(resourceDir, "typeInfo.txt");
    File phraseFile = new File(resourceDir, "phrases.txt");

    File baseTextTestDir = inputDirsFile.getParentFile();

    FromText from = new FromText(lexFile, gramFile, typeInfoFile, phraseFile);
    ToOWL toOWL = new ToOWL();

    for (String textDir : textDirs) {

      // skip comments
      if (textDir.startsWith("#") || textDir.trim().isEmpty()) {
        continue;
      }

      File inputDir = new File(baseTextTestDir, textDir);

      // find all the text files in the input dir
      String[] exts = {".txt"};
      FilenameFilter filter = new SuffixFileFilter(exts);
      File[] textFiles = inputDir.listFiles(filter);

      for (File textFile : textFiles) {
        String txtFileName = textFile.getName().split("\\.")[0];

        System.out.println();
        System.out.println("Loading Text File " + textFile);
        String txt = FileUtils.readFileToString(textFile, "UTF-8");

        IRI docIRI = IRI.create("http://example.org", "testDocument");
        //convert to ontology
        Document doc = from.convertText(txt, docIRI, "testDocument");
        System.out.println("\tConverted Text to abstraction");
        OWLOntology onto = toOWL.convert(doc);
        System.out.println("\tConverted abstraction to OWL");
        File out = new File(resultsDir, txtFileName + ".owl");
        toOWL.saveOntology(onto, out);
        
      }
      WordManager.getWordManager().reset();
    }
  }
}
