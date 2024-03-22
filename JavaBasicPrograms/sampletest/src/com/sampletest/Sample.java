package com.sampletest;
import java.util.*;
class Sample {
	
  public static Set<String> getPermutation(String str) {
    Set<String> permutations = new HashSet<String>();

     if (str.length() == 0) {
      permutations.add("");
      return permutations;
    }
    char first = str.charAt(0);//b
//    System.out.println(first);
    String sub = str.substring(1);
    Set<String> words = getPermutation(sub);
//    System.out.println("word------"+words);
    for (String strNew : words) {
      for (int i = 0;i<=strNew.length();i++){
    	 // System.out.println(strNew.length()+"--->"+strNew.substring(0, i)+"--->"+first+"--->"+strNew.substring(i)+"---");
        permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
      }
    }
  //  System.out.println(permutations.size());
    return permutations;
  }
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the string: ");
    String data = input.nextLine();
    System.out.print("Permutations of :  " + data  + getPermutation(data));
    
   }
}