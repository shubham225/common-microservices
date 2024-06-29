package com.utilities.products.dtos;

import com.utilities.products.enums.StockStatus;
import com.utilities.products.models.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {
    private UUID                            id;
    private String                          name;
    private String                          description;
    private List<Category>                  categories;
    private Seller                          seller;
    private long                            regularPrice;
    private long                            salesPrice;
    private String                          imageURI;
    private List<AttributeTermResponseDto>  attributes;
    private long                            stockQuantity;
    private StockStatus                     stockStatus;

    public ProductResponseDto(Product product) {
        this.id              = product.getId();
        this.name            = product.getName();
        this.description     = product.getDescription();
        this.categories      = product.getCategories();
        this.seller          = product.getSeller();

        ProductVariation variation = product.getProductVariation().get(0);
        this.regularPrice    = variation.getRegularPrice();
        this.salesPrice      = variation.getSalesPrice();
        this.imageURI        = variation.getImageURI();
        this.stockQuantity   = variation.getStockQuantity();
        this.stockStatus     = variation.getStockStatus();

        List<AttributeTermResponseDto> responseDto = new ArrayList<>();

        for(AttributeTerm attributeTerm : variation.getAttributes()) {
            responseDto.add(new AttributeTermResponseDto(attributeTerm));
        }
        this.attributes      = responseDto;
    }
}
