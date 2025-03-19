package de.hhu.propra.exambyte.db;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NutzerInRepositoryImpl implements NutzerInRepository {

    private final NutzerInDataRepository nutzerInDataRepository;

    public NutzerInRepositoryImpl(NutzerInDataRepository nutzerInDataRepository) {
        this.nutzerInDataRepository = nutzerInDataRepository;
    }

    @Override
    public NutzerIn save(NutzerIn nutzerIn) {
        NutzerInDto nutzerInDto = toNutzerInDto(nutzerIn);
        NutzerInDto saved = nutzerInDataRepository.save(nutzerInDto);
        return toNutzerIn(saved);
    }

    @Override
    public void deleteById(Integer id) {
        nutzerInDataRepository.deleteById(id);
    }

    @Override
    public Iterable<NutzerIn> findAll() {
        List<NutzerIn> result = new ArrayList<>();
        for (NutzerInDto nutzerInDto : nutzerInDataRepository.findAll()) {
            result.add(toNutzerIn(nutzerInDto));
        }
        return result;
    }

    @Override
    public Optional<NutzerIn> findById(Integer id) {
        return nutzerInDataRepository.findById(id)
                .map(this::toNutzerIn);
    }

    @Override
    public boolean existsById(Integer id) {
        return nutzerInDataRepository.existsById(id);
    }

    @Override
    public Optional<NutzerIn> findByUsername(String username) {
        return nutzerInDataRepository.findByUsername(username);
    }

    private NutzerIn toNutzerIn(NutzerInDto nutzerInDto) {
        return new NutzerIn(nutzerInDto.id(), nutzerInDto.username());
    }

    private NutzerInDto toNutzerInDto(NutzerIn nutzerIn) {
        return new NutzerInDto(nutzerIn.id(), nutzerIn.username());
    }
}
