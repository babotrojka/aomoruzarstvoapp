package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Oprema;
import hr.aom.aomoruzarstvoapp.model.Zaduzenje;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

public interface IOpremaService {
    List<Oprema> findAll();

    void spremiZaduzenja(Zaduzenje zaduzenje) throws ParseException;

    boolean spremiOpremuIzExcela(InputStream is);
}
