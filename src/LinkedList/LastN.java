package LinkedList;

public class LastN extends List{
	
	
	public static void main(String[] args) {
		
		LastN n = new LastN();
		int x = 3;
		n.input();
		Node node = n.head;
		Node fast = n.head;
		for(int i = 0 ; i < x; i++){
			fast = fast.next;
		}
		while(fast!=null){
			node = node.next;
			fast = fast.next;
		}
		System.out.println(node.data);
		
	}
}
