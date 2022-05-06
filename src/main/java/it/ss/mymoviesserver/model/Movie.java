package it.ss.mymoviesserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Movie {

    private Long id;
    private String title;
    private Integer genreKey;
    private Integer directorKey;
    private Integer countryKey;
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

    public Integer getGenreKey() {
        return genreKey;
    }

    public void setGenreKey(Integer genreKey) {
        this.genreKey = genreKey;
    }

    public Integer getDirectorKey() {
        return directorKey;
    }

    public void setDirectorKey(Integer directorKey) {
        this.directorKey = directorKey;
    }

    public Integer getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(Integer countryKey) {
        this.countryKey = countryKey;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
