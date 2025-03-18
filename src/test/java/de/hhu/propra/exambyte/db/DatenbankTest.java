package de.hhu.propra.exambyte.db;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
import de.hhu.propra.exambyte.configuration.TestcontainersConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
@Import(TestcontainersConfiguration.class)
public class DatenbankTest {

    @Autowired
    NutzerInRepository nutzerInRepository;

    @Test
    @DisplayName("Ein:e NutzerIn Aggregat kann gespeichert werden")
    void test_saveNutzerIn() throws Exception {
        // Arrange
        NutzerIn nutzerIn = new NutzerIn(null, "MaxMustermann");
        // Act
        NutzerIn gespeichert = nutzerInRepository.save(nutzerIn);
        // Assert
        assertThat(gespeichert.id()).isNotNull();
        assertThat(nutzerInRepository.findById(gespeichert.id())).isPresent();
        assertThat(nutzerInRepository.findById(gespeichert.id()).get().username())
                .isEqualTo("MaxMustermann");
    }

    @Test
    @DisplayName("Ein:e NutzerIn wird vernünftig gelöscht")
    void test_deleteNutzerIn() throws Exception {
        // Arrange
        NutzerIn nutzerIn = new NutzerIn(null, "MaxMustermann");
        // Act
        NutzerIn gespeichert = nutzerInRepository.save(nutzerIn);
        nutzerInRepository.delete(gespeichert);
        // Assert
        assertThat(nutzerInRepository.findById(gespeichert.id())).isNotPresent();
    }

    @Test
    @DisplayName("Es werden alle gespeicherten NutzerInnen geladen")
    void test_findAllNutzerIn() throws Exception {
        // Arrange
        NutzerIn nutzerIn1 = new NutzerIn(null, "MaxMustermann");
        NutzerIn nutzerIn2 = new NutzerIn(null, "MiraMusterfrau");
        NutzerIn nutzerIn3 = new NutzerIn(null, "MikaMusterperson");

        nutzerInRepository.save(nutzerIn1);
        nutzerInRepository.save(nutzerIn2);
        nutzerInRepository.save(nutzerIn3);

        // Act
        List<NutzerIn> nutzerInListe = nutzerInRepository.findAll();

        // Assert
        assertThat(nutzerInListe).hasSize(3);
        assertThat(nutzerInListe).extracting(NutzerIn::username)
                .containsExactlyInAnyOrder("MaxMustermann", "MiraMusterfrau", "MikaMusterperson");
    }

    @Test
    @DisplayName("Ein:e NutzerIn kann anhand ihrer Id gefunden werden")
    void test_findNutzerInById() throws Exception {
        // Arrange
        NutzerIn nutzerIn = new NutzerIn(null, "MaxMustermann");
        NutzerIn gespeichert = nutzerInRepository.save(nutzerIn);

        // Act
        Optional<NutzerIn> gefunden = nutzerInRepository.findById(gespeichert.id());

        // Assert
        assertThat(gefunden).isPresent();
        assertThat(gefunden.get().username()).isEqualTo("MaxMustermann");
    }

    @Test
    @DisplayName("Beim Versuch eine nicht vorhandene Id zu finden gibt es eine Fehlermeldung")
    void test_findNutzerInById_fail() throws Exception {
        // Act
        Optional<NutzerIn> nichtGefunden = nutzerInRepository.findById(999L);  // Eine ID, die nicht existiert
        // Assert
        assertThat(nichtGefunden).isNotPresent();  // Erwartet, dass nichts gefunden wird
    }

    @Test
    @DisplayName("Ein:e NutzerIn kann anhand seiner/ihres Usernames gefunden werden")
    void test_findNutzerInByUsername() throws Exception {
        // Arrange
        NutzerIn nutzerIn = new NutzerIn(null, "MaxMustermann");
        NutzerIn gespeichert = nutzerInRepository.save(nutzerIn);

        // Act
        Optional<NutzerIn> gefunden = nutzerInRepository.findByUsername(gespeichert.username());

        // Assert
        assertThat(gefunden).isPresent();
        assertThat(gefunden.get().username()).isEqualTo("MaxMustermann");
    }

    @Test
    @DisplayName("Beim Versuch eine nicht vorhandene Id zu finden gibt es eine Fehlermeldung")
    void test_findNutzerInByUsername_fail() throws Exception {
        // Act
        Optional<NutzerIn> nichtGefunden = nutzerInRepository.findByUsername("NichtVorhanden");  // Eine ID, die nicht existiert
        // Assert
        assertThat(nichtGefunden).isNotPresent();  // Erwartet, dass nichts gefunden wird
    }
}