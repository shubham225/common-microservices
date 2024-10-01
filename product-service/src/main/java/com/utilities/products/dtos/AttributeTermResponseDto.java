package com.utilities.products.dtos;

import com.utilities.products.models.AttributeTerm;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AttributeTermResponseDto {
    private UUID    id;
    private String  attribute;
    private String  value;

    public AttributeTermResponseDto(AttributeTerm attributeTerm) {
        this.id         = attributeTerm.getId();
        this.attribute  = attributeTerm.getAttribute().getName();
        this.value      = attributeTerm.getValue();
    }
}
