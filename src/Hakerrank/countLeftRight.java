package Hakerrank;

import java.util.Scanner;

public class countLeftRight {
	private static int gcd(int a, int b) {
	    int t;
	    while(b != 0){
	        t = a;
	        a = b;
	        b = t%b;
	    }
	    return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while( t-- > 0){
			int n = sc.nextInt();
			int a[] = new int[n];
			for( int i =0 ; i< n ;i ++ ){
				a[i] = sc.nextInt(); 
			}
			if( n < 3){
				int sum = 0;
				int count = 0;
				for( int i =0 ; i< n ;i ++ ){
					sum  = sum + a[i];
					count++;
				}
				if( count == 1 )
					  System.out.println(sum);
				else
					System.out.println(sum+"/"+count);
				continue;
			}
			
			int sum = a[0] + a[n-1];
			int count = 2;
			for( int i = n ;i > 0 ;i-- ){
				sum = sum + a[n-i]*i;
				count++;
			}
			
			if( (n&1) == 1 ){
				sum = sum + a[n/2];
				count++;
			}
			
			while(gcd(sum,count)!=1){
				sum = sum / gcd(sum,count);
				count = count / gcd(sum,count);
			}
			  
			  if( count == 1 )
				  System.out.println(sum);
			System.out.println(sum+"/"+count);
		}
	}

}
