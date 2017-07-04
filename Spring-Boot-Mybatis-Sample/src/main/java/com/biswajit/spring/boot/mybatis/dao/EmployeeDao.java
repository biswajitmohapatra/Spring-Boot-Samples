package com.biswajit.spring.boot.mybatis.dao;

import java.util.List;

import com.biswajit.spring.boot.mybatis.model.Employee;

/**
 * @author Biswajit Mohapatra
 * 
 */

public interface EmployeeDao {

	public List<Employee> getEmployees() throws Exception;
	
	public Employee getEmployee(int empId) throws Exception;
	
	public void createEmployee(Employee employee) throws Exception;
	
	public void updateEmployee(Employee employee) throws Exception;
	
	public String deleteEmployee(int empId) throws Exception;
}
