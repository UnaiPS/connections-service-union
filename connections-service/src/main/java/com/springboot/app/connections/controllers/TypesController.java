package com.springboot.app.connections.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.commons.models.entity.Types;
import com.springboot.app.connections.models.service.ITypesService;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This class is meant to be the REST controller for the types part of the microservice.
 * The REST controller can do all the CRUD operations (Create, Read, Update and Delete) through HTTP
 * requests
 *
 */

@RestController
public class TypesController {
	
	@Autowired
	ITypesService typesService;
	
	/**
	 * This method is a GET request to find all types from the database.
	 * @return This method returns a List from java.util of Types
	 */
	@CrossOrigin
	@GetMapping("/findAllTypes")
	public List<Types> findAll(){
		return typesService.findAllTypes().stream().map(type -> {
			return type;
		}).collect(Collectors.toList());
	}
	
	/**
	 * This method is a GET request, is meant to get only one Type from the database.
	 * The request needs the id of the type as variable in the path.
	 * @param id The id of the type we want to get
	 * @return This method returns a object of type Types
	 */
	@CrossOrigin
	@GetMapping("/findTypeById/{id}")
	public Types findById(@PathVariable Long id) {
		return typesService.findTypeById(id);
	}
	
	/**
	 * This method is a POST request, is meant to create a new type. The body of the request
	 * needs a object of type Types.
	 * @param type The new Type we want to create
	 */
	@CrossOrigin
	@PostMapping("/createType")
	@ResponseStatus(HttpStatus.CREATED)
	public void createConnection(@RequestBody Types type) {
		typesService.updateCreateType(type);
	}
	
	/**
	 * This method is an UPDATE request, is meant to update an existing type. As path variable
	 * we need the id of the type we want to modify and in the body of the request the modified
	 * type.
	 * @param type The type we want to modify with updated data
	 * @param id The Id of the type we want to modify 
	 */
	@CrossOrigin
	@PutMapping("/updateType/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateType(@RequestBody Types type, @PathVariable Long id) {
		Types tempType = typesService.findTypeById(id);
		tempType.setDescription(type.getDescription());
		tempType.setDriver(type.getDriver());
		tempType.setType(type.getType());
		tempType.setTypeGroup(type.getTypeGroup());
		
		typesService.updateCreateType(tempType);
	}
	
	/**
	 * This method is a DELETE request, is meant to delete one type from the database. As path
	 * variable, we need the id of the type we want to delete.
	 * @param id The Id of the type we want to delete
	 */
	@CrossOrigin
	@DeleteMapping("/deleteType/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteType(@PathVariable Long id) {
		typesService.deleteType(id);
	}
}
