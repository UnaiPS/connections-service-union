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

import com.springboot.app.commons.models.entity.Metadates;
import com.springboot.app.connections.models.service.IMetadatesService;

@RestController
public class MetadatesController {
	
	@Autowired
	IMetadatesService metadatesService;
	
	@CrossOrigin
	@GetMapping("/findAllMetadates")
	public List<Metadates> findAll(){
		return metadatesService.findAll().stream().map(metadate -> {
			return metadate;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/findMetadateById/{id}")
	public Metadates findById(@PathVariable Long id) {
		return metadatesService.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/createMetadate")
	@ResponseStatus(HttpStatus.CREATED)
	public void createMetadate(@RequestBody Metadates metadate) {
		metadatesService.updateCreateMetadate(metadate);
	}
	
	@CrossOrigin
	@PutMapping("/updateMetadate/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateMetadate(@RequestBody Metadates metadate, @PathVariable Long id) {
		Metadates tempMetadate = metadatesService.findById(id);
		tempMetadate.setActive(metadate.getActive());
		tempMetadate.setDescription(metadate.getDescription());
		tempMetadate.setIdParent(metadate.getIdParent());
		tempMetadate.setLevel(metadate.getLevel());
		tempMetadate.setMeta(metadate.getMeta());
		
		metadatesService.updateCreateMetadate(tempMetadate);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteMetadate/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMetadate(@PathVariable Long id) {
		metadatesService.deleteMetadate(id);
	}
}
