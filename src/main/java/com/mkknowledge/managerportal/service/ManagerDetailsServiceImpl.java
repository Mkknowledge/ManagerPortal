package com.mkknowledge.managerportal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mkknowledge.managerportal.model.Manager;
import com.mkknowledge.managerportal.repository.ManagerRepository;

@Service
public class ManagerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ManagerRepository managerRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Manager manager = managerRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return ManagerDetailsImpl.build(manager);
	}
}