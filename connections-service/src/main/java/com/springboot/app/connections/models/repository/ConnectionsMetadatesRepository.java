package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.ConnectionsMetadates;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This interface is to  extend from CrudRepository, to
 * be able to do HTTP requests to ConnectionsMetadates object.
 *
 */
@RepositoryRestResource(path = "connections-metadates")
public interface ConnectionsMetadatesRepository extends CrudRepository<ConnectionsMetadates, Long>{

}
