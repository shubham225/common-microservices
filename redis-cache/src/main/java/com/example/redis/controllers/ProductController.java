package com.example.redis.controllers;

import com.example.redis.models.Product;
import com.example.redis.services.ProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    @Cacheable(key = "#id", value = "Product")
    public Product getProductById(@PathVariable int id) {
        return productService.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProduct(@PathVariable int id) {
        return productService.delete(id);
    }
}
