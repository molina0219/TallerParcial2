package co.com.poli.customerservice.service;

import co.com.poli.customerservice.persistence.entity.Movies;

import java.util.List;

public interface MoviesService {

    void save(Movies movies);
    void delete(Movies movies);
    List<Movies> findAll();
    Movies findById(Long id);
}
