package com.mkknowledge.managerportal.service;

import org.springframework.transaction.annotation.Transactional;

import com.mkknowledge.managerportal.model.Employee;
import com.mkknowledge.managerportal.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public Optional< Employee > get(long id) {
		return employeeRepository.findById(id);
	}
	
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}

}
