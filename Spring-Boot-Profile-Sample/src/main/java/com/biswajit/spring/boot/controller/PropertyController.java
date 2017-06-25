package com.biswajit.spring.boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.spring.boot.bean.DatasourceBean;
import com.biswajit.spring.boot.bean.ProfileBean;

@RestController
public class PropertyController {
	
@Autowired
private ProfileBean profileBean;

@Autowired
private DatasourceBean datasource;

/**
 * @author Biswajit Mohapatra
 *
 */

@RequestMapping(value="/",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public String verifyProfileMode(){
	
	StringBuilder sb= new StringBuilder();
	
	sb.append("App is running at "+profileBean.getName()).append("\n\n");
	
	sb.append("You are connected to " +profileBean.getName() + " DB").append("\n");
	
	sb.append("DB details are :").append("\n\n");
	
	sb.append(datasource.getName()).append("\n");
	sb.append(datasource.getUrl()).append("\n");
	sb.append(datasource.getUsername()).append("\n");
	sb.append(datasource.getPassword()).append("\n");
		
	return sb.toString();
}




}
