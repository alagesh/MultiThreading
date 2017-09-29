package ReentrantLocks_10;

/*
 * Lock and condition variable:
 * Lock: an object that can only be owned by a single thread at any given time. Basic operations on a lock: acquire & release
 * Lock provides : Mutual Exclusion
 * Condition Variable: Synchronization mechanism needs more than mutual exclusion;
 *  also need a way to wait for another thread to do some action.
 *  used to wait for a particular condition to become true.
 *  methods: wait ( on a condition,lock) , signal (condition,lock), broadcast(condition,lock)
 *  https://web.stanford.edu/class/cs140/cgi-bin/lecture.php?topic=locks
 *  
 *  Disadvantage of Reentrant lock : Deadlock scenario if one of the thread signals but never unlocks 
 *   
 */
public class App {

	 public static void main(String[] args) throws Exception {
		 /*
		  * Create two threads and make them run 2 different methods: firstThread & secondThread
			 * Output:
			 * Thread 1: Waiting...
			 * Thread 2: Press Return key !
			 * Thread 2: Increment ++
			 * Thread 1: Woke up
			 * Thread 1: Increment ++
			 * Count is : 2000
		 */
		 
	 final Runner runner = new Runner();
     Thread t1 = new Thread(new Runnable() {
         public void run() {
             try {
                 runner.firstThread();
             } catch (InterruptedException ignored) {
             }
         }
     });

     Thread t2 = new Thread(new Runnable() {
         public void run() {
             try {
                 runner.secondThread();
             } catch (InterruptedException ignored) {
             }
         }
     });

     t1.start();
     t2.start();
     t1.join();
     t2.join();
     runner.finished();
     
	 }
}
