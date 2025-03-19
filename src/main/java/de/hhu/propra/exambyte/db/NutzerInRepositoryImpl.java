package de.hhu.propra.exambyte.db;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class NutzerInRepositoryImpl implements NutzerInRepository {

    private final NutzerInDataRepository nutzerInDataRepository;

    public NutzerInRepositoryImpl(NutzerInDataRepository nutzerInDataRepository) {
        this.nutzerInDataRepository = nutzerInDataRepository;
    }

    @Override
    public NutzerIn save(NutzerIn nutzerIn) {
        Integer existingDbKey =
                nutzerInDataRepository.findByGithubId(nutzerIn.id()).map(NutzerInDto::id).orElse(null);
        NutzerInDto nutzerInDto = toNutzerInDto(existingDbKey, nutzerIn);
        NutzerInDto saved = nutzerInDataRepository.save(nutzerInDto);
        return toNutzerIn(saved);
    }

    @Override
    public void deleteById(Integer id) {
        nutzerInDataRepository.deleteById(id);
    }

    @Override
    public Optional<NutzerIn> findById(Integer id) {
        return nutzerInDataRepository.findByGithubId(id)
                .map(this::toNutzerIn);
    }

    @Override
    public boolean existsById(Integer id) {
        return nutzerInDataRepository.existsById(id);
    }

    @Override
    public Iterable<NutzerIn> findAll() {
        List<NutzerIn> result = new ArrayList<>();
        for (NutzerInDto nutzerInDto : nutzerInDataRepository.findAll()) {
            result.add(toNutzerIn(nutzerInDto));
        }
        return result;
    }

    private NutzerIn toNutzerIn(NutzerInDto nutzerInDto) {
        return new NutzerIn(nutzerInDto.githubId(), nutzerInDto.username());
    }

    private NutzerInDto toNutzerInDto(Integer existingDbKey, NutzerIn nutzerIn) {
        return new NutzerInDto(existingDbKey, nutzerIn.id(), nutzerIn.username());
    }
}
