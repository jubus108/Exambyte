package de.hhu.propra.exambyte.domain.model.nutzerin;

public class NutzerIn {

    private final Integer id;

    private final String username;

    public NutzerIn(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer id() {
        return id;
    }

    public String username() {
        return username;
    }

    @Override
    public String toString() {
        return "Nutzer:in{" +
                "githubId=" + id +
                ", username='" + username + "'" +
                "}";
    }
}
