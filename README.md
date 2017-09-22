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
1. **CountDown Latch** - Java class to aid in synchronization. Multiple threads wait on the coundown to become 0. <br/>Example of CountDownLatch is similar to catering food where the main thread waits on completion of all individual orders.<br/>
1. **Producer Consumer** - Implementation of Producer - Consumer pattern, where one/ many threads produces data and stores in shared data structure and other threads are removing/consuming data. Thread safe datastructure used: BlockingQueue
1. **Wait & Notify** - Wait - calling thread gives up the lock and goes to sleep. Notify - wakes up the first thread which called wait.

