package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.services.AOPService;

@SpringBootApplication
public class SpringBootAopDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopDemoApplication.class, args);
	}

	@Autowired
	private AOPService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(service.getName());
		
		System.out.println(service.getSalary());
		
	}
	
	

}
