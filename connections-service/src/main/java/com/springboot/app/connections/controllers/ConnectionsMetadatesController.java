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

import com.springboot.app.commons.models.entity.ConnectionsMetadates;
import com.springboot.app.connections.models.service.IConnectionsMetadatesService;

@RestController
public class ConnectionsMetadatesController {

	@Autowired
	IConnectionsMetadatesService connectionsMetadatesService;

	@CrossOrigin
	@GetMapping("/findAllConnectionsMetadates")
	public List<ConnectionsMetadates> findAll() {
		return connectionsMetadatesService.findAll().stream().map(connectionMetadate -> {
			return connectionMetadate;
		}).collect(Collectors.toList());
	}

	@CrossOrigin
	@GetMapping("/findConnectionMetadateById/{id}")
	public ConnectionsMetadates findById(@PathVariable Long id) {
		return connectionsMetadatesService.findById(id);
	}

	@CrossOrigin
	@PostMapping("/createConnectionMetadate")
	@ResponseStatus(HttpStatus.CREATED)
	public void createConnectionMetadate(@RequestBody ConnectionsMetadates connectionMetadate) {
		connectionsMetadatesService.updateCreateConnectionMetadate(connectionMetadate);
	}

	@CrossOrigin
	@PutMapping("/updateConnectionMetadate/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateConnectionMetadate(@RequestBody ConnectionsMetadates connectionMetadate, @PathVariable Long id) {
		ConnectionsMetadates tempConnectionMetadates = connectionsMetadatesService.findById(id);
		tempConnectionMetadates.setConnection(connectionMetadate.getConnection());
		tempConnectionMetadates.setMetadates(connectionMetadate.getMetadates());

		connectionsMetadatesService.updateCreateConnectionMetadate(tempConnectionMetadates);
	}

	@CrossOrigin
	@DeleteMapping("/deleteConnectionMetadate/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteConnectionMetadate(@PathVariable Long id) {
		connectionsMetadatesService.deleteConnectionMetadate(id);
	}
}
