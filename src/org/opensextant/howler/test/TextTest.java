package org.opensextant.howler.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.text.DocumentFactory;
import org.opensextant.howler.text.DocumentFactory.FileStructure;
import org.opensextant.howler.text.FromText;
import org.opensextant.howler.text.ToText;
import org.semanticweb.owlapi.model.IRI;

public class TextTest {

  public static void main(String[] args) throws IOException {
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
    File wordTypeInfoFile = new File(resourceDir, "wordTypeInfo.txt");
    
    FromText from = new FromText(lexFile, gramFile, typeInfoFile, phraseFile,wordTypeInfoFile);
    ToText to = new ToText();

    File results = new File(resultsDir, "textBack.txt");

    File baseTextTestDir = inputDirsFile.getParentFile();

    // write header to results
    FileUtils.writeStringToFile(results, "File\tMatches\tOriginal text\tBack Text\tClean Original\tClean Back\n",
        false);

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
          System.out.println("Roundtripping Text\t" + txtFileName);
          List<Statement> statements = from.convertText(originalTextDoc, docIRI, "testDocument").getStatements();

          StringBuilder bldr = new StringBuilder();

          for (Statement state : statements) {
            for (Word w : state.getWords()) {
              bldr.append(w.getNormalForm());
              bldr.append(" ");
            }
          }
          
          String backText = bldr.toString();
          String cleanOrig = originalTextDoc.trim().replaceAll("\\.$", "").trim().replaceAll("( |^)an ", " a ").trim();
          String cleanBack = backText.trim().replaceAll("\\.$", "").trim().replaceAll("_", " ").trim();
          boolean matchText = cleanOrig.equalsIgnoreCase(cleanBack);// compare(originalTextDoc,backText );

          // write the details to results
          FileUtils.writeStringToFile(results, txtFileName + "\t" + matchText + "\t" + originalTextDoc + "\t" + backText
              + "\t" + cleanOrig + "\t" + cleanBack + "\t" + "\n", true);

        }
      }
    }

  }

  private static boolean compare(String orig, String back) {
    String origString = orig.trim().replaceAll("\\.$", "").trim().replaceAll("( |^)an ", "a ").trim();
    String backText = back.trim().replaceAll("\\.$", "").trim().replaceAll("_", " ").trim();
    return origString.equalsIgnoreCase(backText);
  }

}
