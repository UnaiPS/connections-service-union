package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.commons.models.entity.Types;
import com.springboot.app.connections.models.repository.TypesRepository;

/**
 * 
 * @author Unai Pérez Sánchez
 * This class is to prepare the methods that are going to be used by the requests.
 *
 */
@Service
public class TypesServiceImpl implements ITypesService{
	
	@Autowired
	private TypesRepository typesRepository;
	
	/**
	 * This method returns a list of Types, we get all
	 * types from the database
	 */
	@Override
	public List<Types> findAllTypes() {
		return (List<Types>) typesRepository.findAll();
	}
	
	/**
	 * This method returns an object of type Types, to get
	 * this type from the database we must specify the Id of the 
	 * type we want to get
	 */
	@Override
	public Types findTypeById(Long id) {
		return typesRepository.findById(id).orElse(null);
	}
	
	/**
	 * This method can be used to create or update a type, depends if the
	 * type already exists in the database
	 */
	@Override
	public void updateCreateType(Types type) {
		typesRepository.save(type);
	}
	
	/**
	 * This method can be used to delete a type from the database,
	 * giving the proper Id of the type we want to delete
	 */
	@Override
	public void deleteType(Long id) {
		typesRepository.deleteById(id);
		
	}

}
