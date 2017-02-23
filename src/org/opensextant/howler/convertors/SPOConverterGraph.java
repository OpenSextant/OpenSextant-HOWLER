package org.opensextant.howler.convertors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Transaction;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.opensextant.howler.spo.Document;
import org.opensextant.howler.spo.ObjectPhrase;
import org.opensextant.howler.spo.Phrase;
import org.opensextant.howler.spo.Phrase.PhraseType;
import org.opensextant.howler.spo.PhraseSet;
import org.opensextant.howler.spo.Predicate;
import org.opensextant.howler.spo.PredicatePhrase;
import org.opensextant.howler.spo.SubjectPredicateObject;
import org.opensextant.howler.spo.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPOConverterGraph {

  /** The LOGGER. */
  private static final Logger LOGGER = LoggerFactory
      .getLogger(SPOConverterGraph.class);

  // labels used for relation between phrases which mention the same word
  static String MENTIONLABEL = "mentions";
  static String MENTIONBYLABEL = "mentioned by";
  // label used for Keyword nodes
  static String KEYWORDLABEL = "Keyword";

  // the TinkerPop graph to be populated
  Graph graph;

  // map for phrases to be merged to a single vertex
  private Map<String, Vertex> phraseVertexMap = new HashMap<String, Vertex>();

  // map between a word and the vertices in which it is mentioned
  private Map<String, Set<Vertex>> mentionMap = new HashMap<String, Set<Vertex>>();

  // re-using the SPO/Phrase to english converter to create node labels
  SPOConverterText textConverter;

  public SPOConverterGraph(Graph graph) {
    this.graph = graph;
    textConverter = new SPOConverterText();
  }

  // convert document and add to graph
  public void addDocument(Document doc) {

    List<SubjectPredicateObject> spos = doc.getSentences();

    try (Transaction transaction = graph.tx()) {
      for (SubjectPredicateObject spo : spos) {
        this.AddSPO(spo);
      }
      // commit transaction
      transaction.commit();
    }

  }

  // convert a single SPO and add to graph
  // NOTE: this must be wrapped in a transaction
  public void AddSPO(SubjectPredicateObject spo) {

    // get subject and objects
    ObjectPhrase subjPhrase = spo.getSubject();
    PhraseSet objPhrases = spo.getObjects();

    // get text for whole sentence via text converter
    String sent = textConverter.convertSPOtoText(spo);

    // create the vertex which represents the subject
    Vertex subjVert = this.createVertexFromPhrase(subjPhrase, false);

    // create vertices for each object and link to subject vertex via predicate
    for (Phrase ph : objPhrases.getPhrases()) {

      // all object phrases whould be type PREDICATEPHRASE
      if (ph.getPhraseType() == PhraseType.PREDICATEPHRASE) {

        // get predicate and convert to text for link label
        PredicatePhrase predPhrase = (PredicatePhrase) ph;
        String predString = this.stringFromPredicate(predPhrase.getPredicate());

        // get object and convert to vertex
        ObjectPhrase objectPhrase = predPhrase.getObject();
        Vertex objVert = this.createVertexFromPhrase(objectPhrase, true);

        // create link if not already there
        if (!this.alreadyThere(subjVert, objVert, predString)) {
          subjVert.addEdge(predString, objVert, "sentence", sent);
        } else {
          // TODO add an increment to relation count property
           LOGGER.info("Already a link: " + subjPhrase + " " + predString + " " + objectPhrase);
        }
      } else {
        LOGGER.error(
            "Skipping non-predicate phrase found as predicate when converting to graph"
                + ph);
      }
    }

  }

  /*
   * // add links between all phrases which mention the same word public void
   * addMentions_N2() {
   * 
   * // mentions are added in their own transaction try (Transaction transaction
   * = graph.tx()) {
   * 
   * // link amongst all vertices which share a mention for (String key :
   * this.mentionMap.keySet()) {
   * 
   * // convert to list so we can increment through ArrayList<Vertex> mentions =
   * new ArrayList<Vertex>( this.mentionMap.get(key));
   * 
   * // add mention link between each vertex for (int i = 0; i <
   * mentions.size(); i++) { for (int j = i + 1; j < mentions.size(); j++) {
   * 
   * Vertex v1 = mentions.get(i); Vertex v2 = mentions.get(j);
   * 
   * // don't add if already there if (!this.alreadyThere(v1, v2, MENTIONLABEL))
   * { // add mention link v1.addEdge(MENTIONLABEL, v2, "word", key); }
   * 
   * } } }
   * 
   * // commit transaction transaction.commit(); }
   * 
   * }
   */

  // add links between a keyword node and phrases which mention that word
  public void addMentions_Keys() {

    // mentions are added in their own transaction
    try (Transaction transaction = graph.tx()) {

      // link all mentions to keyword node
      for (String key : this.mentionMap.keySet()) {

        // get all the mentions for this keyword
        Set<Vertex> mentions = this.mentionMap.get(key);

        LOGGER.info("MentionCount\t" + key +"\t" +  mentions.size() );
        
        // only add key if more than 1 uses
        if (mentions.size() > 1) {
          // create keyword node
          Vertex keyVert = graph.addVertex(T.label, KEYWORDLABEL, "text", key);
          // link to all uses of keyword
          for (Vertex m : mentions) {
            m.addEdge(MENTIONLABEL, keyVert, "word", key);
            // keyVert.addEdge(MENTIONBYLABEL, m, "word", key);
          }
        }
      }

      // commit transaction
      transaction.commit();
    }

  }

  // create a vertex from a phrase or return existing vertex
  private Vertex createVertexFromPhrase(Phrase phrase, boolean isObject) {

    // get key to identify phrase. All phrases with the same key are linked to
    // the same vertex
    // Empty if phrases are not be linked
    String phraseKey = this.keyFromPhrase(phrase, isObject);

    // return vertex if it already exists
    if (phraseVertexMap.containsKey(phraseKey)) {
      return phraseVertexMap.get(phraseKey);
    }

    // get the attributes for the vertex
    String text = this.stringFromPhrase(phrase, isObject);
    String label = phrase.getPhraseType().name();


    // create vertex
    Vertex v = graph.addVertex(T.label, label, "text", text);

    // if there is a phrase key, associate vertex with key
    if (!phraseKey.isEmpty()) {
      phraseVertexMap.put(phraseKey, v);
    }

    // get the words which might be keyword mentions
    collectMentions(v, phrase);

    return v;

  }

  // create the index key for a phrase
  private String keyFromPhrase(Phrase phrase, boolean isObject) {

    StringBuilder bldr = new StringBuilder();

    // create key by concatenating words
    for (Word w : this.textConverter.convert(phrase, isObject)) {
      if(w.getPhraseType().equals(PhraseType.PROPER) || w.getPhraseType().equals(PhraseType.NOUN)|| w.getPhraseType().equals(PhraseType.ADJECTIVE)  ){
        bldr.append(w.getLogicalForm());
        bldr.append(" ");
      }
    }
    String key = bldr.toString().trim();

    return key;
  }

  // create the label for a node from a phrase
  private String stringFromPhrase(Phrase ph, boolean isObject) {

    StringBuilder bldr = new StringBuilder();
    // use Howler phrase to text converter
    for (Word w : this.textConverter.convert(ph, isObject)) {
      // concat space separated surface forms
      bldr.append(w.getSurfaceForm());
      bldr.append(" ");
    }

    return bldr.toString().replaceAll("_", " ").trim();
  }

  // create a label for a link from a predicate
  private String stringFromPredicate(Predicate pred) {

    StringBuilder bldr = new StringBuilder();

    // use Howler predicate to text converter
    for (Word w : textConverter.convertPredicate(pred)) {
      // concat space separated surface forms
      bldr.append(w.getSurfaceForm());
      bldr.append(" ");
    }

    return bldr.toString().trim();
  }

  // collect all of the words mentioned in a phrase and vertex which uses them
  private void collectMentions(Vertex v, Phrase phrase) {

    // convert phrase to list of words
    List<Word> wrds = this.textConverter.convert(phrase, false);

    // for each word
    for (Word w : wrds) {
      // only mentions between nouns (common or proper)
      if (!w.getVocabulary().equals(SPOConverterText.FIXED_NAMESPACE)) {

        String wordForm = w.getLogicalForm().replaceAll("_", " ");
        
        if(w.getPhraseType().equals(PhraseType.PROPER)){
           wordForm = w.getSurfaceForm().replaceAll("_", " ");
        }
        

        // add to mention map if not already there
        if (!this.mentionMap.containsKey(wordForm)) {
          this.mentionMap.put(wordForm, new HashSet<Vertex>());
        }

        // add vertex which mentions surface form
        this.mentionMap.get(wordForm).add(v);
      }
    }
  }

  // see if an edge already exists from v1 to v2 of type label
  private boolean alreadyThere(Vertex v1, Vertex v2, String label) {

    Iterator<Edge> edgeIter = v1.edges(Direction.OUT, label);

    while (edgeIter.hasNext()) {
      if (edgeIter.next().inVertex().equals(v2)) {
        return true;
      }
    }

    return false;
  }

}
