package de.propra.exambyte.domain.model.propratest;

import java.util.HashMap;
import java.util.Map;

public class MultipleChoiceFrage extends Frage {

    private Map<String, Boolean> antworten;

    public MultipleChoiceFrage(String titel, String aufgabenstellung, int punkte) {
        super(titel, aufgabenstellung, punkte);
        this.antworten = new HashMap<>();
    }

    public Map<String, Boolean> getAntworten() {
        return antworten;
    }

    public void addAntwort(String antwortString, Boolean istRichtig) {
        this.antworten.put(antwortString, istRichtig);
    }

    public int getNumAntworten() {
        return antworten.size();
    }
}
