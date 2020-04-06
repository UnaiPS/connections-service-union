package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This interface is to  extend from CrudRepository, to
 * be able to do HTTP requests to Connections object.
 *
 */
import com.springboot.app.commons.models.entity.Connections;
@RepositoryRestResource(path = "connections")
public interface ConnectionRepository extends CrudRepository<Connections, Long>{

}
