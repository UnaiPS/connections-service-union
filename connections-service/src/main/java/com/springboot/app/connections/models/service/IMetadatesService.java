package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.commons.models.entity.Metadates;

public interface IMetadatesService {
	
	public List<Metadates> findAll();
	
	public Metadates findById(Long id);
	
	public void updateCreateMetadate(Metadates metadate);
	
	public void deleteMetadate(Long id);
}
