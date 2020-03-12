package com.springboot.app.connections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.springboot.app.connections.models.entity.Connections;
import com.springboot.app.connections.models.entity.Types;
import com.springboot.app.connections.models.entity.TypesGroups;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(TypesGroups.class, Connections.class, Types.class);
	}
}
