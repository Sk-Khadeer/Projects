package practice;

import java.util.ArrayList;

//without toString
//public class ObjectMethods {
//public ObjectMethods(String name, int no) {
//		this.name = name;
//		this.no = no;
//	}
//String name;
//int no;
//public static void main(String[] args) {
//	ObjectMethods o=new ObjectMethods("sridhar", 1);
//	ObjectMethods o1=new ObjectMethods("khadeer", 2);
//	System.out.println(o);
//	System.out.println(o.toString());
//	System.out.println(o1);
//}
//}

//with toString
//public class ObjectMethods {
//public ObjectMethods(String name, int no) {
//		this.name = name;
//		this.no = no;
//	}
//
//@Override
//public String toString() {
//	return "ObjectMethods [name=" + name + ", no=" + no + "]";
//}
//
//String name;
//int no;
//public static void main(String[] args) {
//	ObjectMethods o=new ObjectMethods("sridhar", 1);
//	ObjectMethods o1=new ObjectMethods("khadeer", 2);
//	System.out.println(o);
//	System.out.println(o1);
//}
//}


//all wrapperclasses,collections,string are overridden already toString methods no need to write explicitly
public class ObjectMethods {

public static void main(String[] args) {
	String s=new String("khadeer");
	System.out.println(s);
	Integer i=new Integer(10);
	System.out.println(i);
	ArrayList l=new ArrayList();
	l.add(10);
	l.add("sridhar");
	l.add("aswanth");
	System.out.println(l);
	ObjectMethods o=new ObjectMethods();
	System.out.println(o);
}
}
