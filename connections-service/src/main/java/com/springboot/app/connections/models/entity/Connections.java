package com.springboot.app.connections.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "connections")
public class Connections implements Serializable{

	private static final long serialVersionUID = -1377205675053132583L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String host;
	
	private Integer port;
	
	private String user;
	
	private String pass;
	
	@Column(unique = true)
	private String alias;
	
	private Boolean active = true;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type")
	private Types types;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	private Date createDate;

}
