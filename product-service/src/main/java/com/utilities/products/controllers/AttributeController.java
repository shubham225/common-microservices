package com.utilities.products.controllers;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.dtos.AttributeResponseDto;
import com.utilities.products.dtos.AttributeTermResponseDto;
import com.utilities.products.models.Attribute;
import com.utilities.products.models.AttributeTerm;
import com.utilities.products.services.AttributeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/V1/attributes")
public class AttributeController {
    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<AttributeResponseDto> getAllAttributes() {
        List<Attribute> attributeList = attributeService.getAllAttributes();
        List<AttributeResponseDto> attributeResponseDtoList = new ArrayList<>();

        for(Attribute attribute : attributeList)
            attributeResponseDtoList.add(new AttributeResponseDto(attribute));

        return attributeResponseDtoList;
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public AttributeResponseDto createNewAttribute(@RequestBody AttributeRequestDto requestDto) {
        Attribute attribute = attributeService.createNewAttribute(requestDto);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public AttributeResponseDto getAttributeById(@PathVariable UUID id) {
        Attribute attribute = attributeService.getAttributeById(id);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}"
    )
    public AttributeResponseDto updateAttributeById(@PathVariable UUID id,
                                                    @RequestBody  AttributeRequestDto requestDto) {
        Attribute attribute = attributeService.updateAttributeById(id, requestDto);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public AttributeResponseDto deleteAttributeById(@PathVariable UUID id) {
        Attribute attribute = attributeService.deleteAttributeById(id);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}/terms"
    )
    public List<AttributeTermResponseDto> getAllAttributeTermsByAttributeId(@PathVariable UUID id) {
        List<AttributeTerm> attributeTermList = attributeService.getAllAttributeTermsByAttributeId(id);
        List<AttributeTermResponseDto> attributeTermsResponseDtoList = new ArrayList<>();

        for(AttributeTerm attributeTerm : attributeTermList)
            attributeTermsResponseDtoList.add(new AttributeTermResponseDto(attributeTerm));

        return attributeTermsResponseDtoList;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "{id}/terms"
    )
    public AttributeTermResponseDto createNewAttributeTerm(@PathVariable UUID id,
                                                           @RequestBody  AttributeRequestDto requestDto) {
        AttributeTerm attributeTerm = attributeService.createNewAttributeTerm(id, requestDto);
        return new AttributeTermResponseDto(attributeTerm);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}/terms/{termId}"
    )
    public AttributeTermResponseDto getAttributeTermById(@PathVariable UUID id,
                                                         @PathVariable UUID termId) {
        AttributeTerm attributeTerm = attributeService.getAttributeTermById(id, termId);
        return new AttributeTermResponseDto(attributeTerm);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}/terms/{termId}"
    )
    public AttributeTermResponseDto updateAttributeTermById(@PathVariable UUID id,
                                                            @RequestBody  AttributeRequestDto requestDto) {
        AttributeTerm attributeTerm = attributeService.updateAttributeTermById(id, requestDto);
        return new AttributeTermResponseDto(attributeTerm);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}/terms/{termId}"
    )
    public AttributeTermResponseDto deleteAttributeTermById(@PathVariable UUID id) {
        AttributeTerm attributeTerm = attributeService.deleteAttributeTermById(id);
        return new AttributeTermResponseDto(attributeTerm);
    }
}
