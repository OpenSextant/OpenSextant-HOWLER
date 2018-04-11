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
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.opensextant.howler.abstraction.WordManager;
import org.opensextant.howler.owl.FromOWL;
import org.opensextant.howler.owl.ToOWL;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.MissingImportEvent;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.MissingImportListener;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNaryAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.parameters.ChangeApplied;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;

public class OWLTest {
	@SuppressWarnings("serial")
	public static void main(String[] args) throws IOException, OWLOntologyCreationException {

		File inputDirsFile = new File(args[0]);
		File resultsDir = new File(args[1]);
		boolean ignoreBadImports = Boolean.valueOf(args[2]);
		
		List<String> ontoDirs = FileUtils.readLines(inputDirsFile);

		// create and write header to Summary file
		File summary = new File(resultsDir, "Summary.txt");
		FileUtils.writeStringToFile(summary,
				"Ontology File\tOntology Name\tVersion\tHeader\tAnnotations (Missing)\tAnnotations (Extra)\t"
						+ "Import (Missing)\tImport (Extra)\t" + "Signature (Missing)\tSignature (Extra)\t"
						+ "Axiom (Missing)\tAxiom (Extra)\t Axiom (NYI)" + "\n",
				false);

		OWLOntologyManager mgr = OWLManager.createOWLOntologyManager();
		// setup the ontology manager to ignore missing imports if desired
		if (ignoreBadImports) {
			OWLOntologyLoaderConfiguration loadConfig = new OWLOntologyLoaderConfiguration()
					.setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT).setStrict(false)
					.setFollowRedirects(true);
			mgr.setOntologyLoaderConfiguration(loadConfig);
		}

		File baseOntoTestDir = inputDirsFile.getParentFile();
		//File to the total set of Words seen
		File wDump = new File(resultsDir, "wordDump.txt");
		
