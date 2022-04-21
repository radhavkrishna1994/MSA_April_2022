package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.User;
import com.training.services.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@GetMapping(value = "/userstream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersStream()
	{
		return userService.getUsersStream();
	}
	
	@GetMapping(value = "/usersstreamdb",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersStreamDb()
	{
		return userService.getUsersStreamDb().log();
	}
	
	@PostMapping
	public void saveUser(@RequestBody User user)
	{
		userService.saveUser(user);
	}
	
	@GetMapping(value = "/userstreamdb/{id}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<User> getUsersStreamDb1(@PathVariable("id") Long id)
	{
		return userService.getUserStreamDb(id);
	}
}


