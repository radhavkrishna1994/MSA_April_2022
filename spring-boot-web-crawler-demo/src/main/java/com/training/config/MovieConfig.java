package com.training.config;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.model.Movie;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class MovieConfig {

    @Bean
    public Sinks.Many<Movie> movieSinks(){
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<Movie>> orderSupplier(Sinks.Many<Movie> sinks){
       return sinks::asFlux;
    }
}