package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class minVlaue {
	public static void main(String[] args) {
		MyScanner sc= new MyScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int a[] = new int[n+1];
		
		for( int i =0 ;i<q;i++ ){
			int type = sc.nextInt();
			if( type == 1 ){
				int index = sc.nextInt();
				for( int j = 1 ;j<=index;j++ ){
					a[j] = index;
				}
			} else{
				int index = sc.nextInt();
				if( a[index] == 0 )
					System.out.println("-1");
				else
					System.out.println(a[index]);
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
