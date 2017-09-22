package WaitAndNotify_8;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException{
		
		
		synchronized(this) {
			System.out.println("Producer thread running..");
			wait();
			System.out.println("Resumed...");
		}
	}
	
	public void consume() throws InterruptedException{
		
		Scanner scanner = new Scanner(System.in);
		
		//Make sure produce thread runs first 
		Thread.sleep(2000);
		
		synchronized(this) {
			System.out.println("Waiting on return key");
			scanner.nextLine();
			System.out.println("Return key pressed");
			
			/*
			 * Notify can be called only inside synchronized code block
			 * Notify will wake up thread waiting on the lock & relinquish the current lock  
			 * NotifyAll - will wake up all threads sleeping on the lock
			 */
			
			notify();
		}
	}
}
