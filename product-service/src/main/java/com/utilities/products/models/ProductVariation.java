package com.utilities.products.models;

import com.utilities.products.enums.StockStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ProductVariation extends BaseModel {
    @ManyToOne
    private Product             product;
    private long                regularPrice;
    private long                salesPrice;
    private String              imageURI;
    private boolean             defaultVariation;
    @ManyToMany
    private List<AttributeTerm> attributes;
    private long                stockQuantity;
    private StockStatus         stockStatus;
}
