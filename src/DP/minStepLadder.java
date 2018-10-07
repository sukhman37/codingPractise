package DP;

import java.util.Scanner;

public class minStepLadder {
	
	
	//Complexity O(n*k)
	static int minWay(int n, int k){
		if( n == 0 || k == 0)
			return 0;
		int dp[] = new int[n+1];
		
		dp[0] = 1; //On ground only one way. Just stand
		
		for(int step = 1 ; step <= n ;step++){
			dp[step] = 0;
			for(int j = 1; j<=k;j++){
				if(step - j >= 0) // not start underground
					dp[step] += dp[step - j]; 
			}
		}
		return dp[n];
	}
	
	static int minWayOp(int n, int k){
		if( n == 0 || k == 0)
			return 0;
		int dp[] = new int[n+1];
		
		dp[0] = 1;
	
		//first count the k step so we not need to add again last k step. So simply we use sliding window to get the result in O(n)
		for(int i = 1; i <= k;i++){
			dp[i] = 0;
			for(int j = 1; j<=k ;j++){
				if( i - j > 0){
					dp[i] += dp[i - j];
				}
			}
		}
		
		for(int step = k ; step <= n ;step++){
			dp[step] = 0;
			dp [step] = 2 * dp[step -1] - dp[step - k];
		}
		return dp[n];
	}
	
	static int minWayOpSnakeLadder(int arr[],int n, int k){
		if( n == 0 || k == 0)
			return 0;
		int dp[] = new int[n+1];
		
		dp[0] = 1;
	
		for(int i = 1; i <= k;i++){
			dp[i] = 0;
			for(int j = 1; j<=k ;j++){
				if( i - j > 0 && arr[i - j] != 1){
					dp[i] += dp[i - j];
				}
			}
		}
		
		for(int step = k ; step <= n ;step++){
			dp[step] = 0;
			if(arr[step-1] != 1)
			dp [step] = 2 * dp[step -1] - dp[step - k];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int arr[] =  new int[n];
		int k = sc.nextInt();
		for(int i =0 ;i < n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(minWayOpSnakeLadder(arr, arr.length, k));
		sc.close();
		//System.out.println(minWay(4, 2));
	}

}
