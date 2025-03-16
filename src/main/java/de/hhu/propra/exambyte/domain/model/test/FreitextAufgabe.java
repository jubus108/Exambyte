package de.hhu.propra.exambyte.domain.model.test;

public class FreitextAufgabe extends Aufgabe {

    public FreitextAufgabe(String name, String aufgabenstellung, int moeglichePunkte) {
        super(name, aufgabenstellung, moeglichePunkte);
    }

    @Override
    public String toString() {
        return "FreitextAufgabe{name='" + getName() + "'" +
                ", aufgabenstellung='" + getAufgabenstellung() + "'" +
                ", moeglichePunkte=" + getMoeglichePunkte() +
                "}";
    }
}
