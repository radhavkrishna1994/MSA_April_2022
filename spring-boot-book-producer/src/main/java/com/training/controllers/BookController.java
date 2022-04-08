package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;
import com.training.services.BookServiceI;

@RequestMapping("/bookstore/api")   // localhost:8081/bookstore/api
@RestController
public class BookController {

	@Autowired
	private BookServiceI bookService;
	
	@GetMapping("/hello")      // localhost:8081/bookstore/api/hello
	public String sayHello()
	{
		return "Hello Spring Boot";
	}
	
	@GetMapping("/book/isbn/{isbn}")  //localhost:8081/bookstore/api/book/isbn/1234
	public Book getBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.getBook(isbn);
	}

	@GetMapping("/books")  //localhost:8081/bookstore/api/books
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
}






