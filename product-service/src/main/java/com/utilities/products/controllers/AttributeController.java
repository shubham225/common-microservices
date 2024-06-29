package com.utilities.products.controllers;

import com.utilities.products.dtos.AttributeRequestDto;
import com.utilities.products.dtos.AttributeResponseDto;
import com.utilities.products.models.Attribute;
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
        Attribute product = attributeService.createNewAttribute(requestDto);
        return new AttributeResponseDto(product);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{id}"
    )
    public AttributeResponseDto getAttributeDetail(@PathVariable UUID id) {
        Attribute attribute = attributeService.getAttribute(id);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{id}"
    )
    public AttributeResponseDto updateAttribute(@PathVariable UUID id) {
        Attribute attribute = attributeService.updateAttribute(id);
        return new AttributeResponseDto(attribute);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{id}"
    )
    public AttributeResponseDto deleteAttribute(@PathVariable UUID id) {
        Attribute attribute = attributeService.deleteAttribute(id);
        return new AttributeResponseDto(attribute);
    }
}
