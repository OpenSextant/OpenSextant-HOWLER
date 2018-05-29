package org.opensextant.howler.abstraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.opensextant.howler.abstraction.words.Adjective;
import org.opensextant.howler.abstraction.words.AnnotationPredicate;
import org.opensextant.howler.abstraction.words.BadWord;
import org.opensextant.howler.abstraction.words.CommonNoun;
import org.opensextant.howler.abstraction.words.DataFacetPredicate;
import org.opensextant.howler.abstraction.words.DataPredicate;
import org.opensextant.howler.abstraction.words.DataType;
import org.opensextant.howler.abstraction.words.DataType.DataTypeCategory;
import org.opensextant.howler.abstraction.words.DataValue;
import org.opensextant.howler.abstraction.words.GenericWord;
import org.opensextant.howler.abstraction.words.ObjectPredicate;
import org.opensextant.howler.abstraction.words.Predicate;
import org.opensextant.howler.abstraction.words.ProperNoun;
import org.opensextant.howler.abstraction.words.enumerated.BooleanSetType;
import org.opensextant.howler.abstraction.words.enumerated.DataFacet;
import org.opensextant.howler.abstraction.words.enumerated.Negative;
import org.opensextant.howler.abstraction.words.enumerated.PassiveMarker;
import org.opensextant.howler.abstraction.words.enumerated.PredicateCharacteristic;
import org.opensextant.howler.abstraction.words.enumerated.Quantifier;
import org.opensextant.howler.abstraction.words.enumerated.RelativeMarker;
import org.opensextant.howler.abstraction.words.enumerated.Scope;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WordManager acts a a factory and repository for all words created and used in the abstraction.
 * <p>
 */
@SuppressWarnings("unchecked")
public class WordManager {

  /** The LOGGER. */
  public static final Logger LOGGER = LoggerFactory.getLogger(WordManager.class);

  // List of managed word, unique by key and class
  private Set<Word> words = new HashSet<Word>();

  // List of labels by key
  private Map<IRI, String> labelMap = new HashMap<IRI, String>();

  // map of namespaces to prefix
  private Map<IRI, String> nsPrefixMap = new HashMap<IRI, String>();

  // single instance of WordManager shared by everybody
  private static final WordManager wm = new WordManager();

  public static WordManager getWordManager() {
    return wm;
  }

  private WordManager() {
    // add the fixed Vocabulary to Manager
    for (Word w : Vocabulary.fixedVocabulary) {
      this.addWord(w);
    }
  }

  public void reset() {
    words.clear();
    // add the fixed Vocabulary to Manager
    for (Word w : Vocabulary.fixedVocabulary) {
      this.addWord(w);
    }
  }

  // add and/or merge a new word into the manager
  private void addWord(Word newWord) {

    // existing words with same key
    List<Word> existingWordsByKey = lookupByKey(newWord.getKey());

    // no other words by key, add it
    if (existingWordsByKey.isEmpty()) {
      if (labelMap.containsKey(newWord.getKey())) {
        newWord.setNormalForm(labelMap.get(newWord.getKey()));
      }

      words.add(newWord);
      return;
    }

    // if the Word to be added is a GENERIC_WORD ...
    if (newWord.getWordType().equals(WordType.GENERIC_WORD)) {
      // don't add new generic because we already have Word with same key
      return;
    } else {
      // if adding a non-GENERIC_WORD ...
      // see if there is a GENERIC_WORD with same key
      Optional<Word> existingGenericWord = lookupByKeyAndType(newWord.getKey(), WordType.GENERIC_WORD);
      // if there is an existing GENERIC_WORD
      if (existingGenericWord.isPresent()) {
        // remove GENERIC_WORD
        words.remove(existingGenericWord.get());
      }

      // TODO any further checks for duplicate/ambigous words?
      if (labelMap.containsKey(newWord.getKey())) {
        newWord.setNormalForm(labelMap.get(newWord.getKey()));
      }
      words.add(newWord);
    }
  }

  public void addPrefix(String prefix, IRI namespace) {
    if (prefix != null && !prefix.trim().isEmpty()) {
      if (!nsPrefixMap.containsKey(namespace)) {
        nsPrefixMap.put(namespace, prefix);
      } else {
        String oldPrefix = nsPrefixMap.get(namespace);
        if (!prefix.equals(oldPrefix)) {
          LOGGER.trace(
              "Ignoring attempt to change " + namespace + " namespace prefix from " + oldPrefix + " to " + prefix);
        }
      }
    }
  }

