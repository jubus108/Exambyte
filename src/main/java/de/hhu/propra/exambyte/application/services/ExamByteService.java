package de.hhu.propra.exambyte.application.services;

import de.hhu.propra.exambyte.application.services.repository.NutzerInRepository;

import de.hhu.propra.exambyte.domain.model.nutzerin.NutzerIn;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ExamByteService {

    private final NutzerInRepository nutzerInRepository;
    // private final TestRepository testRepository;

    public ExamByteService(NutzerInRepository nutzerInRepository) {
        this.nutzerInRepository = nutzerInRepository;
    }

    public NutzerIn nutzerInHinzufuegen(Integer id, String username) {
        NutzerIn nutzerIn = new NutzerIn(id, username);
        return nutzerInRepository.save(nutzerIn);
    }

    public boolean isNutzerInVorhanden(Integer id) {
        return false;
    }
}
