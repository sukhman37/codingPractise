package hackerearth;

import java.util.Scanner;

public class minMaxValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while( t-- > 0 ){
			int n = sc.nextInt();
			int rating = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean flag = true;
			for( int i =0; i < n; i++){
				int value = sc.nextInt();
				if( value > rating ){
					if( value < min )
						min = value;
					else{
						flag = false;
					}
						
				} else if(value < rating ){
					if( value > max ){
						max = value;
					} else{
						flag = false;
					
					}
				} 
				
			}
			if( flag ){
				System.out.println("YES");
			} else{
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
