package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountriesDAO extends CrudRepository<Country, Long> {

    Optional<Country> findCountryByName(String name);
}
