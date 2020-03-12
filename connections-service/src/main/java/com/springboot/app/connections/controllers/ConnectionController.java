package com.springboot.app.connections.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.connections.models.entity.Connections;
import com.springboot.app.connections.models.service.IConnectionService;

@RestController
public class ConnectionController {
	@Autowired
	IConnectionService connectionService;
	
	@CrossOrigin
	@GetMapping("/findAllConnections")
	public List<Connections> findAll(){
		return connectionService.findAll().stream().map(connection -> {
			return connection;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/findConnectionById/{id}")
	public Connections findById(@PathVariable Long id) {
		return connectionService.findById(id);
	}
}
