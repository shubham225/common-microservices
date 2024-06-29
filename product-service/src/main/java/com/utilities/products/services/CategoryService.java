package com.utilities.products.services;

import com.utilities.products.dtos.CategoryRequestDto;
import com.utilities.products.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<Category> getAllCategories();

    public Category createNewCategory(CategoryRequestDto requestDto);

    public Category updateCategory(UUID id);

    public Category deleteCategory(UUID id);

    public Category getCategory(UUID id);
}
