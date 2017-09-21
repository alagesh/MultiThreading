package SynchronizedKeyword_3;

public class App {
	
	private int count =0;
	
	/*
	 * Synchronized: Let's only one thread inside the function at a time
	 * Avoids: Race condition
	 */
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
				
	
		
	}
	
	public void doWork() {
		
		/*
		 * Create 2 threads to increment value of global variable using function
		 */
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increment();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					increment();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		/*
		 * Join: The main thread waits until the completion of thread on which it is joined
		 * Eg: t1.join() , main thread waits until the completion of thread t1
		 */
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 *  Finally print the value of global variable : count
		 *  Using synchronized keyword on the method, the global variable is
		 *  Guaranteed to increment to 2000
		 */
		
		System.out.println("Final value of count:"+ count);
	}
	
	

}
