package Graph;

import java.util.Iterator;

public class DFS extends Graph{

	DFS(int vertex) {
		super(vertex);
	}
	
	/*
	 * Work for disconnected components
	 */
	public void DFSComponent() {
		boolean visited[] = new boolean[vertex];
		for(int i = 0 ; i < vertex;i++) {
				if(visited[i] == false)
					DFSearchUtil(i,visited);
		}
	}
	
	/*
	 * Not worked for disconnected components.
	 */
	public void DFSearch(int start){
		boolean visited[] = new boolean[vertex];
		DFSearchUtil(start, visited);
	}
	
	public void DFSearchUtil(int vertex, boolean visited[] ){
		visited[vertex] = true;
		System.out.print(vertex+" ");

		for(int data : adj[vertex]) {
			if(visited[data] == false){
				DFSearchUtil(data, visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		DFS dfs = new DFS(5);
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(2, 4);
		dfs.addEdge(1, 3);
		
//		dfs.addEdge(0, 1);
//		dfs.addEdge(0, 2);
//		dfs.addEdge(1, 2);
//		dfs.addEdge(2, 0);
//		dfs.addEdge(2, 3);
//		dfs.addEdge(3, 3);
		
		//dfs.DFSearch(0);
		dfs.DFSComponent();
	}

}
