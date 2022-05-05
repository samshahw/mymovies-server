package it.ss.mymoviesserver.dao.impl;

import it.ss.mymoviesserver.dao.DirectorsDAO;
import it.ss.mymoviesserver.model.DirectorView;
import it.ss.mymoviesserver.model.mapper.DirectorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorsDAOimpl implements DirectorsDAO {

    private final JdbcTemplate jdbcTemplate;

    public DirectorsDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DirectorView> findAll() {
        final String query = "SELECT * FROM mymovies.directors_list ORDER BY id DESC";
        return this.jdbcTemplate.query(query, new DirectorRowMapper());
    }

    @Override
    public List<DirectorView> findAllStartWithName(String name) {
        final String query = "SELECT * FROM mymovies.directors_list "
                             + "WHERE LOWER(name) LIKE LOWER(?) ORDER BY id DESC";
        return this.jdbcTemplate.query(query, new DirectorRowMapper(), String.format("%s%%", name));
    }

    @Override
    public DirectorView findById(Long id) {
        final String query = "SELECT * FROM mymovies.directors_list WHERE id = ? ORDER BY id DESC";
        return this.jdbcTemplate.queryForObject(query, new DirectorRowMapper(), id);
    }

    @Override
    public List<DirectorView> findAllByName(String name) {
        final String query = "SELECT * FROM mymovies.directors_list "
                             + "WHERE LOWER(name) LIKE LOWER(?) ORDER BY id DESC";
        return this.jdbcTemplate.query(query, new DirectorRowMapper(), name);
    }
}
