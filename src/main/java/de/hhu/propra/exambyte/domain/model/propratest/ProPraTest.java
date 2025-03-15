package de.hhu.propra.exambyte.domain.model.propratest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProPraTest {

    private String name;
    private List<Frage> fragen;
    private LocalDateTime timeDue;

    public ProPraTest(String name) {
        this.name = name;
        this.fragen = new ArrayList<>();
        this.timeDue = LocalDateTime.now().plusWeeks(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFrage(Frage frage) {
        fragen.add(frage);
    }

    public void removeFrage(Frage frage) {
        fragen.remove(frage);
    }

    public void setFrage(int index, Frage frage) {
        fragen.set(index, frage);
    }

    public List<Frage> getFragen() {
        return fragen;
    }

    public LocalDateTime getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(LocalDateTime timeDue) {
        this.timeDue = timeDue;
    }
}
