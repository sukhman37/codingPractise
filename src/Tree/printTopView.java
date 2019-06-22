package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class printTopView extends BinaryTree{
	
	static void printTopViews(Node root) {
		Queue<QueueNode> queue = new LinkedList<>();
		Map<Integer,QueueNode> hashmap = new HashMap<>();
		if(root == null)
			return;
		else
			queue.add(new QueueNode(root,0));
		while(!queue.isEmpty()) {
			QueueNode tmpNode = queue.poll();
			
			if(!hashmap.containsKey(tmpNode.HD)){
				hashmap.put(tmpNode.HD, tmpNode);
			}
			if(tmpNode.node.left!=null) {
				queue.add(new QueueNode(tmpNode.node.left,tmpNode.HD-1));
			}
			if(tmpNode.node.right!=null) {
				queue.add(new QueueNode(tmpNode.node.right,tmpNode.HD+1));
			}
		}
		for(Map.Entry<Integer, QueueNode> entry : hashmap.entrySet()) {
			System.out.print(entry.getValue().node.data+" ");
		}
		
	}
	
	public static void main(String[] args) {
		printTopView top = new printTopView();
		top.input();
		System.out.println("input complete");
		printTopView.printTopViews(top.root);
	}

}
class QueueNode{
	Node node;
	int HD;
	public QueueNode(Node node, int hD) {
		super();
		this.node = node;
		HD = hD;
	}
	
}
