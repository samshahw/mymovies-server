package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Country;
import it.ss.mymoviesserver.model.Director;
import it.ss.mymoviesserver.model.Genre;
import it.ss.mymoviesserver.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MoviesDAO extends CrudRepository<Movie, Long> {

    Optional<Movie> findById(Long id);

    List<Movie> findByOrderByIdDesc();

    // Wildcard queries

    List<Movie> findByTitleStartsWithIgnoreCaseOrderByIdDesc(String title);

    List<Movie> findByTitleStartsWithIgnoreCaseAndGenreOrderByIdDesc(String title, Genre genre);

    List<Movie> findByTitleStartsWithIgnoreCaseAndDirectorOrderByIdDesc(String title, Director director);

    List<Movie> findByTitleStartsWithIgnoreCaseAndCountryOrderByIdDesc(String title, Country country);

    List<Movie> findByTitleStartsWithIgnoreCaseAndGenreAndDirectorOrderByIdDesc(String title, Genre genre, Director director);

    List<Movie> findByTitleStartsWithIgnoreCaseAndGenreAndCountryOrderByIdDesc(String title, Genre genre, Country country);

    List<Movie> findByTitleStartsWithIgnoreCaseAndDirectorAndCountryOrderByIdDesc(String title, Director director, Country country);

    List<Movie> findByTitleStartsWithIgnoreCaseAndGenreAndDirectorAndCountryOrderByIdDesc(String title, Genre genre, Director director, Country country);

    // Exact queries

    List<Movie> findByTitleOrderByIdDesc(String title);

    List<Movie> findByTitleAndGenreOrderByIdDesc(String title, Genre genre);

    List<Movie> findByTitleAndDirectorOrderByIdDesc(String title, Director director);

    List<Movie> findByTitleAndCountryOrderByIdDesc(String title, Country country);

    List<Movie> findByTitleAndGenreAndDirectorOrderByIdDesc(String title, Genre genre, Director director);

    List<Movie> findByTitleAndGenreAndCountryOrderByIdDesc(String title, Genre genre, Country country);

    List<Movie> findByTitleAndDirectorAndCountryOrderByIdDesc(String title, Director director, Country country);

    List<Movie> findByTitleAndGenreAndDirectorAndCountryOrderByIdDesc(String title, Genre genre, Director director, Country country);

    // Additional queries

    List<Movie> findByGenreOrderByIdDesc(Genre genre);

    List<Movie> findByDirectorOrderByIdDesc(Director director);

    List<Movie> findByCountryOrderByIdDesc(Country country);
}
