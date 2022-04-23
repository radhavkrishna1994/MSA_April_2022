package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.OrderedBook;
import com.training.services.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RequestMapping("/orders")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@CircuitBreaker(fallbackMethod = "getDefault", name = "fallbackmethod")
	@GetMapping("/isbn/{isbn}/qty/{qty}")
	public OrderedBook createOrder(@PathVariable("isbn") Long isbn,@PathVariable("qty") int quantity)
	{
		return orderService.createOrder(isbn, quantity);
	}


	public OrderedBook defaultFallBack(long isbn,int qty,Throwable e)
	{
		return new OrderedBook();
	}
}
