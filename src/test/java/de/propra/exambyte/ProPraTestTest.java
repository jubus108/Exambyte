package de.propra.exambyte;

import de.propra.exambyte.domain.model.propratest.FreitextFrage;
import de.propra.exambyte.domain.model.propratest.MultipleChoiceFrage;
import de.propra.exambyte.domain.model.propratest.ProPraTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProPraTestTest {

    private ProPraTest dummyTest;
    private MultipleChoiceFrage dummyMultipleChoiceFrage;
    private FreitextFrage dummyFreitextFrage;

    @BeforeEach
    void setUp() {
        dummyTest = new ProPraTest("Dummy Test");
        dummyMultipleChoiceFrage = new MultipleChoiceFrage("Frage X", "Was ist Richtig?", 5);
        dummyFreitextFrage = new FreitextFrage("Frage Y", "Schreib etwas", 5);
    }

    @Test
    void multipleChoiceFragenParameterSindInitialisiert() {
        assertThat(dummyMultipleChoiceFrage.getTitel()).isEqualTo("Frage X");
        assertThat(dummyMultipleChoiceFrage.getAufgabenstellung()).isEqualTo("Was ist Richtig?");
        assertThat(dummyMultipleChoiceFrage.getPunkte()).isEqualTo(5);
        assertThat(dummyMultipleChoiceFrage.getNumAntworten()).isEqualTo(0);
    }

    @Test
    void multipleChoiceFragenAddAntworten() {
        // Füge Antworten hinzu
        dummyMultipleChoiceFrage.addAntwort("Antwort a", true);
        dummyMultipleChoiceFrage.addAntwort("Antwort b", false);
        dummyMultipleChoiceFrage.addAntwort("Antwort c", true);

        // Erwartete Map
        Map<String, Boolean> erwarteteAntworten = new HashMap<>();
        erwarteteAntworten.put("Antwort a", true);
        erwarteteAntworten.put("Antwort b", false);
        erwarteteAntworten.put("Antwort c", true);

        // AssertJ-Test, um zu prüfen, ob die tatsächliche Map gleich der erwarteten ist
        assertThat(dummyMultipleChoiceFrage.getAntworten()).isEqualTo(erwarteteAntworten);
    }

    @Test
    void freitextFragenParameterSindInitialisiert() {
        assertThat(dummyFreitextFrage.getTitel()).isEqualTo("Frage Y");
        assertThat(dummyFreitextFrage.getAufgabenstellung()).isEqualTo("Schreib etwas");
        assertThat(dummyFreitextFrage.getPunkte()).isEqualTo(5);
        assertThat(dummyFreitextFrage.getAntwort()).isEqualTo("");
    }

    @Test
    void testParameterSindInitialisiert() {
        assertThat(dummyTest.getName()).isEqualTo("Dummy Test");
        assertThat(dummyTest.getFragen()).isEmpty();
    }

    @Test
    void testAddFrage() {

    }

    @Test
    void testRemoveFrage() {

    }

    @Test
    void testSetFrage() {

    }
}
