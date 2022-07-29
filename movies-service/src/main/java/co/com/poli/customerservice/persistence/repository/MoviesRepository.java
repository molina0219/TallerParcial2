package co.com.poli.customerservice.persistence.repository;

import co.com.poli.customerservice.persistence.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {
    Movies findByNumberID(String numberID);
}