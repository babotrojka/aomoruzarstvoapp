package hr.aom.aomoruzarstvoapp.model;

import java.util.*;
import java.util.stream.Collectors;

public class PrikazPosudbe {
    private String username;
    private String ime;
    private String prezime;
    private Date datumPovrata;

    private Map<String, Integer> posudenaOprema = new HashMap<>();

    public PrikazPosudbe(String username, String ime, String prezime, Date datumPovrata) {
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.datumPovrata = datumPovrata;
    }


    public void dodajOpremu(String naziv, Integer kolicina) {
        posudenaOprema.put(naziv, kolicina);
    }

    public boolean istaPosudba(String username, Date datumPovrata) {
        return this.username.equals(username) &&
                this.datumPovrata.equals(datumPovrata);
    }

    /**
     * Na temelju liste posudbi iz baze podataka radi listu prikaza tih posudbi na web stranici
     * @param posudbaList lista posudbi iz baze
     * @param osobe lista osoba iz baze
     * @param opremaList lista opreme iz baze
     * @return Listu za prikaz posudbi
     */
    public static List<PrikazPosudbe> dohvatiPrikazPosudbi(List<Posudba> posudbaList, List<Osoba> osobe, List<Oprema> opremaList) {
        Map<String, Osoba> mapaOsoba = osobe.stream()
                .collect(Collectors.toMap(Osoba::getUsername, osoba -> osoba));

        Map<String, String> mapaOpreme = opremaList.stream()
                .collect(Collectors.toMap(Oprema::getSifra, Oprema::getNaziv));

        List<PrikazPosudbe> prikazPosudbeList = new ArrayList<>();

        boolean dodano;
        for(Posudba posudba : posudbaList) {
            dodano = false;
            for(PrikazPosudbe prikazPosudbe : prikazPosudbeList)
                if(prikazPosudbe.istaPosudba(posudba.getUsername(), posudba.getDatum_povratka())) {
                    prikazPosudbe.dodajOpremu(mapaOpreme.get(posudba.getSifra()), posudba.getKolicina());
                    dodano = true;
                    break;
                }


            if(!dodano) {
                PrikazPosudbe noviPrikaz = new PrikazPosudbe(
                        posudba.getUsername(),
                        mapaOsoba.get(posudba.getUsername()).getIme(),
                        mapaOsoba.get(posudba.getUsername()).getPrezime(),
                        posudba.getDatum_povratka()
                );
                noviPrikaz.dodajOpremu(mapaOpreme.get(posudba.getSifra()), posudba.getKolicina());
                prikazPosudbeList.add(noviPrikaz);
            }
        }

        return prikazPosudbeList;
    }


    public String getPrezime() {
        return prezime;
    }

    public String getIme() {
        return ime;
    }

    public Date getDatumPovrata() {
        return datumPovrata;
    }

    public Map<String, Integer> getPosudenaOprema() {
        return posudenaOprema;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "PrikazPosudbe{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumPovrata=" + datumPovrata +
                ", posudenaOprema=" + posudenaOprema +
                '}';
    }
}
