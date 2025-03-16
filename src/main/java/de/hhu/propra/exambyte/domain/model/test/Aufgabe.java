package de.hhu.propra.exambyte.domain.model.test;

public abstract class Aufgabe {

    private String name;
    private String aufgabenstellung;
    private int moeglichePunkte;

    public Aufgabe(String name, String text, int moeglichePunkte) {
        this.name = name;
        this.aufgabenstellung = text;
        this.moeglichePunkte = moeglichePunkte;
    }

    public String getName() {
        return name;
    }

    public String getAufgabenstellung() {
        return aufgabenstellung;
    }

    public int getMoeglichePunkte() {
        return moeglichePunkte;
    }
}
