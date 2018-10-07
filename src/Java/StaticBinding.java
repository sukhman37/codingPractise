package Java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StaticBinding {
	
	public  void show(Collection c){
		System.out.println("Collection call");
	}
	
	public void show(ArrayList hashmap){
		System.out.println("Array call");
	}
	
	public static void main(String[] args) {
		StaticBinding sb = new StaticBinding();
		Collection c = new ArrayList();
		sb.show(c);
		
	}

}
