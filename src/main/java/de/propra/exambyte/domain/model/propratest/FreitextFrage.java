package de.propra.exambyte.domain.model.propratest;

public class FreitextFrage extends Frage{

    private String antwort;

    public FreitextFrage(String titel, String aufgabenstellung, int punkte) {
        super(titel, aufgabenstellung, punkte);
        this.antwort = "";
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }
}
