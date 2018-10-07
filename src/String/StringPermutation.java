package String;
import java.util.*;

public class StringPermutation {
	
	public void permutation( char input[] ){
		
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		for(char ch : input){
			map.compute(ch, (key,value) -> {
				if(value == null)
					return 1;
				else
					return value+1;
			});
		}
		int count[] =  new int[map.size()];
		char str[] = new char[map.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			count[index] = entry.getValue();
			str[index] = entry.getKey();
			index++;			
		}
		char result[] = new char[input.length];
		permuteUtil(count, str, result, 0);
	}
	
	public void permuteUtil(int count[], char str[],char result[], int level){
		if(level == result.length){
			printArray(result);
			return;
		}
		
		for(int i = 0; i < str.length ; i++){
			if(count[i] == 0)
				continue;
			result[level] = str[i];
			count[i]--;
			permuteUtil(count, str, result, level + 1);
			count[i]++;
		}
		
	}
	
	public void printArray(char result[]){
		for(char s : result)
			System.out.print(s);
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		sp.permutation("AABC".toCharArray());
	}

}
