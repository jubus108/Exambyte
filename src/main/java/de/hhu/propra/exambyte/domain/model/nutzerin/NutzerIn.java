package de.hhu.propra.exambyte.domain.model.nutzerin;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

public class NutzerIn {

    @Id
    private final Long id;
    private final String username;

    public NutzerIn(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public NutzerIn withId(Long id) {
        return new NutzerIn(id, username);
    }

    public Long id() {
        return id;
    }

    public String username() {
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
