package testing;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DequeTest {
	public static void main(String[] args) {
		Deque<Integer> q = new LinkedList<>();
		q.add(1);
		q.addLast(2);
		q.addFirst(3);
		//System.out.println(q.removeFirst());
		
		Queue<Integer> pq = new PriorityQueue<>(3,Collections.reverseOrder());
		pq.add(0);
		pq.add(3);
		pq.add(7);
		pq.add(0);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}

}
