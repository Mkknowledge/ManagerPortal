package com.mkknowledge.managerportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mkknowledge.managerportal.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {
	
	private List<Employee> employees = createList();
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> listEmployee() {
		return employees;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}
	
	private static List<Employee> createList() {
		
		String pattern = "MM/dd/yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		List<Employee> tempEmployees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setEmpId("1");
		emp1.setFirstname("Mayur");
		emp1.setLastname("Kandalkar");
		emp1.setAddress("Nanded City");
		try {
			emp1.setDob(format.parse("21/06/1992"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee emp2 = new Employee();
		emp2.setEmpId("2");
		emp2.setFirstname("Shital");
		emp2.setLastname("Mohite");
		emp2.setAddress("Shivne");
		try {
			emp2.setDob(format.parse("02/08/1994"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

}
