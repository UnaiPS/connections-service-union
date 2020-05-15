package com.springboot.app.connections.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

	@Query(value = "SELECT * FROM metadates WHERE id IN (SELECT id_metadate FROM connections_metadates WHERE id_connection = :id) AND level = 1", nativeQuery = true)
	public List<Metadates> allConnectionsMetadatesTable(Long id);
	
	@Query(value = "SELECT * FROM metadates WHERE id_parent IN (SELECT id FROM metadates WHERE id IN (SELECT id_metadate FROM connections_metadates WHERE id_connection = :id) AND level = 1 AND meta LIKE :nameTable)", nativeQuery = true)
	public List<Metadates> allMetadatesOfATable(Long id, String nameTable);
}
