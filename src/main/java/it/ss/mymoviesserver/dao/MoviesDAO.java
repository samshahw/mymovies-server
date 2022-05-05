package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Movie;
import it.ss.mymoviesserver.model.MovieView;

import java.util.List;

public interface MoviesDAO {

    List<MovieView> findAll();

    List<MovieView> findAllStartWithTitle(String title);

    List<MovieView> findAllByTitle(String title);

    List<MovieView> findAllByGenre(String genre);

    List<MovieView> findAllByDirector(String director);

    List<MovieView> findAllByCountry(String country);

    MovieView findById(Long id);

    void saveOrUpdate(Movie movie);

    void delete(Movie movie);

    void deleteById(Long id);
}
