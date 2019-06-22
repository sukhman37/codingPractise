package testing;

import java.util.Scanner;

public class count {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt();
	int arr[] = new int[n];
	for(int i = 0;i<n;i++) {
		arr[i] = sc.nextInt();
	}
	int k = sc.nextInt();
	
	int start = 0;
	int end = n;
	int ans = 0;
	while(end!=k) {
		if(arr[start] != 0) {
			int x = n-start;
			int y = x - k;
			if(y > 0) {
				ans = ans + y * k;
				System.out.println("ans = "+ans+" x = "+x+" y = "+y);
			}else if(y == 0) {
				ans = ans + 1;
				System.out.println("ans = "+ans+" x = "+x+" y = "+y);
			}else {
				break;
			}
		}
		start++;
		if(start >= n)
			break;
	}
	System.out.println(ans);
}
}
