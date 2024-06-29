package com.utilities.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String          name;
    private String          description;
    @ManyToMany
    private List<Category>  categories;
    @ManyToOne
    private Seller          seller;
}
