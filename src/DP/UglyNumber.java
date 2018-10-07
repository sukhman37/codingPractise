package DP;
/*package whatever //do not write package name here */

import java.util.Scanner;

class UglyNumber {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
		    int n = sc.nextInt();
		    int ugly[] = new int[n];
		    ugly[0] = 1;
		    int i2 = 0,i3 =0 ,i5 = 0;
		    int factor_i2 = 2;
		    int factor_i3 = 3;
		    int factor_i5 = 5;
		    int min = 1;
		    for(int i = 1; i< n ;i++){
		         min = Math.min(factor_i2,Math.min(factor_i3,factor_i5));
		        ugly[i] = min;
		        if(min == factor_i2){
		            i2 = i2 + 1;
		            factor_i2 = ugly[i2] * 2;
		        }
		         if(min == factor_i3){
		            i3 = i3 + 1;
		            factor_i3 = ugly[i3] * 3;
		        } if(min == factor_i5){
		            i5 = i5 + 1;
		            factor_i5 = ugly[i5] * 5;
		        }
		    }
		    System.out.println(min);
		}
		sc.close();
	}
}