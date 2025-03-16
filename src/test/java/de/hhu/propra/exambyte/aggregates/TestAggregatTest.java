package de.hhu.propra.exambyte.aggregates;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import de.hhu.propra.exambyte.domain.model.test.ExambyteTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAggregatTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Test
    @DisplayName("ExambyteTest wird korrekt initialisiert")
    void test_nutzerInKonstruktor() {
        // Arrange
        Integer expectedId = 1;
        String expectedName = "Test #1";
        LocalDateTime expectedStartDatum = LocalDateTime.of(2025, 3, 1, 8, 0);
        LocalDateTime expectedEndDatum = expectedStartDatum.plusWeeks(1);
        // Act
        ExambyteTest test = new ExambyteTest(expectedId, expectedName, expectedStartDatum, expectedEndDatum);
        // Assert
        assertThat(test).isNotNull();
        assertThat(test.getId()).isEqualTo(expectedId);
        assertThat(test.getName()).isEqualTo(expectedName);
        assertThat(test.getStartDatum()).isEqualTo(expectedStartDatum);
        assertThat(test.getEndDatum()).isEqualTo(expectedEndDatum);
    }

    @Test
    @DisplayName("toString Methode von ExambyteTest gibt erwarten String zurück")
    void test_toString() {
        // Arrange
        Integer id = 1;
        String username = "NutzerIn";
        NutzerIn nutzerIn = new NutzerIn(id, username);
        // Act
        String toStringResult = nutzerIn.toString();
        // Assert
        assertThat(toStringResult).isNotNull();
        assertThat(toStringResult).isEqualTo("Nutzer:in{id=1, username='NutzerIn'}");
    }
}
