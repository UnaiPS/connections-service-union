package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.TypesGroups;

@RepositoryRestResource(path = "types-groups")
public interface TypesGroupsRepository extends CrudRepository<TypesGroups, Long>{

}
