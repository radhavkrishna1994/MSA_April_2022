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


import com.training.model.Customer;
import com.training.services.CustomerService;

@RequestMapping("/customers/api")   // localhost:8081/bookstore/api
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/hello")      // localhost:8081/bookstore/api/hello
	public String sayHello()
	{
		return "Hello Spring Boot";
	}
	
	@GetMapping("/customer/id/{id}")  //localhost:8081/bookstore/api/book/isbn/1234
	public Customer getCustomer(@PathVariable("id") Long id)
	{
		return customerService.getCustomer(id);
	}

	@GetMapping 
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@DeleteMapping("/customer/id/{id}") 
	public Customer deleteBook(@PathVariable("id") Long id)
	{
		return customerService.deleteCustomer(id);
	}
	
	/*
	 * @PutMapping("/book/isbn/{isbn}/stock/{newstock}") public Book
	 * updateBook(@PathVariable("isbn") Long isbn,@PathVariable("newstock") Long
	 * newstock) { return bookService.updateBookStock(isbn, newstock); }
	 */
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
}






