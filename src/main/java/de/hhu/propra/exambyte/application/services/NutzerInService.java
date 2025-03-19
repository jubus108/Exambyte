package de.hhu.propra.exambyte.application.services;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;
import de.hhu.propra.exambyte.db.NutzerInDto;
import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutzerInService {

    private final NutzerInRepository nutzerInRepository;

    public NutzerInService(NutzerInRepository nutzerInRepository) {
        this.nutzerInRepository = nutzerInRepository;
    }

    public NutzerIn save(int id, String username) {
        return nutzerInRepository.save(new NutzerIn(id, username));
    }

    public void delete(NutzerIn nutzerIn) {
        nutzerInRepository.deleteById(nutzerIn.id());
    }

    public boolean isVorhanden(Integer id) {
        return nutzerInRepository.existsById(id);
    }

    public Iterable<NutzerInDto> alleNutzerInnen() {
        return nutzerInRepository.findAll();
    }
}
