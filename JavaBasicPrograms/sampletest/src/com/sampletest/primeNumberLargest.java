package com.sampletest;

import java.util.*;

public class primeNumberLargest {
public static void main(String[] args) {
	int i, number, count,largest,q=0;; 
	List<Integer> b=new ArrayList<Integer>();
	System.out.print("Enter Range :");	
	Scanner s=new Scanner(System.in);
	int c=s.nextInt();
	System.out.print("Prime Numbers from 1 to 100 are :---:  ");	
	for(number = 1 ;number <= c; number++){
		count = 0;
	    for (i = 2; i <number; i++) {
	    	if(number % i == 0) {
	    		count=1;
	    		break;
	    	}
	    }
	    if(count==0 )
	    {
	     b.add(number);
	    	
	    }
	  }
	 System.out.println(b);
	
	 largest = 0;
     for (Integer k : b) {
         if (k>largest)
        	 largest = k;
     }
     System.out.println("The maximum prime value between 1 and "+c + " is :---: "+largest);                    
    
     System.out.print("Non-Prime Numbers which is not divisble by 2 to 10 in given range :---: ");
     for(int k=120;k<c;k++)
     {
         int p=0;
         for(int j=2;j<=10;j++)
         {
             if(k%j==0){
                 p=1;
                 break;
             }
         }
         if(p==0)
         {
        	
             for(int m=2;m<=k/2;m++)
             {
                 if(k%m==0){
                	 q=1;
                     System.out.print(k+" ");
                     break;
                 }
              }
          }
         
     }
     if(q==0)
    	 System.out.println("Sorry ,u didn't have any numbers ");
     
}
}
