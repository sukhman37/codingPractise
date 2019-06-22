package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


 class TaskOne implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task One");
        try {
            Thread.sleep(2000);
            System.out.println("Complete Task One");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
 class TaskTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Two");
        try {
            Thread.sleep(2000);
            System.out.println("complete Task Two");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
 class TaskThree implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Task Three");
        try {
            Thread.sleep(2000);
            System.out.println("complete Task Three");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
 class MultiRunnable implements Runnable {
	 
	    private final List<Runnable> runnables;
	 
	    public MultiRunnable(List<Runnable> runnables) {
	        this.runnables = runnables;
	    }
	 
	    @Override
	    public void run() {
	        for (Runnable runnable : runnables) {
	             new Thread(runnable).start();
	        }
	    }
	}

public class BlockingQueueExample {
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
		ThreadPoolExecutor th = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, queue) ;
		th.prestartAllCoreThreads();
		
		
		
        List<Runnable> taskGroup = new ArrayList<Runnable>();
        List<Runnable> taskGroup1 = new ArrayList<Runnable>();
        taskGroup.add(new TaskOne());
        taskGroup1.add(new TaskTwo());
        taskGroup1.add(new TaskThree());
        
        queue.put(new MultiRunnable(taskGroup));
        queue.put(new MultiRunnable(taskGroup1));
		
		
	}
}
