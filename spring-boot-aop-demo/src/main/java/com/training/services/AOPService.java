package com.training.services;

import org.springframework.stereotype.Service;

@Service
public class AOPService {
	
	public String getName()
	{
		return "sam";
	}
	
	public Double getSalary()
	{
		return 10000.50;
	}
	
	public void setName(String name)
	{
		System.out.println("Setting name");
	}
}
