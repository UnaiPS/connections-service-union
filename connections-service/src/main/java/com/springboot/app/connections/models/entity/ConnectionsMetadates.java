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
@Table(name = "connections_metadates")
public class ConnectionsMetadates implements Serializable{

	private static final long serialVersionUID = 5014064753598785786L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_connection")
	private Connections connection;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_metadate")
	private Metadates metadates;
}
