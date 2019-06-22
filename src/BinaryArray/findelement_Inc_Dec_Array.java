package BinaryArray;

public class findelement_Inc_Dec_Array {
	public static void main(String[] args) {
		int arr[] = {11};
		
		int start = 0;
		int end = arr.length-1;
		
		while(start < end) {
			int mid = (start + end)/2;
			if(arr[mid] > arr[mid+1])
				end = mid -1;
			else
				start = mid+1;
		}
		System.out.println(arr[start]);
		
		
	}
}
