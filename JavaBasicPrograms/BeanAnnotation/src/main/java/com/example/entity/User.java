package com.example.entity;

public class User {
	private String name;

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public String getName() {
		return name;
	}
	public User(String name) {
		this.name=name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
