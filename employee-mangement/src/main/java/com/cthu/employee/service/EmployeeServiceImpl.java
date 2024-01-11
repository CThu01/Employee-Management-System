package com.cthu.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cthu.employee.model.Employee;
import com.cthu.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public void create(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Page<Employee> findPagenated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1 , pageSize);
		return employeeRepo.findAll(pageable);
	}

}
