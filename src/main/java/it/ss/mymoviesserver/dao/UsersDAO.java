package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.User;

public interface UsersDAO {

    User findByUsername(String username);
}
