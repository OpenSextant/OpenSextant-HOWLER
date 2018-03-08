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

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextUtils {

  static Map<String, Integer> numbers = new HashMap<String, Integer>();

  static {
    numbers.put("one", 1);
    numbers.put("two", 2);
    numbers.put("three", 3);
    numbers.put("four", 4);
    numbers.put("five", 5);
    numbers.put("six", 6);
    numbers.put("seven", 7);
    numbers.put("eight", 8);
    numbers.put("nine", 9);
    numbers.put("ten", 10);
    numbers.put("eleven", 11);
    numbers.put("twelve", 12);
  }

  // Log object
  private static final Logger LOGGER = LoggerFactory.getLogger(TextUtils.class);

  public static Integer convertNumber(String text) {

    try {
      if (text.matches("[0-9]+")) {
        int num = Integer.parseInt(text);
        return num;
      }
    } catch (NumberFormatException e) {
      LOGGER.error("Didn't convert number string to numeric " + text);
      return 1;
    }

    if (numbers.containsKey(text.toLowerCase())) {
      return numbers.get(text);
    }

    LOGGER.error("Didn't convert number string to numeric " + text);

    return 1;
  }

  public static String getLogicalForm(IRI key) {
    String shortForm = key.getShortForm();
    String[] pieces = key.toString().split("[/#]|_:");
    String lastBit = pieces[pieces.length - 1];

    if (!shortForm.equals(lastBit)) {
      // LOGGER.warn("Possibly malformed IRI:" + iri + " using " + lastBit);
      return lastBit;
    }
    return shortForm;
  }

  public static String getNamespace(IRI key) {
    String keyString = key.toString();
    return keyString.substring(0, keyString.length() - getLogicalForm(key).length());
  }

}
