package Array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowsMaxK {
	public static void main(String[] args) {
		for(int i='A';i<='z';i++) {
			System.out.println((char)i);
		}
		int x='A';
		int y='z';
		//System.out.println(y);
		
	}
	static void maxPrint(int arr[],int k) {
		
		Deque<Integer> queue = new LinkedList<>();
		int i = 0;
		for(i=0; i < k ; i++) {
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			queue.addLast(i);
		}
		
		for(;i<arr.length;i++) {
			
			System.out.println(arr[queue.peekFirst()]+" ");
			
			while(!queue.isEmpty() && queue.peek()<=i-k)
				queue.removeFirst();
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			queue.addLast(i);
		}
	}
}
