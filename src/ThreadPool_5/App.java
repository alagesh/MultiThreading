package ThreadPool_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting:"+id);
		
		//Make the thread sleep for 5 seconds 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		System.out.println("Completed:"+id);
	}
	
}

public class App {
	
	public static void main(String[] args) {
		
		/*
		 * Threadpool contains collection of worker threads.
		 * Once a thread completes a task in threadpool, it is recycled to complete pending tasks
		 */
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		//Assigning 5 tasks and using the threadpool with 2 threads and recycle them
		for(int i=0;i<5;i++) {
			exec.submit(new Processor(i));
		}
		
		//Stop accepting new task after completion of all tasks 
		exec.shutdown();
		
		System.out.println("All tasks submitted");
		
		//Max wait time for the tasks to complete
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks Completed");
	}
}
