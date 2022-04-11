package com.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="account_no")
	private Long accountNo;
	
	private Double balance;
	
	@Column(name="account_type")
	private String accountType;
		
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;
	
}