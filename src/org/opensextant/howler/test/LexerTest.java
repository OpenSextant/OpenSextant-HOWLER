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
import org.opensextant.howler.text.DocumentFactory;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
import org.opensextant.howler.text.HOWLERToken;
import org.opensextant.howler.text.HowlerLexer;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class LexerTest {

  public static void main(String[] args) throws IOException, OWLOntologyCreationException {

    File inputDirsFile = new File(args[0]);
    FileStructure fileMode = FileStructure.valueOf(args[1]);
    File resultsDir = new File(args[2]);
    File resourceDir = new File(args[3]);

    File posDir = new File(resourceDir, "pos");

    List<String> textDirs = FileUtils.readLines(inputDirsFile);

    File lexFile = new File(posDir, "lexicon.txt");
    File gramFile = new File(posDir, "ngrams.txt");
    File typeInfoFile = new File(resourceDir, "typeInfo.txt");
    File phraseFile = new File(resourceDir, "phrases.txt");

    HowlerLexer lexer = new HowlerLexer(lexFile, gramFile, typeInfoFile, phraseFile);

    File typeReport = new File(resultsDir, "LexerTypeReport.txt");
    lexer.generateTypeReport(lexFile, typeReport);

    File results = new File(resultsDir, "LexerSentences.txt");

    File baseTextTestDir = inputDirsFile.getParentFile();

    // write header to results
    FileUtils.writeStringToFile(results,
        "File\tGood Lex\tOriginal text\tTokenized Text\tNormalized\tPOS and Phrase tags\tToken Types\tBAD Tokens\n", false);

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

          // run the text through the lexer
          lexer.setInput(originalTextDoc);
          List<HOWLERToken> backtokens = lexer.getTokens();

          // create sequence of aspects of the token sequence
          StringBuilder textBldr = new StringBuilder();
          StringBuilder posBldr = new StringBuilder();
          StringBuilder normBldr = new StringBuilder();
          StringBuilder tokenTypeBldr = new StringBuilder();
          StringBuilder badBldr = new StringBuilder();


          for (HOWLERToken tok : backtokens) {

            if (tok.getTokenTypeName().equals("BAD")) {
              badBldr.append(tok.getText() + " (" + tok.getPos() + ")");
              badBldr.append(" ");
            }

            textBldr.append(tok.getText());
            textBldr.append("|");

            posBldr.append(tok.getPos());
            posBldr.append(" ");

            normBldr.append(tok.getNormalForm());
            normBldr.append(" ");

            tokenTypeBldr.append(tok.getTokenTypeName());
            tokenTypeBldr.append(" ");
          }

          String textSeq = textBldr.toString().trim();
          String normSeq = normBldr.toString().trim();
          String posSeq = posBldr.toString().trim();
          String typeSeq = tokenTypeBldr.toString().trim();
          String badSeq = badBldr.toString().trim();
          
          // did the result contain a token mapped to the BAD type?
          boolean goodLex = badSeq.isEmpty();

          // write the details to results
          FileUtils.writeStringToFile(results, txtFileName + "\t" + goodLex + "\t" + originalTextDoc + "\t" + textSeq
              + "\t" + normSeq + "\t" + posSeq + "\t" + typeSeq + "\t" + badSeq + "\n", true);

        }
      }
    }

  }

}
