package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repo.UserRepo;

@SpringBootApplication
public class Login1Application implements CommandLineRunner {
@Autowired
	private UserRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(Login1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Employee());
		
	}

}
