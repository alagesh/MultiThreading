package DeadLock_11;

/*
 * Deadlock: describes a situation where two or more threads are blocked forever, waiting for each other.
 */
	
	
	public class App {

	  
	    
	    /*
	     * It is a program that purposely causes deadlock between two threads that	    
	     * are both trying to acquire locks for the same two resources.
	     * 
	     */
	    
		 public static void main(String[] args) throws Exception {
			  final Object resource1 = "resource1";
			  final Object resource2 = "resource2";
			  
			  System.out.println("Creating 2 threads");
			    
			 Thread t1= new Thread(new Runnable() {

				@Override
				public void run() {
				
					  synchronized(resource1){
				          System.out.println("Thread 1: locked resource 1");				         
				          try{ 
				            Thread.sleep(50); 
				          } catch (InterruptedException e) {}
				          
				          //Now wait 'till we can get a lock on resource 2
				          synchronized(resource2){
				            System.out.println("Thread 1: locked resource 2");
				          }
				          
					  }
				}
				 
			 });
			 
			 Thread t2 = new Thread(new Runnable() {

				@Override
				public void run() {
					  synchronized(resource2){
				          System.out.println("Thread 2: locked resource 2");				         
				          try{ 
				            Thread.sleep(50); 
				          } catch (InterruptedException e) {}
				          
				          //Now wait 'till we can get a lock on resource 2
				          synchronized(resource1){
				            System.out.println("Thread 2: locked resource 1");
				          }
						
				          
					  }
				}
			 
			 });
			 
			 //Start both the threads
			 
			 t1.start(); 
			 t2.start();
			 
			 t1.join();
		     t2.join();
		     
		     System.out.println("This log won't be printed because of deadlock");
			 
		 }
	}


