package com.training.proxy;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.model.OrderedBook;

@FeignClient(name="book-producer-service")//,url = "http://localhost:8081")
@LoadBalancerClient(name="book-producer-service")
public interface OrderFeign {

	@GetMapping("/bookstore/api/book/isbn/{isbn}")
	public OrderedBook createOrder(@PathVariable("isbn") Long isbn);
}
