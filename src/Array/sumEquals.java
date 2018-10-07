package Array;

public class sumEquals {
	public static void main(String[] args) {
		int a[] = {1, 4, 0, 0, 3, 10, 5};
		
		int find = 7;
		int start = 0;
		int sum = 0;
		
		for(int i = 0;i<a.length;i++){
			while(sum > find && i < a.length){
				sum = sum - a[start];
				start++;
			}
			if(sum == find)
				System.out.println("start index = "+start+" end = "+(i-1));
			sum = sum + a[i];
		}
		
	}
}
