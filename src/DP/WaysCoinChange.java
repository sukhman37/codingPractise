package DP;

import java.util.Scanner;

public class WaysCoinChange {
	
	static int waysCount(int n, int m, int coin[]) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			dp[i][0] = 1;
		}
		for(int i=1;i<=m;i++) {
			
			for(int j=1;j<=n;j++) {
				
				if(j >= coin[i-1]) {
					dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]]; 
				}else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int coin[] = new int[m];
		for(int i = 0; i < m ; i++) {
			coin[i] = sc.nextInt();
		}
		System.out.println(waysCount(n,m,coin));
		sc.close();
	}

}
