package com.machinevc.coreapi.controllers;

import com.machinevc.coreapi.domain.Attribute;
import com.machinevc.coreapi.domain.Project;
import com.machinevc.coreapi.domain.errors.AttributeTypeParseException;
import com.machinevc.coreapi.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/projects")
public class ProjectController {

    private ProjectService projectService;

    /**
     *
     * @return an array of every projects
     */
    @GetMapping(path="")
    public List<Project> getAll(){
        return projectService.findAll();
    }

    /**
     *
     * @param id: project identifier number
     * @return the particular project with this id
     */
    @GetMapping(path="/{id}")
    public Optional<Project> getById(@PathVariable int id){
        return projectService.findById(id);
    }

    /**
     *
     * @param project: project request body in JSON
     * @return the inserted project with its new generated id
     * @throws AttributeTypeParseException automatically transformed by the CustomResponseEntityExceptionHandler
     *                                     into a custom Bad Request (400) with some details     */
    @PostMapping
    public Project insert(@RequestBody Project project) throws AttributeTypeParseException {
        validateAttributesFormat(project);
        return projectService.saveAndFlush(project);
    }

    /**
     *
     * @param id: project identifier number
     * @param project: project request body in JSON
     * @return the project up-to-date
     * @throws AttributeTypeParseException automatically transformed by the CustomResponseEntityExceptionHandler
     *                                     into a custom Bad Request (400) with some details
     */
    @PutMapping(path="/{id}")
    public Project update(@PathVariable int id, @RequestBody Project project) throws AttributeTypeParseException {
        //Project projectWithFormattedAttributeIds = replaceAttributeNegativeIdsByNull(project);
        validateAttributesFormat(project);
        return projectService.saveAndFlush(project);
    }

    /*
    private static Project replaceAttributeNegativeIdsByNull(Project project) {
        Set<Attribute> attributesWithFormattedIds = project.getAttributes().stream().map(attribute -> {
                    attribute.setId(attribute.getId() < 0 ? null : attribute.getId());
                    return attribute;
                }
        ).collect(Collectors.toSet());
        project.setAttributes(attributesWithFormattedIds);
        return project;
    }*/

    /**
     *
     * @param id: project identifier number
     */
    @DeleteMapping(path="/{id}")
    public void delete(@PathVariable int id){
        projectService.deleteById(id);
    }

    /**
     *
     * @param project: Project we want to validate, before inserting or updating it, to ensure the attributes are valid
     * @throws AttributeTypeParseException automatically transformable by the CustomResponseEntityExceptionHandler
     *                                     into a custom Bad Request (400) with some details
     */
    private void validateAttributesFormat(Project project) throws AttributeTypeParseException {
        for (Attribute attribute : project.getAttributes()) {
            attribute.validate();
        }
    }
}
