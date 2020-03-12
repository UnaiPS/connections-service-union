package com.springboot.app.connections.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "metadates")
public class Metadates implements Serializable{

	private static final long serialVersionUID = -5360116432232909902L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String meta;
	
	private String description;
	
	@Column(name = "id_parent")
	private Long idParent;
	
	private Integer level;
	
	private Boolean active;

}