  // used by FromOWL to lookup or create words when only the key is known (i.e. Annotations)
  public <T extends Word> T lookupOrCreateByKey(IRI key, boolean add) {

    // check for existing word with same key
    List<Word> wrds = lookupByKey(key);

    // found something
    if (!wrds.isEmpty()) {
      if (wrds.size() > 1) {
        if (checkLegalPun(wrds)) {
          LOGGER.trace("Ambigous words found by key (pun):" + wrds);
        } else {
          LOGGER.error("Illegal (pun):" + wrds);
        }
      }
      return (T) wrds.get(0);
    }

    // didn't find anything. Create word with key Generic type
    return createByKeyAndType(key, WordType.GENERIC_WORD, add);
  }

  private boolean checkLegalPun(List<Word> wrds) {
    for (int i = 0; i < wrds.size() - 1; i++) {

      for (int j = i + 1; j < wrds.size(); j++) {

        if (wrds.get(i) instanceof Predicate && wrds.get(j) instanceof Predicate) {
          return false;
        }

        if (wrds.get(i).getWordType().equals(WordType.COMMON_NOUN)
            || wrds.get(i).getWordType().equals(WordType.ADJECTIVE)) {
          if (wrds.get(j).getWordType().equals(WordType.DATATYPE)) {
            return false;
          }
        }

        if (wrds.get(i).getWordType().equals(WordType.DATATYPE)) {
          if (wrds.get(j).getWordType().equals(WordType.COMMON_NOUN)
              || wrds.get(j).getWordType().equals(WordType.ADJECTIVE)) {
            return false;
          }
        }
      }

    }
    return true;
  }

  // used by FromOWL to find and create Words
  public <T extends Word> T lookupOrCreateByKeyAndType(IRI key, WordType wordType, boolean add) {

    // check for existing word with same key and word type
    Optional<Word> wrd = lookupByKeyAndType(key, wordType);

    // found something
    if (wrd.isPresent()) {
      return (T) wrd.get();
    }

    // didn't find anything. Create word with key and type
    return createByKeyAndType(key, wordType, add);
  }

  // used by FromText to find and create Words
  public <T extends Word> List<T> lookupOrCreateByNormalForm(String normal, WordType wordType, IRI ns, boolean add) {

    List<T> wrds = lookupByNormalAndType(normal, wordType);

    if (!wrds.isEmpty()) {
      return wrds;
    }

    String logical = TextUtils.createLogicalFromNormal(normal);
    IRI key = IRI.create(ns.toString() + "#", logical);
    /*
     * if (wordType.equals(WordType.ADJECTIVE)) { key = IRI.create(ns.toString() + "#", logical + "_thing"); }
     */
    List<T> newWrds = new ArrayList<T>();
    newWrds.add(createByNormalKeyAndType(normal, key, wordType, add));
    return newWrds;
  }

  private <T extends Word> T createByKeyAndType(IRI key, WordType wordType, boolean add) {
    String normal = TextUtils.getLocalName(key).trim().replaceAll("_+", " ");

    if (normal.isEmpty() || TextUtils.looksLikeFilePath(key)) {
      // looks like a namespace only
      LOGGER.trace("Word looks like namespace/URL:" + key);
      normal = key.toString();
    }

    return createByNormalKeyAndType(normal, key, wordType, add);
  }

