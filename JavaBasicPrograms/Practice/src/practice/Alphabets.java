package practice;

import java.util.Scanner;

public class Alphabets 
{
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the input value :");
	String s=sc.next();
	String s1=sc.nextLine();
		char c[]=s.toCharArray();
	    for(int j=0;j<c.length;j++)
		{
			if((c[j]<65 || c[j]>90)&&(c[j]<97 || c[j]>122))
			{
	    	 System.out.print(c[j]+" ");
			}
			
			int n=26;
			int b=0;
			for(char ch='a';ch<='z';ch++) 
			{
				if(ch==c[j])
				{
					//System.out.print(n+"->"+ch+" ");
					System.out.print(n+" ");
					b=1;
				
				}
				n--;
			}
			if(b==0)
			{
				n=26;
				for(char ch='A';ch<='Z';ch++) 
				{
					if(ch==c[j])
					{
						//System.out.print(n+"->"+ch+" ");
						System.out.print(n+" ");
					}
				n--;
				}
			}
			}
	    
	}
}
