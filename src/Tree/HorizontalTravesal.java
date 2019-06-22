package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HorizontalTravesal extends BinaryTree{
	static Map<Integer,List<Node>>  horizontalNodes= new HashMap<>();
	
	static void builtHorizontalTravesal(Node root, int HD) {
		if(root != null) {
			if(!horizontalNodes.containsKey(HD))
				horizontalNodes.put(HD, new ArrayList<>());
			horizontalNodes.get(HD).add(root);
			builtHorizontalTravesal(root.left,HD-1);
			builtHorizontalTravesal(root.right,HD+1);
		}
	}
	
	static void printHorizontalTravesal(){
		for(Map.Entry<Integer,List<Node>> entry : horizontalNodes.entrySet()) {
			int HD = entry.getKey();
			System.out.println("Horizontal Distance = "+HD);
			for(Node node: entry.getValue()) {
				System.out.print(node.data+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HorizontalTravesal travesal = new HorizontalTravesal();
		travesal.input();
		builtHorizontalTravesal(travesal.root,0);
		printHorizontalTravesal();
		sc.close();
	}

}
