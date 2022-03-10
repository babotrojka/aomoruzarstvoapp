package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Osoba;

import java.util.List;
import java.util.Optional;

public interface IOsobaService {
    Optional<String> dohvatiUsernamePrekoImePrezime(String imePrezime);
    List<Osoba> findAll();
}
