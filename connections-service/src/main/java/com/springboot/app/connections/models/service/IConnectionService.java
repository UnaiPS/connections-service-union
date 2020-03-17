package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.commons.models.entity.Connections;

public interface IConnectionService {
	public List<Connections> findAll();
	
	public Connections findById(Long id);
	
	public void updateCreateConnection(Connections connection);
	
	public void deleteConnection(Long id);
}
