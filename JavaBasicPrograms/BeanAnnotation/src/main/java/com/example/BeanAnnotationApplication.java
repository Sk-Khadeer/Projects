package com.example;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.service.UserService;

@SpringBootApplication
public class BeanAnnotationApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(BeanAnnotationApplication.class);
	UserService us=ctx.getBean(UserService.class);
	//UserService us=(UserService) ctx.getBean("myBean");
	System.out.println(us.getList());
	ctx.close();
	
	}

}
