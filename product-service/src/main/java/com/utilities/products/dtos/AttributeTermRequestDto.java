package com.utilities.products.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AttributeTermRequestDto {
    private UUID    id;
    private String  value;
}
