package com.training.consumers;

import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class MessageConsumer {

	@JmsListener(destination = "in-memory-queue")
	public void receive(String message)
	{
		System.out.println("Received Message:"+ message);
	}
	/*
	 * @JmsListener(destination = "external-queue") public void receive1(String
	 * message) { System.out.println("Received Message:"+ message); }
	 */

	
	  @JmsListener(destination = "external-queue") 
	  public void receive1(List<Order>
	  order) { System.out.println("Received order:"+ order); }
	 

}
