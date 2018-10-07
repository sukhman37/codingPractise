package LinkedList;

class AlternatingSplit extends List {
	
	void alternativeSplit(Node source,Node aNode,Node bNode) {
		Node a = new Node(0);
		Node b = new Node(0);
		aNode.next = a;
		bNode.next = b;
		while(source != null){
			if(source != null ){
				a.next = source;
				source = source.next;
				a = a.next;
				a.next = null;
			} if( source != null ) {
				b.next = source;
				source = source.next;
				b = b.next;
				b.next = null;
			}
		}
		aNode = aNode.next.next;
		bNode = bNode.next.next;
		
	}
	
}

public class AlternatingSplit_32 {
	public static void main(String[] args) {
		AlternatingSplit as = new AlternatingSplit();
		as.input();
		Node a = new Node();
		Node b = new Node();
		as.alternativeSplit(as.head, a, b);
		as.traverse(a.next);
		System.out.println("///");
		as.traverse(b.next);
		
	}
}
