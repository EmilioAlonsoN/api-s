package nl.h2.api.repository;

import nl.h2.api.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface CodeRepository extends CrudRepository <Users, Long> {

        Users findByCode(String code);
}
