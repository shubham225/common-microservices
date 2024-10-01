package com.utilities.products.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seller extends BaseModel {
    private String name;
}
