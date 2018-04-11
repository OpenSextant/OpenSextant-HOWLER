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
package org.opensextant.howler.kanban;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.opensextant.howler.Howler;
import org.opensextant.howler.abstraction.Document;
import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.enumerated.WordType;
import org.opensextant.howler.kanban.elements.Board;
import org.opensextant.howler.kanban.elements.Card;
import org.opensextant.howler.kanban.elements.CardList;
import org.opensextant.howler.kanban.elements.RawText;
import org.opensextant.howler.kanban.elements.Sentence;
import org.opensextant.howler.text.TextDocument;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDisjointClassesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;
import org.semanticweb.owlapi.util.OWLAPIStreamUtils;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.EmailAuth;

/*
 * The Kanban class represents the state of the Wekan Kanban system:
 * the boards, lists,cards,sentences and rawtext.
 * It also manages the actions that are triggered by additions (and changes eventually)
 * to the Kanban system e.g. create sentences base on rawtext, create any cards needed ...
 * 
 */

@SuppressWarnings("unchecked")
public class Kanban {

  // the primary kanban elements indexed by their IDs
  Map<String, Board> boards = new HashMap<String, Board>();
  Map<String, CardList> lists = new HashMap<String, CardList>();
  Map<String, Card> cards = new HashMap<String, Card>();
  Map<String, Sentence> sentences = new HashMap<String, Sentence>();
  Map<String, RawText> rawTexts = new HashMap<String, RawText>();

  // sentences indexed by their content and board to avoid duplicates
  Map<String, Sentence> sentencesByText = new HashMap<String, Sentence>();

  // cards index by the keys which links them to sentences
  // used to determine if card already exists
  Map<String, Card> cardsByKey = new HashMap<String, Card>();

  // mapping between board ontology (indexed by the board's ID)
  Map<String, OWLOntology> ontologiesByBoardID = new HashMap<String, OWLOntology>();

  // the elements that do the English <-> OWL conversions
  Howler howler;

  // the client which talks to the Wekan system
  private DDPClient client;

  // the elements that create/manage the ontologies
  OWLDataFactory owlFactory;
  OWLOntologyManager mgr;
  ReasonerFactory reasonerFactory = new ReasonerFactory();

  // used to convert from Java to JSON
  Gson gson = new Gson();

