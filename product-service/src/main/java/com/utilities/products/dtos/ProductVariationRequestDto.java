package com.utilities.products.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductVariationRequestDto {
    private long                            regularPrice;
    private long                            salesPrice;
    private String                          imageURI;
    private List<AttributeTermRequestDto>   attributes;
    private long                            stockQuantity;
}
