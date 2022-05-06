package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MoviesDAO extends CrudRepository<Movie, Long> {

    List<Movie> findByOrderByIdDesc();

    List<Movie> findByTitleStartsWith(String title);

    List<Movie> findByTitle(String title);

    List<Movie> findByGenre(String genre);

    List<Movie> findByDirector(String director);

    List<Movie> findByCountry(String country);

    Optional<Movie> findById(Long id);
}
