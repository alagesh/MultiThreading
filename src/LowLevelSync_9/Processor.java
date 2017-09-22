package LowLevelSync_9;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT=10;
	
	private Object lock  = new Object();

	public void produce() throws InterruptedException{
		
		int value =0;
		
		while(true) {
			
			synchronized(lock) {
				
				//Once the list reaches the limit , make the producer thread to sleep
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);	
				
				lock.notify();
			}
			
		}
	}
	
	public void consume() throws InterruptedException{
		
		while(true) {
			synchronized(lock) {
				
				while(list.size() ==0) {
					lock.wait();
				}
				
			System.out.print("List size is: "+list.size());
			int value = list.removeFirst();
			System.out.println(" ; value removed is: "+value);
			lock.notify();
			}
			Thread.sleep(new Random().nextInt(1000));	
		}
	}

}
