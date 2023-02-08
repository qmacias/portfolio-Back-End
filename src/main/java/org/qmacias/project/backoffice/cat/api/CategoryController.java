package org.qmacias.project.backoffice.cat.api;

import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.backoffice.cat.application.CategoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
final class CategoryController {

    private final CategoryService service;

    CategoryController(final CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> allCategories() {
        return service.all();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable final Long id) {
        return service.get(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody final Category category) {
        return service.add(category);
    }

    @DeleteMapping("/{id}")
    public void removeCategory(@PathVariable final Long id) {
        service.remove(id);
    }

}
