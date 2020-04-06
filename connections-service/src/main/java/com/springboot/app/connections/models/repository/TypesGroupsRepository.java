package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.TypesGroups;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This interface is to  extend from CrudRepository, to
 * be able to do HTTP requests to TypesGroups object.
 *
 */
@RepositoryRestResource(path = "types-groups")
public interface TypesGroupsRepository extends CrudRepository<TypesGroups, Long>{

}
