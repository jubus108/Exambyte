package de.hhu.propra.exambyte.domain.model.test;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class ExambyteTest {

    @Id
    private final int id;
    private final String name;
    private final List<Aufgabe> aufgaben;
    private final LocalDateTime startDatum;
    private final LocalDateTime endDatum;
    private final LocalDateTime ergebnisVeroeffentlichungsDatum;

    public ExambyteTest(int id, String name, List<Aufgabe> aufgaben, LocalDateTime startDatum, LocalDateTime endDatum, LocalDateTime ergebnisVeroeffentlichungsDatum) {
        this.id = id;
        this.name = name;
        this.aufgaben = aufgaben;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.ergebnisVeroeffentlichungsDatum = ergebnisVeroeffentlichungsDatum;
    }

    public ExambyteTest withId(int id) {
        return new ExambyteTest(id, name, aufgaben, startDatum, endDatum, ergebnisVeroeffentlichungsDatum);
    }

    public long id() {
        return id;
    }

    public  String name() {
        return name;
    }

    public List<Aufgabe> aufgaben() {
        return aufgaben;
    }

    public LocalDateTime startDatum() {
        return startDatum;
    }

    public LocalDateTime endDatum() {
        return endDatum;
    }

    public LocalDateTime ergebnisVeroeffentlichungsDatum() {
        return ergebnisVeroeffentlichungsDatum;
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
