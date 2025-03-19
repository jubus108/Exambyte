package de.hhu.propra.exambyte.domain.model.test;

public abstract class Aufgabe {

    private final AufgabeTyp typ;
    private final String name;
    private final String aufgabenstellung;
    private final int moeglichePunkte;

    public Aufgabe(AufgabeTyp typ, String name, String text, int moeglichePunkte) {
        this.typ = typ;
        this.name = name;
        this.aufgabenstellung = text;
        this.moeglichePunkte = moeglichePunkte;
    }

    public AufgabeTyp typ() {
        return typ;
    }

    public String name() {
        return name;
    }

    public String aufgabenstellung() {
        return aufgabenstellung;
    }

    public int moeglichePunkte() {
        return moeglichePunkte;
    }
}
