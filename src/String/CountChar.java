package String;

import java.util.*;

public class CountChar {
	public static void main(String[] args) {
		String str = "AABBCAC";
		char charS[] = str.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		for(char ch:charS){
			map.compute(ch, (key,value) -> {
				if(value == null)
					return 1;
				else
					return value+1;
			});
		}
		
		for(Map.Entry<Character, Integer> ke : map.entrySet()){
			System.out.print(ke.getKey()+""+ke.getValue());
		}
		
		
	}
	
	

}
