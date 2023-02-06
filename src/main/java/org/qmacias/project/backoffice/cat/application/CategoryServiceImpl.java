package org.qmacias.project.backoffice.cat.application;

import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.backoffice.cat.domain.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> all() {
        return repository.findAll();
    }

    @Override
    public Category get(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category add(final Category category) {
        return repository.save(category);
    }

    @Override
    public void remove(final Long id) {
        repository.deleteById(id);
    }

}
