package hr.aom.aomoruzarstvoapp.repository;

import hr.aom.aomoruzarstvoapp.model.Posudba;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface PosudbaRepository extends CrudRepository<Posudba, String> {

    @Transactional
    @Modifying
    @Query(value = "delete from posudba where username = ?1 and datumpovratka = ?2", nativeQuery = true)
    void deletePosudbaByUsernameAndDatum_povratka(String username, Date datumPovratka);
}
