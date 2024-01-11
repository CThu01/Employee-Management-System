package com.cthu.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cthu.employee.model.Employee;
import com.cthu.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String index(Model model) {
		return findPagenated(1, model);
	}
	
	@GetMapping("employeeForm")
	public String employeeForm(Model model) {
		var employee = new Employee();
		model.addAttribute("employee",employee);
		return "newEmployeeForm";
	}
	
	@PostMapping("createEmployee")
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.create(employee);
		return "redirect:/";
	}
	
	@GetMapping("updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "updateEmployee";
	}
	
	@GetMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	@GetMapping("page/{pageNo}")
	public String findPagenated(@PathVariable("pageNo") int pageNo,Model model) {
		
		int pageSize = 5;
		Page<Employee> page = employeeService.findPagenated(pageNo, pageSize);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listEmployee",listEmployees);
		
		return "index";
	}
	
	
	
	
}




















