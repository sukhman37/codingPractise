package Graph;

public class Connected_Undirected {
	public static void main(String[] args) {
		DFS dfs = new DFS(5);
		dfs.addEdge(0, 1);
		dfs.addEdge(1, 0);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 1);
		dfs.addEdge(3, 4);
		dfs.addEdge(4, 3);
		boolean visited[] = new boolean[5];
		for (int i = 0; i < 5; i++) {
			if (visited[i] == false) {
				dfs.DFSearchUtil(i, visited);
				System.out.println();
			}
		}

	}

}
