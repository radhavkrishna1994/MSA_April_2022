package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	private static final String TOPIC = "kafka_topic";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate1;
	
	
	public String postMessage(String message)
	{
		kafkaTemplate1.send(TOPIC,message);
		return "published";
	}
}
