package com.example.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerDto;
import com.example.demo.entity.Loan;
import com.example.demo.repo.CustomerRepo;

import lombok.Data;
@Data
@Service
public class CustomerSer {
	
private Customer c;
@Autowired private CustomerRepo cr;

public Customer save(CustomerSer cs){
    return cr.save(cs.getC());
 }

//
//public Set<Customer> create(CustomerDto dto){
//	Set<Bank> bankList=dto.getB();
//	Set<Loan> loanList=dto.getL();
//	Set<Customer> customerList=dto.getC();
//	bankList.forEach(b->b.setL(loanList));
//	loanList.forEach(l->l.setC(customerList));
//	customerList.forEach(c->c.setB(bankList));
//	cr.saveAll(customerList);
//	return customerList;
//}



}
