package de.hhu.propra.exambyte.aggregates;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import de.hhu.propra.exambyte.domain.model.test.ExambyteTest;
import de.hhu.propra.exambyte.domain.model.test.Antwort;
import de.hhu.propra.exambyte.domain.model.test.FreitextAufgabe;
import de.hhu.propra.exambyte.domain.model.test.MultipleChoiceAufgabe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAggregatTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    @DisplayName("ExambyteTest wird korrekt initialisiert")
    void test_exambyteTestKonstruktor() {
        // Arrange
        Integer id = 1;
        String name = "Test #1";
        LocalDateTime startDatum = LocalDateTime.of(2025, 3, 1, 8, 0);
        LocalDateTime endDatum = startDatum.plusWeeks(1);
        // Act
        ExambyteTest test = new ExambyteTest(id, name, startDatum, endDatum);
        // Assert
        assertThat(test).isNotNull();
        assertThat(test.getId()).isEqualTo(id);
        assertThat(test.getName()).isEqualTo(name);
        assertThat(test.getStartDatum()).isEqualTo(startDatum);
        assertThat(test.getEndDatum()).isEqualTo(endDatum);
    }

    @Test
    @DisplayName("toString Methode von ExambyteTest gibt erwarten String zurück")
    void test_exambyteTestToString() {
        // Arrange
        Integer id = 1;
        String username = "NutzerIn";
        NutzerIn nutzerIn = new NutzerIn(id, username);
        // Act
        String toStringResult = nutzerIn.toString();
        // Assert
        assertThat(toStringResult).isNotNull();
        assertThat(toStringResult).isEqualTo("Nutzer:in{id=" + id + ", username='" + username + "'}");
    }

    @Test
    @DisplayName("FreitextAufgabe wird korrekt initialisiert")
    void test_freitextAufgabeKonstruktor() {
        // Arrange
        String name = "Aufgabe #1";
        String aufgabenstellung = "Hier könnte ihre Aufgabenstellung stehen";
        int moeglichePunkte = 5;
        // Act
        FreitextAufgabe freitextAufgabe = new FreitextAufgabe(name, aufgabenstellung, moeglichePunkte);
        // Assert
        assertThat(freitextAufgabe).isNotNull();
        assertThat(freitextAufgabe.getName()).isEqualTo(name);
        assertThat(freitextAufgabe.getAufgabenstellung()).isEqualTo(aufgabenstellung);
        assertThat(freitextAufgabe.getMoeglichePunkte()).isEqualTo(moeglichePunkte);
    }

    @Test
    @DisplayName("toString Methode von FreitextAufgabe gibt erwarten String zurück")
    void test_freitextAufgabeToString() {
        // Arrange
        String name = "Aufgabe #1";
        String aufgabenstellung = "Hier könnte ihre Aufgabenstellung stehen";
        int moeglichePunkte = 5;
        FreitextAufgabe freitextAufgabe = new FreitextAufgabe(name, aufgabenstellung, moeglichePunkte);
        // Act
        String toStringResult = freitextAufgabe.toString();
        // Assert
        assertThat(toStringResult).isNotNull();
        assertThat(toStringResult).isEqualTo("FreitextAufgabe{name='"+ name + "', aufgabenstellung='" + aufgabenstellung + "', moeglichePunkte=" + moeglichePunkte+ "}");
    }

    @Test
    @DisplayName("Antwort wird korrekt initialisiert")
    void test_antwortKonstruktor() {
        // Arrange
        String text = "Java ist auch eine Insel";
        boolean isRichtig = true;
        // Act
        Antwort antwort = new Antwort(text, isRichtig);
        // Assert
        assertThat(antwort).isNotNull();
        assertThat(antwort.text()).isEqualTo(text);
        assertThat(antwort.isRichtig()).isEqualTo(isRichtig);
    }

    @Test
    @DisplayName("MultipleChoiceAufgabe wird korrekt initialisiert")
    void test_multipleChoiceAufgabeKonstruktor() {
        // Arrange
        String name = "Aufgabe #1";
        String aufgabenstellung = "Welches Schlüsselwort nutzt man, damit nur die Klassen innerhalb des gleichen Packages auf ein Attribut zugreifen können?";
        List<Antwort> antworten  = new ArrayList<>();
        antworten.add(new Antwort("private", false));
        antworten.add(new Antwort("keins", false));
        antworten.add(new Antwort("protected", true));
        antworten.add(new Antwort("public", false));
        int moeglichePunkte = 8;
        // Act
        MultipleChoiceAufgabe multipleChoiceAufgabe = new MultipleChoiceAufgabe(name, aufgabenstellung, antworten, moeglichePunkte);
        // Assert
        assertThat(multipleChoiceAufgabe).isNotNull();
        assertThat(multipleChoiceAufgabe.getName()).isEqualTo(name);
        assertThat(multipleChoiceAufgabe.getAufgabenstellung()).isEqualTo(aufgabenstellung);
        assertThat(antworten).isEqualTo(antworten);
    }
}