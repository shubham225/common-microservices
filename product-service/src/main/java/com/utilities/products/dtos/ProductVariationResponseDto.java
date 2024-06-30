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
public class ProductVariationResponseDto {
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

    public ProductVariationResponseDto(ProductVariation productVariation) {
        this.id              = productVariation.getId();
        this.name            = productVariation.getProduct().getName();
        this.description     = productVariation.getProduct().getDescription();
        this.categories      = productVariation.getProduct().getCategories();
        this.seller          = productVariation.getProduct().getSeller();
        this.regularPrice    = productVariation.getRegularPrice();
        this.salesPrice      = productVariation.getSalesPrice();
        this.imageURI        = productVariation.getImageURI();
        this.stockQuantity   = productVariation.getStockQuantity();
        this.stockStatus     = productVariation.getStockStatus();

        List<AttributeTermResponseDto> responseDto = new ArrayList<>();

        for(AttributeTerm attributeTerm : productVariation.getAttributes()) {
            responseDto.add(new AttributeTermResponseDto(attributeTerm));
        }
        this.attributes      = responseDto;
    }
}
