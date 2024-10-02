package com.example.redis.services;

import com.example.redis.models.Product;
import com.example.redis.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        log.info("Finding Product from Database");
        return productRepository.findById(id);
    }

    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    public String delete(int id) {
        return productRepository.delete(id);
    }
}
