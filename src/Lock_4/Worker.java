package Lock_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	
	 private Random random = new Random();

	 /*
	  * This example is to showcase how in a multithreaded system, 
	  * Synchronized Block is faster than Synchronized method.
	  * Example: Thread1 can execute Stagae1 and Thread2 executes Stage2 as the lock is at block level 
	  * Lock objects to create synchronized block
	  */
	    private final Object lock1 = new Object();
	    private final Object lock2 = new Object();

	    /*
	     * Shared objects 
	     */
	    private List<Integer> list1 = new ArrayList<>();
	    private List<Integer> list2 = new ArrayList<>();

	    public void stageOne() {

	        synchronized (lock1) {
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {		            	
	                e.printStackTrace();
	            }
	            list1.add(random.nextInt(100));
	        }
	    }

	    public void stageTwo() {
	    	
	        synchronized (lock2) {
	            try {
	                Thread.sleep(1);
	            } catch (InterruptedException e) {	            	
	                e.printStackTrace();
	            }
	            list2.add(random.nextInt(100));
	        }

	    }

	    public void process() {
	        for (int i = 0; i < 1000; i++) {
	            stageOne();
	            stageTwo();
	        }
	    }

	    public void main() {
	        System.out.println("Starting ...");
	       
	        long start = System.currentTimeMillis();
	        Thread t1 = new Thread(new Runnable() {
	            public void run() {
	                process();
	            }
	        });

	        Thread t2 = new Thread(new Runnable() {
	            public void run() {
	                process();
	            }
	        });

	        t1.start();
	        t2.start();

	        try {
	            t1.join();
	            t2.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        long end = System.currentTimeMillis();

	        System.out.println("Time taken: " + (end - start));
	        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	    }
}
