package DesignPattern.Singleton;


public class Singleton {

	private Singleton(){
		System.out.println("class Instance Created");
	}
	
	private static class SingletonInstance{
		static Singleton Instance = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonInstance.Instance;
	}

}
