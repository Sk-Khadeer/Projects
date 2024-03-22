package com.passwordEncoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passwordEncoder.entity.Customer;
import com.passwordEncoder.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Customer cus) {
		customerService.saveCustomer(cus);
		return new ResponseEntity<>("Successfully added customer", HttpStatus.OK);
	}
}
