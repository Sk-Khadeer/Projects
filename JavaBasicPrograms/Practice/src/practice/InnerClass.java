package practice;
//Accessing inner class code from static area of outer class
//public class InnerClass 
//{
//	class Inner
//	{
//		public void m1() 
//		{
//			System.out.println("inner class");
//		}
//		public static void main(String[] args) {
//			InnerClass o=new InnerClass();
//			InnerClass.Inner i=o.new Inner();
//			i.m1();
//			//or
//			InnerClass.Inner i1=new InnerClass().new Inner();
//			i1.m1();
//			//or
//			new InnerClass().new Inner().m1();
//		}}
//}


//Accessing inner class code from instance area of outer class
//public class InnerClass 
//{
//	class Inner
//	{
//		public void m1() 
//		{
//			System.out.println("inner m1");
//		}
//	}
//		public void m2() 
//		{
//			Inner i=new Inner();
//			i.m1();
//			}
//		public static void main(String[] args) {
//			InnerClass o=new InnerClass();
//			o.m2();
//			}
//}

//Accessing inner class code from outside of outer class
//class Outer
//{
//	class Inner
//	{
//		public void m1() 
//		{
//			System.out.println("inner class method");
//		}
//	}
//}
//public class InnerClass {
//		public static void main(String[] args) {
//			Outer o=new Outer();
//			Outer.Inner i=o.new Inner();
//			i.m1();
//			
//			}
//}


//accessing variables 
//public class InnerClass {
//	int x=10;
//	class Inner{
//		int x=100;
//		public void m1() {
//			int x=1000;
//			System.out.println(x);
//			System.out.println(this.x);//or System.out.println(Inner.this.x);
//			System.out.println(InnerClass.this.x);
//		}
//	}
//	public static void main(String[] args) {
//		new InnerClass().new Inner().m1();
//		}
//}


//Nesting innerclass
//class X{
//	class B{
//		class C{
//			public void m1() {
//				System.out.println("innermost class method");
//			}
//		}
//	}
//}
//
//public class InnerClass {
//	public static void main(String[] args) {
//		X a=new X();
//		X.B b=a.new B();
//		X.B.C c=b.new C();
//		c.m1();
//	}
//}


//with out Anonymous class(normal class)
//class MyRunnable1 implements Runnable
//{
//	@Override
//	public void run() {
//		for(int i=0;i<2;i++) {	System.out.println("run");}
//	}
//}
//public class InnerClass{
//	public static void main(String[] args) {
//		MyRunnable1 m=new MyRunnable1();
//		Thread t=new Thread(m);
//		t.start();
//		for(int i=0;i<2;i++) {	System.out.println("main");}
//	}
//}



//Anonymous inner class
//public class InnerClass{
//	public static void main(String[] args) {
//		Runnable m=new Runnable() {
//			public void run() {
//				for(int i=0;i<2;i++) {	System.out.println("run");}
//			}
//		};
//		Thread t=new Thread(m);
//		t.start();
//		for(int i=0;i<2;i++) {	System.out.println("main");}
//	}
//}

public class InnerClass{
	public static void main(String[] args) {
	new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<2;i++) {	System.out.println("run");}
			}
		}).start();
		for(int i=0;i<2;i++) {	System.out.println("main");}
	}
}











