package com.biswajit.spring.boot.mybatis.mapper;

import java.util.List;

import com.biswajit.spring.boot.mybatis.model.Employee;

public interface EmployeeMapper {

	    void insertEmployee(Employee employee);
	    
	    void updateEmployee(Employee employee);

	    Employee findEmployeeById(Integer id);

	    List<Employee> findAllEmployees();
	    
	    void deleteEmployeeById(Integer id);
	    
}
