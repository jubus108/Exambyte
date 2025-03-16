package de.hhu.propra.exambyte.domain.model.test;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Test {

    @Id
    private Integer id;
    private String testName;
    private LocalDateTime startDatum;
    private LocalDateTime endDatum;

    public Test(Integer id, String testname, LocalDateTime startDatum, LocalDateTime endDatum) {
        this.id = id;
        this.testName = testName;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public Integer getId() {
        return id;
    }

    public  String getTestName() {
        return testName;
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
                ", name='" + testName + "'" +
                ", startDatum=" + startDatum +
                ", endDatum=" + endDatum;
    }
}
