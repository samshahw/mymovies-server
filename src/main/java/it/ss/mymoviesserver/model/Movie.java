package it.ss.mymoviesserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Movie {

    private Long id;
    private String title;
    private Integer genre_key;
    private Integer director_key;
    private Integer country_key;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGenre_key() {
        return genre_key;
    }

    public void setGenre_key(Integer genre_key) {
        this.genre_key = genre_key;
    }

    public Integer getDirector_key() {
        return director_key;
    }

    public void setDirector_key(Integer director_key) {
        this.director_key = director_key;
    }

    public Integer getCountry_key() {
        return country_key;
    }

    public void setCountry_key(Integer country_key) {
        this.country_key = country_key;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
