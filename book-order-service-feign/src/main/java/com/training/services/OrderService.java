package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.config.OrderConfiguration;
import com.training.model.OrderedBook;
import com.training.proxy.OrderFeign;

@Service
public class OrderService {
	
	@Autowired
	private OrderFeign orderFeign;
		
	public OrderedBook createOrder(Long isbn,int quantity)
	{
		OrderedBook orderedBook = orderFeign.createOrder(isbn);
		orderedBook.setQuantity(quantity);
		orderedBook.setAmount(orderedBook.getPrice() * quantity);
		
		return orderedBook;
		
	}

}
