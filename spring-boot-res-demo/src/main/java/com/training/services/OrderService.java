package com.training.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.model.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String producerUrl = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";

	@CircuitBreaker(name="test",fallbackMethod = "defaultFallBack()")
	public Order createOrder(Long isbn,int qty)
	{
		HashMap<String,String> map=new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		Order order = restTemplate.getForObject(producerUrl, Order.class, map);
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty);
		return order;
	}

	public Order defaultFallBack(Long isbn,int qty,Exception e) {
		
		return new Order(null, producerUrl, null, null, 0, null);
	}
}
