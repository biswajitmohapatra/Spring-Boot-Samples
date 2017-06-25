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

@Profile(value="QA")
@Configuration
@PropertySource(value="classpath:qaDatasource.properties",ignoreResourceNotFound=true)
public class AppQADatabaseConfig {

 @Autowired
 private Environment env;
	
	@Bean(name="datasource")
	public DatasourceBean devDatasorceBean(){
		return new DatasourceBean(env.getProperty("qa.database.name"), env.getProperty("qa.database.url"), env.getProperty("qa.database.username"), env.getProperty("qa.database.password"));
	}
		
	
}
