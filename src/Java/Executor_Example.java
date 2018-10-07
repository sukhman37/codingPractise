package Java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor_Example {
	
	public static ExecutorService executor = Executors.newFixedThreadPool(100);
	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(20, 0);
		
		concurrentAdd(map);
		
		executor.shutdown();
		while(!executor.awaitTermination(1, TimeUnit.SECONDS));
			System.out.println(map);
	}
	public static void concurrentAdd(Map<Integer, Integer> map) {
		for (int i = 0; i < 10000000; i++) {
			executor.submit(() -> addOne(map));
		}

	}
	
	public static void addOne(Map<Integer, Integer> map) {
		/*while (true) {
			int value = map.get(20);
			if(map.replace(20, value, ++value)){
				break;
			}
			
		}*/
		int value = map.get(20);
		map.put(20, ++value);
		//map.computeIfPresent(20, (K,V) -> ++V);
	}
	

}
