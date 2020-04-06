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

import com.springboot.app.commons.models.entity.Connections;
import com.springboot.app.connections.models.service.IConnectionService;
import com.springboot.app.connections.models.service.ITypesService;

/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This class is meant to be the REST controller for the connections part of the microservice.
 * The REST controller can do all the CRUD operations (Create, Read, Update and Delete) through HTTP
 * requests
 * 
 */

@RestController
public class ConnectionController {
	@Autowired
	IConnectionService connectionService;
	
	@Autowired
	ITypesService typesService;
	
	/**
	 * This method does a GET request, to search all connections that exists in the database
	 * @return The method returns a List from java.util of Connections
	 */
	@CrossOrigin
	@GetMapping("/findAllConnections")
	public List<Connections> findAll(){
		return connectionService.findAll().stream().map(connection -> {
			return connection;
		}).collect(Collectors.toList());
	}
	
	/**
	 * This method does a GET request, to search an specific connection in the database,
	 * to happen this, it must contain as path variable the id of the connection we want to get.
	 * @param id This parameter is the id of the connection we want to know about
	 * @return This method returns a Connection object as result of the request
	 */
	@CrossOrigin
	@GetMapping("/findConnectionById/{id}")
	public Connections findById(@PathVariable Long id) {
		return connectionService.findById(id);
	}
	
	/**
	 * This method does a POST request, to create a new connection. In the body of the request
	 * must be the new connection we want to create.
	 * @param connection An object of type Connection is required
	 */
	@CrossOrigin
	@PostMapping("/createConnection")
	@ResponseStatus(HttpStatus.CREATED)
	public void createConnection(@RequestBody Connections connection) {
		connectionService.updateCreateConnection(connection);
	}
	
	/**
	 * This method does a PUT request, to update an existing connection. The request must have in the body of
	 * the request the connection, and then as path variables we will need the id of the connection we want to
	 * update and the id of the type of connection we are going to assign.
	 * @param connection The connection with the updated data
	 * @param id The id of the connection we want to update
	 * @param idType The id of the type we want for this connection
	 */
	@CrossOrigin
	@PutMapping("/updateConnection/{id}/type/{idType}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateConnection(@RequestBody Connections connection, @PathVariable Long id, @PathVariable Long idType) {
		Connections tempConnection = connectionService.findById(id);
		tempConnection.setHost(connection.getHost());
		tempConnection.setUser(connection.getUser());
		tempConnection.setAlias(connection.getAlias());
		tempConnection.setPort(connection.getPort());
		tempConnection.setPass(connection.getPass());
		tempConnection.setActive(connection.getActive());
		tempConnection.setTypes(typesService.findTypeById(idType));
		
		connectionService.updateCreateConnection(tempConnection);
	}
	
	/**
	 * This method does a DELETE request, to delete one connection via id. We need to specify the id of the connection
	 * we want to delete as path variable.
	 * @param id The id of the connection we want to delete
	 */
	@CrossOrigin
	@DeleteMapping("/deleteConnection/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteConnection(@PathVariable Long id) {
		connectionService.deleteConnection(id);
	}
}
