package Tree;

import java.util.Scanner;

public class Tree extends BinaryTree{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTree bt = new BinaryTree();
		while(true){
			int a = sc.nextInt();
			if( a == -1 )
				break;
			bt.insert(a);
		}
		bt.traverse(bt.root);
		System.out.println(bt.maxDepth(bt.root));
		sc.close();
	}
}
