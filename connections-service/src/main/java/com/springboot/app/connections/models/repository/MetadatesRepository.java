package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.Metadates;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This interface is to  extend from CrudRepository, to
 * be able to do HTTP requests to Metadates object.
 *
 */
@RepositoryRestResource(path = "metadates")
public interface MetadatesRepository extends CrudRepository<Metadates, Long>{

}
