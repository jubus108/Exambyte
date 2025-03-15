package de.propra.exambyte.domain.model.nutzerin;

public abstract class NutzerIn {

    private final int id;
    private String username;
    private String displayName;
    private Rolle rolle;

    public NutzerIn(int id, String username) {
        this.id = id;
        this.username = username;
        this.displayName = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nutzerName) {
        this.username = nutzerName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String nutzerName) {
        this.displayName = nutzerName;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }
}
