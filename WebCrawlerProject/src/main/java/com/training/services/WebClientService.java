package com.training.services;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.training.model.Movie;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {
	
	private String uri = "http://localhost:8083/movies";
	
	public void crawlMovies()
	{
		Mono<Movie[]> movieMono = WebClient.create()
		.get()
		.uri(uri)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(Movie[].class);
		
		movieMono.subscribe(movieArray->Arrays.stream(movieArray).collect(Collectors.toList())
				.forEach(movie->System.out.println(movie)));
	}

}
