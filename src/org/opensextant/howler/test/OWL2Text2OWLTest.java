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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.owl.FromOWL;
import org.opensextant.howler.owl.ToOWL;
import org.opensextant.howler.text.FromText;
import org.opensextant.howler.text.ToText;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNaryAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.search.EntitySearcher;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;

/**
 * The Class OWLTest does a round trip from OWL to Abstraction back to OWL and compares the original to converted.
 */
public class OWL2Text2OWLTest {

  public static void main(String[] args) throws IOException, OWLOntologyCreationException {

    File inputDirsFile = new File(args[0]);
    File resultsDir = new File(args[1]);
    boolean ignoreBadImports = Boolean.valueOf(args[2]);
    File resourceDir = new File(args[3]);

    File posDir = new File(resourceDir, "pos");

    File lexFile = new File(posDir, "lexicon.txt");
    File gramFile = new File(posDir, "ngrams.txt");
    File typeInfoFile = new File(resourceDir, "typeInfo.txt");
    File phraseFile = new File(resourceDir, "phrases.txt");

    // the to and from converters
    ToOWL toOWL = new ToOWL();
    toOWL.setUseHasValue(false);
    
    FromOWL fromOWL = new FromOWL(ignoreBadImports);
    fromOWL.setRewriteAllAsSubclass(false);
    fromOWL.setMaxPairs(-1);
    fromOWL.setFlattenSingleSet(false);
    fromOWL.setNegNormal(false);

    ToText toText = new ToText();
    FromText fromText = new FromText(lexFile, gramFile, typeInfoFile, phraseFile);

    List<String> ontoDirs = FileUtils.readLines(inputDirsFile, "UTF-8");

    // create and write header to Summary file
    File summary = new File(resultsDir, "Summary.txt");
    FileUtils.writeStringToFile(summary,
        "Ontology File\tOntology Name\tVersion\tAxiom (Missing)\tAxiom (Extra)\t Axiom (NYI)" + "\n", "UTF-8", false);

    File baseOntoTestDir = inputDirsFile.getParentFile();
    // File to the total set of Words seen

    File totalResults = new File(resultsDir, "total_AxiomCompare.txt");

    FileUtils.writeStringToFile(totalResults, "Ontology Name\tStatus\tAxiom Type\tAxiom" + "\n", "UTF-8", false);
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

      File results = new File(resultsDir, inputDir.getName() + "_AxiomCompare.txt");
      File wDump = new File(resultsDir, inputDir.getName() + "_wordDump.txt");
      // write header to result files
      FileUtils.writeStringToFile(results, "Ontology Name\tStatus\tAxiom Type\tAxiom" + "\n", "UTF-8", false);
      for (File ontoFile : ontos) {
        String ontoName = ontoFile.getName();

        System.out.println();
        System.out.println("Loading Ontology\t" + ontoFile);
        OWLOntology originalOnto = fromOWL.loadOWL(ontoFile);

        // expand the nary axioms to pairwise (which is what the
        // conversion does)
        expandNary(originalOnto);
        // convert ontology to text and back to ontology
        OWLOntology backOnto = toOWL.convert(fromText.convertText(toText.convert(fromOWL.convertOWL(originalOnto))));
        OWLOntologyID origID = originalOnto.getOntologyID();

        int axiomErrorsMissing = 0;
        int axiomErrorsExtra = 0;
        int axiomErrorsNYI = 0;
        // compare axioms

        // compare each axiom in original to see if it appears in back
        // converted ontology
        for (OWLAxiom originalAx : OWLAPIStreamUtils.asList(originalOnto.axioms())) {
          if (!compare(backOnto, originalAx)) {

            if (nyi(originalAx)) {
              axiomErrorsNYI++;
              FileUtils.writeStringToFile(results, ontoName + "\t" + "NYI" + "\t" + originalAx.getAxiomType() + "\t"
                  + originalAx.toString().replaceAll("[\\n\\r\\t]", "<WHITE_SPACE>") + "\n", "UTF-8", true);
              FileUtils.writeStringToFile(totalResults, ontoName + "\t" + "NYI" + "\t" + originalAx.getAxiomType()
                  + "\t" + originalAx.toString().replaceAll("[\\n\\r\\t]", " ") + "\n", "UTF-8", true);
            } else {
              axiomErrorsMissing++;
              FileUtils.writeStringToFile(results, ontoName + "\t" + "Missing" + "\t" + originalAx.getAxiomType() + "\t"
                  + originalAx.toString().replaceAll("[\\n\\r\\t]", "<WHITE_SPACE>") + "\n", "UTF-8", true);
              FileUtils.writeStringToFile(totalResults, ontoName + "\t" + "Missing" + "\t" + originalAx.getAxiomType()
                  + "\t" + originalAx.toString().replaceAll("[\\n\\r\\t]", "<WHITE_SPACE>") + "\n", "UTF-8", true);
            }
          }
        }

        // compare each axiom in back converted ontology to see if it
        // appears in original ontology
        for (OWLAxiom backAx : OWLAPIStreamUtils.asList(backOnto.axioms())) {
          if (!compare(originalOnto, backAx)) {
            axiomErrorsExtra++;

            FileUtils.writeStringToFile(results, ontoName + "\t" + "Extra" + "\t" + backAx.getAxiomType() + "\t"
                + backAx.toString().replaceAll("[\\n\\r\\t]", "<WHITE_SPACE>") + "\n", "UTF-8", true);
            FileUtils.writeStringToFile(totalResults, ontoName + "\t" + "Extra" + "\t" + backAx.getAxiomType() + "\t"
                + backAx.toString().replaceAll("[\\n\\r\\t]", "<WHITE_SPACE>") + "\n", "UTF-8", true);
          }
        }

        // write the summary
        FileUtils
            .writeStringToFile(summary,
                ontoFile + "\t" + origID.getOntologyIRI().orElse(null) + "\t" + origID.getVersionIRI().orElse(null)
                    + "\t" + axiomErrorsMissing + "\t" + axiomErrorsExtra + "\t" + axiomErrorsNYI + "\n",
                "UTF-8", true);
      }
      // dump the vocabulary from the WordManager
      WordManager.getWordManager().dumpWordsToFile(wDump);
      WordManager.getWordManager().reset();
    }

  }

  // catch the axioms that are not yet implmeneted by the converters
  private static boolean nyi(OWLAxiom ax) {
    if (ax.getAxiomType().equals(AxiomType.SUB_PROPERTY_CHAIN_OF) || ax.getAxiomType().equals(AxiomType.SWRL_RULE)
        || ax.getAxiomType().equals(AxiomType.HAS_KEY)) {
      return true;
    }
    return false;
  }

  // expand n-ary axioms into all pairwise combinations
  private static void expandNary(OWLOntology originalOnto) {

    List<OWLOntologyChange> changes = new ArrayList<OWLOntologyChange>();

    for (OWLAxiom originalAx : OWLAPIStreamUtils.asList(originalOnto.axioms())) {

      if (originalAx instanceof OWLNaryAxiom) {
        changes.add(new RemoveAxiom(originalOnto, originalAx));

        OWLNaryAxiom<?> nary = (OWLNaryAxiom<?>) originalAx;
        // for (OWLAxiom pairAx : nary.splitToAnnotatedPairs()) {
        for (OWLAxiom pairAx : nary.asPairwiseAxioms()) {
          changes.add(new AddAxiom(originalOnto, pairAx));
        }
      }
    }

    if (!changes.isEmpty()) {
      originalOnto.getOWLOntologyManager().applyChanges(changes);
    }
  }

  // see if an axioms appears in an ontology ignoring any axiom-level
  // annotations
  private static boolean compare(OWLOntology onto, OWLAxiom ax) {
    
    if (onto.containsAxiomIgnoreAnnotations(ax)) {
      return true;
    }

    //see if there is an annotation with same literal value
    if (ax.getAxiomType().equals(AxiomType.ANNOTATION_ASSERTION)) {
      OWLAnnotationAssertionAxiom anno = (OWLAnnotationAssertionAxiom) ax;
      Optional<OWLLiteral> value = anno.literalValue();
      String litString = "";
      if (value.isPresent()) {
        OWLLiteral lit = value.get();
         litString = lit.getLiteral();
      }else{
        return false;
      }
      
      //annotation asserts with same subject
      List<OWLAnnotationAssertionAxiom> annos = OWLAPIStreamUtils.asList(EntitySearcher.getAnnotationAssertionAxioms(anno.getSubject(), onto));

        for (OWLAnnotationAssertionAxiom annoAx : annos) {
          if (annoAx.literalValue().isPresent()) {
            OWLLiteral axLit = annoAx.literalValue().get();
            String axLitString = axLit.getLiteral();
            if (axLitString.equals(litString)) {
              return true;
            }
          }
        }
        return false;
      }
    

    // TODO check for subclass rewrite

    return false;
  }

}
