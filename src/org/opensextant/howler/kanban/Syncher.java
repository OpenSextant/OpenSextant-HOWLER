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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.opensextant.howler.kanban.elements.Board;
import org.opensextant.howler.kanban.elements.Card;
import org.opensextant.howler.kanban.elements.CardList;
import org.opensextant.howler.kanban.elements.RawText;
import org.opensextant.howler.kanban.elements.Sentence;
import org.slf4j.LoggerFactory;

import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.DDPClient.DdpMessageField;
import com.keysolutions.ddpclient.DDPClient.DdpMessageType;
import com.keysolutions.ddpclient.DDPListener;

public class Syncher extends DDPListener implements Observer {
  private static final org.slf4j.Logger LOGGER = LoggerFactory
      .getLogger(Syncher.class);

  // the Kanban object to be synchronized with Wekan
  private Kanban kanban;

  List<Integer> readies = new ArrayList<Integer>();

  // state of connection to Wekan
  private DDPClient.CONNSTATE connect;

  public Syncher(Kanban kanban) {
    this.kanban = kanban;
    connect = DDPClient.CONNSTATE.Closed;
  }

  @Override
  @SuppressWarnings("unchecked")
  // catch all of the incoming messages
  public void update(Observable obs, Object msg) {

    if (!(obs instanceof DDPClient)) {
      LOGGER.error("Got an Observable that is not a DDPClient" + obs);
      return;
    }

    if (!(msg instanceof Map<?, ?>)) {
      LOGGER.error("Got an update message that is not a Map:" + msg);
      return;
    }

    Map<String, Object> message = (Map<String, Object>) msg;

    // get fixed message fields
    String msgtype = (String) message.get(DDPClient.DdpMessageField.MSG);
    String collName = (String) message.get(DdpMessageField.COLLECTION);
    String id = (String) message.get(DdpMessageField.ID);

    // all the variable message fields
    Map<String, Object> fields = (Map<String, Object>) message
        .get(DdpMessageField.FIELDS);

    // new elements added
    if (msgtype.equals(DdpMessageType.ADDED)) {

      // new raw text added
      if (collName.equalsIgnoreCase("rawtext")) {
        RawText input = RawText.fromMap(fields);
        input.set_id(id);
        kanban.addRawText(input);
        return;
      }

      // new sentence added
      if (collName.equalsIgnoreCase("sentences")) {
        Sentence input = Sentence.fromMap(fields);
        input.set_id(id);
        kanban.addSentence(input);
        return;
      }

      // new board added
      if (collName.equalsIgnoreCase("boards")) {
        Board board = Board.fromMap(fields);
        board.setId(id);
        kanban.addBoard(board);
        return;
      }

      // new lists added
      if (collName.equalsIgnoreCase("lists")) {
        CardList list = CardList.fromMap(fields);
        list.setId(id);
        kanban.addList(list);
        return;
      }

      // new card added
      if (collName.equalsIgnoreCase("cards")) {
        Card card = Card.fromMap(fields);
        card.set_id(id);
        kanban.addCard(card);
        return;
      }

      LOGGER.info("Got a " + msgtype + " message for collection " + collName
          + " Ignoring.");
      return;
    }

    // changed element TODO?
    if (msgtype.equals(DdpMessageType.CHANGED)) {

      LOGGER.info("Got a " + msgtype + " message for collection " + collName
          + " Ignoring.");
      return;
    }

    // removed/deleted element TODO?
    if (msgtype.equals(DdpMessageType.REMOVED)) {

      LOGGER.info("Got a " + msgtype + " message for collection " + collName
          + " Ignoring.");
      return;
    }

    // set connection state
    if (msgtype.equals(DdpMessageType.CONNECTED)) {
      LOGGER.debug("Got a CONNECTED");
      connect = DDPClient.CONNSTATE.Connected;
      return;
    }

    if (msgtype.equals(DdpMessageType.CLOSED)) {
      LOGGER.debug("Got a CLOSED");
      connect = DDPClient.CONNSTATE.Closed;
      return;
    }

    if (msgtype.equals(DdpMessageType.ERROR)) {
      LOGGER.error("Got a ERROR:" + msg);
      return;
    }

    if (msgtype.equals(DdpMessageType.PING)) {
      LOGGER.debug("Got a PING");
      return;
    }

    if (msgtype.equals(DdpMessageType.READY)) {
      List<String> subs = (List<String>) message.get("subs");

      for (String i : subs) {
        readies.add(Integer.parseInt(i));
      }

      LOGGER.debug(
          "Got a READY message for subscription(s):" + message.get("subs"));
      return;
    }

    // ignore every other message
    LOGGER.info("Got a " + msgtype + " message. Ignoring " + msg);

  }

  public boolean isConnected() {
    return this.connect.equals(DDPClient.CONNSTATE.Connected);
  }

  public boolean isReady(Integer sID) {
    return this.readies.contains(sID);
  }

}
