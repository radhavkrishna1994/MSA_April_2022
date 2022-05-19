package com.training.config;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.kafka.KafkaItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	Logger log = LoggerFactory.getLogger(SpringBatchConfig.class);
	@Bean
	Job job(JobBuilderFactory jobBuilderFactory) {
		return jobBuilderFactory.get("job")
				.incrementer(new RunIdIncrementer())
				.start(start())
				.build();
	}

	@Bean
	KafkaItemReader<String, String> kafkaItemReader() {
		Properties props = new Properties();
		props.putAll(this.properties.buildConsumerProperties());
		return new KafkaItemReaderBuilder<String, String>()
				.partitions(0).consumerProperties(props)
				.name(“customer-reader”).saveState(true)
				.topic(“customer-topic”).build();
	}

	@Bean
	Step start() {
		ItemWriter writer = new ItemWriter<String>() {
			@Override
			public void write(List<? extends String> items) 
					throws Exception {
				items.forEach(item -> 
				System.out.println(“Consumed Message “ + item));
			}
		}; 
		return stepBuilderFactory.get(“job”)
				.chunk(0)
				.reader(kafkaItemReader())
				.writer(writer)
				.build();
	}
}
