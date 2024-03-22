package com.sampletest;

import java.util.Scanner;

public class Gb 
{
  public static void main(String[] args)
  {
	Scanner s=new Scanner(System.in);
	System.out.print("How much GB is used :");
	int i=s.nextInt();
	
	int a=1,b=2,c=3,d,e=i-500,f=500,g,h,j,k,x;
	
	if(i>0 && i<=500)
	{
	   d=i*a;
	  System.out.println("Total amount u have to pay------- "+d);
	}
	if(i>=501 && i<=1000) 
	{
		e=i-500;
		if(f>0 && f<=500)
		{
			g=f*a;
			h=e*b;
			x=g+h;
			System.out.println("Total amount u have to pay------- "+x);
		}
	}
	if(i>=1001) 
	{
		e=i-500;
	 	k=e-500;
	 	if(f>0 && f<=500) 
	 	{
	 		g=f*a;
		 	h=f*b;
		 	j=k*c;
		 	x=g+h+j;
		 	System.out.println("Total amount u have to pay------- "+x);
	 	}
	}
  }
}
