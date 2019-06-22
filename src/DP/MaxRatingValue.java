package DP;

public class MaxRatingValue {
	public static void main(String[] args) {
		int input[] = {1,1,-1,1,1};
		System.out.println(max(input,0,0,1));
	}
	
	
	static int max(int input[], int i, int max,int index) {
		if(i >= input.length )
			return max;
		//System.out.println("i = "+ i +" index = "+index);
		int max1 = max+index*input[i];
		int max2 = max;
		return Math.max(max(input,i+1,max1,index+1),max(input,i+1,max2,index));
	}
}
