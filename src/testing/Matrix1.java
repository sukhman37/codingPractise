package testing;

import java.util.Scanner;

public class Matrix1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		int maxi = -1;
		int maxj = -1;
		int mini = -1;
		int minj = -1;
		int arr[][] = new int[n][m];
		
		for(int i = 0 ;i < n ;i++) {
			for(int j = 0; j< m ;j++) {
				arr[i][j] = sc.nextInt(); 
				if(arr[i][j] > max) {
					max = arr[i][j];
					maxi = i;
					maxj = j;
				}
				if(arr[i][j] < min) {
					min = arr[i][j];
					mini = i;
					minj = j;
				}
			}
		}
		int count = 0;
		System.out.println("min i = "+mini+" min j = "+minj+" maxi = "+maxi+" maxj = "+maxj);
		for(int i = 0 ;i < n ;i++) {
			for(int j = 0; j< m ;j++) {
				if(i == mini || j == minj)
					count++;
				else if(i == maxi || j == maxj)
					count++;
				System.out.println("count = "+count+" i = "+i+" j = "+j);
			}
		}
		System.out.println(count);
		sc.close();
	}
}
