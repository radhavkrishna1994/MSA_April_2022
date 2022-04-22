package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGatewayServiceApplication.class, args);
	}
	
	/*
	 * @Bean public RouteLocator routes(RouteLocatorBuilder builder) { return
	 * builder .routes() .route(p->p.path("/helloservice1/**")
	 * .filters(f->f.addRequestHeader("Authorization", "Bearer hsdhshzxavv")
	 * .addResponseHeader("my-response-header", "This is a response Header"))
	 * //.uri("http://localhost:8080")) .uri("lb://service1"))
	 * .route(p->p.path("/helloservice2/**")
	 * .filters(f->f.addRequestHeader("Authorization", "Bearer hsdhshzxavv")
	 * .addResponseHeader("my-response-header", "This is a response Header"))
	 * //.uri("http://localhost:8081")) .uri("lb://service2")) .build();
	 * 
	 * }
	 */
	
	@Bean
	public GlobalFilter globalFilter() {
		
		return (exchange,chain)->{
			System.out.println("First Global Filter");
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				
				System.out.println("First Post Global Filter");
			}));
		};
	}

}
