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
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.text.DocumentFactory;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
import org.opensextant.howler.text.FromText;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class ParserTest {

  public static void main(String[] args) throws IOException, OWLOntologyCreationException {

    File inputDirsFile = new File(args[0]);
    FileStructure fileMode = FileStructure.valueOf(args[1]);
    File resultsDir = new File(args[2]);
    File resourceDir = new File(args[3]);

    File posDir = new File(resourceDir, "pos");

    List<String> textDirs = FileUtils.readLines(inputDirsFile, "UTF-8");

    File lexFile = new File(posDir, "lexicon.txt");
    File gramFile = new File(posDir, "ngrams.txt");
    File typeInfoFile = new File(resourceDir, "typeInfo.txt");
    File phraseFile = new File(resourceDir, "phrases.txt");

    // FromText from = new FromText(lexFile, gramFile, typeInfoFile, phraseFile);

    File parseResults = new File(resultsDir, "ParserSentences.txt");
    File baseTextTestDir = inputDirsFile.getParentFile();

    // File to the total set of Words seen
    File wDump = new File(resultsDir, "wordDump.txt");

    FileUtils.writeStringToFile(parseResults, "File\toriginal text\tParse Type\tParse\tNormalized text\tPOS sequence\n",
        "UTF-8", false);

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
        String txtFileName = textFile.getName();

        WordManager.getWordManager().reset();
        FromText from = new FromText(lexFile, gramFile, typeInfoFile, phraseFile);

        System.out.println();
        System.out.println("Loading Text File " + textFile);
        List<String> originalTextDocs = DocumentFactory.createTextDocument(textFile, fileMode);
        System.out.println("Loaded " + originalTextDocs.size() + " text documents from " + textFile);

        for (String originalTextDoc : originalTextDocs) {

          // skip comments
          if (originalTextDoc.startsWith("//") || originalTextDoc.trim().isEmpty()) {
            continue;
          }

          // convert and convert the document
          IRI docIRI = IRI.create("http://example.org", "testDocument");

          Document doc = from.convertText(originalTextDoc, docIRI, "testDocument");

          // get the statements
          List<Statement> statements = doc.getStatements();

          // for each statement in converted document
          for (Statement statement : statements) {

            // create sequence of views of the token sequence
            StringBuilder posBldr = new StringBuilder();
            StringBuilder normBldr = new StringBuilder();

            for (Word w : statement.getWords()) {
              normBldr.append(w.getNormalForm());
              normBldr.append(" ");

              posBldr.append(w.getPOS());
              posBldr.append(" ");
            }

            String normSeq = normBldr.toString().trim();
            String posSeq = posBldr.toString().trim();

            String tree = statement.getSource();
            // flatten tree to list of nodes (Strings)
            List<String> nodes = Arrays.asList(tree.split(" +"));

            // see how the statement was parsed
            String parseType = nodes.get(0);
            String typeString = "";
            for (String t : nodes.subList(1, nodes.size())) {
              typeString = typeString + " " + t;
            }

            // write the details to results
            String txt = "";
            if (fileMode.equals(FileStructure.DOCUMENT_PER_LINE)) {
              txt = originalTextDoc;
            }

            FileUtils.writeStringToFile(parseResults, txtFileName + "\t" + txt + "\t" + parseType + "\t"
                + typeString.trim() + "\t" + normSeq + "\t" + posSeq + "\n", "UTF-8", true);
          }

        }
        // WordManager.getWordManager().reset();
      }
    }
    // WordManager.getWordManager().dumpWordsToFile(wDump);
  }

}
