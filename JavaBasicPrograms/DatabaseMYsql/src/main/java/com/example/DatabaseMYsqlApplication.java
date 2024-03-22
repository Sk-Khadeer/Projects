package com.example;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.dao.UserRepo;
import com.example.entities.User;

@SpringBootApplication
public class DatabaseMYsqlApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=  SpringApplication.run(DatabaseMYsqlApplication.class, args);
	UserRepo userRepo=context.getBean(UserRepo.class);
	
	User user=new User(0, null, null);
	user.setName("khadeer");
	user.setEmail("khadeer@gmail.com");
	User user1=userRepo.save(user);
	System.out.println(user1);
	
	
	}

}
