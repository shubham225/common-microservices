package com.utilities.products.dtos;

import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AttributeResponseDto {
    private UUID    id;
    private String  name;

    public AttributeResponseDto(Attribute attribute) {
        this.id     = attribute.getId();
        this.name   = attribute.getName();
    }
}
