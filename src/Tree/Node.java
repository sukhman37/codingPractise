package Tree;

public class Node {
	
	int data;
	Node left;
	Node right;
	
	Node(){}
	
	Node(int data) {
		this(data,null,null);
	}
	Node(int data, Node left, Node right) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
}
