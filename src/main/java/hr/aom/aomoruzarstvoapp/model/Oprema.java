package hr.aom.aomoruzarstvoapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Oprema")
public class Oprema {
    @Id
    private String sifra;

    private String grupa_opreme;
    private String proizvodac;
    private String model;
    private String naziv;
    private String jm;
    private Integer kolicina;
    private Integer pobrojano;
    private Integer godina;
    private String napomena;


    public Oprema(String sifra, String grupa_opreme, String proizvodac, String model, String naziv, String jm, Integer kolicina, Integer pobrojano, Integer godina, String napomena) {
        this.sifra = sifra;
        this.grupa_opreme = grupa_opreme;
        this.proizvodac = proizvodac;
        this.model = model;
        this.naziv = naziv;
        this.jm = jm;
        this.kolicina = kolicina;
        this.pobrojano = pobrojano;
        this.godina = godina;
        this.napomena = napomena;
    }

    public Oprema() {
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    public String getSifra() {
        return sifra;
    }

    public Integer getGodina() {
        return godina;
    }

    public String getNaziv() {
        return naziv;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public Integer getPobrojano() {
        return pobrojano;
    }

    public String getGrupa_opreme() {
        return grupa_opreme;
    }

    public String getJm() {
        return jm;
    }

    public String getModel() {
        return model;
    }

    public String getNapomena() {
        return napomena;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setGrupa_opreme(String grupa_opreme) {
        this.grupa_opreme = grupa_opreme;
    }

    public void setJm(String jm) {
        this.jm = jm;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public void setPobrojano(Integer pobrojano) {
        this.pobrojano = pobrojano;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }
}
