package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.DirectorView;

import java.util.List;

public interface DirectorsDAO {

    List<DirectorView> findAll();

    List<DirectorView> findAllStartWithName(String name, String country);

    List<DirectorView> findAllByName(String name, String country);

    List<DirectorView> findAllByCountry(String country);

    DirectorView findById(Long id);
}
