package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.Connections;
import com.springboot.app.connections.models.repository.ConnectionRepository;

/**
 * 
 * @author Unai Pérez Sánchez
 * This class is to prepare the methods that are going to be used by the requests.
 *
 */
@Service
public class ConnectionServiceImpl implements IConnectionService{
	@Autowired
	ConnectionRepository connectionRepository;
	
	/**
	 * This method returns a list of Connections, is meant to 
	 * find all connections in the database
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Connections> findAll() {
		return (List<Connections>) connectionRepository.findAll();
	}
	
	/**
	 * This method returns a Connections object, is meant to find
	 * one connection using the id of the connection
	 */
	@Override
	@Transactional(readOnly = true)
	public Connections findById(Long id) {
		return connectionRepository.findById(id).orElse(null);
	}
	
	/**
	 * This method can be used to update or create a new connection,
	 * depending if the object exists already in the database or not
	 */
	@Override
	@Transactional
	public void updateCreateConnection(Connections connection) {
		connectionRepository.save(connection);		
	}
	
	/**
	 * This method can be used to delete a connection from the database,
	 * is required the id of the connection to delete
	 */
	@Override
	@Transactional
	public void deleteConnection(Long id) {
		connectionRepository.deleteById(id);
		
	}
	
	
}
