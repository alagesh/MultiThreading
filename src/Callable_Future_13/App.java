package Callable_Future_13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class App {
	
	/*
	 * Callable - get results from threads and allow threads to throw exceptions
	 * Future - allows you to control your threads, checking to see if they are running or not, waiting for results 
	 * and even interrupting or descheduling them 
	 */
	public static void main(String[] args) {
		
	
		
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future =  executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				  Random random = new Random();
				  
	              int duration = random.nextInt(1000);
	              if(duration > 100) {
	            	  throw new IOException("Sleeping for too long");
	              }
	            	  
	              System.out.println("Starting ...");
	                try {
	                    Thread.sleep(duration);
	                } catch (InterruptedException ignored) {}
	                System.out.println("Finished.");
	                
	                return duration;
	                
			}
			
		});
		
		executor.shutdown();
		
		try {
			//The get value is obtained after the thread is completed with the job
			System.out.println("Result is: "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());			
		}
		
		
	}

}
