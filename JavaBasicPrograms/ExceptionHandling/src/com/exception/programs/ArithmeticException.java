package com.exception.programs;

public class ArithmeticException {

	public static void main(String[] args) {
		try {
			System.out.println((10/0));
			}
		catch(Exception e)
		{
		//System.out.println(e.printStackTrace());
		//System.out.println(e);  java.lang.ArithmeticException: / by zero
		System.out.println(e.getMessage()); 
		}	
		}

}
