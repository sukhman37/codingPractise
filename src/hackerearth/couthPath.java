package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class couthPath {
	
	static int countPath(int grid[][], int row,int col, int path[][]){
		
		
		
		if( row == grid.length-1 && col == grid[0].length-1)
			return grid[row][col];
		
		if(row > grid.length-1 || col > grid[0].length-1)
			return 0;
		if( path[row][col] == -1 )
			path[row][col] = countPath(grid,row+1,col,path) + countPath(grid,row,col+1,path);
		
		return path[row][col];
	}
	
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int arr[][] = new int[n+1][m+1];
			int path[][] = new int[n+1][m+1];
			for( int i = 0 ;i <= n;i++ ){
				for(int j=0;j<=m;j++){
					path[i][j] = -1;
				}
			}
			int k = sc.nextInt();
			for(int i =0 ;i<k;i++){
				arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
			}
			
			for( int i = 0 ;i < n;i++ ){
				for(int j=0;j<m;j++){
						path[i][j] = arr[i+1][j] + arr[i][j+1];
					
				}
			}
			
			
			System.out.println(path[n-1][m-1]);
		}
		
	}
	public static PrintWriter out;
    public static class MyScanner {
   BufferedReader br;
   StringTokenizer st;

   public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
   }

   String next() {
       while (st == null || !st.hasMoreElements()) {
           try {
               st = new StringTokenizer(br.readLine());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return st.nextToken();
   }

   int nextInt() {
       return Integer.parseInt(next());
   }

   long nextLong() {
       return Long.parseLong(next());
   }

   double nextDouble() {
       return Double.parseDouble(next());
   }

   String nextLine(){
       String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
   }

}
}
