package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Osoba;
import hr.aom.aomoruzarstvoapp.repository.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsobaService implements IOsobaService{

    @Autowired
    OsobaRepository repository;

    @Override
    public List<Osoba> findAll() {
        return (List<Osoba>) repository.findAll();
    }

    @Override
    public Optional<String> dohvatiUsernamePrekoImePrezime(String imePrezime) {
        String ime = imePrezime.split(" ")[0].strip();
        String prezime = imePrezime.split(" ")[1].strip();
        return repository.dohvatiUsernamePrekoImePrezime(ime, prezime);
    }
}
