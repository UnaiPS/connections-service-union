package com.springboot.app.connections.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.commons.models.entity.Process;
import com.springboot.app.connections.models.service.IConnectionService;
import com.springboot.app.connections.models.service.IProcessService;

@RestController
public class ProcessController {
	
	@Autowired
	IProcessService processService;
	
	@Autowired
	IConnectionService connectionService;
	
	@CrossOrigin
	@GetMapping("/findAllProcess")
	public List<Process> findAll(){
		return processService.findAll().stream().map(process -> {
			return process;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/findProcessById/{id}")
	public Process findById(@PathVariable Long id) {
		return processService.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/createProcess/origin/{idOrigin}/destination/{idDestination}/keep/{keepId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProcess(@PathVariable Long idOrigin, @PathVariable Long idDestination, @PathVariable Boolean keepId) {
		Process process = new Process();
		process.setOrigin(connectionService.findById(idOrigin));
		process.setDestination(connectionService.findById(idDestination));
		process.setKeepIds(keepId);
		processService.updateCreateProcess(process);
	}
	
	@CrossOrigin
	@PutMapping("/updateProcess/{id}/keep/{keepId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateProcess(@PathVariable Long id, @PathVariable Boolean keepId) {
		Process processToUpdate = new Process();
		processToUpdate = processService.findById(id);
		processToUpdate.setKeepIds(keepId);
		processService.updateCreateProcess(processToUpdate);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteProcess/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProcess(@PathVariable Long id) {
		processService.deleteProcess(id);
	}
}
