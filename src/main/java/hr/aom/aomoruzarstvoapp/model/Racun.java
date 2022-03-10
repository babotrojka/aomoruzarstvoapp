package hr.aom.aomoruzarstvoapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Racun")
public class Racun {
    @Id
    private String username;
    private String lozinka;

    public Racun(){}

    public Racun(String username, String lozinka) {
        this.username = username;
        this.lozinka = lozinka;
    }

    public Racun(Prijava prijava) {
        this(prijava.getUsername(), prijava.getPassword());
    }
    public String getUsername() {
        return username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
