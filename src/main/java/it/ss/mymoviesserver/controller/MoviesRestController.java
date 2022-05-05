package it.ss.mymoviesserver.controller;

import it.ss.mymoviesserver.dao.MoviesDAO;
import it.ss.mymoviesserver.model.MovieView;
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
    public List<MovieView> findAll(@RequestParam @Nullable String title,
                                   @RequestParam @Nullable Boolean exactTitle) {
        if (title != null && title.length() >= 2) {
            if (exactTitle != null && exactTitle) {
                return this.moviesDAO.findAllByTitle(title);
            }
            return this.moviesDAO.findAllStartWithTitle(title);
        }
        return this.moviesDAO.findAll();
    }

    @GetMapping("/movies/{id}")
    public MovieView find(@PathVariable Long id) {
        return this.moviesDAO.findById(id);
    }
}
