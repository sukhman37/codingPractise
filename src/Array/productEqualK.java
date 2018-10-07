package Array;

public class productEqualK {
	
	static int subArray(int arr[], int max){
		int n = arr.length;
		int countArray = 0 , product = 1;
		int counter = 0;
		for(int left  = 0,right = -1; left < n ; left++){
			while( right+1 < n && arr[right + 1] < Math.ceil((double)max/product)){
				product *=arr[right +1];
				right++;
			}
			countArray = countArray + right - left + 1;
			System.out.println("value = "+countArray+" r  = "+right+" l = "+left+" counter = "+counter);
			product = product / arr[left]; 
		}
		return countArray;
	}
	
	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 3, 2, 10, 5};
		int max = 65;
		System.out.println(subArray(arr,max));
	}
}
