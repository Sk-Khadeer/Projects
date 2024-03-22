package com.exception.programs;

public class NumberFormatException {

	public static void main(String[] args) {
		try {
			int a=Integer.parseInt("ABC");
			System.out.println(a);
			
		}
      catch(Exception e) {
	  //System.out.println(e.printStackTrace());
    	  System.out.println(e.getMessage());
     }
	}

	


}
