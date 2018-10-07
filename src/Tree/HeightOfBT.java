package Tree;

public class HeightOfBT extends BinaryTree{
	
	int countNode( Node head ){ 
		if(head == null)
			return -1;
		int lDepth = countNode(head.left);
		int rDepth = countNode(head.right);
		if( lDepth > rDepth )
			return lDepth++;
		else
			return rDepth++;
	}
	
	public static void main(String[] args) {
		HeightOfBT bt = new HeightOfBT();
		bt.input();
		System.out.println(bt.maxDepth(bt.root));
	}
}
