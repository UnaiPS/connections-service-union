package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.connections.models.entity.Connections;

public interface IConnectionService {
	public List<Connections> findAll();
	
	public Connections findById(Long id);
}
