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
package org.opensextant.howler.kanban.elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opensextant.howler.spo.Word;

import com.google.gson.Gson;

public class Sentence {

  private String _id;
  private String text;
  private Set<Word> words = new HashSet<Word>();
  private boolean parseable = true;
  private boolean inferred = true;
  private String userId;
  private String boardId;
  private List<String> keys = new ArrayList<String>();

  private static Gson gson = new Gson();

  public static Sentence fromMap(Map<String, Object> fields) {
    return gson.fromJson(gson.toJson(fields), Sentence.class);
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Set<Word> getWords() {
    return words;
  }

  public void setWords(Set<Word> words) {
    this.words = words;
  }

  public String getBoardId() {
    return boardId;
  }

  public void setBoardId(String boardId) {
    this.boardId = boardId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public boolean isInferred() {
    return inferred;
  }

  public void setInferred(boolean inferred) {
    this.inferred = inferred;
  }

  public boolean isParseable() {
    return parseable;
  }

  public void setParseable(boolean parseable) {
    this.parseable = parseable;
  }

  public List<String> getKeys() {
    return keys;
  }

  public void setKeys(List<String> keys) {
    this.keys = keys;
  }

  public void addKey(String key) {
    this.keys.add(key);
  }

  public String textKey() {
    return this.getText().toLowerCase() + "|" + this.getBoardId();
  }

  public String toString() {
    return this.text;
  }

}
