package com.training.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private Long custId;
	
	private String name;
	
		
	@OneToMany
	private List<Account> accounts;
	
	public String toString()
	{
		return custId+" "+name;
	}
}
