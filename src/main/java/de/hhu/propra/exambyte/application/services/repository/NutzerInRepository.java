package de.hhu.propra.exambyte.application.services.repository;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NutzerInRepository extends CrudRepository<NutzerIn, Integer> {
    NutzerIn save(NutzerIn nutzerIn);

    List<NutzerIn> findAll();

    Optional<NutzerIn> findById(Integer id);

    Optional<NutzerIn> findByUsername(String username);
}
