package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@RestController
public class Controller {
	@Autowired
	CustomerService cs;
	
	@GetMapping("/li")
    public List<Customer> getList()
	{
    return cs.getList();
    }

}
