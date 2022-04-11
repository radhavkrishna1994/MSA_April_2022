package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.model.Customer;
import com.training.repo.CustomerRepo;

@Service
public class CustomerService  {

	@Autowired
	private  CustomerRepo customerRepo;

	
	public Customer addCustomer(Customer Customer) {
		
		return customerRepo.save(Customer);
	}

	
	public List<Customer> getCustomers() {

		return customerRepo.findAll();
	}

	
	public Customer getCustomer(Long isbn) {

		Optional<Customer> customerOp = customerRepo.findById(isbn);
		Customer customerFound=null;
		if(customerOp.isPresent()) {
			customerFound=customerOp.get();

			return customerFound;
		}
		return null;
	}

	public Customer deleteCustomer(Long isbn) {

		Optional<Customer> customerOp = customerRepo.findById(isbn);
		Customer customerFound=null;
		if(customerOp.isPresent()) {
			customerFound=customerOp.get();
			customerRepo.delete(customerFound);

			return customerFound;}
		return null;
	}


	/*
	 * public Customer updateCustomerStock(Long isbn, Long newStock) {
	 * Optional<Customer> CustomerOp = CustomerRepo.findById(isbn); Customer
	 * CustomerFound=null; if(CustomerOp.isPresent()) {
	 * CustomerFound=CustomerOp.get();
	 * CustomerFound.setStock(CustomerFound.getStock()+newStock);
	 * 
	 * CustomerRepo.save(CustomerFound); return CustomerFound; } return null; }
	 */
}
