package com.utilities.products.services;

import com.utilities.products.dtos.ProductRequestDto;
import com.utilities.products.dtos.ProductUpdateRequestDto;
import com.utilities.products.dtos.ProductVariationRequestDto;
import com.utilities.products.dtos.ProductVariationUpdateRequestDto;
import com.utilities.products.enums.StockStatus;
import com.utilities.products.models.Product;
import com.utilities.products.models.ProductVariation;
import com.utilities.products.respositories.ProductRepository;
import com.utilities.products.respositories.ProductVariationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductVariationRepository productVariationRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductVariationRepository productVariationRepository) {
        this.productRepository = productRepository;
        this.productVariationRepository = productVariationRepository;
    }

    @Override
    public List<Product> getAllProducts(String sort, String sortBy, int limit, int offset) {
        Sort.Direction direction = (sort.equalsIgnoreCase("desc")) ?
                                        Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sorting = Sort.by(direction, sortBy);

        Pageable pagination = PageRequest.of(offset, limit, sorting);

        Page<Product> products = productRepository.findAll(pagination);

        return products.stream().toList();
    }

    @Override
    public Product getProductById(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty())
            throw new RuntimeException("Product Not Found");

        return productOptional.orElse(null);
    }

    @Override
    public Product createNewProduct(ProductRequestDto requestDto) {
        Product product = new Product();

        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setCategories(requestDto.getCategories());
        product.setSeller(requestDto.getSeller());

        List<ProductVariation> variations = new ArrayList<>();
        ProductVariation variation = new ProductVariation();

        variation.setProduct(product);
        variation.setDefaultVariation(true);
        variation.setRegularPrice(requestDto.getRegularPrice());
        variation.setSalesPrice(requestDto.getSalesPrice());
        variation.setStockQuantity(requestDto.getStockQuantity());
        variation.setStockStatus(StockStatus.IN_STOCK);
        variation.setImageURI(requestDto.getImageURI());

        variations.add(variation);
        product.setProductVariation(variations);

        product = productRepository.save(product);

        return product;
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
