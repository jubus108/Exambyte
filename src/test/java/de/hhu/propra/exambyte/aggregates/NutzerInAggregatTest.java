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
        Integer id = 849594326;
        String username = "Nutzer";
        // Act
        NutzerIn nutzerIn = new NutzerIn(id, username);
        // Assert
        assertThat(nutzerIn).isNotNull();
        assertThat(nutzerIn.id()).isEqualTo(id);
        assertThat(nutzerIn.username()).isEqualTo(username);
    }

    @Test
    @DisplayName("toString Methode von Nutzerin gibt erwarten String zurück")
    void test_toString() {
        // Arrange
        Integer id = 20570257;
        String username = "NutzerIn";
        NutzerIn nutzerIn = new NutzerIn(id, username);
        // Act
        String toStringResult = nutzerIn.toString();
        // Assert
        assertThat(toStringResult).isNotNull();
        assertThat(toStringResult).isEqualTo("Nutzer:in{id=" + id + ", username='" + username + "'}");
    }
}