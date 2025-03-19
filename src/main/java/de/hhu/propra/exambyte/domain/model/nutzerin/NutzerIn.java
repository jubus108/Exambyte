package de.hhu.propra.exambyte.domain.model.nutzerin;

import org.springframework.data.annotation.Id;

public class NutzerIn {

    @Id
    private final int id;
    private final String username;

    public NutzerIn(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public NutzerIn withId(int id) {
        return new NutzerIn(id, username);
    }

    public int id() {
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
