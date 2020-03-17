package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.commons.models.entity.Types;

@RepositoryRestResource(path = "types")
public interface TypesRepository extends CrudRepository<Types, Long>{

}
