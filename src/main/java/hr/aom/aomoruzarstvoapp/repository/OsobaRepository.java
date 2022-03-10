package hr.aom.aomoruzarstvoapp.repository;

import hr.aom.aomoruzarstvoapp.model.Osoba;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OsobaRepository extends CrudRepository<Osoba, String> {

    @Query(value = "SELECT username FROM osoba where ime = ?1 AND prezime = ?2", nativeQuery = true)
    Optional<String> dohvatiUsernamePrekoImePrezime(String ime, String prezime);

}
