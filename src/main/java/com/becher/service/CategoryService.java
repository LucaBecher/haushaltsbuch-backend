package com.becher.service;

import com.becher.model.data.Category;
import com.becher.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category createCategory(Category category) {
        if(category.getParentId() == null) {
            throw new IllegalArgumentException("Cannot create category without parent");
        }

        if(categoryRepository.findByNameIgnoreCase(category.getName()) != null) {
            throw new IllegalArgumentException("Category already exists");
        }

        return categoryRepository.save(category);
    }

    public Category getRootCategory(Category category) {
        Category parentCategory = categoryRepository.findById(category.getParentId()).orElse(null);

        while(!Objects.equals(category.getParentId(), parentCategory.getId())) {
            category = parentCategory;
            parentCategory = categoryRepository.findById(category.getParentId()).orElse(null);
        }

        return category;
    }
}
