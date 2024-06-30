package com.utilities.products.services;

import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.dtos.ProductUpdateRequestDto;
import com.utilities.products.dtos.ProductVariationRequestDto;
import com.utilities.products.dtos.ProductVariationUpdateRequestDto;
import com.utilities.products.models.Product;
import com.utilities.products.models.ProductVariation;
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
    public Product getProductById(UUID id) {
        return null;
    }

    @Override
    public Product createNewProduct(ProductRequestDto requestDto) {
        return null;
    }

    @Override
    public Product updateProductById(UUID id, ProductUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public Product deleteProductById(UUID id) {
        return null;
    }

    @Override
    public List<ProductVariation> getAllProductVariations(UUID id) {
        return null;
    }

    @Override
    public ProductVariation getProductVariationById(UUID id, UUID varId) {
        return null;
    }

    @Override
    public ProductVariation updateProductVariationById(UUID id, UUID varId, ProductVariationUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public ProductVariation deleteProductVariationById(UUID id, UUID varId) {
        return null;
    }

    @Override
    public ProductVariation createNewProductVariation(ProductVariationRequestDto requestDto) {
        return null;
    }
}
