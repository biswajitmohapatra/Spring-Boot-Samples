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

@Profile(value="PROD")
@Configuration
@PropertySource(value="classpath:ProdDatasource.properties",ignoreResourceNotFound=true)
public class AppProductionDatabaseConfig {

 @Autowired
 private Environment env;
	
	@Bean(name="datasource")
	public DatasourceBean devDatasorceBean(){
		return new DatasourceBean(env.getProperty("prod.database.name"), env.getProperty("prod.database.url"), env.getProperty("prod.database.username"), env.getProperty("prod.database.password"));
	}
		
	
}
