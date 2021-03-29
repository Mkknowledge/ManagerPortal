package com.mkknowledge.managerportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mkknowledge.managerportal.model.Employee;
import com.mkknowledge.managerportal.service.EmployeeService;
import com.mkknowledge.managerportal.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(produces = "application/json")
	public List<Employee> listEmployee() {
		return employeeService.listAll();
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		
		Employee emp = employeeService.get(id);
				/*.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));*/
		
		if (emp == null) {
			 throw new ResourceNotFoundException("Employee", "id", id);
		}else {
			employeeService.delete(id);
		}

		return ResponseEntity.ok().build();
	}

}
