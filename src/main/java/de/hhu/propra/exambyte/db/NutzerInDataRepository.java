package de.hhu.propra.exambyte.db;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NutzerInDataRepository extends CrudRepository<NutzerInDto, Integer> {

    NutzerInDto save(NutzerInDto nutzerIn);

    void deleteById(Integer id);

    Iterable<NutzerInDto> findAll();

    Optional<NutzerInDto> findById(Integer id);

    boolean existsById(Integer id);

    Optional<NutzerIn> findByUsername(String username);
}
