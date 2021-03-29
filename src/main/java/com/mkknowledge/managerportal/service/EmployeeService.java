package com.mkknowledge.managerportal.service;

import org.springframework.transaction.annotation.Transactional;

import com.mkknowledge.managerportal.model.Employee;
import com.mkknowledge.managerportal.repository.EmployeeRepository;

import java.util.List;

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
	
	public void save(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public Employee get(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}

}
