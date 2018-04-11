package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;

public enum Negative implements Word {
	NO("no"),
  NOT("not"),
  NONE("none");

	private final String logicalform;
	private String normalform;
	private IRI key;

	Negative(String normalForm) {
		this.logicalform = TextUtils.createLogicalFromNormal(normalForm);
		this.normalform = normalForm;
		this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
	}

	public static Negative getTypeByNormalName(String normal) {
		return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
	}

	public String getLogicalform() {
		return logicalform;
	}

	@Override
	public String getNormalForm() {
		return normalform;
	}

	@Override
	public void setNormalForm(String normalForm) {
		// ignore
	}

	@Override
	public IRI getKey() {
		return key;
	}

	@Override
	public String getLogicalForm() {
		return logicalform;
	}

	@Override
	public String getNamespace() {
		return Vocabulary.BUILTIN_NS.toString();
	}

	@Override
	public Scope getScope() {
		return Scope.GENERAL;
	}

	@Override
	public WordType getWordType() {
		return WordType.NEGATIVE;
	}

	@Override
	public List<Footnote> getFootnotes() {
		return new ArrayList<Footnote>();
	}

	@Override
	public void setFootnotes(List<Footnote> footnotes) {
		// ignore
	}

	@Override
	public void addFootnote(Footnote footnote) {
		// ignore
	}

}
