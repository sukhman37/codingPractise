package Java;

public class AutoboxingOverloading {
	
	public static int sum(Integer a,Integer b) {
		System.out.println("Integer call");
		return a+b;
	}
	
	public static long sum(long a,long b) {
		System.out.println("Long call");
		return a+b;
	}
	
	public static void main(String[] args) {
		AutoboxingOverloading.sum(10, 20);
	}
}
