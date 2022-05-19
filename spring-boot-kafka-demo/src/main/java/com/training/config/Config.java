package com.training.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {
	
	
	  @Bean public NewTopic topicExample() { return
	  TopicBuilder.name("my-kafka-topic-new") .partitions(6) .replicas(2) .build(); }
	 

}
