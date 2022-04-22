package com.training.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class MyCustomFilter extends AbstractGatewayFilterFactory<MyCustomFilter.Config>{

	public static class Config
	{
		
	}
	
	public MyCustomFilter()
	{
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		
		return (exchange,chain)->{
			
			System.out.println("First Pre Filter");
			System.out.println(exchange.getRequest().getPath());
			System.out.println(exchange.getRequest().getMethod());
			ServerHttpResponse response = exchange.getResponse();
			System.out.println(response.getStatusCode());
			
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				
				System.out.println("First Post Filter");
			}));
			
		};
	}
	
	
	
}
