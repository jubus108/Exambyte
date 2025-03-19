package de.hhu.propra.exambyte.application.services.repository;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import java.util.Optional;

public interface NutzerInRepository {

    NutzerIn save(NutzerIn nutzerIn);

    void deleteById(Integer id);

    Optional<NutzerIn> findById(Integer id);

    boolean existsById(Integer id);

    Optional<NutzerIn> findByUsername(String username);

    Iterable<NutzerIn> findAll();

}
