package de.hhu.propra.exambyte.domain.model.test;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class ExambyteTest {

    @Id
    private Integer id;
    private String name;
    private LocalDateTime startDatum;
    private LocalDateTime endDatum;

    public ExambyteTest(Integer id, String name, LocalDateTime startDatum, LocalDateTime endDatum) {
        this.id = id;
        this.name = name;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public Integer getId() {
        return id;
    }

    public  String getName() {
        return name;
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
