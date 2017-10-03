# MultiThreading
Exercises from Java Multithreading course by John Purcell
<br/><br/>
Course link on Udemy: https://www.udemy.com/java-multithreading/learn/v4/overview 

## Notes

1. **Hello World** - Two ways of starting threads 
   1. Extends Thread class
   1. Implement Runnable and pass it to constructor of thread class
1. **Volatile Keyword** - Set shared variable to volatile to avoid caching between threads
	 and guarantees that any thread will read the most recent written values
1. **Synchronized keyword** - Let's only one thread inside the function at a time.**Avoids:** Race condition
1. **Lock** - This example is to showcase how in a multithreaded system, Synchronized Block is faster than Synchronized method. 
1. **Thread Pool** - Threadpool contains collection of worker threads. Once a thread completes a task in threadpool, it is recycled to complete pending tasks
		executor.shutdown();ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		});
		executor.shutdown();
1. **CountDown Latch** - Java class to aid in synchronization. Multiple threads wait on the coundown to become 0. <br/>Example of CountDownLatch is similar to catering food where the main thread waits on completion of all individual orders.<br/>
1. **Producer Consumer** - Implementation of Producer - Consumer pattern, where one/ many threads produces data and stores in shared data structure and other threads are removing/consuming data. Thread safe datastructure used: BlockingQueue
1. **Wait & Notify** - Wait - calling thread gives up the lock and goes to sleep. Notify - wakes up the first thread which called wait & once the thread finishes the synchronized block , the lock is relinquished. Invoking notify doesn't relinquish the lock.
1. **Low Level Sync** - Implemented producer consumer pattern using low level synchronization techniques : wait & notify
1. **Reenterant locks** - Implemented reenterant lock with two theads and used await and signal for synchronization.
   **Lock:** an object that can only be owned by a single thread at any given time. Basic operations on a lock: acquire & release
  Lock provides : **Mutual Exclusion**  
  **Condition Variable:** Synchronization mechanism needs more than mutual exclusion;also need a way to wait for another thread to do some 	  action.used to wait for a particular condition to become true.  
  methods: wait (condition,lock) , signal (condition,lock), broadcast(condition,lock)
   https://web.stanford.edu/class/cs140/cgi-bin/lecture.php?topic=locks   
   Disadvantage of Reentrant lock : **Deadlock** scenario if one of the thread signals but never unlocks 
1. **Deadlocks** - Situation where two or more threads are blocked forever, waiting for each other.
1. **Semaphores** - Difference between lock , mutex and semaphore
	1. Lock - one thread at a time enters that's locked  and not shared with other processes.
	1. Mutex- same as lock but can be system wide ( shared by multiple processes)
	1. Semaphore - same as mutex but allows only x number of threads to enter  (Eg: to limit CPU /IO/RAM usage)
https://stackoverflow.com/questions/2332765/lock-mutex-semaphore-whats-the-difference?noredirect=1&lq=1
   
   
