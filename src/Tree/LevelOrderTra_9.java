package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTra_9 extends BinaryTree{
	
	/******  Level Order traversal  ***********/
	
	void printLevelOrder(){
		int size = maxDepth(root);
		for(int i = 1; i <= size; i++){
			printGivenLevel(root, i);
		}
	}
	
	void printGivenLevel(Node node, int level){
		if(node == null)
			return;
		if(level == 1)
			System.out.print(node.data+" ");
		else{
			printGivenLevel(node.left, level-1);
			printGivenLevel(node.right, level-1);
		}
			
	}
	
	
	/******  Level Order traversal using Queue ***********/
	
	void printLevelQueue() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while( !queue.isEmpty() ){
			Node node = queue.poll();
			System.out.print(node.data);
			
			if( node.left != null ){
				queue.add(node.left);
			} 
			if( node.right != null ){
				queue.add(node.right);
			}
		}
	}
	
	/******  Level Order traversal using Queue by line by line ***********/
	void printLevelQueueByLine() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(true){
			int count = queue.size();
			if( count == 0)
				break;
			while( count != 0 ){
				Node node = queue.poll();
				System.out.print(node.data+" ");

				if( node.left != null ){
					queue.add(node.left);
				} 
				if( node.right != null ){
					queue.add(node.right);
				}
				count--;
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		LevelOrderTra_9 lv = new LevelOrderTra_9();
		lv.input();
		lv.printLevelQueueByLine();
	}
	
}
