package com.mkknowledge.managerportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkknowledge.managerportal.model.Employee;
import com.mkknowledge.managerportal.service.EmployeeService;
import com.mkknowledge.managerportal.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/")
	public String login() {
		return "Success";
	}

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employees")
	public List<Employee> listEmployee() {
		return employeeService.listAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/employees/employee/{id}")
	public Employee getEmployee(@PathVariable(value = "id") Long id) {
		Employee emp = employeeService.get(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		return emp;
		
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee user) {
		return employeeService.save(user);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee empDetails) {

		Employee emp = employeeService.get(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		emp.setFirstname(empDetails.getFirstname());
		emp.setLastname(empDetails.getLastname());
		emp.setEmail(empDetails.getEmail());
		emp.setAddress(empDetails.getAddress());
		emp.setDob(empDetails.getDob());
		emp.setMobile(empDetails.getMobile());
		emp.setCity(empDetails.getCity());
		
		Employee updateEmployee = employeeService.save(emp);
		
		return updateEmployee;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		
		Employee emp = employeeService.get(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		employeeService.delete(id);
				/*
				 * if (emp == null) { throw new ResourceNotFoundException("Employee", "id", id);
				 * }else { employeeService.delete(id); }
				 */
		return ResponseEntity.ok().build();
	}
	
	

}
