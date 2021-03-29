package com.mkknowledge.managerportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ManagerPortalApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ManagerPortalApplication.class, args);
	}

}
