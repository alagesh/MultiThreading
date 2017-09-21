package HelloWorld_1;

/*
 * Two ways of starting threads 
 * 1) Extends Thread class
 * 2) Implement Runnable and pass it to constructor of thread class
 * 
 * This code is example for starting threads using method (1) - Extends Thread class
 * 
 */

class Runner extends Thread{

	@Override
	public void run() {
		
		//Simple task of iterating and printing many hello world(s)
		for(int i=0;i<5;i++) {
			System.out.println("Hello World - " + i);
		}
		
			try {
				
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}

public class App_Using_Extends {

	public static void main(String[] args) {
		
		//Start 2 threads
		new Runner().start();
		new Runner().start();
		
	}
}
