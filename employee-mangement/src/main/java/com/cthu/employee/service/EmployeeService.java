package com.cthu.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cthu.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	void create(Employee employee);
	
	Employee getEmployeeById(int id);
	
	void deleteEmployeeById(int id);
	
	Page<Employee> findPagenated(int pageNo, int pageSize);
}
