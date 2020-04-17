package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.Metadates;
import com.springboot.app.connections.models.repository.MetadatesRepository;

@Service
public class MetadatesServiceImpl implements IMetadatesService{
	@Autowired
	MetadatesRepository metadatesRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Metadates> findAll() {
		return (List<Metadates>) metadatesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Metadates findById(Long id) {
		return metadatesRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void updateCreateMetadate(Metadates metadate) {
		metadatesRepository.save(metadate);
		
	}

	@Override
	@Transactional
	public void deleteMetadate(Long id) {
		metadatesRepository.deleteById(id);
		
	}
	
	@Override
	public List<Metadates> findAllConnectionMetadates(Long id) {
		return (List<Metadates>) metadatesRepository.allConnectionsMetadatesTable(id);
	}
	
}
