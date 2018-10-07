package Java;

public class ArrayOfArray {
	public static void main(String[] args) {
		Object arr[] = {39, 48};
		Object arr1[] = {24, 20, arr, 89};
		Object arr2[] = {1, 5, 8, 9, 10,arr1, 105, 99};
		printArray(arr2);
	}
	
	static void printArray(Object arr[]){
		for(int i = 0; i < arr.length ; i++){
			if(arr[i].getClass().isArray()){
				printArray(arr[i]);
			}
			else
				System.out.print("m1 = "+arr[i]+" ");
		}
	}

	private static void printArray(Object object) {
		Object arr[] = (Object[])object;
		for(int i = 0; i < arr.length ; i++){
			if(arr[i].getClass().isArray()){
				printArray(arr[i]);
			}
			else
				System.out.print("m2 = "+arr[i]+" ");
		}
		
	}
}
