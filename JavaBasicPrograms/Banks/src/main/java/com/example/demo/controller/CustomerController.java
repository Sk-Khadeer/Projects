package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerDto;
import com.example.demo.service.CustomerSer;


@RestController
public class CustomerController {
@Autowired
private CustomerSer cs;
@PostMapping("/save")
public Customer save(@RequestBody CustomerSer c)
{
	return cs.save(c);
	}






//@PostMapping("/saves")
//public ResponseEntity<Set<Customer>> create(@RequestBody CustomerDto dto){
//	return new ResponseEntity<Set<Customer>>(cs.create(dto),HttpStatus.CREATED);
//}
}
