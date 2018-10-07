package Array;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwoSum {
	public static void main(String[] args) {
		Logger.getLogger(TwoSum.class.getName()).log(Level.INFO, "Hiiiiiii");
		System.out.println(twoSum(new int[]{1,2,3,4,5,6}, 10));
		
	}
	public static int[] twoSum(int nums[], int target){
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int res[] = new int[2];
		for( int i = 0; i< nums.length; i++ ){
			if( hash.containsKey(target - nums[i])){
				res[1] = i;
				res[0] = hash.get(target - nums[i]);
			}
			hash.put(nums[i], i);		
		}
		return res;
	}
}
