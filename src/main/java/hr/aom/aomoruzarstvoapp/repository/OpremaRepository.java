package hr.aom.aomoruzarstvoapp.repository;

import hr.aom.aomoruzarstvoapp.model.Oprema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface OpremaRepository extends CrudRepository<Oprema, Long> {

}
