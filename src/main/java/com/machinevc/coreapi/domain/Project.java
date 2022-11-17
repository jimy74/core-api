package com.machinevc.coreapi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity // make this class a persistable entity using JPA
@NoArgsConstructor
@AllArgsConstructor
@Data // for getter and setters, but also toString equals hashcode and requiredArgsConstructor
@Table(name = "vc_projects")
public class Project {

    //TODO: **Architecture hexagonale**: ajouter des DTO entre les entitées et l'API,
    // pour plus de flexibilité dans la business logic et pas casser les clients à cause de la BDD

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To not pass the id, on both POST and the import.sql init script
    @Column(name="pro_id")
    private Integer id;

    @NonNull
    @Column(name="pro_name")
    private String name;

    @NonNull
    @ManyToMany
    @OrderBy("att_id ASC")
    @Column(name="pro_attributes")
    private Set<Attribute> attributes;
}
