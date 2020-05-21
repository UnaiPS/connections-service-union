package com.springboot.app.connections.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.commons.models.entity.Process;
import com.springboot.app.connections.models.repository.ProcessRepository;

@Service
public class ProcessServiceImpl implements IProcessService{
	
	@Autowired
	ProcessRepository processRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Process> findAll() {
		return (List<Process>) processRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Process findById(Long id) {
		return processRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void updateCreateProcess(Process process) {
		processRepository.save(process);
		
	}

	@Override
	@Transactional
	public void deleteProcess(Long id) {
		processRepository.deleteById(id);
		
	}

}
