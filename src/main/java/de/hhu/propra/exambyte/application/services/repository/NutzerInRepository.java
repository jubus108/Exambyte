package de.hhu.propra.exambyte.application.services.repository;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NutzerInRepository {

    NutzerIn save(NutzerIn nutzerIn);

    void deleteById(int id);

    List<NutzerIn> findAll();

    Optional<NutzerIn> findById(int id);

    boolean existsById(int id);

    Optional<NutzerIn> findByUsername(String username);

}
