package com.example.entity;

import javax.validation.constraints.NotNull;

public class Customer {
	@NotNull(message="name should not be null")
	private String name;
	@NotNull(message="loc should not be null")
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", location=" + location + "]";
	}
	
}
