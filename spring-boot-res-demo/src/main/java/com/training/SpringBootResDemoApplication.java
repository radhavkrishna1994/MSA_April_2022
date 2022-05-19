package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;

@SpringBootApplication
public class SpringBootResDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResDemoApplication.class, args);
	}

	@Bean
	public CircuitBreakerConfigCustomizer circuitBreakerConfigCustomizer() {
		return CircuitBreakerConfigCustomizer.of("cb-instanceA",builder -> builder.minimumNumberOfCalls(10)
				.permittedNumberOfCallsInHalfOpenState(15));
	}
}
