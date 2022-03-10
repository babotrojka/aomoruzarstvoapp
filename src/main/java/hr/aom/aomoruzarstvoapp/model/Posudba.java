package hr.aom.aomoruzarstvoapp.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(Posudba.PosudbaId.class)
@Table(name = "Posudba")
public class Posudba {

    @Id
    private String username;
    @Id
    private String sifra;
    @Id
    @Column(name="datumposudbe")
    private Date datum_posudbe;
    @Id
    @Column(name = "datumpovratka")
    private Date datum_povratka;
    @Id
    private Integer kolicina;

    public Posudba() {}

    public Posudba(String username, String sifra, Date datumPovratka, Integer kolicina) {
        this.username = username;
        this.sifra = sifra;
        this.datum_povratka = datumPovratka;
        this.kolicina = kolicina;

        datum_posudbe = new Date(System.currentTimeMillis());
    }

    @Override
    public int hashCode() {
        return username.hashCode() + datum_povratka.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Posudba))
            return false;

        Posudba that = (Posudba) obj;

        return this.username.equals(that.username) && this.datum_povratka.equals(that.datum_povratka);
    }

    @Override
    public String toString() {
        return "Posudba{" +
                "username='" + username + '\'' +
                ", sifra='" + sifra + '\'' +
                ", datum_posudbe=" + datum_posudbe +
                ", datum_povratka=" + datum_povratka +
                ", kolicina=" + kolicina +
                '}';
    }

    // equals() and hashCode()

    public Posudba(String username, Date datum_povratka) {
        this(username, null, datum_povratka, null);
    }

    public String getUsername() {
        return username;
    }


    public Integer getKolicina() {
        return kolicina;
    }

    public String getSifra() {
        return sifra;
    }

    public Date getDatum_posudbe() {
        return datum_posudbe;
    }

    public Date getDatum_povratka() {
        return datum_povratka;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setDatum_posudbe(Date datum_posudbe) {
        this.datum_posudbe = datum_posudbe;
    }

    public void setDatum_povratka(Date datum_povratka) {
        this.datum_povratka = datum_povratka;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    static class PosudbaId implements Serializable {
        private String username;
        private String sifra;
        @Column(name="datumposudbe")
        private Date datum_posudbe;
        @Column(name = "datumpovratka")
        private Date datum_povratka;
        private Integer kolicina;

        // default constructor
        public PosudbaId() {}

        public PosudbaId(String username, String sifra, Date datum_posudbe, Date datum_povratka, Integer kolicina) {
            this.username = username;
            this.sifra = sifra;
            this.datum_posudbe = datum_posudbe;
            this.datum_povratka = datum_povratka;
            this.kolicina = kolicina;
        }


    }
}

