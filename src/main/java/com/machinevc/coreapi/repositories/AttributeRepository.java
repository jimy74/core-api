package com.machinevc.coreapi.repositories;

import com.machinevc.coreapi.domain.Attribute;
import com.machinevc.coreapi.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {

    //TODO: change to SQLRepository and use findAll with pagination
}
