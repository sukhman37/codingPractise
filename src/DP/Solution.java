package DP;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getWays(int n, int[] c){
        int dp[] = new int[n+1];
        for(int i = 0 ;i <=n ;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 1; i <=n ;i++){
            for(int j = 0 ; j<c.length;j++){
                if( c[j] <= i ){
                    int smallValue = dp[i - c[j]];
                    if( smallValue != Integer.MAX_VALUE ){
                        dp[i] = Math.min(dp[i],smallValue+1);
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        int ways = getWays(n, c);
        System.out.println(ways);
    }
}
