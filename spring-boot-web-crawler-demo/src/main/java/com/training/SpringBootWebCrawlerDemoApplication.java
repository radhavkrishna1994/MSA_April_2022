package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.services.WebCrawlerService;

@SpringBootApplication
public class SpringBootWebCrawlerDemoApplication {

	@Autowired
	private WebCrawlerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebCrawlerDemoApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{

			service.crawl();
		};
	}
}
