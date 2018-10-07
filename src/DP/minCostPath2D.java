package DP;

import java.util.Scanner;

public class minCostPath2D {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for( int i = 0 ; i< n ; i++ ){
			for(int j =0 ; j < m ; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		int dp[][] = new int[n][m];
		
		dp[0][0] = arr[0][0];
		
		for( int i = 1 ; i< n ; i++ ){
			dp[0][i] = dp[0][i-1] + arr[0][i];			
		}
		
		for( int i = 1 ; i< n ; i++ ){
			dp[i][0] = dp[i-1][0] + arr[i][0];			
		}
		
		for( int i = 1 ; i< n ; i++ ){
			for(int j =1 ; j < m ; j++){
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		System.out.println(dp[n-1][m-1]);
		sc.close();
	}

}
