package Tree;

/* Traverse tree without stack and recursion
 * 
 * https://www.youtube.com/watch?v=wGXB9OWhPTg */

public class MorrisTraversal extends BinaryTree{

	void inorder(Node node) {
		
		if(node == null)
			return;
		
		// Current point to root of the tree
		Node current = node;
		
		// Loop till current is empty
		while( current != null ){
			
			//left is null then print the node and go to right 
			if( current.left == null ) {
				System.out.println(current.data+" ");
				current = current.right;
			} else {
				
				//find predecessor
				Node predecessor = current.left;
				
				//keep going right till right node is not null or right node is not pointing to null.
				while( predecessor.right != null && predecessor.right != current )
					predecessor = predecessor.right;
				
				//if right node is null then establishing link from predecessor right to current and move current to current left
				if( predecessor.right == null ){
					predecessor.right = current;
					current = current.left;
				} else { // if left is already visited then remove the link, print the data and move right
					predecessor.right = null;
					System.out.println(current.data);
					current = current.right;
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		MorrisTraversal mt = new MorrisTraversal();
		mt.input();
		mt.inorder(mt.root);

	}

}
