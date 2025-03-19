package de.hhu.propra.exambyte.aggregates;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import de.hhu.propra.exambyte.domain.model.test.*;
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
        int id = 24663478;
        String name = "Test #1";

        Aufgabe a1 = new MultipleChoiceAufgabe("Geografie 1",
                "Will ich aus 'ganda' einen Staat in Afrika machen, muss da vorne noch ein ...?",
                4,
                List.of(new Antwort("'Ti' tan", false),
                        new Antwort("'Pla' tin", false),
                        new Antwort("'Wolf' ram", false),
                        new Antwort("'U' ran", true)),
                "Dies ist eine Erklärung");
        Aufgabe a2 = new MultipleChoiceAufgabe("Freizeit 2",
                "Was macht man mit Kaminholz?",
                4,
                List.of(new Antwort("adjektivwettlauf", false),
                        new Antwort("präpositionenjagd", false),
                        new Antwort("substantivralley", false),
                        new Antwort("verbrennen", true)),
                "Dies ist eine Erklärung");
        Aufgabe a3 = new FreitextAufgabe("Haushalt 1",
                "Pasten Sie hier ihr Lieblingsrezept:",
                5);
        Aufgabe a4 = new FreitextAufgabe("Kultur 1",
                "Stellen Sie sich vor, sie wären ein Chinesischer Bauer während der Ming Dynastie. Schreiben Sie einen Brief an ihren Bruder, einen Offizier in der Kaiserlichen Armee",
                10);

        List<Aufgabe> aufgaben = List.of(a1, a2, a3, a4);
        LocalDateTime startDatum = LocalDateTime.of(2025, 3, 1, 8, 0);
        LocalDateTime endDatum = startDatum.plusWeeks(1);
        LocalDateTime ergebnisVeroeffentlichungsdatum = endDatum.plusWeeks(1);
        // Act
        ExambyteTest test = new ExambyteTest(id, name, aufgaben, startDatum, endDatum, ergebnisVeroeffentlichungsdatum);
        // Assert
        assertThat(test).isNotNull();
        assertThat(test.id()).isEqualTo(id);
        assertThat(test.name()).isEqualTo(name);
        assertThat(test.aufgaben()).isEqualTo(aufgaben);
        assertThat(test.startDatum()).isEqualTo(startDatum);
        assertThat(test.endDatum()).isEqualTo(endDatum);
        assertThat(test.ergebnisVeroeffentlichungsDatum()).isEqualTo(ergebnisVeroeffentlichungsdatum);
    }

    @Test
    @DisplayName("toString Methode von ExambyteTest gibt erwarten String zurück")
    void test_exambyteTestToString() {
        //TODO
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
        assertThat(freitextAufgabe.name()).isEqualTo(name);
        assertThat(freitextAufgabe.aufgabenstellung()).isEqualTo(aufgabenstellung);
        assertThat(freitextAufgabe.moeglichePunkte()).isEqualTo(moeglichePunkte);
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
        int moeglichePunkte = 8;
        antworten.add(new Antwort("private", false));
        antworten.add(new Antwort("keins", false));
        antworten.add(new Antwort("protected", true));
        antworten.add(new Antwort("public", false));
        String erklaerung = "Auf ein mit 'public' gekennzeichnetes Attribut kann von überall zugegriffen werden. Ohne Schlüsselwort können nur...";
        // Act
        MultipleChoiceAufgabe multipleChoiceAufgabe = new MultipleChoiceAufgabe(name, aufgabenstellung, moeglichePunkte,  antworten, erklaerung);
        // Assert
        assertThat(multipleChoiceAufgabe).isNotNull();
        assertThat(multipleChoiceAufgabe.name()).isEqualTo(name);
        assertThat(multipleChoiceAufgabe.aufgabenstellung()).isEqualTo(aufgabenstellung);
        assertThat(multipleChoiceAufgabe.moeglichePunkte()).isEqualTo(moeglichePunkte);
        assertThat(multipleChoiceAufgabe.antworten()).isEqualTo(antworten);
        assertThat(multipleChoiceAufgabe.erklaerung()).isEqualTo(erklaerung);
    }
}