package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User1")
public class Employee {
	@Id
	private int id;
	private String name;
 
public Employee() {
		
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

 @Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + "]";
}

 
}
