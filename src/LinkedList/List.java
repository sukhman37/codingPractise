package LinkedList;

import java.util.Scanner;

public class List {
	
	Node head;
	Node tail;
	
	public void insertFirst(int data) {
		Node newNode = new Node(data);
		
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			tail.next = newNode;
			this.tail = newNode;
		}
	}
	
	public void display() {
		Node temp = this.head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for( int i = 0; i < n; i++)
			insertFirst(sc.nextInt());
		sc.close();
	}
	
	public void traverse(Node node) {
		if(node == null)
			return;
		
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
