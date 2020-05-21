package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "process")
public interface ProcessRepository extends CrudRepository<com.springboot.app.commons.models.entity.Process, Long>{

}
