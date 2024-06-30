package com.utilities.products.services;

import com.utilities.products.dtos.CategoryRequestDto;
import com.utilities.products.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category createNewCategory(CategoryRequestDto requestDto) {
        return null;
    }

    @Override
    public Category getCategoryById(UUID id) {
        return null;
    }

    @Override
    public Category updateCategoryById(UUID id, CategoryRequestDto requestDto) {
        return null;
    }

    @Override
    public Category deleteCategoryById(UUID id) {
        return null;
    }

}
