package de.hhu.propra.exambyte.domain.model.test;

import java.time.LocalDateTime;
import java.util.List;

public class ExambyteTest {

    //@Id
    private final Integer id;
    private final String name;
    private final List<Aufgabe> aufgaben;
    private final LocalDateTime startDatum;
    private final LocalDateTime endDatum;

    public ExambyteTest(Integer id, String name, List<Aufgabe> aufgaben, LocalDateTime startDatum, LocalDateTime endDatum) {
        this.id = id;
        this.name = name;
        this.aufgaben = aufgaben;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public Integer getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public List<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public LocalDateTime getStartDatum() {
        return startDatum;
    }

    public LocalDateTime getEndDatum() {
        return endDatum;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", startDatum=" + startDatum +
                ", endDatum=" + endDatum;
    }
}
