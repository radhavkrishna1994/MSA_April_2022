package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.model.Book;
import com.training.repo.BookRepo;

@SpringBootApplication
public class SpringBootBookProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookProducerApplication.class, args);
	}
	
	@Autowired
	private BookRepo bookRepo;
	
	@PostConstruct
	public void saveBooks()
	{
		bookRepo.save(new Book(1234l, "C", 120.50, 100l));
		bookRepo.save(new Book(3456l, "CPlus", 150.50, 100l));
		bookRepo.save(new Book(5678l, "Python", 170.50, 100l));
	}

}
