package DP;

import java.util.Scanner;

public class KnapsackProblem {
	
	static int knapsnakProblem(int n,int m, int val[],int wt[]){
		int dp[][] = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(j < wt[i-1]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}
			}
		}
		return dp[n][m];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}
		System.out.println(knapsnakProblem(n, m, val, wt));
		sc.close();
	}
}
