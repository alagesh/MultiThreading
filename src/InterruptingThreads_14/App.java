package InterruptingThreads_14;

import java.util.Random;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				System.out.println("Started..."); 
				
				Random ran = new Random();
				// 1e6 =  1x 10^6 (One million representation
				for(int i=0;i<1E8;i++) {
					
					//One way to check if the thread is interupted is to quiz the thread and check if current thread isInterrupted()
					if(Thread.currentThread().isInterrupted()) {
						
						System.out.println("Interrupted");
						break;
					}
					
					Math.sin(ran.nextDouble());
					
				}
				
			}
			
		});
		t1.start();
		//Make the main thread sleep		
		Thread.sleep(500);
		//Once the main thread wakes up , it interupts the thread t1
		t1.interrupt();
		
		t1.join();
		
		System.out.println("Finished...");
	}

}
