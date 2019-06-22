package Array;

public class BinarySearchOnArray {
	
	static int findPivot(int arr[],int start, int end) {
		int mid = (start + end)/2;
		if(arr[mid-1] > arr[mid])
			return mid;
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {5,6,7,4,3,2,1};
		//findPivot(arr);
	}

}
