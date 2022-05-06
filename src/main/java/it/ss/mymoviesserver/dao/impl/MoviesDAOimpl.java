package it.ss.mymoviesserver.dao.impl;

import it.ss.mymoviesserver.dao.MoviesDAO;
import it.ss.mymoviesserver.model.Movie;
import it.ss.mymoviesserver.model.MovieView;
import it.ss.mymoviesserver.model.mapper.MovieRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesDAOimpl implements MoviesDAO {

    private final JdbcTemplate jdbcTemplate;

    public MoviesDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MovieView> findAll() {
        final String query = "SELECT * FROM mymovies.movies_list";
        return this.jdbcTemplate.query(query, new MovieRowMapper());
    }

    @Override
    public List<MovieView> findAllStartWithTitle(String title) {
        final String query = "SELECT * FROM mymovies.movies_list WHERE LOWER(title) LIKE LOWER(?)";
        return this.jdbcTemplate.query(query, new MovieRowMapper(), String.format("%s%%", title));
    }

    @Override
    public List<MovieView> findAllByTitle(String title) {
        final String query = "SELECT * FROM mymovies.movies_list WHERE LOWER(title) LIKE LOWER(?)";
        return this.jdbcTemplate.query(query, new MovieRowMapper(), title);
    }

    @Override
    public List<MovieView> findAllByGenre(String genre) {
        final String query = "SELECT * FROM mymovies.movies_list WHERE LOWER(genre) LIKE LOWER(?)";
        return this.jdbcTemplate.query(query, new MovieRowMapper(), genre);
    }

    @Override
    public List<MovieView> findAllByDirector(String director) {
        final String query = "SELECT * FROM mymovies.movies_list "
                             + "WHERE LOWER(director) LIKE LOWER(?)";
        return this.jdbcTemplate.query(query, new MovieRowMapper(), director);
    }

    @Override
    public List<MovieView> findAllByCountry(String country) {
        final String query = "SELECT * FROM mymovies.movies_list "
                             + "WHERE LOWER(country) LIKE LOWER(?)";
        return this.jdbcTemplate.query(query, new MovieRowMapper(), country);
    }

    @Override
    public MovieView findById(Long id) {
        final String query = "SELECT * FROM mymovies.movies_list WHERE id = ?";
        return this.jdbcTemplate.queryForObject(query, new MovieRowMapper(), id);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        if (movie.getId() == null) {
            final String query = "INSERT INTO mymovies.movie (title, genre_key, director_key, "
                                 + "country_key, release_date) VALUES (?, ?, ?, ?, ?)";
            this.jdbcTemplate.update(query, movie.getTitle(), movie.getGenreKey(),
                                     movie.getDirectorKey(), movie.getCountryKey(),
                                     movie.getReleaseDate());
        } else {
            final String query = "UPDATE mymovies.movie SET title=?, genre_key=?, director_key=?, "
                                 + "country_key=?, release_date=? WHERE id=?";
            this.jdbcTemplate.update(query, movie.getTitle(), movie.getGenreKey(),
                                     movie.getDirectorKey(), movie.getCountryKey(),
                                     movie.getReleaseDate(), movie.getId());
        }
    }

    @Override
    public void delete(Movie movie) {
        deleteById(movie.getId());
    }

    @Override
    public void deleteById(Long id) {
        final String query = "DELETE FROM mymovies.movie WHERE id = ?";
        this.jdbcTemplate.update(query, id);
    }
}
