package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.ProcessMetadata;
import com.springboot.app.connections.models.repository.ProcessMetadataRepository;

@Service
public class ProcessMetadataServiceImpl implements IProcessMetadataService{
	
	@Autowired
	ProcessMetadataRepository processMetadataRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProcessMetadata> findAll() {
		return (List<ProcessMetadata>) processMetadataRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProcessMetadata findById(Long id) {
		return processMetadataRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void updateCreateProcessMetadata(ProcessMetadata processMetadata) {
		processMetadataRepository.save(processMetadata);
		
	}

	@Override
	@Transactional
	public void deleteProcessMetadata(Long id) {
		processMetadataRepository.deleteById(id);
		
	}

}
