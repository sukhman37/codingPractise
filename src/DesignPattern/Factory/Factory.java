package DesignPattern.Factory;

import java.util.HashMap;
import java.util.Map;

public class Factory {
	
	static Map<String,Product> map = new HashMap<>();
	//Register id with class objects
	public static void registerProduct(String id, Product p){
		map.put(id,p);
	}
	 public static Product createProduct(String id){
		 return map.get(id).createProduct();
	 }
	
}
