package com.biswajit.spring.boot.mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biswajit.spring.boot.mybatis.model.Employee;

/**
 * @author Biswajit Mohapatra
 * 
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	 @Autowired
	 private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Employee> getEmployees() throws Exception {
	
		List<Employee> employees=  sqlSessionTemplate.selectList("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.findAllEmployees");
		
		return employees;
	}

	public Employee getEmployee(int empId) throws Exception {
	
		Employee employee =sqlSessionTemplate.selectOne("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.findEmployeeById", empId);
		
		return employee;
	}

	public void createEmployee(Employee employee) throws Exception {
		
		sqlSessionTemplate.insert("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.insertEmployee", employee);
		
	}

	public String deleteEmployee(int empId) throws Exception {
		
		Employee employee =sqlSessionTemplate.selectOne("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.findEmployeeById", empId);
		
		if(employee == null){
			
			return "Employee with empid "+ empId + " does not exist in our Database." ;
		}
		else{
			sqlSessionTemplate.delete("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.deleteEmployeeById", empId);
			return "Employee with empid "+ empId + " successfully deleted from our database." ;
		}
	}

	public void updateEmployee(Employee employee) throws Exception {
		sqlSessionTemplate.update("com.biswajit.spring.boot.mybatis.mapper.EmployeeMapper.updateEmployee", employee);
		
	}

}
