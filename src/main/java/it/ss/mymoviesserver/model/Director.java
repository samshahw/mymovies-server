package it.ss.mymoviesserver.model;

public class Director {

    private Long id;
    private String name;
    private Integer country_key;

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

    public Integer getCountry_key() {
        return country_key;
    }

    public void setCountry_key(Integer country_key) {
        this.country_key = country_key;
    }
}
