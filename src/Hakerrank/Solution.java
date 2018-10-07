package Hakerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long maxTotalStrength(int[] strength, int[] l, int[] r) {
    	int dp[] = new int[strength.length+1];
    	
    	for( int i =1; i < strength.length; i++ ){
    	dp[i] = dp[i-1];
    	for(int j = 1 ; j < i-l[i] ; j ++)
    	  if(j+r[j] < i)
    	    dp[i] = Math.max(dp[i] , dp[j] + strength[i]);
    	}

    	
//    	for( int i =1; i < strength.length; i++ ){
//    		System.out.println("i = "+i);
//    		int x = i - l[i];
//    		System.out.println("x = "+x);
//    		if( x >0 ){
//    			System.out.println("pass");
//    			while( r[x] + x > i && x > 0){
//    				x--;
//    			}
//    			if( x > 0 && r[x] + x < i){
//    				dp[i] = Math.max(dp[x] , strength[i] + strength[x]);
//    			} else{
//    				dp[i] = dp[x];
//    			}
//    		}
//    		System.out.println("dp = "+dp[i]);
//    	}
    	
        return dp[strength.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] strength = new int[n+1];
        for(int strength_i = 1; strength_i <= n; strength_i++){
            strength[strength_i] = in.nextInt();
        }
        int[] l = new int[n+1];
        for(int l_i = 1; l_i <= n; l_i++){
            l[l_i] = in.nextInt();
        }
        int[] r = new int[n+1];
        for(int r_i = 1; r_i <= n; r_i++){
            r[r_i] = in.nextInt();
        }
        long result = maxTotalStrength(strength, l, r);
        System.out.println(result);
        in.close();
    }
}
