package org.opensextant.howler.abstraction.statements;

import java.util.ArrayList;
import java.util.List;

import org.opensextant.howler.abstraction.Statement;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.words.BadWord;

public class WordSequence extends Statement {

	private List<Word> wordBases = new ArrayList<Word>();

	public boolean isBad() {
		for (Word w : wordBases) {
			if (w instanceof BadWord) {
				return true;
			}
		}
		return false;
	}

	public List<Word> getWords() {
		return wordBases;
	}

	public void setWords(List<Word> wordBases) {
		this.wordBases = wordBases;
	}

	public void addWord(Word wordBase) {
		this.wordBases.add(wordBase);
	}

}
