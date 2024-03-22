package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.dao.UserRepo;
import com.example.modal.User;



@SpringBootApplication
public class SbOracleDb1Application {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext context=SpringApplication.run(SbOracleDb1Application.class, args);
		UserRepo ur=context.getBean(UserRepo.class);
		User u=new User(0, null);
		u.setFirstName("KHADEER");
		User u1=ur.save(u);
		System.out.println(u1);
				
	
		
	}

}
