package com.training.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Movie {
	
	private long movieId;
	private String title;
	private String genre;
	//add lombok

}
