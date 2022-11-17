package com.machinevc.coreapi.repositories;

import com.machinevc.coreapi.domain.Attribute;
import com.machinevc.coreapi.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
