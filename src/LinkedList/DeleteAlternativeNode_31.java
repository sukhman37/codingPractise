package LinkedList;
import java.util.*;

class DeleteAlternativeNode extends List{
	void deleteNode(){
		Node temp = head;
		while(temp != null && temp.next!=null ) {
			temp.next = temp.next.next;
			temp = temp.next;
		}
	}
	
	void deleteNodeR(Node node){
		if( node == null )
			return;
		if(node.next == null)
			return;
		node.next = node.next.next;
		deleteNodeR(node.next);
	}
	
}

public class DeleteAlternativeNode_31 {
	public static void main(String arg[]){

		DeleteAlternativeNode deleteAlternativeNode = new DeleteAlternativeNode();
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		for(int i = 0 ;i < n; i++){
			deleteAlternativeNode.insertFirst(input.nextInt());
		}
		deleteAlternativeNode.display();
		deleteAlternativeNode.deleteNodeR(deleteAlternativeNode.head);
		deleteAlternativeNode.display();
	}
}
