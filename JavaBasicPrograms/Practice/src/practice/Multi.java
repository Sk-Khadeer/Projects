package practice;
class MyThread extends Thread{
	//yield()
//	public void run() {
//		for(int i=0;i<=5;i++) {	System.out.println("run");
//		Thread.yield();
//		}
		
		//join()---waiting main 
	public void run() {
		for(int i=0;i<=3;i++) {	System.out.println("run");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		}
		//join()---waiting child 
//	static Thread mt;
//	public void run() {
//		try {
//			mt.join();
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		for(int i=0;i<=3;i++) {	System.out.println("run");
//		}
	}
}
public class Multi {
public static void main(String[] args) throws InterruptedException {
//	MyThread t=new MyThread();
//	MyThread t1=new MyThread();
//	t.start();
//	t.run();
//	for(int i=0;i<=5;i++) {	System.out.println("main");}
//	System.out.println(Thread.currentThread().getName());
//	System.out.println(t.getName());
//	System.out.println(t1.getName());
//	Thread.currentThread().setName("sridhar");
//	System.out.println(Thread.currentThread().getName());
//	
//	System.out.println("default main priority :"+Thread.currentThread().getPriority());
//	Thread.currentThread().setPriority(7);
//	System.out.println("after setting main :"+Thread.currentThread().getPriority());
//	System.out.println("default child priority :"+t.getPriority());
//	t.setPriority(8);
//	System.out.println("after setting child :"+t.getPriority());
	
	
	//If we use yield method in Mythread then outputs
//	t.start();
//	for(int i=0;i<=5;i++) {	System.out.println("main");}
	
	//If we use join method here
	//1.waiting main
	MyThread t=new MyThread();
	t.start();
	t.join();
	for(int i=0;i<=3;i++) {
	System.out.println("main");
	}
	//2.waiting child
//	MyThread.mt=Thread.currentThread();
//	MyThread t=new MyThread();
//	t.start();
//	for(int i=0;i<=3;i++) {
//	System.out.println("main");
//	Thread.sleep(1000);
//	}
}}

