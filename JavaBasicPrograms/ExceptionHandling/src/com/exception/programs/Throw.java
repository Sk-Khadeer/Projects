package com.exception.programs;

public class Throw {
public static void validate(int age) {
	if(age<18) {
		throw new RuntimeException("person is not eligible for vote");
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
validate(13);
	}

}
