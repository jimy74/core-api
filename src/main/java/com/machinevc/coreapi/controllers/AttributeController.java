package com.machinevc.coreapi.controllers;

import com.machinevc.coreapi.domain.Attribute;
import com.machinevc.coreapi.domain.AttributeTypes;
import com.machinevc.coreapi.services.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/attributes")
public class AttributeController {

    private AttributeService attributeService;

    /**
     *
     * @return an array of every attributes
     */
    @GetMapping
    public List<Attribute> getAll(){
        return attributeService.findAll();
    }

    /**
     *
     * @param id: attribute identifier number
     * @return the particular attribute with this id
     */
    @GetMapping(path="/{id}")
    public Optional<Attribute> getById(@PathVariable int id){
        return attributeService.findById(id);
    }

    /**
     *
     * @return an array of the possible attributes types
     */
    @GetMapping(path="/types")
    public List<AttributeTypes> getAllPossibleAttributesTypes(){
        return AttributeTypes.allPossibleAttributeTypes();
    }
}
