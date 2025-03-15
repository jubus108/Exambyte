package de.hhu.propra.exambyte;

import de.hhu.propra.exambyte.domain.model.propratest.Frage;
import de.hhu.propra.exambyte.domain.model.propratest.FragenType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ProPraTestTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Frage wird vernünftig als Multiple-Choice-Frage initialisiert")
    void test_frageInitalisierungMultipleChoice() {
        // arrange
        HashMap<String, Boolean> antworten = new HashMap<>();
        antworten.put("global",false);
        antworten.put("package",true);
        antworten.put("class",true);
        antworten.put("subclass",true);
        // act
        Frage frage = new Frage(FragenType.MULTIPLE_CHOICE, 5, "Scope 3", "Klassen aus welchem Scope können auf eine Methode zugreifen, die den Modifier protected hat?", antworten);
        // assert
        assertThat(frage.antworten()).isEqualTo(antworten);
    }

    @Test
    @DisplayName("Frage wird vernünftig als Freitext-Aufgabe initialisiert")
    void test_frageInitalisierungFreitext() {
        // arrange
        HashMap<String, Boolean> antworten = new HashMap<>();
        antworten.put("Bitte schreiben Sie einen kurzen Text:",false);
        // act
        Frage frage = new Frage(FragenType.FREITEXT, 5, "DummyText", "Lorem ipsum bla bli blub", antworten);
        // assert
        assertThat(frage.antworten()).isEqualTo(antworten);
    }

}
