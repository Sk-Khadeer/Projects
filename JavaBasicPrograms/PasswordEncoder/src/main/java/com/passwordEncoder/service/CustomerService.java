package com.passwordEncoder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.passwordEncoder.entity.Customer;
import com.passwordEncoder.repo.CustomerRepo;

@Service("customerService")
public class CustomerService {


    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer saveCustomer(Customer customerData) {
    	 Customer customer = new Customer();
         customer.setFirstName(customerData.getFirstName());
         customer.setLastName(customerData.getLastName());
         customer.setEmail(customerData.getEmail());
         customer.setPassword(passwordEncoder.encode(customerData.getPassword()));
         
              return customerRepository.save(customer);
    }

    
}