package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.entity.Address;
import com.microservice.repository.AddressRepo;

@Service
public class AddressService {
	@Autowired
	private AddressRepo addressRepo;

	public Address getAddress(Long id) {
		System.out.println(id);
		Address address = addressRepo.findById(id).get();
		System.out.println(address);
		return address;
	}

	public void save(Address e) {
		addressRepo.save(e);
	}
}
