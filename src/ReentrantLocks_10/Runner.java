package ReentrantLocks_10;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private int count=0;
	
	/*
	 * Reenterant locks - Once a thread acquires a lock and locked it, it can lock it again if it wants to & keeps track 
	 * of how many times it has been locked.
	 * The thread has to unlock it to the same number of times ( usually locked only once)
	 * 
	 */
	
	/*
	 * Output:
	 * Thread 1: Waiting...
	 * Thread 2: Press Return key !
	 * Thread 2: Increment ++
	 * Thread 1: Woke up
	 * Thread 1: Increment ++
	 * Count is : 2000
	 */
	private Lock lock = new ReentrantLock();
	private Condition cond =  lock.newCondition();
	
	private void increment() {
		for(int i=0;i<1000;i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException{
		lock.lock();
		
		System.out.println("Thread 1: Waiting...");
		cond.await();
		System.out.println("Thread 1: Woke up");
		
		/*
		 * Don't use unlock after method as if method throws exception or fails, the lock is never unlocked
		 * Best practise is to use try , catch & finally and ensure lock unlock
		 */
		try {
			System.out.println("Thread 1: Increment ++");	
			increment();
		}finally {
		lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException{
		
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Thread 2: Press Return key !");
		new Scanner(System.in).nextLine();
		
		cond.signal();
		
		try {
			System.out.println("Thread 2: Increment ++");
			increment();
		
		}finally {
			lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println("Count is : "+count);
	}

}
