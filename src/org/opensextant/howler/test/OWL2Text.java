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
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.owl.FromOWL;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
import org.opensextant.howler.text.TextDocument;
import org.opensextant.howler.text.ToText;

/**
 * The Class OWLTest does a round trip from OWL to Abstraction back to OWL and compares the original to converted.
 */

public class OWL2Text {

  public static void main(String[] args) throws IOException {

    File inputDirsFile = new File(args[0]);
    File resultsDir = new File(args[1]);

    FileStructure outFormat = FileStructure.DOCUMENT_PER_LINE;

    try {
      outFormat = FileStructure.valueOf(args[2]);
    } catch (Exception e) {
      System.err.println("Bad value for format:" + args[2]);
    }

    boolean ignoreBadImports = Boolean.valueOf(args[3]);

    // the to and from converters
    FromOWL fromOWL = new FromOWL(ignoreBadImports);
    ToText toText = new ToText();

    fromOWL.setRewriteAllAsSubclass(false);
    fromOWL.setMaxPairs(-1);
    fromOWL.setFlattenSingleSet(false);
    fromOWL.setNegNormal(false);

    List<String> ontoDirs = FileUtils.readLines(inputDirsFile, "UTF-8");

    File results = new File(resultsDir, "sentences.txt");
    File byOntoDir = new File(resultsDir, "byOnto");
    byOntoDir.mkdirs();

    FileUtils.writeStringToFile(results, "OntoFile\tAxiomType\tAxiom\tText\n", "UTF-8", false);

    File baseOntoTestDir = inputDirsFile.getParentFile();
    // File to the total set of Words seen
    File wDump = new File(resultsDir, "wordDump.txt");

    for (String ontoDir : ontoDirs) {

      // skip comments
      if (ontoDir.startsWith("#") || ontoDir.trim().isEmpty()) {
        continue;
      }

      File inputDir = new File(baseOntoTestDir, ontoDir);

      // find all the ontology files in the input dir
      String[] exts = {".owl", ".ttl", ".rdf"};
      FilenameFilter filter = new SuffixFileFilter(exts);
      File[] ontos = inputDir.listFiles(filter);

      for (File ontoFile : ontos) {
        System.out.println("Converting " + ontoFile);

        TextDocument backText = toText.convert(fromOWL.convertOWL(ontoFile));

        // create a name from the input ontology file
        String ontoNameBase = ontoFile.getName().split("\\.")[0];
        File outText = new File(byOntoDir, ontoNameBase + ".txt");
        FileUtils.writeStringToFile(outText, backText.toString(outFormat, true), "UTF-8");
      }
    }

    // dump all words seen during all ontology conversions
    WordManager.getWordManager().dumpWordsToFile(wDump);
  }

}
