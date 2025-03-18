package de.hhu.propra.exambyte.domain.model.test;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;

public class Abgabe {

    private AggregateReference<NutzerIn, Long> nutzerIn;
    private final LocalDateTime abgabeDatum;

    public Abgabe(AggregateReference<NutzerIn, Long> nutzerIn, LocalDateTime abgabeDatum) {
        this.nutzerIn = nutzerIn;
        this.abgabeDatum = abgabeDatum;
    }

    public AggregateReference<NutzerIn, Long> nutzerIn() {
        return nutzerIn;
    }

    public LocalDateTime abgabeDatum() {
        return abgabeDatum;
    }

    @Override
    public String toString() {
        return "Abgabe{" +
                "nutzerIn=" + nutzerIn.getId() +
                ", abgabeDatum=" + abgabeDatum +
                '}';
    }
}