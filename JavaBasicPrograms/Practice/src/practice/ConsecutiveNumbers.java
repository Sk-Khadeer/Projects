package practice;

public class ConsecutiveNumbers {
public static void main(String[] args) {
	 int a[]= {1,3,2 };
     for(int i=0;i<a.length;i++) {
         for(int j=0;j<a.length;j++) {
             if(a[i]<a[j]) {
                 int temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
             }
         }
     }
     for(int c:a) {
         System.out.print(c+" ");
     } 
     int count=0;
     for(int i=0;i<a.length-1;i++) {
         if(a[i]==a[i+1]-1) {
             count++;//1
         }
     }
     if(a[a.length-1]==a[a.length-2]+1) {
         count++;
     }
     System.out.println();
     System.out.println(a.length+" - "+count);
     if(a.length==count)
         System.out.println("The given array is consecutive");
     else
             System.out.println("The given array is not consecutive");

	
}
}