  private boolean synched = false;
  private OWLOntology baseOnto;
  private Syncher syncher;
  private String user;
  private String pass;

  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Kanban.class);

  public Kanban(Howler howler, String configPath) {

    // the Howler, which does all the work
    this.howler = howler;

    // initialize the ontology manager and factory
    mgr = OWLManager.createOWLOntologyManager();
    owlFactory = mgr.getOWLDataFactory();
    try {
      File propFile = new File(configPath);

      // load properties file
      Properties props = new Properties();

      props.load(new FileInputStream(propFile));

      // get the base ontology which is to be preloaded into each board/ontology
      String baseOntoPath = props.getProperty("os.howler.kanban.baseOntology");

      // paths are relative to config file
      File baseDir = new File(configPath).getParentFile();

      baseOnto = mgr.loadOntologyFromOntologyDocument(new File(baseDir, baseOntoPath));

      String host = props.getProperty("os.howler.kanban.host");
      Integer port = Integer.parseInt(props.getProperty("os.howler.kanban.port"));

      this.client = new DDPClient(host, port);

      this.syncher = new Syncher(this);
      this.client.addObserver(syncher);

      this.user = props.getProperty("os.howler.kanban.user");
      this.pass = props.getProperty("os.howler.kanban.password");

    } catch (OWLOntologyCreationException | IOException | URISyntaxException e) {
      LOGGER.error("Couldn't load base ontology from " + configPath + ". " + e.getMessage());
    }

  }

  public void addBoard(Board board) {
    this.boards.put(board.getId(), board);
    LOGGER.info("Added Board:" + board.getTitle());

    // create a ontology for each board
    this.addOntology(board);

    this.loadOntology(board);

    // if already done initial synch then this is a new board
    if (this.synched) {
      this.prepBoards();
    }

  }

  public Board getBoard(String id) {
    return this.boards.get(id);
  }

  public void addList(CardList list) {
    this.lists.put(list.getId(), list);
    // add the list to the board it is part of
    this.boards.get(list.getBoardId()).addList(list);
    LOGGER.info("Added List:" + list.getTitle());
  }

  public CardList getList(String id) {
    return this.lists.get(id);
  }

  public void addCard(Card card) {
    this.cards.put(card.get_id(), card);
    // add the card to the board it is part of
    boards.get(card.getBoardId()).addCard(card);
    this.cardsByKey.put(card.getKey(), card);
    // add the card to the list it is part of
    lists.get(card.getListId()).addCard(card);
    LOGGER.info("Added Card:" + card.getTitle());
  }

  public Card getCard(String id) {
    return this.cards.get(id);
  }

  public Card getCardByKey(String key) {
    return this.cardsByKey.get(key);
  }

  public Sentence getSentence(String id) {
    return sentences.get(id);
  }

  public void addSentence(Sentence sentence) {

    this.sentences.put(sentence.get_id(), sentence);

    LOGGER.info("Added Sentence:" + sentence.getText());
    // create any cards needed to match words used in sentence
    this.addCards(sentence);
    // create axiom(s) that corresponds to sentence and add to ontology
    this.addAxioms(sentence);

  }

  public RawText getRawText(String id) {
    return rawTexts.get(id);
  }

  public void addRawText(RawText rawText) {

    this.rawTexts.put(rawText.get_id(), rawText);
    LOGGER.info("Added RawText:" + rawText.getText());

    // create sentences from the input text
    List<Sentence> sents = this.createSentences(rawText);

    // send the sentences to the Wekan system
    this.sendSentences(sents, false);

    // remove the rawtext
    client.collectionDelete("rawtext", rawText.get_id());

  }

  public boolean isSynched() {
    return synched;
  }

  public void setSynched(boolean synched) {
    this.synched = synched;
    if (synched) {
      this.prepBoards();
    }

  }

  // make sure start up conditions are set following synch
  private void prepBoards() {

    if (synched) {

      for (Board b : boards.values()) {

        // make sure all boards have at least one list
        if (b.getLists().isEmpty()) {
          // add default list

          CardList list = new CardList();
          list.setBoardId(b.getId());
          list.setTitle("New Stuff");

          // create field map and send to Wekan
          String json = gson.toJson(list);
          Map<String, Object> fields = gson.fromJson(json, Map.class);
          fields.remove("cards");

          int id = client.collectionInsert("lists", fields);
          LOGGER.info("Inserting new default List. ID=" + id + ". " + list.getTitle());

        }

        // TODO make sure labels are set for each board

      }

    } else {
      LOGGER.error("Tried to do prep when not synched");
    }

  }

  // create Sentences from the input text
  public List<Sentence> createSentences(RawText raw) {

    List<Sentence> sentences = new ArrayList<Sentence>();

    String text = raw.getText();
    String boardId = raw.getBoardId();
    boolean inferred = raw.isInferred();

    // roundtrip: input text to Document, to ontology, to Document
    Document doc = howler.convertText("dummy", text);

    // continue round trip: Document to ontology back to Document
    OWLOntology onto = howler.toOntology(doc, true);
    doc = howler.convertOntology(onto);

    // loop over each of the SPOs created from the input text
    for (Statement spo : doc.getStatements()) {

      // all the words used in the SPO
      // Set<Word> words = spo.getWords();

      // TODO
      // create and populate a Sentence
      Sentence sent = new Sentence();
      // sent.setWords(words);
      sent.setBoardId(boardId);
      // a sentence is inferred if the raw text was inferred
      sent.setInferred(inferred);

      // create the keys based on the words in the sentence
      // key is of the form: logicalform|wordtype|boardID
      /*
       * for (Word w : words) { if (w instanceof Thing || w instanceof Nothing || w instanceof DataValue || w instanceof
       * AuxiliaryWord || w instanceof BadWord) { continue; } String tmpKey = w.getLogicalForm() + "|" + w.getWordType()
       * + "|" + boardId; sent.addKey(tmpKey); }
       */
      // get the clean text from the SPO
      Sentence cleanText = howler.toText(spo);
      // sent.setText(cleanText);
      sentences.add(sent);

    }

    return sentences;
  }

  // send the sentences to the Wekan Kanban system
  public void sendSentences(List<Sentence> sentences, boolean update) {

    for (Sentence sent : sentences) {

      if (sent.isParseable()) {
        String textKey = sent.textKey();

        // look for duplicate sentence (same text key)
        if (!this.sentencesByText.containsKey(textKey)) {
          this.sentencesByText.put(textKey, sent);

          // null out the quantifiers and relative clauses since not needed
          // TODO Needed?
          for (Word w : sent.getWords()) {
            // w.setRelativePhrases(null);
            // w.setQuantifier(null);
          }

          // convert to field map
          String json = gson.toJson(sent);
          Map<String, Object> fields = gson.fromJson(json, Map.class);

          // send as update or insert
          if (update) {
            int id = client.collectionUpdate("sentences", sent.get_id(), fields);
            LOGGER.info("Updating sentence. ID=" + id + ". " + sent.getText());
          } else {
            int id = client.collectionInsert("sentences", fields);
            LOGGER.info("Inserting sentence. ID=" + id + ". " + sent.getText());
          }

        } else {
          LOGGER.info("Duplicate Sentence. Not sent:" + sent.getText());
        }
      } else {
        LOGGER.info("Unparseable Sentence. Not sent:" + sent.getText());
      }
    }
  }

  // create any new cards needed to represent words used in the sentence
  public void addCards(Sentence sent) {

    String userID = sent.getUserId();
    String boardID = sent.getBoardId();

    for (String key : sent.getKeys()) {

      // seen key before?
      if (!this.cardsByKey.keySet().contains(key)) {

        // keys look like:logicalForm|WordType|boardID
        String[] pieces = key.split("\\|");

        // title is the words logical form with part of speech following
        String title = pieces[0].replaceAll("_", " ") + " (" + pieces[1].toLowerCase() + ")";

        // create and populate new card
        Card card = new Card();

        card.setTitle(title);
        card.setKey(key);
        card.setEntityType(WordType.valueOf(pieces[1]));
        card.setBoardId(boardID);
        // TODO list selected is first list in board. Better choice?
        card.setListId(boards.get(boardID).getLists().get(0).getId());
        card.setUserid(userID);

        // create field map and send to Wekan
        String json = gson.toJson(card);
        Map<String, Object> fields = gson.fromJson(json, Map.class);

        int id = client.collectionInsert("cards", fields);
        LOGGER.info("Inserting new Card. ID=" + id + ". " + card.getTitle());

        this.cardsByKey.put(key, card);
      }

    }
  }

  // create a new blank ontology for a board
  public void addOntology(Board board) {

    try {

      // better way to create ontology IRI?
      IRI iri = IRI.create(board.getTitle());

      // create ontology and place in ontologies map by boardID
      OWLOntology onto = mgr.createOntology(iri);

      ontologiesByBoardID.put(board.getId(), onto);

      LOGGER.info("Added new ontology " + iri);

    } catch (OWLOntologyCreationException e) {
      LOGGER.error("Unable to create ontology for board:" + board.getTitle() + ":" + e.getMessage());
    }

  }

  // load an ontology into an existing board
  public void loadOntology(Board board) {
    OWLOntology currentOnto = ontologiesByBoardID.get(board.getId());

    if (this.baseOnto != null) {
      currentOnto.addAxioms(OWLAPIStreamUtils.asList(this.baseOnto.axioms()));
    }

  }

  // create a axiom(s) from a sentence and add to appropriate ontology
  public void addAxioms(Sentence sent) {

    // don't add results from inferred sentence (already there)
    if (!sent.isInferred()) {

      // get the asserted ontology that corresponds to this board
      OWLOntology onto = ontologiesByBoardID.get(sent.getBoardId());

      // convert the new sentence to Document
      Document doc = howler.convertText("dummy", sent.getText());

      // convert each SPO in Document to owl axiom
      for (Statement spo : doc.getStatements()) {

        List<OWLAxiom> axioms = howler.toAxiom(spo);

        // add to ontology
        onto.add(axioms);

        LOGGER.info("Added new axiom " + sent.getText() + "->" + axioms.toString());

      }

      // added all the axioms now get any resulting inferrences

      // run inference on ontology
      OWLReasoner reasoner = reasonerFactory.createReasoner(onto);

      if (!reasoner.isConsistent()) {
        LOGGER.error("Ontology is inconsistent");
      } else {
        Set<OWLClass> unsats = reasoner.getUnsatisfiableClasses().getEntitiesMinusBottom();
        if (!unsats.isEmpty()) {
          LOGGER.error("Ontology contains " + unsats.size() + " unsatisfiable classes: " + unsats);
          // TODO mark cards corresponding to this class as broken

        } else {

          // all of the possible types of inferences
          List<InferredAxiomGenerator<? extends OWLAxiom>> gens = new ArrayList<>();
          gens.add(new InferredSubClassAxiomGenerator());
          gens.add(new InferredClassAssertionAxiomGenerator());
          // gens.add(new InferredDataPropertyCharacteristicAxiomGenerator());
          gens.add(new InferredDisjointClassesAxiomGenerator());
          gens.add(new InferredEquivalentClassAxiomGenerator());
          // gens.add(new InferredEquivalentDataPropertiesAxiomGenerator());
          // gens.add(new InferredEquivalentObjectPropertyAxiomGenerator());
          // gens.add(new InferredInverseObjectPropertiesAxiomGenerator());
          // gens.add(new InferredObjectPropertyCharacteristicAxiomGenerator());
          gens.add(new InferredPropertyAssertionGenerator());
          // gens.add(new InferredSubDataPropertyAxiomGenerator());
          // gens.add(new InferredSubObjectPropertyAxiomGenerator());

          InferredOntologyGenerator inferGenerator = new InferredOntologyGenerator(reasoner, gens);

          try {

            // create a temporary ontology to hold the inferences
            OWLOntology inferred = mgr.createOntology();

            // populate new ontology with just the inferred axioms
            inferGenerator.fillOntology(owlFactory, inferred);

            LOGGER.info("Inferred " + inferred.getAxiomCount() + " axioms");

            // create a sentence from each inferred axiom

            for (OWLAxiom ax : OWLAPIStreamUtils.asList(inferred.axioms())) {

              // don't include "XX is a Thing" axioms
              if (!this.isThingAxiom(ax)) {
                this.sendAxiom(ax, sent.getBoardId(), sent.getUserId());
              }
            }
          } catch (OWLOntologyCreationException e) {
            LOGGER.error("Error when trying to create ontology for inference:" + e.getMessage());
          }
        }
      }
    }

  }

  private void sendAxiom(OWLAxiom ax, String boardId, String userID) {

    Document inferDoc = howler.convertAxiom(ax, "dummy");

    TextDocument inferences = howler.toText(inferDoc);

    // add each inference as raw text
    for (org.opensextant.howler.text.Sentence inf : inferences.getSentences()) {

      RawText raw = new RawText();
      raw.setText(inf.getContents());
      raw.setBoardId(boardId);
      raw.setUserId(userID);
      raw.setInferred(true);

      // create field map and send to Wekan
      String json = gson.toJson(raw);
      Map<String, Object> fields = gson.fromJson(json, Map.class);

      LOGGER.info("Adding inferred text: " + inf);
      client.collectionInsert("rawtext", fields);
    }
  }

  //
  // is axiom of the form X is a thing ?
  private boolean isThingAxiom(OWLAxiom ax) {

    if (ax.getAxiomType() == AxiomType.SUBCLASS_OF) {
      OWLSubClassOfAxiom sub = (OWLSubClassOfAxiom) ax;
      if (sub.getSuperClass().isTopEntity()) {
        LOGGER.debug("Rejecting axiom: " + ax);
        return true;
      } else {
        LOGGER.debug("Accepting axiom: " + ax);
        return false;
      }
    }

    if (ax.getAxiomType() == AxiomType.CLASS_ASSERTION) {
      OWLClassAssertionAxiom ca = (OWLClassAssertionAxiom) ax;

      if (ca.getClassExpression().isTopEntity()) {
        LOGGER.debug("Rejecting axiom: " + ax);
        return true;
      } else {
        LOGGER.debug("Accepting axiom: " + ax);
        return false;
      }
    }

    return false;

  }

  public void start() {
    // and connect
    this.client.connect();

    try {
      // wait for connection
      while (!syncher.isConnected()) {
        System.out.println("Waiting on connection");
        Thread.sleep(500);
      }

      // login
      Object[] methodArgs = new Object[1];
      EmailAuth emailpass = new EmailAuth(user, pass);
      methodArgs[0] = emailpass;
      this.client.call("login", methodArgs, syncher);

      // setup subscriptions
      // wait for ready state after each subscribe
      Integer sID = 0;
      sID = this.client.subscribe("allBoards", null, syncher);
      while (!syncher.isReady(sID)) {
        Thread.sleep(100);
      }

      sID = this.client.subscribe("lists", null, syncher);
      while (!syncher.isReady(sID)) {
        Thread.sleep(100);
      }

      sID = this.client.subscribe("cards", null, syncher);
      while (!syncher.isReady(sID)) {
        Thread.sleep(100);
      }

      sID = this.client.subscribe("sentences", null, syncher);
      while (!syncher.isReady(sID)) {
        Thread.sleep(100);
      }

      sID = this.client.subscribe("rawtext", null, syncher);
      while (!syncher.isReady(sID)) {
        Thread.sleep(100);
      }

      // all elements show ready Kanban is synched to Wekan
      this.setSynched(true);
    } catch (InterruptedException e) {
      LOGGER.error("Could not connect to Wekan:" + e.getMessage());
    }

  }

}
