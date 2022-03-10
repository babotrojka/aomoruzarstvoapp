package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Posudba;
import hr.aom.aomoruzarstvoapp.repository.PosudbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosudbaService implements IPosudbaService{
    @Autowired
    PosudbaRepository repository;

    @Override
    public void deletePoUsernameIDatum(Posudba posudba) {
        System.out.println(posudba);
        repository.deletePosudbaByUsernameAndDatum_povratka(posudba.getUsername(), posudba.getDatum_povratka());
    }

    @Override
    public List<Posudba> findAll() {
        return (List<Posudba>) repository.findAll();
    }

    @Override
    public void save(Posudba posudba) {
        repository.save(posudba);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void saveALl(List<Posudba> posudbaList) {
        repository.saveAll(posudbaList);
    }
}
