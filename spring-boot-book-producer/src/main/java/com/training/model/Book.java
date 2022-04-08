package com.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity  
public class Book {

	@Id  //primary key
	private Long isbn;
	private String title;
	private Double price;
	private Long stock;
	
	
}
