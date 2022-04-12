package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping
	public String sayHello()
	{
		return "Hello ! Welcome to Spring Security";
	}
	
	@GetMapping("/user/hello")
	public String sayHelloUser()
	{
		return "Hello User ! Welcome to Spring Security";
	}
	
	@GetMapping("/user/hello1")
	public String sayHello1User()
	{
		return "Hello User again ! Welcome to Spring Security";
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin()
	{
		return "Hello Admin ! Welcome to Spring Security";
	}
}
