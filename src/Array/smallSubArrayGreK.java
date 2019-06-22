package Array;
import java.util.*;
import java.lang.*;
import java.io.*;

class smallSubArrayGreK {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i =0; i< n;i++){
		        arr[i] = sc.nextInt();
		    }
		    int size = n + 1;
		    int sum = 0;
		    for(int start = 0,end = 0; end < n ; ){
		        
		        while(sum <= k && end < n){
		            sum = sum + arr[end];
		            end++;
		        }
		        
		        while(sum > k && start < n){
		            if((end-start) < size)
		                 size = end - start ;
		            sum = sum - arr[start];
		            start++;
		        }
		        
		        
		    }
		    System.out.println(size);
		}
	}
}