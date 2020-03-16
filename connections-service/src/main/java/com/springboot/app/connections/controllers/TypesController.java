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

import com.springboot.app.connections.models.entity.Types;
import com.springboot.app.connections.models.service.ITypesService;

@RestController
public class TypesController {
	
	@Autowired
	ITypesService typesService;
	
	@CrossOrigin
	@GetMapping("findAllTypes")
	public List<Types> findAll(){
		return typesService.findAllTypes().stream().map(type -> {
			return type;
		}).collect(Collectors.toList());
	}
	
	@CrossOrigin
	@GetMapping("/findTypeById/{id}")
	public Types findById(@PathVariable Long id) {
		return typesService.findTypeById(id);
	}
	
	@CrossOrigin
	@PostMapping("/createType")
	@ResponseStatus(HttpStatus.CREATED)
	public void createConnection(@RequestBody Types type) {
		typesService.updateCreateType(type);
	}
	
	@CrossOrigin
	@PutMapping("/updateType/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateType(@RequestBody Types type, @PathVariable Long id) {
		Types tempType = typesService.findTypeById(id);
		tempType.setDescription(type.getDescription());
		tempType.setDriver(type.getDriver());
		tempType.setType(type.getType());
		tempType.setTypeGroup(type.getTypeGroup());
		
		typesService.updateCreateType(tempType);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteType/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteType(@PathVariable Long id) {
		typesService.deleteType(id);
	}
}
