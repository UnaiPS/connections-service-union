package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.commons.models.entity.ConnectionsMetadates;

public interface IConnectionsMetadatesService {
	
	public List<ConnectionsMetadates> findAll();
	
	public ConnectionsMetadates findById(Long id);
	
	public void updateCreateConnectionMetadate(ConnectionsMetadates connectionMetadate);
	
	public void deleteConnectionMetadate(Long id);
}
