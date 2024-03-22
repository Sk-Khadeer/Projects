package com.exception.programs;

public class SIOOBE {

	public static void main(String[] args) {
	try {
		String s="khadeer";
		System.out.println(s.length());
		char c=s.charAt(0);
		c=s.charAt(40);
		System.out.println(c);
	
	}
	catch(StringIndexOutOfBoundsException e) {
		//System.out.println(e.printStackTrace());
		System.out.println(e.getMessage());
	}

	}

}
