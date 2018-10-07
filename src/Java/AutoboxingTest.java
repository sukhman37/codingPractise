package Java;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;


class compareString{
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		compareString other = (compareString) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}

public class AutoboxingTest{
	
    public static void main(String args[]) {
    	compareString cs = new compareString();
    	cs.setId(20);
    	
    	compareString cs1 = new compareString();	
    	cs1.setId(20);
    	
    	System.out.println(cs.equals(cs1));
    	
    	
        // Example 1: == comparison pure primitive – no autoboxing
        int i1 = 1;
        int i2 = 1;
        System.out.println("i1==i2 : " + (i1 == i2)); // true

        // Example 2: equality operator mixing object and primitive
        Integer num1 = 1; // autoboxing
        int num2 = 1;
        System.out.println("num1 == num2 : " + (num1 == num2)); // true

        // Example 3: special case - arises due to autoboxing in Java
        Integer obj1 = 1; // autoboxing will call Integer.valueOf()
        Integer obj2 = 1; // same call to Integer.valueOf() will return same
                            // cached Object

        System.out.println("obj1 == obj2 : " + (obj1 == obj2)); // true

        // Example 4: equality operator - pure object comparison
        Integer one = new Integer(1); // no autoboxing
        Integer anotherOne = new Integer(1);
        System.out.println("one == anotherOne : " + (one == anotherOne)); // false

    }

}