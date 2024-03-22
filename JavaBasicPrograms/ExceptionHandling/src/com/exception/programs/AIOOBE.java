package com.exception.programs;

public class AIOOBE {

	public static void main(String[] args) {
		try {
			int a[]=new int[10];
			a[11]=1;
			}
		catch(ArrayIndexOutOfBoundsException e)
		{
		e.printStackTrace();
		}
	}

}
