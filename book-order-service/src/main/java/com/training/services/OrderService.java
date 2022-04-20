package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.config.OrderConfiguration;
import com.training.model.OrderedBook;

@Service
public class OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderConfiguration config;
	
	//private String producerUrl = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";
	
	public OrderedBook createOrder(Long isbn,int quantity)
	{
		Map<String,String> map = new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		OrderedBook orderedBook = restTemplate.getForObject(config.getUrl(), OrderedBook.class, map);
		orderedBook.setQuantity(quantity);
		orderedBook.setAmount(orderedBook.getPrice() * quantity);
		
		return orderedBook;
		
	}

}
