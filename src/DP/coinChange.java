package DP;

import java.util.Scanner;

public class coinChange {
	static int coinsNeededDP(int coins[],int amount,int n){
	    int dp[] = new int[amount+1];

	    for(int i=0;i<=amount;i++){
	        dp[i] = Integer.MAX_VALUE;
	    }
	    
	    dp[0] = 0;
	    for(int rupay=1; rupay<=amount;rupay++){

	        // Iterate Over Coins
	        for(int i=0;i<n;i++){

	            if(coins[i]<=rupay){

	                int smallerAns = dp[rupay-coins[i]];
	                if(smallerAns!=Integer.MAX_VALUE){
	                    dp[rupay] = Math.min(dp[rupay],smallerAns + 1);
	                }

	            }

	        }
	    }
	    return dp[amount];

	}
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	int a[] = new int[m];
	for(int i = 0 ; i < m ; i ++){
		a[i] = sc.nextInt(); 
	}
	System.out.println(coinsNeededDP(a, n, m));
}
}
