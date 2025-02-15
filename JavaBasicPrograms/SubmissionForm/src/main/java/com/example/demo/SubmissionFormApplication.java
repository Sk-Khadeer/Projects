package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.SubmissionFormApplication;
@ComponentScan
@SpringBootApplication
public class SubmissionFormApplication extends SpringBootServletInitializer {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder apk) {
		return apk.sources(SubmissionFormApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SubmissionFormApplication.class, args);
	}

}
