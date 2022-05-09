package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Country;
import it.ss.mymoviesserver.model.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorsDAO extends CrudRepository<Director, Long> {

    Optional<Director> findDirectorById(Long id);

    List<Director> findByOrderByIdDesc();

    // Wildcard queries

    List<Director> findByNameStartsWithIgnoreCaseOrderByIdDesc(String name);

    List<Director> findByNameStartsWithIgnoreCaseAndCountryOrderByIdDesc(String name, Country country);

    // Exact queries

    List<Director> findByNameOrderByIdDesc(String name);

    List<Director> findByNameAndCountryOrderByIdDesc(String name, Country country);

    // Additional queries

    List<Director> findByCountryOrderByIdDesc(Country country);
}
