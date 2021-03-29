package com.mkknowledge.managerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkknowledge.managerportal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
