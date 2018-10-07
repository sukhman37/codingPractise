package LinkedList;

public class ReverseListByRecs extends List{
	
	public Node reverse(Node node){
		if(node.next == null)
			return node;
		
		Node node_head = reverse(head.next);
		node.next.next = head;
		
		node.next = null; //Null on last node
		return node_head; // return head of the node
	}
	
	
	public static void main(String[] args) {
		ReverseListByRecs rev = new ReverseListByRecs();
		rev.input();
		rev.traverse(rev.reverse(rev.head));
		
	}

}
