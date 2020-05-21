package com.springboot.app.connections.models.service;

import java.util.List;

import com.springboot.app.commons.models.entity.ProcessMetadata;


public interface IProcessMetadataService {
	public List<ProcessMetadata> findAll();
	
	public ProcessMetadata findById(Long id);
	
	public void updateCreateProcessMetadata(ProcessMetadata processMetadata);
	
	public void deleteProcessMetadata(Long id);
}
