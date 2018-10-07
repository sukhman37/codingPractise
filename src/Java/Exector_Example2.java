package Java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Exector_Example2 {
	static Semaphore sem = new Semaphore(1);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		ex.submit(new Task(1));
		ex.submit(new Task(2));
		ex.submit(new Task(3));
		ex.submit(new Task(4));
		ex.submit(new Task(5));
		ex.submit(new Task(6));
		ex.shutdown();
	}
}

class Task implements Callable<Integer>{
	int count = 1;
	public Task(int c) {
		count = c;
	}
	@Override
	public Integer call() throws Exception {
		Exector_Example2.sem.acquire();
		//System.out.println("count = "+count);
		System.out.println(count+ "Lock Acquired :"+Exector_Example2.sem.availablePermits());
		Thread.sleep(2000);
		Exector_Example2.sem.release();
		System.out.println("Thread lock release");
		return 0;
	}
	
}
