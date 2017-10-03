package Semaphore_12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	/*
	 * Semaphores : same as mutex but allows only x number of threads to enter (Eg: to limit CPU /IO/RAM usage)
	 */
	public static void main(String args[]) throws InterruptedException {
		
		//Semaphore with one permit is basically a lock
		//Semaphore sem = new Semaphore(10);
		
		// Acquire decrements the count by 1 .. If total permit 0, acquire waits for it to become available
		//sem.acquire();
		// Release increments the count by 1
		//sem.release();
		//System.out.println("Available permits:"+sem.availablePermits());
		
				
		//Connection.getInstance().connect();
		
		//Create thread pool with executorservice
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<200;i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
				
						Connection.getInstance().connect();
					
				}
				
			});
		}
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		
	}

}
