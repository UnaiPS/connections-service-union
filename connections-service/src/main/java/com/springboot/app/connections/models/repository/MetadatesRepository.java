package com.springboot.app.connections.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.connections.models.entity.Metadates;

@RepositoryRestResource(path = "metadates")
public interface MetadatesRepository extends CrudRepository<Metadates, Long>{

}
