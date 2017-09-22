package CountDownLatch_6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Example of CountDownLatch is similar to catering food where the main thread waits
 * on completion of all individual orders.
 * 
 */
class Processor implements Runnable{

	/*
	 * No Need for synchronized , as CountDownLatch is thread safe class
	 * Disadvantage: Cannot be resued once the latch value becomes zero
	 */
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Latch value at process init : "+ latch.getCount());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		latch.countDown();
		
		System.out.println("Latch value at process completion : "+ latch.getCount());
		
	}
	
	
}

public class App {

	public static void main(String[] args) {
	/*
	 * Java class to aid in synchronization.
	 * Multiple threads wait on the coundown to become 0
	 */
	
	System.out.println("Started....");
	CountDownLatch latch = new CountDownLatch(3);
	
	ExecutorService exec = Executors.newFixedThreadPool(3);
	
	for(int i=0;i<3;i++) {
		exec.submit(new Processor(latch));
	 }
	
	//Make the main thread wait on the countdown to become zero 
	try {
		latch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Completed....");
}
}
