package Array;
import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {
    static long fun(int k, int n) {
    long sum = 0;
    for (int i = 1;i<=n;i++) {
        sum += i;
        i *= k;
    }
    return sum;
}
    static long simplestSum(int k, int a, int b) {
        long sum = 0;
        LinkedList<Long> al = new LinkedList<>();
        al.add(1L);
        int pow = k;
        for(int i = 1;i <=b ;i++){
        	al.add(al.getLast()+pow);
        	System.out.println(al.getLast());
        	pow = pow * pow;
        }
//      for(int i = 1 ;i < b ;i = i*k){
//         if(i == a){
//        	 sum = (sum + fun(k,i))%1000000007;
//         }
//          sum = (sum + fun(k,i))%1000000007;
//      }
        return sum;
    }

    public static int sumNumber(int i){
    	return i+1;
    }
    
    public static void main(String[] args) {
    	
    	/*ExecutorService ex = Executors.newFixedThreadPool(100);
    	Map<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>();
    	map.put(30, 0);
    	map.computeIfPresent(10, (K,V) -> 30);*/
    	
    	List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
    	
    	list.stream()
    	.parallel()
    	.filter(e -> e>6)
    	//.map(sumNumber(e))
    	.forEachOrdered(System.out::println);
    	
    
    	
    	//System.out.println(map.get(30));
//        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for(int a0 = 0; a0 < q; a0++){
//            int k = in.nextInt();
//            int a = in.nextInt();
//            int b = in.nextInt();
//            //long result = simplestSum(k, a, b);
//        }
    //	Stream.iterate(0, e -> e+2)
    	//.limit(30)
    	//.forEach(System.out::println);
    	
    	
    	//System.out.println(simplestSum(2, 1, 5));
        //System.out.println(fun(3,40));
       // in.close();
    }
}
