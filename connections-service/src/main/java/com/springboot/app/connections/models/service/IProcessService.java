package com.springboot.app.connections.models.service;

import java.util.List;


public interface IProcessService {
public List<com.springboot.app.commons.models.entity.Process> findAll();
	
	public com.springboot.app.commons.models.entity.Process findById(Long id);
	
	public void updateCreateProcess(com.springboot.app.commons.models.entity.Process process);
	
	public void deleteProcess(Long id);
}
