package it.ss.mymoviesserver.controller;

import it.ss.mymoviesserver.dao.DirectorsDAO;
import it.ss.mymoviesserver.model.DirectorView;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorsRestController {

    private final DirectorsDAO directorsDAO;

    public DirectorsRestController(DirectorsDAO directorsDAO) {
        this.directorsDAO = directorsDAO;
    }

    @GetMapping("/directors")
    public List<DirectorView> findAll(@RequestParam @Nullable String name,
                                      @RequestParam @Nullable Boolean exactName,
                                      @RequestParam @Nullable String country) {
        if (name != null && name.length() >= 2) {
            if (exactName != null && exactName) {
                return this.directorsDAO.findAllByName(name, country);
            }
            return this.directorsDAO.findAllStartWithName(name, country);
        } else if (country != null && !country.isEmpty()) {
            return this.directorsDAO.findAllByCountry(country);
        }
        return this.directorsDAO.findAll();
    }

    @GetMapping("/directors/{id}")
    public DirectorView findById(@PathVariable Long id) {
        return this.directorsDAO.findById(id);
    }
}
