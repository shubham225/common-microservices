package com.utilities.products.controllers;

import com.utilities.products.dtos.ProductResponseDto;
import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.models.Product;
import com.utilities.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<ProductResponseDto> getAllProductDetails(@RequestParam(defaultValue = "asc") String sort,
                                                         @RequestParam(defaultValue = "") String limit,
                                                         @RequestParam(defaultValue = "1") String offset) {
        List<Product> productList = productService.getAllProducts(sort, limit, offset);
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        for(Product product : productList)
            productResponseDtoList.add(new ProductResponseDto(product));

        return productResponseDtoList;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ProductResponseDto createNewProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = productService.createNewProduct(requestDto);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public ProductResponseDto getProductDetail(@PathVariable UUID id) {
        Product product = productService.getProductDetail(id);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}"
    )
    public ProductResponseDto updateProduct(@PathVariable UUID id) {
        Product product = productService.updateProduct(id);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public ProductResponseDto deleteProduct(@PathVariable UUID id) {
        Product product = productService.deleteProduct(id);
        return new ProductResponseDto(product);
    }
}
