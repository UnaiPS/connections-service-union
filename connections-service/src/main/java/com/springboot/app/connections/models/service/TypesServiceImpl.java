package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.commons.models.entity.Types;
import com.springboot.app.connections.models.repository.TypesRepository;

@Service
public class TypesServiceImpl implements ITypesService{
	
	@Autowired
	private TypesRepository typesRepository;
	
	@Override
	public List<Types> findAllTypes() {
		return (List<Types>) typesRepository.findAll();
	}

	@Override
	public Types findTypeById(Long id) {
		return typesRepository.findById(id).orElse(null);
	}

	@Override
	public void updateCreateType(Types type) {
		typesRepository.save(type);
	}

	@Override
	public void deleteType(Long id) {
		typesRepository.deleteById(id);
		
	}

}
