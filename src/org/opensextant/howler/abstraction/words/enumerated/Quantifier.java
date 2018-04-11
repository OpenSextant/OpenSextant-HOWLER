package org.opensextant.howler.abstraction.words.enumerated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opensextant.howler.abstraction.Vocabulary;
import org.opensextant.howler.abstraction.Word;
import org.opensextant.howler.abstraction.phrases.Footnote;
import org.opensextant.howler.utils.TextUtils;
import org.semanticweb.owlapi.model.IRI;

public enum Quantifier implements Word {
  NULL("", false),
  NO("no", false),
  EVERY("every", false),
  SOME("some", false),
  ONLY("only", false),
  A("a", false),
  THE("the",false),
  EXACT("exactly", true),
  MORE_THAN("more than", true),
  LESS_THAN("less than",true),
  MORE_THAN_OR_EQUAL("at least", true),
  LESS_THAN_OR_EQUAL("at most", true);

    private final String logicalform;
    private boolean numeric;
    private String normalform;
    private IRI key;

    Quantifier(String normalForm, boolean numeric) {
	this.logicalform = TextUtils.createLogicalFromNormal(normalForm);
	this.normalform = normalForm;
	this.numeric = numeric;
	this.key = IRI.create(Vocabulary.BUILTIN_NS.toString(), logicalform);
    }

    public static Quantifier getTypeByNormalName(String normal) {
	return Stream.of(values()).filter(v -> v.getNormalForm().equals(normal)).findAny().orElse(null);
    }

    public String getLogicalform() {
	return logicalform;
    }

    public boolean isNumeric() {
	return numeric;
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
	return Scope.OBJECT;
    }

    @Override
    public WordType getWordType() {
	return WordType.QUANTIFIER;
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