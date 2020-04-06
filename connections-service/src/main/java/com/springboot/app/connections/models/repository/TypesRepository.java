package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.Types;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This interface is to be able to extend from CrudRepository, to
 * be able to do HTTP requests to Types object.
 *
 */
@RepositoryRestResource(path = "types")
public interface TypesRepository extends CrudRepository<Types, Long>{

}
