package com.utilities.products.services;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;

import java.util.List;
import java.util.UUID;

public interface AttributeService {
    public List<Attribute> getAllAttributes();

    public Attribute createNewAttribute(AttributeRequestDto requestDto);

    public Attribute getAttributeById(UUID id);

    public Attribute updateAttributeById(UUID id, AttributeRequestDto requestDto);

    public Attribute deleteAttributeById(UUID id);

    public List<AttributeTerm> getAllAttributeTermsByAttributeId(UUID id);

    public AttributeTerm createNewAttributeTerm(UUID id, AttributeRequestDto requestDto);

    public AttributeTerm deleteAttributeTermById(UUID id);

    public AttributeTerm updateAttributeTermById(UUID id, AttributeRequestDto requestDto);

    public AttributeTerm getAttributeTermById(UUID id, UUID termId);
}
