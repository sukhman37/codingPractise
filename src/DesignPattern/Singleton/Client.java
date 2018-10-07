package DesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	
	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 10;i++){
			ex.submit(()->
			{
				Singleton.getInstance();
			});
			System.out.println(i);
		}
		ex.shutdown();
		
	}
}
