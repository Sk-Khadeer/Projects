package com.example.modal;

public class User {
private String name;
@Override
public String toString() {
	return "User [name=" + name + ", Location=" + Location + ", age=" + age + "]";
}
private String Location;
private String age;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}

}
