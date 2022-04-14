package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.services.KafkaService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;
	
	@GetMapping("post/{message}")
	public String postMessage(@PathVariable("message") String message)
	{
		return kafkaService.postMessage(message);
	}
}
