package Tree;

public class RemoveBSTOutSideRange extends BinaryTree{
	
	public Node removeOutSideRange(Node root,int min, int max){
		if(root == null)
			return null;
		
		root.left = removeOutSideRange(root.left, min, max);
		root.right = removeOutSideRange(root.right, min, max);
		
		if(root.data < min) {
			return root.right;
		}else if(root.data > max) {
			return root.left;
		}else {
			return root;
		}
		
	}
	
	public static void main(String[] args) {
		RemoveBSTOutSideRange tree = new RemoveBSTOutSideRange();
		tree.input();
		tree.removeOutSideRange(tree.root, -10, 13);
		tree.traverse(tree.root);
	}
}
