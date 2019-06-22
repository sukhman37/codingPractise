package testing;

import java.util.ArrayList;
import java.util.List;import Hakerrank.maxArraySum;

public class Solution {
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1967513926);
		al.add(1540383426);
		al.add(-1303455736);
		al.add(-521595368);
		//al.add(2);
		//al.add(3);
		//[ 1967513926, 1540383426, -1303455736, -521595368 ]
		
		System.out.println(maxset(al));
	}
	
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long windowsum = 0;
        long maxsum =Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int startMax = -1;
        int endMax = -1;
        for(int i = 0 ;i < A.size();i++){
            
            if(A.get(i) >= 0){
               windowsum = windowsum + A.get(i);
               
               if(windowsum > maxsum){
                    maxsum = windowsum;
                    startMax = start;
                    endMax = i;
               }else if(windowsum == maxsum){
                   if(end-start > endMax - startMax){
                       endMax = end;
                       startMax = start;
                   }
               }
               end++;
            }else{
            	windowsum = 0;
                for(int j = i+1;j<A.size();j++){
                    if(A.get(j) >= 0){
                        start = j;
                        i = j-1;
                        break;
                    }
                }
            }
            System.out.println("start = "+start+" end = "+end+" startMax = "+startMax+" endMax = "+endMax+" window = "+windowsum);
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(startMax == -1)
        	return al;
        for(int i = startMax;i<=endMax;i++){
            al.add(A.get(i));
        }
        return al;
    }
}
