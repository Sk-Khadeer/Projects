package practice;
// SYNCHORIZED METHOD
class Display
{
	//if we wont declare method as Synchorization then o/p is "0A1BC23D"
	//if we declare method as  Synchorization then o/p is "0123ABCD"
	public synchronized void wish() 
	{
		for(int i=0;i<=3;i++) 
		{
			System.out.print(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
	public synchronized void wish1() 
	{
		for(int i=65;i<=68;i++) 
		{
			System.out.print((char)i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
}
class display1 extends Thread{
	Display d;
	
	display1(Display d){
		this.d=d;
		
		}
	public void run() {
		d.wish();
	}
	
}
class display2 extends Thread{
	Display d;
	
	display2(Display d){
		this.d=d;
		
		}
	public void run() {
		d.wish1();
	}
	
}


public class Synchorization1 {

	public static void main(String[] args) {
		Display d=new Display();
		
		display1 b1=new display1(d);
		display2 b2=new display2(d);
		b1.start();
		b2.start();
	}

}
