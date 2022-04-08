package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;

@RequestMapping("/bookstore/api")   // localhost:8081/bookstore/api
@RestController
public class BookController {

	@GetMapping("/hello")      // localhost:8081/bookstore/api/hello
	public String sayHello()
	{
		return "Hello Spring Boot";
	}
	
	@GetMapping("/book")  //localhost:8081/bookstore/api/book
	public Book getBook()
	{
		return new Book(1234l, "Let Us C", 150.25, 100l);
	}

	
}






