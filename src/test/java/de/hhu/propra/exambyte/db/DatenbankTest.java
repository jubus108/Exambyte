package de.hhu.propra.exambyte.db;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import de.hhu.propra.exambyte.configuration.TestcontainersConfiguration;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestcontainersConfiguration.class)
public class DatenbankTest {

    @Autowired
    NutzerInDataRepository nutzerInDataRepository;

    NutzerInRepository nutzerInRepository;

    @BeforeEach
    void setUp() {
        nutzerInRepository = new NutzerInRepositoryImpl(nutzerInDataRepository);
    }

    @Test
    @DisplayName("Ein:e Nutzer:in kann gespeichert und geladen werden")
    void test_speicherNutzerIn() {
        // Arrange
        NutzerIn nutzerIn = new NutzerIn(693689129, "username");
        Integer existingDbKey =
                nutzerInDataRepository.findByGithubId(nutzerIn.id()).map(NutzerInDto::id).orElse(null);
        // Act
        nutzerInRepository.save(nutzerIn);
        Optional<NutzerIn> geladen = nutzerInRepository.findById(nutzerIn.id());
        // Assert
        assertThat(geladen).isPresent();
        assertThat(geladen.get().id()).isEqualTo(693689129);
        assertThat(geladen.get().username()).isEqualTo("username");
    }

    @Test
    @DisplayName("NutzerInDto kann vernünftig in die Datenbank geschrieben werden")
    void  test_speicherNutzerInDto() {
        // Arrange
        NutzerInDto nutzerInDto = new NutzerInDto(null, 123456, "testuser");
        // Act
        NutzerInDto saved = nutzerInDataRepository.save(nutzerInDto);
        // Assert
        assertThat(saved.id()).isNotNull();
    }
}