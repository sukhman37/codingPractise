package Java;

import java.util.concurrent.*;

public class Exector_Example2 {
	static Semaphore sem = new Semaphore(2);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		Future f1 = ex.submit(new Task(1));
		Future f2 =ex.submit(new Task(2));
		Future f3 =ex.submit(new Task(3));
		Future f4 =ex.submit(new Task(4));
		Future f5 =ex.submit(new Task(5));
		Future f6 =ex.submit(new Task(6));
		System.out.println("main  = "+f1.get());
		System.out.println("main  = "+f2.get());
		System.out.println("main  = "+f3.get());
		System.out.println("main  = "+f4.get());
		System.out.println("main  = "+f5.get());
		System.out.println("main  = "+f6.get());
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
		System.out.println(count+ " Lock Acquired :"+Exector_Example2.sem.availablePermits());
		Thread.sleep(2000);
		Exector_Example2.sem.release();
		System.out.println("Thread lock release");
		return count;
	}
	
}
