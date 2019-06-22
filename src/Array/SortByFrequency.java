package Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SortByFrequency {

	public static void main(String[] args) {
		//Integer[] input = new Integer[] { 2,3,5,3,7,9,5,3,7 };
		// Sort the array using custom comparator
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		Object[] arr = al.toArray();
		Integer input[] = new Integer[arr.length];
		for(int i=0;i<arr.length;i++) {
			input[i] = (int)arr[i];
		}
		Arrays.sort(input, new FrequencyComparator(input));
		// Print the result
		for (Integer i : input)
			System.out.print(i + " ");
	}
	
	static class FrequencyComparator implements Comparator<Integer>
    {            
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		public FrequencyComparator(Integer[] input) {
			System.out.println("constructor call");
			for (Integer i : input) {
				frequencyMap.put(i, frequencyMap.get(i) != null ? frequencyMap.get(i) + 1 : 1);
			}
		}
		
		@Override
		public int compare(Integer i1, Integer i2) {
			System.out.println("element call for ="+i1+" "+i2);
			// If frequencies are the same then compare the actual numbers
			if (frequencyMap.get(i1).equals(frequencyMap.get(i2))) 
				return i1.compareTo(i2);

			return (frequencyMap.get(i1) > frequencyMap.get(i2)) ? 1 : -1;
		}
     }
	
	
	
	 public static List<String> missingWords(String s, String t) {
	        String[] sSplit = s.split(" ");
	        String [] tSplit = t.split(" ");
	        Set<Integer> matchedIndexes = new HashSet<>();
	        
	        int sIndex = 0;
	        int tIndex = 0;
	        
	        for(;tIndex<tSplit.length;) {
	        	if(sSplit[sIndex].equals(tSplit[tIndex])) {
	        		matchedIndexes.add(sIndex);
	        		sIndex++;
	        		tIndex++;
	        	} else {
	        		sIndex++;
	        	}
	        }
	        
	        List<String> missingWords = new ArrayList<>();
	        for(int i=0;i<sSplit.length;i++) {
	        	if(!matchedIndexes.contains(i)) {
	        		missingWords.add(sSplit[i]);
	        	}
	        }
	        
	        return missingWords;
	    }
}
	