package de.hhu.propra.exambyte.domain.model.nutzerin;

import org.springframework.data.annotation.Id;

public class NutzerIn {

    @Id
    private final Integer id;
    private final String username;

    public NutzerIn(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Nutzer:in{" +
                "id=" + id +
                ", username='" + username + "'" +
                "}";
    }
}
