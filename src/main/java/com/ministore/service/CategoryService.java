
package com.ministore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ministore.entity.Category;
import com.ministore.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    public List<Category> getAllCategoriesWithProducts() {
        return categoryRepository.findAllWithProducts();
    }
}
