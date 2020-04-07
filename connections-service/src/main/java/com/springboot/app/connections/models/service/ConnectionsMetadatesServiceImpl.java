package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.ConnectionsMetadates;
import com.springboot.app.connections.models.repository.ConnectionsMetadatesRepository;

@Service
public class ConnectionsMetadatesServiceImpl implements IConnectionsMetadatesService{
	
	@Autowired
	ConnectionsMetadatesRepository connectionsMetadatesRepository;	
	@Override
	@Transactional(readOnly = true)
	public List<ConnectionsMetadates> findAll() {
		return (List<ConnectionsMetadates>)connectionsMetadatesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ConnectionsMetadates findById(Long id) {
		return connectionsMetadatesRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void updateCreateConnectionMetadate(ConnectionsMetadates connectionMetadate) {
		connectionsMetadatesRepository.save(connectionMetadate);
		
	}

	@Override
	@Transactional
	public void deleteConnectionMetadate(Long id) {
		connectionsMetadatesRepository.deleteById(id);
	}

}
