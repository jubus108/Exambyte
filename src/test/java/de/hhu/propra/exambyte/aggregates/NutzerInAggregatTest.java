package de.hhu.propra.exambyte.aggregates;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NutzerInAggregatTest {

    @Test
    @DisplayName("NutzerIn wird korrekt initialisiert")
    void test_nutzerInKonstruktor() {
        // Arrange
        Integer expectedId = 1;
        String expectedUsername = "Nutzer";
        // Act
        NutzerIn nutzerIn = new NutzerIn(expectedId, expectedUsername);
        // Assert
        assertThat(nutzerIn).isNotNull();
        assertThat(nutzerIn.getId()).isEqualTo(expectedId);
        assertThat(nutzerIn.getUsername()).isEqualTo(expectedUsername);
    }

    @Test
    @DisplayName("toString Methode von Nutzerin gibt erwarten String zurück")
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