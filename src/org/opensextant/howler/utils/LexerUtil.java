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
package org.opensextant.howler.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

public class LexerUtil {

  public static void main(String[] args) {
    // generate token ID lookup table
    // used both in the lexer and the parser
    File lexiconFile = new File(args[0]);
    File phraseFile = new File(args[1]);
    File tagFile = new File(args[2]);

    Set<String> tagSet = LexerUtil.createTagSet(lexiconFile, phraseFile);

    // delete the tagfile if its there
    try {
      FileUtils.write(tagFile, "", false);
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    int index = 1;
    for (String tag : tagSet) {
      try {
        String line = tag + "=" + index + "\n";
        FileUtils.write(tagFile, line, true);
        index++;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static Set<String> createTagSet(File lexicon, File phraseFile) {

    // the set of all tags see in the lexicon and phrase files
    Set<String> tagSet = new TreeSet<String>();

    // find all tags used in the lexicon
    List<String> lexiconLines = null;
    try {
      lexiconLines = FileUtils.readLines(lexicon);
    } catch (IOException e) {
      e.printStackTrace();
      return tagSet;
    }

    // find all tags used in the phrases
    List<String> phraseLines = null;
    try {
      phraseLines = FileUtils.readLines(phraseFile);
    } catch (IOException e) {
      e.printStackTrace();
      return tagSet;
    }

    // for each lexicon entry pull out the tags used
    for (String line : lexiconLines) {
      String[] pieces = line.split("\\s");
      for (int t = 1; t < pieces.length; t = t + 2) {
        String tag = pieces[t];
        if (!tag.startsWith("<")) {
          tagSet.add(tag);
        }
      }
    }

    // get the set of phrase types
    for (String line : phraseLines) {
      String[] pieces = line.split("\t");
      String tag = pieces[0];
      tagSet.add(tag);
    }

    return tagSet;
  }
}
