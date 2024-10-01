package com.utilities.products.services;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.enums.AttributeType;
import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;
import com.utilities.products.respositories.AttributeRepository;
import com.utilities.products.respositories.AttributeTermRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeServiceImpl implements AttributeService{

    private final AttributeRepository attributeRepository;
    private final AttributeTermRepository attributeTermRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository,
                                AttributeTermRepository attributeTermRepository) {
        this.attributeRepository = attributeRepository;
        this.attributeTermRepository = attributeTermRepository;
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
        return attributeTermRepository.findAll();
    }

    @Override
    public AttributeTerm createNewAttributeTerm(UUID id, AttributeRequestDto requestDto) {
        AttributeTerm attributeTerm = new AttributeTerm();
        Optional<Attribute> attributeOptional = attributeRepository.findById(id);

        if(attributeOptional.isEmpty())
            throw new RuntimeException("Attribute not found");

        attributeTerm.setAttribute(attributeOptional.get());
        attributeTerm.setValue(requestDto.getName());

        attributeTerm = attributeTermRepository.save(attributeTerm);

        return attributeTerm;
    }

    @Override
    public AttributeTerm deleteAttributeTermById(UUID id, UUID termId) {
        Optional<AttributeTerm> attributeTermOptional = attributeTermRepository.findById(termId);

        if (attributeTermOptional.isEmpty())
            throw new RuntimeException("Attribute Term not found");

        AttributeTerm attributeTerm = attributeTermOptional.get();

        attributeTermRepository.delete(attributeTerm);

        return attributeTerm;
    }

    @Override
    public AttributeTerm updateAttributeTermById(UUID id, UUID termId, AttributeRequestDto requestDto) {
        Optional<AttributeTerm> attributeTermOptional = attributeTermRepository.findById(termId);

        if (attributeTermOptional.isEmpty())
            throw new RuntimeException("Attribute Term not found");

        AttributeTerm attributeTerm = attributeTermOptional.get();

        attributeTerm.setValue(requestDto.getName());
        attributeTerm = attributeTermRepository.save(attributeTerm);

        return attributeTerm;
    }

    @Override
    public AttributeTerm getAttributeTermById(UUID id, UUID termId) {
        Optional<AttributeTerm> attributeTermOptional = attributeTermRepository.findById(termId);

        if (attributeTermOptional.isEmpty())
            throw new RuntimeException("Attribute Term not found");

        return attributeTermOptional.get();
    }
}
