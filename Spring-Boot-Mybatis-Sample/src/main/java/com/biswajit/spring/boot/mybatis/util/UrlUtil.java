package com.biswajit.spring.boot.mybatis.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;

import com.biswajit.spring.boot.mybatis.view.UrlResponse;

public class UrlUtil {

public static List<UrlResponse> getUrls(){
	
	List<UrlResponse> urls = new ArrayList<UrlResponse>();
	
	String base = "http://localhost:8080/EmployeeService";
	
	UrlResponse url1 = new UrlResponse();
	
	url1.setUrl(base +"/heartbeat");
	url1.setType(RequestMethod.GET);
	url1.setPurpose("Health checkup");
	
	UrlResponse url2 = new UrlResponse();
	
	url2.setUrl(base +"/addEmployee");
	url2.setType(RequestMethod.POST);
	url2.setPurpose("Add new employee");
	
	UrlResponse url3 = new UrlResponse();
	
	url3.setUrl(base +"/updateEmployee");
	url3.setType(RequestMethod.PUT);
	url3.setPurpose("Update employee details");
	
	UrlResponse url4 = new UrlResponse();
	
	url4.setUrl(base +"/getEmployee/{id}");
	url4.setType(RequestMethod.GET);
	url4.setPurpose("Get employee details by ID");
	
	UrlResponse url5 = new UrlResponse();
	
	url5.setUrl(base +"/getEmployees");
	url5.setType(RequestMethod.GET);
	url5.setPurpose("Get all employee details");
	
	UrlResponse url6 = new UrlResponse();
	
	url6.setUrl(base +"/deleteEmployee/{id}");
	url6.setType(RequestMethod.DELETE);
	url6.setPurpose("Delete employee by ID");
	
	urls.add(url1);
	urls.add(url2);
	urls.add(url3);
	urls.add(url4);
	urls.add(url5);
	urls.add(url6);
	
	return urls;
}
	
}
