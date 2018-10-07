package LinkedList;

import java.util.HashMap;

class rNode{
	int data;
	rNode next;
	rNode random;
	rNode(){}
	rNode(int data) {
		this(data, null,null);
	}
	
	rNode(int data, rNode next,rNode random) {
		this.data = data;
		this.next = next;
		this.random = random;
	}
}


public class LinkedListClone{
	 public static rNode cloneList(rNode node){
		 HashMap<rNode,rNode> map = new HashMap<>();
		 rNode store = node;
		 while(store != null){
			 map.put(store, new rNode(store.data)); // Store new node in hashmap with every original node
			 store = store.next;
		 }
		 store = node;
		 while(store != null){
			 map.get(store).next = map.get(store.next); // Make new node next link same as original node next store in new hashmap
			 map.get(store).random = map.get(store.random); // // Make new node random link same as original node random store in new hashmap
			 store = store.next;
		 }
		 return map.get(node);
	 }
	
	public static void main(String[] args) {
		rNode list4 = new rNode(4);
		rNode list3 = new rNode(3);
		rNode list2 = new rNode(2);
		rNode list1 = new rNode(1);
		
		list1.next = list2;
		list1.random = list3;
		list2.next = list3;
		list3.next = list4;
		list3.random = list2;
		
		rNode node =  cloneList(list1);
		while(node != null){
			System.out.println("data "+ node.data);
			if(node.next != null)
				System.out.println("next "+ node.next.data);
			else
				System.out.println("next is null");
			if(node.random != null)
				System.out.println("random "+ node.random.data);
			else
				System.out.println("random is null");
			node = node.next;
		}
	}
}
