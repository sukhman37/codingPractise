package Tree;

import java.util.Stack;

public class TravsStack extends BinaryTree{
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.input();
		tree.traverse(tree.root);
		traverseStack(tree.root);
	}
	
	public static void traverseStack(Node root) {
		System.out.println("Stack Traversal");
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while(curr !=null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.println(curr.data);
			curr = curr.right;
		}
	}
}