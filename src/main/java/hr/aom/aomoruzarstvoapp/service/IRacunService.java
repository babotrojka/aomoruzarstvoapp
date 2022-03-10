package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Racun;

import java.util.List;
import java.util.Optional;

public interface IRacunService {
    Optional<Racun> findById(String username);
    Optional<Racun> findByUsernameAndPassword(Racun racun);
    List<Racun> findAll();
}
