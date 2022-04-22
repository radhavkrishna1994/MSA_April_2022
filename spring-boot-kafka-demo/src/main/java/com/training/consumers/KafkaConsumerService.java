package com.training.consumers;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.training.model.Movie;
import com.training.model.Order;

@Component
public class KafkaConsumerService {

	/*
	 * @KafkaListener(topics = "kafka_topic",groupId = "test-consumer-group") public
	 * void receiveMessage(String message) {
	 * System.out.println("Message Received:"+message); }
	 * 
	 * @KafkaListener(topics = "kafka_topic1",groupId = "test-consumer-group")
	 * public void receiveOrder(List<Order> orders) {
	 * System.out.println("Order Received:"+orders); }
	 */
	
	
	@KafkaListener(topics = "movie-out-topic",groupId = "test-consumer-group")
	public void receiveMovies(List<Movie> movies)
	{
		System.out.println("Movies Received:"+movies);
	}
	
}
