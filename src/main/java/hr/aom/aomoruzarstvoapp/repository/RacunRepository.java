package hr.aom.aomoruzarstvoapp.repository;

import hr.aom.aomoruzarstvoapp.model.Racun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RacunRepository extends CrudRepository<Racun, String> {

    @Query(value = "select * from racun where username = ?1 and lozinka = ?2", nativeQuery = true)
    Optional<Racun> findByUsernameAndPassword(String username, String lozinka);

}
