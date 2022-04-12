package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.repo.CustomerRepo;

@SpringBootApplication
public class SpringBootMongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbDemoApplication.class, args);
	}

	@Autowired
	private CustomerRepo repo;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			
			System.out.println(repo.findByName("sam"));
			
			System.out.println(repo.getCustomersByName("sam"));
			System.out.println(repo.getCustomersByAge(18));
		};
	}
}
