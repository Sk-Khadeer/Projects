package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.customer.repo.CustomerRepository;
import com.example.modal.ProductModel;
import com.example.modal1.CustomerModel;
import com.example.product.repo.ProductRepository;

@RestController
@RequestMapping("save")
public class CustomerCont {
	@Autowired
	private CustomerRepository cr;
	@Autowired
	private ProductRepository pr;
	@PostMapping("/cust")
	public CustomerModel save(@RequestBody CustomerModel cm) {
		return cr.save(cm);
	}
	@PostMapping("/prod")
	public ProductModel save(@RequestBody ProductModel cm) {
		return pr.save(cm);
	}
}
