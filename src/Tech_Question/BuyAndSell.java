package Tech_Question;

import java.util.Scanner;

public class BuyAndSell {
	
	
	static int traderProfit(int k, int n, int[] A) {
       int T[][] = new int[k+1][n];
       
       for (int i = 1; i < T.length; i++) {
		int maxDiff = -A[0];
		for (int j = 1; j < T[i].length; j++) {
			T[i][j] = Math.max(T[i][j-1], A[j] + maxDiff);
			maxDiff = Math.max(maxDiff, T[i-1][j] - A[j]);
		}
		
	}
      return T[k][n-1]; 
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();}
	
}
