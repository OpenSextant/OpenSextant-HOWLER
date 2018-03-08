package org.opensextant.howler.abstraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.abstraction.words.Adjective;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.BadWord;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.IntegerNum;
import org.opensextant.howler.abstraction.words.Negative;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.PredicateParticle;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.UndeterminedPredicate;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.RelativeMarker;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class WordManager {

	/** The LOGGER. */
	public static final Logger LOGGER = LoggerFactory.getLogger(WordManager.class);

	// static MorphAnalyzer lemmatizer = new EnglishMorphAnalyzer();

	// List of managed word, unique by key and class
	private Set<Word> words = new HashSet<Word>();

	private static WordManager wm = new WordManager();

	public static WordManager getWordManager() {
		return wm;
	}

	private WordManager() {
		// add the fixed Vocabulary to Manager
		for (Word w : Vocabulary.fixedVocabulary) {
			this.addWord(w);
		}
	}

	public void addWord(Word newWord) {

		List<Word> wordsByKey = lookupByKey(newWord.getKey());
		List<Word> typedWordsByKey = lookupByKeyTypedOnly(newWord.getKey());

		if (newWord.getWordType().equals(WordType.GENERIC_WORD)) {
			if (wordsByKey.isEmpty()) {
				words.add(newWord);
				return;
			}
			// merge in any footnotes from generic word
			mergeFootnotes(wordsByKey, newWord);
			return;
		} else {
			Optional<Word> existingGenericWord = lookupByKeyAndType(newWord.getKey(), WordType.GENERIC_WORD);
			if (existingGenericWord.isPresent()) {
				if (words.remove(existingGenericWord.get())) {
					mergeFootnotes(newWord, existingGenericWord.get());
				} else {
					LOGGER.error("Could not remove general WORD:" + existingGenericWord.get());
				}
			}
			mergeFootnotes(newWord, typedWordsByKey);
			mergeFootnotes(typedWordsByKey, newWord);
			words.add(newWord);
		}

	}

	public <T extends Word> T lookupOrCreateByKeyAndType(IRI key, WordType wordType) {

		// check for existing word with same key and word type
		Optional<Word> wrd = lookupByKeyAndType(key, wordType);

		// found something
		if (wrd.isPresent()) {
			return (T) wrd.get();
		}

		// didn't find anything. Create word with key and type
		return createByKeyAndType(key, wordType);
	}

	public <T extends Word> List<T> lookupOrCreateByNormalForm(String normal, WordType wordType, IRI ns) {

		List<T> wrds = lookupByNormalAndType(normal, wordType);

		if (!wrds.isEmpty()) {
			return wrds;
		}

		String logical = logicalize(normal);
		IRI key = IRI.create(ns.toString(), logical);
		if (wordType.equals(WordType.ADJECTIVE)) {
			key = IRI.create(ns.toString(), logical + "_thing");
		}

		List<T> newWrds = new ArrayList<T>();
		newWrds.add(createByNormalKeyAndType(normal, key, wordType));
		return newWrds;
	}

	private <T extends Word> T createByKeyAndType(IRI key, WordType wordType) {
		String normal = getDefaultNormalForm(key);
		return createByNormalKeyAndType(normal, key, wordType);
	}

	private <T extends Word> T createByNormalKeyAndType(String normal, IRI key, WordType wordType) {

		if (wordType.equals(WordType.ADJECTIVE)) {
			Adjective wrd = new Adjective(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.ANNOTATION_PREDICATE)) {
			AnnotationPredicate wrd = new AnnotationPredicate(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.BADWORD)) {
			BadWord wrd = new BadWord(normal);
			// addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.COMMON_NOUN)) {
			CommonNoun wrd = new CommonNoun(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.DATA_PREDICATE)) {
			DataPredicate wrd = new DataPredicate(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.DATA_FACET_PREDICATE)) {
			DataFacet fc = DataFacet.getTypeByNormalName(normal);
			DataFacetPredicate wrd = new DataFacetPredicate(fc);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.DATATYPE)) {
			DataType wrd = new DataType(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.DATAVALUE)) {
			DataValue wrd = new DataValue(normal);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.GENERIC_WORD)) {
			GenericWord wrd = new GenericWord(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.INTEGER)) {
			IntegerNum wrd = new IntegerNum(normal);
			// addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.NEGATIVE)) {
			Negative wrd = new Negative(normal);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.OBJECT_PREDICATE)) {
			ObjectPredicate wrd = new ObjectPredicate(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.PREDICATE_PARTICLE)) {
			PredicateParticle wrd = new PredicateParticle(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.PROPER_NOUN)) {
			ProperNoun wrd = new ProperNoun(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.UNDETERMINED_PREDICATE)) {
			UndeterminedPredicate wrd = new UndeterminedPredicate(normal, key);
			addWord(wrd);
			normalize(wrd);
			return (T) wrd;
		}

		/*------------ The Enumerated Types ----------------*/

		if (wordType.equals(WordType.BOOLEAN_SET_TYPE)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			BooleanSetType wrd = BooleanSetType.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.DATA_FACET)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			DataFacet wrd = DataFacet.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.PREDICATE_CHARACTERISTIC)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			PredicateCharacteristic wrd = PredicateCharacteristic.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.QUANTIFIER)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			Quantifier wrd = Quantifier.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.RELATIVE_MARKER)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			RelativeMarker wrd = RelativeMarker.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.SCOPE)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			Scope wrd = Scope.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		if (wordType.equals(WordType.WORD_TYPE)) {
			LOGGER.warn("Creating an enumerated type in wordManager:" + wordType);
			WordType wrd = WordType.getTypeByNormalName(normal);
			addWord(wrd);
			return (T) wrd;
		}

		/*------------ The Abstract Types -------------------*/

		if (wordType.isAbstractType()) {
			LOGGER.error("Tried to instantiate an abstract type:" + wordType);
		}

		if (wordType.equals(WordType.NOUN)) {
			return null;
		}

		if (wordType.equals(WordType.CATEGORY)) {
			return null;
		}

		if (wordType.equals(WordType.PREDICATE)) {
			return null;
		}

		if (wordType.equals(WordType.INSTANCE)) {
			return null;
		}

		// Fell through all WordTypes
		return null;
	}

	// should always return 0 or 1 Word
	public Optional<Word> lookupByKeyAndType(IRI key, WordType wordType) {
		return words.stream().filter((w) -> w.getKey().equals(key) && w.getWordType().equals(wordType)).findFirst();
	}

	// returns 0-n words, same key (puns)
	public List<Word> lookupByKey(IRI key) {
		return words.stream().filter((w) -> w.getKey().equals(key)).collect(Collectors.toList());
	}

	// returns 0-n words, same key (puns) doesn't include words of WordType.Word
	private List<Word> lookupByKeyTypedOnly(IRI key) {
		return words.stream().filter((w) -> w.getKey().equals(key) && !w.getWordType().equals(WordType.GENERIC_WORD))
				.collect(Collectors.toList());
	}

	private <T extends Word> List<T> lookupByNormalAndType(String normal, WordType wordType) {

		List<Word> wrds = new ArrayList<Word>();
		if (wordType.equals(WordType.GENERIC_WORD) || wordType == null) {
			wrds = words.stream().filter((w) -> w.getNormalForm().equals(normal)).collect(Collectors.toList());
		} else {
			wrds = words.stream().filter((w) -> w.getNormalForm().equals(normal) && w.getWordType().equals(wordType))
					.collect(Collectors.toList());

		}

		List<T> results = new ArrayList<T>();

		for (Word wrd : wrds) {
			results.add((T) wrd);
		}

		return results;
	}

	public void renormalize() {
		for (Word w : words) {
			normalize(w);
		}
	}

	// load from tab separated file
	// LogicalForm<tab>WordType<tab>NameSpace(IRI)<tab>Description(Opt)
	public void loadFromFile(File vocabFile) {

	}

	public void dumpWordsToFile(File vocabFile) throws IOException {

		String hdr = "Normal Form\tLogical Form\tLabel\tWord Type\tWord Namespace\n";
		FileUtils.writeStringToFile(vocabFile, hdr, false);

		for (Word wrd : words) {
			StringBuilder notes = new StringBuilder();
			notes.append("\t");
			String label = "";
			for (Footnote fn : wrd.getFootnotes()) {
				for (IRI prop : Vocabulary.labelIRIs) {
					if (prop.equals(fn.getPredicate().getKey())) {
						label = fn.getWord().getNormalForm();
					}
				}
				notes.append(fn.toString().replaceAll("\\s+", " "));
				notes.append(",");
			}
			String line = wrd.getNormalForm() + "\t" + wrd.getLogicalForm() + "\t" + label + "\t" + wrd.getWordType()
					+ "\t" + wrd.getNamespace();

			FileUtils.writeStringToFile(vocabFile, line + notes + "\n", true);
		}

	}

	public List<List<Word>> dumpAmbigousWordsToFile(File ambigFile) throws IOException {

		Map<String, List<Word>> wrdMap = words.stream().collect(Collectors.groupingBy(Word::getNormalForm));
		String hdr = "Normal Form\tAmbigous Count\tAmbigous Words\n";
		FileUtils.writeStringToFile(ambigFile, hdr, false);

		List<List<Word>> ambigs = new ArrayList<List<Word>>();
		for (String norm : wrdMap.keySet()) {
			if (wrdMap.get(norm).size() > 1) {
				ambigs.add(wrdMap.get(norm));
				String line = norm + "\t" + wrdMap.get(norm).size() + "\t" + wrdMap.get(norm) + "\n";
				FileUtils.writeStringToFile(ambigFile, line, true);
			}
		}

		return ambigs;
	}

	private void mergeFootnotes(Word to, List<Word> from) {

		Set<Footnote> notes = new HashSet<Footnote>();
		for (Word w : from) {
			notes.addAll(w.getFootnotes());
		}
		notes.addAll(to.getFootnotes());
		to.setFootnotes(new ArrayList<Footnote>(notes));
	}

	private void mergeFootnotes(List<Word> to, Word from) {

		Set<Footnote> notes = new HashSet<Footnote>();
		for (Word w : to) {
			notes.addAll(w.getFootnotes());
		}
		notes.addAll(from.getFootnotes());

		from.setFootnotes(new ArrayList<Footnote>(notes));

		for (Word w : to) {
			w.setFootnotes(new ArrayList<Footnote>(notes));
		}
	}

	private void mergeFootnotes(Word to, Word from) {

		Set<Footnote> notes = new HashSet<Footnote>();
		notes.addAll(from.getFootnotes());
		notes.addAll(to.getFootnotes());
		to.setFootnotes(new ArrayList<Footnote>(notes));
	}

	// convert camel case words to space separated word
	private String decamelize(String surface) {
		return surface.replaceAll("[_\\s]+", " ").replaceAll("([a-z0-9])([A-Z])", "$1 $2").replaceAll("\\s+", " ")
				.trim();
	}

	// convert a sequence of strings to a single string, all proper cased
	private String properCase(String[] words) {

		StringBuilder bldr = new StringBuilder();
		for (String word : words) {
			if (word.isEmpty()) {
				continue;
			}
			if (word.length() == 1) {
				bldr.append(Character.toUpperCase(word.charAt(0)));
			} else {
				bldr.append(Character.toUpperCase(word.charAt(0)) + word.substring(1));
			}

			bldr.append(" ");
		}

		return bldr.toString().replaceFirst("_$", "").trim();
	}

	// create the logical form from the normalized form
	private String logicalize(String normal) {
		return normal.replaceAll("\\s+", "_");
	}

	private void normalize(Word wrd) {

		String norm = normalFromSurface(wrd.getLogicalForm(), wrd.getWordType());
		String label = selectLabel(wrd.getFootnotes());

		if (!label.isEmpty()) {
			norm = normalFromSurface(label, wrd.getWordType());
		}

		wrd.setNormalForm(norm);
	}

	// create the normalized form from the surface, logical or label form
	private String normalFromSurface(String surface, WordType wordType) {

		String norm = decamelize(surface);

		// convert Proper nouns to underbar-delimited Proper Case
		if (WordType.PROPER_NOUN.equals(wordType)) {
			norm = properCase(norm.split(" "));
			return norm.replaceAll(" +", "_");
		}
		if (WordType.ADJECTIVE.equals(wordType)) {
			return norm.replaceAll(" thing$", "");
		}

		// all others underbar-delimited lower case
		return norm.toLowerCase().replaceAll(" +", "_");
	}

	// create a default normal form using only the key
	private String getDefaultNormalForm(IRI key) {
		String shortForm = key.getShortForm();
		String[] pieces = key.toString().split("[/#]|_:");
		String lastBit = pieces[pieces.length - 1];

		if (!shortForm.equals(lastBit)) {
			// LOGGER.warn("Possibly malformed IRI:" + iri + " using " +
			// lastBit);
			shortForm = lastBit;
		}

		return lastBit.toLowerCase().trim().replaceAll("\\s+", "_");
	}

	private String selectLabel(List<Footnote> footnotes) {

		for (Footnote fn : footnotes) {
			// find first label in foot notes
			for (IRI prop : Vocabulary.labelIRIs) {
				if (prop.equals(fn.getPredicate().getKey())) {
					return fn.getWord().getNormalForm();
				}
			}
		}

		return "";
	}

}
