package com.mkknowledge.managerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkknowledge.managerportal.model.Manager;
import com.mkknowledge.managerportal.repository.ManagerRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/secure")
public class ManagerController {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/* @PreAuthorize("hasAnyRole('MANAGER')") */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/manager/add")
	public Manager addManager(@RequestBody Manager manager) {
		
		String password = manager.getPassword();
		String encryptPwd = bCryptPasswordEncoder.encode(password);
		
		manager.setPassword(encryptPwd);
		
		return managerRepository.save(manager);
	}
}
