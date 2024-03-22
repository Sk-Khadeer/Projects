package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stud_details")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	  
	@Column(name="first_name",nullable=false)
private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email",nullable=false)
private String email;
	
	@Column(name="phone",nullable=false)
	private Long phone;
	
	@Column(name="Address",nullable=false)
	private String address;
		
public Student() {
		super();
	}
public Student(String firstName, String lastName, String email,Long phone,String address) {
	super();
	this.phone=phone;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.address=address;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone= phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
