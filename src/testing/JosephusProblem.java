package testing;
import java.util.Scanner;

public class JosephusProblem {


	public static void main(String args[] ) throws Exception {
	       
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x=0;
        int ans = 0;
        for (int i=0;i<N;i++) {
            x = sc.nextInt();
            ans = 2*x - (int) Math.pow(2,1+Math.floor(Math.log(x)/Math.log(2))) + 1;
            System.out.println(get((long)x,(long)2));
        }
    }
    
    public static long get(long n, long k) {
        if (n == 1)
        return 1;
        else 
            return (get(n-1,k) + k-1 ) %n +1;
    }
}

