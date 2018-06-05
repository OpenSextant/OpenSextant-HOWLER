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
import org.opensextant.howler.text.DocumentFactory;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
import org.opensextant.howler.text.FromText;
import org.opensextant.howler.text.Sentence;
import org.opensextant.howler.text.TextDocument;
import org.opensextant.howler.text.ToText;
import org.semanticweb.owlapi.model.IRI;

/**
 * The Class TextTest does a round trip from text to abstraction back to text and compares original to converted.
 */
public class TextTest {

  public static void main(String[] args) throws IOException {
    File inputDirsFile = new File(args[0]);
    FileStructure fileMode = FileStructure.valueOf(args[1]);
    File resultsDir = new File(args[2]);
    File resourceDir = new File(args[3]);

    File posDir = new File(resourceDir, "pos");

    List<String> textDirs = FileUtils.readLines(inputDirsFile,"UTF-8");

    File lexFile = new File(posDir, "lexicon.txt");
    File gramFile = new File(posDir, "ngrams.txt");
    File typeInfoFile = new File(resourceDir, "typeInfo.txt");
    File phraseFile = new File(resourceDir, "phrases.txt");

    FromText from = new FromText(lexFile, gramFile, typeInfoFile, phraseFile);
    ToText to = new ToText();

    File results = new File(resultsDir, "textBack.txt");
    File wordManagerDump = new File(resultsDir, "wordManagerDump.txt");

    File baseTextTestDir = inputDirsFile.getParentFile();

    // write header to results
    FileUtils.writeStringToFile(results, "File\tStatement Type\tMatches\tOriginal text\tBack Text\n", "UTF-8",false);

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

        System.out.println();
        System.out.println("Loading Text File " + textFile);
        List<String> originalTextDocs = DocumentFactory.createTextDocument(textFile, fileMode);
        System.out.println("Loaded " + originalTextDocs.size() + " text documents from " + textFile);

        for (String originalTextDoc : originalTextDocs) {

          // skip comments
          if (originalTextDoc.startsWith("//") || originalTextDoc.trim().isEmpty()) {
            continue;
          }

          IRI docIRI = IRI.create("http://example.org", "testDocument");
          // convert text to abstraction and back to text
          TextDocument doc = to.convert(from.convertText(originalTextDoc, docIRI, "testDocument"));
          List<Sentence> sentences = doc.getSentences();

          // for each statement in converted document
          for (Sentence sentence : sentences) {
            String backText = sentence.toString().trim();
            boolean matchText = compare(originalTextDoc, backText);
            // String clean = clean(originalTextDoc, backText);
            String parse = sentence.getParseTree();
            String sentType = sentType(parse);

            // write the details to results
            FileUtils.writeStringToFile(results, txtFileName + "\t" + sentType + "\t" + matchText + "\t"
                + originalTextDoc + "\t" + backText + "\t" + parse + "\n", "UTF-8",true);
          }

        }

      }
    }
    WordManager.getWordManager().dumpWordsToFile(wordManagerDump);
  }

  private static boolean compare(String orig, String back) {
    String[] pieces = clean(orig, back).split("\t");
    if (pieces.length == 2) {
      return pieces[0].equalsIgnoreCase(pieces[1]);
    } else {
      return false;
    }

  }

  private static String clean(String orig, String back) {
    String cleanOrig = orig.trim().replaceAll("\\.$", "").trim().replaceAll("( |^)[aA]n ", " a ")
        .replaceAll("doesn't", "does not").replaceAll("\\s+", " ").trim();
    String backText = back.trim().replaceAll("\\.$", "").trim().replaceAll("_", " ").replaceAll("\\s+", " ").trim();
    return cleanOrig + "\t" + backText;
  }

  private static String sentType(String parse) {
    String[] pieces = parse.split("[\\(\\) ]");

    if (pieces.length > 2) {
      return pieces[3];
    }
    if (pieces.length > 1) {
      return pieces[1].split(" ")[0];
    }
    return "";
  }

}