  private <T extends Word> T createByNormalKeyAndType(String normal, IRI key, WordType wordType, boolean add) {

    boolean passiveForm = normal.endsWith("by");

    String pref = lookupPrefix(key);

    if (wordType.equals(WordType.ADJECTIVE)) {
      Adjective wrd = new Adjective(normal, key);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.ANNOTATION_PREDICATE)) {
      AnnotationPredicate wrd = new AnnotationPredicate(normal, key);
      wrd.setPassiveForm(passiveForm);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.BADWORD)) {
      BadWord wrd = new BadWord(normal, Vocabulary.getBuiltInKey(normal));
      wrd.setPrefix(pref);
      // if(add){addWord(wrd);}
      return (T) wrd;
    }

    if (wordType.equals(WordType.COMMON_NOUN)) {
      CommonNoun wrd = new CommonNoun(normal, key);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.DATA_PREDICATE)) {
      DataPredicate wrd = new DataPredicate(normal, key);
      wrd.setPassiveForm(passiveForm);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.DATA_FACET_PREDICATE)) {
      DataFacet fc = DataFacet.getTypeByNormalName(normal);
      DataFacetPredicate wrd = new DataFacetPredicate(fc);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.DATATYPE)) {
      DataType wrd = new DataType(normal, key, DataTypeCategory.OTHER);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.DATAVALUE)) {
      DataValue wrd = new DataValue(normal);
      wrd.setPrefix(pref);
      if (add) {
        LOGGER.error("Word Manager does not manage data values:" + wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.GENERIC_WORD)) {
      GenericWord wrd = new GenericWord(normal, key);
      wrd.setPrefix(pref);
      if (add) {
        // LOGGER.warn("Creating a GENERIC_WORD in word manager:" + normal + " (" + key + ")");
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.PREDICATE)) {
      ObjectPredicate wrd = new ObjectPredicate(normal, key);
      wrd.setPassiveForm(passiveForm);
      wrd.setPrefix(pref);
      if (add) {
        LOGGER.warn("Tried to create a generic Predicate in WordManager. Forcing to be Object Predicate:" + normal + "("
            + key + ")");
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.OBJECT_PREDICATE)) {
      ObjectPredicate wrd = new ObjectPredicate(normal, key);
      wrd.setPassiveForm(passiveForm);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    if (wordType.equals(WordType.PROPER_NOUN)) {
      ProperNoun wrd = new ProperNoun(normal, key);
      wrd.setPrefix(pref);
      if (add) {
        addWord(wrd);
      }
      return (T) wrd;
    }

    /*------------ The Abstract Types -------------------*/

    if (wordType.isAbstractType()) {
      LOGGER.error("Tried to instantiate an abstract type:" + wordType);
      return null;

    }
    // Fell through all WordTypes
    LOGGER.error("Fell through all wordtypes:" + normal + " (" + wordType + ")");
    return null;
  }

  private String lookupPrefix(IRI key) {
    IRI ns = TextUtils.getNamespace(key);

    if (this.nsPrefixMap.containsKey(ns)) {
      String pref = nsPrefixMap.get(ns);
      return pref;
    } else {
      // LOGGER.warn("No prefix for namespace:" + ns);
    }

    return "";
  }

  // should always return 0 or 1 Word
  private Optional<Word> lookupByKeyAndType(IRI key, WordType wordType) {
    // A word is uniquely identified by its key and WordType, so only 0 or 1
    return words.stream().filter((w) -> w.getKey().equals(key) && w.getWordType().equals(wordType)).findFirst();
  }

  // returns 0-n words, same key (puns)
  private List<Word> lookupByKey(IRI key) {
    return words.stream().filter((w) -> w.getKey().equals(key)).collect(Collectors.toList());
  }

  // There may be 0-n Words with the same normal form and WordType
  private <T extends Word> List<T> lookupByNormalAndType(String normal, WordType wordType) {

    List<T> results = new ArrayList<T>();

    if (wordType != null && wordType.isEnumerated()) {
      Word wrd = lookupByNormalEnumeratedAndType(normal, wordType);
      results.add((T) wrd);
      return results;
    }

    List<Word> wrds = new ArrayList<Word>();
    if (wordType.equals(WordType.GENERIC_WORD) || wordType == null) {
      wrds = words.stream().filter((w) -> w.getNormalForm().equalsIgnoreCase(normal)).collect(Collectors.toList());
    } else if (wordType.equals(WordType.PREDICATE)) {
      // look for any type of predicate
      wrds = words.stream()
          .filter((w) -> w.getNormalForm().equalsIgnoreCase(normal)
              && (w.getWordType().equals(WordType.OBJECT_PREDICATE) || w.getWordType().equals(WordType.DATA_PREDICATE)
                  || w.getWordType().equals(WordType.ANNOTATION_PREDICATE)))
          .collect(Collectors.toList());
    } else {
      wrds = words.stream()
          .filter((w) -> w.getNormalForm().equalsIgnoreCase(normal) && w.getWordType().equals(wordType))
          .collect(Collectors.toList());
    }

    for (Word wrd : wrds) {
      results.add((T) wrd);
    }

    return results;
  }

  private <T extends Word> T lookupByNormalEnumeratedAndType(String normal, WordType wordType) {

    if (wordType.equals(WordType.NEGATIVE)) {
      Negative wrd = Negative.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.BOOLEAN_SET_TYPE)) {
      BooleanSetType wrd = BooleanSetType.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.DATA_FACET)) {
      DataFacet wrd = DataFacet.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.PREDICATE_CHARACTERISTIC)) {
      PredicateCharacteristic wrd = PredicateCharacteristic.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.QUANTIFIER)) {
      Quantifier wrd = Quantifier.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.THAT)) {
      RelativeMarker wrd = RelativeMarker.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.SCOPE)) {
      Scope wrd = Scope.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.BY)) {
      PassiveMarker wrd = PassiveMarker.getTypeByNormalName(normal);
      return (T) wrd;
    }

    if (wordType.equals(WordType.WORD_TYPE)) {
      WordType wrd = WordType.getTypeByNormalName(normal);
      return (T) wrd;
    }

    return null;
  }

  // return a copy of the known words
  public Set<Word> getWords() {
    Set<Word> wrds = new HashSet<Word>();
    wrds.addAll(words);

    // add the enumerated types
    for (WordType wordType : WordType.values()) {

      if (wordType.equals(WordType.NEGATIVE)) {
        wrds.addAll(Arrays.asList(Negative.values()));
      }

      if (wordType.equals(WordType.BOOLEAN_SET_TYPE)) {
        wrds.addAll(Arrays.asList(BooleanSetType.values()));
      }

      if (wordType.equals(WordType.DATA_FACET)) {
        wrds.addAll(Arrays.asList(DataFacet.values()));
      }

      if (wordType.equals(WordType.PREDICATE_CHARACTERISTIC)) {
        wrds.addAll(Arrays.asList(PredicateCharacteristic.values()));
      }

      if (wordType.equals(WordType.QUANTIFIER)) {
        wrds.addAll(Arrays.asList(Quantifier.values()));
      }

      if (wordType.equals(WordType.THAT)) {
        wrds.addAll(Arrays.asList(RelativeMarker.values()));
      }

      // Don't include SCOPE

      if (wordType.equals(WordType.BY)) {
        wrds.addAll(Arrays.asList(PassiveMarker.values()));
      }

      if (wordType.equals(WordType.WORD_TYPE)) {
        // only add wordtypes which are not enumerated and not abstract
        for (WordType wt : WordType.values()) {
          if (!wt.isEnumerated() && !wt.isAbstractType()) {
            wrds.add(wt);
          }
        }
      }
    }

    return wrds;
  }

  public void addLabelAnnotation(Word w, AnnotationPredicate pred, Word v) {

    IRI wordKey = w.getKey();
    IRI predKey = pred.getKey();

    // is it one of the label predicates?
    if (Vocabulary.labelIRIs.contains(predKey)) {
      // is it a String?
      if (v instanceof DataValue) {
        DataValue valueWord = (DataValue) v;
        if (valueWord.getLanguage().equals("en") || valueWord.getLanguage().isEmpty()) {
          String label = cleanLabel(valueWord.getNormalForm());
          this.labelMap.put(wordKey, label);
          // check for existing words with this key
          for (Word l : this.lookupByKey(wordKey)) {
            l.setNormalForm(label);
          }
        } else {
          LOGGER.trace("Non-English label. Ignoring:" + valueWord);
        }
      }
    }
  }

  // TODO any other cleaning for label?
  private String cleanLabel(String raw) {
    return raw.replaceAll("[\"'\\(\\)\\,]", "").replaceAll("\\s+", " ");
  }

  // load from tab separated file
  // same structure as produced by dumpWordsToFile
  private void loadFromFile(File vocabFile) {

  }

  public void dumpWordsToFile(File vocabFile) throws IOException {

    String hdr = "Prefix\tNormal Form\tLogical Form\tLabel\tWord Type\tWord Namespace\n";
    FileUtils.writeStringToFile(vocabFile, hdr, "UTF-8", false);
    for (Word wrd : words) {
      String label = "";
      if (labelMap.containsKey(wrd.getKey())) {
        label = labelMap.get(wrd.getKey());
      }

      String line = wrd.getPrefix() + "\t" + wrd.getNormalForm() + "\t" + wrd.getLogicalForm() + "\t" + label + "\t"
          + wrd.getWordType() + "\t" + wrd.getNamespace() + "\n";

      FileUtils.writeStringToFile(vocabFile, line, "UTF-8", true);
    }

  }

  public List<List<Word>> dumpAmbigousWordsToFile(File ambigFile) throws IOException {

    Map<String, List<Word>> wrdMap = words.stream().collect(Collectors.groupingBy(Word::getNormalForm));
    String hdr = "Normal Form\tAmbigous Count\tAmbigous Words\n";
    FileUtils.writeStringToFile(ambigFile, hdr, "UTF-8", false);

    List<List<Word>> ambigs = new ArrayList<List<Word>>();
    for (String norm : wrdMap.keySet()) {
      if (wrdMap.get(norm).size() > 1) {
        ambigs.add(wrdMap.get(norm));
        String line = norm + "\t" + wrdMap.get(norm).size() + "\t" + wrdMap.get(norm) + "\n";
        FileUtils.writeStringToFile(ambigFile, line, "UTF-8", true);
      }
    }

    return ambigs;
  }

}
