package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con= SpringApplication.run(DependencyInjectionApplication.class, args);
	Students s=con.getBean(Students.class);
	s.display();
	}

}
