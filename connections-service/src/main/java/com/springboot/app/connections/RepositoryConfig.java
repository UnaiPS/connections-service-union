package com.springboot.app.connections;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.springboot.app.commons.models.entity.Connections;
import com.springboot.app.commons.models.entity.Types;
import com.springboot.app.commons.models.entity.TypesGroups;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(TypesGroups.class, Connections.class, Types.class);
	}
}
