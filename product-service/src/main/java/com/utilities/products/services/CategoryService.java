package com.utilities.products.services;

import com.utilities.products.dtos.CategoryRequestDto;
import com.utilities.products.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<Category> getAllCategories();

    public Category createNewCategory(CategoryRequestDto requestDto);

    public Category getCategoryById(UUID id);

    public Category updateCategoryById(UUID id, CategoryRequestDto requestDto);

    public Category deleteCategoryById(UUID id);
}
