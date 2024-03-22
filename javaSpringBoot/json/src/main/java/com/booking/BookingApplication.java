package com.booking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<MyJson> list=new ArrayList<>();
		MyJson json=new MyJson();
		json.setId(1);
		json.setName("sridhar");
		String[] address= {"hyd","kmm"};
		json.setAddress(address);
		list.add(json);
		MyJson json1=new MyJson();
		json1.setId(2);
		json1.setName("ashok");
		String[] address1= {"kmm","hyd"};
		json1.setAddress(address1);
		list.add(json1);
		String jsonString=null;
		try {
			 jsonString=mapper.writeValueAsString(json);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			mapper.writeValue(new File("C:\\Users\\user181\\Documents\\json\\data.json"), list);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
