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

import java.util.Map;

import org.opensextant.howler.abstraction.words.enumerated.WordType;

import com.google.gson.Gson;

public class Card {

  private String _id;

  String title;
  String key;
  WordType entityType = WordType.COMMON_NOUN;
  boolean archived = false;
  String listId;
  String boardId;
  String coverId;
  String description;
  String[] labelIds = new String[0];
  String[] members = new String[0];
  String userId;
  double sort = 1.0;

  private static Gson gson = new Gson();

  public static Card fromMap(Map<String, Object> fields) {
    return gson.fromJson(gson.toJson(fields), Card.class);
  }

  public String get_id() {
    return _id;
  }

  public void set_id(String _id) {
    this._id = _id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public WordType getEntityType() {
    return entityType;
  }

  public void setEntityType(WordType entityType) {
    this.entityType = entityType;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getListId() {
    return listId;
  }

  public void setListId(String listId) {
    this.listId = listId;
  }

  public String getBoardId() {
    return boardId;
  }

  public void setBoardId(String boardId) {
    this.boardId = boardId;
  }

  public String getCoverId() {
    return coverId;
  }

  public void setCoverId(String coverId) {
    this.coverId = coverId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String[] getLabelIds() {
    return labelIds;
  }

  public void setLabelIds(String[] labelIds) {
    this.labelIds = labelIds;
  }

  public String[] getMembers() {
    return members;
  }

  public void setMembers(String[] members) {
    this.members = members;
  }

  public String getUserid() {
    return userId;
  }

  public void setUserid(String userid) {
    this.userId = userid;
  }

  public double getSort() {
    return sort;
  }

  public void setSort(double sort) {
    this.sort = sort;
  }

  public boolean isArchived() {
    return archived;
  }

  public void setArchived(boolean archived) {
    this.archived = archived;
  }

}
