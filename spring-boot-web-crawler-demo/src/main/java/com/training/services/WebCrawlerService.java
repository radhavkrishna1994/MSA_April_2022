package com.training.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.training.model.Movie;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Arrays;

@Service
public class WebCrawlerService {
	
	@Autowired
	private Sinks.Many<Movie> movieSinks;
	//http://localhost:8083/movies/
	
	public void crawl()
	{
		Mono<Movie[]> movieMono = WebClient
		.create()
		.get()
		.uri("http://localhost:8083/movies")
		.retrieve()
		.bodyToMono(Movie[].class);
		
		
		
		
		movieMono.subscribe(movieArray->Arrays.stream(movieArray).collect(Collectors.toList())
				.forEach(movie->{
					//System.out.println(movie);
					movieSinks.tryEmitNext(movie);
					
				}));
		
	}

}
