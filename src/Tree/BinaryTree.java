package Tree;

import java.util.Scanner;

public class BinaryTree {
	
	Node root;
	
	void insert( int data ) {
		Node newNode = new Node(data);
		if(root == null)
			root = newNode;
		else{
			Node node = root;
			while( node != null ) {
				if( data == node.data )
					break;
				if( data > node.data ){
					if(node.right == null) {
						node.right = newNode;
						break;
					}
					else
						node = node.right;
				} else {
					if( node.left == null ) {
						node.left = newNode;
						break;
					}
					else
						node = node.left;
				}
			}
		}
	}
	
	void traverse(Node node) {
		if( node == null )
			return;
		traverse(node.left);
		System.out.println(node.data);
		traverse(node.right);
	}
	
	int maxDepth(Node node) {
		
		if( node == null )
			return 0;
		
		int lDepth = maxDepth(node.left);
		int rDepth = maxDepth(node.right);
		
		if( lDepth > rDepth )
			return (lDepth + 1);
		else
			return (rDepth + 1);
	}
	
	void input(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			if( a == -1 )
				break;
			insert(a);
		}
		sc.close();
	}
	
}
