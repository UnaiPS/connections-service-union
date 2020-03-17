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

import com.springboot.app.connections.models.entity.Connections;
import com.springboot.app.connections.models.service.IConnectionService;
import com.springboot.app.connections.models.service.ITypesService;

@RestController
public class ConnectionController {
	@Autowired
	IConnectionService connectionService;
	
	@Autowired
	ITypesService typesService;
	
	@CrossOrigin
	@GetMapping("/findAllConnections")
	public List<Connections> findAll(){
		return connectionService.findAll().stream().map(connection -> {
			return connection;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/findConnectionById/{id}")
	public Connections findById(@PathVariable Long id) {
		return connectionService.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/createConnection")
	@ResponseStatus(HttpStatus.CREATED)
	public void createConnection(@RequestBody Connections connection) {
		connectionService.updateCreateConnection(connection);
	}
	
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
	
	@CrossOrigin
	@DeleteMapping("/deleteConnection/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteConnection(@PathVariable Long id) {
		connectionService.deleteConnection(id);
	}
}
