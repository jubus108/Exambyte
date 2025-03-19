package de.hhu.propra.exambyte.domain.model.test;

import java.util.List;

public class MultipleChoiceAufgabe extends Aufgabe{

    private final List<Antwort> antworten;
    private final String erklaerung;

    public MultipleChoiceAufgabe(String name, String aufgabenstellung, int moeglichePunkte, List<Antwort> fragen, String erklaerung) {
        super(AufgabeTyp.MULTIPLE_CHOICE, name, aufgabenstellung, moeglichePunkte);
        this.antworten = fragen;
        this.erklaerung = erklaerung;
    }

    public List<Antwort> antworten() {
        return antworten;
    }

    public String erklaerung() {
        return erklaerung;
    }
    
    @Override
    public String toString() {
        return "MultipleChoiceAufgabe{name='" + name() + "'" +
                ", aufgabenstellung='" + aufgabenstellung() + "'" +
                ", moeglichePunkte=" + moeglichePunkte() +
                "}";
    }
}
