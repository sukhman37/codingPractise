package Java;
public class ThreadDemo implements Runnable {

 
	
	 int id = 1;
	    public static void main(String[] args) {
	        new Thread(new ThreadDemo()).start();
	        new Thread(new ThreadDemo()).start();
	        new Thread(new ThreadDemo()).start();
	    }
	    public void run() {
	        press(id);
	    }
	    synchronized void press(Integer id) {
	        System.out.print(id.intValue());
	        System.out.print((++id).intValue());
	    }
		

}