package de.hhu.propra.exambyte.domain.model.test;

public abstract class Aufgabe {

    private final String name;
    private final String aufgabenstellung;
    private final int moeglichePunkte;

    public Aufgabe(String name, String text, int moeglichePunkte) {
        this.name = name;
        this.aufgabenstellung = text;
        this.moeglichePunkte = moeglichePunkte;
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
