package com.utilities.products.services;

import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> getAllProducts(String sort, String limit, String offset);

    public Product getProductDetail(UUID id);

    public Product createNewProduct(ProductRequestDto requestDto);

    public Product deleteProduct(UUID id);

    public Product updateProduct(UUID id);
}
