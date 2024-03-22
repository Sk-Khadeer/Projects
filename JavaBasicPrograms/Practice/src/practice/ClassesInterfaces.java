package practice;
//1.......class inside class
//public class ClassesInterfaces {
//		class Inner
//		{
//			public void m1() 
//			{
//				System.out.println("inner class");
//			}
//			
//	public static void main(String[] args) {
//		ClassesInterfaces o=new ClassesInterfaces();
//		ClassesInterfaces.Inner i=o.new Inner();
//		i.m1();
//		//or
//		ClassesInterfaces.Inner i1=new ClassesInterfaces().new Inner();
//		i1.m1();
//		//or
//		new ClassesInterfaces().new Inner().m1();
//	}}
//}

//2............Interface inside class
//public class ClassesInterfaces
//{
//	interface inner
//	{
//		public void m();
//	}
//	class bus implements inner
//	{
//		public void m()
//		{
//			System.out.println("bus");
//		}
//	}
//	class car implements inner
//	{
//			public void m()
//			{
//				System.out.println("car");
//			}
//	}
//	public static void main(String[] args) {
//		ClassesInterfaces c=new ClassesInterfaces();
//		ClassesInterfaces.bus b=c.new bus();
//		b.m();
//		ClassesInterfaces.car c1=c.new car();
//		c1.m();
//	}
//}

//3.............Interface inside interface
//interface outer{
//	public void m1();
//	interface Inner{
//		public void m2();
//	}
//}
//class Test1 implements outer
//{
//	@Override
//	public void m1() 
//	{
//		System.out.println("outer interface");
//	}
//}
//class Test2 implements outer.Inner
//{
//	@Override
//	public void m2() {
//		// TODO Auto-generated method stub
//	System.out.println("inner interfaces");	
//	}
//}
//public class ClassesInterfaces{
//	public static void main(String[] args) {
//		Test1 t=new Test1();
//		t.m1();
//		Test2 t2=new Test2();
//		t2.m2();
//	}	
//}

//4..............class inside interface
interface Bank{
	public String roi();
	class DeflautBank implements Bank
	{
		@Override
		public String roi() 
		{
			return 5+"%";
		}
		
	}
}
class Sbi implements Bank
{
	@Override
	public String roi() 
	{
		return 6+"%";
	}
	
}
class Axis implements Bank
{
	@Override
	public String roi() {
	 return 3+"%";
	}
}
public class ClassesInterfaces{
	public static void main(String[] args) {
		Bank.DeflautBank d=new Bank.DeflautBank();
		System.out.println("Default bank  :"+d.roi());
		
	Sbi s=new Sbi();
	System.out.println("Sbi bank   :"+s.roi());
	Axis a=new Axis();
	System.out.println("Axis bank  :"+a.roi());
	}
}
