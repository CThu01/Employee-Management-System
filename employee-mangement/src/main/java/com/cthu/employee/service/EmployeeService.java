package com.cthu.employee.service;

import java.util.List;

import com.cthu.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	void create(Employee employee);
	
	Employee getEmployeeById(int id);
	
	void deleteEmployeeById(int id);
}
