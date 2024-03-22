package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.Address;
import com.microservice.service.AddressService;
@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	@GetMapping("/address/{id}")
	public Address getAddress(@PathVariable("id") Long id) {
		return addressService.getAddress(id);
	}
	@PostMapping("/save")
	public String save(@RequestBody Address a) {
		System.out.println(a);
		addressService.save(a);
		return "saved";
	}
}
