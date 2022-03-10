package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Posudba;

import java.util.List;

public interface IPosudbaService {
    void save(Posudba posudba);
    List<Posudba> findAll();
    void deletePoUsernameIDatum(Posudba posudba);
    void deleteAll();
    void saveALl(List<Posudba> posudbaList);
}
