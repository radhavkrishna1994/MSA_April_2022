package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.services.TestService;

@RestController
public class TestController {


	@Autowired
	private TestService testService;

	@GetMapping("/call1")
	public String circuitBreaker() {
		return testService.circuitBreaker();
	}
}
