package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.connections.models.entity.Connections;
import com.springboot.app.connections.models.repository.ConnectionRepository;

@Service
public class ConnectionServiceImpl implements IConnectionService{
	@Autowired
	ConnectionRepository connectionRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Connections> findAll() {
		return (List<Connections>) connectionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Connections findById(Long id) {
		return connectionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void updateCreateConnection(Connections connection) {
		connectionRepository.save(connection);		
	}

	@Override
	@Transactional
	public void deleteConnection(Long id) {
		connectionRepository.deleteById(id);
		
	}
	
	
}
