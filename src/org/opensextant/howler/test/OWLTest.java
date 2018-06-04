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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.owl.FromOWL;
import org.opensextant.howler.owl.ToOWL;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLNaryAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;

/**
 * The Class OWLTest does a round trip from OWL to Abstraction back to OWL and compares the original to converted.
 */
public class OWLTest {
  public static void main(String[] args) throws IOException, OWLOntologyCreationException {

    File inputDirsFile = new File(args[0]);
    File resultsDir = new File(args[1]);
    boolean ignoreBadImports = Boolean.valueOf(args[2]);

    // the to and from converters
    FromOWL fromOWL = new FromOWL(ignoreBadImports);
    ToOWL toOWL = new ToOWL();
    // use same manager for both to and from
    toOWL.setOwlOntologyManager(fromOWL.getOntologyManager());

    // expand n-ary axioms including all pairs
    fromOWL.setMaxPairs(-1);
    
    // rewrite Domain/Ranges to subclass axioms?
    fromOWL.setRewriteDomainRanges(false);

    // rewrite all axioms as subclass axioms?
    fromOWL.setRewriteAllAsSubclass(false);

    // convert axiom to Negation Normal Form 
    fromOWL.setNegNormal(false);
    
    // if only one individual in set, use HasValue not SomeValuesFrom
    toOWL.setUseHasValue(true);
    
    List<String> ontoDirs = FileUtils.readLines(inputDirsFile, "UTF-8");

    // create and write header to Summary file
    File summary = new File(resultsDir, "Summary.txt");
    FileUtils.writeStringToFile(summary,
        "Ontology File\tOntology Name\tVersion\tAxiom (Missing)\tAxiom (Extra)\t Axiom (NYI)" + "\n", "UTF-8", false);

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

      File results = new File(resultsDir, inputDir.getName() + "_AxiomCompare.txt");

      // write header to result files
      FileUtils.writeStringToFile(results, "Ontology Name\tStatus\tAxiom Type\tAxiom" + "\n", "UTF-8", false);

      for (File ontoFile : ontos) {
        String ontoName = ontoFile.getName();

        System.out.println();
        System.out.println("Loading Ontology\t" + ontoFile);
        AutoIRIMapper mapper = new AutoIRIMapper(ontoFile.getParentFile(), true);
        fromOWL.getOntologyManager().getIRIMappers().add(mapper);
        OWLOntology originalOnto = fromOWL.getOntologyManager().loadOntologyFromOntologyDocument(ontoFile);
        // expand the nary axioms to pairwise (which is what the
        // conversion does)
        expandNary(originalOnto);
        OWLOntologyID origID = originalOnto.getOntologyID();

        // convert ontology to abstraction and back to ontology
        OWLOntology backOnto = toOWL.convert(fromOWL.convertOWL(originalOnto));



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
              FileUtils.writeStringToFile(results,
                  ontoName + "\t" + "NYI" + "\t" + originalAx.getAxiomType() + "\t" + originalAx + "\n", "UTF-8", true);
            } else {
              axiomErrorsMissing++;
              FileUtils.writeStringToFile(results,
                  ontoName + "\t" + "Missing" + "\t" + originalAx.getAxiomType() + "\t" + originalAx + "\n", "UTF-8",
                  true);
            }
          }
        }

        // compare each axiom in back converted ontology to see if it
        // appears in original ontology
        for (OWLAxiom backAx : OWLAPIStreamUtils.asList(backOnto.axioms())) {
          if (!compare(originalOnto, backAx)) {
            axiomErrorsExtra++;
            FileUtils.writeStringToFile(results,
                ontoName + "\t" + "Extra" + "\t" + backAx.getAxiomType() + "\t" + backAx + "\n", "UTF-8", true);
          }
        }

        // write the summary
        FileUtils
            .writeStringToFile(summary,
                ontoFile + "\t" + origID.getOntologyIRI().orElse(null) + "\t" + origID.getVersionIRI().orElse(null)
                    + "\t" + axiomErrorsMissing + "\t" + axiomErrorsExtra + "\t" + axiomErrorsNYI + "\n",
                "UTF-8", true);
      }
    }
    // dump the vocabulary from the WordManager
    WordManager.getWordManager().dumpWordsToFile(wDump);
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

    // TODO check for subclass rewrite

    return false;
  }

}
