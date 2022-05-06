package it.ss.mymoviesserver.controller;

import it.ss.mymoviesserver.dao.MoviesDAO;
import it.ss.mymoviesserver.model.Movie;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesRestController {

    private final MoviesDAO moviesDAO;

    public MoviesRestController(MoviesDAO moviesDAO) {
        this.moviesDAO = moviesDAO;
    }

    @GetMapping("/movies")
    public List<Movie> findAll(@RequestParam @Nullable String title,
                               @RequestParam @Nullable Boolean exactTitle) {
        // TODO: Implement search with filters for genre, director, country and release date
        if (title != null && title.length() >= 2) {
            if (exactTitle != null && exactTitle) {
                return this.moviesDAO.findByTitle(title);
            }
            return this.moviesDAO.findByTitleStartsWith(title);
        }
        return this.moviesDAO.findByOrderByIdDesc();
    }

    @GetMapping("/movies/{id}")
    public Movie find(@PathVariable Long id) {
        return this.moviesDAO.findById(id).orElse(null);
    }
}
