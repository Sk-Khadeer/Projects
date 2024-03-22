package com.microservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.Employee;
import com.microservice.repository.EmployeeRepo;
import com.microservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeee(@PathVariable("id") Long id) {
//		String address=restTemplate.getForObject("http://localhost:8083/address", String.class);
		return employeeService.getEmployeee(id);
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Employee e) {
		System.out.println(e);
		employeeService.save(e);
		return "saved";
	}
}
