package com.springboot.app.connections.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "types")
public class Types implements Serializable{

	private static final long serialVersionUID = -8534508234144225265L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	
	private String description;
	
	private String driver;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type_group")
	private TypesGroups typeGroup;

	
}
