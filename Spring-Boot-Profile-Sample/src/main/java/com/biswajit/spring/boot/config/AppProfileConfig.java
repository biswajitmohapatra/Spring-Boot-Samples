package com.biswajit.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.biswajit.spring.boot.bean.ProfileBean;

/**
 * @author Biswajit Mohapatra
 *
 */
@Configuration
public class AppProfileConfig {

	@Bean(name="profileBean")
	@Profile(value="DEV")
	public ProfileBean devProfile(){
		return new ProfileBean("DEV");
	}
		
	@Bean(name="profileBean")
	@Profile(value="QA")
	public ProfileBean qaProfile(){
		return new ProfileBean("QA");
	}
	
	@Bean(name="profileBean")
	@Profile(value="PROD")
	public ProfileBean prodProfile(){
		return new ProfileBean("PROD");
	}
}
