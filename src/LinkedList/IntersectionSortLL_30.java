package LinkedList;

import java.util.Scanner;

public class IntersectionSortLL_30 {
	
	static Node sortedIntersect( Node a, Node b) {
		Node head = new Node();
		Node tail = head;
		while( a!=null && b!=null) {
			if(a.data == b.data) {
				
				tail.next = a;
				tail = tail.next;
				a = a.next;
				b = b.next;
				tail.next = null;
			}
			else if( a.data < b.data ){
				a = a.next;
			}else {
				b = b.next;
			}
		}
		return head;
	}
	
	static void traverse(Node node) {
		if(node == null)
			return;
		
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Node headA = new Node();
		Node tailA = headA;
		
		for (int i = 0; i < n; i++) {
			tailA.next = new Node(sc.nextInt());
			tailA = tailA.next;
		}
		
		n = sc.nextInt();
		Node headB = new Node();
		Node tailB = headB;
		
		for (int i = 0; i < n; i++) {
			tailB.next = new Node(sc.nextInt());
			tailB = tailB.next;
		}
		
		traverse(sortedIntersect(headA.next, headB.next).next);
		sc.close();
		
	}
}
