package testing;

import java.util.Scanner;

public class Matrix2 {
	static boolean isValid(int n ,int m ,int x,int y) {
		return x<n && x >=0 && y<m && y>=0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];

		for(int i = 0 ;i < n ;i++) {
			for(int j = 0; j< m ;j++) {
				arr[i][j] = sc.nextInt(); 
			}
		}
		int count = 0;
		for(int i = 0 ;i < n ;i++) {
			for(int j = 0; j< m ;j++) {
				if(arr[i][j] == 1) {
				if(isValid(n, m, i+1, j) && arr[i+1][j] == 1)
					count++;
				if(isValid(n, m, i, j+1) && arr[i][j+1] == 1)
					count++;
				if(isValid(n, m, i+1, j+1) && arr[i+1][j+1] == 1)
					count++;
				if(isValid(n, m, i-1, j) && arr[i-1][j] == 1)
					count++;
				if(isValid(n, m, i, j-1) && arr[i][j-1] == 1)
					count++;
				if(isValid(n, m, i-1, j-1) && arr[i-1][j-1] == 1)
					count++;
				if(isValid(n, m, i+1, j-1) && arr[i+1][j-1] == 1)
					count++;
				if(isValid(n, m, i-1, j+1) && arr[i-1][j+1] == 1)
					count++;
			}
			}
		}
		System.out.println(count/2);
		
		sc.close();
	}
}
