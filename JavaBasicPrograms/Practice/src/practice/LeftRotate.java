package practice;

import java.util.Scanner;

public class LeftRotate {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
        System.out.println("enter a number : ");
        long num=sc.nextLong();
        int arry[]= {1,9,-5,6,7};
        int uparry[]=new int[arry.length];
        int j=0;
        while(num>=arry.length) {
            num=num-arry.length;
        }
        for(long i=num;i<arry.length;i++) {
            uparry[j]=arry[(int) i];
            j++;
        }
        int k=arry.length-j;
        for(int i=0;i<k;i++) {
            uparry[j]=arry[i];
            j++;
        }
        for(int i=0;i<uparry.length;i++)
        {
            System.out.print(uparry[i]+"  ");
        }
		}
		
			
	
	}

