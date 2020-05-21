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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.commons.models.entity.ProcessMetadata;
import com.springboot.app.connections.models.service.IMetadatesService;
import com.springboot.app.connections.models.service.IProcessMetadataService;
import com.springboot.app.connections.models.service.IProcessService;

@RestController
public class ProcessMetadateController {
	@Autowired
	IProcessMetadataService processMetadataService;
	@Autowired
	IMetadatesService metadatesService;
	@Autowired
	IProcessService processService;
	
	@CrossOrigin
	@GetMapping("/findAllProcessMetadata")
	public List<ProcessMetadata> findAll(){
		return processMetadataService.findAll().stream().map(processMeta -> {
			return processMeta;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/findProcessMetadataById/{id}")
	public ProcessMetadata findById(@PathVariable Long id) {
		return processMetadataService.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/createProcessMetadata")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProcessMetadata(@RequestBody ProcessMetadata processMetadata) {
		processMetadataService.updateCreateProcessMetadata(processMetadata);
	}
	
	@CrossOrigin
	@PutMapping("/updateProcessMetadata/{id}/process/{process}/origin/{origin}/destination/{destination}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateProcessMetadata(@PathVariable Long id, @PathVariable Long process, @PathVariable Long origin, @PathVariable Long destination) {
		ProcessMetadata processMetaToUpdate = new ProcessMetadata();
		processMetaToUpdate.setId(id);
		processMetaToUpdate.setProcess(processService.findById(process));
		processMetaToUpdate.setOrigin(metadatesService.findById(origin));
		processMetaToUpdate.setDestination(metadatesService.findById(destination));
		
		processMetadataService.updateCreateProcessMetadata(processMetaToUpdate);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteProcessMetadata/{id}")
	public void deleteProcessMetadata(@PathVariable Long id) {
		processMetadataService.deleteProcessMetadata(id);
	}
}
