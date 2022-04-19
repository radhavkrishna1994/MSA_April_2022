package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.MyConfig;


@RestController
public class TestController {
	
	@Autowired
	private MyConfig config;
	
	@GetMapping("/message")
	public String getMessage()
	{
		return config.getMessage();
	}

}
