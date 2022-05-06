package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Country;
import it.ss.mymoviesserver.model.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorsDAO extends CrudRepository<Director, Long> {

    List<Director> findByOrderByIdDesc();

    List<Director> findByNameStartsWithIgnoreCaseOrderByIdDesc(String name);

    List<Director> findByNameStartsWithIgnoreCaseAndCountry(String name, Country country);

    List<Director> findByName(String name);

    List<Director> findByNameAndCountryIs(String name, Country country);

    List<Director> findByCountry(Country country);

    Optional<Director> findById(Long id);
}
