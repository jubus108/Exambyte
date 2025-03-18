package de.hhu.propra.exambyte.aggregates;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import de.hhu.propra.exambyte.domain.model.test.Abgabe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AbgabeTest {

    private NutzerIn nutzerInMock;
    private AggregateReference<NutzerIn, Long> nutzerInReference;
    private LocalDateTime abgabeDatum;

    @BeforeEach
    void setUp() {
        nutzerInMock = mock(NutzerIn.class);
        nutzerInReference = AggregateReference.to(nutzerInMock.id());
        abgabeDatum = LocalDateTime.of(2025, 3, 16, 12, 0);
    }

    @Test
    void test_abgabeKonstruktor() {
        // Act
        Abgabe abgabe = new Abgabe(nutzerInReference, abgabeDatum);
        // Assert
        assertThat(abgabe).isNotNull();
        assertThat(abgabe.nutzerIn()).isEqualTo(nutzerInReference);
        assertThat(abgabe.abgabeDatum()).isEqualTo(abgabeDatum);
    }

    @Test
    void test_toString() {
        // Act
        Abgabe abgabe = new Abgabe(nutzerInReference, abgabeDatum);

        // Assert
        assertThat(abgabe.toString()).contains("nutzerIn=" + nutzerInMock.id().toString());
        assertThat(abgabe.toString()).contains("abgabeDatum=" + abgabeDatum.toString());
    }

    @Test
    void test_abgabeNullDatum() {
        // Act
        Abgabe abgabe = new Abgabe(nutzerInReference, null);
        // Assert
        assertThat(abgabe.abgabeDatum()).isNull();
    }
}
