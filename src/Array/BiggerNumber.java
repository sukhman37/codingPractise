package Array;

/*
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * 
 */
class StoreChar implements Comparable<String>{
	
	String s1;
	@Override
	public int compareTo(String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 == len2) {
			for (int i = 0; i < len1; i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					if(s1.charAt(i) > s2.charAt(i))
						s1.compareTo(s2);
				}
			}
		}
		return 0;
	}
	
}

public class BiggerNumber {
	public static void main(String[] args) {
		
	}
}
