package com.mkknowledge.managerportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/manager/validateLogin" })
	public String loginManager(HttpServletRequest request) {
		
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		Manager mg = managerRepository.findByUsername(username);
		
		if(mg == null) {
			return "User Not Found";
		}else {
			if(mg.getUsername() == username && mg.getPassword() == password) {
				return "SUCCESS";
			}else {
				return "FAILURE";
			}
		}
		
	}

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
