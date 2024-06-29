package com.utilities.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AttributeTerm extends BaseModel {
    @ManyToOne
    private Attribute   attribute;
    private String      value;
}
