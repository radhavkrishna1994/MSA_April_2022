package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.training.model.Order;

@Service
public class KafkaService {

	private static final String TOPIC = "kafka_topic";
	
	private static final String TOPIC1 = "kafka_topic1";
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate1;
	
	@Autowired
	private KafkaTemplate<String, List<Order>> kafkaTemplate2;
		
	public String postMessage(String message)
	{
		kafkaTemplate1.send(TOPIC,message);
		return "published";
	}
	
	public void postOrders(List<Order> orders) {
		
		ListenableFuture<SendResult<String,List<Order>>> future = kafkaTemplate2.send(TOPIC1, orders);
		
		future.addCallback(new ListenableFutureCallback<Object>() {

			@Override
			public void onSuccess(Object result) {
			System.out.println(result);
			}

			@Override
			public void onFailure(Throwable ex) {
				
				/*
				 * try { Thread.sleep(50000); } catch (InterruptedException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			System.out.println("Exception :"+ex.getMessage());
			
			}
	
		
		});
		
		
	}
}
