package com.utilities.products.models;

import com.utilities.products.enums.AttributeType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attribute extends BaseModel {
    private String          name;
    private AttributeType   type;
}
