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
package org.opensextant.howler.abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.opensextant.howler.abstraction.phrases.Footnote;
import org.semanticweb.owlapi.model.IRI;

/**
 * The Class Document is a container for statements
 */
public class Document {

  private Optional<IRI> documentID = Optional.empty();
  private Optional<IRI> versionID = Optional.empty();
  private List<IRI> importedDocuments = new ArrayList<IRI>();
  private String shortname = ":";
  private List<Statement> statements = new ArrayList<Statement>();
  private List<Word> vocabulary = new ArrayList<Word>();
  private List<Footnote> footnotes = new ArrayList<Footnote>();

  public Document() {
    documentID = Optional.of(IRI.create(Vocabulary.HOWLER_DEFAULT_NS.toString(), "NewDocument"));
  }

  public Optional<IRI> getDocumentID() {
    return documentID;
  }

  public void setDocumentID(IRI id) {
    this.documentID = Optional.of(id);
  }

  public Optional<IRI> getVersionID() {
    return versionID;
  }

  public void setVersionID(IRI versionID) {
    this.versionID = Optional.of(versionID);
  }

  public List<IRI> getImportedDocuments() {
    return importedDocuments;
  }

  public void setImportedDocuments(List<IRI> importedDocument) {
    this.importedDocuments = importedDocument;
  }

  public void addImportedDocument(IRI importedDocument) {
    this.importedDocuments.add(importedDocument);
  }

  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }

  public List<Statement> getStatements() {
    return statements;
  }

  public void setStatements(List<Statement> statements) {
    this.statements = statements;
  }

  public void addStatement(Statement statement) {
    this.statements.add(statement);
  }

  public List<Word> getVocabulary() {
    return vocabulary;
  }

  public void setVocabulary(List<Word> vocabulary) {
    this.vocabulary = vocabulary;
  }

  public void addVocabulary(Word wrd) {
    this.vocabulary.add(wrd);
  }

  public List<Footnote> getFootnotes() {
    return footnotes;
  }

  public void setFootnotes(List<Footnote> footnotes) {
    this.footnotes = footnotes;
  }

  public void addFootnote(Footnote footnote) {
    this.footnotes.add(footnote);
  }

  public String toString() {
    return this.footnotes + "-" + this.statements;
  }

}
