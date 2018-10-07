package Array;

public class smallLengthgreaterK {
	public static void main(String[] args) {
		int a[] = {1, 4, 45, 6, 0, 19};
		
		int value = 51;
		int sum = 0;
		int start = 0,end = 0;
		int n = a.length;
		int min = n+1;
		while(end < a.length){
			while(sum <= value && end < n ){
				sum = sum + a[end];
				end++;
			}
			
			while(sum > value && start < n){
				if(end - start < min)
					min = end - start;
				sum = sum - a[start];
				start++;
			}
		}
		System.out.println(min);
	}
}
