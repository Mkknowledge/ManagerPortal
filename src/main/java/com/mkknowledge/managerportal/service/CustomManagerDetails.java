package com.mkknowledge.managerportal.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mkknowledge.managerportal.model.Manager;

public class CustomManagerDetails implements UserDetails{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7544124329827294840L;
	private Manager manager;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return manager.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return manager.getPassword();
	}

	@Override
	public String getUsername() {
		return manager.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
