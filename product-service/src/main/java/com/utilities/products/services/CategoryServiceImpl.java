package com.utilities.products.services;

import com.utilities.products.dtos.CategoryRequestDto;
import com.utilities.products.models.Category;
import com.utilities.products.respositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createNewCategory(CategoryRequestDto requestDto) {
        Category category = new Category();

        category.setName(requestDto.getName());
        category.setDescription(requestDto.getDescription());

        category = categoryRepository.save(category);

        return category;
    }

    @Override
    public Category getCategoryById(UUID id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty())
            throw new RuntimeException("Category not Found");

        return categoryOptional.get();
    }

    @Override
    public Category updateCategoryById(UUID id, CategoryRequestDto requestDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty())
            throw new RuntimeException("Category not Found");

        Category category = categoryOptional.get();

        category.setDescription(requestDto.getDescription());

        category = categoryRepository.save(category);

        return category;
    }

    @Override
    public Category deleteCategoryById(UUID id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty())
            throw new RuntimeException("Category not Found");

        Category category = categoryOptional.get();

        categoryRepository.delete(category);

        return category;
    }

}
