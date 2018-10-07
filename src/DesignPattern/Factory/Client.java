package DesignPattern.Factory;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("DesignPattern.Factory.OneProduct");
		System.out.println(Factory.createProduct("P1").productName());
				
	}
}
