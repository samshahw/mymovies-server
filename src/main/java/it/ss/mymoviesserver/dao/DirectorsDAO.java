package it.ss.mymoviesserver.dao;

import it.ss.mymoviesserver.model.DirectorView;

import java.util.List;

public interface DirectorsDAO {

    List<DirectorView> findAll();

    List<DirectorView> findAllStartWithName(String name);

    List<DirectorView> findAllByName(String name);

    DirectorView findById(Long id);
}
