package hr.aom.aomoruzarstvoapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Osoba")
public class Osoba {
    @Id
    private String username;
    private String ime;
    private String prezime;
    private Date datum_rodenja;

    public String getUsername() {
        return username;
    }

    public String getIme() {
        return ime;
    }

    public Date getDatum_rodenja() {
        return datum_rodenja;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setDatum_rodenja(Date datum_rodenja) {
        this.datum_rodenja = datum_rodenja;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
