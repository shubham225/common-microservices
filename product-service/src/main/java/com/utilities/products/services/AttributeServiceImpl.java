package com.utilities.products.services;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.enums.AttributeType;
import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;
import com.utilities.products.respositories.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeServiceImpl implements AttributeService{

    private final AttributeRepository attributeRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Attribute createNewAttribute(AttributeRequestDto requestDto) {
        Attribute attribute = new Attribute();
        attribute.setName(requestDto.getName());
        attribute.setType(AttributeType.SELECT);

        attribute = attributeRepository.save(attribute);

        return attribute;
    }

    @Override
    public Attribute getAttributeById(UUID id) {
        Optional<Attribute> attributeOptional = attributeRepository.findById(id);

        if(attributeOptional.isEmpty())
            throw new RuntimeException("Attribute not found");

        return attributeOptional.get();
    }

    @Override
    public Attribute updateAttributeById(UUID id, AttributeRequestDto requestDto) {
        Optional<Attribute> attributeOptional = attributeRepository.findById(id);

        if(attributeOptional.isEmpty())
            throw new RuntimeException("Attribute not found");

        Attribute attribute = attributeOptional.get();
        attribute.setName(requestDto.getName());
        attribute = attributeRepository.save(attribute);

        return attribute;
    }

    @Override
    public Attribute deleteAttributeById(UUID id) {
        Optional<Attribute> attributeOptional = attributeRepository.findById(id);

        if(attributeOptional.isEmpty())
            throw new RuntimeException("Attribute not found");

        Attribute attribute = attributeOptional.get();
        attributeRepository.delete(attribute);

        return attribute;
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
