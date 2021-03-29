package com.mkknowledge.managerportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkknowledge.managerportal.model.Manager;
import com.mkknowledge.managerportal.repository.ManagerRepository;

@RestController
@RequestMapping("/secure")
public class ManagerController {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/manager/add")
	public String addManager(@RequestBody Manager manager) {
		
		String password = manager.getPassword();
		String encryptPwd = bCryptPasswordEncoder.encode(password);
		
		manager.setPassword(encryptPwd);
		
		managerRepository.save(manager);
		return "Manager Added Successfully";
	}
}
