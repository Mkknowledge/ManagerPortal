package com.mkknowledge.managerportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkknowledge.managerportal.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	Optional<Manager> findByUsername(String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
