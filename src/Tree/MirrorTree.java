package Tree;

public class MirrorTree extends BinaryTree{
	Node mirror(Node node){
		
		if(node == null)
			return node;
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		node.left = right;
		node.right = left;
		
		return node;
	}
	public static void main(String[] args) {
		MirrorTree mt = new MirrorTree();
		mt.input();
		mt.traverse(mt.mirror(mt.root));
	}
}
