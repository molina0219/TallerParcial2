package co.com.poli.store.showtimeservice.persistence.repository;

import co.com.poli.store.showtimeservice.persistence.entity.Category;
import co.com.poli.store.showtimeservice.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}
