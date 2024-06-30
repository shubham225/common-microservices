package com.utilities.products.services;

import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.dtos.ProductUpdateRequestDto;
import com.utilities.products.dtos.ProductVariationRequestDto;
import com.utilities.products.dtos.ProductVariationUpdateRequestDto;
import com.utilities.products.models.Product;
import com.utilities.products.models.ProductVariation;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> getAllProducts(String sort, String limit, String offset);

    public Product getProductById(UUID id);

    public Product createNewProduct(ProductRequestDto requestDto);

    public Product updateProductById(UUID id, ProductUpdateRequestDto requestDto);

    public Product deleteProductById(UUID id);

    public List<ProductVariation> getAllProductVariations(UUID id);

    public ProductVariation getProductVariationById(UUID id, UUID varId);

    public ProductVariation updateProductVariationById(UUID id, UUID varId, ProductVariationUpdateRequestDto requestDto);

    public ProductVariation deleteProductVariationById(UUID id, UUID varId);

    public ProductVariation createNewProductVariation(ProductVariationRequestDto requestDto);
}
