package com.biswajit.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.biswajit.spring.boot.bean.DatasourceBean;

/**
 * @author Biswajit Mohapatra
 *
 */

@Profile(value="DEV")
@Configuration
@PropertySource(value="classpath:DevDatasource.properties",ignoreResourceNotFound=true)
public class AppDevelopmentDatabaseConfig {

 @Autowired
 private Environment env;
	
	@Bean(name="datasource")
	public DatasourceBean devDatasorceBean(){
		return new DatasourceBean(env.getProperty("dev.database.name"), env.getProperty("dev.database.url"), env.getProperty("dev.database.username"), env.getProperty("dev.database.password"));
	}
		
	
}
