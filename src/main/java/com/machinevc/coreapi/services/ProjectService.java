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
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {

    private ProjectRepository projectRepository;
    private AttributeRepository attributeRepository;


    public List<Project> findAll() {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Project> findById(Integer id) {
        return projectRepository.findById(id);
    }

    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }

    //This can be used for insert (when it doesn't exist yet) or update (when already existing)
    public Project saveAndFlush(Project project) {
        //Transform all negative IDs to null
        changeNegativeIdsToNull(project);
        //Saving the attributes first is needed, to work fine in case we save the project with some attributes
        attributeRepository.saveAllAndFlush(project.getAttributes());
        //Then we can safely save the project
        return projectRepository.saveAndFlush(project);
    }

    /**
     * Transform all negative IDs to null
     * This allows not use null too much on this service and its clients
     * @param project
     * @return attributes
     */
    private static Set<Attribute> changeNegativeIdsToNull(Project project) {
        Set<Attribute> attributesWithCleanIds = project.getAttributes().stream().map(attribute -> {
            if (attribute.getId() < 0) {
                attribute.setId(null);
            }
            return attribute;
        }).collect(Collectors.toSet());
        return attributesWithCleanIds;
    }
}
