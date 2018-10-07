package Java;

import java.util.HashMap;
import java.util.Scanner;

public class Tes1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while( t-- > 0 ){
			HashMap<Character, Integer> map = new HashMap<>();
			String str = sc.nextLine();
			int count = 0;
			for( int i = 0; i < str.length();i++ ){
				 if(!map.containsKey(str.charAt(i))){
					 count++;
					 map.put(str.charAt(i), 0);
				 }
			}
			if(count%2 == 0){
				System.out.println("Player2");
			}else{
				System.out.println("Player1");
			}
		}
		sc.close();
	}
}
