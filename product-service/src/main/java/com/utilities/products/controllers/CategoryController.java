package com.utilities.products.controllers;

import com.utilities.products.dtos.CategoryRequestDto;
import com.utilities.products.dtos.CategoryResponseDto;
import com.utilities.products.models.Category;
import com.utilities.products.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();

        for(Category category : categoryList)




            categoryResponseDtoList.add(new CategoryResponseDto(category));

        return categoryResponseDtoList;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public CategoryResponseDto createNewCategory(@RequestBody CategoryRequestDto requestDto) {
        Category product = categoryService.createNewCategory(requestDto);
        return new CategoryResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public CategoryResponseDto getCategoryDetail(@PathVariable UUID id) {
        Category category = categoryService.getCategory(id);
        return new CategoryResponseDto(category);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}"
    )
    public CategoryResponseDto updateCategory(@PathVariable UUID id) {
        Category category = categoryService.updateCategory(id);
        return new CategoryResponseDto(category);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public CategoryResponseDto deleteCategory(@PathVariable UUID id) {
        Category category = categoryService.deleteCategory(id);
        return new CategoryResponseDto(category);
    }
}
