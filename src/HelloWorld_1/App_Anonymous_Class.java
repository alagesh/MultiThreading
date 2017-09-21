package HelloWorld_1;;

/*
 * Starting threads using thread constructor with anonymous classes
 */
public class App_Anonymous_Class {

	 public static void main(String[] args) {
		 Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//Simple task of iterating and printing many hello world(s)
				for(int i=0;i<5;i++) {
					System.out.println("Hello World - " + i);
				}
				
					try {
						
						Thread.sleep(100);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}			 
		 });
		 
		 t1.start();
	 }
}
