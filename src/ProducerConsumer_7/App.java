package ProducerConsumer_7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 *  Implementation of Producer - Consumer pattern
 *  Data structure used: BlockingQueue
 */

public class App {
	
	/*
	 * Thread safe class
	 * First in - First out datastructure 
	 */
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
	
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
	
	private static void producer() throws InterruptedException {
		
		Random random = new Random();
		
		// For sake of simplicity, run it in infinite loop
		
		while (true) {
			
				/*
				 * put method will patiently wait once the queue is fill 
				 * and once value removed it will start re filling the queue
				 */
				queue.put(random.nextInt(100));
			
		}
	}
	
	
	private static void consumer() throws InterruptedException {
		
		//For sake of simplicity, run it in infinite loop
		while(true) {
			Thread.sleep(100);
			//Randomly take an item from queue
			
			Random random = new Random();
			if(random.nextInt(10)==0) {
				/*
				 * take method will patiently wait if the queue is empty 
				 * and once the value is added it will take element out of queue
				 */
				Integer value = queue.take();
				System.out.println("Taken value:"+ value+ "..Queue size is:"+ queue.size());
				
			}
		}
	}
	
}
