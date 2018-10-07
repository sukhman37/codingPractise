package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
	public static void main(String[] args) {
		Stack<Integer> insert = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0 ;i <n;i++){
			int q = sc.nextInt();
			if( q == 1 ){
				int a = sc.nextInt();
				
				if(insert.isEmpty())
					max.push(a);
				else{
					if(a >= max.peek())
						max.push(a);
				}
				insert.push(a);
			}
			if( q == 2 ){
				int b = insert.pop();
				if(b==max.peek())
					max.pop();
			}
			if( q == 3)
				System.out.println(max.peek());
		}
	}
}
