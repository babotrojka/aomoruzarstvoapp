package hr.aom.aomoruzarstvoapp.service;

import hr.aom.aomoruzarstvoapp.model.Racun;
import hr.aom.aomoruzarstvoapp.repository.RacunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacunService implements IRacunService{

    @Autowired
    private RacunRepository repository;

    @Override
    public Optional<Racun> findById(String username) {
        return repository.findById(username);
    }

    @Override
    public Optional<Racun> findByUsernameAndPassword(Racun racun) {
        return repository.findByUsernameAndPassword(racun.getUsername(), racun.getLozinka());
    }

    @Override
    public List<Racun> findAll() {
        return (List<Racun>) repository.findAll();
    }


}
