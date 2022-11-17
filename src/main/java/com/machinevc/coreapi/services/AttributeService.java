package com.machinevc.coreapi.services;

import com.machinevc.coreapi.domain.Attribute;
import com.machinevc.coreapi.domain.Project;
import com.machinevc.coreapi.repositories.AttributeRepository;
import com.machinevc.coreapi.repositories.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttributeService {

    private AttributeRepository attributeRepository;


    public List<Attribute> findAll() {
        return attributeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Attribute> findById(Integer id) {
        return attributeRepository.findById(id);
    }
}
