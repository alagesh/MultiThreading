package Semaphore_12;

import java.util.concurrent.Semaphore;

public class Connection {
	
	private static Connection instance = new Connection();
	
	Semaphore sem = new Semaphore(10,true);
	
	private int connections =0;
	
	private Connection() {
		
	}
	/*
	 * ONE Connection object at a given time - Singleton pattern
	 */
	public static Connection getInstance() {
		return instance;
	}
	
	public void connect()  {
		
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			doConnect();
		}finally {
			/*
			 * To ensure release is called independent of exception thrown
			 */
			sem.release();
		}
		
	}
	
	public void doConnect()  {
		
		synchronized(this) {
			connections++;
			System.out.println("Current connections: "+ connections);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized(this) {
			connections--;
			
		}
		
		
	}

}
