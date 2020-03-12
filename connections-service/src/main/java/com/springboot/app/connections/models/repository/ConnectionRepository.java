package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.connections.models.entity.Connections;
@RepositoryRestResource(path = "connections")
public interface ConnectionRepository extends CrudRepository<Connections, Long>{

}
