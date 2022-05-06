package it.ss.mymoviesserver.controller;

import it.ss.mymoviesserver.dao.CountriesDAO;
import it.ss.mymoviesserver.dao.DirectorsDAO;
import it.ss.mymoviesserver.model.Country;
import it.ss.mymoviesserver.model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorsRestController {

    private final DirectorsDAO directorsDAO;
    private final CountriesDAO countriesDAO;

    @Autowired
    public DirectorsRestController(DirectorsDAO directorsDAO, CountriesDAO countriesDAO) {
        this.directorsDAO = directorsDAO;
        this.countriesDAO = countriesDAO;
    }

    @GetMapping("/directors")
    public List<Director> findAll(@RequestParam @Nullable String name,
                                  @RequestParam @Nullable Boolean exactName,
                                  @RequestParam @Nullable String countryName) {
        final Country country = this.countriesDAO.findCountryByName(countryName).orElse(null);
        if (name != null && name.length() > 1) {
            if (exactName != null && exactName) {
                if (country != null) {
                    return this.directorsDAO.findByNameAndCountryIs(name, country);
                } else {
                    return this.directorsDAO.findByName(name);
                }
            } else {
                if (country != null) {
                    return this.directorsDAO.findByNameStartsWithIgnoreCaseAndCountry(name,
                                                                                      country);
                } else {
                    return this.directorsDAO.findByNameStartsWithIgnoreCaseOrderByIdDesc(name);
                }
            }
        } else if (country != null) {
            return this.directorsDAO.findByCountry(country);
        } else {
            return this.directorsDAO.findByOrderByIdDesc();
        }
    }

    @GetMapping("/directors/{id}")
    public Director findById(@PathVariable Long id) {
        return this.directorsDAO.findById(id).orElse(null);
    }
}
