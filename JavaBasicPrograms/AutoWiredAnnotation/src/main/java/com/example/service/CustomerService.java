package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Customer;
@Service
public class CustomerService {
	private static List<Customer> li=new ArrayList<Customer>();
    static {
	Customer c=new Customer();
    c.setId(1);
    c.setName("khadeer");
    c.setAge(24);
	li.add(c);
	 c=new Customer();
	    c.setId(2);
	    c.setName("sreedar");
	    c.setAge(24);
		li.add(c);
		 c=new Customer();
		    c.setId(3);
		    c.setName("aswanth");
		    c.setAge(24);
			li.add(c);
}

public List<Customer> getList(){
	return li;
}

}
