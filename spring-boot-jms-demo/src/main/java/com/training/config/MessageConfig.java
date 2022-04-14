package com.training.config;

import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MessageConfig {

	@Value("${test-queue}")
	private String testQueue;



	@Bean public ActiveMQQueue getActiveMQ() { return new
			ActiveMQQueue(testQueue); }

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory()
	{
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		//factory.setTrustedPackages(Arrays.asList("com.training.model"));
		factory.setTrustAllPackages(true);
		return factory;
	}

}
