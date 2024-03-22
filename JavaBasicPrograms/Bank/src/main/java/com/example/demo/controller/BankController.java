package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BankLoans;
import com.example.demo.repository.Join;

@RestController
public class BankController {

	@Autowired
	private Join jr;
	
	@PostMapping("/save")
	public BankLoans save(@RequestBody BankLoans bl) {
		return jr.save(bl);
	}
	
	
}
