package com.mkknowledge.managerportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mkknowledge.managerportal.model.Manager;
import com.mkknowledge.managerportal.repository.ManagerRepository;

public class ManagerDetailsService implements UserDetailsService{

	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager manager =  managerRepository.findByUsername(username);
		
		CustomManagerDetails managerDetails = null;
		if(manager!=null) {
			managerDetails = new CustomManagerDetails();
			managerDetails.setManager(manager);
		}else {
			throw new UsernameNotFoundException("Manager not found with name: " + username);
		}
		
		
		
		return null;
	}

}
