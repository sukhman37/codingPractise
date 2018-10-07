package Java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Streaming {
	public static boolean printIt(Integer i){
		System.out.println(i);
		return true;
	}
	public static void main(String[] args) {
		List<Integer> sl = Arrays.asList(1,2,34,43213,4134,134135311,3,4,5,6,7,8);
		sl.stream()
		.parallel()
		.filter(e -> e%2 == 0).sorted().forEach(Streaming::printIt);
		
		
		System.out.println("core  = "+Runtime.getRuntime().availableProcessors());
		//ForkJoinPool fork = new ForkJoinPool().commonPool();
		//System.out.println(fork);
	}

}
