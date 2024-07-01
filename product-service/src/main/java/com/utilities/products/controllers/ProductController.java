package com.utilities.products.controllers;

import com.utilities.products.dtos.*;
import com.utilities.products.models.Product;
import com.utilities.products.models.ProductVariation;
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
    public List<ProductResponseDto> getAllProducts(@RequestParam(defaultValue = "asc") String sort,
                                                   @RequestParam(defaultValue = "name") String sortBy,
                                                   @RequestParam(defaultValue = "1000") String limit,
                                                   @RequestParam(defaultValue = "1") String offset) {

        List<Product> productList = productService.getAllProducts(sort, sortBy,
                                                                  Integer.parseInt(limit),
                                                                  Integer.parseInt(offset));
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
    public ProductResponseDto getProductById(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}"
    )
    public ProductResponseDto updateProductById(@PathVariable UUID id,
                                            @RequestBody ProductUpdateRequestDto requestDto) {
        Product product = productService.updateProductById(id, requestDto);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public ProductResponseDto deleteProductById(@PathVariable UUID id) {
        Product product = productService.deleteProductById(id);
        return new ProductResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}/variations"
    )
    public List<ProductVariationResponseDto> getAllProductVariations(@PathVariable UUID id) {
        List<ProductVariation> productVariationList = productService.getAllProductVariations(id);
        List<ProductVariationResponseDto> productVariationResponseDtoList = new ArrayList<>();

        for(ProductVariation productVariation : productVariationList) {
            productVariationResponseDtoList.add(new ProductVariationResponseDto(productVariation));
        }

        return productVariationResponseDtoList;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "{id}/variations"
    )
    public ProductVariationResponseDto createNewProductVariation(@PathVariable UUID id,
                                                                 @RequestBody  ProductVariationRequestDto requestDto) {
        ProductVariation productVariation = productService.createNewProductVariation(requestDto);
        return new ProductVariationResponseDto(productVariation);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}/variations/{varId}"
    )
    public ProductVariationResponseDto getProductVariationById(@PathVariable UUID id,
                                                               @PathVariable UUID varId) {
        ProductVariation productVariation = productService.getProductVariationById(id, varId);
        return new ProductVariationResponseDto(productVariation);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}/variations/{varId}"
    )
    public ProductVariationResponseDto updateProductVariationById(@PathVariable UUID id,
                                                                  @PathVariable UUID varId,
                                                                  @RequestBody  ProductVariationUpdateRequestDto requestDto) {
        ProductVariation productVariation = productService.updateProductVariationById(id, varId, requestDto);
        return new ProductVariationResponseDto(productVariation);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}/variations/{varId}"
    )
    public ProductVariationResponseDto deleteProductVariationById(@PathVariable UUID id,
                                                                  @PathVariable UUID varId) {
        ProductVariation productVariation = productService.deleteProductVariationById(id, varId);
        return new ProductVariationResponseDto(productVariation);
    }
}
