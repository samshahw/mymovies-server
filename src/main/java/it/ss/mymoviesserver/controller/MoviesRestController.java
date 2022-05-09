package it.ss.mymoviesserver.controller;

import it.ss.mymoviesserver.dao.CountriesDAO;
import it.ss.mymoviesserver.dao.DirectorsDAO;
import it.ss.mymoviesserver.dao.GenresDAO;
import it.ss.mymoviesserver.dao.MoviesDAO;
import it.ss.mymoviesserver.model.Country;
import it.ss.mymoviesserver.model.Director;
import it.ss.mymoviesserver.model.Genre;
import it.ss.mymoviesserver.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesRestController {

    private final GenresDAO genresDAO;
    private final DirectorsDAO directorsDAO;
    private final CountriesDAO countriesDAO;
    private final MoviesDAO moviesDAO;

    @Autowired
    public MoviesRestController(GenresDAO genresDAO, DirectorsDAO directorsDAO,
                                CountriesDAO countriesDAO, MoviesDAO moviesDAO) {
        this.genresDAO = genresDAO;
        this.directorsDAO = directorsDAO;
        this.countriesDAO = countriesDAO;
        this.moviesDAO = moviesDAO;
    }

    @GetMapping("/movies")
    public List<Movie> findByAttr(@RequestParam @Nullable String title,
                                  @RequestParam @Nullable Boolean exactTitle,
                                  @RequestParam @Nullable String genreName,
                                  @RequestParam @Nullable Long directorId,
                                  @RequestParam @Nullable String countryName) {
        // Initialize params
        final Genre genre = this.genresDAO.findGenreByName(genreName).orElse(null);
        Director director = null;
        if (directorId != null) {
            director = this.directorsDAO.findDirectorById(directorId).orElse(null);
        }
        final Country country = this.countriesDAO.findCountryByName(countryName).orElse(null);
        boolean exactQuery = exactTitle != null && exactTitle;
        // Return data
        if (title != null && !title.isEmpty()) {
            if (genre != null && director != null && country != null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndGenreAndDirectorAndCountryOrderByIdDesc(title, genre, director, country);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndGenreAndDirectorAndCountryOrderByIdDesc(title, genre, director, country);
                }
            } else if (genre != null && director != null && country == null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndGenreAndDirectorOrderByIdDesc(title, genre, director);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndGenreAndDirectorOrderByIdDesc(title, genre, director);
                }
            } else if (genre != null && director == null && country != null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndGenreAndCountryOrderByIdDesc(title, genre, country);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndGenreAndCountryOrderByIdDesc(title, genre, country);
                }
            } else if (genre == null && director != null && country != null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndDirectorAndCountryOrderByIdDesc(title, director, country);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndDirectorAndCountryOrderByIdDesc(title, director, country);
                }
            } else if (genre != null && director == null && country == null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndGenreOrderByIdDesc(title, genre);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndGenreOrderByIdDesc(title, genre);
                }
            } else if (genre == null && director != null && country == null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndDirectorOrderByIdDesc(title, director);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndDirectorOrderByIdDesc(title, director);
                }
            } else if (genre == null && director == null && country != null) {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleAndCountryOrderByIdDesc(title, country);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseAndCountryOrderByIdDesc(title, country);
                }
            } else {
                if (exactQuery) {
                    return this.moviesDAO.findByTitleOrderByIdDesc(title);
                } else {
                    return this.moviesDAO.findByTitleStartsWithIgnoreCaseOrderByIdDesc(title);
                }
            }
        }
        return this.moviesDAO.findByOrderByIdDesc();
    }

    @GetMapping("/movies/genre/{id}")
    public List<Movie> findByGenre(@PathVariable Long id) {
        final Genre genre = this.genresDAO.findGenreById(id).orElse(null);
        return this.moviesDAO.findByGenreOrderByIdDesc(genre);
    }

    @GetMapping("/movies/director/{id}")
    public List<Movie> findByDirector(@PathVariable Long id) {
        final Director director = this.directorsDAO.findDirectorById(id).orElse(null);
        return this.moviesDAO.findByDirectorOrderByIdDesc(director);
    }

    @GetMapping("/movies/country/{id}")
    public List<Movie> findByCountry(@PathVariable Long id) {
        final Country country = this.countriesDAO.findCountryById(id).orElse(null);
        return this.moviesDAO.findByCountryOrderByIdDesc(country);
    }

    @GetMapping("/movies/{id}")
    public Movie findById(@PathVariable Long id) {
        return this.moviesDAO.findById(id).orElse(null);
    }
}
