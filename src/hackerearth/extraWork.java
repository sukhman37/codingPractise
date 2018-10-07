package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class extraWork {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int t = sc.nextInt();
		while( t-- > 0 ){
			int n = sc.nextInt();
			int a[] = new int[n];
			int q = sc.nextInt();
			for( int i = 0; i< n;i++ ){
				a[i] = sc.nextInt();
			}
			for( int i = 0;i<q;i++ ){
				int j = sc.nextInt();
				int max = Integer.MIN_VALUE;
				int max1 = Integer.MIN_VALUE;
				for( int z = 0 ; z<j-1 ;z++ ){
					if( a[z] <= a[j-1] && a[z] > max){
						max = a[z];
						System.out.println("max = "+max);
					}
				}
				for( int z = j ; z< a.length ;z++ ){
					if( a[z] <= a[j-1] && a[z] > max1){
						max1 = a[z];
						System.out.println("max1 = "+max1);
					}
				}
				if( max == Integer.MIN_VALUE || max1 == Integer.MAX_VALUE )
					System.out.println("0");
				else
					System.out.println(max*a[j-1]*max1);
			}
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
