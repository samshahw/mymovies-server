package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersDAO extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
