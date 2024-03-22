package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", Email=" + Email + "]";
}
public User(int id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	Email = email;
}
private String name;

private String Email;
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


public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
