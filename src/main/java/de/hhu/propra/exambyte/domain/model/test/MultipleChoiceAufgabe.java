package de.hhu.propra.exambyte.domain.model.test;

import java.util.List;

public class MultipleChoiceAufgabe extends Aufgabe{

    private final List<Antwort> antworten;

    public MultipleChoiceAufgabe(String name, String aufgabenstellung, List<Antwort> fragen, int moeglichePunkte) {
        super(name, aufgabenstellung, moeglichePunkte);
        this.antworten = fragen;
    }

    public List<Antwort> getAntworten() {
        return antworten;
    }

    @Override
    public String toString() {
        return "MultipleChoiceAufgabe{name='" + getName() + "'" +
                ", aufgabenstellung='" + getAufgabenstellung() + "'" +
                ", moeglichePunkte=" + getMoeglichePunkte() +
                "}";
    }
}
