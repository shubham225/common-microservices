package com.utilities.products.services;

import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> getAllProducts(String sort, String limit, String offset) {
        return null;
    }

    @Override
    public Product getProductDetail(UUID id) {
        return null;
    }

    @Override
    public Product createNewProduct(ProductRequestDto requestDto) {
        return null;
    }

    @Override
    public Product deleteProduct(UUID id) {
        return null;
    }

    @Override
    public Product updateProduct(UUID id) {
        return null;
    }
}
