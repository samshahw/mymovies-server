package it.ss.mymoviesserver.model;

import javax.persistence.*;

@Entity
@Table(name = "directors", schema = "mymovies")
public class Director {

    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_key")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
