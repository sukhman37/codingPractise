package Stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		Scanner sc = new Scanner( System.in );
		int n = sc.nextInt();
		for(int i = 0 ; i < n ; i++){
			int a = sc.nextInt();
			if(st.isEmpty())
				st.push((a*n)-i);
			else{
				if( st.peek() < (a*n)-i )
					st.push((a*n)-i);
			}
			System.out.println(st.peek());
		}
		System.out.println(st.peek());
	}

}
