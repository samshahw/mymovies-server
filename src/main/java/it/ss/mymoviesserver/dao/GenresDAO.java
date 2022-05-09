package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenresDAO extends CrudRepository<Genre, Long> {

    Optional<Genre> findGenreById(Long id);

    Optional<Genre> findGenreByName(String name);
}
