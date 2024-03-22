package com.exception.programs;

import java.util.Scanner;

public class TryWithMultipleCatch {

	public static void main(String[] args) {
	Scanner s= new Scanner(System.in);
	int a[]= {10,20,30,40,50,0};
	System.out.print("ENTER THE VALUE :");
	int b=s.nextInt();
	System.out.print("ENTER THE VALUE :");
	int c=s.nextInt();
	try {
		float result=(a[b]/a[c]);
		System.out.println("RESULT OF "+a[b]+"/"+a[c]+" : "+result);
	}
	catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("your index position is out of range,please try again with present index in array");
	}
	
	catch(Exception e) {
		System.out.println("ERROR OCCURED :"+e.getMessage());
	}
	}

}
