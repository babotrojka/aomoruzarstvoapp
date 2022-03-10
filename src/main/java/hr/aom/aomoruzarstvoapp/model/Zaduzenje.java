package hr.aom.aomoruzarstvoapp.model;

import java.util.Arrays;
import java.util.Date;

public class Zaduzenje {

    private String username;
    private String[] opremaC;
    private String datumPovrata;
    private int kolicina;

    public String getUsername() {
        return username;
    }

    public void setDatumPovrata(String datumPovrata) {
        this.datumPovrata = datumPovrata;
    }

    public int getKolicina() {
        return kolicina;
    }

    public String getDatumPovrata() {
        return datumPovrata;
    }

    public String[] getOpremaC() {
        return opremaC;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOpremaC(String[] opremaC) {
        this.opremaC = opremaC;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        return "Zaduzenje{" +
                "username='" + username + '\'' +
                ", opremaC=" + Arrays.toString(opremaC) +
                ", datumPovrata='" + datumPovrata + '\'' +
                ", kolicina=" + kolicina +
                '}';
    }
}
