package com.biswajit.spring.boot.mybatis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.spring.boot.mybatis.model.Employee;
import com.biswajit.spring.boot.mybatis.service.EmployeeService;
import com.biswajit.spring.boot.mybatis.util.UrlUtil;
import com.biswajit.spring.boot.mybatis.view.Response;
import com.biswajit.spring.boot.mybatis.view.UrlResponse;

/**
 * @author Biswajit Mohapatra
 * 
 */
@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceImpl;

	@RequestMapping(value = "/heartbeat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response heartbeat() {
		Response response = new Response() ;
		response.setMessage("Application is up");
		response.setStatus(HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/url", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UrlResponse> getUrl() {
		return UrlUtil.getUrls();
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Response addEmployee(@RequestBody Employee employee) {
		Response response = new Response() ;
		if (employee == null){
			response.setMessage("Bad Request");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return response;
		}

		try {
			if (employeeServiceImpl.isExist(employee)){
				response.setMessage("Employee with name " + employee.getName() + " is already exist.");
				response.setStatus(HttpStatus.FORBIDDEN);
				return response;
			}

			employeeServiceImpl.createEmployee(employee);
			response.setMessage("Employee successfully added");
			response.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Employee failed to add");
			response.setStatus(HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Employee> getEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();

		try {
			employees.addAll(employeeServiceImpl.getEmployees());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;

	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Employee getEmployee(@PathVariable("id") Integer id) throws Exception {
		return employeeServiceImpl.getEmployee(id);
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Response deleteEmployee(@PathVariable("id") Integer id) throws Exception {
		Response response = new Response() ;
		response.setMessage(employeeServiceImpl.deleteEmployee(id));
		response.setStatus(HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Response updateEmployee(@RequestBody Employee employee) throws Exception {
		Response response = new Response() ;

		if (employee == null){
			response.setMessage("Bad Request");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return response;
		}
		
		if(employee.getId() == null || employee.getId().intValue() <= 0 ){
			response.setMessage("Employee ID is null");
			response.setStatus(HttpStatus.UNAUTHORIZED);
			return response;
		}
		
		try {
			if (employeeServiceImpl.isExistExcept(employee)){
				response.setMessage("Employee with name " + employee.getName() + " is already exist.So System could not update the details");
				response.setStatus(HttpStatus.FORBIDDEN);
				return response;
			}
			
			employeeServiceImpl.updateEmployee(employee);
			response.setMessage("Employee successfully updated");
			response.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("System could not update the details due some error :"+e.getMessage());
			response.setStatus(HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}
	

}
