package co.com.poli.store.showtimeservice.controller;

import co.com.poli.store.showtimeservice.helpers.Response;
import co.com.poli.store.showtimeservice.helpers.ResponseBuild;
import co.com.poli.store.showtimeservice.persistence.entity.Category;
import co.com.poli.store.showtimeservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@RequestBody Category category) {
        service.save(category);
        return builder.success(category);
    }
}
