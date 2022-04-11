package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;

@SpringBootApplication
public class SpringBootBankDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankDemo.class, args);
	}
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Autowired
	private AccountRepo accountRepo;
	
	// add few records
	@PostConstruct
	public void init()
	{
		
	}
}

