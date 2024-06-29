package com.utilities.products.services;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.models.Attribute;

import java.util.List;
import java.util.UUID;

public interface AttributeService {
    public List<Attribute> getAllAttributes();

    public Attribute createNewAttribute(AttributeRequestDto requestDto);

    public Attribute getAttribute(UUID id);

    public Attribute updateAttribute(UUID id);

    public Attribute deleteAttribute(UUID id);
}
