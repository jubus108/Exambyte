package de.hhu.propra.exambyte.application.services.repository;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;

import java.util.Optional;
import java.util.UUID;

public interface NutzerInRepository {

    NutzerIn save(NutzerIn nutzerIn);

    void deleteById(Integer id);

    Optional<NutzerIn> findById(Integer id);

    boolean existsById(Integer id);

    Iterable<NutzerIn> findAll();
}
