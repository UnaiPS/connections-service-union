package com.springboot.app.connections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 
 * @author Unai Pérez Sánchez
 * 
 * This class is the main one, that runs the microservice.
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.springboot.app.commons.models.entity"})
public class ConnectionsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsServiceApplication.class, args);
	}

}
