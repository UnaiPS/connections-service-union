package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.commons.models.entity.Types;

/**
 * 
 * @author Unai Pérez Sánchez
 *
 */
public interface ITypesService {
	public List<Types> findAllTypes();
	
	public Types findTypeById(Long id);
	
	public void updateCreateType(Types type);
	
	public void deleteType(Long id);
}
