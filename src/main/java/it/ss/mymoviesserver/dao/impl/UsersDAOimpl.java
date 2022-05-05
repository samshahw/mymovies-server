package it.ss.mymoviesserver.dao.impl;

import it.ss.mymoviesserver.dao.UsersDAO;
import it.ss.mymoviesserver.model.User;
import it.ss.mymoviesserver.model.mapper.UserRowMapper;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOimpl implements UsersDAO {

    private final JdbcTemplate jdbcTemplate;

    public UsersDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        final String query = "SELECT * FROM mymovies.user WHERE username = ?";
        try {
            return this.jdbcTemplate.queryForObject(query, new UserRowMapper(), username);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
