
package Tree;

public class SumTree extends BinaryTree{
	static boolean sumTree(Node node){
		if(node == null || (node.left == null && node.right == null))
			return true;
		boolean isSum = sumTree(node.left) && sumTree(node.right);
		if(isSum == false)
			return false;
		int leftSum = 0, rightSum = 0;
		if(node.left != null) {
			if(node.left.left == null && node.left.right == null)
				leftSum = node.left.data;
			else
				leftSum = 2 * node.left.data;
		}
		if(node.right != null) {
			if(node.right.left == null && node.right.right == null)
				rightSum = node.right.data;
			else
				rightSum = 2 * node.right.data;
		}
			
		if(leftSum + rightSum == node.data){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SumTree sumTree = new SumTree();
		//sumTree.input();
		Node node1 = new Node(4);
		Node node2 = new Node(6);
		Node node3 = new Node(10,node1,node2);
		Node node4 = new Node(9);
		Node node5 = new Node(3,null,node4);
		Node node6 = new Node(26,node3,node5);
		sumTree.root = node6;
		
		sumTree.traverse(sumTree.root);
		System.out.println(sumTree(sumTree.root));
	}
}
