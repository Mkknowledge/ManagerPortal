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
	
	@CrossOrigin(origins = "*")
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/manager/validateLogin" })
	public Manager loginManager(HttpServletRequest request) {
		
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		System.out.print("username" + username + "password" + password);
		Manager mg = managerRepository.findByUsername(username);
		
		if(mg == null) {
			System.out.println("user not found");
			return null;
		}else {
			 System.out.println("Username :::: " + mg.getUsername().trim());
			 System.out.println("\n encoder Match :::: " + bCryptPasswordEncoder.matches(password.trim(), mg.getPassword().trim()));
			 
			if(mg.getUsername().trim().equals(username.trim())) {
				System.out.println("success");
				return mg;
			}else {
				System.out.println("failed");
				return null;
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
