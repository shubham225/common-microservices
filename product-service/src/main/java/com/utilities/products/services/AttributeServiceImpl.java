package com.utilities.products.services;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttributeServiceImpl implements AttributeService{
    @Override
    public List<Attribute> getAllAttributes() {
        return null;
    }

    @Override
    public Attribute createNewAttribute(AttributeRequestDto requestDto) {
        return null;
    }

    @Override
    public Attribute getAttributeById(UUID id) {
        return null;
    }

    @Override
    public Attribute updateAttributeById(UUID id, AttributeRequestDto requestDto) {
        return null;
    }

    @Override
    public Attribute deleteAttributeById(UUID id) {
        return null;
    }

    @Override
    public List<AttributeTerm> getAllAttributeTermsByAttributeId(UUID id) {
        return null;
    }

    @Override
    public AttributeTerm createNewAttributeTerm(UUID id, AttributeRequestDto requestDto) {
        return null;
    }

    @Override
    public AttributeTerm deleteAttributeTermById(UUID id) {
        return null;
    }

    @Override
    public AttributeTerm updateAttributeTermById(UUID id, AttributeRequestDto requestDto) {
        return null;
    }

    @Override
    public AttributeTerm getAttributeTermById(UUID id, UUID termId) {
        return null;
    }
}
