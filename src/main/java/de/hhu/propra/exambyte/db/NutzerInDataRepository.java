package de.hhu.propra.exambyte.db;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutzerInDataRepository extends CrudRepository<NutzerInDto, Integer> {
    NutzerInDto save(NutzerInDto nutzerInDto);

    void deleteById(Integer id);

    Optional<NutzerInDto> findById(Integer id);

    Iterable<NutzerInDto> findAll();

    boolean existsById(Integer id);

    Optional<NutzerInDto> findByGithubId(Integer id);
}
