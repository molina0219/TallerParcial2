package co.com.poli.store.showtimeservice.service;

import co.com.poli.store.showtimeservice.persistence.entity.Category;
import co.com.poli.store.showtimeservice.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public void save(Category category) {
        repository.save(category);
    }

}
