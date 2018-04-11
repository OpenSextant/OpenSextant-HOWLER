package org.opensextant.howler.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DocumentFactory {

  public enum FileStructure {
    DOCUMENT_PER_LINE, SINGLE_BLOCK, MULTI_BLOCK
  };

  public static List<String> createTextDocument(File input, FileStructure structure) throws IOException {

    List<String> bodies = new ArrayList<String>();

    if (structure.equals(FileStructure.DOCUMENT_PER_LINE)) {

      for (String line : FileUtils.readLines(input, "UTF-8")) {
        if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
          bodies.add(line);
        }
      }
    }

    if (structure.equals(FileStructure.SINGLE_BLOCK)) {
      bodies.add(FileUtils.readFileToString(input, "UTF-8"));
    }

    if (structure.equals(FileStructure.MULTI_BLOCK)) {
      bodies.addAll(Arrays.asList(FileUtils.readFileToString(input, "UTF-8").split("[\n\r]{2,}")));
    }

    return bodies;
  }

}
