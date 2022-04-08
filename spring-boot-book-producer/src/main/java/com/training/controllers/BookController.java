package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
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
	public ResponseEntity<Book> getBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.getBook(isbn);
	}

	@GetMapping("/books")  //localhost:8081/bookstore/api/books
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
	@DeleteMapping("/book/isbn/{isbn}") 
	public Book deleteBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{newstock}") 
	public Book updateBook(@PathVariable("isbn") Long isbn,@PathVariable("newstock") Long newstock)
	{
		return bookService.updateBookStock(isbn, newstock);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
}






