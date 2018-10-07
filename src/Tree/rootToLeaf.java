package Tree;

public class rootToLeaf extends BinaryTree {
	static void rootToLeafPath(Node node, int path[], int pathlen) {
		if (node == null)
			return;
		path[pathlen] = node.data;
		pathlen++;
		if (node.left == null && node.right == null)
			printArr(path, pathlen);
		else {
			rootToLeafPath(node.left, path, pathlen);
			rootToLeafPath(node.right, path, pathlen);
		}
	}

	static void printArr(int path[], int pathlen) {
		for (int i = 0; i < pathlen; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		rootToLeaf rtf = new rootToLeaf();
		rtf.input();
		int path[] = new int[1000];
		int pathlen = 0;
		rootToLeafPath(rtf.root, path, pathlen);
	}
}
