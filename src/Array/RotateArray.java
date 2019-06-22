package Array;

public class RotateArray {
	
	static int gcd(int x, int y) {
		return (y==0) ? x : gcd(y,x%y);
	}
	static int[] rotateArray(int arr[],int d) {
		int i, j, k, temp; 
		int n = arr.length;
        for (i = 0; i < gcd(d, n); i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
        return arr;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		int ans[] = rotateArray(arr, 9);
		for(int i =0 ; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