		for (String ontoDir : ontoDirs) {
 
			// skip comments
			if (ontoDir.startsWith("#") || ontoDir.trim().isEmpty()) {
				continue;
			}

			File inputDir = new File(baseOntoTestDir,ontoDir);

			// AutoMapper attempts to find imported ontologies located in same
			// directories as ontology
			AutoIRIMapper mapper = new AutoIRIMapper(inputDir, true);
			mgr.getIRIMappers().add(mapper);

			// find all the ontology files in the input dir
			String[] exts = { ".owl", ".ttl", ".rdf" };
			FilenameFilter filter = new SuffixFileFilter(exts);
			File[] ontos = inputDir.listFiles(filter);

			File results = new File(resultsDir, inputDir.getName() + "_AxiomCompare.txt");
			File signs = new File(resultsDir, inputDir.getName() + "_SignatureCompare.txt");
			File hdrs = new File(resultsDir, inputDir.getName() + "_HeaderCompare.txt");


			// write header to result files
			FileUtils.writeStringToFile(results, "Ontology Name\tStatus\tAxiom Type\tAxiom" + "\n", false);
			FileUtils.writeStringToFile(signs, "Ontology Name\tStatus\tEntity Type\tEntity\tWord" + "\n", false);
			FileUtils.writeStringToFile(hdrs, "Ontology Name\tStatus\tHeaderElement\tDetails" + "\n", false);

			// the to and from converters
			ToOWL to = new ToOWL();
			FromOWL from = new FromOWL();
			// expand n-ary axioms including all pairs
			from.setMaxPairs(-1);

			for (File ontoFile : ontos) {
				String ontoName = ontoFile.getName();
				// clear the manager after each ontology to avoid multiple
				// version errors
				mgr.clearOntologies();

				// add a listener for any missing imports
				mgr.addMissingImportListener(new MissingImportListener() {
					public void importMissing(MissingImportEvent event) {
						IRI importURI = event.getImportedOntologyURI();
						System.out.println(
								"Cannot import\t" + importURI + "\t" + event.getCreationException().getMessage());
					}
				});

				System.out.println();
				System.out.println("Loading Ontology\t" + ontoFile);
				OWLOntology originalOnto = mgr.loadOntologyFromOntologyDocument(ontoFile);
				System.out.println("Loaded Ontology\t" + ontoFile);

				// convert ontology to abstraction and back to ontology
				System.out.println("Roundtripping Ontology\t" + ontoFile);
				OWLOntology backOnto = to.convert(from.convertOWL(originalOnto));
				System.out.println("Roundtripped Ontology\t" + ontoFile);

				OWLOntologyID origID = originalOnto.getOntologyID();
				OWLOntologyID backID = backOnto.getOntologyID();

				// expand the nary axioms to pairwise (which is what the
				// conversion does)
				expandNary(originalOnto);

				// compare headers

				int headerErrors = 0;
				// compare IDs
				if (!origID.equals(backID) && !origID.isAnonymous() && !backID.isAnonymous()) {
					headerErrors++;
					FileUtils.writeStringToFile(hdrs, ontoName + "\t" + "Missing" + "\t" + "Header\t" + origID + "=>"
							+ backOnto.getOntologyID() + "\n", true);
				}

				// compare prefix
				// TODO

				// compare annotations
				Set<OWLAnnotation> origAnnos = originalOnto.annotations().collect(Collectors.toSet());
				Set<OWLAnnotation> backAnnos = backOnto.annotations().collect(Collectors.toSet());
				int annoErrorsMissing = 0;
				int annoErrorsExtra = 0;
				for (OWLAnnotation anno : origAnnos) {
					if (!backAnnos.contains(anno)) {
						annoErrorsMissing++;
						FileUtils.writeStringToFile(hdrs,
								ontoName + "\t" + "Missing" + "\t" + "Annotation\t" + anno + "\n", true);
					}
				}
				for (OWLAnnotation anno : backAnnos) {
					if (!origAnnos.contains(anno)) {
						annoErrorsExtra++;
						FileUtils.writeStringToFile(hdrs,
								ontoName + "\t" + "Extra" + "\t" + "Annotation\t" + anno + "\n", true);
					}
				}

				// compare imports
				Set<IRI> origImports = originalOnto.directImportsDocuments().collect(Collectors.toSet());
				Set<IRI> backImports = backOnto.directImportsDocuments().collect(Collectors.toSet());

				int importErrorsMissing = 0;
				int importErrorsExtra = 0;
				for (IRI imported : origImports) {
					if (!backImports.contains(imported)) {
						importErrorsMissing++;
						FileUtils.writeStringToFile(hdrs,
								ontoName + "\t" + "Missing" + "\t" + "Import\t" + imported + "\n", true);
					}
				}
				for (IRI imported : backImports) {
					if (!origImports.contains(imported)) {
						importErrorsExtra++;
						FileUtils.writeStringToFile(hdrs,
								ontoName + "\t" + "Extra" + "\t" + "Import\t" + imported + "\n", true);
					}
				}

				// compare signatures
				Set<OWLEntity> originalSignature = OWLAPIStreamUtils.asSet(originalOnto.signature());
				Set<OWLEntity> backSignature = OWLAPIStreamUtils.asSet(backOnto.signature());

				int signErrorsMissing = 0;
				int signErrorsExtra = 0;

				for (OWLEntity original : originalSignature) {
					if (!backSignature.contains(original) && !original.isBuiltIn()
							&& !original.getIRI().isReservedVocabulary()) {
						signErrorsMissing++;
						FileUtils.writeStringToFile(signs, ontoName + "\t" + "Missing" + "\t" + original.getEntityType()
								+ "\t" + original + "\t" + from.lookupPrimitive(original).orElse(null) + "\n", true);
					}
				}

				for (OWLEntity back : backSignature) {
					if (!originalSignature.contains(back) && !back.isBuiltIn()
							&& !back.getIRI().isReservedVocabulary()) {
						signErrorsExtra++;
						FileUtils.writeStringToFile(signs, ontoName + "\t" + "Extra" + "\t" + back.getEntityType()
								+ "\t" + back + "\t" + from.lookupPrimitive(back).orElse(null) + "\n", true);
					}
				}

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
							FileUtils.writeStringToFile(results, ontoName + "\t" + "NYI" + "\t"
									+ originalAx.getAxiomType() + "\t" + originalAx + "\n", true);
						} else {
							if (!isBuiltin(originalAx)) {
								axiomErrorsMissing++;
								FileUtils.writeStringToFile(results, ontoName + "\t" + "Missing" + "\t"
										+ originalAx.getAxiomType() + "\t" + originalAx + "\n", true);
							}
						}
					}
				}

				// compare each axiom in back converted ontology to see if it
				// appears in original ontology
				for (OWLAxiom backAx : OWLAPIStreamUtils.asList(backOnto.axioms())) {
					if (!compare(originalOnto, backAx)) {
						if (!isBuiltin(backAx)) {
							axiomErrorsExtra++;
							FileUtils.writeStringToFile(results,
									ontoName + "\t" + "Extra" + "\t" + backAx.getAxiomType() + "\t" + backAx + "\n",
									true);
						}
					}
				}

				// write the summary
				FileUtils.writeStringToFile(summary,
						ontoFile + "\t" + origID.getOntologyIRI().orElse(null) + "\t"
								+ origID.getVersionIRI().orElse(null) + "\t" + headerErrors + "\t" + annoErrorsMissing
								+ "\t" + annoErrorsExtra + "\t" + importErrorsMissing + "\t" + importErrorsExtra + "\t"
								+ signErrorsMissing + "\t" + signErrorsExtra + "\t" + axiomErrorsMissing + "\t"
								+ axiomErrorsExtra + "\t" + axiomErrorsNYI + "\n",
						true);
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
			ChangeApplied applied = originalOnto.getOWLOntologyManager().applyChanges(changes);
			System.out.println("Expanded\t" + changes.size() + " " + applied);
		}
	}

	// don't worry about missing/extra declarations of RDF/XML/OWL builtin types
	private static boolean isBuiltin(OWLAxiom ax) {
		if (ax.isOfType(AxiomType.DECLARATION)) {
			OWLDeclarationAxiom dec = (OWLDeclarationAxiom) ax;
			if (dec.getEntity().isBuiltIn() || dec.getEntity().getIRI().isReservedVocabulary()) {
				return true;
			}
		}
		return false;
	}

	// see if an axioms appears in an ontology ignoring any axiom-level
	// annotations
	private static boolean compare(OWLOntology onto, OWLAxiom ax) {

		if (onto.containsAxiomIgnoreAnnotations(ax)) {
			return true;
		}
		return false;
	}

}
