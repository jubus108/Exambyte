package de.propra.exambyte.domain.model.propratest;

public abstract class Frage {

    private int punkte;
    private String titel;
    private String aufgabenstellung;

    public Frage(String titel, String aufgabenstellung, int punkte) {
        this.titel = titel;
        this.aufgabenstellung = aufgabenstellung;
        this.punkte = punkte;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAufgabenstellung() {
        return aufgabenstellung;
    }

    public void setAufgabenstellung(String aufgabenstellung) {
        this.aufgabenstellung = aufgabenstellung;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
