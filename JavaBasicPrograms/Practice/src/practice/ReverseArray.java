package practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ReverseArray {
public static void main(String[] args) {
//Integer []a= {8,9,10,12,13,3,4,6,5};
//Set<Integer> s
//= new LinkedHashSet<Integer>();
//	for(int i=0;i<a.length-1;i++) {
//		int b=a[i+1];
//		int c=a[i]+1;
//		if(b==c) {
//			s.add(a[i]);
//			s.add(a[i+1]);
//		}
//	}
//	System.out.println(s);
	
	
	int arry[]= {0,2,76,76,77,77,89,90,90,100,0};
    if(arry[0]+1==arry[1])
        System.out.print(arry[0]+" ");
    for(int i=1;i<arry.length-1;i++) {
        if(arry[i]==arry[i-1]+1 || arry[i]+1==arry[i+1]) {
            System.out.print(arry[i]+" ");
        }
    }
    if(arry[arry.length-1]==arry[arry.length-2]+1)
        System.out.println(arry[arry.length-1]);
	

//	int nums[] = {1,2,3,4};
//	int b[]= {0,0,0,0};
//	int a[][] = {{1,0},{-3,1},{-4,0},{2,3}};   //Output: [8,6,2,4]
//			int c=a[0][0];
//			int d=nums[0];
//			int e=c+d;
//			 nums[0]=e;
//			 int sum=0;
//			  for(int f=0;f<nums.length;f++) {
//				 if(nums[f]%2==0) 
//					 sum=sum+nums[f];
//				}
//			 b[0]=sum;
//			
//			 int c1=a[1][0];
//			 int d1=nums[1];
//			 int e1=c1+d1;
//			nums[1]=e1;
//			 int sum1=0;
//			  for(int f=0;f<nums.length;f++) {
//				 if(nums[f]%2==0) 
//					 sum1=sum1+nums[f];
//				}
//			 b[1]=sum1;
//			
//			 int c2=a[2][0];
//			 int d2=nums[0];
//			 int e2=c2+d2;
//			 nums[0]=e2;
//			 int sum2=0;
//			 
//			 for(int f=0;f<nums.length;f++) {
//				 if(nums[f]%2==0) 
//					 sum2=sum2+nums[f];
//				}
//			 b[2]=sum2;
//			
//			 int c3=a[3][0];
//			 int d3=nums[3];
//			 int e3=c3+d3;
//			 nums[3]=e3;
//			 int sum3=0;
//			  for(int f=0;f<nums.length;f++) {
//				 if(nums[f]%2==0) 
//					 sum3=sum3+nums[f];
//				}
//			 b[3]=sum3;
//			 
//			 for(int k:b)
//				{
//					 System.out.print(k+" ");
//				}
			

	
			 
			
			 
 }
}
