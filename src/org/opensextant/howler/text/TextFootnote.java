package org.opensextant.howler.text;

import org.opensextant.howler.abstraction.Word;

public class TextFootnote {

  private Word noteType;
  private Word content;

  public Word getNoteType() {
    return noteType;
  }

  public void setNoteType(Word noteType) {
    this.noteType = noteType;
  }

  public Word getContent() {
    return content;
  }

  public void setContent(Word content) {
    this.content = content;
  }

  public String toString() {
    return "Footnote:" + this.noteType.getNormalForm() + "->" + this.content.getNormalForm();
  }

}
