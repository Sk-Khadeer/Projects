package practice;

public class Runnable1 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=5;i++) {	System.out.println("runnable");}
	}

	public static void main(String[] args) {
		
Runnable1 r=new Runnable1();
Thread t1=new Thread();
Thread t2=new Thread(r);

//t1.start();
//t2.start();
r.run();
for(int i=0;i<=5;i++) {	System.out.println("main");}
	}

}
